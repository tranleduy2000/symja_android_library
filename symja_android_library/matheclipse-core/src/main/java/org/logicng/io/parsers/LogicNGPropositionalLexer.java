// Generated from LogicNGPropositional.g4 by ANTLR 4.7

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
public class LogicNGPropositionalLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VARIABLE=1, TRUE=2, FALSE=3, LBR=4, RBR=5, NOT=6, AND=7, OR=8, IMPL=9, 
		EQUIV=10, WS=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"VARIABLE", "TRUE", "FALSE", "LBR", "RBR", "NOT", "AND", "OR", "IMPL", 
		"EQUIV", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'$true'", "'$false'", "'('", "')'", "'~'", "'&'", "'|'", 
		"'=>'", "'<=>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "VARIABLE", "TRUE", "FALSE", "LBR", "RBR", "NOT", "AND", "OR", "IMPL", 
		"EQUIV", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
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

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	private FormulaFactory f;

	public void setFormulaFactory(final FormulaFactory f) {
	  this.f = f;
	}


	public LogicNGPropositionalLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LogicNGPropositional.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\rE\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\6\f@\n\f\r\f\16\fA\3\f\3\f\2\2\r"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\3\2\5\5\2B\\aac|\6"+
		"\2\62;C\\aac|\5\2\13\f\17\17\"\"\2F\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\3\31\3\2\2\2\5 \3\2\2\2\7&\3\2\2\2"+
		"\t-\3\2\2\2\13/\3\2\2\2\r\61\3\2\2\2\17\63\3\2\2\2\21\65\3\2\2\2\23\67"+
		"\3\2\2\2\25:\3\2\2\2\27?\3\2\2\2\31\35\t\2\2\2\32\34\t\3\2\2\33\32\3\2"+
		"\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36\4\3\2\2\2\37\35\3\2"+
		"\2\2 !\7&\2\2!\"\7v\2\2\"#\7t\2\2#$\7w\2\2$%\7g\2\2%\6\3\2\2\2&\'\7&\2"+
		"\2\'(\7h\2\2()\7c\2\2)*\7n\2\2*+\7u\2\2+,\7g\2\2,\b\3\2\2\2-.\7*\2\2."+
		"\n\3\2\2\2/\60\7+\2\2\60\f\3\2\2\2\61\62\7\u0080\2\2\62\16\3\2\2\2\63"+
		"\64\7(\2\2\64\20\3\2\2\2\65\66\7~\2\2\66\22\3\2\2\2\678\7?\2\289\7@\2"+
		"\29\24\3\2\2\2:;\7>\2\2;<\7?\2\2<=\7@\2\2=\26\3\2\2\2>@\t\4\2\2?>\3\2"+
		"\2\2@A\3\2\2\2A?\3\2\2\2AB\3\2\2\2BC\3\2\2\2CD\b\f\2\2D\30\3\2\2\2\5\2"+
		"\35A\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}