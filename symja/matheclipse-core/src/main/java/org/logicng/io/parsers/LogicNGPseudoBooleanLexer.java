package org.logicng.io.parsers;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.logicng.formulas.FormulaFactory;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LogicNGPseudoBooleanLexer extends Lexer {
    public static final int
            NUMBER = 1, LITERAL = 2, TRUE = 3, FALSE = 4, LBR = 5, RBR = 6, NOT = 7, AND = 8, OR = 9,
            IMPL = 10, EQUIV = 11, MUL = 12, ADD = 13, EQ = 14, LE = 15, LT = 16, GE = 17, GT = 18,
            WS = 19;
    public static final String[] ruleNames = {
            "NUMBER", "LITERAL", "TRUE", "FALSE", "LBR", "RBR", "NOT", "AND", "OR",
            "IMPL", "EQUIV", "MUL", "ADD", "EQ", "LE", "LT", "GE", "GT", "WS"
    };
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25p\b\1\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\3\2\5\2+\n\2\3\2\6\2.\n\2\r\2\16\2/\3\3\5\3\63\n" +
                    "\3\3\3\3\3\7\3\67\n\3\f\3\16\3:\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3" +
                    "\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3" +
                    "\13\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3" +
                    "\21\3\22\3\22\3\22\3\23\3\23\3\24\6\24k\n\24\r\24\16\24l\3\24\3\24\2\2" +
                    "\25\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35" +
                    "\20\37\21!\22#\23%\24\'\25\3\2\t\3\2//\3\2\62;\3\2\u0080\u0080\5\2B\\" +
                    "aac|\6\2\62;C\\aac|\4\2--//\5\2\13\f\17\17\"\"\2t\2\3\3\2\2\2\2\5\3\2" +
                    "\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21" +
                    "\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2" +
                    "\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3" +
                    "\2\2\2\3*\3\2\2\2\5\62\3\2\2\2\7;\3\2\2\2\tA\3\2\2\2\13H\3\2\2\2\rJ\3" +
                    "\2\2\2\17L\3\2\2\2\21N\3\2\2\2\23P\3\2\2\2\25R\3\2\2\2\27U\3\2\2\2\31" +
                    "Y\3\2\2\2\33[\3\2\2\2\35]\3\2\2\2\37_\3\2\2\2!b\3\2\2\2#d\3\2\2\2%g\3" +
                    "\2\2\2\'j\3\2\2\2)+\t\2\2\2*)\3\2\2\2*+\3\2\2\2+-\3\2\2\2,.\t\3\2\2-," +
                    "\3\2\2\2./\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\4\3\2\2\2\61\63\t\4\2\2\62" +
                    "\61\3\2\2\2\62\63\3\2\2\2\63\64\3\2\2\2\648\t\5\2\2\65\67\t\6\2\2\66\65" +
                    "\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29\6\3\2\2\2:8\3\2\2\2;<\7&\2" +
                    "\2<=\7v\2\2=>\7t\2\2>?\7w\2\2?@\7g\2\2@\b\3\2\2\2AB\7&\2\2BC\7h\2\2CD" +
                    "\7c\2\2DE\7n\2\2EF\7u\2\2FG\7g\2\2G\n\3\2\2\2HI\7*\2\2I\f\3\2\2\2JK\7" +
                    "+\2\2K\16\3\2\2\2LM\7\u0080\2\2M\20\3\2\2\2NO\7(\2\2O\22\3\2\2\2PQ\7~" +
                    "\2\2Q\24\3\2\2\2RS\7?\2\2ST\7@\2\2T\26\3\2\2\2UV\7>\2\2VW\7?\2\2WX\7@" +
                    "\2\2X\30\3\2\2\2YZ\7,\2\2Z\32\3\2\2\2[\\\t\7\2\2\\\34\3\2\2\2]^\7?\2\2" +
                    "^\36\3\2\2\2_`\7>\2\2`a\7?\2\2a \3\2\2\2bc\7>\2\2c\"\3\2\2\2de\7@\2\2" +
                    "ef\7?\2\2f$\3\2\2\2gh\7@\2\2h&\3\2\2\2ik\t\b\2\2ji\3\2\2\2kl\3\2\2\2l" +
                    "j\3\2\2\2lm\3\2\2\2mn\3\2\2\2no\b\24\2\2o(\3\2\2\2\b\2*/\628l\3\b\2\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = {
            null, null, null, "'$true'", "'$false'", "'('", "')'", "'~'", "'&'", "'|'",
            "'=>'", "'<=>'", "'*'", null, "'='", "'<='", "'<'", "'>='", "'>'"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, "NUMBER", "LITERAL", "TRUE", "FALSE", "LBR", "RBR", "NOT", "AND",
            "OR", "IMPL", "EQUIV", "MUL", "ADD", "EQ", "LE", "LT", "GE", "GT", "WS"
    };
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };
    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

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


    public LogicNGPseudoBooleanLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
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

    public void setFormulaFactory(final FormulaFactory f) {
        this.f = f;
    }

    @Override
    public String getGrammarFileName() {
        return "LogicNGPseudoBoolean.g4";
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
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }
}