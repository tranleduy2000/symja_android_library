package org.matheclipse.core.system;

public class DistributionTest extends AbstractTestCase {
	public DistributionTest(String name) {
		super(name);
	}

	public void testBernoulliDistribution() {
		check("Mean(BernoulliDistribution(x))", //
				"x");
		check("Quantile(BernoulliDistribution(x), {1/4, 1/2, 3/4})", //
				"{Piecewise({{1,1/4>1-x}},0),Piecewise({{1,1/2>1-x}},0),Piecewise({{1,3/4>1-x}},0)}");
	}

	public void testErlangDistribution() {
		check("Mean(ErlangDistribution(n, m))", //
				"n/m");
		check("Quantile(ErlangDistribution(n, m), {1/4, 1/2, 3/4})", //
				"{InverseGammaRegularized(n,0,1/4)/m,InverseGammaRegularized(n,0,1/2)/m,InverseGammaRegularized(n,\n"
						+ "0,3/4)/m}");
	}

	public void testExponentialDistribution() {
		check("Mean(ExponentialDistribution(x))", //
				"1/x");
		check("Quantile(ExponentialDistribution(x), {1/4, 1/2, 3/4})", //
				"{Log(4/3)/x,Log(2)/x,Log(4)/x}");
	}

	public void testFrechetDistribution() {
		check("Mean(FrechetDistribution(n, m))", //
				"Piecewise({{m*Gamma(1-1/n),1<n}},Infinity)");
		check("Quantile(FrechetDistribution(n, m), {1/4, 1/2, 3/4})", //
				"{m/Log(4)^(1/n),m/Log(2)^(1/n),m/Log(4/3)^(1/n)}");
	}

	public void testGammaDistribution() {
		check("Mean(GammaDistribution(a, b))", //
				"a*b");
		check("Mean(GammaDistribution(a, b, g, d))", //
				"d+(b*Gamma(a+1/g))/Gamma(a)");
		check("StandardDeviation(GammaDistribution(m, s))", //
				"Sqrt(m*s^2)");
		check("Variance(GammaDistribution(m, s))", //
				"m*s^2");
		check("CDF(GammaDistribution(a, b))", //
				"Piecewise({{GammaRegularized(a,0,#1/b),#1>0}},0)&");
		check("CDF(GammaDistribution(a, b, g, d))", //
				"Piecewise({{GammaRegularized(a,0,((-d+#1)/b)^g),#1>d}},0)&");
		check("PDF(GammaDistribution(a, b))", //
				"Piecewise({{1/(b^a*E^(#1/b)*Gamma(a)*#1^(1-a)),#1>0}},0)&");
		check("PDF(GammaDistribution(a, b, g, d))", //
				"Piecewise({{g/(E^((-d+#1)/b)^g*b*Gamma(a)*((-d+#1)/b)^(1-a*g)),#1>d}},0)&");
		check("Quantile(GammaDistribution(a, b), {1/4, 1/2, 3/4})", //
				"{b*InverseGammaRegularized(a,0,1/4),b*InverseGammaRegularized(a,0,1/2),b*InverseGammaRegularized(a,\n"
						+ "0,3/4)}");
		check("Quantile(GammaDistribution(a, b, g, d), {1/4, 1/2, 3/4})", //
				"{d+b*InverseGammaRegularized(a,0,1/4)^(1/g),d+b*InverseGammaRegularized(a,0,1/2)^(1/g),d+b*InverseGammaRegularized(a,\n"
						+ "0,3/4)^(1/g)}");
	}

	public void testNormalDistribution() {
		check("Mean(NormalDistribution( ) )", //
				"0");
		check("Mean(NormalDistribution(m, s))", //
				"m");
		check("CDF(NormalDistribution( ), x)", //
				"1/2*(2-Erfc(x/Sqrt(2)))");
		check("CDF(NormalDistribution(n,m), x)", //
				"Erfc((n-x)/(Sqrt(2)*m))/2");
		check("PDF(NormalDistribution( ), x)", //
				"1/(E^(x^2/2)*Sqrt(2*Pi))");
		check("PDF(NormalDistribution(m, s), x)", //
				"1/(E^((-m+x)^2/(2*s^2))*Sqrt(2*Pi)*s)");

		check("StandardDeviation(NormalDistribution(m, s))", //
				"s");
		check("Variance(NormalDistribution(m, s))", //
				"s^2");

		check("Quantile(NormalDistribution(m, s), q)", //
				"ConditionalExpression(m-Sqrt(2)*s*InverseErfc(2*q),0<=q<=1)");
		check("Quantile(NormalDistribution(2, 3), {1/4, 1/2, 3/4})", //
				"{2-3*Sqrt(2)*InverseErfc(1/2),2,2-3*Sqrt(2)*InverseErfc(3/2)}");
	}

	public void testGumbelDistribution() {
		check("Mean(GumbelDistribution())", //
				"-EulerGamma");
		check("Mean(GumbelDistribution(a,b))", //
				"a-b*EulerGamma");
		check("Quantile(GumbelDistribution(), {1/4, 1/2, 3/4})", //
				"{Log(Log(4/3)),Log(Log(2)),Log(Log(4))}");
		check("Quantile(GumbelDistribution(a,b), {1/4, 1/2, 3/4})", //
				"{a+b*Log(Log(4/3)),a+b*Log(Log(2)),a+b*Log(Log(4))}");
	}

	public void testLogNormalDistribution() {
		check("Mean(LogNormalDistribution(m,d))", //
				"E^(d^2/2+m)");
		check("Quantile(LogNormalDistribution(m,d), {1/4, 1/2, 3/4})", //
				"{E^(m-Sqrt(2)*d*InverseErfc(1/2)),E^m,E^(m-Sqrt(2)*d*InverseErfc(3/2))}");
	}

	public void testNakagamiDistribution() {
		check("Mean(NakagamiDistribution(m,w))", //
				"(Sqrt(w)*Pochhammer(m,1/2))/Sqrt(m)");
		check("Variance(NakagamiDistribution(m,w))", //
				"w+(-w*Pochhammer(m,1/2)^2)/m");
		check("Quantile(NakagamiDistribution(m,w), {1/4, 1/2, 3/4})", //
				"{Sqrt((w*InverseGammaRegularized(m,0,1/4))/m),Sqrt((w*InverseGammaRegularized(m,\n"
						+ "0,1/2))/m),Sqrt((w*InverseGammaRegularized(m,0,3/4))/m)}");
	}

	public void testPoissonDistribution() {
		check("Mean(PoissonDistribution(m))", //
				"m");
		check("Variance(PoissonDistribution(m))", //
				"m");
	}

	public void testStudentTDistribution() {
		check("Mean(StudentTDistribution(v))", //
				"Piecewise({{0,v>1}},Indeterminate)");
		check("Mean(StudentTDistribution(m,s,v))", //
				"Piecewise({{m,v>1}},Indeterminate)");
		check("Quantile(StudentTDistribution(v), {1/4, 1/2, 3/4})", //
				"{-Sqrt(v)*Sqrt(-1+1/InverseBetaRegularized(1/2,v/2,1/2)),0,Sqrt(v)*Sqrt(-1+1/InverseBetaRegularized(\n"
						+ "1/2,v/2,1/2))}");
		check("Quantile(StudentTDistribution(m,s,v), {1/4, 1/2, 3/4})", //
				"{m-s*Sqrt(v)*Sqrt(-1+1/InverseBetaRegularized(1/2,v/2,1/2)),m,m+s*Sqrt(v)*Sqrt(\n"
						+ "-1+1/InverseBetaRegularized(1/2,v/2,1/2))}");
	}

	public void testWeibullDistribution() {
		check("Mean(WeibullDistribution(a,b))", //
				"b*Gamma(1+1/a)");
		check("Mean(WeibullDistribution(a,b,m))", //
				"m+b*Gamma(1+1/a)");

		check("Quantile(WeibullDistribution(a,b), {1/4, 1/2, 3/4})", //
				"{b*Log(4/3)^(1/a),b*Log(2)^(1/a),b*Log(4)^(1/a)}");
		check("Quantile(WeibullDistribution(a,b,m), {1/4, 1/2, 3/4})", //
				"{m+b*Log(4/3)^(1/a),m+b*Log(2)^(1/a),m+b*Log(4)^(1/a)}");
	}
}
