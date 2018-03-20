package org.matheclipse.core.expression;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.HashMap;
import java.util.RandomAccess;
import java.util.Set;
import com.duy.lambda.DoubleUnaryOperator;
import com.duy.lambda.Function;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IExpr;

public class ASTSeriesData extends AST implements Cloneable, Externalizable, RandomAccess {

	/**
	 * 
	 * Returns a new ASTPowerSeries where each element is mapped by the given function.
	 *
	 * @param astVector
	 *            an AST which could be converted into <code>double[]</code>
	 * @param function
	 *            Function to apply to each entry.
	 * @return a new vector.
	 */
	public static ASTSeriesData map(final IAST astVector, DoubleUnaryOperator function) {
		HashMap<Integer, IExpr> vector = new HashMap<Integer, IExpr>();
		ASTSeriesData series = new ASTSeriesData(vector, false);
		for (int i = 1; i < astVector.size(); i++) {
			vector.put(i, astVector.get(i));
		}
		return series;
	}

	/**
	 * The underlying matrix
	 */
	// private Function<Integer, IExpr> f;

	// private HashMap<Integer, IExpr> vals;
	// -1 => undetermined
	private int power = -1;
	private IExpr x;

	private IExpr x0;

	private int nMin;

	private int nMax;

	private int denominator;

	/**
	 * 
	 * @param vals
	 * @param deepCopy
	 */
	// public ASTPowerSeries(double[] vector, boolean deepCopy) {
	// this.vector = new ArrayRealVector(vector, deepCopy);
	// }

	IExpr ring;

	public ASTSeriesData() {
		super(F.SeriesData);
		// When Externalizable objects are deserialized, they first need to be constructed by invoking the void
		// constructor. Since this class does not have one, serialization and deserialization will fail at runtime.
	}

	// public ASTSeriesData(Function<Integer, IExpr> f, HashMap<Integer, IExpr> map, IExpr ring) {
	// super(F.SeriesData);
	// this.f = f;
	// // this.vals = map;
	// this.ring = ring;
	// }

	// public ASTSeriesData(Function<Integer, IExpr> f, HashMap<Integer, IExpr> map, int order, IExpr ring) {
	// super(F.SeriesData);
	// this.power = order;
	// this.f = f;
	// // this.vals = map;
	// this.ring = ring;
	// }

	// public ASTSeriesData(Function<Integer, IExpr> f, IExpr ring) {
	// super(F.SeriesData);
	// this.f = f;
	// // this.vals = new HashMap<Integer, IExpr>();
	// this.ring = ring;
	// }

	// public ASTSeriesData(Function<Integer, IExpr> f, int order, IExpr ring) {
	// super(F.SeriesData);
	// this.power = order;
	// this.f = f;
	// // this.vals = new HashMap<Integer, IExpr>();
	// this.ring = ring;
	// }

	/**
	 * 
	 * 
	 * @param vector
	 *            the vector which should be wrapped in this object.
	 * @param deepCopy
	 *            TODO
	 */
	public ASTSeriesData(HashMap<Integer, IExpr> vector, boolean deepCopy) {
		super(F.SeriesData);
		// if (deepCopy) {
		// this.vals = (HashMap<Integer, IExpr>) vector.clone();
		// } else {
		// this.vals = vector;
		// }
	}

	public ASTSeriesData(IExpr x, IExpr x0, int nMin, int nMax, int denominator) {
		super(F.SeriesData);
		this.x = x;
		this.x0 = x0;
		this.nMin = nMin;
		this.nMax = nMax;
		this.denominator = denominator;
	}

	/**
	 * Inserts the specified object into this {@code ArrayList} at the specified location. The object is inserted before
	 * any previous element at the specified location. If the location is equal to the size of this {@code ArrayList},
	 * the object is added at the end.
	 * 
	 * @param location
	 *            the index at which to insert the object.
	 * @param object
	 *            the object to add.
	 * @throws IndexOutOfBoundsException
	 *             when {@code location < 0 || > size()}
	 */
	// @Override
	// public void append(int location, IExpr object) {
	// hashValue = 0;
	// throw new UnsupportedOperationException();
	// }

	@Override
	public Set<IExpr> asSet() {
		throw new UnsupportedOperationException();
		// empty set:
		// return new HashSet<IExpr>();
	}

	/**
	 * Returns a new {@code HMArrayList} with the same elements, the same size and the same capacity as this
	 * {@code HMArrayList}.
	 * 
	 * @return a shallow copy of this {@code ArrayList}
	 * @see java.lang.Cloneable
	 */
	@Override
	public IAST clone() {
		IASTAppendable series = new ASTSeriesData(x, x0, nMin, nMax, denominator);
		series.appendArgs(this);
		return series;
	}
	//
	// public ASTSeriesData composePS(ASTSeriesData b) {
	// int minSize = nMin;
	// if (nMin > b.nMin) {
	// minSize = b.nMin;
	// }
	// int maxSize = nMax;
	// if (nMax > b.nMax) {
	// maxSize = b.nMax;
	// }
	// int size = size();
	// ASTSeriesData series = new ASTSeriesData(x, x0, minSize, maxSize, denominator);
	// int j = 1;
	// IASTAppendable list = F.ListAlloc(size);
	// for (int i = 0; i < size - 1; i++) {
	// list.append(j++, this.getCoeff(minSize + i).plus(b.getCoeff(minSize + i)));
	// }
	// return series;
	// }

	@Override
	public int compareTo(final IExpr rhsExpr) {
		if (rhsExpr instanceof ASTSeriesData) {
			ASTSeriesData rhs = (ASTSeriesData) rhsExpr;
			int cp = x.compareTo(rhs.x);
			if (cp != 0) {
				return cp;
			}
			cp = x0.compareTo(rhs.x0);
			if (cp != 0) {
				return cp;
			}
			cp = nMax - rhs.nMax;
			if (cp != 0) {
				if (cp < 0) {
					return -1;
				}
				return 1;
			}
			cp = nMin - rhs.nMin;
			if (cp != 0) {
				if (cp < 0) {
					return -1;
				}
				return 1;
			}
			cp = denominator - rhs.denominator;
			if (cp != 0) {
				if (cp < 0) {
					return -1;
				}
				return 1;
			}
			return super.compareTo(rhsExpr);
		}
		int x = hierarchy();
		int y = rhsExpr.hierarchy();
		return (x < y) ? -1 : ((x == y) ? 0 : 1);
	}
	/** {@inheritDoc} */
	@Override
	public ASTSeriesData copy() {
		ASTSeriesData series = new ASTSeriesData(x, x0, nMin, nMax, denominator);
		series.appendArgs(this);
		return series;
	}

	@Override
	public IASTAppendable copyAppendable() {
		return null;// Convert.vector2List(vector);
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof ASTSeriesData) {
			if (obj == this) {
				return true;
			}
			ASTSeriesData that = (ASTSeriesData) obj;
			if (!x.equals(that.x)) {
				return false;
			}
			if (!x0.equals(that.x0)) {
				return false;
			}
			if (nMin != that.nMin) {
				return false;
			}
			if (denominator != that.denominator) {
				return false;
			}
			if (power != that.power) {
				return false;
			}
			if (super.equals(obj)) {
				return true;
			}
		}
		return false;
	}

	/** {@inheritDoc} */
	@Override
	public IExpr evaluate(EvalEngine engine) {
		return F.NIL;
	}

	/** {@inheritDoc} */
	@Override
	public String fullFormString() {
		StringBuilder buf = new StringBuilder();
		buf.append("SeriesData(");
		buf.append(x.toString());
		buf.append(',');
		buf.append(x0.toString());
		buf.append(',');

		// list of coefficients
		buf.append("{");
		final int listSize = size();
		if (listSize > 1) {
			buf.append(arg1().toString());
		}
		for (int i = 2; i < listSize; i++) {
			buf.append(",");
			buf.append(get(i).toString());
		}
		buf.append("}");

		buf.append(',');
		buf.append(nMin);
		buf.append(',');
		buf.append(nMax);
		buf.append(',');
		buf.append(denominator);
		buf.append(")");
		return buf.toString();
	}

	/**
	 * Get the coefficient for <code>(x-x0)^k</code>.
	 *
	 * @param k
	 * @return
	 */
	public IExpr coeff(int k) {
		// if (vals.containsKey(k))
		// return vals.get(k);
		// IExpr c = f.apply(k);
		// vals.put(k, c);
		if (k < nMin) {
			return F.C0;
		}
		int index = k - nMin + 1;
		if (index >= size()) {
			return F.C0;
		}

		return get(index);
	}

	public long getDenominator() {
		return denominator;
	}

	public long getNMax() {
		return nMax;
	}

	public long getNMin() {
		return nMin;
	}

	public Integer getOrder() {
		return power;
	}

	public IExpr getX() {
		return x;
	}

	public IExpr getX0() {
		return x0;
	}

	// @Override
	// public boolean appendAll(IAST ast, int startPosition, int endPosition) {
	// throw new UnsupportedOperationException();
	// }

	/**
	 * Inserts the objects in the specified collection at the specified location in this List. The objects are added in
	 * the order they are returned from the collection's iterator.
	 * 
	 * @param location
	 *            the index at which to insert.
	 * @param collection
	 *            the collection of objects.
	 * @return {@code true} if this {@code ArrayList} is modified, {@code false} otherwise.
	 * @throws IndexOutOfBoundsException
	 *             when {@code location < 0 || > size()}
	 */
	// @Override
	// public boolean appendAll(int location, Collection<? extends IExpr> collection) {
	// hashValue = 0;
	// throw new UnsupportedOperationException();
	// }

	// @Override
	// public boolean addAll(List<? extends IExpr> list) {
	// throw new UnsupportedOperationException();
	// }

	// @Override
	// public boolean appendAll(List<? extends IExpr> ast, int startPosition, int endPosition) {
	// throw new UnsupportedOperationException();
	// }

	// @Override
	// public boolean appendArgs(IAST ast) {
	// throw new UnsupportedOperationException();
	// }

	// @Override
	// public final boolean appendArgs(IAST ast, int untilPosition) {
	// throw new UnsupportedOperationException();
	// }

	// @Override
	// public IAST appendOneIdentity(IAST subAST) {
	// throw new UnsupportedOperationException();
	// }

	/**
	 * Adds the specified object at the end of this {@code ArrayList}.
	 * 
	 * @param object
	 *            the object to add.
	 * @return always true
	 */
	// @Override
	// public boolean append(IExpr object) {
	// hashValue = 0;
	// throw new UnsupportedOperationException();
	// }

	/** {@inheritDoc} */
	@Override
	public int hierarchy() {
		return SERIESID;
	}


	@Override
	public ASTSeriesData inverse() {
		if (!isInvertible()) {
			int coefficientLength = argSize();
			if (coefficientLength > 10) {
				return null;
			}
			if (coefficientLength > 1 && !this.coeff(1).isZero()) {

				ASTSeriesData ps = new ASTSeriesData(x, x0, nMin, nMax, denominator);
				ps.append(F.C0);

				IExpr a1 = coeff(1);
				// a1^(-1)
				ps.append(a1.inverse());
				if (coefficientLength > 2) {
					// -a1^(-3) * a2
					IExpr a2 = coeff(2);
					ps.append(a1.power(-3).times(a2).negate());
					if (coefficientLength > 3) {
						// a1^(-5) * (2*a2^2-a1*a3)
						IExpr a3 = coeff(3);
						ps.append(F.Times.of(F.Power(a1, -5), //
								F.Subtract(F.Times(F.C2, F.Sqr(a2)), F.Times(a1, a3))));
						if (coefficientLength > 4) {
							// a1^(-7) * (5*a1*a2*a3-a1*a4-5*a2^3)
							IExpr a4 = coeff(4);
							ps.append(F.Times.of(F.Power(a1, -7), //
									F.Plus(F.Times(F.CN5, F.Power(a2, 3)), F.Times(F.C5, a1, a2, a3),
											F.Times(F.CN1, a1, a4))));
							if (coefficientLength > 5) {
								// a1^(-9) * (6*a1^2*a2*a4+3*a1^2*a3^2+14*a2^4-a1^3*a5-21*a1*a2^2*a3)
								IExpr a5 = coeff(5);
								ps.append(F.Times.of(F.Power(a1, -9), //
										F.Plus(F.Times(F.ZZ(14L), F.Power(a2, 4)),
												F.Times(F.ZZ(-21L), a1, F.Sqr(a2), a3),
												F.Times(F.C3, F.Sqr(a1), F.Sqr(a3)), F.Times(F.C6, F.Sqr(a1), a2, a4),
												F.Times(F.CN1, F.Power(a1, 3), a5))));
								if (coefficientLength > 6) {
									// a1^(-11) *
									// (7*a1^3*a2*a5+7*a1^3*a3*a4+84*a1*a2^3*a3-a1^4*a6-28*a1^2*a2*a3^2-42*a2^5-28*a1^2*a2^2*a4)
									IExpr a6 = coeff(6);
									ps.append(F.Times.of(F.Power(a1, -11), //
											F.Plus(F.Times(F.ZZ(-42L), F.Power(a2, 5)),
													F.Times(F.ZZ(84L), a1, F.Power(a2, 3), a3),
													F.Times(F.ZZ(-28L), F.Sqr(a1), a2, F.Sqr(a3)),
													F.Times(F.ZZ(-28L), F.Sqr(a1), F.Sqr(a2), a4),
													F.Times(F.C7, F.Power(a1, 3), a3, a4),
													F.Times(F.C7, F.Power(a1, 3), a2, a5),
													F.Times(F.CN1, F.Power(a1, 4), a6))));
									if (coefficientLength > 7) {
										IExpr a7 = coeff(7);
										// (132*a2^6 - 330*a1*a2^4*a3 + 120*a1^2*a2^3*a4 - 36*a1^2*a2^2*(-5*a3^2 +
										// a1*a5) + 8*a1^3*a2*(-9*a3*a4 + a1*a6) + a1^3*(-12*a3^3 + 8*a1*a3*a5 +
										// a1*(4*a4^2 - a1*a7))) / a1^13
										ps.append(F.Times.of(F.Power(a1, -13),
												F.Plus(F.Times(F.ZZ(132L), F.Power(a2, 6)),
														F.Times(F.ZZ(-330L), a1, F.Power(a2, 4), a3),
														F.Times(F.ZZ(120L), F.Sqr(a1), F.Power(a2, 3), a4),
														F.Times(F.ZZ(-36L), F.Sqr(a1), F.Sqr(a2),
																F.Plus(F.Times(F.CN5, F.Sqr(a3)), F.Times(a1, a5))),
														F.Times(F.C8, F.Power(a1, 3), a2,
																F.Plus(F.Times(F.CN9, a3, a4), F.Times(a1, a6))),
														F.Times(F.Power(a1, 3),
																F.Plus(F.Times(F.ZZ(-12L), F.Power(a3, 3)),
																		F.Times(F.C8, a1, a3, a5),
																		F.Times(a1,
																				F.Plus(F.Times(F.C4, F.Sqr(a4)),
																						F.Times(F.CN1, a1, a7)))))),
												F.Power(a1, 13)));
										if (coefficientLength > 8) {
											// (-429*a2^7 + 1287*a1*a2^5*a3 - 495*a1^2*a2^4*a4 +
											// 165*a1^2*a2^3*(-6*a3^2
											// + a1*a5) - 45*a1^3*a2^2*(-11*a3*a4 + a1*a6) + 3*a1^3*a2*(55*a3^3 -
											// 30*a1*a3*a5 + 3*a1*(-5*a4^2 + a1*a7)) + a1^4*(-45*a3^2*a4 +
											// 9*a1*a3*a6 +
											// a1*(9*a4*a5 - a1*a8)))/a1^15
											IExpr a8 = coeff(8);
											ps.append(F.Times.of(F.Power(a1, -15),
													F.Plus(F.Times(F.ZZ(-429L), F.Power(a2, 7)),
															F.Times(F.ZZ(1287L), a1, F.Power(a2, 5), a3),
															F.Times(F.ZZ(-495L), F.Sqr(a1), F.Power(a2, 4), a4),
															F.Times(F.ZZ(165L), F.Sqr(a1), F.Power(a2, 3),
																	F.Plus(F.Times(F.CN6, F.Sqr(a3)), F.Times(a1, a5))),
															F.Times(F.ZZ(-45L), F.Power(a1, 3), F.Sqr(a2),
																	F.Plus(F.Times(F.ZZ(-11L), a3, a4),
																			F.Times(a1, a6))),
															F.Times(F.C3, F.Power(a1, 3), a2,
																	F.Plus(F.Times(F.ZZ(55L), F.Power(a3, 3)),
																			F.Times(F.ZZ(-30L), a1, a3, a5),
																			F.Times(F.C3, a1,
																					F.Plus(F.Times(F.CN5, F.Sqr(a4)),
																							F.Times(a1, a7))))),
															F.Times(F.Power(a1, 4),
																	F.Plus(F.Times(F.ZZ(-45L), F.Sqr(a3), a4),
																			F.Times(F.C9, a1, a3, a6),
																			F.Times(a1, F.Plus(F.Times(F.C9, a4, a5),
																					F.Times(F.CN1, a1, a8))))))));
											if (coefficientLength > 9) {
												// (1430*a2^8 - 5005*a1*a2^6*a3 + 2002*a1^2*a2^5*a4 -
												// 715*a1^2*a2^4*(-7*a3^2 + a1*a5) + 220*a1^3*a2^3*(-13*a3*a4 +
												// a1*a6) -
												// 55*a1^3*a2^2*(26*a3^3 - 12*a1*a3*a5 + a1*(-6*a4^2 + a1*a7)) +
												// 10*a1^4*a2*(66*a3^2*a4 - 11*a1*a3*a6 + a1*(-11*a4*a5 + a1*a8)) +
												// a1^4*(55*a3^4 - 55*a1*a3^2*a5 + 5*a1*a3*(-11*a4^2 + 2*a1*a7) +
												// a1^2*(5*a5^2 + 10*a4*a6 - a1*a9)))/a1^17
												IExpr a9 = coeff(9);
												ps.append(F.Times.of(F.Power(a1, -17),
														F.Plus(F.Times(F.ZZ(1430L), F.Power(a2, 8)),
																F.Times(F.ZZ(-5005L), a1, F.Power(a2, 6), a3),
																F.Times(F.ZZ(2002L), F.Sqr(a1), F.Power(a2, 5), a4),
																F.Times(F.ZZ(-715L), F.Sqr(a1), F.Power(a2, 4),
																		F.Plus(F.Times(F.CN7, F.Sqr(a3)),
																				F.Times(a1, a5))),
																F.Times(F.ZZ(220L), F.Power(a1, 3), F.Power(a2, 3),
																		F.Plus(F.Times(F.ZZ(-13L), a3, a4),
																				F.Times(a1, a6))),
																F.Times(F.ZZ(-55L), F.Power(a1, 3), F.Sqr(a2), F.Plus(
																		F.Times(F.ZZ(26L), F.Power(a3, 3)),
																		F.Times(F.ZZ(-12L), a1, a3, a5),
																		F.Times(a1,
																				F.Plus(F.Times(F.CN6, F.Sqr(a4)),
																						F.Times(a1, a7))))),
																F.Times(F.C10, F.Power(a1, 4), a2, F.Plus(
																		F.Times(F.ZZ(66L), F.Sqr(a3), a4),
																		F.Times(F.ZZ(-11L), a1, a3, a6),
																		F.Times(a1,
																				F.Plus(F.Times(F.ZZ(-11L), a4, a5),
																						F.Times(a1, a8))))),
																F.Times(F.Power(a1, 4), F.Plus(
																		F.Times(F.ZZ(55L), F.Power(a3, 4)),
																		F.Times(F.ZZ(-55L), a1, F.Sqr(a3), a5),
																		F.Times(F.C5, a1, a3,
																				F.Plus(F.Times(F.ZZ(-11L), F.Sqr(a4)),
																						F.Times(F.C2, a1, a7))),
																		F.Times(F.Sqr(a1),
																				F.Plus(F.Times(F.C5, F.Sqr(a5)),
																						F.Times(F.C10, a4, a6),
																						F.Times(F.CN1, a1, a9))))))));
											}
										}
									}
								}
							}
						}
					}
				}
				return ps;
			}
			throw new IllegalStateException("PowerSeries cannot be inverted");
		}
		IExpr d = this.coeff(0).power(-1L);
		// HashMap<Integer, IExpr> bTable = new HashMap<>();
		// bTable.put(0, a);
		ASTSeriesData ps = new ASTSeriesData(x, x0, nMin, nMax, denominator);
		ps.append(d);
		for (int i = 1; i < size(); i++) {
			IExpr c = F.C0;
			for (int k = 0; k < i; k++) {
				IExpr m = this.coeff(k).times(this.coeff(i - k));
				c = c.plus(m);
			}
			IExpr b = c.times(d.times(F.CN1));
			ps.append(b);
		}
		return ps;

		// C d = leadingCoefficient().inverse(); // may fail
		// if (i == 0) {
		// return d;
		// }
		// C c = null; //fac.getZERO();
		// for (int k = 0; k < i; k++) {
		// C m = get(k).multiply(coefficient(i - k));
		// if (c == null) {
		// c = m;
		// } else {
		// c = c.sum(m);
		// }
		// }
		// c = c.multiply(d.negate());
		// return c;

		// BiFunction<BiFunction, Integer, IExpr> g = (s, k) -> {
		// if (bTable.containsKey(k)) {
		// return bTable.get(k);
		// }
		// IExpr sum = F.C0;
		// for (Integer n = 0; n < k; n++) {
		// sum = sum.plus(this.getCoef(k - n).times((IExpr) s.apply(s, n)));
		// }
		// IExpr b = sum.times(a.times(F.CN1));
		// bTable.put(k, b);
		// return b;
		// };
		// Function<Integer, IExpr> h = k -> g.apply(g, k);
		// return new ASTPowerSeries(h, bTable, -power, ring);
	}

	/** {@inheritDoc} */
	@Override
	public boolean isAST0() {
		return false;
	}

	/** {@inheritDoc} */
	@Override
	public boolean isAST1() {
		return false;
	}

	/** {@inheritDoc} */
	@Override
	public boolean isAST2() {
		return false;
	}

	/** {@inheritDoc} */
	@Override
	public boolean isAST3() {
		return false;
	}

	public boolean isInvertible() {
		return size() > 1 && !coeff(0).isZero();
	}

	public boolean isProbableOne() {
		if (size() > 1) {
			if (!get(1).isOne()) {
				return false;
			}
			for (int i = 2; i < size(); i++) {
				if (!get(i).isZero()) {
					return false;
				}
			}
			// for (Map.Entry<Integer, IExpr> element : vals.entrySet()) {
			// Integer key = element.getKey();
			// if (key != 0) {
			// if (!getCoef(key).isZero()) {
			// return false;
			// }
			// }
			// }
			return true;
		}
		return false;
	}

	// @Override
	// public IExpr get(int location) {
	// IExpr val = vals.get(location);
	// return val;
	// }

	public boolean isProbableZero() {
		for (int i = 1; i < size(); i++) {
			if (!get(i).isZero()) {
				return false;
			}
		}
		// for (Map.Entry<Integer, IExpr> element : vals.entrySet()) {
		// if (!getCoef(element.getKey()).isZero()) {
		// return false;
		// }
		// }
		return true;
	}

	@Override
	public ASTSeriesData negate() {
		ASTSeriesData series = copy();
		for (int i = 1; i < size(); i++) {
			series.set(i, get(i).negate());
		}
		return series;
	}

	// @Override
	// public int hashCode() {
	// if (hashValue == 0) {
	// hashValue = vals.hashCode();
	// }
	// return hashValue;
	// }

	private void normalize() {
		int ord = order();
		if (ord == Integer.MIN_VALUE) {
			power = 0;
		} else {
			shift(-ord);
			power = power - ord;
		}
	}
	/**
	 * Adds the objects in the specified collection to this {@code ArrayList}.
	 * 
	 * @param collection
	 *            the collection of objects.
	 * @return {@code true} if this {@code ArrayList} is modified, {@code false} otherwise.
	 */
	// @Override
	// public boolean appendAll(Collection<? extends IExpr> collection) {
	// hashValue = 0;
	// throw new UnsupportedOperationException();
	// }

	/**
	 * Order of a power series
	 * 
	 * @return <code>Integer.MIN_VALUE</code> if power series <code>isProbableZero()</code> is true or the order of the
	 *         power series
	 */
	public int order() {
		for (int i = 0; i < size(); i++) {
			if (!get(i).isZero()) {
				return nMin + i;
			}
		}
		return Integer.MIN_VALUE;
	}

	/**
	 * Add two power series.
	 * 
	 * See <a href="https://en.wikipedia.org/wiki/Power_series#Addition_and_subtraction">Wikipedia: Power series -
	 * Addition and subtraction</a>
	 * 
	 * @param b
	 * @return
	 */
	public ASTSeriesData plusPS(ASTSeriesData b) {
		int minSize = nMin;
		if (nMin > b.nMin) {
			minSize = b.nMin;
		}
		int maxSize = nMax;
		if (nMax > b.nMax) {
			maxSize = b.nMax;
		}
		int size = size();
		if (size > b.size()) {
			size = b.size();
		}
		ASTSeriesData series = new ASTSeriesData(x, x0, minSize, maxSize, denominator);
		int j = 1;
		for (int i = 0; i < size - 1; i++) {
			series.append(j++, this.coeff(minSize + i).plus(b.coeff(minSize + i)));
		}
		return series;
	}

	public ASTSeriesData pow(final long n) {
		if ((n == 0L)) {
			ASTSeriesData series = new ASTSeriesData(x, x0, 0, 1, denominator);
			series.append(F.C1);
			return series;
		}

		if (n == 1L) {
			return this;
		}

		long exp = n;
		if (n < 0) {
			if (n == Long.MIN_VALUE) {
				throw new java.lang.ArithmeticException();
			}
			exp *= -1;
		}
		long b2pow = 0;

		while ((exp & 1) == 0L) {
			b2pow++;
			exp >>= 1;
		}

		ASTSeriesData r = this;
		ASTSeriesData x = r;

		while ((exp >>= 1) > 0L) {
			x = x.times(x);
			if ((exp & 1) != 0) {
				r = r.times(x);
			}
		}

		while (b2pow-- > 0L) {
			r = r.times(r);
		}
		if (n < 0) {
			return r.inverse();
		}
		return r;
	}

	@Override
	public ASTSeriesData plus(IExpr b) {
		if (b instanceof ASTSeriesData) {
			return plusPS((ASTSeriesData) b);
		}
		if (b.isZero()) {
			return this;
		}
		if (size() > 1) {
			IExpr value = F.eval(coeff(0).plus(b));
			if (value.isZero() && nMin > 0) {
				return this;
			}
		ASTSeriesData series = copy();
			if (nMin > 0) {
				series.shift(nMin);
				series.nMin = 0;
			}
			series.setCoeff(0, value);
			return series;
		} else {
			ASTSeriesData series = copy();
			series.append(b);
			series.nMin = 0;
		return series;
	}
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
		throw new UnsupportedOperationException();
		// this.fEvalFlags = objectInput.readShort();
		//
		// int size;
		// byte attributeFlags = objectInput.readByte();
		// if (attributeFlags != 0) {
		// size = attributeFlags;
		// int exprIDSize = objectInput.readByte();
		// for (int i = 0; i < exprIDSize; i++) {
		// set(i, F.GLOBAL_IDS[objectInput.readShort()]);
		// }
		// for (int i = exprIDSize; i < size; i++) {
		// set(i, (IExpr) objectInput.readObject());
		// }
		// return;
		// }
		//
		// size = objectInput.readInt();
		// for (int i = 0; i < size; i++) {
		// set(i, (IExpr) objectInput.readObject());
		// }
	}

	public void setCoeff(int k, IExpr value) {
		// if (vals.containsKey(k))
		// return vals.get(k);
		// IExpr c = f.apply(k);
		// vals.put(k, c);
		// if (k < nMin) {
		// if (value.isZero()) {
		// return;
		// }
		// shift(nMin - k);
		// }
		set(k + 1, value);
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	public void setNMax(int nMax) {
		this.nMax = nMax;
	}

	public void setNMin(int nMin) {
		this.nMin = nMin;
	}

	public void setX(IExpr x) {
		this.x = x;
	}

	public void setX0(IExpr x0) {
		this.x0 = x0;
	}

	/**
	 * Shifts the power series
	 * 
	 * @param s
	 *            an integer
	 * @return shifted series (to the right)
	 */
	private void shift(int s) {
		nMin -= s;
		ensureCapacity(size() + s);
		for (int i = 0; i < s; i++) {
			append(1, F.C0);
		}
	}

	/**
	 * Subtract two power series.
	 * 
	 * See <a href="https://en.wikipedia.org/wiki/Power_series#Addition_and_subtraction">Wikipedia: Power series -
	 * Addition and subtraction</a>
	 * 
	 * @param b
	 * @return
	 */
	public ASTSeriesData subtractPS(ASTSeriesData b) {
		int minSize = nMin;
		if (nMin > b.nMin) {
			minSize = b.nMin;
			}
		int maxSize = nMax;
		if (nMax > b.nMax) {
			maxSize = b.nMax;
		}
		int size = size();
		if (size > b.size()) {
			size = b.size();
		}
		ASTSeriesData series = new ASTSeriesData(x, x0, minSize, maxSize, denominator);
		int j = 1;
		for (int i = 0; i < size - 1; i++) {
			series.append(j++, this.coeff(minSize + i).subtract(b.coeff(minSize + i)));
		}
		return series;
	}

	@Override
	public ASTSeriesData subtract(IExpr b) {
		if (b instanceof ASTSeriesData) {
			return subtractPS((ASTSeriesData) b);
		}
		if (b.isZero()) {
			return this;
		}
		if (size() > 1) {
			IExpr value = F.eval(coeff(0).subtract(b));
			if (value.isZero() && nMin > 0) {
				return this;
			}
		ASTSeriesData series = copy();
			if (nMin > 0) {
				series.shift(nMin);
				series.nMin = 0;
			}
			series.setCoeff(0, value);
			return series;
		} else {
			ASTSeriesData series = copy();
			series.append(b);
			series.nMin = 0;
		return series;
	}
	}

	/**
	 * Multiply two power series.
	 * 
	 * See <a href="https://en.wikipedia.org/wiki/Power_series#Multiplication_and_division">Wikipedia: Power series -
	 * Multiplication and Division</a>
	 * 
	 * @param b
	 * @return
	 */
	public ASTSeriesData timesPS(ASTSeriesData b) {
		int minSize = nMin;
		if (nMin > b.nMin) {
			minSize = b.nMin;
		}
		int maxSize = nMax;
		if (nMax < b.nMax) {
			maxSize = b.nMax;
		}
		ASTSeriesData series = new ASTSeriesData(x, x0, nMin + b.nMin, maxSize + minSize, denominator);
		int size = series.nMax - series.nMin;
		for (int i = 0; i < size; i++) {
			series.append(F.C0);
		}
		for (int n = series.nMin; n < series.nMax; n++) {
			IASTAppendable sum = F.PlusAlloc(n + 1);
			for (int i = 0; i <= n; i++) {
				sum.append(this.coeff(i).times(b.coeff(n - i)));
			}
			IExpr value = F.eval(sum);
			if (value.isZero()) {
				continue;
			}
			series.setCoeff(n - series.nMin, value);
		}
		return series;
	}

	/**
	 * Multiply a power series with a scalar
	 */
	@Override
	public ASTSeriesData times(IExpr b) {
		if (b instanceof ASTSeriesData) {
			return timesPS((ASTSeriesData) b);
		}
		ASTSeriesData series = copy();
		for (int i = 1; i < size(); i++) {
			series.set(i, this.get(i).times(b));
		}
		return series;
	}

	// public ASTSeriesData map(BiFunction<Integer, IExpr, IExpr> f) {
	// ASTSeriesData series = copy();
	// for (int i = 1; i < size(); i++) {
	// series.set(i, f.apply(i+nMin-1, this.get(i)));
	// }
	// return series;
	// }
	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		throw new UnsupportedOperationException();
		// objectOutput.writeShort(fEvalFlags);
		//
		// int size = size();
		// byte attributeFlags = (byte) 0;
		//
		// ExprID temp = F.GLOBAL_IDS_MAP.get(head());
		// if (temp != null) {
		// short exprID = temp.getExprID();
		// if (exprID <= Short.MAX_VALUE) {
		// int exprIDSize = 1;
		// short[] exprIDArray = new short[size];
		// exprIDArray[0] = exprID;
		// for (int i = 1; i < size; i++) {
		// temp = F.GLOBAL_IDS_MAP.get(get(i));
		// if (temp == null) {
		// break;
		// }
		// exprID = temp.getExprID();
		// if (exprID <= Short.MAX_VALUE) {
		// exprIDArray[i] = exprID;
		// exprIDSize++;
		// } else {
		// break;
		// }
		// }
		// // optimized path
		// attributeFlags = (byte) size;
		// objectOutput.writeByte(attributeFlags);
		// objectOutput.writeByte((byte) exprIDSize);
		// for (int i = 0; i < exprIDSize; i++) {
		// objectOutput.writeShort(exprIDArray[i]);
		// }
		// for (int i = exprIDSize; i < size; i++) {
		// objectOutput.writeObject(get(i));
		// }
		// return;
		// }
		// }
		//
		// objectOutput.writeByte(attributeFlags);
		// objectOutput.writeInt(size);
		// for (int i = 0; i < size; i++) {
		// objectOutput.writeObject(get(i));
		// }
	}

	private Object writeReplace() throws ObjectStreamException {
		return optional(F.GLOBAL_IDS_MAP.get(this));
	}
}