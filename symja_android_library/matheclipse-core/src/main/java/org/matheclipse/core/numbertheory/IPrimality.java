package org.matheclipse.core.numbertheory;


import de.tilman_neumann.util.SortedMultiset;
import java.math.BigInteger;
import java.util.SortedMap;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IInteger;

public interface IPrimality {
  public void factorInteger(BigInteger n, SortedMultiset<BigInteger> sortedMap);

  public SortedMap<BigInteger, Integer> factorInteger(BigInteger n);

  public IAST factorIInteger(IInteger b) ;
}
