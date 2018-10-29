// Generated from LogicNGPseudoBoolean.g4 by ANTLR 4.7

package org.logicng.io.parsers;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LogicNGPseudoBooleanParser}.
 */
public interface LogicNGPseudoBooleanListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LogicNGPseudoBooleanParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterFormula(LogicNGPseudoBooleanParser.FormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogicNGPseudoBooleanParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitFormula(LogicNGPseudoBooleanParser.FormulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogicNGPseudoBooleanParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(LogicNGPseudoBooleanParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogicNGPseudoBooleanParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(LogicNGPseudoBooleanParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogicNGPseudoBooleanParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(LogicNGPseudoBooleanParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogicNGPseudoBooleanParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(LogicNGPseudoBooleanParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogicNGPseudoBooleanParser#simp}.
	 * @param ctx the parse tree
	 */
	void enterSimp(LogicNGPseudoBooleanParser.SimpContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogicNGPseudoBooleanParser#simp}.
	 * @param ctx the parse tree
	 */
	void exitSimp(LogicNGPseudoBooleanParser.SimpContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogicNGPseudoBooleanParser#lit}.
	 * @param ctx the parse tree
	 */
	void enterLit(LogicNGPseudoBooleanParser.LitContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogicNGPseudoBooleanParser#lit}.
	 * @param ctx the parse tree
	 */
	void exitLit(LogicNGPseudoBooleanParser.LitContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogicNGPseudoBooleanParser#conj}.
	 * @param ctx the parse tree
	 */
	void enterConj(LogicNGPseudoBooleanParser.ConjContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogicNGPseudoBooleanParser#conj}.
	 * @param ctx the parse tree
	 */
	void exitConj(LogicNGPseudoBooleanParser.ConjContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogicNGPseudoBooleanParser#disj}.
	 * @param ctx the parse tree
	 */
	void enterDisj(LogicNGPseudoBooleanParser.DisjContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogicNGPseudoBooleanParser#disj}.
	 * @param ctx the parse tree
	 */
	void exitDisj(LogicNGPseudoBooleanParser.DisjContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogicNGPseudoBooleanParser#impl}.
	 * @param ctx the parse tree
	 */
	void enterImpl(LogicNGPseudoBooleanParser.ImplContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogicNGPseudoBooleanParser#impl}.
	 * @param ctx the parse tree
	 */
	void exitImpl(LogicNGPseudoBooleanParser.ImplContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogicNGPseudoBooleanParser#equiv}.
	 * @param ctx the parse tree
	 */
	void enterEquiv(LogicNGPseudoBooleanParser.EquivContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogicNGPseudoBooleanParser#equiv}.
	 * @param ctx the parse tree
	 */
	void exitEquiv(LogicNGPseudoBooleanParser.EquivContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogicNGPseudoBooleanParser#mul}.
	 * @param ctx the parse tree
	 */
	void enterMul(LogicNGPseudoBooleanParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogicNGPseudoBooleanParser#mul}.
	 * @param ctx the parse tree
	 */
	void exitMul(LogicNGPseudoBooleanParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogicNGPseudoBooleanParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(LogicNGPseudoBooleanParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogicNGPseudoBooleanParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(LogicNGPseudoBooleanParser.AddContext ctx);
}
