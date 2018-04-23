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
	ConditionalExpression( "conditionalexpression", 115 ), //
	Conjugate( "conjugate", 116 ), //
	ConjugateTranspose( "conjugatetranspose", 117 ), //
	Constant( "constant", 118 ), //
	ConstantArray( "constantarray", 119 ), //
	Continue( "continue", 120 ), //
	ContinuedFraction( "continuedfraction", 121 ), //
	ConvexHullMesh( "convexhullmesh", 122 ), //
	CoprimeQ( "coprimeq", 123 ), //
	Correlation( "correlation", 124 ), //
	Cos( "cos", 125 ), //
	CosIntegral( "cosintegral", 126 ), //
	Cosh( "cosh", 127 ), //
	CoshIntegral( "coshintegral", 128 ), //
	CosineDistance( "cosinedistance", 129 ), //
	Cot( "cot", 130 ), //
	Coth( "coth", 131 ), //
	Count( "count", 132 ), //
	Covariance( "covariance", 133 ), //
	Cross( "cross", 134 ), //
	Csc( "csc", 135 ), //
	Csch( "csch", 136 ), //
	CubeRoot( "cuberoot", 137 ), //
	Curl( "curl", 138 ), //
	D( "D", 139 ), //
	DSolve( "dsolve", 140 ), //
	Decrement( "decrement", 141 ), //
	Default( "default", 142 ), //
	Defer( "defer", 143 ), //
	Definition( "definition", 144 ), //
	Degree( "degree", 145 ), //
	Delete( "delete", 146 ), //
	DeleteCases( "deletecases", 147 ), //
	DeleteDuplicates( "deleteduplicates", 148 ), //
	Denominator( "denominator", 149 ), //
	Depth( "depth", 150 ), //
	Derivative( "derivative", 151 ), //
	DesignMatrix( "designmatrix", 152 ), //
	Det( "det", 153 ), //
	Diagonal( "diagonal", 154 ), //
	DiagonalMatrix( "diagonalmatrix", 155 ), //
	DiceDissimilarity( "dicedissimilarity", 156 ), //
	DigitQ( "digitq", 157 ), //
	Dimensions( "dimensions", 158 ), //
	DiracDelta( "diracdelta", 159 ), //
	DirectedInfinity( "directedinfinity", 160 ), //
	Direction( "direction", 161 ), //
	DiscreteDelta( "discretedelta", 162 ), //
	DiscreteUniformDistribution( "discreteuniformdistribution", 163 ), //
	Discriminant( "discriminant", 164 ), //
	Disputed( "disputed", 165 ), //
	Distribute( "distribute", 166 ), //
	Distributed("distributed", 167), //
	Divergence("divergence", 168), //
	Divide("divide", 169), //
	DivideBy("divideby", 170), //
	Divisible("divisible", 171), //
	DivisorSigma("divisorsigma", 172), //
	Divisors("divisors", 173), //
	Do("do", 174), //
	Dot("dot", 175), //
	Drop("drop", 176), //
	E("E", 177), //
	EasterSunday("eastersunday", 178), //
	Eigenvalues("eigenvalues", 179), //
	Eigenvectors("eigenvectors", 180), //
	Element("element", 181), //
	ElementData("elementdata", 182), //
	Eliminate("eliminate", 183), //
	EllipticE("elliptice", 184), //
	EllipticF("ellipticf", 185), //
	EllipticK("elliptick", 186), //
	EllipticPi("ellipticpi", 187), //
	End("end", 188), //
	EndPackage("endpackage", 189), //
	Equal("equal", 190), //
	Equivalent("equivalent", 191), //
	Erf("erf", 192), //
	Erfc("erfc", 193), //
	Erfi("erfi", 194), //
	ErlangDistribution("erlangdistribution", 195), //
	EuclideanDistance("euclideandistance", 196), //
	EulerE("eulere", 197), //
	EulerGamma("eulergamma", 198), //
	EulerPhi("eulerphi", 199), //
	EvenQ("evenq", 200), //
	ExactNumberQ("exactnumberq", 201), //
	Except("except", 202), //
	Exists("exists", 203), //
	Exp("exp", 204), //
	ExpIntegralE("expintegrale", 205), //
	ExpIntegralEi("expintegralei", 206), //
	Expand("expand", 207), //
	ExpandAll("expandall", 208), //
	Expectation("expectation", 209), //
	Exponent("exponent", 210), //
	ExponentialDistribution("exponentialdistribution", 211), //
	Export("export", 212), //
	ExtendedGCD("extendedgcd", 213), //
	Extract("extract", 214), //
	Factor("factor", 215), //
	FactorInteger("factorinteger", 216), //
	FactorSquareFree("factorsquarefree", 217), //
	FactorSquareFreeList("factorsquarefreelist", 218), //
	FactorTerms("factorterms", 219), //
	Factorial("factorial", 220), //
	Factorial2("factorial2", 221), //
	False("false", 222), //
	Fibonacci("fibonacci", 223), //
	FindInstance("findinstance", 224), //
	FindRoot("findroot", 225), //
	First("first", 226), //
	Fit("fit", 227), //
	FixedPoint("fixedpoint", 228), //
	FixedPointList("fixedpointlist", 229), //
	Flat("flat", 230), //
	Flatten("flatten", 231), //
	FlattenAt("flattenat", 232), //
	Floor("floor", 233), //
	Fold("fold", 234), //
	FoldList("foldlist", 235), //
	For("for", 236), //
	ForAll("forall", 237), //
	FourierMatrix("fouriermatrix", 238), //
	FractionalPart("fractionalpart", 239), //
	FrechetDistribution("frechetdistribution", 240), //
	FreeQ("freeq", 241), //
	FresnelC("fresnelc", 242), //
	FresnelS("fresnels", 243), //
	FrobeniusSolve("frobeniussolve", 244), //
	FromCharacterCode("fromcharactercode", 245), //
	FromContinuedFraction("fromcontinuedfraction", 246), //
	FromPolarCoordinates("frompolarcoordinates", 247), //
	FullForm("fullform", 248), //
	FullSimplify("fullsimplify", 249), //
	Function("function", 250), //
	GCD("gcd", 251), //
	Gamma("gamma", 252), //
	GammaDistribution("gammadistribution", 253), //
	GammaRegularized("gammaregularized", 254), //
	Gather("gather", 255), //
	GegenbauerC("gegenbauerc", 256), //
	GeometricDistribution("geometricdistribution", 257), //
	GeometricMean("geometricmean", 258), //
	Get("get", 259), //
	Glaisher("glaisher", 260), //
	GoldenRatio("goldenratio", 261), //
	Graphics("graphics", 262), //
	Graphics3D("graphics3d", 263), //
	Greater("greater", 264), //
	GreaterEqual("greaterequal", 265), //
	GroebnerBasis("groebnerbasis", 266), //
	GumbelDistribution("gumbeldistribution", 267), //
	HarmonicNumber("harmonicnumber", 268), //
	Haversine("haversine", 269), //
	Head("head", 270), //
	HeavisideTheta("heavisidetheta", 271), //
	HermiteH("hermiteh", 272), //
	HermitianMatrixQ("hermitianmatrixq", 273), //
	HilbertMatrix("hilbertmatrix", 274), //
	Hold("hold", 275), //
	HoldAll("holdall", 276), //
	HoldFirst("holdfirst", 277), //
	HoldForm("holdform", 278), //
	HoldPattern("holdpattern", 279), //
	HoldRest("holdrest", 280), //
	Horner("horner", 281), //
	HornerForm("hornerform", 282), //
	HurwitzZeta("hurwitzzeta", 283), //
	Hypergeometric1F1("hypergeometric1f1", 284), //
	Hypergeometric2F1("hypergeometric2f1", 285), //
	HypergeometricDistribution("hypergeometricdistribution", 286), //
	HypergeometricPFQ("hypergeometricpfq", 287), //
	HypergeometricPFQRegularized("hypergeometricpfqregularized", 288), //
	I("I", 289), //
	Identity("identity", 290), //
	IdentityMatrix("identitymatrix", 291), //
	If("if", 292), //
	Im("im", 293), //
	Implies("implies", 294), //
	Import("import", 295), //
	Increment("increment", 296), //
	Indeterminate("indeterminate", 297), //
	Inequality("inequality", 298), //
	InexactNumberQ("inexactnumberq", 299), //
	Infinity("infinity", 300), //
	Information("information", 301), //
	Inner("inner", 302), //
	Insert("insert", 303), //
	Integer("integer", 304), //
	IntegerExponent("integerexponent", 305), //
	IntegerLength("integerlength", 306), //
	IntegerPart("integerpart", 307), //
	IntegerPartitions("integerpartitions", 308), //
	IntegerQ("integerq", 309), //
	Integers("integers", 310), //
	Integrate("integrate", 311), //
	InterpolatingFunction("interpolatingfunction", 312), //
	InterpolatingPolynomial("interpolatingpolynomial", 313), //
	Interpolation("interpolation", 314), //
	Intersection("intersection", 315), //
	Interval("interval", 316), //
	Inverse("inverse", 317), //
	InverseBetaRegularized("inversebetaregularized", 318), //
	InverseErf("inverseerf", 319), //
	InverseErfc("inverseerfc", 320), //
	InverseFunction("inversefunction", 321), //
	InverseGammaRegularized("inversegammaregularized", 322), //
	InverseHaversine("inversehaversine", 323), //
	InverseLaplaceTransform("inverselaplacetransform", 324), //
	InverseSeries("inverseseries", 325), //
	JaccardDissimilarity("jaccarddissimilarity", 326), //
	JacobiMatrix("jacobimatrix", 327), //
	JacobiSymbol("jacobisymbol", 328), //
	JacobiZeta("jacobizeta", 329), //
	JavaForm("javaform", 330), //
	Join("join", 331), //
	KOrderlessPartitions("korderlesspartitions", 332), //
	KPartitions("kpartitions", 333), //
	Khinchin("khinchin", 334), //
	KroneckerDelta("kroneckerdelta", 335), //
	Kurtosis("kurtosis", 336), //
	LCM("lcm", 337), //
	LUDecomposition("ludecomposition", 338), //
	LaguerreL("laguerrel", 339), //
	LaplaceTransform("laplacetransform", 340), //
	Last("last", 341), //
	LeafCount("leafcount", 342), //
	LeastSquares("leastsquares", 343), //
	LegendreP("legendrep", 344), //
	LegendreQ("legendreq", 345), //
	Length("length", 346), //
	Less("less", 347), //
	LessEqual("lessequal", 348), //
	LetterQ("letterq", 349), //
	Level("level", 350), //
	LevelQ("levelq", 351), //
	Limit("limit", 352), //
	Line("line", 353), //
	LinearModelFit("linearmodelfit", 354), //
	LinearProgramming("linearprogramming", 355), //
	LinearSolve("linearsolve", 356), //
	LiouvilleLambda("liouvillelambda", 357), //
	List("list", 358), //
	ListConvolve("listconvolve", 359), //
	ListCorrelate("listcorrelate", 360), //
	ListQ("listq", 361), //
	Listable("listable", 362), //
	Literal("literal", 363), //
	Log("log", 364), //
	Log10("log10", 365), //
	Log2("log2", 366), //
	LogGamma("loggamma", 367), //
	LogIntegral("logintegral", 368), //
	LogNormalDistribution("lognormaldistribution", 369), //
	LogicalExpand("logicalexpand", 370), //
	LogisticSigmoid("logisticsigmoid", 371), //
	LowerCaseQ("lowercaseq", 372), //
	LowerTriangularize("lowertriangularize", 373), //
	LucasL("lucasl", 374), //
	MachineNumberQ("machinenumberq", 375), //
	MangoldtLambda("mangoldtlambda", 376), //
	ManhattanDistance("manhattandistance", 377), //
	MantissaExponent("mantissaexponent", 378), //
	Map("map", 379), //
	MapAll("mapall", 380), //
	MapAt("mapat", 381), //
	MapThread("mapthread", 382), //
	MatchQ("matchq", 383), //
	MatchingDissimilarity("matchingdissimilarity", 384), //
	MathMLForm("mathmlform", 385), //
	MatrixForm("matrixform", 386), //
	MatrixMinimalPolynomial("matrixminimalpolynomial", 387), //
	MatrixPower("matrixpower", 388), //
	MatrixQ("matrixq", 389), //
	MatrixRank("matrixrank", 390), //
	Max("max", 391), //
	MaxIterations("maxiterations", 392), //
	MaxPoints("maxpoints", 393), //
	Mean("mean", 394), //
	MeanDeviation("meandeviation", 395), //
	Median("median", 396), //
	MeijerG("meijerg", 397), //
	MemberQ("memberq", 398), //
	MersennePrimeExponent("mersenneprimeexponent", 399), //
	MersennePrimeExponentQ("mersenneprimeexponentq", 400), //
	MeshRange("meshrange", 401), //
	MessageName("messagename", 402), //
	Method("method", 403), //
	Min("min", 404), //
	MinimalPolynomial("minimalpolynomial", 405), //
	Minus("minus", 406), //
	Missing("missing", 407), //
	MissingQ("missingq", 408), //
	Mod("mod", 409), //
	Module("module", 410), //
	Modulus("modulus", 411), //
	MoebiusMu("moebiusmu", 412), //
	MonomialList("monomiallist", 413), //
	Most("most", 414), //
	Multinomial("multinomial", 415), //
	MultiplicativeOrder("multiplicativeorder", 416), //
	N("N", 417), //
	NDSolve("ndsolve", 418), //
	NFourierTransform("nfouriertransform", 419), //
	NHoldAll("nholdall", 420), //
	NHoldFirst("nholdfirst", 421), //
	NHoldRest("nholdrest", 422), //
	NIntegrate("nintegrate", 423), //
	NMaximize("nmaximize", 424), //
	NMinimize("nminimize", 425), //
	NRoots("nroots", 426), //
	NSolve("nsolve", 427), //
	NakagamiDistribution("nakagamidistribution", 428), //
	Names("names", 429), //
	Nand("nand", 430), //
	Nearest("nearest", 431), //
	Negative("negative", 432), //
	Nest("nest", 433), //
	NestList("nestlist", 434), //
	NestWhile("nestwhile", 435), //
	NestWhileList("nestwhilelist", 436), //
	NextPrime("nextprime", 437), //
	NonCommutativeMultiply("noncommutativemultiply", 438), //
	NonNegative("nonnegative", 439), //
	NonPositive("nonpositive", 440), //
	None("none", 441), //
	NoneTrue("nonetrue", 442), //
	Nonexistent("nonexistent", 443), //
	Nor("nor", 444), //
	Norm("norm", 445), //
	Normal("normal", 446), //
	NormalDistribution("normaldistribution", 447), //
	Normalize("normalize", 448), //
	Not("not", 449), //
	NotApplicable("notapplicable", 450), //
	NotAvailable("notavailable", 451), //
	NotListQ("notlistq", 452), //
	Null("null", 453), //
	NullSpace("nullspace", 454), //
	NumberFieldRootsOfUnity("numberfieldrootsofunity", 455), //
	NumberQ("numberq", 456), //
	Numerator("numerator", 457), //
	NumericFunction("numericfunction", 458), //
	NumericQ("numericq", 459), //
	O("O", 460), //
	OddQ("oddq", 461), //
	OneIdentity("oneidentity", 462), //
	Operate("operate", 463), //
	Optional("optional", 464), //
	Options("options", 465), //
	Or("or", 466), //
	Order("order", 467), //
	OrderedQ("orderedq", 468), //
	Ordering("ordering", 469), //
	Orderless("orderless", 470), //
	OrthogonalMatrixQ("orthogonalmatrixq", 471), //
	Orthogonalize("orthogonalize", 472), //
	Out("out", 473), //
	Outer("outer", 474), //
	PDF("pdf", 475), //
	Package("package", 476), //
	PadLeft("padleft", 477), //
	PadRight("padright", 478), //
	ParametricPlot("parametricplot", 479), //
	Part("part", 480), //
	Partition("partition", 481), //
	PartitionsP("partitionsp", 482), //
	PartitionsQ("partitionsq", 483), //
	Pattern("pattern", 484), //
	PatternTest("patterntest", 485), //
	PerfectNumber("perfectnumber", 486), //
	PerfectNumberQ("perfectnumberq", 487), //
	Permutations("permutations", 488), //
	Pi("pi", 489), //
	Piecewise("piecewise", 490), //
	Plot("plot", 491), //
	Plot3D("plot3d", 492), //
	PlotRange("plotrange", 493), //
	Plus("plus", 494), //
	Pochhammer("pochhammer", 495), //
	Point("point", 496), //
	PoissonDistribution("poissondistribution", 497), //
	PolyGamma("polygamma", 498), //
	PolyLog("polylog", 499), //
	Polygon("polygon", 500), //
	PolynomialExtendedGCD("polynomialextendedgcd", 501), //
	PolynomialGCD("polynomialgcd", 502), //
	PolynomialLCM("polynomiallcm", 503), //
	PolynomialQ("polynomialq", 504), //
	PolynomialQuotient("polynomialquotient", 505), //
	PolynomialQuotientRemainder("polynomialquotientremainder", 506), //
	PolynomialRemainder("polynomialremainder", 507), //
	Position("position", 508), //
	Positive("positive", 509), //
	PossibleZeroQ("possiblezeroq", 510), //
	Power("power", 511), //
	PowerExpand("powerexpand", 512), //
	PowerMod("powermod", 513), //
	PreDecrement("predecrement", 514), //
	PreIncrement("preincrement", 515), //
	PrePlus("preplus", 516), //
	Precision("precision", 517), //
	PrecisionGoal("precisiongoal", 518), //
	Prepend("prepend", 519), //
	PrependTo("prependto", 520), //
	Prime("prime", 521), //
	PrimeOmega("primeomega", 522), //
	PrimePi("primepi", 523), //
	PrimePowerQ("primepowerq", 524), //
	PrimeQ("primeq", 525), //
	Primes("primes", 526), //
	PrimitiveRootList("primitiverootlist", 527), //
	Print("print", 528), //
	Product("product", 529), //
	ProductLog("productlog", 530), //
	Projection("projection", 531), //
	PseudoInverse("pseudoinverse", 532), //
	Put("put", 533), //
	QRDecomposition("qrdecomposition", 534), //
	Quantile("quantile", 535), //
	Quiet("quiet", 536), //
	Quit("quit", 537), //
	Quotient("quotient", 538), //
	QuotientRemainder("quotientremainder", 539), //
	RandomChoice("randomchoice", 540), //
	RandomInteger("randominteger", 541), //
	RandomReal("randomreal", 542), //
	RandomSample("randomsample", 543), //
	RandomVariate("randomvariate", 544), //
	Range("range", 545), //
	Rational("rational", 546), //
	Rationalize("rationalize", 547), //
	Rationals("rationals", 548), //
	Re("re", 549), //
	Real("real", 550), //
	RealNumberQ("realnumberq", 551), //
	Reals("reals", 552), //
	Reap("reap", 553), //
	Rectangle("rectangle", 554), //
	Reduce("reduce", 555), //
	Refine("refine", 556), //
	Repeated("repeated", 557), //
	RepeatedNull("repeatednull", 558), //
	Replace("replace", 559), //
	ReplaceAll("replaceall", 560), //
	ReplaceList("replacelist", 561), //
	ReplacePart("replacepart", 562), //
	ReplaceRepeated("replacerepeated", 563), //
	Rest("rest", 564), //
	Resultant("resultant", 565), //
	Return("return", 566), //
	Reverse("reverse", 567), //
	Riffle("riffle", 568), //
	RogersTanimotoDissimilarity("rogerstanimotodissimilarity", 569), //
	Root("root", 570), //
	RootIntervals("rootintervals", 571), //
	RootOf("rootof", 572), //
	Roots("roots", 573), //
	RotateLeft("rotateleft", 574), //
	RotateRight("rotateright", 575), //
	Round("round", 576), //
	RowReduce("rowreduce", 577), //
	Rule("rule", 578), //
	RuleDelayed("ruledelayed", 579), //
	RussellRaoDissimilarity("russellraodissimilarity", 580), //
	SameQ("sameq", 581), //
	SatisfiabilityCount("satisfiabilitycount", 582), //
	SatisfiabilityInstances("satisfiabilityinstances", 583), //
	SatisfiableQ("satisfiableq", 584), //
	Scan("scan", 585), //
	Sec("sec", 586), //
	Sech("sech", 587), //
	Second("second", 588), //
	Select("select", 589), //
	Sequence("sequence", 590), //
	Series("series", 591), //
	SeriesCoefficient("seriescoefficient", 592), //
	SeriesData("seriesdata", 593), //
	Set("set", 594), //
	SetAttributes("setattributes", 595), //
	SetDelayed("setdelayed", 596), //
	Share("share", 597), //
	Show("show", 598), //
	Sign("sign", 599), //
	SignCmp("signcmp", 600), //
	Simplify("simplify", 601), //
	Sin("sin", 602), //
	SinIntegral("sinintegral", 603), //
	Sinc("sinc", 604), //
	SingularValueDecomposition("singularvaluedecomposition", 605), //
	Sinh("sinh", 606), //
	SinhIntegral("sinhintegral", 607), //
	Skewness("skewness", 608), //
	Slot("slot", 609), //
	SlotSequence("slotsequence", 610), //
	SokalSneathDissimilarity("sokalsneathdissimilarity", 611), //
	Solve("solve", 612), //
	Sort("sort", 613), //
	Sow("sow", 614), //
	Span("span", 615), //
	Split("split", 616), //
	SplitBy("splitby", 617), //
	Sqrt("sqrt", 618), //
	SquareFreeQ("squarefreeq", 619), //
	SquaredEuclideanDistance("squaredeuclideandistance", 620), //
	StandardDeviation("standarddeviation", 621), //
	Standardize("standardize", 622), //
	StieltjesGamma("stieltjesgamma", 623), //
	StirlingS1("stirlings1", 624), //
	StirlingS2("stirlings2", 625), //
	String("string", 626), //
	StringDrop("stringdrop", 627), //
	StringJoin("stringjoin", 628), //
	StringLength("stringlength", 629), //
	StringTake("stringtake", 630), //
	StruveH("struveh", 631), //
	StruveL("struvel", 632), //
	StudentTDistribution("studenttdistribution", 633), //
	Subfactorial("subfactorial", 634), //
	Subscript("subscript", 635), //
	Subsets("subsets", 636), //
	Subsuperscript("subsuperscript", 637), //
	Subtract("subtract", 638), //
	SubtractFrom("subtractfrom", 639), //
	Sum("sum", 640), //
	Superscript("superscript", 641), //
	Surd("surd", 642), //
	SurfaceGraphics("surfacegraphics", 643), //
	Switch("switch", 644), //
	Symbol("symbol", 645), //
	SymbolName("symbolname", 646), //
	SymbolQ("symbolq", 647), //
	SymmetricMatrixQ("symmetricmatrixq", 648), //
	SyntaxLength("syntaxlength", 649), //
	SyntaxQ("syntaxq", 650), //
	Table("table", 651), //
	Take("take", 652), //
	Tally("tally", 653), //
	Tan("tan", 654), //
	Tanh("tanh", 655), //
	TautologyQ("tautologyq", 656), //
	Taylor("taylor", 657), //
	TeXForm("texform", 658), //
	TensorDimensions("tensordimensions", 659), //
	TensorProduct("tensorproduct", 660), //
	TensorRank("tensorrank", 661), //
	Thread("thread", 662), //
	Through("through", 663), //
	Throw("throw", 664), //
	TimeConstrained("timeconstrained", 665), //
	Times("times", 666), //
	TimesBy("timesby", 667), //
	Timing("timing", 668), //
	ToCharacterCode("tocharactercode", 669), //
	ToPolarCoordinates("topolarcoordinates", 670), //
	ToRadicals("toradicals", 671), //
	ToString("tostring", 672), //
	ToUnicode("tounicode", 673), //
	ToeplitzMatrix("toeplitzmatrix", 674), //
	Together("together", 675), //
	TooLarge("toolarge", 676), //
	Total("total", 677), //
	Tr("tr", 678), //
	Trace("trace", 679), //
	Transpose("transpose", 680), //
	Trig("trig", 681), //
	TrigExpand("trigexpand", 682), //
	TrigReduce("trigreduce", 683), //
	TrigToExp("trigtoexp", 684), //
	True("true", 685), //
	TrueQ("trueq", 686), //
	Tuples("tuples", 687), //
	Undefined("undefined", 688), //
	Unequal("unequal", 689), //
	Unevaluated("unevaluated", 690), //
	Union("union", 691), //
	Unique("unique", 692), //
	UnitStep("unitstep", 693), //
	UnitVector("unitvector", 694), //
	UnitaryMatrixQ("unitarymatrixq", 695), //
	Unitize("unitize", 696), //
	Unknown("unknown", 697), //
	UnsameQ("unsameq", 698), //
	Unset("unset", 699), //
	UpSet("upset", 700), //
	UpSetDelayed("upsetdelayed", 701), //
	UpperCaseQ("uppercaseq", 702), //
	UpperTriangularize("uppertriangularize", 703), //
	ValueQ("valueq", 704), //
	VandermondeMatrix("vandermondematrix", 705), //
	Variable("variable", 706), //
	Variables("variables", 707), //
	Variance("variance", 708), //
	VectorAngle("vectorangle", 709), //
	VectorQ("vectorq", 710), //
	WeibullDistribution("weibulldistribution", 711), //
	Which("which", 712), //
	While("while", 713), //
	White("white", 714), //
	With("with", 715), //
	Xor("xor", 716), //
	YuleDissimilarity("yuledissimilarity", 717), //
	Zeta("zeta", 718);

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