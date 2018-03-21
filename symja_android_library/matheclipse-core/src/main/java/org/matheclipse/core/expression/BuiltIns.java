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
 Conjugate( "conjugate", 115 ), //
 ConjugateTranspose( "conjugatetranspose", 116 ), //
 Constant( "constant", 117 ), //
 ConstantArray( "constantarray", 118 ), //
 Continue( "continue", 119 ), //
 ContinuedFraction( "continuedfraction", 120 ), //
 ConvexHullMesh( "convexhullmesh", 121 ), //
 CoprimeQ( "coprimeq", 122 ), //
 Correlation( "correlation", 123 ), //
 Cos( "cos", 124 ), //
 CosIntegral( "cosintegral", 125 ), //
 Cosh( "cosh", 126 ), //
 CoshIntegral( "coshintegral", 127 ), //
 CosineDistance( "cosinedistance", 128 ), //
 Cot( "cot", 129 ), //
 Coth( "coth", 130 ), //
 Count( "count", 131 ), //
 Covariance( "covariance", 132 ), //
 Cross( "cross", 133 ), //
 Csc( "csc", 134 ), //
 Csch( "csch", 135 ), //
 CubeRoot( "cuberoot", 136 ), //
 Curl( "curl", 137 ), //
 D( "D", 138 ), //
 DSolve( "dsolve", 139 ), //
 Decrement( "decrement", 140 ), //
 Default( "default", 141 ), //
 Defer( "defer", 142 ), //
 Definition( "definition", 143 ), //
 Degree( "degree", 144 ), //
 Delete( "delete", 145 ), //
 DeleteCases( "deletecases", 146 ), //
 DeleteDuplicates( "deleteduplicates", 147 ), //
 Denominator( "denominator", 148 ), //
 Depth( "depth", 149 ), //
 Derivative( "derivative", 150 ), //
 DesignMatrix( "designmatrix", 151 ), //
 Det( "det", 152 ), //
 Diagonal( "diagonal", 153 ), //
 DiagonalMatrix( "diagonalmatrix", 154 ), //
 DiceDissimilarity( "dicedissimilarity", 155 ), //
 DigitQ( "digitq", 156 ), //
 Dimensions( "dimensions", 157 ), //
 DiracDelta( "diracdelta", 158 ), //
 DirectedInfinity( "directedinfinity", 159 ), //
 Direction( "direction", 160 ), //
 DiscreteDelta( "discretedelta", 161 ), //
 DiscreteUniformDistribution( "discreteuniformdistribution", 162 ), //
 Discriminant( "discriminant", 163 ), //
 Disputed( "disputed", 164 ), //
 Distribute( "distribute", 165 ), //
 Divergence( "divergence", 166 ), //
 Divide( "divide", 167 ), //
 DivideBy( "divideby", 168 ), //
 Divisible( "divisible", 169 ), //
 DivisorSigma( "divisorsigma", 170 ), //
 Divisors( "divisors", 171 ), //
 Do( "do", 172 ), //
 Dot( "dot", 173 ), //
 Drop( "drop", 174 ), //
 E( "E", 175 ), //
 EasterSunday( "eastersunday", 176 ), //
 Eigenvalues( "eigenvalues", 177 ), //
 Eigenvectors( "eigenvectors", 178 ), //
 Element( "element", 179 ), //
 ElementData( "elementdata", 180 ), //
 Eliminate( "eliminate", 181 ), //
 EllipticE( "elliptice", 182 ), //
 EllipticF( "ellipticf", 183 ), //
 EllipticK( "elliptick", 184 ), //
 EllipticPi( "ellipticpi", 185 ), //
 End( "end", 186 ), //
 EndPackage( "endpackage", 187 ), //
 Equal( "equal", 188 ), //
 Equivalent( "equivalent", 189 ), //
 Erf( "erf", 190 ), //
 Erfc( "erfc", 191 ), //
 Erfi( "erfi", 192 ), //
 ErlangDistribution( "erlangdistribution", 193 ), //
 EuclideanDistance( "euclideandistance", 194 ), //
 EulerE( "eulere", 195 ), //
 EulerGamma( "eulergamma", 196 ), //
 EulerPhi( "eulerphi", 197 ), //
 EvenQ( "evenq", 198 ), //
 ExactNumberQ( "exactnumberq", 199 ), //
 Except( "except", 200 ), //
 Exists( "exists", 201 ), //
 Exp( "exp", 202 ), //
 ExpIntegralE( "expintegrale", 203 ), //
 ExpIntegralEi( "expintegralei", 204 ), //
 Expand( "expand", 205 ), //
 ExpandAll( "expandall", 206 ), //
 Expectation( "expectation", 207 ), //
 Exponent( "exponent", 208 ), //
 ExponentialDistribution( "exponentialdistribution", 209 ), //
 Export( "export", 210 ), //
 ExtendedGCD( "extendedgcd", 211 ), //
 Extract( "extract", 212 ), //
 Factor( "factor", 213 ), //
 FactorInteger( "factorinteger", 214 ), //
 FactorSquareFree( "factorsquarefree", 215 ), //
 FactorSquareFreeList( "factorsquarefreelist", 216 ), //
 FactorTerms( "factorterms", 217 ), //
 Factorial( "factorial", 218 ), //
 Factorial2( "factorial2", 219 ), //
 False( "false", 220 ), //
 Fibonacci( "fibonacci", 221 ), //
 FindInstance( "findinstance", 222 ), //
 FindRoot( "findroot", 223 ), //
 First( "first", 224 ), //
 Fit( "fit", 225 ), //
 FixedPoint( "fixedpoint", 226 ), //
 FixedPointList( "fixedpointlist", 227 ), //
 Flat( "flat", 228 ), //
 Flatten( "flatten", 229 ), //
 FlattenAt( "flattenat", 230 ), //
 Floor( "floor", 231 ), //
 Fold( "fold", 232 ), //
 FoldList( "foldlist", 233 ), //
 For( "for", 234 ), //
 ForAll( "forall", 235 ), //
 FourierMatrix( "fouriermatrix", 236 ), //
 FractionalPart( "fractionalpart", 237 ), //
 FrechetDistribution( "frechetdistribution", 238 ), //
 FreeQ( "freeq", 239 ), //
 FresnelC( "fresnelc", 240 ), //
 FresnelS( "fresnels", 241 ), //
 FrobeniusSolve( "frobeniussolve", 242 ), //
 FromCharacterCode( "fromcharactercode", 243 ), //
 FromContinuedFraction( "fromcontinuedfraction", 244 ), //
 FromPolarCoordinates( "frompolarcoordinates", 245 ), //
 FullForm( "fullform", 246 ), //
 FullSimplify( "fullsimplify", 247 ), //
 Function( "function", 248 ), //
 GCD( "gcd", 249 ), //
 Gamma( "gamma", 250 ), //
 GammaDistribution( "gammadistribution", 251 ), //
 GammaRegularized( "gammaregularized", 252 ), //
 Gather( "gather", 253 ), //
 GegenbauerC( "gegenbauerc", 254 ), //
 GeometricDistribution( "geometricdistribution", 255 ), //
 GeometricMean( "geometricmean", 256 ), //
 Get( "get", 257 ), //
 Glaisher( "glaisher", 258 ), //
 GoldenRatio( "goldenratio", 259 ), //
 Graphics( "graphics", 260 ), //
 Graphics3D( "graphics3d", 261 ), //
 Greater( "greater", 262 ), //
 GreaterEqual( "greaterequal", 263 ), //
 GroebnerBasis( "groebnerbasis", 264 ), //
 GumbelDistribution( "gumbeldistribution", 265 ), //
 HarmonicNumber( "harmonicnumber", 266 ), //
 Haversine( "haversine", 267 ), //
 Head( "head", 268 ), //
 HeavisideTheta( "heavisidetheta", 269 ), //
 HermiteH( "hermiteh", 270 ), //
 HermitianMatrixQ( "hermitianmatrixq", 271 ), //
 HilbertMatrix( "hilbertmatrix", 272 ), //
 Hold( "hold", 273 ), //
 HoldAll( "holdall", 274 ), //
 HoldFirst( "holdfirst", 275 ), //
 HoldForm( "holdform", 276 ), //
 HoldRest( "holdrest", 277 ), //
 Horner( "horner", 278 ), //
 HornerForm( "hornerform", 279 ), //
 HurwitzZeta( "hurwitzzeta", 280 ), //
 Hypergeometric1F1( "hypergeometric1f1", 281 ), //
 Hypergeometric2F1( "hypergeometric2f1", 282 ), //
 HypergeometricDistribution( "hypergeometricdistribution", 283 ), //
 HypergeometricPFQ( "hypergeometricpfq", 284 ), //
 HypergeometricPFQRegularized( "hypergeometricpfqregularized", 285 ), //
 I( "I", 286 ), //
 Identity( "identity", 287 ), //
 IdentityMatrix( "identitymatrix", 288 ), //
 If( "if", 289 ), //
 Im( "im", 290 ), //
 Implies( "implies", 291 ), //
 Import( "import", 292 ), //
 Increment( "increment", 293 ), //
 Indeterminate( "indeterminate", 294 ), //
 Inequality( "inequality", 295 ), //
 InexactNumberQ( "inexactnumberq", 296 ), //
 Infinity( "infinity", 297 ), //
 Information( "information", 298 ), //
 Inner( "inner", 299 ), //
 Insert( "insert", 300 ), //
 Integer( "integer", 301 ), //
 IntegerExponent( "integerexponent", 302 ), //
 IntegerLength( "integerlength", 303 ), //
 IntegerPart( "integerpart", 304 ), //
 IntegerPartitions( "integerpartitions", 305 ), //
 IntegerQ( "integerq", 306 ), //
 Integers( "integers", 307 ), //
 Integrate( "integrate", 308 ), //
 InterpolatingFunction( "interpolatingfunction", 309 ), //
 InterpolatingPolynomial( "interpolatingpolynomial", 310 ), //
 Interpolation( "interpolation", 311 ), //
 Intersection( "intersection", 312 ), //
 Interval( "interval", 313 ), //
 Inverse( "inverse", 314 ), //
 InverseErf( "inverseerf", 315 ), //
 InverseErfc( "inverseerfc", 316 ), //
 InverseFunction( "inversefunction", 317 ), //
 InverseHaversine( "inversehaversine", 318 ), //
 InverseLaplaceTransform( "inverselaplacetransform", 319 ), //
 InverseSeries( "inverseseries", 320 ), //
 JaccardDissimilarity( "jaccarddissimilarity", 321 ), //
 JacobiMatrix( "jacobimatrix", 322 ), //
 JacobiSymbol( "jacobisymbol", 323 ), //
	JacobiZeta("jacobizeta", 324), //
	JavaForm("javaform", 325), //
	Join("join", 326), //
	KOrderlessPartitions("korderlesspartitions", 327), //
	KPartitions("kpartitions", 328), //
	Khinchin("khinchin", 329), //
	KroneckerDelta("kroneckerdelta", 330), //
	Kurtosis("kurtosis", 331), //
	LCM("lcm", 332), //
	LUDecomposition("ludecomposition", 333), //
	LaguerreL("laguerrel", 334), //
	LaplaceTransform("laplacetransform", 335), //
	Last("last", 336), //
	LeafCount("leafcount", 337), //
	LeastSquares("leastsquares", 338), //
	LegendreP("legendrep", 339), //
	LegendreQ("legendreq", 340), //
	Length("length", 341), //
	Less("less", 342), //
	LessEqual("lessequal", 343), //
	LetterQ("letterq", 344), //
	Level("level", 345), //
	LevelQ("levelq", 346), //
	Limit("limit", 347), //
	Line("line", 348), //
	LinearModelFit("linearmodelfit", 349), //
	LinearProgramming("linearprogramming", 350), //
	LinearSolve("linearsolve", 351), //
	LiouvilleLambda("liouvillelambda", 352), //
	List("list", 353), //
	ListConvolve("listconvolve", 354), //
	ListCorrelate("listcorrelate", 355), //
	ListQ("listq", 356), //
	Listable("listable", 357), //
	Literal("literal", 358), //
	Log("log", 359), //
	Log10("log10", 360), //
	Log2("log2", 361), //
	LogGamma("loggamma", 362), //
	LogIntegral("logintegral", 363), //
	LogNormalDistribution("lognormaldistribution", 364), //
	LogicalExpand("logicalexpand", 365), //
	LogisticSigmoid("logisticsigmoid", 366), //
	LowerCaseQ("lowercaseq", 367), //
	LowerTriangularize("lowertriangularize", 368), //
	LucasL("lucasl", 369), //
	MachineNumberQ("machinenumberq", 370), //
	MangoldtLambda("mangoldtlambda", 371), //
	ManhattanDistance("manhattandistance", 372), //
	MantissaExponent("mantissaexponent", 373), //
	Map("map", 374), //
	MapAll("mapall", 375), //
	MapAt("mapat", 376), //
	MapThread("mapthread", 377), //
	MatchQ("matchq", 378), //
	MatchingDissimilarity("matchingdissimilarity", 379), //
	MathMLForm("mathmlform", 380), //
	MatrixForm("matrixform", 381), //
	MatrixMinimalPolynomial("matrixminimalpolynomial", 382), //
	MatrixPower("matrixpower", 383), //
	MatrixQ("matrixq", 384), //
	MatrixRank("matrixrank", 385), //
	Max("max", 386), //
	MaxIterations("maxiterations", 387), //
	MaxPoints("maxpoints", 388), //
	Mean("mean", 389), //
	MeanDeviation("meandeviation", 390), //
	Median("median", 391), //
	MeijerG("meijerg", 392), //
	MemberQ("memberq", 393), //
	MersennePrimeExponent("mersenneprimeexponent", 394), //
	MersennePrimeExponentQ("mersenneprimeexponentq", 395), //
	MeshRange("meshrange", 396), //
	MessageName("messagename", 397), //
	Method("method", 398), //
	Min("min", 399), //
	MinimalPolynomial("minimalpolynomial", 400), //
	Minus("minus", 401), //
	Missing("missing", 402), //
	MissingQ("missingq", 403), //
	Mod("mod", 404), //
	Module("module", 405), //
	Modulus("modulus", 406), //
	MoebiusMu("moebiusmu", 407), //
	MonomialList("monomiallist", 408), //
	Most("most", 409), //
	Multinomial("multinomial", 410), //
	MultiplicativeOrder("multiplicativeorder", 411), //
	N("N", 412), //
	NDSolve("ndsolve", 413), //
	NFourierTransform("nfouriertransform", 414), //
	NHoldAll("nholdall", 415), //
	NHoldFirst("nholdfirst", 416), //
	NHoldRest("nholdrest", 417), //
	NIntegrate("nintegrate", 418), //
	NMaximize("nmaximize", 419), //
	NMinimize("nminimize", 420), //
	NRoots("nroots", 421), //
	NSolve("nsolve", 422), //
	NakagamiDistribution("nakagamidistribution", 423), //
	Names("names", 424), //
	Nand("nand", 425), //
	Nearest("nearest", 426), //
	Negative("negative", 427), //
	Nest("nest", 428), //
	NestList("nestlist", 429), //
	NestWhile("nestwhile", 430), //
	NestWhileList("nestwhilelist", 431), //
	NextPrime("nextprime", 432), //
	NonCommutativeMultiply("noncommutativemultiply", 433), //
	NonNegative("nonnegative", 434), //
	NonPositive("nonpositive", 435), //
	None("none", 436), //
	NoneTrue("nonetrue", 437), //
	Nonexistent("nonexistent", 438), //
	Nor("nor", 439), //
	Norm("norm", 440), //
	Normal("normal", 441), //
	NormalDistribution("normaldistribution", 442), //
	Normalize("normalize", 443), //
	Not("not", 444), //
	NotApplicable("notapplicable", 445), //
	NotAvailable("notavailable", 446), //
	NotListQ("notlistq", 447), //
	Null("null", 448), //
	NullSpace("nullspace", 449), //
	NumberFieldRootsOfUnity("numberfieldrootsofunity", 450), //
	NumberQ("numberq", 451), //
	Numerator("numerator", 452), //
	NumericFunction("numericfunction", 453), //
	NumericQ("numericq", 454), //
	O("O", 455), //
	OddQ("oddq", 456), //
	OneIdentity("oneidentity", 457), //
	Operate("operate", 458), //
	Optional("optional", 459), //
	Options("options", 460), //
	Or("or", 461), //
	Order("order", 462), //
	OrderedQ("orderedq", 463), //
	Ordering("ordering", 464), //
	Orderless("orderless", 465), //
	OrthogonalMatrixQ("orthogonalmatrixq", 466), //
	Orthogonalize("orthogonalize", 467), //
	Out("out", 468), //
	Outer("outer", 469), //
	PDF("pdf", 470), //
	Package("package", 471), //
	PadLeft("padleft", 472), //
	PadRight("padright", 473), //
	ParametricPlot("parametricplot", 474), //
	Part("part", 475), //
	Partition("partition", 476), //
	PartitionsP("partitionsp", 477), //
	PartitionsQ("partitionsq", 478), //
	Pattern("pattern", 479), //
	PatternTest("patterntest", 480), //
	PerfectNumber("perfectnumber", 481), //
	PerfectNumberQ("perfectnumberq", 482), //
	Permutations("permutations", 483), //
	Pi("pi", 484), //
	Piecewise("piecewise", 485), //
	Plot("plot", 486), //
	Plot3D("plot3d", 487), //
	PlotRange("plotrange", 488), //
	Plus("plus", 489), //
	Pochhammer("pochhammer", 490), //
	Point("point", 491), //
	PoissonDistribution("poissondistribution", 492), //
	PolyGamma("polygamma", 493), //
	PolyLog("polylog", 494), //
	Polygon("polygon", 495), //
	PolynomialExtendedGCD("polynomialextendedgcd", 496), //
	PolynomialGCD("polynomialgcd", 497), //
	PolynomialLCM("polynomiallcm", 498), //
	PolynomialQ("polynomialq", 499), //
	PolynomialQuotient("polynomialquotient", 500), //
	PolynomialQuotientRemainder("polynomialquotientremainder", 501), //
	PolynomialRemainder("polynomialremainder", 502), //
	Position("position", 503), //
	Positive("positive", 504), //
	PossibleZeroQ("possiblezeroq", 505), //
	Power("power", 506), //
	PowerExpand("powerexpand", 507), //
	PowerMod("powermod", 508), //
	PreDecrement("predecrement", 509), //
	PreIncrement("preincrement", 510), //
	PrePlus("preplus", 511), //
	Precision("precision", 512), //
	PrecisionGoal("precisiongoal", 513), //
	Prepend("prepend", 514), //
	PrependTo("prependto", 515), //
	Prime("prime", 516), //
	PrimeOmega("primeomega", 517), //
	PrimePi("primepi", 518), //
	PrimePowerQ("primepowerq", 519), //
	PrimeQ("primeq", 520), //
	Primes("primes", 521), //
	PrimitiveRootList("primitiverootlist", 522), //
	Print("print", 523), //
	Product("product", 524), //
	ProductLog("productlog", 525), //
	Projection("projection", 526), //
	PseudoInverse("pseudoinverse", 527), //
	Put("put", 528), //
	QRDecomposition("qrdecomposition", 529), //
	Quantile("quantile", 530), //
	Quiet("quiet", 531), //
	Quit("quit", 532), //
	Quotient("quotient", 533), //
	QuotientRemainder("quotientremainder", 534), //
	RandomChoice("randomchoice", 535), //
	RandomInteger("randominteger", 536), //
	RandomReal("randomreal", 537), //
	RandomSample("randomsample", 538), //
	RandomVariate("randomvariate", 539), //
	Range("range", 540), //
	Rational("rational", 541), //
	Rationalize("rationalize", 542), //
	Rationals("rationals", 543), //
	Re("re", 544), //
	Real("real", 545), //
	RealNumberQ("realnumberq", 546), //
	Reals("reals", 547), //
	Reap("reap", 548), //
	Rectangle("rectangle", 549), //
	Reduce("reduce", 550), //
	Refine("refine", 551), //
	Repeated("repeated", 552), //
	RepeatedNull("repeatednull", 553), //
	Replace("replace", 554), //
	ReplaceAll("replaceall", 555), //
	ReplaceList("replacelist", 556), //
	ReplacePart("replacepart", 557), //
	ReplaceRepeated("replacerepeated", 558), //
	Rest("rest", 559), //
	Resultant("resultant", 560), //
	Return("return", 561), //
	Reverse("reverse", 562), //
	Riffle("riffle", 563), //
	RogersTanimotoDissimilarity("rogerstanimotodissimilarity", 564), //
	Root("root", 565), //
	RootIntervals("rootintervals", 566), //
	RootOf("rootof", 567), //
	Roots("roots", 568), //
	RotateLeft("rotateleft", 569), //
	RotateRight("rotateright", 570), //
	Round("round", 571), //
	RowReduce("rowreduce", 572), //
	Rule("rule", 573), //
	RuleDelayed("ruledelayed", 574), //
	RussellRaoDissimilarity("russellraodissimilarity", 575), //
	SameQ("sameq", 576), //
	SatisfiabilityCount("satisfiabilitycount", 577), //
	SatisfiabilityInstances("satisfiabilityinstances", 578), //
	SatisfiableQ("satisfiableq", 579), //
	Scan("scan", 580), //
	Sec("sec", 581), //
	Sech("sech", 582), //
	Second("second", 583), //
	Select("select", 584), //
	Sequence("sequence", 585), //
	Series("series", 586), //
	SeriesCoefficient("seriescoefficient", 587), //
	SeriesData("seriesdata", 588), //
	Set("set", 589), //
	SetAttributes("setattributes", 590), //
	SetDelayed("setdelayed", 591), //
	Share("share", 592), //
	Show("show", 593), //
	Sign("sign", 594), //
	SignCmp("signcmp", 595), //
	Simplify("simplify", 596), //
	Sin("sin", 597), //
	SinIntegral("sinintegral", 598), //
	Sinc("sinc", 599), //
	SingularValueDecomposition("singularvaluedecomposition", 600), //
	Sinh("sinh", 601), //
	SinhIntegral("sinhintegral", 602), //
	Skewness("skewness", 603), //
	Slot("slot", 604), //
	SlotSequence("slotsequence", 605), //
	SokalSneathDissimilarity("sokalsneathdissimilarity", 606), //
	Solve("solve", 607), //
	Sort("sort", 608), //
	Sow("sow", 609), //
	Span("span", 610), //
	Split("split", 611), //
	SplitBy("splitby", 612), //
	Sqrt("sqrt", 613), //
	SquareFreeQ("squarefreeq", 614), //
	SquaredEuclideanDistance("squaredeuclideandistance", 615), //
	StandardDeviation("standarddeviation", 616), //
	Standardize("standardize", 617), //
	StieltjesGamma("stieltjesgamma", 618), //
	StirlingS1("stirlings1", 619), //
	StirlingS2("stirlings2", 620), //
	String("string", 621), //
	StringDrop("stringdrop", 622), //
	StringJoin("stringjoin", 623), //
	StringLength("stringlength", 624), //
	StringTake("stringtake", 625), //
	StruveH("struveh", 626), //
	StruveL("struvel", 627), //
	StudentTDistribution("studenttdistribution", 628), //
	Subfactorial("subfactorial", 629), //
	Subscript("subscript", 630), //
	Subsets("subsets", 631), //
	Subsuperscript("subsuperscript", 632), //
	Subtract("subtract", 633), //
	SubtractFrom("subtractfrom", 634), //
	Sum("sum", 635), //
	Superscript("superscript", 636), //
	Surd("surd", 637), //
	SurfaceGraphics("surfacegraphics", 638), //
	Switch("switch", 639), //
	Symbol("symbol", 640), //
	SymbolName("symbolname", 641), //
	SymbolQ("symbolq", 642), //
	SymmetricMatrixQ("symmetricmatrixq", 643), //
	SyntaxLength("syntaxlength", 644), //
	SyntaxQ("syntaxq", 645), //
	Table("table", 646), //
	Take("take", 647), //
	Tally("tally", 648), //
	Tan("tan", 649), //
	Tanh("tanh", 650), //
	TautologyQ("tautologyq", 651), //
	Taylor("taylor", 652), //
	TeXForm("texform", 653), //
	TensorDimensions("tensordimensions", 654), //
	TensorProduct("tensorproduct", 655), //
	TensorRank("tensorrank", 656), //
	Thread("thread", 657), //
	Through("through", 658), //
	Throw("throw", 659), //
	TimeConstrained("timeconstrained", 660), //
	Times("times", 661), //
	TimesBy("timesby", 662), //
	Timing("timing", 663), //
	ToCharacterCode("tocharactercode", 664), //
	ToPolarCoordinates("topolarcoordinates", 665), //
	ToRadicals("toradicals", 666), //
	ToString("tostring", 667), //
	ToUnicode("tounicode", 668), //
	ToeplitzMatrix("toeplitzmatrix", 669), //
	Together("together", 670), //
	TooLarge("toolarge", 671), //
	Total("total", 672), //
	Tr("tr", 673), //
	Trace("trace", 674), //
	Transpose("transpose", 675), //
	Trig("trig", 676), //
	TrigExpand("trigexpand", 677), //
	TrigReduce("trigreduce", 678), //
	TrigToExp("trigtoexp", 679), //
	True("true", 680), //
	TrueQ("trueq", 681), //
	Tuples("tuples", 682), //
	Unequal("unequal", 683), //
	Unevaluated("unevaluated", 684), //
	Union("union", 685), //
	Unique("unique", 686), //
	UnitStep("unitstep", 687), //
	UnitVector("unitvector", 688), //
	UnitaryMatrixQ("unitarymatrixq", 689), //
	Unitize("unitize", 690), //
	Unknown("unknown", 691), //
	UnsameQ("unsameq", 692), //
	Unset("unset", 693), //
	UpSet("upset", 694), //
	UpSetDelayed("upsetdelayed", 695), //
	UpperCaseQ("uppercaseq", 696), //
	UpperTriangularize("uppertriangularize", 697), //
	ValueQ("valueq", 698), //
	VandermondeMatrix("vandermondematrix", 699), //
	Variable("variable", 700), //
	Variables("variables", 701), //
	Variance("variance", 702), //
	VectorAngle("vectorangle", 703), //
	VectorQ("vectorq", 704), //
	WeibullDistribution("weibulldistribution", 705), //
	Which("which", 706), //
	While("while", 707), //
	White("white", 708), //
	With("with", 709), //
	Xor("xor", 710), //
	YuleDissimilarity("yuledissimilarity", 711), //
	Zeta("zeta", 712);

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