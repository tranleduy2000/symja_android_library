// Generated from LogicNGPropositional.g4 by ANTLR 4.7

package org.logicng.io.parsers;

import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.logicng.formulas.Formula;
import org.logicng.formulas.FormulaFactory;

import java.util.LinkedHashSet;
import java.util.List;

public class LogicNGPropositionalParser extends Parser {
    public static final int
            VARIABLE = 1, TRUE = 2, FALSE = 3, LBR = 4, RBR = 5, NOT = 6, AND = 7, OR = 8, IMPL = 9,
            EQUIV = 10, WS = 11;
    public static final int
            RULE_formula = 0, RULE_constant = 1, RULE_simp = 2, RULE_lit = 3, RULE_conj = 4,
            RULE_disj = 5, RULE_impl = 6, RULE_equiv = 7;
    public static final String[] ruleNames = {
            "formula", "constant", "simp", "lit", "conj", "disj", "impl", "equiv"
    };
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\rd\4\2\t\2\4\3\t" +
                    "\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\3\2" +
                    "\3\2\5\2\31\n\2\3\3\3\3\3\3\3\3\5\3\37\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4" +
                    "\3\4\3\4\3\4\5\4+\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\64\n\5\3\6\3\6\3" +
                    "\6\3\6\3\6\3\6\7\6<\n\6\f\6\16\6?\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7" +
                    "\7\7I\n\7\f\7\16\7L\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\5\bV\n\b\3\b" +
                    "\3\b\3\t\3\t\3\t\3\t\3\t\3\t\5\t`\n\t\3\t\3\t\3\t\2\2\n\2\4\6\b\n\f\16" +
                    "\20\2\2\2d\2\30\3\2\2\2\4\36\3\2\2\2\6*\3\2\2\2\b\63\3\2\2\2\n\65\3\2" +
                    "\2\2\fB\3\2\2\2\16O\3\2\2\2\20Y\3\2\2\2\22\23\7\2\2\3\23\31\b\2\1\2\24" +
                    "\25\5\20\t\2\25\26\7\2\2\3\26\27\b\2\1\2\27\31\3\2\2\2\30\22\3\2\2\2\30" +
                    "\24\3\2\2\2\31\3\3\2\2\2\32\33\7\4\2\2\33\37\b\3\1\2\34\35\7\5\2\2\35" +
                    "\37\b\3\1\2\36\32\3\2\2\2\36\34\3\2\2\2\37\5\3\2\2\2 !\7\3\2\2!+\b\4\1" +
                    "\2\"#\5\4\3\2#$\b\4\1\2$+\3\2\2\2%&\7\6\2\2&\'\5\20\t\2\'(\7\7\2\2()\b" +
                    "\4\1\2)+\3\2\2\2* \3\2\2\2*\"\3\2\2\2*%\3\2\2\2+\7\3\2\2\2,-\7\b\2\2-" +
                    ".\5\b\5\2./\b\5\1\2/\64\3\2\2\2\60\61\5\6\4\2\61\62\b\5\1\2\62\64\3\2" +
                    "\2\2\63,\3\2\2\2\63\60\3\2\2\2\64\t\3\2\2\2\65\66\5\b\5\2\66=\b\6\1\2" +
                    "\678\7\t\2\289\5\b\5\29:\b\6\1\2:<\3\2\2\2;\67\3\2\2\2\3\2\2\2>@\3\2\2\2?=\3\2\2\2@A\b\6\1\2A\13\3\2\2\2BC\5\n\6\2CJ\b" +
                    "\7\1\2DE\7\n\2\2EF\5\n\6\2FG\b\7\1\2GI\3\2\2\2HD\3\2\2\2IL\3\2\2\2JH\3" +
                    "\2\2\2JK\3\2\2\2KM\3\2\2\2LJ\3\2\2\2MN\b\7\1\2N\r\3\2\2\2OP\5\f\7\2PU" +
                    "\b\b\1\2QR\7\13\2\2RS\5\16\b\2ST\b\b\1\2TV\3\2\2\2UQ\3\2\2\2UV\3\2\2\2" +
                    "VW\3\2\2\2WX\b\b\1\2X\17\3\2\2\2YZ\5\16\b\2Z_\b\t\1\2[\\\7\f\2\2\\]\5" +
                    "\20\t\2]^\b\t\1\2^`\3\2\2\2_[\3\2\2\2_`\3\2\2\2`a\3\2\2\2ab\b\t\1\2b\21" +
                    "\3\2\2\2\n\30\36*\63=JU_";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = {
            null, null, "'$true'", "'$false'", "'('", "')'", "'~'", "'&'", "'|'",
            "'=>'", "'<=>'"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, "VARIABLE", "TRUE", "FALSE", "LBR", "RBR", "NOT", "AND", "OR", "IMPL",
            "EQUIV", "WS"
    };
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    static {
        RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION);
    }

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "";
            }
        }
    }

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    private FormulaFactory f;

    public LogicNGPropositionalParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "LogicNGPropositional.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public void setFormulaFactory(final FormulaFactory f) {
        this.f = f;
    }

    public final FormulaContext formula() throws RecognitionException {
        FormulaContext _localctx = new FormulaContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_formula);
        try {
            setState(22);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case EOF:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(16);
                    match(EOF);
                    ((FormulaContext) _localctx).f = f.verum();
                }
                break;
                case VARIABLE:
                case TRUE:
                case FALSE:
                case LBR:
                case NOT:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(18);
                    ((FormulaContext) _localctx).equiv = equiv();
                    setState(19);
                    match(EOF);
                    ((FormulaContext) _localctx).f = ((FormulaContext) _localctx).equiv.f;
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ConstantContext constant() throws RecognitionException {
        ConstantContext _localctx = new ConstantContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_constant);
        try {
            setState(28);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case TRUE:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(24);
                    match(TRUE);
                    ((ConstantContext) _localctx).f = f.verum();
                }
                break;
                case FALSE:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(26);
                    match(FALSE);
                    ((ConstantContext) _localctx).f = f.falsum();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final SimpContext simp() throws RecognitionException {
        SimpContext _localctx = new SimpContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_simp);
        try {
            setState(40);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case VARIABLE:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(30);
                    ((SimpContext) _localctx).VARIABLE = match(VARIABLE);
                    ((SimpContext) _localctx).f = f.literal((((SimpContext) _localctx).VARIABLE != null ? ((SimpContext) _localctx).VARIABLE.getText() : null), true);
                }
                break;
                case TRUE:
                case FALSE:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(32);
                    ((SimpContext) _localctx).constant = constant();
                    ((SimpContext) _localctx).f = ((SimpContext) _localctx).constant.f;
                }
                break;
                case LBR:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(35);
                    match(LBR);
                    setState(36);
                    ((SimpContext) _localctx).equiv = equiv();
                    setState(37);
                    match(RBR);
                    ((SimpContext) _localctx).f = ((SimpContext) _localctx).equiv.f;
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LitContext lit() throws RecognitionException {
        LitContext _localctx = new LitContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_lit);
        try {
            setState(49);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case NOT:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(42);
                    match(NOT);
                    setState(43);
                    ((LitContext) _localctx).a = lit();
                    ((LitContext) _localctx).f = f.not(((LitContext) _localctx).a.f);
                }
                break;
                case VARIABLE:
                case TRUE:
                case FALSE:
                case LBR:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(46);
                    ((LitContext) _localctx).simp = simp();
                    ((LitContext) _localctx).f = ((LitContext) _localctx).simp.f;
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ConjContext conj() throws RecognitionException {
        ConjContext _localctx = new ConjContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_conj);
        LinkedHashSet literals = new LinkedHashSet<>();
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(51);
                ((ConjContext) _localctx).a = lit();
                literals.add(((ConjContext) _localctx).a.f);
                setState(59);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == AND) {
                    {
                        {
                            setState(53);
                            match(AND);
                            setState(54);
                            ((ConjContext) _localctx).b = lit();
                            literals.add(((ConjContext) _localctx).b.f);
                        }
                    }
                    setState(61);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                ((ConjContext) _localctx).f = f.and(literals);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DisjContext disj() throws RecognitionException {
        DisjContext _localctx = new DisjContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_disj);
        LinkedHashSet conjunctions = new LinkedHashSet<>();
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(64);
                ((DisjContext) _localctx).a = conj();
                conjunctions.add(((DisjContext) _localctx).a.f);
                setState(72);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OR) {
                    {
                        {
                            setState(66);
                            match(OR);
                            setState(67);
                            ((DisjContext) _localctx).b = conj();
                            conjunctions.add(((DisjContext) _localctx).b.f);
                        }
                    }
                    setState(74);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                ((DisjContext) _localctx).f = f.or(conjunctions);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ImplContext impl() throws RecognitionException {
        ImplContext _localctx = new ImplContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_impl);
        Formula[] operands = new Formula[2];
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(77);
                ((ImplContext) _localctx).a = disj();
                operands[0] = ((ImplContext) _localctx).a.f;
                setState(83);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == IMPL) {
                    {
                        setState(79);
                        match(IMPL);
                        setState(80);
                        ((ImplContext) _localctx).b = impl();
                        operands[1] = ((ImplContext) _localctx).b.f;
                    }
                }

                ((ImplContext) _localctx).f = operands[1] == null ? operands[0] : f.implication(operands[0], operands[1]);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final EquivContext equiv() throws RecognitionException {
        EquivContext _localctx = new EquivContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_equiv);
        Formula[] operands = new Formula[2];
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(87);
                ((EquivContext) _localctx).a = impl();
                operands[0] = ((EquivContext) _localctx).a.f;
                setState(93);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == EQUIV) {
                    {
                        setState(89);
                        match(EQUIV);
                        setState(90);
                        ((EquivContext) _localctx).b = equiv();
                        operands[1] = ((EquivContext) _localctx).b.f;
                    }
                }

                ((EquivContext) _localctx).f = operands[1] == null ? operands[0] : f.equivalence(operands[0], operands[1]);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FormulaContext extends ParserRuleContext {
        public Formula f;
        public EquivContext equiv;

        public FormulaContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode EOF() {
            return getToken(LogicNGPropositionalParser.EOF, 0);
        }

        public EquivContext equiv() {
            return getRuleContext(EquivContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_formula;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPropositionalListener)
                ((LogicNGPropositionalListener) listener).enterFormula(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPropositionalListener)
                ((LogicNGPropositionalListener) listener).exitFormula(this);
        }
    }

    public static class ConstantContext extends ParserRuleContext {
        public Formula f;

        public ConstantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode TRUE() {
            return getToken(LogicNGPropositionalParser.TRUE, 0);
        }

        public TerminalNode FALSE() {
            return getToken(LogicNGPropositionalParser.FALSE, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPropositionalListener)
                ((LogicNGPropositionalListener) listener).enterConstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPropositionalListener)
                ((LogicNGPropositionalListener) listener).exitConstant(this);
        }
    }

    public static class SimpContext extends ParserRuleContext {
        public Formula f;
        public Token VARIABLE;
        public ConstantContext constant;
        public EquivContext equiv;

        public SimpContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode VARIABLE() {
            return getToken(LogicNGPropositionalParser.VARIABLE, 0);
        }

        public ConstantContext constant() {
            return getRuleContext(ConstantContext.class, 0);
        }

        public TerminalNode LBR() {
            return getToken(LogicNGPropositionalParser.LBR, 0);
        }

        public EquivContext equiv() {
            return getRuleContext(EquivContext.class, 0);
        }

        public TerminalNode RBR() {
            return getToken(LogicNGPropositionalParser.RBR, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_simp;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPropositionalListener)
                ((LogicNGPropositionalListener) listener).enterSimp(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPropositionalListener)
                ((LogicNGPropositionalListener) listener).exitSimp(this);
        }
    }

    public static class LitContext extends ParserRuleContext {
        public Formula f;
        public LitContext a;
        public SimpContext simp;

        public LitContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode NOT() {
            return getToken(LogicNGPropositionalParser.NOT, 0);
        }

        public LitContext lit() {
            return getRuleContext(LitContext.class, 0);
        }

        public SimpContext simp() {
            return getRuleContext(SimpContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_lit;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPropositionalListener)
                ((LogicNGPropositionalListener) listener).enterLit(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPropositionalListener)
                ((LogicNGPropositionalListener) listener).exitLit(this);
        }
    }

    public static class ConjContext extends ParserRuleContext {
        public Formula f;
        public LitContext a;
        public LitContext b;

        public ConjContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List lit() {
            return getRuleContexts(LitContext.class);
        }

        public LitContext lit(int i) {
            return getRuleContext(LitContext.class, i);
        }

        public List AND() {
            return getTokens(LogicNGPropositionalParser.AND);
        }

        public TerminalNode AND(int i) {
            return getToken(LogicNGPropositionalParser.AND, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_conj;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPropositionalListener)
                ((LogicNGPropositionalListener) listener).enterConj(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPropositionalListener)
                ((LogicNGPropositionalListener) listener).exitConj(this);
        }
    }

    public static class DisjContext extends ParserRuleContext {
        public Formula f;
        public ConjContext a;
        public ConjContext b;

        public DisjContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List conj() {
            return getRuleContexts(ConjContext.class);
        }

        public ConjContext conj(int i) {
            return getRuleContext(ConjContext.class, i);
        }

        public List OR() {
            return getTokens(LogicNGPropositionalParser.OR);
        }

        public TerminalNode OR(int i) {
            return getToken(LogicNGPropositionalParser.OR, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_disj;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPropositionalListener)
                ((LogicNGPropositionalListener) listener).enterDisj(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPropositionalListener)
                ((LogicNGPropositionalListener) listener).exitDisj(this);
        }
    }

    public static class ImplContext extends ParserRuleContext {
        public Formula f;
        public DisjContext a;
        public ImplContext b;

        public ImplContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public DisjContext disj() {
            return getRuleContext(DisjContext.class, 0);
        }

        public TerminalNode IMPL() {
            return getToken(LogicNGPropositionalParser.IMPL, 0);
        }

        public ImplContext impl() {
            return getRuleContext(ImplContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_impl;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPropositionalListener)
                ((LogicNGPropositionalListener) listener).enterImpl(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPropositionalListener)
                ((LogicNGPropositionalListener) listener).exitImpl(this);
        }
    }

    public static class EquivContext extends ParserRuleContext {
        public Formula f;
        public ImplContext a;
        public EquivContext b;

        public EquivContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ImplContext impl() {
            return getRuleContext(ImplContext.class, 0);
        }

        public TerminalNode EQUIV() {
            return getToken(LogicNGPropositionalParser.EQUIV, 0);
        }

        public EquivContext equiv() {
            return getRuleContext(EquivContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_equiv;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPropositionalListener)
                ((LogicNGPropositionalListener) listener).enterEquiv(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPropositionalListener)
                ((LogicNGPropositionalListener) listener).exitEquiv(this);
        }
    }
}