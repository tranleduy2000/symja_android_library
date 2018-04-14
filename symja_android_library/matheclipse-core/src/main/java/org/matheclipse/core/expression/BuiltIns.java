package org.matheclipse.core.expression;

import org.matheclipse.core.interfaces.IBuiltInSymbol;

public enum BuiltIns {
 Abort( "abort", 0 ), //
 Abs( "abs", 1 ), //
 AbsArg( "absarg", 2 ), //
 Accumulate( "accumulate", 3 ), //
 AddTo( "addto", 4 ), //
 AlgebraicNumber( "algebraicnumber", 5 ), //
 Algebraics( "algebraics", 6 ), //
 All( "all", 7 ), //
 AllTrue( "alltrue", 8 ), //
 Alternatives( "alternatives", 9 ), //
 And( "and", 10 ), //
 AngleVector( "anglevector", 11 ), //
 AntihermitianMatrixQ( "antihermitianmatrixq", 12 ), //
 AntisymmetricMatrixQ( "antisymmetricmatrixq", 13 ), //
 AnyTrue( "anytrue", 14 ), //
 Apart( "apart", 15 ), //
 AppellF1( "appellf1", 16 ), //
 Append( "append", 17 ), //
 AppendTo( "appendto", 18 ), //
 Apply( "apply", 19 ), //
 ArcCos( "arccos", 20 ), //
 ArcCosh( "arccosh", 21 ), //
 ArcCot( "arccot", 22 ), //
 ArcCoth( "arccoth", 23 ), //
 ArcCsc( "arccsc", 24 ), //
 ArcCsch( "arccsch", 25 ), //
 ArcSec( "arcsec", 26 ), //
 ArcSech( "arcsech", 27 ), //
 ArcSin( "arcsin", 28 ), //
 ArcSinh( "arcsinh", 29 ), //
 ArcTan( "arctan", 30 ), //
 ArcTanh( "arctanh", 31 ), //
 Arg( "arg", 32 ), //
 Array( "array", 33 ), //
 ArrayDepth( "arraydepth", 34 ), //
 ArrayPad( "arraypad", 35 ), //
 ArrayQ( "arrayq", 36 ), //
 Assumptions( "assumptions", 37 ), //
 AtomQ( "atomq", 38 ), //
 Attributes( "attributes", 39 ), //
 Automatic( "automatic", 40 ), //
 Axes( "axes", 41 ), //
 AxesOrigin( "axesorigin", 42 ), //
 AxesStyle( "axesstyle", 43 ), //
 Background( "background", 44 ), //
 Begin( "begin", 45 ), //
 BeginPackage( "beginpackage", 46 ), //
 BellB( "bellb", 47 ), //
 BellY( "belly", 48 ), //
 BernoulliB( "bernoullib", 49 ), //
 BernoulliDistribution( "bernoullidistribution", 50 ), //
 BesselI( "besseli", 51 ), //
 BesselJ( "besselj", 52 ), //
 BesselK( "besselk", 53 ), //
 BesselY( "bessely", 54 ), //
 Beta( "beta", 55 ), //
 BetaRegularized( "betaregularized", 56 ), //
 BinCounts( "bincounts", 57 ), //
 Binomial( "binomial", 58 ), //
 BinomialDistribution( "binomialdistribution", 59 ), //
 BitLength( "bitlength", 60 ), //
 Blank( "blank", 61 ), //
 Block( "block", 62 ), //
 Boole( "boole", 63 ), //
 BooleanConvert( "booleanconvert", 64 ), //
 BooleanMinimize( "booleanminimize", 65 ), //
 BooleanQ( "booleanq", 66 ), //
 BooleanTable( "booleantable", 67 ), //
 BooleanVariables( "booleanvariables", 68 ), //
 Booleans( "booleans", 69 ), //
 BrayCurtisDistance( "braycurtisdistance", 70 ), //
 Break( "break", 71 ), //
 CDF( "cdf", 72 ), //
 CanberraDistance( "canberradistance", 73 ), //
 Cancel( "cancel", 74 ), //
 CarmichaelLambda( "carmichaellambda", 75 ), //
 CartesianProduct( "cartesianproduct", 76 ), //
 Cases( "cases", 77 ), //
 Catalan( "catalan", 78 ), //
 CatalanNumber( "catalannumber", 79 ), //
 Catch( "catch", 80 ), //
 Catenate( "catenate", 81 ), //
 Ceiling( "ceiling", 82 ), //
 CentralMoment( "centralmoment", 83 ), //
 CharacterEncoding( "characterencoding", 84 ), //
 CharacteristicPolynomial( "characteristicpolynomial", 85 ), //
 ChebyshevT( "chebyshevt", 86 ), //
 ChebyshevU( "chebyshevu", 87 ), //
 ChessboardDistance( "chessboarddistance", 88 ), //
 ChineseRemainder( "chineseremainder", 89 ), //
 CholeskyDecomposition( "choleskydecomposition", 90 ), //
 Chop( "chop", 91 ), //
 CirclePoints( "circlepoints", 92 ), //
 Clear( "clear", 93 ), //
 ClearAll( "clearall", 94 ), //
 ClearAttributes( "clearattributes", 95 ), //
 Clip( "clip", 96 ), //
 Coefficient( "coefficient", 97 ), //
 CoefficientList( "coefficientlist", 98 ), //
 CoefficientRules( "coefficientrules", 99 ), //
 Collect( "collect", 100 ), //
 Colon( "colon", 101 ), //
 Commonest( "commonest", 102 ), //
 Compile( "compile", 103 ), //
 Complement( "complement", 104 ), //
 Complex( "complex", 105 ), //
 ComplexExpand( "complexexpand", 106 ), //
 ComplexInfinity( "complexinfinity", 107 ), //
 Complexes( "complexes", 108 ), //
 ComplexityFunction( "complexityfunction", 109 ), //
 ComposeList( "composelist", 110 ), //
 ComposeSeries( "composeseries", 111 ), //
 Composition( "composition", 112 ), //
 CompoundExpression( "compoundexpression", 113 ), //
 Condition( "condition", 114 ), //
	ConditionalExpression("conditionalexpression", 115), //
	Conjugate("conjugate", 116), //
	ConjugateTranspose("conjugatetranspose", 117), //
	Constant("constant", 118), //
	ConstantArray("constantarray", 119), //
	Continue("continue", 120), //
	ContinuedFraction("continuedfraction", 121), //
	ConvexHullMesh("convexhullmesh", 122), //
	CoprimeQ("coprimeq", 123), //
	Correlation("correlation", 124), //
	Cos("cos", 125), //
	CosIntegral("cosintegral", 126), //
	Cosh("cosh", 127), //
	CoshIntegral("coshintegral", 128), //
	CosineDistance("cosinedistance", 129), //
	Cot("cot", 130), //
	Coth("coth", 131), //
	Count("count", 132), //
	Covariance("covariance", 133), //
	Cross("cross", 134), //
	Csc("csc", 135), //
	Csch("csch", 136), //
	CubeRoot("cuberoot", 137), //
	Curl("curl", 138), //
	D("D", 139), //
	DSolve("dsolve", 140), //
	Decrement("decrement", 141), //
	Default("default", 142), //
	Defer("defer", 143), //
	Definition("definition", 144), //
	Degree("degree", 145), //
	Delete("delete", 146), //
	DeleteCases("deletecases", 147), //
	DeleteDuplicates("deleteduplicates", 148), //
	Denominator("denominator", 149), //
	Depth("depth", 150), //
	Derivative("derivative", 151), //
	DesignMatrix("designmatrix", 152), //
	Det("det", 153), //
	Diagonal("diagonal", 154), //
	DiagonalMatrix("diagonalmatrix", 155), //
	DiceDissimilarity("dicedissimilarity", 156), //
	DigitQ("digitq", 157), //
	Dimensions("dimensions", 158), //
	DiracDelta("diracdelta", 159), //
	DirectedInfinity("directedinfinity", 160), //
	Direction("direction", 161), //
	DiscreteDelta("discretedelta", 162), //
	DiscreteUniformDistribution("discreteuniformdistribution", 163), //
	Discriminant("discriminant", 164), //
	Disputed("disputed", 165), //
	Distribute("distribute", 166), //
	Divergence("divergence", 167), //
	Divide("divide", 168), //
	DivideBy("divideby", 169), //
	Divisible("divisible", 170), //
	DivisorSigma("divisorsigma", 171), //
	Divisors("divisors", 172), //
	Do("do", 173), //
	Dot("dot", 174), //
	Drop("drop", 175), //
	E("E", 176), //
	EasterSunday("eastersunday", 177), //
	Eigenvalues("eigenvalues", 178), //
	Eigenvectors("eigenvectors", 179), //
	Element("element", 180), //
	ElementData("elementdata", 181), //
	Eliminate("eliminate", 182), //
	EllipticE("elliptice", 183), //
	EllipticF("ellipticf", 184), //
	EllipticK("elliptick", 185), //
	EllipticPi("ellipticpi", 186), //
	End("end", 187), //
	EndPackage("endpackage", 188), //
	Equal("equal", 189), //
	Equivalent("equivalent", 190), //
	Erf("erf", 191), //
	Erfc("erfc", 192), //
	Erfi("erfi", 193), //
	ErlangDistribution("erlangdistribution", 194), //
	EuclideanDistance("euclideandistance", 195), //
	EulerE("eulere", 196), //
	EulerGamma("eulergamma", 197), //
	EulerPhi("eulerphi", 198), //
	EvenQ("evenq", 199), //
	ExactNumberQ("exactnumberq", 200), //
	Except("except", 201), //
	Exists("exists", 202), //
	Exp("exp", 203), //
	ExpIntegralE("expintegrale", 204), //
	ExpIntegralEi("expintegralei", 205), //
	Expand("expand", 206), //
	ExpandAll("expandall", 207), //
	Expectation("expectation", 208), //
	Exponent("exponent", 209), //
	ExponentialDistribution("exponentialdistribution", 210), //
	Export("export", 211), //
	ExtendedGCD("extendedgcd", 212), //
	Extract("extract", 213), //
	Factor("factor", 214), //
	FactorInteger("factorinteger", 215), //
	FactorSquareFree("factorsquarefree", 216), //
	FactorSquareFreeList("factorsquarefreelist", 217), //
	FactorTerms("factorterms", 218), //
	Factorial("factorial", 219), //
	Factorial2("factorial2", 220), //
	False("false", 221), //
	Fibonacci("fibonacci", 222), //
	FindInstance("findinstance", 223), //
	FindRoot("findroot", 224), //
	First("first", 225), //
	Fit("fit", 226), //
	FixedPoint("fixedpoint", 227), //
	FixedPointList("fixedpointlist", 228), //
	Flat("flat", 229), //
	Flatten("flatten", 230), //
	FlattenAt("flattenat", 231), //
	Floor("floor", 232), //
	Fold("fold", 233), //
	FoldList("foldlist", 234), //
	For("for", 235), //
	ForAll("forall", 236), //
	FourierMatrix("fouriermatrix", 237), //
	FractionalPart("fractionalpart", 238), //
	FrechetDistribution("frechetdistribution", 239), //
	FreeQ("freeq", 240), //
	FresnelC("fresnelc", 241), //
	FresnelS("fresnels", 242), //
	FrobeniusSolve("frobeniussolve", 243), //
	FromCharacterCode("fromcharactercode", 244), //
	FromContinuedFraction("fromcontinuedfraction", 245), //
	FromPolarCoordinates("frompolarcoordinates", 246), //
	FullForm("fullform", 247), //
	FullSimplify("fullsimplify", 248), //
	Function("function", 249), //
	GCD("gcd", 250), //
	Gamma("gamma", 251), //
	GammaDistribution("gammadistribution", 252), //
	GammaRegularized("gammaregularized", 253), //
	Gather("gather", 254), //
	GegenbauerC("gegenbauerc", 255), //
	GeometricDistribution("geometricdistribution", 256), //
	GeometricMean("geometricmean", 257), //
	Get("get", 258), //
	Glaisher("glaisher", 259), //
	GoldenRatio("goldenratio", 260), //
	Graphics("graphics", 261), //
	Graphics3D("graphics3d", 262), //
	Greater("greater", 263), //
	GreaterEqual("greaterequal", 264), //
	GroebnerBasis("groebnerbasis", 265), //
	GumbelDistribution("gumbeldistribution", 266), //
	HarmonicNumber("harmonicnumber", 267), //
	Haversine("haversine", 268), //
	Head("head", 269), //
	HeavisideTheta("heavisidetheta", 270), //
	HermiteH("hermiteh", 271), //
	HermitianMatrixQ("hermitianmatrixq", 272), //
	HilbertMatrix("hilbertmatrix", 273), //
	Hold("hold", 274), //
	HoldAll("holdall", 275), //
	HoldFirst("holdfirst", 276), //
	HoldForm("holdform", 277), //
	HoldPattern("holdpattern", 278), //
	HoldRest("holdrest", 279), //
	Horner("horner", 280), //
	HornerForm("hornerform", 281), //
	HurwitzZeta("hurwitzzeta", 282), //
	Hypergeometric1F1("hypergeometric1f1", 283), //
	Hypergeometric2F1("hypergeometric2f1", 284), //
	HypergeometricDistribution("hypergeometricdistribution", 285), //
	HypergeometricPFQ("hypergeometricpfq", 286), //
	HypergeometricPFQRegularized("hypergeometricpfqregularized", 287), //
	I("I", 288), //
	Identity("identity", 289), //
	IdentityMatrix("identitymatrix", 290), //
	If("if", 291), //
	Im("im", 292), //
	Implies("implies", 293), //
	Import("import", 294), //
	Increment("increment", 295), //
	Indeterminate("indeterminate", 296), //
	Inequality("inequality", 297), //
	InexactNumberQ("inexactnumberq", 298), //
	Infinity("infinity", 299), //
	Information("information", 300), //
	Inner("inner", 301), //
	Insert("insert", 302), //
	Integer("integer", 303), //
	IntegerExponent("integerexponent", 304), //
	IntegerLength("integerlength", 305), //
	IntegerPart("integerpart", 306), //
	IntegerPartitions("integerpartitions", 307), //
	IntegerQ("integerq", 308), //
	Integers("integers", 309), //
	Integrate("integrate", 310), //
	InterpolatingFunction("interpolatingfunction", 311), //
	InterpolatingPolynomial("interpolatingpolynomial", 312), //
	Interpolation("interpolation", 313), //
	Intersection("intersection", 314), //
	Interval("interval", 315), //
	Inverse("inverse", 316), //
	InverseErf("inverseerf", 317), //
	InverseErfc("inverseerfc", 318), //
	InverseFunction("inversefunction", 319), //
	InverseHaversine("inversehaversine", 320), //
	InverseLaplaceTransform("inverselaplacetransform", 321), //
	InverseSeries("inverseseries", 322), //
	JaccardDissimilarity("jaccarddissimilarity", 323), //
	JacobiMatrix("jacobimatrix", 324), //
	JacobiSymbol("jacobisymbol", 325), //
	JacobiZeta("jacobizeta", 326), //
	JavaForm("javaform", 327), //
	Join("join", 328), //
	KOrderlessPartitions("korderlesspartitions", 329), //
	KPartitions("kpartitions", 330), //
	Khinchin("khinchin", 331), //
	KroneckerDelta("kroneckerdelta", 332), //
	Kurtosis("kurtosis", 333), //
	LCM("lcm", 334), //
	LUDecomposition("ludecomposition", 335), //
	LaguerreL("laguerrel", 336), //
	LaplaceTransform("laplacetransform", 337), //
	Last("last", 338), //
	LeafCount("leafcount", 339), //
	LeastSquares("leastsquares", 340), //
	LegendreP("legendrep", 341), //
	LegendreQ("legendreq", 342), //
	Length("length", 343), //
	Less("less", 344), //
	LessEqual("lessequal", 345), //
	LetterQ("letterq", 346), //
	Level("level", 347), //
	LevelQ("levelq", 348), //
	Limit("limit", 349), //
	Line("line", 350), //
	LinearModelFit("linearmodelfit", 351), //
	LinearProgramming("linearprogramming", 352), //
	LinearSolve("linearsolve", 353), //
	LiouvilleLambda("liouvillelambda", 354), //
	List("list", 355), //
	ListConvolve("listconvolve", 356), //
	ListCorrelate("listcorrelate", 357), //
	ListQ("listq", 358), //
	Listable("listable", 359), //
	Literal("literal", 360), //
	Log("log", 361), //
	Log10("log10", 362), //
	Log2("log2", 363), //
	LogGamma("loggamma", 364), //
	LogIntegral("logintegral", 365), //
	LogNormalDistribution("lognormaldistribution", 366), //
	LogicalExpand("logicalexpand", 367), //
	LogisticSigmoid("logisticsigmoid", 368), //
	LowerCaseQ("lowercaseq", 369), //
	LowerTriangularize("lowertriangularize", 370), //
	LucasL("lucasl", 371), //
	MachineNumberQ("machinenumberq", 372), //
	MangoldtLambda("mangoldtlambda", 373), //
	ManhattanDistance("manhattandistance", 374), //
	MantissaExponent("mantissaexponent", 375), //
	Map("map", 376), //
	MapAll("mapall", 377), //
	MapAt("mapat", 378), //
	MapThread("mapthread", 379), //
	MatchQ("matchq", 380), //
	MatchingDissimilarity("matchingdissimilarity", 381), //
	MathMLForm("mathmlform", 382), //
	MatrixForm("matrixform", 383), //
	MatrixMinimalPolynomial("matrixminimalpolynomial", 384), //
	MatrixPower("matrixpower", 385), //
	MatrixQ("matrixq", 386), //
	MatrixRank("matrixrank", 387), //
	Max("max", 388), //
	MaxIterations("maxiterations", 389), //
	MaxPoints("maxpoints", 390), //
	Mean("mean", 391), //
	MeanDeviation("meandeviation", 392), //
	Median("median", 393), //
	MeijerG("meijerg", 394), //
	MemberQ("memberq", 395), //
	MersennePrimeExponent("mersenneprimeexponent", 396), //
	MersennePrimeExponentQ("mersenneprimeexponentq", 397), //
	MeshRange("meshrange", 398), //
	MessageName("messagename", 399), //
	Method("method", 400), //
	Min("min", 401), //
	MinimalPolynomial("minimalpolynomial", 402), //
	Minus("minus", 403), //
	Missing("missing", 404), //
	MissingQ("missingq", 405), //
	Mod("mod", 406), //
	Module("module", 407), //
	Modulus("modulus", 408), //
	MoebiusMu("moebiusmu", 409), //
	MonomialList("monomiallist", 410), //
	Most("most", 411), //
	Multinomial("multinomial", 412), //
	MultiplicativeOrder("multiplicativeorder", 413), //
	N("N", 414), //
	NDSolve("ndsolve", 415), //
	NFourierTransform("nfouriertransform", 416), //
	NHoldAll("nholdall", 417), //
	NHoldFirst("nholdfirst", 418), //
	NHoldRest("nholdrest", 419), //
	NIntegrate("nintegrate", 420), //
	NMaximize("nmaximize", 421), //
	NMinimize("nminimize", 422), //
	NRoots("nroots", 423), //
	NSolve("nsolve", 424), //
	NakagamiDistribution("nakagamidistribution", 425), //
	Names("names", 426), //
	Nand("nand", 427), //
	Nearest("nearest", 428), //
	Negative("negative", 429), //
	Nest("nest", 430), //
	NestList("nestlist", 431), //
	NestWhile("nestwhile", 432), //
	NestWhileList("nestwhilelist", 433), //
	NextPrime("nextprime", 434), //
	NonCommutativeMultiply("noncommutativemultiply", 435), //
	NonNegative("nonnegative", 436), //
	NonPositive("nonpositive", 437), //
	None("none", 438), //
	NoneTrue("nonetrue", 439), //
	Nonexistent("nonexistent", 440), //
	Nor("nor", 441), //
	Norm("norm", 442), //
	Normal("normal", 443), //
	NormalDistribution("normaldistribution", 444), //
	Normalize("normalize", 445), //
	Not("not", 446), //
	NotApplicable("notapplicable", 447), //
	NotAvailable("notavailable", 448), //
	NotListQ("notlistq", 449), //
	Null("null", 450), //
	NullSpace("nullspace", 451), //
	NumberFieldRootsOfUnity("numberfieldrootsofunity", 452), //
	NumberQ("numberq", 453), //
	Numerator("numerator", 454), //
	NumericFunction("numericfunction", 455), //
	NumericQ("numericq", 456), //
	O("O", 457), //
	OddQ("oddq", 458), //
	OneIdentity("oneidentity", 459), //
	Operate("operate", 460), //
	Optional("optional", 461), //
	Options("options", 462), //
	Or("or", 463), //
	Order("order", 464), //
	OrderedQ("orderedq", 465), //
	Ordering("ordering", 466), //
	Orderless("orderless", 467), //
	OrthogonalMatrixQ("orthogonalmatrixq", 468), //
	Orthogonalize("orthogonalize", 469), //
	Out("out", 470), //
	Outer("outer", 471), //
	PDF("pdf", 472), //
	Package("package", 473), //
	PadLeft("padleft", 474), //
	PadRight("padright", 475), //
	ParametricPlot("parametricplot", 476), //
	Part("part", 477), //
	Partition("partition", 478), //
	PartitionsP("partitionsp", 479), //
	PartitionsQ("partitionsq", 480), //
	Pattern("pattern", 481), //
	PatternTest("patterntest", 482), //
	PerfectNumber("perfectnumber", 483), //
	PerfectNumberQ("perfectnumberq", 484), //
	Permutations("permutations", 485), //
	Pi("pi", 486), //
	Piecewise("piecewise", 487), //
	Plot("plot", 488), //
	Plot3D("plot3d", 489), //
	PlotRange("plotrange", 490), //
	Plus("plus", 491), //
	Pochhammer("pochhammer", 492), //
	Point("point", 493), //
	PoissonDistribution("poissondistribution", 494), //
	PolyGamma("polygamma", 495), //
	PolyLog("polylog", 496), //
	Polygon("polygon", 497), //
	PolynomialExtendedGCD("polynomialextendedgcd", 498), //
	PolynomialGCD("polynomialgcd", 499), //
	PolynomialLCM("polynomiallcm", 500), //
	PolynomialQ("polynomialq", 501), //
	PolynomialQuotient("polynomialquotient", 502), //
	PolynomialQuotientRemainder("polynomialquotientremainder", 503), //
	PolynomialRemainder("polynomialremainder", 504), //
	Position("position", 505), //
	Positive("positive", 506), //
	PossibleZeroQ("possiblezeroq", 507), //
	Power("power", 508), //
	PowerExpand("powerexpand", 509), //
	PowerMod("powermod", 510), //
	PreDecrement("predecrement", 511), //
	PreIncrement("preincrement", 512), //
	PrePlus("preplus", 513), //
	Precision("precision", 514), //
	PrecisionGoal("precisiongoal", 515), //
	Prepend("prepend", 516), //
	PrependTo("prependto", 517), //
	Prime("prime", 518), //
	PrimeOmega("primeomega", 519), //
	PrimePi("primepi", 520), //
	PrimePowerQ("primepowerq", 521), //
	PrimeQ("primeq", 522), //
	Primes("primes", 523), //
	PrimitiveRootList("primitiverootlist", 524), //
	Print("print", 525), //
	Product("product", 526), //
	ProductLog("productlog", 527), //
	Projection("projection", 528), //
	PseudoInverse("pseudoinverse", 529), //
	Put("put", 530), //
	QRDecomposition("qrdecomposition", 531), //
	Quantile("quantile", 532), //
	Quiet("quiet", 533), //
	Quit("quit", 534), //
	Quotient("quotient", 535), //
	QuotientRemainder("quotientremainder", 536), //
	RandomChoice("randomchoice", 537), //
	RandomInteger("randominteger", 538), //
	RandomReal("randomreal", 539), //
	RandomSample("randomsample", 540), //
	RandomVariate("randomvariate", 541), //
	Range("range", 542), //
	Rational("rational", 543), //
	Rationalize("rationalize", 544), //
	Rationals("rationals", 545), //
	Re("re", 546), //
	Real("real", 547), //
	RealNumberQ("realnumberq", 548), //
	Reals("reals", 549), //
	Reap("reap", 550), //
	Rectangle("rectangle", 551), //
	Reduce("reduce", 552), //
	Refine("refine", 553), //
	Repeated("repeated", 554), //
	RepeatedNull("repeatednull", 555), //
	Replace("replace", 556), //
	ReplaceAll("replaceall", 557), //
	ReplaceList("replacelist", 558), //
	ReplacePart("replacepart", 559), //
	ReplaceRepeated("replacerepeated", 560), //
	Rest("rest", 561), //
	Resultant("resultant", 562), //
	Return("return", 563), //
	Reverse("reverse", 564), //
	Riffle("riffle", 565), //
	RogersTanimotoDissimilarity("rogerstanimotodissimilarity", 566), //
	Root("root", 567), //
	RootIntervals("rootintervals", 568), //
	RootOf("rootof", 569), //
	Roots("roots", 570), //
	RotateLeft("rotateleft", 571), //
	RotateRight("rotateright", 572), //
	Round("round", 573), //
	RowReduce("rowreduce", 574), //
	Rule("rule", 575), //
	RuleDelayed("ruledelayed", 576), //
	RussellRaoDissimilarity("russellraodissimilarity", 577), //
	SameQ("sameq", 578), //
	SatisfiabilityCount("satisfiabilitycount", 579), //
	SatisfiabilityInstances("satisfiabilityinstances", 580), //
	SatisfiableQ("satisfiableq", 581), //
	Scan("scan", 582), //
	Sec("sec", 583), //
	Sech("sech", 584), //
	Second("second", 585), //
	Select("select", 586), //
	Sequence("sequence", 587), //
	Series("series", 588), //
	SeriesCoefficient("seriescoefficient", 589), //
	SeriesData("seriesdata", 590), //
	Set("set", 591), //
	SetAttributes("setattributes", 592), //
	SetDelayed("setdelayed", 593), //
	Share("share", 594), //
	Show("show", 595), //
	Sign("sign", 596), //
	SignCmp("signcmp", 597), //
	Simplify("simplify", 598), //
	Sin("sin", 599), //
	SinIntegral("sinintegral", 600), //
	Sinc("sinc", 601), //
	SingularValueDecomposition("singularvaluedecomposition", 602), //
	Sinh("sinh", 603), //
	SinhIntegral("sinhintegral", 604), //
	Skewness("skewness", 605), //
	Slot("slot", 606), //
	SlotSequence("slotsequence", 607), //
	SokalSneathDissimilarity("sokalsneathdissimilarity", 608), //
	Solve("solve", 609), //
	Sort("sort", 610), //
	Sow("sow", 611), //
	Span("span", 612), //
	Split("split", 613), //
	SplitBy("splitby", 614), //
	Sqrt("sqrt", 615), //
	SquareFreeQ("squarefreeq", 616), //
	SquaredEuclideanDistance("squaredeuclideandistance", 617), //
	StandardDeviation("standarddeviation", 618), //
	Standardize("standardize", 619), //
	StieltjesGamma("stieltjesgamma", 620), //
	StirlingS1("stirlings1", 621), //
	StirlingS2("stirlings2", 622), //
	String("string", 623), //
	StringDrop("stringdrop", 624), //
	StringJoin("stringjoin", 625), //
	StringLength("stringlength", 626), //
	StringTake("stringtake", 627), //
	StruveH("struveh", 628), //
	StruveL("struvel", 629), //
	StudentTDistribution("studenttdistribution", 630), //
	Subfactorial("subfactorial", 631), //
	Subscript("subscript", 632), //
	Subsets("subsets", 633), //
	Subsuperscript("subsuperscript", 634), //
	Subtract("subtract", 635), //
	SubtractFrom("subtractfrom", 636), //
	Sum("sum", 637), //
	Superscript("superscript", 638), //
	Surd("surd", 639), //
	SurfaceGraphics("surfacegraphics", 640), //
	Switch("switch", 641), //
	Symbol("symbol", 642), //
	SymbolName("symbolname", 643), //
	SymbolQ("symbolq", 644), //
	SymmetricMatrixQ("symmetricmatrixq", 645), //
	SyntaxLength("syntaxlength", 646), //
	SyntaxQ("syntaxq", 647), //
	Table("table", 648), //
	Take("take", 649), //
	Tally("tally", 650), //
	Tan("tan", 651), //
	Tanh("tanh", 652), //
	TautologyQ("tautologyq", 653), //
	Taylor("taylor", 654), //
	TeXForm("texform", 655), //
	TensorDimensions("tensordimensions", 656), //
	TensorProduct("tensorproduct", 657), //
	TensorRank("tensorrank", 658), //
	Thread("thread", 659), //
	Through("through", 660), //
	Throw("throw", 661), //
	TimeConstrained("timeconstrained", 662), //
	Times("times", 663), //
	TimesBy("timesby", 664), //
	Timing("timing", 665), //
	ToCharacterCode("tocharactercode", 666), //
	ToPolarCoordinates("topolarcoordinates", 667), //
	ToRadicals("toradicals", 668), //
	ToString("tostring", 669), //
	ToUnicode("tounicode", 670), //
	ToeplitzMatrix("toeplitzmatrix", 671), //
	Together("together", 672), //
	TooLarge("toolarge", 673), //
	Total("total", 674), //
	Tr("tr", 675), //
	Trace("trace", 676), //
	Transpose("transpose", 677), //
	Trig("trig", 678), //
	TrigExpand("trigexpand", 679), //
	TrigReduce("trigreduce", 680), //
	TrigToExp("trigtoexp", 681), //
	True("true", 682), //
	TrueQ("trueq", 683), //
	Tuples("tuples", 684), //
	Undefined("undefined", 685), //
	Unequal("unequal", 686), //
	Unevaluated("unevaluated", 687), //
	Union("union", 688), //
	Unique("unique", 689), //
	UnitStep("unitstep", 690), //
	UnitVector("unitvector", 691), //
	UnitaryMatrixQ("unitarymatrixq", 692), //
	Unitize("unitize", 693), //
	Unknown("unknown", 694), //
	UnsameQ("unsameq", 695), //
	Unset("unset", 696), //
	UpSet("upset", 697), //
	UpSetDelayed("upsetdelayed", 698), //
	UpperCaseQ("uppercaseq", 699), //
	UpperTriangularize("uppertriangularize", 700), //
	ValueQ("valueq", 701), //
	VandermondeMatrix("vandermondematrix", 702), //
	Variable("variable", 703), //
	Variables("variables", 704), //
	Variance("variance", 705), //
	VectorAngle("vectorangle", 706), //
	VectorQ("vectorq", 707), //
	WeibullDistribution("weibulldistribution", 708), //
	Which("which", 709), //
	While("while", 710), //
	White("white", 711), //
	With("with", 712), //
	Xor("xor", 713), //
	YuleDissimilarity("yuledissimilarity", 714), //
	Zeta("zeta", 715);

	private final String name;
	private final int symbolID;
	private final static IBuiltInSymbol[] builtInSymbols = new IBuiltInSymbol[values().length];

	public static IBuiltInSymbol valueOf(BuiltIns sEnum) {
		IBuiltInSymbol symbol = F.initFinalSymbol(sEnum);
		builtInSymbols[sEnum.symbolID] = symbol;
		return symbol;
	}

	BuiltIns(String name, int symbolID) {
		this.name = name;
		this.symbolID = symbolID;
	}

	public static IBuiltInSymbol symbol(int id) {
		return builtInSymbols[id];
	}

	public final int id() {
		return symbolID;
	}

	public final String str() {
		return name;
	}
}