package org.matheclipse.core.builtin;

import org.matheclipse.core.expression.F;

public final class FunctionDefinitions {
    private final static FunctionDefinitions CONST = new FunctionDefinitions();

    static {
        F.AbsArg.setEvaluator(new org.matheclipse.core.reflection.system.AbsArg());
        F.BesselJ.setEvaluator(new org.matheclipse.core.reflection.system.BesselJ());
        F.ComplexExpand.setEvaluator(new org.matheclipse.core.reflection.system.ComplexExpand());
        F.ContinuedFraction.setEvaluator(new org.matheclipse.core.reflection.system.ContinuedFraction());
        F.Curl.setEvaluator(new org.matheclipse.core.reflection.system.Curl());
        F.D.setEvaluator(new org.matheclipse.core.reflection.system.D());
        F.Default.setEvaluator(new org.matheclipse.core.reflection.system.Default());
        F.Derivative.setEvaluator(new org.matheclipse.core.reflection.system.Derivative());
        F.Distribute.setEvaluator(new org.matheclipse.core.reflection.system.Distribute());
        F.Divergence.setEvaluator(new org.matheclipse.core.reflection.system.Divergence());
        F.DSolve.setEvaluator(new org.matheclipse.core.reflection.system.DSolve());
        F.EasterSunday.setEvaluator(new org.matheclipse.core.reflection.system.EasterSunday());
        F.ElementData.setEvaluator(new org.matheclipse.core.data.ElementData());
        F.Eliminate.setEvaluator(new org.matheclipse.core.reflection.system.Eliminate());
        F.Export.setEvaluator(new org.matheclipse.core.reflection.system.Export());
        F.FindInstance.setEvaluator(new org.matheclipse.core.reflection.system.FindInstance());
        F.FindRoot.setEvaluator(new org.matheclipse.core.reflection.system.FindRoot());
        F.Fit.setEvaluator(new org.matheclipse.core.reflection.system.Fit());
        F.FrobeniusSolve.setEvaluator(new org.matheclipse.core.reflection.system.FrobeniusSolve());
        F.FromContinuedFraction.setEvaluator(new org.matheclipse.core.reflection.system.FromContinuedFraction());
        F.FromPolarCoordinates.setEvaluator(new org.matheclipse.core.reflection.system.FromPolarCoordinates());
        F.GeometricMean.setEvaluator(new org.matheclipse.core.reflection.system.GeometricMean());
        F.GroebnerBasis.setEvaluator(new org.matheclipse.core.reflection.system.GroebnerBasis());
        F.HeavisideTheta.setEvaluator(new org.matheclipse.core.reflection.system.HeavisideTheta());
        F.Horner.setEvaluator(new org.matheclipse.core.reflection.system.Horner());
        F.Import.setEvaluator(new org.matheclipse.core.reflection.system.Import());
        F.InterpolatingFunction.setEvaluator(new org.matheclipse.core.reflection.system.InterpolatingFunction());
        F.InterpolatingPolynomial.setEvaluator(new org.matheclipse.core.reflection.system.InterpolatingPolynomial());
        F.Interpolation.setEvaluator(new org.matheclipse.core.reflection.system.Interpolation());
        F.Interval.setEvaluator(new org.matheclipse.core.reflection.system.Interval());
        F.InverseFunction.setEvaluator(new org.matheclipse.core.reflection.system.InverseFunction());
        F.InverseLaplaceTransform.setEvaluator(new org.matheclipse.core.reflection.system.InverseLaplaceTransform());
        F.LaplaceTransform.setEvaluator(new org.matheclipse.core.reflection.system.LaplaceTransform());
        F.LinearProgramming.setEvaluator(new org.matheclipse.core.reflection.system.LinearProgramming());
        F.MonomialList.setEvaluator(new org.matheclipse.core.reflection.system.MonomialList());
        F.Names.setEvaluator(new org.matheclipse.core.reflection.system.Names());
        F.NDSolve.setEvaluator(new org.matheclipse.core.reflection.system.NDSolve());
        F.NFourierTransform.setEvaluator(new org.matheclipse.core.reflection.system.NFourierTransform());
        F.NIntegrate.setEvaluator(new org.matheclipse.core.reflection.system.NIntegrate());
        F.NMaximize.setEvaluator(new org.matheclipse.core.reflection.system.NMaximize());
        F.NMinimize.setEvaluator(new org.matheclipse.core.reflection.system.NMinimize());
        F.NonCommutativeMultiply.setEvaluator(new org.matheclipse.core.reflection.system.NonCommutativeMultiply());
        F.NSolve.setEvaluator(new org.matheclipse.core.reflection.system.NSolve());
        F.Out.setEvaluator(new org.matheclipse.core.reflection.system.Out());
        F.Outer.setEvaluator(new org.matheclipse.core.reflection.system.Outer());
        F.Plot.setEvaluator(new org.matheclipse.core.reflection.system.Plot());
        F.Plot3D.setEvaluator(new org.matheclipse.core.reflection.system.Plot3D());
        F.Product.setEvaluator(new org.matheclipse.core.reflection.system.Product());
        F.Rationalize.setEvaluator(new org.matheclipse.core.reflection.system.Rationalize());
        F.Replace.setEvaluator(new org.matheclipse.core.reflection.system.Replace());
        F.ReplaceList.setEvaluator(new org.matheclipse.core.reflection.system.ReplaceList());
        F.ReplaceRepeated.setEvaluator(new org.matheclipse.core.reflection.system.ReplaceRepeated());
        F.Share.setEvaluator(new org.matheclipse.core.reflection.system.Share());
        F.Sign.setEvaluator(new org.matheclipse.core.reflection.system.Sign());
        F.SignCmp.setEvaluator(new org.matheclipse.core.reflection.system.SignCmp());
        F.Solve.setEvaluator(new org.matheclipse.core.reflection.system.Solve());
        F.Sum.setEvaluator(new org.matheclipse.core.reflection.system.Sum());
        F.Taylor.setEvaluator(new org.matheclipse.core.reflection.system.Taylor());
        F.ToPolarCoordinates.setEvaluator(new org.matheclipse.core.reflection.system.ToPolarCoordinates());
        F.TrigExpand.setEvaluator(new org.matheclipse.core.reflection.system.TrigExpand());
        F.TrigReduce.setEvaluator(new org.matheclipse.core.reflection.system.TrigReduce());
        F.TrigToExp.setEvaluator(new org.matheclipse.core.reflection.system.TrigToExp());
    }

    private FunctionDefinitions() {

    }

    public static FunctionDefinitions initialize() {
        return CONST;
    }
}
