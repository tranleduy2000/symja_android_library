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
 Distributed( "distributed", 167 ), //
 Divergence( "divergence", 168 ), //
 Divide( "divide", 169 ), //
 DivideBy( "divideby", 170 ), //
 Divisible( "divisible", 171 ), //
 DivisorSigma( "divisorsigma", 172 ), //
 Divisors( "divisors", 173 ), //
 Do( "do", 174 ), //
 Dot( "dot", 175 ), //
 Drop( "drop", 176 ), //
 E( "E", 177 ), //
 EasterSunday( "eastersunday", 178 ), //
 Eigenvalues( "eigenvalues", 179 ), //
 Eigenvectors( "eigenvectors", 180 ), //
 Element( "element", 181 ), //
 ElementData( "elementdata", 182 ), //
 Eliminate( "eliminate", 183 ), //
 EllipticE( "elliptice", 184 ), //
 EllipticF( "ellipticf", 185 ), //
 EllipticK( "elliptick", 186 ), //
 EllipticPi( "ellipticpi", 187 ), //
 End( "end", 188 ), //
 EndPackage( "endpackage", 189 ), //
 Equal( "equal", 190 ), //
 Equivalent( "equivalent", 191 ), //
 Erf( "erf", 192 ), //
 Erfc( "erfc", 193 ), //
 Erfi( "erfi", 194 ), //
 ErlangDistribution( "erlangdistribution", 195 ), //
 EuclideanDistance( "euclideandistance", 196 ), //
 EulerE( "eulere", 197 ), //
 EulerGamma( "eulergamma", 198 ), //
 EulerPhi( "eulerphi", 199 ), //
 EvenQ( "evenq", 200 ), //
 ExactNumberQ( "exactnumberq", 201 ), //
 Except( "except", 202 ), //
 Exists( "exists", 203 ), //
 Exp( "exp", 204 ), //
 ExpIntegralE( "expintegrale", 205 ), //
 ExpIntegralEi( "expintegralei", 206 ), //
 Expand( "expand", 207 ), //
 ExpandAll( "expandall", 208 ), //
 Expectation( "expectation", 209 ), //
 Exponent( "exponent", 210 ), //
 ExponentialDistribution( "exponentialdistribution", 211 ), //
 Export( "export", 212 ), //
 ExtendedGCD( "extendedgcd", 213 ), //
 Extract( "extract", 214 ), //
 Factor( "factor", 215 ), //
 FactorInteger( "factorinteger", 216 ), //
 FactorSquareFree( "factorsquarefree", 217 ), //
 FactorSquareFreeList( "factorsquarefreelist", 218 ), //
 FactorTerms( "factorterms", 219 ), //
 Factorial( "factorial", 220 ), //
 Factorial2( "factorial2", 221 ), //
 False( "false", 222 ), //
 Fibonacci( "fibonacci", 223 ), //
 FindInstance( "findinstance", 224 ), //
 FindRoot( "findroot", 225 ), //
 First( "first", 226 ), //
 Fit( "fit", 227 ), //
 FixedPoint( "fixedpoint", 228 ), //
 FixedPointList( "fixedpointlist", 229 ), //
 Flat( "flat", 230 ), //
 Flatten( "flatten", 231 ), //
 FlattenAt( "flattenat", 232 ), //
 Floor( "floor", 233 ), //
 Fold( "fold", 234 ), //
 FoldList( "foldlist", 235 ), //
 For( "for", 236 ), //
 ForAll( "forall", 237 ), //
 FourierMatrix( "fouriermatrix", 238 ), //
 FractionalPart( "fractionalpart", 239 ), //
 FrechetDistribution( "frechetdistribution", 240 ), //
 FreeQ( "freeq", 241 ), //
 FresnelC( "fresnelc", 242 ), //
 FresnelS( "fresnels", 243 ), //
 FrobeniusNumber( "frobeniusnumber", 244 ), //
 FrobeniusSolve( "frobeniussolve", 245 ), //
 FromCharacterCode( "fromcharactercode", 246 ), //
 FromContinuedFraction( "fromcontinuedfraction", 247 ), //
 FromPolarCoordinates( "frompolarcoordinates", 248 ), //
 FullForm( "fullform", 249 ), //
 FullSimplify( "fullsimplify", 250 ), //
 Function( "function", 251 ), //
 GCD( "gcd", 252 ), //
 Gamma( "gamma", 253 ), //
 GammaDistribution( "gammadistribution", 254 ), //
 GammaRegularized( "gammaregularized", 255 ), //
 Gather( "gather", 256 ), //
 GegenbauerC( "gegenbauerc", 257 ), //
 GeometricDistribution( "geometricdistribution", 258 ), //
 GeometricMean( "geometricmean", 259 ), //
 Get( "get", 260 ), //
 Glaisher( "glaisher", 261 ), //
 GoldenRatio( "goldenratio", 262 ), //
 Graphics( "graphics", 263 ), //
 Graphics3D( "graphics3d", 264 ), //
 Greater( "greater", 265 ), //
 GreaterEqual( "greaterequal", 266 ), //
 GroebnerBasis( "groebnerbasis", 267 ), //
 GumbelDistribution( "gumbeldistribution", 268 ), //
 HarmonicNumber( "harmonicnumber", 269 ), //
 Haversine( "haversine", 270 ), //
 Head( "head", 271 ), //
 HeavisideTheta( "heavisidetheta", 272 ), //
 HermiteH( "hermiteh", 273 ), //
 HermitianMatrixQ( "hermitianmatrixq", 274 ), //
 HilbertMatrix( "hilbertmatrix", 275 ), //
 Hold( "hold", 276 ), //
 HoldAll( "holdall", 277 ), //
 HoldFirst( "holdfirst", 278 ), //
 HoldForm( "holdform", 279 ), //
 HoldPattern( "holdpattern", 280 ), //
 HoldRest( "holdrest", 281 ), //
 Horner( "horner", 282 ), //
 HornerForm( "hornerform", 283 ), //
 HurwitzZeta( "hurwitzzeta", 284 ), //
 Hypergeometric1F1( "hypergeometric1f1", 285 ), //
 Hypergeometric2F1( "hypergeometric2f1", 286 ), //
 HypergeometricDistribution( "hypergeometricdistribution", 287 ), //
 HypergeometricPFQ( "hypergeometricpfq", 288 ), //
 HypergeometricPFQRegularized( "hypergeometricpfqregularized", 289 ), //
 I( "I", 290 ), //
 Identity( "identity", 291 ), //
 IdentityMatrix( "identitymatrix", 292 ), //
 If( "if", 293 ), //
 Im( "im", 294 ), //
 Implies( "implies", 295 ), //
 Import( "import", 296 ), //
 Increment( "increment", 297 ), //
 Indeterminate( "indeterminate", 298 ), //
 Inequality( "inequality", 299 ), //
 InexactNumberQ( "inexactnumberq", 300 ), //
 Infinity( "infinity", 301 ), //
 Information( "information", 302 ), //
 Inner( "inner", 303 ), //
 Insert( "insert", 304 ), //
 Integer( "integer", 305 ), //
	IntegerDigits("integerdigits", 306), //
	IntegerExponent("integerexponent", 307), //
	IntegerLength("integerlength", 308), //
	IntegerPart("integerpart", 309), //
	IntegerPartitions("integerpartitions", 310), //
	IntegerQ("integerq", 311), //
	Integers("integers", 312), //
	Integrate("integrate", 313), //
	InterpolatingFunction("interpolatingfunction", 314), //
	InterpolatingPolynomial("interpolatingpolynomial", 315), //
	Interpolation("interpolation", 316), //
	Intersection("intersection", 317), //
	Interval("interval", 318), //
	Inverse("inverse", 319), //
	InverseBetaRegularized("inversebetaregularized", 320), //
	InverseErf("inverseerf", 321), //
	InverseErfc("inverseerfc", 322), //
	InverseFunction("inversefunction", 323), //
	InverseGammaRegularized("inversegammaregularized", 324), //
	InverseHaversine("inversehaversine", 325), //
	InverseLaplaceTransform("inverselaplacetransform", 326), //
	InverseSeries("inverseseries", 327), //
	JaccardDissimilarity("jaccarddissimilarity", 328), //
	JacobiMatrix("jacobimatrix", 329), //
	JacobiSymbol("jacobisymbol", 330), //
	JacobiZeta("jacobizeta", 331), //
	JavaForm("javaform", 332), //
	Join("join", 333), //
	KOrderlessPartitions("korderlesspartitions", 334), //
	KPartitions("kpartitions", 335), //
	Khinchin("khinchin", 336), //
	KroneckerDelta("kroneckerdelta", 337), //
	Kurtosis("kurtosis", 338), //
	LCM("lcm", 339), //
	LUDecomposition("ludecomposition", 340), //
	LaguerreL("laguerrel", 341), //
	LaplaceTransform("laplacetransform", 342), //
	Last("last", 343), //
	LeafCount("leafcount", 344), //
	LeastSquares("leastsquares", 345), //
	LegendreP("legendrep", 346), //
	LegendreQ("legendreq", 347), //
	Length("length", 348), //
	Less("less", 349), //
	LessEqual("lessequal", 350), //
	LetterQ("letterq", 351), //
	Level("level", 352), //
	LevelQ("levelq", 353), //
	Limit("limit", 354), //
	Line("line", 355), //
	LinearModelFit("linearmodelfit", 356), //
	LinearProgramming("linearprogramming", 357), //
	LinearSolve("linearsolve", 358), //
	LiouvilleLambda("liouvillelambda", 359), //
	List("list", 360), //
	ListConvolve("listconvolve", 361), //
	ListCorrelate("listcorrelate", 362), //
	ListQ("listq", 363), //
	Listable("listable", 364), //
	Literal("literal", 365), //
	Log("log", 366), //
	Log10("log10", 367), //
	Log2("log2", 368), //
	LogGamma("loggamma", 369), //
	LogIntegral("logintegral", 370), //
	LogNormalDistribution("lognormaldistribution", 371), //
	LogicalExpand("logicalexpand", 372), //
	LogisticSigmoid("logisticsigmoid", 373), //
	LowerCaseQ("lowercaseq", 374), //
	LowerTriangularize("lowertriangularize", 375), //
	LucasL("lucasl", 376), //
	MachineNumberQ("machinenumberq", 377), //
	MangoldtLambda("mangoldtlambda", 378), //
	ManhattanDistance("manhattandistance", 379), //
	MantissaExponent("mantissaexponent", 380), //
	Map("map", 381), //
	MapAll("mapall", 382), //
	MapAt("mapat", 383), //
	MapThread("mapthread", 384), //
	MatchQ("matchq", 385), //
	MatchingDissimilarity("matchingdissimilarity", 386), //
	MathMLForm("mathmlform", 387), //
	MatrixForm("matrixform", 388), //
	MatrixMinimalPolynomial("matrixminimalpolynomial", 389), //
	MatrixPower("matrixpower", 390), //
	MatrixQ("matrixq", 391), //
	MatrixRank("matrixrank", 392), //
	Max("max", 393), //
	MaxIterations("maxiterations", 394), //
	MaxPoints("maxpoints", 395), //
	Mean("mean", 396), //
	MeanDeviation("meandeviation", 397), //
	Median("median", 398), //
	MeijerG("meijerg", 399), //
	MemberQ("memberq", 400), //
	MersennePrimeExponent("mersenneprimeexponent", 401), //
	MersennePrimeExponentQ("mersenneprimeexponentq", 402), //
	MeshRange("meshrange", 403), //
	MessageName("messagename", 404), //
	Method("method", 405), //
	Min("min", 406), //
	MinimalPolynomial("minimalpolynomial", 407), //
	Minus("minus", 408), //
	Missing("missing", 409), //
	MissingQ("missingq", 410), //
	Mod("mod", 411), //
	Module("module", 412), //
	Modulus("modulus", 413), //
	MoebiusMu("moebiusmu", 414), //
	MonomialList("monomiallist", 415), //
	Most("most", 416), //
	Multinomial("multinomial", 417), //
	MultiplicativeOrder("multiplicativeorder", 418), //
	N("N", 419), //
	NDSolve("ndsolve", 420), //
	NFourierTransform("nfouriertransform", 421), //
	NHoldAll("nholdall", 422), //
	NHoldFirst("nholdfirst", 423), //
	NHoldRest("nholdrest", 424), //
	NIntegrate("nintegrate", 425), //
	NMaximize("nmaximize", 426), //
	NMinimize("nminimize", 427), //
	NRoots("nroots", 428), //
	NSolve("nsolve", 429), //
	NakagamiDistribution("nakagamidistribution", 430), //
	Names("names", 431), //
	Nand("nand", 432), //
	Nearest("nearest", 433), //
	Negative("negative", 434), //
	Nest("nest", 435), //
	NestList("nestlist", 436), //
	NestWhile("nestwhile", 437), //
	NestWhileList("nestwhilelist", 438), //
	NextPrime("nextprime", 439), //
	NonCommutativeMultiply("noncommutativemultiply", 440), //
	NonNegative("nonnegative", 441), //
	NonPositive("nonpositive", 442), //
	None("none", 443), //
	NoneTrue("nonetrue", 444), //
	Nonexistent("nonexistent", 445), //
	Nor("nor", 446), //
	Norm("norm", 447), //
	Normal("normal", 448), //
	NormalDistribution("normaldistribution", 449), //
	Normalize("normalize", 450), //
	Not("not", 451), //
	NotApplicable("notapplicable", 452), //
	NotAvailable("notavailable", 453), //
	NotListQ("notlistq", 454), //
	Null("null", 455), //
	NullSpace("nullspace", 456), //
	NumberFieldRootsOfUnity("numberfieldrootsofunity", 457), //
	NumberQ("numberq", 458), //
	Numerator("numerator", 459), //
	NumericFunction("numericfunction", 460), //
	NumericQ("numericq", 461), //
	O("O", 462), //
	OddQ("oddq", 463), //
	OneIdentity("oneidentity", 464), //
	Operate("operate", 465), //
	Optional("optional", 466), //
	Options("options", 467), //
	Or("or", 468), //
	Order("order", 469), //
	OrderedQ("orderedq", 470), //
	Ordering("ordering", 471), //
	Orderless("orderless", 472), //
	OrthogonalMatrixQ("orthogonalmatrixq", 473), //
	Orthogonalize("orthogonalize", 474), //
	Out("out", 475), //
	Outer("outer", 476), //
	PDF("pdf", 477), //
	Package("package", 478), //
	PadLeft("padleft", 479), //
	PadRight("padright", 480), //
	ParametricPlot("parametricplot", 481), //
	Part("part", 482), //
	Partition("partition", 483), //
	PartitionsP("partitionsp", 484), //
	PartitionsQ("partitionsq", 485), //
	Pattern("pattern", 486), //
	PatternTest("patterntest", 487), //
	PerfectNumber("perfectnumber", 488), //
	PerfectNumberQ("perfectnumberq", 489), //
	Permutations("permutations", 490), //
	Pi("pi", 491), //
	Piecewise("piecewise", 492), //
	Plot("plot", 493), //
	Plot3D("plot3d", 494), //
	PlotRange("plotrange", 495), //
	Plus("plus", 496), //
	Pochhammer("pochhammer", 497), //
	Point("point", 498), //
	PoissonDistribution("poissondistribution", 499), //
	PolyGamma("polygamma", 500), //
	PolyLog("polylog", 501), //
	Polygon("polygon", 502), //
	PolynomialExtendedGCD("polynomialextendedgcd", 503), //
	PolynomialGCD("polynomialgcd", 504), //
	PolynomialLCM("polynomiallcm", 505), //
	PolynomialQ("polynomialq", 506), //
	PolynomialQuotient("polynomialquotient", 507), //
	PolynomialQuotientRemainder("polynomialquotientremainder", 508), //
	PolynomialRemainder("polynomialremainder", 509), //
	Position("position", 510), //
	Positive("positive", 511), //
	PossibleZeroQ("possiblezeroq", 512), //
	Power("power", 513), //
	PowerExpand("powerexpand", 514), //
	PowerMod("powermod", 515), //
	PreDecrement("predecrement", 516), //
	PreIncrement("preincrement", 517), //
	PrePlus("preplus", 518), //
	Precision("precision", 519), //
	PrecisionGoal("precisiongoal", 520), //
	Prepend("prepend", 521), //
	PrependTo("prependto", 522), //
	Prime("prime", 523), //
	PrimeOmega("primeomega", 524), //
	PrimePi("primepi", 525), //
	PrimePowerQ("primepowerq", 526), //
	PrimeQ("primeq", 527), //
	Primes("primes", 528), //
	PrimitiveRootList("primitiverootlist", 529), //
	Print("print", 530), //
	Product("product", 531), //
	ProductLog("productlog", 532), //
	Projection("projection", 533), //
	PseudoInverse("pseudoinverse", 534), //
	Put("put", 535), //
	QRDecomposition("qrdecomposition", 536), //
	Quantile("quantile", 537), //
	Quiet("quiet", 538), //
	Quit("quit", 539), //
	Quotient("quotient", 540), //
	QuotientRemainder("quotientremainder", 541), //
	RandomChoice("randomchoice", 542), //
	RandomInteger("randominteger", 543), //
	RandomReal("randomreal", 544), //
	RandomSample("randomsample", 545), //
	RandomVariate("randomvariate", 546), //
	Range("range", 547), //
	Rational("rational", 548), //
	Rationalize("rationalize", 549), //
	Rationals("rationals", 550), //
	Re("re", 551), //
	Real("real", 552), //
	RealNumberQ("realnumberq", 553), //
	Reals("reals", 554), //
	Reap("reap", 555), //
	Rectangle("rectangle", 556), //
	Reduce("reduce", 557), //
	Refine("refine", 558), //
	Repeated("repeated", 559), //
	RepeatedNull("repeatednull", 560), //
	Replace("replace", 561), //
	ReplaceAll("replaceall", 562), //
	ReplaceList("replacelist", 563), //
	ReplacePart("replacepart", 564), //
	ReplaceRepeated("replacerepeated", 565), //
	Rest("rest", 566), //
	Resultant("resultant", 567), //
	Return("return", 568), //
	Reverse("reverse", 569), //
	Riffle("riffle", 570), //
	RogersTanimotoDissimilarity("rogerstanimotodissimilarity", 571), //
	Root("root", 572), //
	RootIntervals("rootintervals", 573), //
	RootOf("rootof", 574), //
	Roots("roots", 575), //
	RotateLeft("rotateleft", 576), //
	RotateRight("rotateright", 577), //
	Round("round", 578), //
	RowReduce("rowreduce", 579), //
	Rule("rule", 580), //
	RuleDelayed("ruledelayed", 581), //
	RussellRaoDissimilarity("russellraodissimilarity", 582), //
	SameQ("sameq", 583), //
	SatisfiabilityCount("satisfiabilitycount", 584), //
	SatisfiabilityInstances("satisfiabilityinstances", 585), //
	SatisfiableQ("satisfiableq", 586), //
	Scan("scan", 587), //
	Sec("sec", 588), //
	Sech("sech", 589), //
	Second("second", 590), //
	Select("select", 591), //
	Sequence("sequence", 592), //
	Series("series", 593), //
	SeriesCoefficient("seriescoefficient", 594), //
	SeriesData("seriesdata", 595), //
	Set("set", 596), //
	SetAttributes("setattributes", 597), //
	SetDelayed("setdelayed", 598), //
	Share("share", 599), //
	Show("show", 600), //
	Sign("sign", 601), //
	SignCmp("signcmp", 602), //
	Simplify("simplify", 603), //
	Sin("sin", 604), //
	SinIntegral("sinintegral", 605), //
	Sinc("sinc", 606), //
	SingularValueDecomposition("singularvaluedecomposition", 607), //
	Sinh("sinh", 608), //
	SinhIntegral("sinhintegral", 609), //
	Skewness("skewness", 610), //
	Slot("slot", 611), //
	SlotSequence("slotsequence", 612), //
	SokalSneathDissimilarity("sokalsneathdissimilarity", 613), //
	Solve("solve", 614), //
	Sort("sort", 615), //
	Sow("sow", 616), //
	Span("span", 617), //
	Split("split", 618), //
	SplitBy("splitby", 619), //
	Sqrt("sqrt", 620), //
	SquareFreeQ("squarefreeq", 621), //
	SquaredEuclideanDistance("squaredeuclideandistance", 622), //
	StandardDeviation("standarddeviation", 623), //
	Standardize("standardize", 624), //
	StieltjesGamma("stieltjesgamma", 625), //
	StirlingS1("stirlings1", 626), //
	StirlingS2("stirlings2", 627), //
	String("string", 628), //
	StringDrop("stringdrop", 629), //
	StringJoin("stringjoin", 630), //
	StringLength("stringlength", 631), //
	StringTake("stringtake", 632), //
	StruveH("struveh", 633), //
	StruveL("struvel", 634), //
	StudentTDistribution("studenttdistribution", 635), //
 Subdivide( "subdivide", 636 ), //
 Subfactorial( "subfactorial", 637 ), //
 Subscript( "subscript", 638 ), //
 Subsets( "subsets", 639 ), //
 Subsuperscript( "subsuperscript", 640 ), //
 Subtract( "subtract", 641 ), //
 SubtractFrom( "subtractfrom", 642 ), //
 Sum( "sum", 643 ), //
 Superscript( "superscript", 644 ), //
 Surd( "surd", 645 ), //
 SurfaceGraphics( "surfacegraphics", 646 ), //
 Switch( "switch", 647 ), //
 Symbol( "symbol", 648 ), //
 SymbolName( "symbolname", 649 ), //
 SymbolQ( "symbolq", 650 ), //
 SymmetricMatrixQ( "symmetricmatrixq", 651 ), //
 SyntaxLength( "syntaxlength", 652 ), //
 SyntaxQ( "syntaxq", 653 ), //
 Table( "table", 654 ), //
 Take( "take", 655 ), //
 Tally( "tally", 656 ), //
 Tan( "tan", 657 ), //
 Tanh( "tanh", 658 ), //
 TautologyQ( "tautologyq", 659 ), //
 Taylor( "taylor", 660 ), //
 TeXForm( "texform", 661 ), //
 TensorDimensions( "tensordimensions", 662 ), //
 TensorProduct( "tensorproduct", 663 ), //
 TensorRank( "tensorrank", 664 ), //
 Thread( "thread", 665 ), //
 Through( "through", 666 ), //
 Throw( "throw", 667 ), //
 TimeConstrained( "timeconstrained", 668 ), //
 Times( "times", 669 ), //
 TimesBy( "timesby", 670 ), //
 Timing( "timing", 671 ), //
 ToCharacterCode( "tocharactercode", 672 ), //
 ToPolarCoordinates( "topolarcoordinates", 673 ), //
 ToRadicals( "toradicals", 674 ), //
 ToString( "tostring", 675 ), //
 ToUnicode( "tounicode", 676 ), //
 ToeplitzMatrix( "toeplitzmatrix", 677 ), //
 Together( "together", 678 ), //
 TooLarge( "toolarge", 679 ), //
 Total( "total", 680 ), //
 Tr( "tr", 681 ), //
 Trace( "trace", 682 ), //
 Transpose( "transpose", 683 ), //
 Trig( "trig", 684 ), //
 TrigExpand( "trigexpand", 685 ), //
 TrigReduce( "trigreduce", 686 ), //
 TrigToExp( "trigtoexp", 687 ), //
 True( "true", 688 ), //
 TrueQ( "trueq", 689 ), //
 Tuples( "tuples", 690 ), //
 Undefined( "undefined", 691 ), //
 Unequal( "unequal", 692 ), //
 Unevaluated( "unevaluated", 693 ), //
 Union( "union", 694 ), //
 Unique( "unique", 695 ), //
 UnitStep( "unitstep", 696 ), //
 UnitVector( "unitvector", 697 ), //
 UnitaryMatrixQ( "unitarymatrixq", 698 ), //
 Unitize( "unitize", 699 ), //
 Unknown( "unknown", 700 ), //
 UnsameQ( "unsameq", 701 ), //
 Unset( "unset", 702 ), //
 UpSet( "upset", 703 ), //
 UpSetDelayed( "upsetdelayed", 704 ), //
 UpperCaseQ( "uppercaseq", 705 ), //
 UpperTriangularize( "uppertriangularize", 706 ), //
 ValueQ( "valueq", 707 ), //
 VandermondeMatrix( "vandermondematrix", 708 ), //
 Variable( "variable", 709 ), //
 Variables( "variables", 710 ), //
 Variance( "variance", 711 ), //
 VectorAngle( "vectorangle", 712 ), //
 VectorQ( "vectorq", 713 ), //
 WeibullDistribution( "weibulldistribution", 714 ), //
 Which( "which", 715 ), //
 While( "while", 716 ), //
 White( "white", 717 ), //
 With( "with", 718 ), //
 Xor( "xor", 719 ), //
 YuleDissimilarity( "yuledissimilarity", 720 ), //
 Zeta( "zeta", 721 );

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
