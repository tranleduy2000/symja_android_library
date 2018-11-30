package org.matheclipse.core.builtin;

import com.duy.lambda.IntFunction;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.Validate;
import org.matheclipse.core.eval.interfaces.AbstractFunctionEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IExpr;

public class VectorAnalysisFunctions {
	static {
		F.Curl.setEvaluator(new Curl());
		F.Div.setEvaluator(new Div());
		F.Grad.setEvaluator(new Grad());
		F.RotationMatrix.setEvaluator(new RotationMatrix());
	}

	/**
	 * <pre>
	 * Curl({f1, f2}, {x1, x2})
	 * 
	 * Curl({f1, f2, f3}, {x1, x2, x3})
	 * </pre>
	 * 
	 * <blockquote>
	 * <p>
	 * gives the curl.
	 * </p>
	 * </blockquote>
	 * <p>
	 * See:<br />
	 * </p>
	 * <ul>
	 * <li><a href="http://en.wikipedia.org/wiki/Curl_%28mathematics%29">Wikipedia - Curl (mathematics)</a></li>
	 * </ul>
	 * <h3>Examples</h3>
	 * 
	 * <pre>
	 * &gt;&gt; Curl({f(u,v,w),f(v,w,u),f(w,u,v),f(x)}, {u,v,w})
	 * {-D(f(v,w,u),w)+D(f(w,u,v),v),-D(f(w,u,v),u)+D(f(u,v,w),w),-D(f(u,v,w),v)+D(f(v,w,u),u),f(x)}
	 * </pre>
	 */
	private static final class Curl extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			Validate.checkSize(ast, 3);
			if (ast.arg1().isVector() >= 3) {
				if (ast.arg2().isVector() == 3) {
					IAST variables = (IAST) ast.arg2();
					IAST vector = (IAST) ast.arg1();
					IASTAppendable curlVector = F.ListAlloc(vector.size());
					curlVector.append(
							F.Subtract(F.D(vector.arg3(), variables.arg2()), F.D(vector.arg2(), variables.arg3())));
					curlVector.append(
							F.Subtract(F.D(vector.arg1(), variables.arg3()), F.D(vector.arg3(), variables.arg1())));
					curlVector.append(
							F.Subtract(F.D(vector.arg2(), variables.arg1()), F.D(vector.arg1(), variables.arg2())));
					for (int i = 4; i < vector.size(); i++) {
						curlVector.append(vector.get(i));
					}
					return curlVector;
				}
			}

			return F.NIL;
		}

	}

	/**
	 * <pre>
	 * Div({f1, f2, f3,...},{x1, x2, x3,...})
	 * </pre>
	 * 
	 * <blockquote>
	 * <p>
	 * compute the divergence.
	 * </p>
	 * </blockquote>
	 * <p>
	 * See:<br />
	 * </p>
	 * <ul>
	 * <li><a href="http://en.wikipedia.org/wiki/Divergence">Wikipedia - Divergence</a></li>
	 * </ul>
	 * <h3>Examples</h3>
	 * 
	 * <pre>
	 * &gt;&gt; Div({x^2, y^3},{x, y})
	 * 2*x+3*y^2
	 * </pre>
	 */
	private static final class Div extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			Validate.checkSize(ast, 3);
			if ((ast.arg1().isVector() == ast.arg2().isVector()) && (ast.arg1().isVector() >= 0)) {
				final IAST vector = (IAST) ast.arg1();
				final IAST variables = (IAST) ast.arg2();
				int size = vector.size();
				IASTAppendable divergenceValue = F.PlusAlloc(size);
				return divergenceValue.appendArgs(size, new IntFunction<IExpr>() {
                    @Override
                    public IExpr apply(int i) {
                        return F.D(vector.get(i), variables.get(i));
                    }
                });
			}

			return F.NIL;
		}

	}

	private static final class Grad extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			Validate.checkSize(ast, 3);
			IExpr function = ast.arg1();
			if (ast.arg2().isVector() > 0) {
				IAST variables = (IAST) ast.arg2();
				IASTAppendable dList = F.ListAlloc(variables.argSize());
				for (int i = 1; i < variables.size(); i++) {
					dList.append(engine.evaluate(F.D(function, variables.get(i))));
				}
				return dList;
			}

			return F.NIL;
		}

	}

	private static final class RotationMatrix extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			if (ast.isAST1()) {
				IExpr theta = ast.arg1();
				return
				// [$ {{Cos(theta),-Sin(theta)},{Sin(theta),Cos(theta)}} $]
				F.List(F.List(F.Cos(theta), F.Negate(F.Sin(theta))), F.List(F.Sin(theta), F.Cos(theta))); // $$;
			}
			if (ast.isAST2() && ast.arg2().isAST(F.List, 4)) {
				// TODO generalize for all rotations
				// see https://github.com/corywalker/expreduce/blob/master/expreduce/resources/trig.m
				IExpr theta = ast.arg1();
				IAST vector = (IAST) ast.arg2();
				IExpr x = vector.arg1();
				IExpr y = vector.arg2();
				IExpr z = vector.arg3();
				if (z.isZero()) {
					if (y.isZero()) {
						return
						// [$ {{(x^3*Conjugate(x)^3)/Abs(x)^6,0,0},{0,Cos(theta),-((x^2*Conjugate(x)*
						// Sin(theta))/Abs(x)^3)},{0,(x*Conjugate(x)^2*Sin(theta))/Abs(x)^3,(x^3*Conjugate(x)^3*
						// Cos(theta))/Abs(x)^6}} $]
						F.List(F.List(F.Times(F.Power(x, 3), F.Power(F.Abs(x), -6), F.Power(F.Conjugate(x), 3)), F.C0,
								F.C0),
								F.List(F.C0, F.Cos(theta),
										F.Times(F.CN1, F.Sqr(x), F.Power(F.Abs(x), -3), F.Conjugate(x), F.Sin(theta))),
								F.List(F.C0, F.Times(x, F.Power(F.Abs(x), -3), F.Sqr(F.Conjugate(x)), F.Sin(theta)),
										F.Times(F.Power(x, 3), F.Power(F.Abs(x), -6), F.Power(F.Conjugate(x), 3),
												F.Cos(theta)))); // $$;
					}
					if (x.isZero()) {
						return
						// [$
						// {{Cos(theta),0,(y^2*Conjugate(y)*Sin(theta))/Abs(y)^3},{0,(y^3*Conjugate(y)^3)/Abs(y)^6,0},{-((y*Conjugate(y)^2*Sin(theta))/Abs(y)^3),0,(y^3*Conjugate(y)^3*Cos(theta))/Abs(y)^6}}
						// $]
						F.List(F.List(F.Cos(theta), F.C0,
								F.Times(F.Sqr(y), F.Power(F.Abs(y), -3), F.Conjugate(y), F.Sin(theta))),
								F.List(F.C0, F.Times(F.Power(y, 3), F.Power(F.Abs(y), -6), F.Power(F.Conjugate(y), 3)),
										F.C0),
								F.List(F.Times(F.CN1, y, F.Power(F.Abs(y), -3), F.Sqr(F.Conjugate(y)), F.Sin(theta)),
										F.C0, F.Times(F.Power(y, 3), F.Power(F.Abs(y), -6), F.Power(F.Conjugate(y), 3),
												F.Cos(theta)))); // $$;
					}
					return F.NIL;
				}
				if (x.isZero() && y.isZero()) {
					return
					// [$ {{Cos(theta),-((z*Sin(theta))/Abs(z)),0},{(Conjugate(z)*Sin(theta))/Abs(z),(z*Conjugate(z)*
					// Cos(theta))/Abs(z)^2,0},{0,0,(z*Conjugate(z))/Abs(z)^2}} $]
					F.List(F.List(F.Cos(theta), F.Times(F.CN1, z, F.Power(F.Abs(z), -1), F.Sin(theta)), F.C0),
							F.List(F.Times(F.Power(F.Abs(z), -1), F.Conjugate(z), F.Sin(theta)),
									F.Times(z, F.Power(F.Abs(z), -2), F.Conjugate(z), F.Cos(theta)), F.C0),
							F.List(F.C0, F.C0, F.Times(z, F.Power(F.Abs(z), -2), F.Conjugate(z)))); // $$;
				}
				return F.NIL;
			}
			return F.NIL;
		}

	}

	private final static VectorAnalysisFunctions CONST = new VectorAnalysisFunctions();

	public static VectorAnalysisFunctions initialize() {
		return CONST;
	}

	private VectorAnalysisFunctions() {

	}

}
