package org.matheclipse.core.interfaces;

import com.duy.lang.FunctionalInterface;

@FunctionalInterface
public interface IDimensionFunction<T> {

  T apply(int[] index);
}
