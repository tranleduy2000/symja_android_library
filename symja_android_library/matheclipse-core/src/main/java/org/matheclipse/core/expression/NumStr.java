package org.matheclipse.core.expression;

import org.apfloat.Apfloat;
import org.matheclipse.core.basic.Config;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.INum;
import org.matheclipse.core.interfaces.INumber;
import org.matheclipse.parser.client.FEConfig;

public final class NumStr extends Num {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6378124858265275437L;

	private String fFloatStr;
	private long fPrecision;
	private int fExponent;

	public NumStr(String floatStr) {
		this(floatStr, 1);
	}

	public NumStr(String floatStr, int exponent) {
		int index = floatStr.indexOf("*^");
		fExponent = 0;
		fFloatStr = floatStr;
		if (index > 0) {
			fFloatStr = floatStr.substring(0, index);
			fExponent = Integer.parseInt(floatStr.substring(index + 2));
		}

		if (fExponent != 0) {
			fDouble = Double.parseDouble(fFloatStr + "E" + fExponent);
			// // value * 10 ^ exponent
			// fDouble = fDouble * Math.pow(10, fExponent);
		} else {
		fDouble = Double.parseDouble(fFloatStr);
		}
		fPrecision = fFloatStr.length();
		if (fFloatStr.startsWith("0.")) {
			fPrecision -= 2;
		} else if (fFloatStr.indexOf(".") > 0) {
			fPrecision--;
		}
		if (fPrecision < FEConfig.MACHINE_PRECISION) {
			fPrecision = FEConfig.MACHINE_PRECISION;
		}
	}

	@Override
	public ApfloatNum apfloatNumValue(long precision) {
		precision = (fPrecision > precision) ? fPrecision : precision;
		if (fExponent == 0) {
			return ApfloatNum.valueOf(fFloatStr, precision);
		}
		return ApfloatNum.valueOf(fFloatStr + "E" + fExponent, precision);
	}

	@Override
	public Apfloat apfloatValue(long precision) {
		precision = (fPrecision > precision) ? fPrecision : precision;
		if (fExponent == 0) {
			return new Apfloat(fFloatStr, precision);
		}
		return new Apfloat(fFloatStr + "E" + fExponent, precision);
	}

	/** {@inheritDoc} */
	@Override
	public long determinePrecision() {
		return precision();
	}

	@Override
	public IExpr evaluate(EvalEngine engine) {
		if (engine.isNumericMode() && engine.isArbitraryMode()) {
			long precision = fPrecision < engine.getNumericPrecision() ? engine.getNumericPrecision() : fPrecision;
			// engine.setNumericPrecision(precision);
			if (fExponent == 0) {
				return ApfloatNum.valueOf(fFloatStr, precision);
			}
			return ApfloatNum.valueOf(fFloatStr + "E" + fExponent, precision);
		}
		return super.evaluate(engine);
	}

	public INumber evaluatePrecision(EvalEngine engine) {
		if (engine.isArbitraryMode()) {
			long precision = fPrecision < engine.getNumericPrecision() ? engine.getNumericPrecision() : fPrecision;
			// long precision = fPrecision;
			// if (engine.isApfloat()) {
      // precision = fPrecision < engine.getNumericPrecision() ? fPrecision :
      // engine.getNumericPrecision();
			// }
			// engine.setNumericPrecision(precision);
			if (fExponent == 0) {
				return ApfloatNum.valueOf(fFloatStr, precision);
			}
			return ApfloatNum.valueOf(fFloatStr + "E" + fExponent, precision);
		}
		return super.evaluatePrecision(engine);
	}

	@Override
	public IExpr plus(final IExpr that) {
		if (EvalEngine.isApfloat(fPrecision)) {
			long precision = fPrecision;
			if (that instanceof ApfloatNum) {
				ApfloatNum arg2 = (ApfloatNum) that;
				precision = arg2.precision() < precision ? arg2.precision() : precision;
				return apfloatNumValue(precision).add(arg2.apfloatNumValue(precision));
			}
			if (that instanceof Num) {
				return apfloatNumValue(precision).add(((INum) that).apfloatNumValue(precision));
			}
			if (that instanceof ApcomplexNum) {
				ApcomplexNum arg2 = (ApcomplexNum) that;
				precision = arg2.precision() < precision ? arg2.precision() : precision;
				return ApcomplexNum.valueOf(apfloatValue(precision)).add((ApcomplexNum) that);
			}
			if (that instanceof ComplexNum) {
				return ApcomplexNum.valueOf(apfloatValue(precision))
						.add(((ComplexNum) that).apcomplexNumValue(precision));
			}
		}
		return super.plus(that);
	}

	@Override
	public IExpr times(final IExpr that) {
		if (EvalEngine.isApfloat(fPrecision)) {
			long precision = fPrecision;
			if (that instanceof ApfloatNum) {
				ApfloatNum arg2 = (ApfloatNum) that;
				precision = arg2.precision() < precision ? arg2.precision() : precision;
				return apfloatNumValue(precision).multiply(arg2.apfloatNumValue(precision));
			}
			if (that instanceof Num) {
				return apfloatNumValue(precision).multiply(((INum) that).apfloatNumValue(precision));
			}
			if (that instanceof ApcomplexNum) {
				ApcomplexNum arg2 = (ApcomplexNum) that;
				precision = arg2.precision() < precision ? arg2.precision() : precision;
				return ApcomplexNum.valueOf(apfloatValue(precision)).multiply((ApcomplexNum) that);
			}
			if (that instanceof ComplexNum) {
				return ApcomplexNum.valueOf(apfloatValue(precision))
						.multiply(((ComplexNum) that).apcomplexNumValue(precision));
			}
		}
		return super.times(that);
	}

	public int getExponent() {
		return fExponent;
	}

	public String getFloatStr() {
		return fFloatStr;
	}

	public long precision() {
		return fPrecision;
	}
}
