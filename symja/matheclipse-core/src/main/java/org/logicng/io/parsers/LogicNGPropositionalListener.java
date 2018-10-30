// Generated from LogicNGPropositional.g4 by ANTLR 4.7

package org.logicng.io.parsers;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LogicNGPropositionalParser}.
 */
public interface LogicNGPropositionalListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link LogicNGPropositionalParser#formula}.
     *
     * @param ctx the parse tree
     */
    void enterFormula(LogicNGPropositionalParser.FormulaContext ctx);

    /**
     * Exit a parse tree produced by {@link LogicNGPropositionalParser#formula}.
     *
     * @param ctx the parse tree
     */
    void exitFormula(LogicNGPropositionalParser.FormulaContext ctx);

    /**
     * Enter a parse tree produced by {@link LogicNGPropositionalParser#constant}.
     *
     * @param ctx the parse tree
     */
    void enterConstant(LogicNGPropositionalParser.ConstantContext ctx);

    /**
     * Exit a parse tree produced by {@link LogicNGPropositionalParser#constant}.
     *
     * @param ctx the parse tree
     */
    void exitConstant(LogicNGPropositionalParser.ConstantContext ctx);

    /**
     * Enter a parse tree produced by {@link LogicNGPropositionalParser#simp}.
     *
     * @param ctx the parse tree
     */
    void enterSimp(LogicNGPropositionalParser.SimpContext ctx);

    /**
     * Exit a parse tree produced by {@link LogicNGPropositionalParser#simp}.
     *
     * @param ctx the parse tree
     */
    void exitSimp(LogicNGPropositionalParser.SimpContext ctx);

    /**
     * Enter a parse tree produced by {@link LogicNGPropositionalParser#lit}.
     *
     * @param ctx the parse tree
     */
    void enterLit(LogicNGPropositionalParser.LitContext ctx);

    /**
     * Exit a parse tree produced by {@link LogicNGPropositionalParser#lit}.
     *
     * @param ctx the parse tree
     */
    void exitLit(LogicNGPropositionalParser.LitContext ctx);

    /**
     * Enter a parse tree produced by {@link LogicNGPropositionalParser#conj}.
     *
     * @param ctx the parse tree
     */
    void enterConj(LogicNGPropositionalParser.ConjContext ctx);

    /**
     * Exit a parse tree produced by {@link LogicNGPropositionalParser#conj}.
     *
     * @param ctx the parse tree
     */
    void exitConj(LogicNGPropositionalParser.ConjContext ctx);

    /**
     * Enter a parse tree produced by {@link LogicNGPropositionalParser#disj}.
     *
     * @param ctx the parse tree
     */
    void enterDisj(LogicNGPropositionalParser.DisjContext ctx);

    /**
     * Exit a parse tree produced by {@link LogicNGPropositionalParser#disj}.
     *
     * @param ctx the parse tree
     */
    void exitDisj(LogicNGPropositionalParser.DisjContext ctx);

    /**
     * Enter a parse tree produced by {@link LogicNGPropositionalParser#impl}.
     *
     * @param ctx the parse tree
     */
    void enterImpl(LogicNGPropositionalParser.ImplContext ctx);

    /**
     * Exit a parse tree produced by {@link LogicNGPropositionalParser#impl}.
     *
     * @param ctx the parse tree
     */
    void exitImpl(LogicNGPropositionalParser.ImplContext ctx);

    /**
     * Enter a parse tree produced by {@link LogicNGPropositionalParser#equiv}.
     *
     * @param ctx the parse tree
     */
    void enterEquiv(LogicNGPropositionalParser.EquivContext ctx);

    /**
     * Exit a parse tree produced by {@link LogicNGPropositionalParser#equiv}.
     *
     * @param ctx the parse tree
     */
    void exitEquiv(LogicNGPropositionalParser.EquivContext ctx);
}