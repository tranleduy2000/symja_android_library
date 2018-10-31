/*
 * Copyright (C) 2012 The Guava Authors
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

package com.gx.common.io;

import com.gx.common.annotations.GwtIncompatible;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;

import static com.gx.common.base.Preconditions.checkNotNull;

/**
 * A destination to which characters can be written, such as a text file. Unlike a {@link Writer}, a
 * {@code CharSink} is not an open, stateful stream that can be written to and closed. Instead, it
 * is an immutable <i>supplier</i> of {@code Writer} instances.
 * <p>
 * <p>{@code CharSink} provides two kinds of methods:
 * <p>
 * <ul>
 * <li><b>Methods that return a writer:</b> These methods should return a <i>new</i>, independent
 * instance each time they are called. The caller is responsible for ensuring that the
 * returned writer is closed.
 * <li><b>Convenience methods:</b> These are implementations of common operations that are
 * typically implemented by opening a writer using one of the methods in the first category,
 * doing something and finally closing the writer that was opened.
 * </ul>
 * <p>
 * <p>Any {@link ByteSink} may be viewed as a {@code CharSink} with a specific {@linkplain Charset
 * character encoding} using {@link ByteSink#asCharSink(Charset)}. Characters written to the
 * resulting {@code CharSink} will written to the {@code ByteSink} as encoded bytes.
 *
 * @author Colin Decker
 * @since 14.0
 */
@GwtIncompatible
public abstract class CharSink {

    /**
     * Constructor for use by subclasses.
     */
    protected CharSink() {
    }

    /**
     * Opens a new {@link Writer} for writing to this sink. This method returns a new, independent
     * writer each time it is called.
     * <p>
     * <p>The caller is responsible for ensuring that the returned writer is closed.
     *
     * @throws IOException if an I/O error occurs while opening the writer
     */
    public abstract Writer openStream() throws IOException;

    /**
     * Writes the given character sequence to this sink.
     *
     * @throws IOException if an I/O error while writing to this sink
     */
    public void write(CharSequence charSequence) throws IOException {
        checkNotNull(charSequence);

        Closer closer = Closer.create();
        try {
            Writer out = closer.register(openStream());
            out.append(charSequence);
            out.flush(); // https://code.google.com/p/guava-libraries/issues/detail?id=1330
        } catch (Throwable e) {
            throw closer.rethrow(e);
        } finally {
            closer.close();
        }
    }

}
