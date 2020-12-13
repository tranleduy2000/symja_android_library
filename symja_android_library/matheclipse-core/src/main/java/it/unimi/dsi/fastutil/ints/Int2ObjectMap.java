/* Generic definitions */




/* Assertions (useful to generate conditional code) */
/* Current type and class (and size, if applicable) */
/* Value methods */
/* Interfaces (keys) */
/* Interfaces (values) */
/* Abstract implementations (keys) */
/* Abstract implementations (values) */
/* Static containers (keys) */
/* Static containers (values) */
/* Implementations */
/* Synchronized wrappers */
/* Unmodifiable wrappers */
/* Other wrappers */
/* Methods (keys) */
/* Methods (values) */
/* Methods (keys/values) */
/* Methods that have special names depending on keys (but the special names depend on values) */
/* Equality */
/* Object/Reference-only definitions (keys) */
/* Primitive-type-only definitions (keys) */
/* Object/Reference-only definitions (values) */
/*
 * Copyright (C) 2002-2013 Sebastiano Vigna
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.unimi.dsi.fastutil.ints;


public interface Int2ObjectMap<V> {

  public static class Entry<V extends Comparable<V>>
      implements Comparable<Entry<V>> {

    private final int key;
    private final V value;

    public Entry(int key, V value) {
      this.key = key;
      this.value = value;
    }


    public V getValue() {
      return value;
    }

    public int getKey() {
      return key;
    }

    public int getIntKey() {
      return key;
    }

    @Override
    public int compareTo(Entry<V> another) {
      return this.value.compareTo(another.value);
    }
  }
}