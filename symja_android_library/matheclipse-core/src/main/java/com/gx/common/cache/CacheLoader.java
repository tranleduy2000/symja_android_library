/*
 * Copyright (C) 2011 The Guava Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gx.common.cache;

import com.gx.common.annotations.GwtCompatible;
import com.gx.common.annotations.GwtIncompatible;
import com.gx.common.base.Function;
import com.gx.common.base.Supplier;
import com.gx.common.util.concurrent.Futures;
import com.gx.common.util.concurrent.ListenableFuture;

import java.io.Serializable;
import java.util.Map;

import static com.gx.common.base.Preconditions.checkNotNull;

/**
 * Computes or retrieves values, based on a key, for use in populating a {@link LoadingCache}.
 * <p>
 * <p>Most implementations will only need to implement {@link #load}. Other methods may be
 * overridden as desired.
 * <p>
 * <p>Usage example:
 * <p>
 * <pre>{@code
 * CacheLoader<Key, Graph> loader = new CacheLoader<Key, Graph>() {
 *   public Graph load(Key key) throws AnyException {
 *     return createExpensiveGraph(key);
 *   }
 * };
 * LoadingCache<Key, Graph> cache = CacheBuilder.newBuilder().build(loader);
 * }</pre>
 * <p>
 * <p>Since this example doesn't support reloading or bulk loading, if you're able to use lambda
 * expressions it can be specified even more easily:
 * <p>
 * <pre>{@code
 * CacheLoader<Key, Graph> loader = CacheLoader.from(key -> createExpensiveGraph(key));
 * }</pre>
 *
 * @author Charles Fry
 * @since 10.0
 */
@GwtCompatible(emulated = true)
public abstract class CacheLoader<K, V> {
    /**
     * Constructor for use by subclasses.
     */
    protected CacheLoader() {
    }

    /**
     * Returns a cache loader that uses {@code function} to load keys, and without supporting either
     * reloading or bulk loading. This is most useful when you can pass a lambda expression. Otherwise
     * it is useful mostly when you already have an existing function instance.
     *
     * @param function the function to be used for loading values; must never return {@code null}
     * @return a cache loader that loads values by passing each key to {@code function}
     */
    public static <K, V> CacheLoader<K, V> from(Function<K, V> function) {
        return new FunctionToCacheLoader<>(function);
    }

    /**
     * Computes or retrieves the value corresponding to {@code key}.
     *
     * @param key the non-null key whose value should be loaded
     * @return the value associated with {@code key}; <b>must not be null</b>
     * @throws Exception            if unable to load the result
     * @throws InterruptedException if this method is interrupted. {@code InterruptedException} is
     *                              treated like any other {@code Exception} in all respects except that, when it is caught,
     *                              the thread's interrupt status is set
     */
    public abstract V load(K key) throws Exception;

    /**
     * Computes or retrieves a replacement value corresponding to an already-cached {@code key}. This
     * method is called when an existing cache entry is refreshed by {@link
     * CacheBuilder#refreshAfterWrite}, or through a call to {@link LoadingCache#refresh}.
     * <p>
     * <p>This implementation synchronously delegates to {@link #load}. It is recommended that it be
     * overridden with an asynchronous implementation when using {@link
     * CacheBuilder#refreshAfterWrite}.
     * <p>
     * <p><b>Note:</b> <i>all exceptions thrown by this method will be logged and then swallowed</i>.
     *
     * @param key      the non-null key whose value should be loaded
     * @param oldValue the non-null old value corresponding to {@code key}
     * @return the future new value associated with {@code key}; <b>must not be null, must not return
     * null</b>
     * @throws Exception            if unable to reload the result
     * @throws InterruptedException if this method is interrupted. {@code InterruptedException} is
     *                              treated like any other {@code Exception} in all respects except that, when it is caught,
     *                              the thread's interrupt status is set
     * @since 11.0
     */
    @GwtIncompatible // Futures
    public ListenableFuture<V> reload(K key, V oldValue) throws Exception {
        checkNotNull(key);
        checkNotNull(oldValue);
        return Futures.immediateFuture(load(key));
    }

    /**
     * Computes or retrieves the values corresponding to {@code keys}. This method is called by {@link
     * LoadingCache#getAll}.
     * <p>
     * <p>If the returned map doesn't contain all requested {@code keys} then the entries it does
     * contain will be cached, but {@code getAll} will throw an exception. If the returned map
     * contains extra keys not present in {@code keys} then all returned entries will be cached, but
     * only the entries for {@code keys} will be returned from {@code getAll}.
     * <p>
     * <p>This method should be overridden when bulk retrieval is significantly more efficient than
     * many individual lookups. Note that {@link LoadingCache#getAll} will defer to individual calls
     * to {@link LoadingCache#get} if this method is not overridden.
     *
     * @param keys the unique, non-null keys whose values should be loaded
     * @return a map from each key in {@code keys} to the value associated with that key; <b>may not
     * contain null values</b>
     * @throws Exception            if unable to load the result
     * @throws InterruptedException if this method is interrupted. {@code InterruptedException} is
     *                              treated like any other {@code Exception} in all respects except that, when it is caught,
     *                              the thread's interrupt status is set
     * @since 11.0
     */
    public Map<K, V> loadAll(Iterable<? extends K> keys) throws Exception {
        // This will be caught by getAll(), causing it to fall back to multiple calls to
        // LoadingCache.get
        throw new UnsupportedLoadingOperationException();
    }

    private static final class FunctionToCacheLoader<K, V> extends CacheLoader<K, V>
            implements Serializable {
        private static final long serialVersionUID = 0;
        private final Function<K, V> computingFunction;

        public FunctionToCacheLoader(Function<K, V> computingFunction) {
            this.computingFunction = checkNotNull(computingFunction);
        }

        @Override
        public V load(K key) {
            return computingFunction.apply(checkNotNull(key));
        }
    }

    private static final class SupplierToCacheLoader<V> extends CacheLoader<Object, V>
            implements Serializable {
        private static final long serialVersionUID = 0;
        private final Supplier<V> computingSupplier;

        public SupplierToCacheLoader(Supplier<V> computingSupplier) {
            this.computingSupplier = checkNotNull(computingSupplier);
        }

        @Override
        public V load(Object key) {
            checkNotNull(key);
            return computingSupplier.get();
        }
    }

    /**
     * Exception thrown by {@code loadAll()} to indicate that it is not supported.
     *
     * @since 19.0
     */
    public static final class UnsupportedLoadingOperationException
            extends UnsupportedOperationException {
        // Package-private because this should only be thrown by loadAll() when it is not overridden.
        // Cache implementors may want to catch it but should not need to be able to throw it.
        UnsupportedLoadingOperationException() {
        }
    }

    /**
     * Thrown to indicate that an invalid response was returned from a call to {@link CacheLoader}.
     *
     * @since 11.0
     */
    public static final class InvalidCacheLoadException extends RuntimeException {
        public InvalidCacheLoadException(String message) {
            super(message);
        }
    }
}
