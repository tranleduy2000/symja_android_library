package org.matheclipse.core.convert;

import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.matheclipse.core.eval.exception.WrongArgumentType;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IInteger;
import org.matheclipse.core.interfaces.ISymbol;

import jp.ac.kobe_u.cs.cream.DefaultSolver;
import jp.ac.kobe_u.cs.cream.IntVariable;
import jp.ac.kobe_u.cs.cream.Network;
import jp.ac.kobe_u.cs.cream.Solution;
import jp.ac.kobe_u.cs.cream.SolutionHandler;
import jp.ac.kobe_u.cs.cream.Solver;

/**
 * Convert <code>IExpr</code> classes from and to <a herf="http://bach.istc.kobe-u.ac.jp/cream/">Cream: Class Library
 * for Constraint Programming in Java</a>
 *
 */
public class CreamConvert {
	TreeMap<ISymbol, IntVariable> map = new TreeMap<ISymbol, IntVariable>();

	public CreamConvert() {

	}

	// public IExpr cream2Expr(final Formula formula) throws ClassCastException {
	// return F.NIL;
	// }

	public Network expr2Cream(final IAST list, final IAST variables) throws ClassCastException {
		// Create a constraint network
		Network net = new Network();
		for (int i = 1; i < variables.size(); i++) {
			if (variables.get(i) instanceof ISymbol) {
				map.put((ISymbol) variables.get(i), new IntVariable(net));
			}
		}
		IAST temp;
		IntVariable lhs;
		IntVariable rhs;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) instanceof IAST) {
				temp = (IAST) list.get(i);
				if (temp.isAST2()) {
					lhs = integerVariable(net, temp.arg1());
					rhs = integerVariable(net, temp.arg2());
					if (temp.isEqual()) {
						lhs.equals(rhs);
					} else if (temp.isAST(F.Unequal, 3)) {
						lhs.notEquals(rhs);
					} else if (temp.isAST(F.Greater, 3)) {
						lhs.gt(rhs);
					} else if (temp.isAST(F.GreaterEqual, 3)) {
						lhs.ge(rhs);
					} else if (temp.isAST(F.LessEqual, 3)) {
						lhs.le(rhs);
					} else if (temp.isAST(F.Less, 3)) {
						lhs.lt(rhs);
					} else {
						return null;
					}
				}
			}
		}
		return net;
	}

	private IntVariable integerVariable(Network net, IExpr expr) throws ArithmeticException {
		if (expr instanceof ISymbol) {
			return map.get(expr);
		}
		if (expr instanceof IInteger) {
			int value = ((IInteger) expr).toInt(); // throws ArithmeticException
			return new IntVariable(net, value);
		}
		if (expr.isAST()) {
			IAST ast = (IAST) expr;
			if (ast.isPlus()) {
				IntVariable result = integerVariable(net, ast.arg1());
				for (int i = 2; i < ast.size(); i++) {
					result = result.add(integerVariable(net, ast.get(i)));
				}
				return result;
			} else if (ast.isTimes()) {
				IntVariable result = integerVariable(net, ast.arg1());
				for (int i = 2; i < ast.size(); i++) {
					result = result.multiply(integerVariable(net, ast.get(i)));
				}
				return result;
			} else if (ast.isPower()) {
				IExpr exponent = ast.exponent();
				if (exponent.isInteger()) {
					int value = ((IInteger) exponent).toInt();
					if (value > 0) {
						IExpr base = ast.base();
						IntVariable result = integerVariable(net, base);
						for (int i = 1; i < value; i++) {
							result = result.multiply(integerVariable(net, base));
						}
						return result;
					}
				}
			} else if (ast.isASTSizeGE(F.Max, 3)) {
				IntVariable result = integerVariable(net, ast.arg1());
				for (int i = 2; i < ast.size(); i++) {
					result = result.max(integerVariable(net, ast.get(i)));
				}
				return result;
			} else if (ast.isASTSizeGE(F.Min, 3)) {
				IntVariable result = integerVariable(net, ast.arg1());
				for (int i = 2; i < ast.size(); i++) {
					result = result.min(integerVariable(net, ast.get(i)));
				}
				return result;
			} else if (ast.isAbs()) {
				return integerVariable(net, ast.arg1()).abs();
			} else if (ast.isAST(F.Sign, 2)) {
				return integerVariable(net, ast.arg1()).sign();
			}
		}
		throw new WrongArgumentType(expr, "for Solve(..., Integers)");
	}

	public TreeMap<ISymbol, IntVariable> variableMap() {
		return map;
	}

	public  IAST integerSolve(final IAST list, final IAST variables) {
		final IASTAppendable result = F.ListAlloc();
		
		Solver solver = new DefaultSolver( expr2Cream(list, variables));

		solver.findAll(new SolutionHandler() {
			@Override
			public void solved(Solver solver, Solution solution) {
				if (solution != null) {
					Set<Entry<ISymbol, IntVariable>> set = map.entrySet();
					IASTAppendable temp = F.ListAlloc(set.size());
					for (Entry<ISymbol, IntVariable> entry : set) {
						temp.append(F.Rule(entry.getKey(), F.integer(solution.getIntValue(entry.getValue()))));
					}
					result.append(temp);
				}
			}
		}, 10000);

		// szenario for FindInstance ?
		// Solution solution = solver.findFirst();
		// for (Entry<ISymbol, IntVariable> entry : map.entrySet()) {
		// result.append(F.Rule(entry.getKey(),
		// F.integer(solution.getIntValue(entry.getValue()))));
		// }
		return result;
	}
}
