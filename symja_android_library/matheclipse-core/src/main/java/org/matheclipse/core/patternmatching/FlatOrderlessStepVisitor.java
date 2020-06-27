package org.matheclipse.core.patternmatching;

import org.matheclipse.core.combinatoric.IStepVisitor;
import org.matheclipse.core.combinatoric.MultisetPartitionsIterator;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.patternmatching.PatternMatcher.StackMatcher;

/**
 * This visitor is used in an <code>MultisetPartitionsIterator</code> to match flat and orderless expressions in pattern
 * matching.
 * 
 * @see PatternMatcher
 * @see MultisetPartitionsIterator
 */
public class FlatOrderlessStepVisitor extends FlatStepVisitor implements IStepVisitor {
	protected int[] multiset;

	/**
	 *
	 * @param sym
	 * @param lhsPatternAST
	 * @param lhsEvalAST
	 * @param patternMatcher
	 * @param patternMap
	 * @deprecated used only for JUnit tests
	 */
	public FlatOrderlessStepVisitor(final ISymbol sym, IAST lhsPatternAST, IAST lhsEvalAST,
			PatternMatcher patternMatcher, IPatternMap patternMap) {
		this(sym, lhsPatternAST, lhsEvalAST, //
				patternMatcher.new StackMatcher(EvalEngine.get()), patternMap);
	}
	public FlatOrderlessStepVisitor(final ISymbol sym, IAST lhsPatternAST, IAST lhsEvalAST, StackMatcher stackMatcher,
			IPatternMap patternMap) {
		super(sym, lhsPatternAST, lhsEvalAST, stackMatcher, patternMap);
		toIntArray(lhsEvalAST, 1, lhsEvalAST.size());
	}

	public FlatOrderlessStepVisitor(final ISymbol sym, IAST lhsPatternAST, IAST lhsEvalAST, StackMatcher stackMatcher,
			IPatternMap patternMap, boolean oneIdentity) {
		super(sym, lhsPatternAST, lhsEvalAST, stackMatcher, patternMap, oneIdentity);
		toIntArray(lhsEvalAST, 1, lhsEvalAST.size());
	}
	
	/**
	 * Convert the <code>sortedList</code> to an <code>int[]</code> array. Equal elements get the same index in the
	 * resulting <code>int[]</code> array.
	 *
	 * @param sortedList
	 * @param start
	 * @param end
	 * @return
	 */
	final private void toIntArray(IAST sortedList, int start, int end) {
		multiset = new int[end - start];
		array = new IExpr[end - start];
		/*final*/ IExpr/*[]*/ lastT /*= new IExpr[1]*/;
		lastT/*[0]*/ = sortedList.get(start);

		/*final*/ int/*[]*/ index /*= new int[1]*/ = 0;
		/*final*/ int/*[]*/ j = /*new int[1]*/ 0;
		multiset[j/*[0]*/++] = index/*[0]*/;
		array[index/*[0]*/] = lastT/*[0]*/;
		// swift changed: memory issue
		// sortedList.forEach(start + 1, end, new Consumer<IExpr>() {
		// 	@Override
		// 	public void accept(IExpr x) {
		for (int i = start + 1; i < end; i++) {
			IExpr x = sortedList.get(i);
			if (x.equals(lastT/*[0]*/)) {
				multiset[j/*[0]*/++] = index/*[0]*/;
			} else {
				multiset[j/*[0]*/++] = ++index/*[0]*/;
				array[index/*[0]*/] = x;
				lastT/*[0]*/ = x;
			}
		}
		//});
	}

	@Override
	public int[] getMultisetArray() {
		return multiset;
	}
}
