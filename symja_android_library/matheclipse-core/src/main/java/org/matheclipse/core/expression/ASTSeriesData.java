package org.matheclipse.core.expression;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.util.OpenIntToIExprHashMap;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.INumber;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.Set;

public class ASTSeriesData extends AST0 implements Cloneable, Externalizable {

	/**
	 * A map of the truncated power series coefficients <code>value != 0</code>
	 */
	OpenIntToIExprHashMap coefficientValues;

	/**
	 * The power of this series.
	 */
	private final int power;

	/**
	 * The variable symbol of this series.
	 */
	private IExpr x;

	/**
	 * The point <code>x = x0</code> of this series.
	 */
	private IExpr x0;

	/**
	 * The minimum exponent used in <code>coefficientValues</code>, where the coefficient is not 0.
	 */
	private int nMin;

	/**
	 * The maximum exponent used in <code>coefficientValues</code>, where the coefficient is not 0.
	 */
	private int nMax;

	/**
	 * The denominator of this series
	 */
	private final int denominator;

	public ASTSeriesData() {
		super(F.SeriesData);
		power = 0;
		denominator = 1;
		// When Externalizable objects are deserialized, they first need to be constructed by invoking the void
		// constructor. Since this class does not have one, serialization and deserialization will fail at runtime.
	}

	public ASTSeriesData(IExpr x, IExpr x0, int nMin, int power, int denominator) {
		this(x, x0, nMin, nMin, power, denominator, new OpenIntToIExprHashMap());
	}

	public ASTSeriesData(IExpr x, IExpr x0, int nMin, int nMax, int power, int denominator,
						 OpenIntToIExprHashMap vals) {
		super(F.SeriesData);
		this.coefficientValues = vals;
		this.x = x;
		this.x0 = x0;
		this.nMin = nMin;
		this.nMax = nMax;
		this.power = power;
		this.denominator = denominator;
	}

	@Override
	public Set<IExpr> asSet() {
		throw new UnsupportedOperationException();
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
		return new ASTSeriesData(x, x0, nMin, nMax, power, denominator, new OpenIntToIExprHashMap(coefficientValues));
	}

	/**
	 * Get the coefficient for <code>(x-x0)^k</code>.
	 *
	 * @param k
	 * @return
	 */
	public IExpr coeff(int k) {
		if (k < nMin || k >= nMax) {
			return F.C0;
		}
		IExpr temp = coefficientValues.get(k);
		if (temp == null) {
			return F.C0;
		}
		return temp;
	}

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

	/**
	 * <pre>
	 * series1.compose(series2)
	 * </pre>
	 *
	 * <blockquote>
	 * <p>
	 * substitute <code>series2</code> into <code>series1</code>
	 * </p>
	 * </blockquote>
	 *
	 * <h3>Examples</h3>
	 *
	 * <pre>
	 * &gt;&gt; ComposeSeries(SeriesData(x, 0, {1, 3}, 2, 4, 1), SeriesData(x, 0, {1, 1,0,0}, 0, 4, 1) - 1)
	 * x^2+3*x^3+O(x)^4
	 * </pre>
	 *
	 * @param series2
	 * @return the composed series
	 */
	public ASTSeriesData compose(ASTSeriesData series2) {
		IExpr coeff0 = series2.coeff(0);
		if (!coeff0.equals(x0)) {
			EvalEngine.get().printMessage("Constant " + coeff0.toString() + " of series " + this.toString() + //
					" unequals point " + x0.toString() + " of series " + series2.toString());
			return null;
		}
		ASTSeriesData series = new ASTSeriesData(series2.x, series2.x0, 0, series2.power, series2.denominator);
		ASTSeriesData s;
		ASTSeriesData x0Term;
		if (x0.isZero()) {
			x0Term = series2;
		} else {
			x0Term = series2.subtract(x0);
		}
		for (int n = nMin; n < nMax; n++) {
			IExpr temp = coeff(n);
			if (!temp.isZero()) {
				s = x0Term.pow(n);
				s = s.times(temp);
				series = series.plusPS(s);
			}
		}
		return series;
	}

	/** {@inheritDoc} */
	@Override
	public ASTSeriesData copy() {
		return new ASTSeriesData(x, x0, nMin, nMax, power, denominator, new OpenIntToIExprHashMap(coefficientValues));
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
			if (coefficientValues.equals(that.coefficientValues)) {
				return true;
			}
			for (int i = nMin; i < nMax; i++) {
				if (!coeff(i).equals(that.coeff(i))) {
					return false;
				}
			}
			return true;
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
		boolean first = true;
		for (int i = nMin; i < nMax; i++) {
			IExpr temp = coeff(i);
			if (!first) {
				buf.append(",");
			}
			buf.append(temp.toString());
			first = false;
		}
		buf.append("}");

		buf.append(',');
		buf.append(nMin);
		buf.append(',');
		buf.append(power);
		buf.append(',');
		buf.append(denominator);
		buf.append(")");
		return buf.toString();
	}

	@Override
	public int size() {
		return 7;
	}

	@Override
	final public IExpr arg1() {
		return x;
	}

	@Override
	final public IExpr arg2() {
		return x0;
	}

	@Override
	final public IExpr arg3() {
		int capacity = nMax - nMin;
		if (capacity <= 0) {
			capacity = 4;
		}
		IASTAppendable list = F.ListAlloc(capacity);
		for (int i = nMin; i < nMax; i++) {
			list.append(coeff(i));
		}
		return list;
	}

	@Override
	final public IExpr arg4() {
		return F.ZZ(nMin);
	}

	@Override
	final public IExpr arg5() {
		return F.ZZ(power);
	}

	@Override
	public IExpr get(int location) {
		if (location >= 0 && location <= 7) {
			switch (location) {
				case 0:
					return arg0;
				case 1:
					// x
					return arg1();
				case 2:
					// x0
					return arg2();
				case 3:
					// Coefficients
					return arg3();
				case 4:
					// nMin
					return arg4();
				case 5:
					// power
					return arg5();
				case 6:
					// denominator
					return F.ZZ(denominator);
			}
		}
		throw new IndexOutOfBoundsException("Index: " + Integer.valueOf(location) + ", Size: 1");
	}

	public int getDenominator() {
		return denominator;
	}

	public int getNMax() {
		return nMax;
	}

	public int getNMin() {
		return nMin;
	}

	public Integer getPower() {
		return power;
	}

	public IExpr getX() {
		return x;
	}

	public IExpr getX0() {
		return x0;
	}

	/** {@inheritDoc} */
	@Override
	public int hierarchy() {
		return SERIESID;
	}

	/**
	 * <pre>
	 * series.inverse()
	 * </pre>
	 *
	 * <blockquote>
	 * <p>
	 * return the inverse series.
	 * </p>
	 * </blockquote>
	 * <h3>Examples</h3>
	 *
	 * <pre>
	 * &gt;&gt; InverseSeries(Series(Sin(x), {x, 0, 7}))
	 * x+x^3/6+3/40*x^5+5/112*x^7+O(x)^8
	 * </pre>
	 *
	 * @return the inverse series if possible
	 */
	@Override
	public ASTSeriesData inverse() {
		if (!isInvertible()) {
			int coefficientLength = power;
			if (coefficientLength > 10) {
				return null;
			}
			if (coefficientLength > 1 && !this.coeff(1).isZero()) {

				ASTSeriesData ps = new ASTSeriesData(x, x0, nMin, nMax, denominator);
				// ps.setCoeff(0,F.C0);

				IExpr a1 = coeff(1);
				// a1^(-1)
				ps.setCoeff(1, a1.inverse());
				if (coefficientLength > 2) {
					// -a1^(-3) * a2
					IExpr a2 = coeff(2);
					ps.setCoeff(2, a1.power(-3).times(a2).negate());
					if (coefficientLength > 3) {
						// a1^(-5) * (2*a2^2-a1*a3)
						IExpr a3 = coeff(3);
						ps.setCoeff(3, F.Times.of(F.Power(a1, -5), //
								F.Subtract(F.Times(F.C2, F.Sqr(a2)), F.Times(a1, a3))));
						if (coefficientLength > 4) {
							// a1^(-7) * (5*a1*a2*a3-a1*a4-5*a2^3)
							IExpr a4 = coeff(4);
							ps.setCoeff(4, F.Times.of(F.Power(a1, -7), //
									F.Plus(F.Times(F.CN5, F.Power(a2, 3)), F.Times(F.C5, a1, a2, a3),
											F.Times(F.CN1, a1, a4))));
							if (coefficientLength > 5) {
								// a1^(-9) * (6*a1^2*a2*a4+3*a1^2*a3^2+14*a2^4-a1^3*a5-21*a1*a2^2*a3)
								IExpr a5 = coeff(5);
								ps.setCoeff(5, F.Times.of(F.Power(a1, -9), //
										F.Plus(F.Times(F.ZZ(14L), F.Power(a2, 4)),
												F.Times(F.ZZ(-21L), a1, F.Sqr(a2), a3),
												F.Times(F.C3, F.Sqr(a1), F.Sqr(a3)), F.Times(F.C6, F.Sqr(a1), a2, a4),
												F.Times(F.CN1, F.Power(a1, 3), a5))));
								if (coefficientLength > 6) {
									// a1^(-11) *
									// (7*a1^3*a2*a5+7*a1^3*a3*a4+84*a1*a2^3*a3-a1^4*a6-28*a1^2*a2*a3^2-42*a2^5-28*a1^2*a2^2*a4)
									IExpr a6 = coeff(6);
									ps.setCoeff(6, F.Times.of(F.Power(a1, -11), //
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
										ps.setCoeff(7,
												F.Times.of(F.Power(a1, -13), F.Plus(F.Times(F.ZZ(132L), F.Power(a2, 6)),
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
											ps.setCoeff(8,
													F.Times.of(F.Power(a1, -15),
															F.Plus(F.Times(F.ZZ(-429L), F.Power(a2, 7)),
																	F.Times(F.ZZ(1287L), a1, F.Power(a2, 5), a3),
																	F.Times(F.ZZ(-495L), F.Sqr(a1), F.Power(a2, 4), a4),
																	F.Times(F.ZZ(165L), F.Sqr(a1), F.Power(a2, 3),
																			F.Plus(F.Times(F.CN6, F.Sqr(a3)),
																					F.Times(a1, a5))),
																	F.Times(F.ZZ(-45L), F.Power(a1, 3), F.Sqr(a2),
																			F.Plus(F.Times(F.ZZ(-11L), a3, a4),
																					F.Times(a1, a6))),
																	F.Times(F.C3, F.Power(a1, 3), a2, F.Plus(
																			F.Times(F.ZZ(55L), F.Power(a3, 3)),
																			F.Times(F.ZZ(-30L), a1, a3, a5),
																			F.Times(F.C3, a1,
																					F.Plus(F.Times(F.CN5, F.Sqr(a4)),
																							F.Times(a1, a7))))),
																	F.Times(F.Power(a1, 4), F.Plus(
																			F.Times(F.ZZ(-45L), F.Sqr(a3), a4),
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
												ps.setCoeff(9, F.Times.of(F.Power(a1, -17),
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
		ASTSeriesData ps = new ASTSeriesData(x, x0, nMin, power, denominator);
		ps.setCoeff(nMin, d);
		for (int i = nMin + 1; i < nMax; i++) {
			IExpr c = F.C0;
			for (int k = 0; k < i; k++) {
				IExpr m = this.coeff(k).times(this.coeff(i - k));
				c = c.plus(m);
			}
			IExpr b = c.times(d.times(F.CN1));
			ps.setCoeff(i, b);
		}
		return ps;
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
		return !coeff(0).isZero();
	}

	public boolean isProbableOne() {
		if (!coeff(0).isOne()) {
			return false;
		}
		for (int i = nMin; i < nMax; i++) {
			if (!coeff(i).isZero()) {
				return false;
			}
		}
		return true;
	}

	public boolean isProbableZero() {
		if (coefficientValues.size() == 0) {
			return true;
		}
		for (int i = nMin; i < nMax; i++) {
			if (!coeff(i).isZero()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		if (hashValue == 0 && x0 != null) {
			if (coefficientValues != null) {
				hashValue = x0.hashCode() + power * coefficientValues.hashCode();
			} else {
				hashValue = x0.hashCode() + power;
			}
		}
		return hashValue;
	}

	@Override
	public ASTSeriesData negate() {
		ASTSeriesData series = copy();
		for (int i = nMin; i < nMax; i++) {
			series.setCoeff(i, coeff(i).negate());
		}
		return series;
	}

	/**
	 * <pre>
	 * series.normal()
	 * </pre>
	 *
	 * <blockquote>
	 * <p>
	 * converts a <code>series</code> expression into a standard expression.
	 * </p>
	 * </blockquote>
	 * <h3>Examples</h3>
	 *
	 * <pre>
	 * &gt;&gt; Normal(SeriesData(x, 0, {1, 0, -1, -4, -17, -88, -549}, -1, 6, 1))
	 * 1/x-x-4*x^2-17*x^3-88*x^4-549*x^5
	 * </pre>
	 *
	 * @return the standard expression generated from this series <code>Plus(....)</code>.
	 */
	public IExpr normal() {
		IExpr x = getX();
		IExpr x0 = getX0();
		int nMin = getNMin();
		int nMax = getNMax();
		int denominator = getDenominator();
		int size = nMax - nMin;
		if (size < 4) {
			size = 4;
		}
		IASTAppendable result = F.PlusAlloc(size);
		for (int i = nMin; i < nMax; i++) {
			IExpr expr = coeff(i);
			if (!expr.isZero()) {
				INumber exp;
				if (denominator == 1) {
					exp = F.ZZ(i);
				} else {
					exp = F.fraction(i, denominator).normalize();
				}
				IExpr pow = x.subtract(x0).power(exp);
				result.append(F.Times(expr, pow));
			}
		}
		return result;
	}

	/**
	 * Order of a power series
	 *
	 * @return <code>Integer.MIN_VALUE</code> if power series <code>isProbableZero()</code> is true or the order of the
	 *         power series
	 */
	public int order() {
		for (int i = nMin; i < nMax; i++) {
			if (!coeff(i).isZero()) {
				return i;
			}
		}
		return Integer.MIN_VALUE;
	}

	@Override
	public ASTSeriesData plus(IExpr b) {
		if (b instanceof ASTSeriesData) {
			return plusPS((ASTSeriesData) b);
		}
		if (b.isZero()) {
			return this;
		}
		IExpr value = F.eval(coeff(0).plus(b));
		ASTSeriesData series = copy();
		if (value.isZero()) {
			series.setZero(0);
		} else {
			series.setCoeff(0, value);
		}
		return series;
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
		if (nMax < b.nMax) {
			maxSize = b.nMax;
		}
		int maxPower = power;
		if (power > b.power) {
			maxPower = b.power;
		}
		ASTSeriesData series = new ASTSeriesData(x, x0, minSize, maxPower, denominator);
		for (int i = minSize; i < maxSize; i++) {
			series.setCoeff(i, this.coeff(i).plus(b.coeff(i)));
		}
		return series;
	}

	public ASTSeriesData pow(final long n) {
		if ((n == 0L)) {
			ASTSeriesData series = new ASTSeriesData(x, x0, 0, power, denominator);
			series.setCoeff(0, F.C1);
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
			x = x.timesPS(x);
			if ((exp & 1) != 0) {
				r = r.timesPS(x);
			}
		}

		while (b2pow-- > 0L) {
			r = r.timesPS(r);
		}
		if (n < 0) {
			return r.inverse();
		}
		return r;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
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

	@Override
	public IExpr set(int location, IExpr object) {
		throw new UnsupportedOperationException();
	}

	public void setCoeff(int k, IExpr value) {
		if (value.isZero() || k >= power) {
			return;
		}
		coefficientValues.put(k, value);
		if (k < nMin) {
			nMin = k;
		} else if (k >= nMax) {
			nMax = k + 1;
		}
	}

	public void setZero(int k) {
		if (coefficientValues.containsKey(k)) {
			coefficientValues.remove(k);
			if (k == nMin) {
				nMin = k + 1;
			}
			if (k == nMax) {
				nMax = k - 1;
			}
		}
	}

	@Override
	public ASTSeriesData subtract(IExpr b) {
		if (b instanceof ASTSeriesData) {
			return subtractPS((ASTSeriesData) b);
		}
		if (b.isZero()) {
			return this;
		}
		IExpr value = F.eval(coeff(0).subtract(b));
		ASTSeriesData series = copy();
		if (value.isZero()) {
			series.setZero(0);
		} else {
			series.setCoeff(0, value);
		}
		return series;
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
		if (nMax < b.nMax) {
			maxSize = b.nMax;
		}
		int maxPower = power;
		if (power > b.power) {
			maxPower = b.power;
		}
		ASTSeriesData series = new ASTSeriesData(x, x0, minSize, maxPower, denominator);
		for (int i = minSize; i < maxSize; i++) {
			series.setCoeff(i, this.coeff(i).subtract(b.coeff(i)));
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
		if (b.isOne()) {
			return this;
		}
		ASTSeriesData series = copy();
		for (int i = nMin; i < nMax; i++) {
			series.setCoeff(i, this.coeff(i).times(b));
		}
		return series;
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
		int newPower = power;
		if (b.power < power) {
			newPower = b.power;
		}
		if (b.power != power) {
			newPower++;
		}
		ASTSeriesData series = new ASTSeriesData(x, x0, nMin + b.nMin, newPower + minSize, denominator);
		int start = series.nMin;
		for (int n = start; n <= nMax + b.nMax; n++) {
			if (n - start >= series.power) {
				continue;
			}
			IASTAppendable sum = F.PlusAlloc(n + 1);
			for (int i = 0; i <= n; i++) {
				sum.append(this.coeff(i).times(b.coeff(n - i)));
			}
			IExpr value = F.eval(sum);
			if (value.isZero()) {
				continue;
			}
			series.setCoeff(n, value);
		}
		return series;
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
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