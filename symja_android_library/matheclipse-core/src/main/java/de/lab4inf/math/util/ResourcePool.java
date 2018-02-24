 
   /*
    * Project: Lab4Math
    *
    * Copyright (c) 2008-2013,  Prof. Dr. Nikolaus Wulff
    * University of Applied Sciences, Muenster, Germany
    * Lab for computer sciences (Lab4Inf).
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
   *
   */
  package de.lab4inf.math.util;
  
  import java.util.ArrayList;
  import java.util.Collection;
  
  /**
   * A blocking resource pool of generic type T.
   *
   * @author nwulff
   * @since  14.02.2013
   * @version $Id: ResourcePool.java,v 1.3 2014/09/17 18:02:01 nwulff Exp $
   * @param <T> type of resources
   */
  public class ResourcePool<T> {
      private volatile ArrayList<T> resources;
      /**
       * Constructor using the given objects.
       * @param res Objects of type T
       */
      public ResourcePool(final T... res) {
          resources = new ArrayList<T>();
          for (int i = 0; i < res.length; i++) {
              resources.add(res[i]);
          }
      }
      /**
       * Constructor using the objects given within
       * the collection.
       * @param res Collection with objects of type T
       */
      public ResourcePool(final Collection<T> res) {
          resources = new ArrayList<T>();
          for (T r : res) {
              resources.add(r);
          }
      }
      /**
       * Release a resource to the pool, starting blocked requests.
       * @param resource to release
       */
      public synchronized void release(final T resource) {
          resources.add(resource);
          notifyAll();
      }
      /**
       * Require a resource, block if none is available.
       * @return a free resource
       */
      public synchronized T require() {
          try {
              while (resources.size() == 0) {
                  wait();
              }
          } catch (InterruptedException e) {
              Thread.interrupted();
              //e.printStackTrace();
              throw new RuntimeException(e);
          }
          T res = resources.remove(0);
          return res;
      }
      /**
       * Actual number of free resources.
       * @return free resources size
       */
      public synchronized int size() {
          return resources.size();
      }
  
  }
 