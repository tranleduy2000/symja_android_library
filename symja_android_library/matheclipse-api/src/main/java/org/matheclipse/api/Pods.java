package org.matheclipse.api;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

import org.apache.commons.codec.language.Soundex;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.matheclipse.core.convert.AST2Expr;
import org.matheclipse.core.convert.VariablesSet;
import org.matheclipse.core.data.ElementData1;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.MathMLUtilities;
import org.matheclipse.core.eval.TeXUtilities;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.form.Documentation;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IBuiltInSymbol;
import org.matheclipse.core.interfaces.IDiscreteDistribution;
import org.matheclipse.core.interfaces.IDistribution;
import org.matheclipse.core.interfaces.IEvaluator;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IFraction;
import org.matheclipse.core.interfaces.IInteger;
import org.matheclipse.core.patternmatching.Matcher;
import org.matheclipse.core.reflection.system.FunctionExpand;
import org.matheclipse.parser.client.FEConfig;
import org.matheclipse.parser.client.SyntaxError;
import org.matheclipse.parser.trie.Trie;
import org.matheclipse.parser.trie.Tries;

import com.duy.lambda.Predicate;
import com.duy.lambda.Supplier;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Pods {
	// output formats
	public static final String HTML_STR = "html";
	public static final String PLAIN_STR = "plaintext";
	public static final String SYMJA_STR = "sinput";
	public static final String MATHML_STR = "mathml";
	public static final String LATEX_STR = "latex";
	public static final String MARKDOWN_STR = "markdown";
	public static final String MATHCELL_STR = "mathcell";
	public static final String JSXGRAPH_STR = "jsxgraph";
	public static final String PLOTLY_STR = "plotly";

	public static final int HTML = 0x0001;
	public static final int PLAIN = 0x0002;
	public static final int SYMJA = 0x0004;
	public static final int MATHML = 0x0008;
	public static final int LATEX = 0x0010;
	public static final int MARKDOWN = 0x0020;
	public static final int MATHCELL = 0x0040;
	public static final int JSXGRAPH = 0x0080;
	public static final int PLOTLY = 0x0100;
	// output
	public static final String JSON = "JSON";

	public static final Soundex SOUNDEX = new Soundex();
	public static final Trie<String, ArrayList<IPod>> SOUNDEX_MAP = Tries.forStrings();

	private static Supplier<Trie<String, ArrayList<IPod>>> LAZY_SOUNDEX  =  new Supplier<Trie<String, ArrayList<IPod>>>() {
		@Override
		public Trie<String, ArrayList<IPod>> get() {
			return Pods.initSoundex();
		}
	};

	private static Trie<String, ArrayList<IPod>> initSoundex() {
		Map<String, String> map = AST2Expr.PREDEFINED_SYMBOLS_MAP;

		IAST[] list = ElementData1.ELEMENTS;
		for (int i = 0; i < list.length; i++) {
			String keyWord = list[i].arg3().toString();
			addElementData(list[i].arg2().toString().toLowerCase(), keyWord);
			soundexElementData(list[i].arg3().toString(), keyWord);
		}

		for (Map.Entry<String, String> entry : map.entrySet()) {
			soundexHelp(entry.getKey(), entry.getKey());
		}
		// appendSoundex();
		soundexHelp("cosine", "Cos");
		soundexHelp("sine", "Sin");
		soundexHelp("integral", "Integrate");

		return SOUNDEX_MAP;
	}

	private static void soundexHelp(String key, String value) {
		String soundex = SOUNDEX.encode(key);
		ArrayList<IPod> list = SOUNDEX_MAP.get(soundex);
		if (list == null) {
			list = new ArrayList<IPod>();
			list.add(new DocumentationPod(value));
			SOUNDEX_MAP.put(soundex, list);
		} else {
			list.add(new DocumentationPod(value));
		}
	}

	private static void soundexElementData(String key, String value) {
		String soundex = SOUNDEX.encode(key);
		addElementData(soundex, value);
	}

	private static void addElementData(String soundex, String value) {
		ArrayList<IPod> list = SOUNDEX_MAP.get(soundex);
		if (list == null) {
			list = new ArrayList<IPod>();
			list.add(new ElementDataPod(value));
			SOUNDEX_MAP.put(soundex, list);
		} else {
			list.add(new ElementDataPod(value));
		}
	}

	final static String JSXGRAPH_IFRAME = //
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + //
					"\n" + //
					"<!DOCTYPE html PUBLIC\n" + //
					"  \"-//W3C//DTD XHTML 1.1 plus MathML 2.0 plus SVG 1.1//EN\"\n" + //
					"  \"http://www.w3.org/2002/04/xhtml-math-svg/xhtml-math-svg.dtd\">\n" + //
					"\n" + //
					"<html xmlns=\"http://www.w3.org/1999/xhtml\" style=\"width: 100%; height: 100%; margin: 0; padding: 0\">\n"
					+ //
					"<head>\n" + //
					"<meta charset=\"utf-8\">\n" + //
					"<title>JSXGraph</title>\n" + //
					"\n" + //
					"<body style=\"width: 100%; height: 100%; margin: 0; padding: 0\">\n" + //
					"\n" + //
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdnjs.cloudflare.com/ajax/libs/jsxgraph/0.99.7/jsxgraphcore.css\" />\n"
					+ //
					"<script src=\"https://cdn.jsdelivr.net/gh/paulmasson/math@1.2.8/build/math.js\"></script>\n"
					+ "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jsxgraph/0.99.7/jsxgraphcore.js\"\n" + //
					"        type=\"text/javascript\"></script>\n" + //
					"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jsxgraph/0.99.7/geonext.min.js\"\n" + //
					"        type=\"text/javascript\"></script>\n" + //

					"\n" + //
					"<div id=\"jxgbox\" class=\"jxgbox\" style=\"display: flex; width:99%; height:99%; margin: 0; flex-direction: column; overflow: hidden\">\n"
					+ //
					"<script>\n" + //
					"`1`\n" + //
					"</script>\n" + //
					"</div>\n" + //
					"\n" + //
					"</body>\n" + //
					"</html>";//

	protected final static String MATHCELL_IFRAME = //
			// "<html style=\"width: 100%; height: 100%; margin: 0; padding: 0\">\n"
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + //
					"\n" + //
					"<!DOCTYPE html PUBLIC\n" + //
					"  \"-//W3C//DTD XHTML 1.1 plus MathML 2.0 plus SVG 1.1//EN\"\n" + //
					"  \"http://www.w3.org/2002/04/xhtml-math-svg/xhtml-math-svg.dtd\">\n" + //
					"\n" + //
					"<html xmlns=\"http://www.w3.org/1999/xhtml\" style=\"width: 100%; height: 100%; margin: 0; padding: 0\">\n"
					+ //
					"<head>\n" + //
					"<meta charset=\"utf-8\">\n" + //
					"<title>MathCell</title>\n" + //
					"</head>\n" + //
					"\n" + //
					"<body style=\"width: 100%; height: 100%; margin: 0; padding: 0\">\n" + //
					"\n" + //
					"<script src=\"https://cdn.jsdelivr.net/gh/paulmasson/math@1.2.8/build/math.js\"></script>\n" + //
					"<script src=\"https://cdn.jsdelivr.net/gh/paulmasson/mathcell@1.8.8/build/mathcell.js\"></script>\n"
					+ //
					"<script src=\"https://cdn.jsdelivr.net/gh/mathjax/MathJax@2.7.5/MathJax.js?config=TeX-AMS_HTML\"></script>"
					+ //
					"\n" + //
					"<div class=\"mathcell\" style=\"display: flex; width: 100%; height: 100%; margin: 0;  padding: .25in .5in .5in .5in; flex-direction: column; overflow: hidden\">\n"
					+ //
					"<script>\n" + //
					"\n" + //
					"var parent = document.scripts[ document.scripts.length - 1 ].parentNode;\n" + //
					"\n" + //
					"var id = generateId();\n" + //
					"parent.id = id;\n" + //
					"\n" + //
					"`1`\n" + //
					"\n" + //
					"parent.update( id );\n" + //
					"\n" + //
					"</script>\n" + //
					"</div>\n" + //
					"\n" + //
					"</body>\n" + //
					"</html>";//

	protected final static String PLOTLY_IFRAME = //
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + //
					"\n" + //
					"<!DOCTYPE html PUBLIC\n" + //
					"  \"-//W3C//DTD XHTML 1.1 plus MathML 2.0 plus SVG 1.1//EN\"\n" + //
					"  \"http://www.w3.org/2002/04/xhtml-math-svg/xhtml-math-svg.dtd\">\n" + //
					"\n" + //
					"<html xmlns=\"http://www.w3.org/1999/xhtml\" style=\"width: 100%; height: 100%; margin: 0; padding: 0\">\n"
					+ //
					"<head>\n" + //
					"<meta charset=\"utf-8\">\n" + //
					"<title>Plotly</title>\n" + //
					"\n" + //
					"   <script src=\"https://cdn.plot.ly/plotly-latest.min.js\"></script>\n" + //
					"</head>\n" + //
					"<body>\n" + //
					"<div id='plotly' ></div>\n" + //
					"`1`\n" + //
					"</body>\n" + //
					"</html>";//

	static void addSymjaPod(ArrayNode podsArray, IExpr inExpr, IExpr outExpr, String title, String scanner, int formats,
							ObjectMapper mapper, EvalEngine engine) {
		ArrayNode temp = mapper.createArrayNode();
		ObjectNode subpodsResult = mapper.createObjectNode();
		subpodsResult.put("title", title);
		subpodsResult.put("scanner", scanner);
		subpodsResult.put("error", "false");
		subpodsResult.put("numsubpods", 1);
		subpodsResult.putPOJO("subpods", temp);
		podsArray.add(subpodsResult);

		ObjectNode node = mapper.createObjectNode();
		temp.add(node);
		createJSONFormat(node, engine, inExpr.toString(), outExpr, formats);
	}

	static void addSymjaPod(ArrayNode podsArray, IExpr inExpr, IExpr outExpr, String plaintext, String title,
							String scanner, int formats, ObjectMapper mapper, EvalEngine engine) {
		ArrayNode temp = mapper.createArrayNode();
		ObjectNode subpodsResult = mapper.createObjectNode();
		subpodsResult.put("title", title);
		subpodsResult.put("scanner", scanner);
		subpodsResult.put("error", "false");
		subpodsResult.put("numsubpods", 1);
		subpodsResult.putPOJO("subpods", temp);
		podsArray.add(subpodsResult);

		ObjectNode node = mapper.createObjectNode();
		temp.add(node);
		createJSONFormat(node, engine, plaintext, inExpr.toString(), outExpr, formats);
	}

	static void addPod(ArrayNode podsArray, IExpr inExpr, IExpr outExpr, String title, String scanner, int formats,
					   ObjectMapper mapper, EvalEngine engine) {
		ArrayNode temp = mapper.createArrayNode();
		ObjectNode subpodsResult = mapper.createObjectNode();
		subpodsResult.put("title", title);
		subpodsResult.put("scanner", scanner);
		subpodsResult.put("error", "false");
		subpodsResult.put("numsubpods", 1);
		subpodsResult.putPOJO("subpods", temp);
		podsArray.add(subpodsResult);

		ObjectNode node = mapper.createObjectNode();
		temp.add(node);
		createJSONFormat(node, engine, outExpr, formats);
	}

	static void addPod(ArrayNode podsArray, IExpr inExpr, IExpr outExpr, String plaintext, String title, String scanner,
					   int formats, ObjectMapper mapper, EvalEngine engine) {
		ArrayNode temp = mapper.createArrayNode();
		ObjectNode subpodsResult = mapper.createObjectNode();
		subpodsResult.put("title", title);
		subpodsResult.put("scanner", scanner);
		subpodsResult.put("error", "false");
		subpodsResult.put("numsubpods", 1);
		subpodsResult.putPOJO("subpods", temp);
		podsArray.add(subpodsResult);

		ObjectNode node = mapper.createObjectNode();
		temp.add(node);
		createJSONFormat(node, engine, outExpr, plaintext, "", formats);
	}

	static void integerPropertiesPod(ArrayNode podsArray, IInteger inExpr, IExpr outExpr, String title, String scanner,
									 int formats, ObjectMapper mapper, EvalEngine engine) {
		ArrayNode temp = mapper.createArrayNode();
		int numsubpods = 0;
		ObjectNode subpodsResult = mapper.createObjectNode();
		subpodsResult.put("title", title);
		subpodsResult.put("scanner", scanner);
		subpodsResult.put("error", "false");
		subpodsResult.put("numsubpods", numsubpods);
		subpodsResult.putPOJO("subpods", temp);
		podsArray.add(subpodsResult);

		try {
			if (inExpr.isEven()) {
				ObjectNode node = mapper.createObjectNode();
				temp.add(node);
				createJSONFormat(node, engine, F.NIL, inExpr.toString() + " is an even number.", "", PLAIN);

				numsubpods++;
			} else {
				ObjectNode node = mapper.createObjectNode();
				temp.add(node);
				createJSONFormat(node, engine, F.NIL, inExpr.toString() + " is an odd number.", "", PLAIN);

				numsubpods++;
			}
			if (inExpr.isProbablePrime()) {
				IExpr primePi = F.PrimePi.of(engine, inExpr);
				if (primePi.isInteger()) {
					ObjectNode node = mapper.createObjectNode();
					temp.add(node);
					createJSONFormat(node, engine, F.NIL,
							inExpr.toString() + " the " + primePi.toString() + "th prime number.", "", PLAIN);
					numsubpods++;
				} else {
					ObjectNode node = mapper.createObjectNode();
					temp.add(node);
					createJSONFormat(node, engine, F.NIL, inExpr.toString() + " is a prime number.", "", PLAIN);
					numsubpods++;
				}
			}
		} finally {
			subpodsResult.put("numsubpods", numsubpods);
		}
	}

	private static int internFormat(String[] formats) {
		int intern = 0;
		for (String str : formats) {
			intern = internFormat(intern, str);
		}
		return intern;
	}

	private static int internFormat(int intern, String str) {
		if (str.equals(HTML_STR)) {
			intern |= HTML;
		} else if (str.equals(PLAIN_STR)) {
			intern |= PLAIN;
		} else if (str.equals(SYMJA_STR)) {
			intern |= SYMJA;
		} else if (str.equals(MATHML_STR)) {
			intern |= MATHML;
		} else if (str.equals(LATEX_STR)) {
			intern |= LATEX;
		} else if (str.equals(MARKDOWN_STR)) {
			intern |= MARKDOWN;
		} else if (str.equals(MATHCELL_STR)) {
			intern |= MATHCELL;
		} else if (str.equals(JSXGRAPH_STR)) {
			intern |= JSXGRAPH;
		} else if (str.equals(PLOTLY_STR)) {
			intern |= PLOTLY;
		}
		return intern;
	}

	public static ObjectNode createResult(String inputStr, String[] formatStrs) {
		int formats = internFormat(formatStrs);

		ObjectMapper mapper = new ObjectMapper();
		ObjectNode messageJSON = mapper.createObjectNode();

		ObjectNode queryresult = mapper.createObjectNode();
		messageJSON.putPOJO("queryresult", queryresult);
		queryresult.put("success", "false");
		queryresult.put("error", "false");
		queryresult.put("numpods", 0);
		queryresult.put("version", "0.1");

		inputStr = inputStr.trim();
		if (inputStr.length() > Short.MAX_VALUE) {
			queryresult.put("error", "false");
			return messageJSON;
		} else if (inputStr.length() == 0) {
			queryresult.put("error", "false");
			return messageJSON;
		}

		boolean error = false;
		int numpods = 0;
		IExpr inExpr = F.Null;
		IExpr outExpr = F.Null;
		EvalEngine engine = EvalEngine.get();
		try {
			ArrayNode podsArray = mapper.createArrayNode();
			inExpr = parseInput(inputStr, engine);
			if (inExpr.isPresent()) {
				outExpr = inExpr;
				if (inExpr.isNumericFunction()) {
					outExpr = engine.evaluate(inExpr);
				}
				if (outExpr.isNumber()) {
					if (outExpr.isInteger()) {
						numpods = integerPods(podsArray, (IInteger) outExpr, outExpr, formats, mapper, engine);
						resultStatistics(queryresult, error, numpods, podsArray);
						return messageJSON;
					} else {
						IExpr podOut = outExpr;
						addSymjaPod(podsArray, inExpr, inExpr, "Input", "Identity", formats, mapper, engine);
						numpods++;
						if (outExpr.isRational()) {
							addSymjaPod(podsArray, inExpr, podOut, "Exact result", "Rational", formats, mapper, engine);
							numpods++;
						}

						inExpr = F.N(outExpr);
						podOut = engine.evaluate(inExpr);
						addSymjaPod(podsArray, inExpr, podOut, "Decimal form", "Numeric", formats, mapper, engine);
						numpods++;

						if (outExpr.isFraction()) {
							IFraction frac = (IFraction) outExpr;
							if (!frac.integerPart().equals(F.C0)) {
								inExpr = F.List(F.IntegerPart(outExpr), F.FractionalPart(outExpr));
								podOut = engine.evaluate(inExpr);
								String plaintext = podOut.first().toString() + " " + podOut.second().toString();
								addSymjaPod(podsArray, inExpr, podOut, plaintext, "Mixed fraction", "Rational", formats,
										mapper, engine);
								numpods++;

								inExpr = F.ContinuedFraction(outExpr);
								podOut = engine.evaluate(inExpr);
								StringBuilder plainBuf = new StringBuilder();
								if (podOut.isList() && podOut.size() > 1) {
									IAST list = (IAST) podOut;
									plainBuf.append('[');
									plainBuf.append(list.arg1().toString());
									plainBuf.append(';');
									for (int i = 2; i < list.size(); i++) {
										plainBuf.append(' ');
										plainBuf.append(list.get(i).toString());
										if (i < list.size() - 1) {
											plainBuf.append(',');
										}
									}
									plainBuf.append(']');
								}
								addSymjaPod(podsArray, inExpr, podOut, plainBuf.toString(), "Continued fraction",
										"ContinuedFraction", formats, mapper, engine);
								numpods++;
							}
						}

						resultStatistics(queryresult, error, numpods, podsArray);
						return messageJSON;
					}
				} else {
					if (inExpr.isList()) {
						IAST list = (IAST) inExpr;
						boolean intList = list.forAll(new Predicate<IExpr>() {
							@Override
							public boolean test(IExpr x) {
								return x.isInteger();
							}
						});
						outExpr = inExpr;
						if (intList) {
							numpods = integerListPods(podsArray, inExpr, list, formats, mapper, engine);
							resultStatistics(queryresult, error, numpods, podsArray);
							return messageJSON;
						}
						if (list.argSize() == 2) {
							VariablesSet varSet = new VariablesSet(list);
							IAST variables = varSet.getVarList();
							if (variables.argSize() == 1) {
								IExpr arg1 = list.arg1();
								IExpr arg2 = list.arg2();
								if (arg1.isNumericFunction(varSet) && arg2.isNumericFunction(varSet)) {
									boolean isPoly1 = arg1.isPolynomial(variables);
									boolean isPoly2 = arg2.isPolynomial(variables);
									if (isPoly1 && isPoly2) {
										inExpr = F.PolynomialQuotientRemainder(arg1, arg2, variables.arg1());
										IExpr podOut = engine.evaluate(inExpr);
										addSymjaPod(podsArray, inExpr, podOut, "Polynomial quotient and remainder",
												"Polynomial", formats, mapper, engine);
										numpods++;
									}
								}
							}
						}
					}

					if (inExpr.isSymbol() || inExpr.isString()) {
						String inputWord = inExpr.toString();
						StringBuilder buf = new StringBuilder();
						if (Documentation.printDocumentation(buf, inputWord)) {
							DocumentationPod.addDocumentationPod(mapper, podsArray, buf, formats);
							numpods++;
							resultStatistics(queryresult, error, numpods, podsArray);
							return messageJSON;
						} else {
							ArrayList<IPod> soundsLike = listOfPods(inputWord);
							if (soundsLike != null) {
								boolean evaled = false;
								for (int i = 0; i < soundsLike.size(); i++) {
									IPod pod = soundsLike.get(i);
									if (pod.keyWord().equalsIgnoreCase(inputWord)) {
										int numberOfEntries = pod.addJSON(mapper, podsArray, formats, engine);
										if (numberOfEntries > 0) {
											numpods += numberOfEntries;
											evaled = true;
											break;
										}
									}
								}
								if (!evaled) {
									for (int i = 0; i < soundsLike.size(); i++) {
										IPod pod = soundsLike.get(i);
										int numberOfEntries = pod.addJSON(mapper, podsArray, formats, engine);
										if (numberOfEntries > 0) {
											numpods += numberOfEntries;
										}
									}
								}
								resultStatistics(queryresult, error, numpods, podsArray);
								return messageJSON;
							}
						}
					} else {
						if (inExpr.isAST(F.D, 3)) {
							outExpr = engine.evaluate(inExpr);
							IExpr podOut = outExpr;
							addSymjaPod(podsArray, inExpr, podOut, "Derivative", "Derivative", formats, mapper, engine);
							numpods++;

							if (outExpr.isFreeAST(new Predicate<IExpr>() {
								@Override
								public boolean test(IExpr x) {
									return x.isTrigFunction();
								}
							})) {
								inExpr = F.TrigToExp(outExpr);
								podOut = engine.evaluate(inExpr);
								if (!F.PossibleZeroQ.ofQ(engine, F.Subtract(podOut, outExpr))) {
									addSymjaPod(podsArray, inExpr, podOut, "Alternate form", "Simplification", formats,
											mapper, engine);
									numpods++;
								}
							}
							resultStatistics(queryresult, error, numpods, podsArray);
							return messageJSON;
						} else {
							outExpr = engine.evaluate(inExpr);
							if (outExpr.isAST(F.JSFormData, 3)) {
								IExpr podOut = outExpr;
								int form = internFormat(0, podOut.second().toString());
								addPod(podsArray, inExpr, podOut, podOut.first().toString(), "Function", "Plotter",
										form, mapper, engine);
								numpods++;
							} else {
								IExpr podOut = outExpr;
								addSymjaPod(podsArray, inExpr, podOut, "Input", "Identity", formats, mapper, engine);
								numpods++;

								IExpr head = outExpr.head();
								if (head instanceof IBuiltInSymbol) {
									IEvaluator evaluator = ((IBuiltInSymbol) head).getEvaluator();
									if (evaluator instanceof IDistribution) {
//										if (evaluator instanceof IDiscreteDistribution) {
										int snumpods = statisticsPods(podsArray, inExpr, podOut, formats, mapper,
												engine);

										numpods+=snumpods;
									}
								}

								VariablesSet varSet = new VariablesSet(outExpr);
								IAST variables = varSet.getVarList();
								if (outExpr.isAST(F.Equal, 3)) {
									IExpr arg1 = outExpr.first();
									IExpr arg2 = outExpr.second();
									if (arg1.isNumericFunction(varSet) && //
											arg2.isNumericFunction(varSet)) {
										if (variables.size() == 2) {
											IExpr plot2D = F.Plot(F.List(arg1, arg2),
													F.List(variables.arg1(), F.num(-20), F.num(20)));
											podOut = engine.evaluate(plot2D);
											if (podOut.isAST(F.JSFormData, 3)) {
												int form = internFormat(0, podOut.second().toString());
												addPod(podsArray, inExpr, podOut, podOut.first().toString(), "Function",
														"Plotter", form, mapper, engine);
												numpods++;
											}
										}
										if (!arg1.isZero() && //
												!arg2.isZero()) {
											inExpr = F.Equal(engine.evaluate(F.Subtract(arg1, arg2)), F.C0);
											podOut = inExpr;
											addSymjaPod(podsArray, inExpr, podOut, "Alternate form", "Simplification",
													formats, mapper, engine);
											numpods++;
										}
										inExpr = F.Solve(F.binaryAST2(F.Equal, arg1, arg2), variables);
										podOut = engine.evaluate(inExpr);
										addSymjaPod(podsArray, inExpr, podOut, "Solution", "Reduce", formats, mapper,
												engine);
										numpods++;
									}

									resultStatistics(queryresult, error, numpods, podsArray);
									return messageJSON;
								}

								boolean isNumericFunction = outExpr.isNumericFunction(varSet);
								if (isNumericFunction) {
									if (variables.argSize() == 1) {
										IExpr plot2D = F.Plot(outExpr, F.List(variables.arg1(), F.num(-7), F.num(7)));
										podOut = engine.evaluate(plot2D);
										if (podOut.isAST(F.JSFormData, 3)) {
											int form = internFormat(0, podOut.second().toString());
											addPod(podsArray, inExpr, podOut, podOut.first().toString(), "Function",
													"Plotter", form, mapper, engine);
											numpods++;
										}
									} else if (variables.argSize() == 2) {
										IExpr plot3D = F.Plot3D(outExpr,
												F.List(variables.arg1(), F.num(-3.5), F.num(3.5)),
												F.List(variables.arg2(), F.num(-3.5), F.num(3.5)));
										podOut = engine.evaluate(plot3D);
										if (podOut.isAST(F.JSFormData, 3)) {
											int form = internFormat(0, podOut.second().toString());
											addPod(podsArray, inExpr, podOut, podOut.first().toString(), "3D plot",
													"Plot", form, mapper, engine);
											numpods++;
										}
									}
								}
								if (outExpr.isFreeAST(new Predicate<IExpr>() {
									@Override
									public boolean test(IExpr x) {
										return x.isTrigFunction();
									}
								})) {
									inExpr = F.TrigToExp(outExpr);
									podOut = engine.evaluate(inExpr);
									if (!F.PossibleZeroQ.ofQ(engine, F.Subtract(podOut, outExpr))) {
										addSymjaPod(podsArray, inExpr, podOut, "Alternate form", "Simplification",
												formats, mapper, engine);
										numpods++;
									}
								}

								if (isNumericFunction && variables.argSize() == 1) {
									if (outExpr.isPolynomial(variables)) {
										inExpr = F.Factor(outExpr);
										podOut = engine.evaluate(inExpr);
										addSymjaPod(podsArray, inExpr, podOut, "Factor", "Polynomial", formats, mapper,
												engine);
										numpods++;
									}
									inExpr = F.D(outExpr, variables.arg1());
									podOut = engine.evaluate(inExpr);
									addSymjaPod(podsArray, inExpr, podOut, "Derivative", "Derivative", formats, mapper,
											engine);
									numpods++;

									inExpr = F.Integrate(outExpr, variables.arg1());
									podOut = engine.evaluate(inExpr);
									addSymjaPod(podsArray, inExpr, podOut, "Indefinite integral", "Integral", formats,
											mapper, engine);
									numpods++;
								}
							}

							resultStatistics(queryresult, error, numpods, podsArray);
							return messageJSON;
						}
					}
				}
			}
		} catch (RuntimeException rex) {
			rex.printStackTrace();
			error = true;
			outExpr = F.$Aborted;
		}

		queryresult.put("error", error ? "true" : "false");
		return messageJSON;
	}

	private static int statisticsPods(ArrayNode podsArray, IExpr inExpr, IExpr outExpr, int formats,
			ObjectMapper mapper, EvalEngine engine) {
		int numpods=0;
		  inExpr  = F.PDF(outExpr,F.x);
		IExpr podOut  = engine.evaluate(inExpr);
		addSymjaPod(podsArray, inExpr, podOut, "Probability density function (PDF)", "Statistics", formats, mapper,
				engine);
		numpods++;

		inExpr = F.CDF(outExpr,F.x);
		podOut = engine.evaluate(inExpr);
		addSymjaPod(podsArray, inExpr, podOut, "Cumulative distribution function (CDF)", "Statistics", formats, mapper,
				engine);
		numpods++;
		return numpods;
	}

	private static class LevenshteinDistanceComparator implements Comparator<IPod> {
		static final LevenshteinDistance ld = new LevenshteinDistance(128);

		String str;

		public LevenshteinDistanceComparator(String str) {
			this.str = str;
		}

		@Override
		public int compare(IPod arg0, IPod arg1) {
			int d0 = ld.apply(str, arg0.keyWord());
			int d1 = ld.apply(str, arg1.keyWord());
			return d0 > d1 ? 1 : d0 < d1 ? -1 : 0;
		}

	}

	private static ArrayList<IPod> listOfPods(String inputWord) {
		Map<String, ArrayList<IPod>> map = LAZY_SOUNDEX.get();
		ArrayList<IPod> soundsLike = map.get(inputWord.toLowerCase());
		if (soundsLike == null) {
			soundsLike = map.get(SOUNDEX.encode(inputWord));
		}
		if (soundsLike != null) {
			LevenshteinDistanceComparator ldc = new LevenshteinDistanceComparator(inputWord);
			Collections.sort(soundsLike, ldc);
		}
		return soundsLike;
	}

	private static IExpr parseInput(String inputStr, EvalEngine engine) {
		engine.setPackageMode(false);
		final FuzzyParser parser = new FuzzyParser(engine);
		try {
			IExpr inExpr = parser.parse(inputStr);
			if (inExpr.isList() && inExpr.size() == 2) {
				return inExpr.first();
			}
			return inExpr;
		} catch (SyntaxError se) {
			try {
				IExpr inExpr = parser.parseFuzzyList(inputStr);
				if (inExpr.isList() && inExpr.size() == 2) {
					return inExpr.first();
				}
				return inExpr;
			} catch (SyntaxError syntaxError) {
			} catch (RuntimeException rex) {
				rex.printStackTrace();
			}
		} catch (RuntimeException rex) {
			rex.printStackTrace();
		}
		return F.NIL;
	}

	private static int integerPods(ArrayNode podsArray, IInteger intExpr, IExpr outExpr, int formats,
								   ObjectMapper mapper, EvalEngine engine) {
		int numpods = 0;
		IInteger n = intExpr;
		IExpr inExpr = F.BaseForm(intExpr, F.C2);
		IExpr podOut = engine.evaluate(inExpr);
		addSymjaPod(podsArray, inExpr, podOut, "Binary form", "Integer", formats, mapper, engine);
		numpods++;

		inExpr = F.FactorInteger(n);
		podOut = engine.evaluate(inExpr);
		addSymjaPod(podsArray, inExpr, podOut, "Prime factorization", "Integer", formats, mapper, engine);
		numpods++;

		inExpr = F.Mod(n, F.Range(F.C2, F.C9));
		podOut = engine.evaluate(inExpr);
		addSymjaPod(podsArray, inExpr, podOut, "Residues modulo small integers", "Integer", formats, mapper, engine);
		numpods++;

		integerPropertiesPod(podsArray, intExpr, podOut, "Properties", "Integer", formats, mapper, engine);
		numpods++;

		if (n.isPositive() && n.isLT(F.ZZ(100))) {
			inExpr = F.Union(F.PowerMod(F.Range(F.C0, F.QQ(n, F.C2)), F.C2, n));
			podOut = engine.evaluate(inExpr);
			addSymjaPod(podsArray, inExpr, podOut, "Quadratic residues modulo " + n.toString(), "Integer", formats,
					mapper, engine);
			numpods++;

			if (n.isProbablePrime()) {
				inExpr = F.Select(F.Range(n.add(F.CN1)),
						F.Function(F.Equal(F.MultiplicativeOrder(F.Slot1, n), F.EulerPhi(n))));
				podOut = engine.evaluate(inExpr);
				addSymjaPod(podsArray, inExpr, podOut, "Primitive roots modulo " + n.toString(), "Integer", formats,
						mapper, engine);
				numpods++;
			}
		}
		return numpods;
	}

	private static int integerListPods(ArrayNode podsArray, IExpr inExpr, IAST list, int formats, ObjectMapper mapper,
									   EvalEngine engine) {
		int numpods = 0;
		addSymjaPod(podsArray, inExpr, list, "Input", "Identity", formats, mapper, engine);
		numpods++;

		inExpr = F.Total(list);
		IExpr podOut = engine.evaluate(inExpr);
		addSymjaPod(podsArray, inExpr, podOut, "Total", "List", formats, mapper, engine);
		numpods++;

		inExpr = F.N(F.Norm(list));
		podOut = engine.evaluate(inExpr);
		addSymjaPod(podsArray, inExpr, podOut, "Vector length", "List", formats, mapper, engine);
		numpods++;

		inExpr = F.Normalize(list);
		podOut = engine.evaluate(inExpr);
		addSymjaPod(podsArray, inExpr, podOut, "Normalized vector", "List", formats, mapper, engine);
		numpods++;

		return numpods;
	}

	private static void resultStatistics(ObjectNode queryresult, boolean error, int numpods, ArrayNode podsArray) {
		queryresult.putPOJO("pods", podsArray);
		queryresult.put("success", "true");
		queryresult.put("error", error ? "true" : "false");
		queryresult.put("numpods", numpods);
	}

	static ObjectNode createJSONErrorString(String str) {
		ObjectMapper mapper = new ObjectMapper();

		ObjectNode outJSON = mapper.createObjectNode();
		outJSON.put("prefix", "Error");
		outJSON.put("message", Boolean.TRUE);
		outJSON.put("tag", "syntax");
		outJSON.put("symbol", "General");
		outJSON.put("text", "<math><mrow><mtext>" + str + "</mtext></mrow></math>");

		ObjectNode resultsJSON = mapper.createObjectNode();
		resultsJSON.putNull("line");
		resultsJSON.putNull("result");

		ArrayNode temp = mapper.createArrayNode();
		temp.add(outJSON);
		resultsJSON.putPOJO("out", temp);

		temp = mapper.createArrayNode();
		temp.add(resultsJSON);
		ObjectNode json = mapper.createObjectNode();
		json.putPOJO("results", temp);
		return json;
	}

	private static void createJSONFormat(ObjectNode json, EvalEngine engine, IExpr outExpr, int formats) {
		createJSONFormat(json, engine, outExpr, null, "", formats);
	}

	private static void createJSONFormat(ObjectNode json, EvalEngine engine, String sinput, IExpr outExpr,
										 int formats) {
		createJSONFormat(json, engine, outExpr, null, sinput, formats);
	}

	private static void createJSONFormat(ObjectNode json, EvalEngine engine, String plaintext, String sinput,
										 IExpr outExpr, int formats) {
		createJSONFormat(json, engine, outExpr, plaintext, sinput, formats);
	}

	/**
	 *
	 * @param json
	 * @param engine
	 * @param outExpr
	 * @param plainText
	 *            text which should obligatory be used for plaintext format
	 * @param sinput
	 *            Symja input string
	 * @param formats
	 */
	private static void createJSONFormat(ObjectNode json, EvalEngine engine, IExpr outExpr, String plainText,
										 String sinput, int formats) {

		if ((formats & HTML) != 0x00) {
			if (plainText != null && plainText.length() > 0) {
				json.put(HTML_STR, plainText);
			}
		}

		if ((formats & PLAIN) != 0x00) {
			if (plainText != null && plainText.length() > 0) {
				json.put(PLAIN_STR, plainText);
			} else {
				StringWriter stw = new StringWriter();
				stw.append(outExpr.toString());
				json.put(PLAIN_STR, stw.toString());
			}
		}
		if ((formats & SYMJA) != 0x00) {
			if (sinput != null && sinput.length() > 0) {
				json.put(SYMJA_STR, sinput);
			}
		}
		if ((formats & MATHML) != 0x00) {
			StringWriter stw = new StringWriter();
			MathMLUtilities mathUtil = new MathMLUtilities(engine, false, false);
			if (!mathUtil.toMathML(F.HoldForm(outExpr), stw, true)) {
				// return createJSONErrorString("Max. output size exceeded " +
				// Config.MAX_OUTPUT_SIZE);
			} else {
				json.put(MATHML_STR, stw.toString());
			}
		}
		if ((formats & LATEX) != 0x00) {
			StringWriter stw = new StringWriter();
			TeXUtilities texUtil = new TeXUtilities(engine, engine.isRelaxedSyntax());
			if (!texUtil.toTeX(F.HoldForm(outExpr), stw)) {
				//
			} else {
				json.put(LATEX_STR, stw.toString());
			}
		}
		if ((formats & MARKDOWN) != 0x00) {
			if (plainText != null && plainText.length() > 0) {
				json.put(MARKDOWN_STR, plainText);
			} else {

			}
		}
		if ((formats & MATHCELL) != 0x00) {
			if (plainText != null && plainText.length() > 0) {
				try {
					String html = MATHCELL_IFRAME;
					html = StringUtils.replace(html, "`1`", plainText);
					html = StringEscapeUtils.escapeHtml4(html);
					html = "<iframe srcdoc=\"" + html
							+ "\" style=\"display: block; width: 100%; height: 100%; border: none;\" ></iframe>";
					json.put(MATHCELL_STR, html);
				} catch (Exception ex) {
					if (FEConfig.SHOW_STACKTRACE) {
						ex.printStackTrace();
					}
				}

			} else {

			}
		}
		if ((formats & JSXGRAPH) != 0x00) {
			if (plainText != null && plainText.length() > 0) {
				try {
					String html = JSXGRAPH_IFRAME;
					html = StringUtils.replace(html, "`1`", plainText);
					html = StringEscapeUtils.escapeHtml4(html);
					html = "<iframe srcdoc=\"" + html
							+ "\" style=\"display: block; width: 100%; height: 100%; border: none;\" ></iframe>";
					json.put(JSXGRAPH_STR, html);
				} catch (Exception ex) {
					if (FEConfig.SHOW_STACKTRACE) {
						ex.printStackTrace();
					}
				}

			} else {

			}
		}

		if ((formats & PLOTLY) != 0x00) {
			if (plainText != null && plainText.length() > 0) {
				try {
					String html = PLOTLY_IFRAME;
					html = StringUtils.replace(html, "`1`", plainText);
					html = StringEscapeUtils.escapeHtml4(html);
					html = "<iframe srcdoc=\"" + html
							+ "\" style=\"display: block; width: 100%; height: 100%; border: none;\" ></iframe>";
					json.put(PLOTLY_STR, html);
				} catch (Exception ex) {
					if (FEConfig.SHOW_STACKTRACE) {
						ex.printStackTrace();
					}
				}

			} else {

			}
		}
	}

}
