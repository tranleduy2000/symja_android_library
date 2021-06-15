package com.baeldung.algorithms.romannumerals;

import com.duy.lambda.ToIntFunction;
import com.duy.stream.Collectors;
import com.duy.stream.StreamWrapper;
import com.duy.util.Comparator;
import java.util.Arrays;
import java.util.List;

enum RomanNumeral {
  I(1), IV(4), V(5), IX(9), X(10),
  XL(40), L(50), XC(90), C(100),
  CD(400), D(500), CM(900), M(1000);

  private int value;

  RomanNumeral(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static List<RomanNumeral> getReverseSortedValues() {
    return StreamWrapper.stream(values())
        .sorted(Comparator.reserveComparing(new ToIntFunction<RomanNumeral>() {
          @Override
          public int applyAsInt(RomanNumeral e) {
            return e.value;
          }
        })).toList();
  }
}