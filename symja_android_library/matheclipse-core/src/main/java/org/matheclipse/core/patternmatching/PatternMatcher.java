package org.matheclipse.core.patternmatching;

import com.duy.lambda.Consumer;
import com.duy.lambda.Predicate;

import org.matheclipse.combinatoric.MultisetPartitionsIterator;
import org.matheclipse.combinatoric.NumberPartitionsIterator;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.ConditionException;
import org.matheclipse.core.eval.exception.ReturnException;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.expression.ID;
import org.matheclipse.core.generic.ObjIntPredicate;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.INumber;
import org.matheclipse.core.interfaces.IPattern;
import org.matheclipse.core.interfaces.IPatternObject;
import org.matheclipse.core.interfaces.IPatternSequence;
import org.matheclipse.core.interfaces.IRational;
import org.matheclipse.core.interfaces.ISignedNumber;
import org.matheclipse.core.interfaces.ISymbol;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayDeque;
import java.util.List;

public class PatternMatcher extends IPatternMatcher implements Externalizable {
	private final static IASTAppendable[] UNEVALED = new IASTAppendable[] {};

	private final static class Entry {
		IExpr fPatternExpr;
		IExpr fEvalExpr;

		public Entry(IExpr patternExpr, IExpr evalExpr) {
			this.fPatternExpr = patternExpr;
			this.fEvalExpr = evalExpr;
		}
	}

	/**
	 * Matches an <code>IAST</code> with header attribute <code>Orderless</code> .
	 *
	 * @see ISymbol#ORDERLESS
	 */
	private final class OrderlessMatcher {

		private IAST fLHSPatternAST;

		private IAST fLHSEvalAST;

		/**
		 * The used (i.e. matched) expression indexes in the LHS evaluation expression; <code>-1</code> indicates an
		 * unused index.
		 */
		private int[] fUsedIndex;

		/**
		 * Match a pattern expression against an evaluation expression, there the arguments are commutative (i.e. the
		 * head of the AST expression has attribute <code>Orderless</code>)
		 *
		 * @param lhsPatternAST
		 *            the pattern AST
		 * @param lhsEvalAST
		 *            the evaluation AST
		 */
		public OrderlessMatcher(final IAST lhsPatternAST, final IAST lhsEvalAST) {
			this.fLHSPatternAST = lhsPatternAST;
			this.fLHSEvalAST = lhsEvalAST;
			this.fUsedIndex = new int[fLHSPatternAST.argSize()];
			for (int l = 0; l < fUsedIndex.length; l++) {
				fUsedIndex[l] = -1;
			}
		}

		public void filterResult(IASTAppendable result) {
			for (int i = 0; i < fUsedIndex.length; i++) {
				result.set(fUsedIndex[i], null);
			}
			int indx = 1;
			while (indx < result.size()) {
				if (result.get(indx) == null) {
					result.remove(indx);
				} else {
					indx++;
				}
			}
		}

		/**
		 *
		 * @param lhsPosition
		 *            the position in the LHS expression which should actually be matched.
		 * @param stackMatcher
		 * @return
		 */
		public boolean matchOrderlessAST(final int lhsPosition, final StackMatcher stackMatcher, final EvalEngine engine) {
			if (lhsPosition >= fLHSPatternAST.size()) {
				return stackMatcher.matchRest();
			}
			final IExpr subPattern = fLHSPatternAST.get(lhsPosition);
			final IExpr[] patternValues = fPatternMap.copyPattern();
			return fLHSEvalAST.exists(new ObjIntPredicate<IExpr>() {
				@Override
				public boolean test(IExpr temp, final int j) {
					if (fLHSPatternAST.forAll(new ObjIntPredicate<IExpr>() {
						@Override
						public boolean test(IExpr x, int i) {
							return fUsedIndex[i - 1] != j;
						}
					})) {
						boolean matched = false;
						final StackMatcher localStackMatcher = stackMatcher == null ? new StackMatcher(engine)
								: stackMatcher;
						int lastStackSize = localStackMatcher.size();
						try {
							if (localStackMatcher.push(subPattern, temp)) {
								fUsedIndex[lhsPosition - 1] = j;
								if (OrderlessMatcher.this.matchOrderlessAST(lhsPosition + 1, localStackMatcher, engine)) {
									matched = true;
									return true;
								}
							}
						} finally {
							if (!matched) {
								fPatternMap.resetPattern(patternValues);
								fUsedIndex[lhsPosition - 1] = -1;
							}
							localStackMatcher.removeFrom(lastStackSize);
						}
					}
					return false;
				}
			});
		}
	}

	/**
	 * Manage a stack of pairs of expressions, which have to match each other
	 *
	 */
	@SuppressWarnings("serial")
	public final class StackMatcher extends ArrayDeque<Entry> {
		final EvalEngine fEngine;

		public StackMatcher(EvalEngine engine) {
			fEngine = engine;
		}

		/**
		 * Match the entries of the stack recursively starting from the top entry.
		 *
		 * @return <code>true</code> if all expressions could be matched.
		 */
		public boolean matchRest() {
			if (isEmpty()) {
				return checkCondition(fEngine);
			}
			boolean matched = true;
			Entry entry = pop();
			try {
				matched = matchExpr(entry.fPatternExpr, entry.fEvalExpr, fEngine, this);
				return matched;
			} finally {
				if (!matched) {
					push(entry);
				}
			}
		}

		public boolean push(IExpr patternExpr, IExpr evalExpr) {
			if (patternExpr == evalExpr) {
				return true;
			}
			if (patternExpr.isAST()) {
				// if (fPatternMap.isValueAssigned()) {
				// patternExpr = fPatternMap.substitutePatternOrSymbols(patternExpr, true);
				// if (patternExpr.isAST()) {
				// if (!patternExpr.isFreeOfPatterns()) {
				// // insert for delayed evaluation in matchRest() method
				// push(new Entry(patternExpr, evalExpr));
				// return true;
				// }
				// }
				// } else {
			if (!patternExpr.isFreeOfPatterns()) {
					// insert for delayed evaluation in matchRest() method
					push(new Entry(patternExpr, evalExpr));
					return true;
				}
				// }
			} else if (patternExpr instanceof IPatternObject) {
					return ((IPatternObject) patternExpr).matchPattern(evalExpr, fPatternMap);
				}
			return patternExpr.equals(evalExpr);
		}

		/**
		 * Remove all elements starting at the given <code>fromPosition</code>.
		 *
		 * @param fromPosition
		 */
		public void removeFrom(int fromPosition) {
			int len = size();
			while (len > fromPosition) {
				pop();
				len--;
			}
		}

	}
    /**
     *
     */
    private static final long serialVersionUID = -6708462090303928690L;

    /**
     * Check if the two left-hand-side pattern expressions are equivalent. (i.e. <code>f[x_,y_]</code> is equivalent to
     * <code>f[a_,b_]</code> )
     *
     * @param patternExpr1
     * @param patternExpr2
     * @param pm1
     * @param pm2
     * @return
     */
	public static boolean equivalent(final IExpr patternExpr1, final IExpr patternExpr2, final IPatternMap pm1,
									 final IPatternMap pm2) {
        if (patternExpr1 == patternExpr2) {
            return true;
        }
        if (!patternExpr1.isPatternExpr()) {
            if (!patternExpr2.isPatternExpr()) {
                return patternExpr1.equals(patternExpr2);
            }
            return false;
        }
        if (patternExpr1.isAST()) {
            if (patternExpr2.isAST()) {
                final IAST l1 = (IAST) patternExpr1;
                final IAST l2 = (IAST) patternExpr2;
                if (l1.size() != l2.size()) {
                    return false;
                }
				return l1.forAll(new ObjIntPredicate<IExpr>() {
					@Override
					public boolean test(IExpr temp1, int i) {
						IExpr temp2 = l2.get(i);
						if (temp1 == temp2) {
							return true;
						}
						if (temp1.hashCode() != temp2.hashCode()) {
							if (temp1.isPatternExpr() && temp2.isPatternExpr()) {
								return equivalent(temp1, temp2, pm1, pm2);
							}
							return false;
						}
						if (!temp1.isPatternExpr() || !temp2.isPatternExpr()) {
							if (!temp1.equals(temp2)) {
								return false;
							}
						}
						return equivalent(temp1, temp2, pm1, pm2);
					}
				}, 0);
            }
            return false;
        }
        if (patternExpr1 instanceof IPatternObject) {
            if (patternExpr2 instanceof IPatternObject) {
                return ((IPatternObject) patternExpr1).equivalent((IPatternObject) patternExpr2, pm1, pm2);
            }
            return false;
        }
        return patternExpr1.equals(patternExpr2);
    }


	/**
	 * priority of the left-hand-side of this matcher
	 *
	 */
	protected transient int fLHSPriority;

	protected transient int fPatterHash = 0;

	/**
	 * Additional condition for pattern-matching maybe <code>null</code>
	 *
	 */
	protected IExpr fPatternCondition;

	/**
	 * A map from a pattern to a possibly found value during pattern-matching. Will be set to <code>null</code> if the
	 * left-hand-side pattern expression contains no pattern.
	 */
	protected transient IPatternMap fPatternMap;
	public IPatternMap getPatternMap() {
		if (fPatternMap == null) {
			int[] priority = new int[] { IPatternMapImpl.DEFAULT_RULE_PRIORITY };
			fPatternMap = IPatternMapImpl.determinePatterns(fLhsPatternExpr, priority);
		}
        return fPatternMap;
    }

	/**
	 * Needed for serialization
	 *
	 */
	public PatternMatcher() {
		super(null);
		this.fLHSPriority = IPatternMapImpl.DEFAULT_RULE_PRIORITY;
		this.fLhsPatternExpr = null;
		this.fPatternCondition = null;
		this.fPatternMap = null;
	}

	public PatternMatcher(final IExpr patternExpr) {
		this(patternExpr, true);
	}

	public PatternMatcher(final IExpr patternExpr, boolean initAll) {
		super(patternExpr);
		this.fLHSPriority = IPatternMapImpl.DEFAULT_RULE_PRIORITY;
		this.fPatternCondition = null;
		if (patternExpr.isCondition()) {
			this.fLhsPatternExpr = patternExpr.first();
			this.fPatternCondition = patternExpr.second();
		}
		if (initAll) {
			int[] priority = new int[] { IPatternMapImpl.DEFAULT_RULE_PRIORITY };
			fPatternMap = determinePatterns(priority);
			this.fLHSPriority = priority[0];
	}
	}
    /**
     * Check if the condition for this pattern matcher evaluates to <code>true</code>.
     */
	final public boolean checkCondition(EvalEngine engine) {
		// boolean traceMode = false;
		// try {
		// traceMode = engine.isTraceMode();
		// engine.setTraceMode(false);
			if (fPatternCondition != null) {
                final IExpr substConditon = fPatternMap.substituteSymbols(fPatternCondition);
				if (fPatternMap.isFreeOfPatternSymbols(substConditon)) {
                if (engine.evalTrue(substConditon)) {
                    return checkRHSCondition(engine);
                }
                return false;
			}
				return true;
		} else {
				return checkRHSCondition(engine);
			}
		// } finally {
		// engine.setTraceMode(traceMode);
		// }
        }

    /**
	 * Check if the condition for the right-hand-sides <code>Module[] or Condition[]</code> expressions evaluates to
	 * <code>true</code>. Override it in subclasses.
     *
     * @return <code>true</code>
     * @see PatternMatcherAndEvaluator#checkRHSCondition(EvalEngine)
     */
    public boolean checkRHSCondition(EvalEngine engine) {
        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        PatternMatcher v = (PatternMatcher) super.clone();
        v.fPatternCondition = fPatternCondition;
		IPatternMap patternMap = getPatternMap();
		v.fPatternMap = patternMap.clone();
        v.fLHSPriority = fLHSPriority;
        return v;
    }

	// @Override
	// public int compareTo(IPatternMatcher pm) {
	// if (fPriority < pm.getPriority()) {
	// return -1;
	// }
	// if (fPriority > pm.getPriority()) {
	// return 1;
	// }
	// return equivalent(pm);
	// }
    @Override
    public int equivalentTo(IPatternMatcher patternMatcher) {
        // if (fLHSPriority+getRHSPriority() <
        // patternMatcher.getLHSPriority()+patternMatcher.getRHSPriority()) {
        // return -1;
        // }
        // if (fLHSPriority+getRHSPriority() >
        // patternMatcher.getLHSPriority()+patternMatcher.getRHSPriority()) {
        // return 1;
        // }

        if (fLHSPriority < patternMatcher.getLHSPriority()) {
            return -1;
        }
        if (fLHSPriority > patternMatcher.getLHSPriority()) {
            return 1;
        }

        // if (getRHSPriority() < patternMatcher.getRHSPriority()) {
        // return -1;
        // }
        // if (getRHSPriority() > patternMatcher.getRHSPriority()) {
        // return 1;
        // }

        return equivalent(patternMatcher);

    }

    // package private
    int equivalent(final IPatternMatcher obj) {
        if (this == obj) {
            return 0;
        }
        if (obj instanceof PatternMatcher) {
            return equivalentLHS(obj);
        }
        return fLhsPatternExpr.compareTo(obj.fLhsPatternExpr);
    }

    @Override
    public int equivalentLHS(final IPatternMatcher obj) {
        final PatternMatcher pm = (PatternMatcher) obj;
        if (fPatternMap.size() != pm.fPatternMap.size()) {
            return (fPatternMap.size() < pm.fPatternMap.size()) ? -1 : 1;
        }
        if (isRuleWithoutPatterns()) {
            return fLhsPatternExpr.compareTo(pm.fLhsPatternExpr);
        }
        if (equivalent(fLhsPatternExpr, pm.fLhsPatternExpr, fPatternMap, pm.fPatternMap)) {
            if (fPatternCondition != null) {
                if (pm.fPatternCondition != null) {
                    return fPatternCondition.compareTo(pm.fPatternCondition);
                }
                return 1;
            }
            return (pm.fPatternCondition != null) ? -1 : 0;
        }
        return fLhsPatternExpr.compareTo(obj.fLhsPatternExpr);
    }

	/** {@inheritDoc} */
    @Override
    public IExpr eval(final IExpr leftHandSide, EvalEngine engine) {
        return F.NIL;
    }

    /**
	 * <p>
	 * Replace subexpressions for <code>Rule</code> or <code>RuleDelayed</code> in Flat or Orderless expressions.
	 * </p>
	 *
	 * <pre>
	 * >> f(a, b, c) /. f(a, b) -> d
	 * f(d,c)
	 * </pre>
	 *
     * @param lhsPatternAST
     * @param lhsEvalAST
     * @param rhsExpr
	 * @param engine
     * @return <code>F.NIL</code> if no match was found.
     */
	protected IExpr replaceSubExpressionOrderlessFlat(final IAST lhsPatternAST, final IAST lhsEvalAST,
			final IExpr rhsExpr, EvalEngine engine) {
        if (lhsPatternAST.size() < lhsEvalAST.size()) {
            if (lhsPatternAST.isOrderlessAST() && lhsPatternAST.isFlatAST()) {
				if (!matchExpr(lhsPatternAST.head(), lhsEvalAST.head(), engine, new StackMatcher(engine))) {
                    return F.NIL;
                }
                final OrderlessMatcher foMatcher = new OrderlessMatcher(lhsPatternAST, lhsEvalAST);
				boolean matched = foMatcher.matchOrderlessAST(1, new StackMatcher(engine), engine);
                if (matched) {
                    IASTAppendable lhsResultAST = (lhsEvalAST).copyAppendable();
                    foMatcher.filterResult(lhsResultAST);
                    IExpr result = fPatternMap.substituteSymbols(rhsExpr);
                    try {
                        result = F.eval(result);
                        lhsResultAST.append(result);
                        return lhsResultAST;
                    } catch (final ConditionException e) {
                        logConditionFalse(lhsEvalAST, lhsPatternAST, rhsExpr);
                        // fall through
                    } catch (final ReturnException e) {
                        lhsResultAST.append(e.getValue());
                        return lhsResultAST;
                    }
                }
                return F.NIL;
            }
            if (lhsPatternAST.isFlatAST()) {
				if (!matchExpr(lhsPatternAST.head(), lhsEvalAST.head(), engine, new StackMatcher(engine))) {
                    return F.NIL;
                }
                int len = lhsEvalAST.size() - lhsPatternAST.size();
                for (int i = 0; i < len; i++) {
					if (matchASTSequence(lhsPatternAST, lhsEvalAST, i, engine, new StackMatcher(engine))) {
                        IASTAppendable lhsResultAST = lhsEvalAST.copyAppendable();
                        for (int j = 1; j < lhsPatternAST.size(); j++) {
                            lhsResultAST.remove(i + 1);
                        }
                        try {
                            IExpr result = fPatternMap.substituteSymbols(rhsExpr);
                            result = F.eval(result);
                            lhsResultAST.append(i + 1, result);
                            return lhsResultAST;
                        } catch (final ConditionException e) {
                            logConditionFalse(lhsEvalAST, lhsPatternAST, rhsExpr);
                        } catch (final ReturnException e) {
                            lhsResultAST.append(i + 1, e.getValue());
                            return lhsResultAST;
                        }
                        return F.NIL;
                    }
                }
            }
        }
        return F.NIL;
    }

    /**
     * Get the additional condition for pattern-matching
	 *
     */
    public IExpr getCondition() {
        return fPatternCondition;
    }


    /**
     * Returns the matched pattern in the order they appear in the pExpr
     *
     * @param resultList
     * @param pExpr
     */
    @Override
    public void getPatterns(final List<IExpr> resultList, final IExpr pExpr) {
        if (pExpr.isAST()) {
            ((IAST) pExpr).forEach(new Consumer<IExpr>() {
                @Override
                public void accept(IExpr x) {
                    PatternMatcher.this.getPatterns(resultList, x);
                }
            }, 0);
        } else if (pExpr.isPattern()) {
            resultList.add(fPatternMap.getValue((IPattern) pExpr));
        }
    }

	@Override
	public int getPatternHash() {
		return fPatterHash;
	}

    /**
     * Get the priority of this pattern-matcher. Lower values have higher priorities.
     *
     * @return the priority
     */
    @Override
    public int getLHSPriority() {
        return fLHSPriority;
    }

    public void setLHSPriority(final int priority) {
        fLHSPriority = priority;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((fPatternCondition == null) ? 0 : fPatternCondition.hashCode());
        // result = prime * result + ((fPatternMap == null) ? 0 :
        // fPatternMap.hashCode());
        // result = prime * result + fPriority;
        return result;
    }

	public IPatternMap determinePatterns() {
		int[] priority = new int[] { IPatternMapImpl.DEFAULT_RULE_PRIORITY };
		return IPatternMapImpl.determinePatterns(fLhsPatternExpr, priority);
	}
	public IPatternMap determinePatterns(int[] priority) {
		// int[] priority = new int[] { IPatternMapImpl.DEFAULT_RULE_PRIORITY };
		return IPatternMapImpl.determinePatterns(fLhsPatternExpr, priority);
    }

	/** {@inheritDoc} */
	@Override
	public boolean isPatternHashAllowed(int patternHash) {
		return true;
	}

    /**
     * Returns true if the given expression contains no patterns
     *
     * @return
     */
    @Override
    final public boolean isRuleWithoutPatterns() {
		return getPatternMap().isRuleWithoutPatterns();
    }

    protected void logConditionFalse(final IExpr lhsEvalAST, final IExpr lhsPatternAST, IExpr rhsAST) {
        // System.out.println("\nCONDITION false: " + lhsEvalAST.toString() +
        // "\n >>> " + lhsPatternAST.toString() + " := "
        // + rhsAST.toString());
    }

	protected boolean matchAST(IAST lhsPatternAST, final IExpr lhsEvalExpr, final EvalEngine engine,
							   StackMatcher stackMatcher) {
        // System.out.println(lhsPatternAST.toString()+" -
        // "+lhsEvalExpr.toString());
        int functionID = lhsPatternAST.headID();
        if (functionID > ID.UNKNOWN) {
            switch (functionID) {
			// case ID.Except:
			// if (lhsPatternAST.isExcept()) {
			// if (lhsPatternAST.isAST2()) {
			// return !matchExpr(lhsPatternAST.arg1(), lhsEvalExpr, engine, stackMatcher)
			// && matchExpr(lhsPatternAST.arg2(), lhsEvalExpr, engine, stackMatcher);
			// } else {
			// return !matchExpr(lhsPatternAST.arg1(), lhsEvalExpr, engine, stackMatcher);
			// }
			// }
			// break;

			case ID.HoldPattern:
			case ID.Literal:
				if (lhsPatternAST.isHoldPatternOrLiteral()) {
					return matchExpr(lhsPatternAST.arg1(), lhsEvalExpr, engine, stackMatcher);
				}
				break;
			case ID.Condition:
				if (lhsPatternAST.isCondition()) {
					// expression /; test
					IExpr lhsTempPatternExpr = fPatternMap.substituteSymbols(lhsPatternAST);
					if (lhsTempPatternExpr.isAST()) {
						lhsTempPatternExpr = engine.evalHoldPattern((IAST) lhsTempPatternExpr);
					}
					final PatternMatcher matcher = new PatternMatcherEvalEngine(lhsTempPatternExpr, engine);
					if (matcher.test(lhsEvalExpr, engine)) {
						fPatternMap.copyPatternValuesFromPatternMatcher(matcher.fPatternMap);
						return true;
					}
				}
				break;
			case ID.Alternatives:
				if (lhsPatternAST.isAlternatives()) {
					IAST alternatives = lhsPatternAST;
					return alternatives.exists(new Predicate<IExpr>() {
						@Override
						public boolean test(IExpr x) {
							return PatternMatcher.this.matchExpr(x, lhsEvalExpr, engine);
						}
					});
				}
				break;
                case ID.Except:
                    if (lhsPatternAST.isExcept()) {
                        if (lhsPatternAST.isAST2()) {
						return !matchExpr(lhsPatternAST.arg1(), lhsEvalExpr, engine, stackMatcher)
								&& matchExpr(lhsPatternAST.arg2(), lhsEvalExpr, engine, stackMatcher);
                        } else {
						return !matchExpr(lhsPatternAST.arg1(), lhsEvalExpr, engine, stackMatcher);
                        }
                    }
				break;
			case ID.Complex:
				if (lhsPatternAST.isAST(F.Complex, 3)) {
					if (lhsEvalExpr.isNumber()) {
						INumber number = (INumber) lhsEvalExpr;
						return matchExpr(lhsPatternAST.arg1(), number.re(), engine, stackMatcher)
								&& matchExpr(lhsPatternAST.arg2(), number.im(), engine, stackMatcher);
						// } else {
						// return matchASTExpr(lhsPatternAST, lhsEvalExpr, engine, stackMatcher);
					}
				}
				break;
			case ID.Rational:
				if (lhsPatternAST.isAST(F.Rational, 3)) {
					if (lhsEvalExpr.isRational()) {
						IRational rational = (IRational) lhsEvalExpr;
						return matchExpr(lhsPatternAST.arg1(), rational.numerator(), engine, stackMatcher)
								&& matchExpr(lhsPatternAST.arg2(), rational.denominator(), engine, stackMatcher);
						// } else {
						// return matchASTExpr(lhsPatternAST, lhsEvalExpr, engine, stackMatcher);
					}
				}
				break;
			case ID.Optional:
				if (lhsPatternAST.isOptional()) {
					return matchExpr(lhsPatternAST.arg1(), lhsEvalExpr, engine, stackMatcher);
				}
                    break;
                case ID.PatternTest:
                    if (lhsPatternAST.isPatternTest()) {
					if (matchExpr(lhsPatternAST.arg1(), lhsEvalExpr, engine, stackMatcher)) {
                            return fPatternMap.isPatternTest(lhsPatternAST.arg1(), lhsPatternAST.arg2(), engine);
                        }
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        if (lhsEvalExpr instanceof IAST) {
			if (lhsPatternAST.isFreeOfPatterns() && lhsPatternAST.equals(lhsEvalExpr)) {
				return stackMatcher.matchRest();
            }

            final IAST lhsEvalAST = (IAST) lhsEvalExpr;
            final ISymbol sym = lhsPatternAST.topHead();
			int lhsEvalSize = lhsEvalAST.size();
			if (lhsPatternAST.size() <= lhsEvalSize) {
                if ((lhsPatternAST.isFlatAST()) && sym.equals(lhsEvalAST.topHead())
						&& !(lhsPatternAST.isOrderlessAST() && lhsPatternAST.size() == lhsEvalSize)) {
                    if (!matchExpr(lhsPatternAST.head(), lhsEvalAST.head(), engine)) {
                        return false;
                    }
                    return matchFlatAndFlatOrderlessAST(sym, lhsPatternAST, lhsEvalAST, engine, stackMatcher);
                }
			}

			// if (lhsPatternAST.size() < lhsEvalSize) {
                    if (lhsPatternAST.isEvalFlagOn(IAST.CONTAINS_PATTERN_SEQUENCE)) {
                        if (!matchExpr(lhsPatternAST.head(), lhsEvalAST.head(), engine)) {
                            return false;
                        }
				if (lhsPatternAST.size() == 1 && lhsEvalAST.size() == 1) {
					return true;
				}
						final int lastPosition = lhsPatternAST.argSize();
                        if (lhsPatternAST.get(lastPosition).isAST(F.PatternTest, 3)) {
					if (lhsPatternAST.size() <= lhsEvalSize) {
                            IAST patternTest = (IAST) lhsPatternAST.get(lastPosition);
                            if (patternTest.arg1().isPatternSequence(false)) {
							// TODO only the special case, where the last element is
                                // a pattern sequence, is handled here
                                IASTAppendable seq = F.Sequence();
								seq.appendAll(lhsEvalAST, lastPosition, lhsEvalSize);
                                if (((IPatternSequence) patternTest.arg1()).matchPatternSequence(seq, fPatternMap)) {
                                    if (matchAST(lhsPatternAST.removeFromEnd(lastPosition),
										lhsEvalAST.removeFromEnd(lastPosition), engine, stackMatcher)) {
                                        return fPatternMap.isPatternTest(patternTest.arg1(), patternTest.arg2(),
                                                engine);
                                    }
                                    return false;
                                }
                            }
					}
				} else if (lhsPatternAST.size() > 1 && lhsPatternAST.arg1().isPatternSequence(false)) {
					IPatternSequence patternSequence = (IPatternSequence) lhsPatternAST.arg1();
					return matchBlankSequence(patternSequence, lhsPatternAST, 1, lhsEvalAST, engine, stackMatcher);
				} else {
					if (lhsPatternAST.size() > 1 && lhsEvalSize > 1) {
						// functionID = lhsPatternAST.headID();
						// if (functionID > ID.UNKNOWN) {
						// if (functionID == ID.Except || functionID == ID.PatternTest) {
						// if (matchExpr(lhsPatternAST.arg1(), lhsEvalAST, engine)) {
						// boolean matched = matchAST(
						// lhsPatternAST.rest().addEvalFlags(IAST.CONTAINS_PATTERN_SEQUENCE),
						// lhsEvalAST.rest(), engine, stackMatcher);
						// if (matched) {
						// return true;
						// }
						// }
						// }
						// } else
						if (matchExpr(lhsPatternAST.arg1(), lhsEvalAST.arg1(), engine)) {
							boolean matched = matchAST(
									lhsPatternAST.rest().addEvalFlags(IAST.CONTAINS_PATTERN_SEQUENCE),
									lhsEvalAST.rest(), engine, stackMatcher);
							if (matched) {
								return true;
							}
						}
                        }
                    }
				// }

				return false;
				// }
			}

			// final IExpr lhsPatternHead = lhsPatternAST.head();
			// final IExpr lhsEvalHead = lhsEvalAST.head();
			if (lhsPatternAST.size() != lhsEvalSize) {
				// if (lhsPatternAST.isEvalFlagOn(IAST.CONTAINS_PATTERN_SEQUENCE) && lhsPatternHead.equals(lhsEvalHead)
				// && lhsPatternAST.size() > lhsEvalSize) {
				// return matchASTWithBlankNullSequence(lhsPatternAST, lhsEvalAST, engine, stackMatcher);
				// }
				// // int size = lhsPatternAST.size();
				// // if (lhsPatternAST.hasDefaultArgument()) {
				// // IAST lhsAST = lhsPatternAST.removeAtClone(size - 1);
				// // return matchAST(lhsAST, lhsEvalExpr, stackMatcher);
				// // }
                    return false;
                }
            final IExpr lhsPatternHead = lhsPatternAST.head();
            final IExpr lhsEvalHead = lhsEvalAST.head();
            if (lhsPatternHead.isSymbol() && lhsEvalHead.isSymbol()) {
                if (!lhsPatternHead.equals(lhsEvalHead)) {
                    return false;
                }
            } else {
				if (!matchExpr(lhsPatternHead, lhsEvalHead, engine, stackMatcher)) {
                    return false;
                }
            }

            if (lhsPatternAST.isOrderlessAST() && lhsPatternAST.size() > 2) {
                // only "pure Orderless" and "FlatOrderless with same size()"
                // will be handled here:
                OrderlessStepVisitor visitor = new OrderlessStepVisitor(sym, lhsPatternAST, lhsEvalAST, stackMatcher,
						fPatternMap, (sym.hasOneIdentityAttribute() || sym.hasFlatAttribute())
                        // if FLAT isn't set and the Orderless ASTs have
                        // same size ==> use OneIdentity in pattern
                        // matching
								|| (lhsPatternAST.size() == lhsEvalSize && !sym.hasFlatAttribute()));
                MultisetPartitionsIterator iter = new MultisetPartitionsIterator(visitor, lhsPatternAST.argSize());
                return !iter.execute();
            }

            return matchASTSequence(lhsPatternAST, lhsEvalAST, 0, engine, stackMatcher);
        }
        if (lhsPatternAST.isAST(F.Rational, 3) && lhsEvalExpr.isRational()) {
            IRational numer = ((IRational) lhsEvalExpr).numerator();
            IRational denom = ((IRational) lhsEvalExpr).denominator();
            if (matchExpr(lhsPatternAST.arg1(), numer, engine) && matchExpr(lhsPatternAST.arg2(), denom, engine)) {
                return true;
            }
        } else if (lhsPatternAST.isAST(F.Complex, 3) && lhsEvalExpr.isNumber()) {
            ISignedNumber re = ((INumber) lhsEvalExpr).re();
            ISignedNumber im = ((INumber) lhsEvalExpr).im();
            if (matchExpr(lhsPatternAST.arg1(), re, engine) && matchExpr(lhsPatternAST.arg2(), im, engine)) {
                return true;
            }
        }
        return false;
    }

	private boolean matchBlankSequence(final IPatternSequence patternSequence, final IAST lhsPatternAST,
			final int position, final IAST lhsEvalAST, EvalEngine engine, StackMatcher stackMatcher) {

		boolean isNullSequence = patternSequence.isNullSequence();
		if (position == lhsPatternAST.argSize()) {
			boolean matched = false;
			final IExpr[] patternValues = fPatternMap.copyPattern();
			try {
			IASTAppendable seq = F.Sequence();
			seq.appendAll(lhsEvalAST, 1, lhsEvalAST.size());
			if (patternSequence.matchPatternSequence(seq, fPatternMap)) {
					matched = stackMatcher.matchRest();
				if (matched) {
					return true;
				}
				}
				return false;
			} finally {
				if (!matched) {
				fPatternMap.resetPattern(patternValues);
			}
			}
		}
		int lhsEvalIndex = 2; // lastPosition;
		IAST reducedLHSPatternAST = lhsPatternAST.removeFromStart(position + 1).addEvalFlags(IAST.CONTAINS_PATTERN_SEQUENCE);
		boolean matched = false;
		final IExpr[] patternValues = fPatternMap.copyPattern();
		final int lhsEvalSize = lhsEvalAST.size();
		int startPosition = 1;
		if (isNullSequence) {
			startPosition = 1;
			lhsEvalIndex = 1;
		}
			while (lhsEvalIndex <= lhsEvalSize) {
			try {
				IASTAppendable seq = F.Sequence();
			seq.appendAll(lhsEvalAST, startPosition, lhsEvalIndex);

				if (patternSequence.matchPatternSequence(seq, fPatternMap)) {
					matched = matchAST(reducedLHSPatternAST, lhsEvalAST.copyFrom(lhsEvalIndex), engine, stackMatcher);
					if (matched) {
						return true;
					}
				}
			} finally {
				if (!matched) {
				fPatternMap.resetPattern(patternValues);
			}
			}
			lhsEvalIndex++;

		}
		return false;
	}

    /**
     * Precondition <code>lhsPatternAST.size() > lhsEvalAST.size()</code>.
     *
	 * @param lhsPatternAST
	 *            an AST which contains a BlankNullSequence
     * @param lhsEvalAST
     * @param engine
     * @param stackMatcher
     * @return
     */
	// private boolean matchASTWithBlankNullSequence(final IAST lhsPatternAST, final IAST lhsEvalAST, EvalEngine engine,
	// StackMatcher stackMatcher) {
	// int size = lhsPatternAST.size();
	// if (lhsPatternAST.isOrderlessAST()) {
	// IASTAppendable result = F.NIL;
	// for (int i = 1; i < lhsPatternAST.size(); i++) {
	// if (!lhsPatternAST.get(i).isPatternSequence(true)) {
	// if (result.isPresent()) {
	// result.append(lhsPatternAST.get(i));
	// }
	// } else {
	// size--;
	// if (size == lhsEvalAST.size()) {
	// if (!result.isPresent()) {
	// result = lhsPatternAST.copyUntil(i);
	// }
	// if (result.exists(x -> x.isPatternSequence(true))) {
	// result.addEvalFlags(IAST.CONTAINS_PATTERN_SEQUENCE);
	// }
	// return matchAST(result, lhsEvalAST, engine, stackMatcher);
	// }
	// }
	// }
	// } else {
	// boolean evaled = false;
	// IAST result = lhsPatternAST;
	// // search for null sequences from the start
	// final IExpr[] patternValues = fPatternMap.copyPattern();
	// for (int i = 1; i < lhsPatternAST.size(); i++) {
	// if (!lhsPatternAST.get(i).isPatternSequence(true)) {
	// if (evaled) {
	// result = lhsPatternAST.copyFrom(i);
	// }
	// break;
	// } else {
	// IPatternSequence blankNullSequence = (IPatternSequence) lhsPatternAST.get(i);
	// evaled = true;
	// size--;
	// if (size == lhsEvalAST.size() - 1) {
	// result = lhsPatternAST.copyFrom(i + 1);
	// if (result.exists(x -> x.isPatternSequence(true))) {
	// result.addEvalFlags(IAST.CONTAINS_PATTERN_SEQUENCE);
	// }
	// return matchAST(result, lhsEvalAST, engine, stackMatcher);
	// } else if (size >= lhsEvalAST.size()) {
	// result = lhsPatternAST.copyFrom(i + 1);
	// if (!blankNullSequence.matchPattern(F.Sequence(), fPatternMap)) {
	// fPatternMap.resetPattern(patternValues);
	// return false;
	// }
	// if (size == 1) {
	// return stackMatcher.matchRest();
	// }
	// }
	// }
	// }
	// // search for null sequences from the end
	// for (int i = result.size() - 1; i >= 1; i--) {
	// if (!result.get(i).isPatternSequence(true)) {
	// break;
	// } else {
	// size--;
	// if (size == lhsEvalAST.size()) {
	// result = result.removeFromEnd(i);
	// if (result.exists(x -> x.isPatternSequence(true))) {
	// result.addEvalFlags(IAST.CONTAINS_PATTERN_SEQUENCE);
	// }
	// return matchAST(result, lhsEvalAST, engine, stackMatcher);
	// }
	// }
	// }
	// }
	// return false;
	// }

    /**
	 * Match all sub-expressions which contain no pattern objects if possible (i.e. no Flat or Orderless
	 * expressions,...)
	 *
	 * Distinguishes between "equally" matched list-expressions and list expressions with
	 * <code>expr.isPatternExpr()==true</code>.
     *
     * @param lhsPatternAST
     * @param lhsEvalAST
     * @param lhsEvalOffset
     * @param stackMatcher
     * @return
     */
	private boolean matchASTSequence(IAST lhsPatternAST, IAST lhsEvalAST, final int lhsEvalOffset, EvalEngine engine,
			StackMatcher stackMatcher) {
        // distinguish between "equally" matched list-expressions and AST expressions with "CONTAINS_PATTERN" flag
        IExpr[] patternValues = fPatternMap.copyPattern();
        int lastStackSize = stackMatcher.size();
		boolean matched = false;
        try {
			if (lhsPatternAST.size() == lhsEvalAST.size()) {
				IAST[] removed = remove(lhsPatternAST, lhsEvalAST, engine, stackMatcher);
				if (removed == null) {
					return false;
				} else {
					if (removed.length > 0) {
						lhsPatternAST = removed[0];
						lhsEvalAST = removed[1];
						if (lhsPatternAST.size() == 2) {
							matched = matchExpr(lhsPatternAST.arg1(), lhsEvalAST.arg1(), engine, stackMatcher);
							if (!matched) {
								return false;
							}
							matched = stackMatcher.matchRest();
							return matched;
						} else if (lhsPatternAST.size() == 1) {
							matched = stackMatcher.matchRest();
							return matched;
						}
					}
				}
			}
            for (int i = 1; i < lhsPatternAST.size(); i++) {
                if (!stackMatcher.push(lhsPatternAST.get(i), lhsEvalAST.get(lhsEvalOffset + i))) {
                    matched = false;
                    return false;
                }
            }
			matched = stackMatcher.matchRest();
			return matched;
        } finally {
            if (!matched) {
                stackMatcher.removeFrom(lastStackSize);
                fPatternMap.resetPattern(patternValues);
            }
        }
    }

    /**
     * Match the <code>lhsPatternAST</code> with its <code>Default[]</code> values.
     *
	 * @param symbolWithDefaultValue
	 *            the symbol for getting the associated default values from
	 * @param lhsPatternAST
	 *            left-hand-side which may contain patterns with default values
	 * @param engine
	 *            the evaluation engine
	 * @return <code>F.NIL</code> if the given <code>lhsPatternAST</code> could not be matched or contains no pattern
	 *         with default value.
     */
	private IExpr matchDefaultArgumentsAST(final ISymbol symbolWithDefaultValue, IAST lhsPatternAST, final EvalEngine engine) {
		final IASTAppendable cloned = F.ast(lhsPatternAST.head(), lhsPatternAST.size(), false);
		final boolean[] defaultValueMatched = new boolean[] { false };
		if (lhsPatternAST.exists(new ObjIntPredicate<IExpr>() {
			@Override
			public boolean test(IExpr temp, int i) {
				if (temp.isPatternDefault()) {
					if (temp.isOptional()) {
						IAST optional = (IAST) temp;
						IExpr optionalValue;
						if (optional.size() == 3) {
							optionalValue = optional.arg2();
						} else {
							optionalValue = symbolWithDefaultValue.getDefaultValue();
						}
						if (optionalValue != null) {
							if (!(PatternMatcher.this.matchExpr(temp.first(), optionalValue, engine))) {
								return true;
							}
							defaultValueMatched[0] = true;
						}
						return false;
					}
					IExpr positionDefaultValue = symbolWithDefaultValue.getDefaultValue(i);
					if (positionDefaultValue != null) {
						if (!((IPatternObject) temp).matchPattern(positionDefaultValue, fPatternMap)) {
							return true;
						}
						defaultValueMatched[0] = true;
						return false;
					} else {
						IExpr commonDefaultValue = symbolWithDefaultValue.getDefaultValue();
						if (commonDefaultValue != null) {
							if (!((IPatternObject) temp).matchPattern(commonDefaultValue, fPatternMap)) {
								return true;
							}
							defaultValueMatched[0] = true;
							return false;
						}
					}
				}
				cloned.append(temp);
				return false;
			}
		})) {
            return F.NIL;
        }
        if (defaultValueMatched[0]) {
            if (cloned.isOneIdentityAST1()) {
                return cloned.arg1();
            }
            return cloned;
        }
        return F.NIL;
    }

    /**
     * Checks if the two expressions match each other
     *
	 *
     * @return
     */
    protected boolean matchExpr(IExpr lhsPatternExpr, final IExpr lhsEvalExpr, EvalEngine engine) {
		return matchExpr(lhsPatternExpr, lhsEvalExpr, engine, new StackMatcher(engine));
    }

    /**
     * Checks if the two expressions match each other
     *
     * @return
     */
	protected boolean matchExpr(IExpr lhsPatternExpr, final IExpr lhsEvalExpr, final EvalEngine engine,
								StackMatcher stackMatcher) {
        boolean matched = false;
        if (lhsPatternExpr.isAST()) {
            IAST lhsPatternAST = (IAST) lhsPatternExpr;
            int functionID = lhsPatternAST.headID();
            if (functionID > ID.UNKNOWN) {
                switch (functionID) {
                    case ID.HoldPattern:
				case ID.Literal:
                        if (lhsPatternAST.isHoldPatternOrLiteral()) {
						return matchExpr(lhsPatternAST.arg1(), lhsEvalExpr, engine, stackMatcher);
                        }
                        break;
                    case ID.Condition:
                        if (lhsPatternAST.isCondition()) {
                            // expression /; test
                            IExpr lhsTempPatternExpr = fPatternMap.substituteSymbols(lhsPatternAST);
                            if (lhsTempPatternExpr.isAST()) {
							lhsTempPatternExpr = engine.evalHoldPattern((IAST) lhsTempPatternExpr);
                            }
                            final PatternMatcher matcher = new PatternMatcherEvalEngine(lhsTempPatternExpr, engine);
                            if (matcher.test(lhsEvalExpr, engine)) {
                                matched = true;
                                fPatternMap.copyPatternValuesFromPatternMatcher(matcher.fPatternMap);
                            }
                        }
                        break;
                    case ID.Alternatives:
                        if (lhsPatternAST.isAlternatives()) {
						IAST alternatives = lhsPatternAST;
						matched = alternatives.exists(new Predicate<IExpr>() {
							@Override
							public boolean test(IExpr x) {
								return PatternMatcher.this.matchExpr(x, lhsEvalExpr, engine);
							}
						});
                            if (!matched) {
                                return false;
                            }
                        }
                        break;
                    case ID.Except:
                        if (lhsPatternAST.isExcept()) {
                            if (lhsPatternAST.isAST2()) {
							matched = !matchExpr(lhsPatternAST.arg1(), lhsEvalExpr, engine, stackMatcher)
									&& matchExpr(lhsPatternAST.arg2(), lhsEvalExpr, engine, stackMatcher);
                            } else {
							matched = !matchExpr(lhsPatternAST.arg1(), lhsEvalExpr, engine, stackMatcher);
                            }
                            if (!matched) {
                                return false;
                            }
                        }
                        break;
                    case ID.Complex:
                        if (lhsPatternAST.isAST(F.Complex, 3)) {
                            if (lhsEvalExpr.isNumber()) {
                                INumber number = (INumber) lhsEvalExpr;
							matched = matchExpr(lhsPatternAST.arg1(), number.re(), engine, stackMatcher)
									&& matchExpr(lhsPatternAST.arg2(), number.im(), engine, stackMatcher);
                            } else {
                                matched = matchASTExpr(lhsPatternAST, lhsEvalExpr, engine, stackMatcher);
                            }
                            if (!matched) {
                                return false;
                            }
                        }
                        break;
                    case ID.Rational:
                        if (lhsPatternAST.isAST(F.Rational, 3)) {
                            if (lhsEvalExpr.isRational()) {
                                IRational rational = (IRational) lhsEvalExpr;
							matched = matchExpr(lhsPatternAST.arg1(), rational.numerator(), engine, stackMatcher)
									&& matchExpr(lhsPatternAST.arg2(), rational.denominator(), engine, stackMatcher);
                            } else {
                                matched = matchASTExpr(lhsPatternAST, lhsEvalExpr, engine, stackMatcher);
                            }
						if (!matched) {
							return false;
						}
					}
					break;
				case ID.Optional:
					if (lhsPatternAST.isOptional()) {
						matched = matchExpr(lhsPatternAST.arg1(), lhsEvalExpr, engine, stackMatcher);
                            if (!matched) {
                                return false;
                            }
                        }
					break;
				case ID.PatternTest:
					if (lhsPatternAST.isPatternTest()) {
						if (matchExpr(lhsPatternAST.arg1(), lhsEvalExpr, engine, stackMatcher)) {
							return fPatternMap.isPatternTest(lhsPatternAST.arg1(), lhsPatternAST.arg2(), engine);
						}
						return false;
					}
                        break;
                    default:
                        matched = matchASTExpr(lhsPatternAST, lhsEvalExpr, engine, stackMatcher);
                        break;
                }
            } else {
                matched = matchASTExpr(lhsPatternAST, lhsEvalExpr, engine, stackMatcher);
            }
        } else if (lhsPatternExpr instanceof IPatternObject) {
            matched = ((IPatternObject) lhsPatternExpr).matchPattern(lhsEvalExpr, fPatternMap);
        } else {
            matched = lhsPatternExpr.equals(lhsEvalExpr);
        }
        if (matched) {
			return stackMatcher.matchRest();
        }
        return false;

    }

	private boolean matchASTExpr(IAST lhsPatternAST, final IExpr lhsEvalExpr, EvalEngine engine,
                                 StackMatcher stackMatcher) {
        boolean matched = false;
        IExpr[] patternValues = fPatternMap.copyPattern();
        try {
            matched = matchAST(lhsPatternAST, lhsEvalExpr, engine, stackMatcher);
                if (!matched) {
				fPatternMap.resetPattern(patternValues);
				if ((lhsPatternAST.getEvalFlags() & IAST.CONTAINS_DEFAULT_PATTERN) == IAST.CONTAINS_DEFAULT_PATTERN) {
					// if (!lhsPatternAST.isFreeOfDefaultPatterns()) {
					if (lhsEvalExpr.isAST() && lhsPatternAST.hasOptionalArgument() && !lhsPatternAST.isOrderlessAST()) {
						// TODO for Power[x_, y_.] matching Power[a,b] test both cases Power[a,b] && Power[Power[a,b],1]
						IExpr temp = matchOptionalArgumentsAST(lhsPatternAST.topHead(), lhsPatternAST, (IAST) lhsEvalExpr,
								engine);
                        if (temp.isPresent()) {
							matched = matchExpr(temp, lhsEvalExpr, engine, stackMatcher);
                        }
                    } else {
						IExpr temp = matchDefaultArgumentsAST(lhsPatternAST.topHead(), lhsPatternAST, engine);
                        if (temp.isPresent()) {
							matched = matchExpr(temp, lhsEvalExpr, engine, stackMatcher);
                        }
                    }
                }
            }
        } finally {
            if (!matched) {
                fPatternMap.resetPattern(patternValues);
            }
        }
        return matched;

    }

	/**
	 * Match Flat or Orderless LHS pattern expressions. It's assumed that the headers of the expreesion already matched.
	 *
	 * @param sym
	 * @param lhsPattern
	 * @param lhsEval
	 * @param engine
	 * @param stackMatcher
	 * @return
	 */
	private boolean matchFlatAndFlatOrderlessAST(final ISymbol sym, IAST lhsPattern, IAST lhsEval, EvalEngine engine,
			StackMatcher stackMatcher) {
        if ((sym.getAttributes() & ISymbol.ORDERLESS) == ISymbol.ORDERLESS) {
			// System.out.println(lhsPatternAST.toString() + " << >> " + lhsEvalAST.toString());

			if (lhsPattern.isAST1()) {
				return matchExpr(lhsPattern.arg1(), lhsEval, engine, stackMatcher);
			}

			// IExpr temp = fPatternMap.substituteASTPatternOrSymbols(lhsPattern, false);
			// if (temp.isAST(lhsPattern.head())) {
			// lhsPattern = (IAST) temp;
			// }
			IASTAppendable[] removed = removeOrderless(lhsPattern, lhsEval);
			if (removed==null) {
						return false;
					}
			boolean matched = false;
			IExpr[] patternValues = fPatternMap.copyPattern();
			IASTAppendable lhsPatternAST = removed[0];
			IASTAppendable lhsEvalAST =  removed[1];
			if (lhsPatternAST.size() <= 2) {
				try {
				if (lhsPatternAST.isAST1()) {
						matched = matchExpr(lhsPatternAST.arg1(), lhsEvalAST, engine, stackMatcher);
						return matched;
            }
				if (lhsPatternAST.size() == 1 && lhsEvalAST.size() > 1) {
						matched = false;
						return matched;
					}
					matched = stackMatcher.matchRest();
					return matched;
				} finally {
					if (!matched) {
						fPatternMap.resetPattern(patternValues);
				}
				}
			}
			lhsPattern = lhsPatternAST;
			lhsEval = lhsEvalAST;

			final IAST lhsPatternFinal = lhsPattern;
			final IAST lhsEvalFinal = lhsEval;
			for (int i = 1; i < lhsPatternFinal.size(); i++) {
				IExpr patternArg = lhsPatternFinal.get(i);
				if (!(patternArg instanceof IPatternObject)) {
                    final int index = i;
					IAST reduced = lhsPatternFinal.removeAtCopy(index);
					boolean evaled = false;
					for (int k = 1; k < lhsEvalFinal.size(); k++) {
                                try {
							IExpr evalArg = lhsEvalFinal.get(k);
							if (!(patternArg.head() instanceof IPatternObject)) {
								if (patternArg.isAST()) {
//									if ((((IAST) patternArg).getEvalFlags()
//											& IAST.CONTAINS_DEFAULT_PATTERN) == IAST.CONTAINS_DEFAULT_PATTERN) {
//										if (patternArg.isFree(x -> x.isOrderlessAST(), true)) {
//											matched = matchExpr(patternArg, evalArg, engine, stackMatcher);
//											evaled = true;
//
//											if (matched) {
//												matched = matchFlatAndFlatOrderlessAST(sym, reduced,
//														lhsEvalFinal.removeAtCopy(k), engine, stackMatcher);
//												if (matched) {
//													return true;
//												}
//											}
//										}
//										continue;
//									}

									 if ((((IAST) patternArg).getEvalFlags()
									 & IAST.CONTAINS_DEFAULT_PATTERN) == IAST.CONTAINS_DEFAULT_PATTERN) {
									 continue;
									 }
								}

								if (patternArg.head().equals(evalArg.head())
										&& patternArg.isFree(new Predicate<IExpr>() {
									@Override
									public boolean test(IExpr x) {
										return x.isOrderlessAST();
									}
								}, true)) {
									evaled = true;
									matched = matchExpr(patternArg, evalArg, engine, stackMatcher);
								}

								if (matched) {
									matched = matchFlatAndFlatOrderlessAST(sym, reduced, lhsEvalFinal.removeAtCopy(k),
											engine, stackMatcher);
									if (matched) {
										return true;
									}
								}
							}
                                } finally {
                                    if (!matched) {
                            fPatternMap.resetPattern(patternValues);
							}
						}
					}
					if (evaled) {
                            return false;
                        }
                }
            }

			FlatOrderlessStepVisitor visitor = new FlatOrderlessStepVisitor(sym, lhsPatternFinal, lhsEvalFinal,
					stackMatcher, fPatternMap, sym.hasFlatAttribute());
			MultisetPartitionsIterator iter = new MultisetPartitionsIterator(visitor, lhsPattern.argSize());
            return !iter.execute();
		} else {
			// IExpr temp = fPatternMap.substituteASTPatternOrSymbols(lhsPattern, false);
			// if (temp.isAST(lhsPattern.head())) {
			// lhsPattern = (IAST) temp;
			// }
			IASTAppendable[] removed = removeFlat(lhsPattern, lhsEval);
			if (removed == null) {
				return false;
			}
			if (removed[0].size() == 1) {
				return false;
			}
			IAST lhsPatternAST = removed[0];
			IAST lhsEvalAST = removed[1];
			if (lhsPatternAST.isAST1()) {
				int lhsEvalSize = lhsEvalAST.size();
				if (lhsPatternAST.arg1().isPatternSequence(false)) {
                    // TODO only the special case, where the last element is
                    // a pattern sequence, is handled here
                    IASTAppendable seq = F.Sequence();
					seq.appendAll(lhsEval, 1, lhsEvalSize);
					if (((IPatternSequence) lhsPatternAST.arg1()).matchPatternSequence(seq, fPatternMap)) {
                        return true;
                    }
                }
				if (lhsPatternAST.size() == lhsEvalAST.size()) {
					return matchASTSequence(lhsPatternAST, lhsEvalAST, 0, engine, stackMatcher);
                }
                return false;
            }

			FlatStepVisitor visitor = new FlatStepVisitor(sym, lhsPatternAST, lhsEvalAST, stackMatcher, fPatternMap);
			NumberPartitionsIterator iter = new NumberPartitionsIterator(visitor, lhsEvalAST.argSize(),
					lhsPatternAST.argSize());
            return !iter.execute();
        }
    }

	/**
	 * Remove parts which are "free of patterns" in <code>lhsPattern</code> and <code>lhsEval</code>.
	 *
	 * @param lhsPattern
	 *            the expression which can contain pattern-matching objects
	 * @param lhsEval
	 *            the expression which can contain no patterns
	 * @return <code>null</code> if the matching isn't possible.
	 */
	private IASTAppendable[] removeOrderless(final IAST lhsPattern, final IAST lhsEval) {
		IASTAppendable lhsPatternAST = lhsPattern.copyAppendable();
		IASTAppendable lhsEvalAST = lhsEval.copyAppendable();
		int iIndex = 1;
		while (iIndex < lhsPatternAST.size()) {
			// for (int i = 1; i < lhsPatternSize; i++) {
			IExpr temp = lhsPatternAST.get(iIndex);

			// if (temp instanceof IPatternObject) {
			// temp = fPatternMap.getValue((IPatternObject) temp);
			// if (temp == null) {
			// iIndex++;
			// continue;
			// }
			// }
			if (temp.isFreeOfPatterns()) {
				boolean evaled = false;
				int jIndex = 1;
				while (jIndex < lhsEvalAST.size()) {
					IExpr x = lhsEvalAST.get(jIndex);
					if (x.equals(temp)) {
						lhsPatternAST.remove(iIndex);
						lhsEvalAST.remove(jIndex);
						evaled = true;
						break;
					}
					jIndex++;
				}
				if (!evaled) {
					return null;
				}
				continue;
			}
			iIndex++;
		}
		return new IASTAppendable[] { lhsPatternAST, lhsEvalAST };
	}

	/**
	 * Remove parts which are "free of patterns" in <code>lhsPattern</code> and <code>lhsEval</code>.
	 *
	 * @param lhsPattern
	 *            the expression which can contain pattern-matching objects
	 * @param lhsEval
	 *            the expression which can contain no patterns
	 * @return <code>null</code> if the matching isn't possible.
	 */
	private IAST[] remove(final IAST lhsPattern, final IAST lhsEval, EvalEngine engine, StackMatcher stackMatcher) {
		IASTAppendable lhsPatternAST = lhsPattern.copyAppendable();
		IASTAppendable lhsEvalAST = lhsEval.copyAppendable();

		int iIndex = 1;
		boolean evaled = false;
		boolean matched = false;
		while (iIndex < lhsPatternAST.size()) {
			IExpr lhs = lhsPatternAST.get(iIndex);
			IExpr rhs = lhsEvalAST.get(iIndex);

			if (lhs.isFreeOfPatterns()) {
				if (lhs.equals(rhs)) {
					lhsPatternAST.remove(iIndex);
					lhsEvalAST.remove(iIndex);
					evaled = true;
					continue;
				}
				return null;
			}
			if (lhs instanceof IPattern) {
				matched = ((IPattern) lhs).matchPattern(rhs, fPatternMap);
				if (matched) {
					lhsPatternAST.remove(iIndex);
					lhsEvalAST.remove(iIndex);
					evaled = true;
					continue;
				}
				return null;
			}
			if (lhs instanceof IPatternSequence) {
				return UNEVALED;
			}
//			if (lhs.isAST() && lhs.isFree(x -> x.isOrderlessAST(), true)) {
//				matched = matchExpr(lhs, rhs, engine);
//				if (matched) {
//					lhsPatternAST.remove(iIndex);
//					lhsEvalAST.remove(iIndex);
//					evaled = true;
//					continue;
//				}
//				return null;
//			}
			iIndex++;
		}
		if (!evaled) {
			return UNEVALED;
		}
		// if (lhsPatternAST.size() > 1) {
		// IAST temp = fPatternMap.substituteASTPatternOrSymbols(lhsPatternAST, false);
		// if (temp.isAST(lhsPatternAST.head())) {
		// System.out.println(" " + lhsPatternAST.toString() + " -> " + temp.toString());
		// return new IAST[] { temp, lhsEvalAST };
		// }
		// }
		return new IAST[] { lhsPatternAST, lhsEvalAST };
	}
	/**
	 * Remove parts which are "free of patterns" in <code>lhsPattern</code> and <code>lhsEval</code>.
	 *
	 * @param lhsPattern
	 *            the expression which can contain pattern-matching objects
	 * @param lhsEval
	 *            the expression which can contain no patterns
	 * @return <code>null</code> if the matching isn't possible.
	 */
	private IASTAppendable[] removeFlat(final IAST lhsPattern, final IAST lhsEval) {
		IASTAppendable lhsPatternAST = lhsPattern.copyAppendable();
		IASTAppendable lhsEvalAST = lhsEval.copyAppendable();
		// start from the beginning
		int iIndex = 1;
		while (iIndex < lhsPatternAST.size()) {
			IExpr temp = lhsPatternAST.get(iIndex);
			if (temp.isFreeOfPatterns()) {
				boolean evaled = false;
				if (iIndex < lhsEvalAST.size()) {
					if (lhsEvalAST.get(iIndex).equals(temp)) {
						lhsPatternAST.remove(iIndex);
						lhsEvalAST.remove(iIndex);
						evaled = true;
					}
				}
				if (!evaled) {
					return null;
				}
				continue;
			}
			break;
		}
		// now start from the end
		iIndex = lhsPatternAST.size() - 1;
		int jIndex = lhsEvalAST.size() - 1;
		while (iIndex > 0) {
			IExpr temp = lhsPatternAST.get(iIndex);
			if (temp.isFreeOfPatterns()) {
				boolean evaled = false;
				if (jIndex < lhsEvalAST.size()) {
					if (lhsEvalAST.get(jIndex).equals(temp)) {
						lhsPatternAST.remove(iIndex--);
						lhsEvalAST.remove(jIndex--);
						evaled = true;
					}
				}
				if (!evaled) {
					return null;
				}
				continue;
			}
			break;
		}
		return new IASTAppendable[] { lhsPatternAST, lhsEvalAST };
	}

    /**
     * Match the <code>lhsPatternAST</code> with its <code>Default[]</code> values.
     *
	 * @param symbolWithDefaultValue
	 *            the symbol for getting the associated default values from
	 * @param lhsPatternAST
	 *            left-hand-side which may contain patterns with default values
	 * @param engine
	 *            the evaluation engine
	 * @return <code>F.NIL</code> if the given <code>lhsPatternAST</code> could not be matched or contains no pattern
	 *         with default value.
     */
	private IExpr matchOptionalArgumentsAST(ISymbol symbolWithDefaultValue, IAST lhsPatternAST, IAST lhsEvalAST,
			EvalEngine engine) {
        int lhsSize = lhsEvalAST.size();
        IASTAppendable cloned = F.ast(lhsPatternAST.head(), lhsPatternAST.size(), false);
        boolean defaultValueMatched = false;
        for (int i = 1; i < lhsPatternAST.size(); i++) {
			IExpr temp = lhsPatternAST.get(i);
			if (temp.isPatternDefault()) {
				if (temp.isOptional()) {
					IAST optional = (IAST) temp;
					if (i < lhsSize) {
						cloned.append(optional.arg1());
						continue;
					}
					IExpr optionalValue;
					if (optional.size() == 3) {
						optionalValue = optional.arg2();
					} else {
						optionalValue = symbolWithDefaultValue.getDefaultValue();
					}
					if (optionalValue != null) {
						if (!(matchExpr(optional.arg1(), optionalValue, engine))) {
							return F.NIL;
						}
						defaultValueMatched = true;
						continue;
					}
				} else {
				IPattern pattern = (IPattern) temp;
				IExpr positionDefaultValue = symbolWithDefaultValue.getDefaultValue(i);
                if (positionDefaultValue != null) {
					if (!((IPatternObject) temp).matchPattern(positionDefaultValue, fPatternMap)) {
                        return F.NIL;
                    }
                    defaultValueMatched = true;
                    continue;
                } else {
                    if (i < lhsSize) {
                        cloned.append(pattern);
                        continue;
                    }
                    IExpr commonDefaultValue = symbolWithDefaultValue.getDefaultValue();
                    if (commonDefaultValue != null) {
						if (!((IPatternObject) temp).matchPattern(commonDefaultValue, fPatternMap)) {
                            return F.NIL;
                        }
                        defaultValueMatched = true;
                        continue;
                    }
                }

				}
            }
			cloned.append(temp);
        }
        if (defaultValueMatched) {
            if (cloned.isOneIdentityAST1()) {
                return cloned.arg1();
            }
            return cloned;
        }
        return F.NIL;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        fLhsPatternExpr = (IExpr) objectInput.readObject();
        fPatternCondition = (IExpr) objectInput.readObject();
        if (fLhsPatternExpr != null) {
			int[] priority = new int[] { IPatternMapImpl.DEFAULT_RULE_PRIORITY };
			this.fPatternMap = IPatternMapImpl.determinePatterns(fLhsPatternExpr, priority);
			fLHSPriority = priority[0];
        }
    }

	/**
	 * Sets an additional evaluation-condition for pattern-matching
	 *
	 */
	public void setCondition(final IExpr condition) {
		fPatternCondition = condition;
	}

	// @SuppressWarnings("unchecked")
	// private void readObject(ObjectInputStream stream) throws IOException,
	// ClassNotFoundException {
	// ObjectInputStream.GetField fields = stream.readFields();
	// this.fPatternMap = new PatternMap();
	// if (fLhsPatternExpr != null) {
	// init(fLhsPatternExpr);
	// }
	// }
    @Override
    public boolean test(final IExpr leftHandSide) {
        return test(leftHandSide, EvalEngine.get());
    }

    @Override
    public boolean test(final IExpr leftHandSide, EvalEngine engine) {
        if (isRuleWithoutPatterns()) {
            // no patterns found match equally:
            return fLhsPatternExpr.equals(leftHandSide);
        }

        fPatternMap.initPattern();
        return matchExpr(fLhsPatternExpr, leftHandSide, engine);
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(fLhsPatternExpr);
        objectOutput.writeObject(fPatternCondition);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        PatternMatcher other = (PatternMatcher) obj;
        if (fPatternCondition == null) {
            if (other.fPatternCondition != null)
                return false;
        } else if (!fPatternCondition.equals(other.fPatternCondition))
            return false;
        // if (fPatternMap == null) {
        // if (other.fPatternMap != null)
        // return false;
        // } else if (!fPatternMap.equals(other.fPatternMap))
        // return false;
        // if (fPriority != other.fPriority)
        // return false;
        return true;
    }

}