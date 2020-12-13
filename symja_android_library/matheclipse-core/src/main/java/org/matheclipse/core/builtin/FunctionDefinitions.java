package org.matheclipse.core.builtin;


import static org.matheclipse.core.expression.F.ComplexExpand;
import static org.matheclipse.core.expression.F.D;
import static org.matheclipse.core.expression.F.DSolve;
import static org.matheclipse.core.expression.F.Derivative;
import static org.matheclipse.core.expression.F.EasterSunday;
import static org.matheclipse.core.expression.F.ElementData;
import static org.matheclipse.core.expression.F.Eliminate;
import static org.matheclipse.core.expression.F.ExpToTrig;
import static org.matheclipse.core.expression.F.Export;
import static org.matheclipse.core.expression.F.FindInstance;
import static org.matheclipse.core.expression.F.FindRoot;
import static org.matheclipse.core.expression.F.Fourier;
import static org.matheclipse.core.expression.F.FrobeniusSolve;
import static org.matheclipse.core.expression.F.FunctionExpand;
import static org.matheclipse.core.expression.F.HeavisideTheta;
import static org.matheclipse.core.expression.F.Horner;
import static org.matheclipse.core.expression.F.In;
import static org.matheclipse.core.expression.F.InterpolatingFunction;
import static org.matheclipse.core.expression.F.InterpolatingPolynomial;
import static org.matheclipse.core.expression.F.Interpolation;
import static org.matheclipse.core.expression.F.InverseFourier;
import static org.matheclipse.core.expression.F.InverseFunction;
import static org.matheclipse.core.expression.F.InverseLaplaceTransform;
import static org.matheclipse.core.expression.F.LaplaceTransform;
import static org.matheclipse.core.expression.F.LinearProgramming;
import static org.matheclipse.core.expression.F.ListLinePlot;
import static org.matheclipse.core.expression.F.ListPlot;
import static org.matheclipse.core.expression.F.ListPlot3D;
import static org.matheclipse.core.expression.F.ND;
import static org.matheclipse.core.expression.F.NDSolve;
import static org.matheclipse.core.expression.F.NFourierTransform;
import static org.matheclipse.core.expression.F.NIntegrate;
import static org.matheclipse.core.expression.F.NSolve;
import static org.matheclipse.core.expression.F.NonCommutativeMultiply;
import static org.matheclipse.core.expression.F.OptimizeExpression;
import static org.matheclipse.core.expression.F.Out;
import static org.matheclipse.core.expression.F.Outer;
import static org.matheclipse.core.expression.F.ParametricPlot;
import static org.matheclipse.core.expression.F.Plot;
import static org.matheclipse.core.expression.F.Plot3D;
import static org.matheclipse.core.expression.F.PolarPlot;
import static org.matheclipse.core.expression.F.Product;
import static org.matheclipse.core.expression.F.Share;
import static org.matheclipse.core.expression.F.Solve;
import static org.matheclipse.core.expression.F.Sum;
import static org.matheclipse.core.expression.F.Taylor;
import static org.matheclipse.core.expression.F.TrigExpand;
import static org.matheclipse.core.expression.F.TrigReduce;
import static org.matheclipse.core.expression.F.TrigToExp;

import org.matheclipse.core.basic.Config;
import org.matheclipse.core.expression.F;

public final class FunctionDefinitions {

  /**
   * See <a href="https://pangin.pro/posts/computation-in-static-initializer">Beware of computation in static
   * initializer</a>
   */
  private static class Initializer {

    private static void init() {
      ComplexExpand.setEvaluator(new org.matheclipse.core.reflection.system.ComplexExpand());
      // F.Dataset.setEvaluator(new org.matheclipse.core.reflection.system.Dataset());
      D.setEvaluator(new org.matheclipse.core.reflection.system.D());
      Derivative.setEvaluator(new org.matheclipse.core.reflection.system.Derivative());
      DSolve.setEvaluator(new org.matheclipse.core.reflection.system.DSolve());
      EasterSunday.setEvaluator(new org.matheclipse.core.reflection.system.EasterSunday());
      ElementData.setEvaluator(new org.matheclipse.core.data.ElementData());
      Eliminate.setEvaluator(new org.matheclipse.core.reflection.system.Eliminate());
      ExpToTrig.setEvaluator(new org.matheclipse.core.reflection.system.ExpToTrig());
      FindInstance.setEvaluator(new org.matheclipse.core.reflection.system.FindInstance());
      FindRoot.setEvaluator(new org.matheclipse.core.reflection.system.FindRoot());
      Fourier.setEvaluator(new org.matheclipse.core.reflection.system.Fourier());
      FrobeniusSolve.setEvaluator(new org.matheclipse.core.reflection.system.FrobeniusSolve());
      FunctionExpand.setEvaluator(new org.matheclipse.core.reflection.system.FunctionExpand());
      HeavisideTheta.setEvaluator(new org.matheclipse.core.reflection.system.HeavisideTheta());
      Horner.setEvaluator(new org.matheclipse.core.reflection.system.Horner());
			//In.setEvaluator(new org.matheclipse.core.reflection.system.In());
			InterpolatingFunction
          .setEvaluator(new org.matheclipse.core.reflection.system.InterpolatingFunction());
      InterpolatingPolynomial
          .setEvaluator(new org.matheclipse.core.reflection.system.InterpolatingPolynomial());
      Interpolation.setEvaluator(new org.matheclipse.core.reflection.system.Interpolation());
      InverseFourier.setEvaluator(new org.matheclipse.core.reflection.system.InverseFourier());
      InverseFunction.setEvaluator(new org.matheclipse.core.reflection.system.InverseFunction());
      InverseLaplaceTransform
          .setEvaluator(new org.matheclipse.core.reflection.system.InverseLaplaceTransform());
      LaplaceTransform.setEvaluator(new org.matheclipse.core.reflection.system.LaplaceTransform());
      LinearProgramming
          .setEvaluator(new org.matheclipse.core.reflection.system.LinearProgramming());
      ListLinePlot.setEvaluator(new org.matheclipse.core.reflection.system.ListLinePlot());
      ListPlot.setEvaluator(new org.matheclipse.core.reflection.system.ListPlot());
      ListPlot3D.setEvaluator(new org.matheclipse.core.reflection.system.ListPlot3D());
      ND.setEvaluator(new org.matheclipse.core.reflection.system.ND());
      NDSolve.setEvaluator(new org.matheclipse.core.reflection.system.NDSolve());
      NFourierTransform
          .setEvaluator(new org.matheclipse.core.reflection.system.NFourierTransform());
      NIntegrate.setEvaluator(new org.matheclipse.core.reflection.system.NIntegrate());
      NonCommutativeMultiply
          .setEvaluator(new org.matheclipse.core.reflection.system.NonCommutativeMultiply());
      NSolve.setEvaluator(new org.matheclipse.core.reflection.system.NSolve());
      Out.setEvaluator(new org.matheclipse.core.reflection.system.Out());
      Outer.setEvaluator(new org.matheclipse.core.reflection.system.Outer());
      ParametricPlot.setEvaluator(new org.matheclipse.core.reflection.system.ParametricPlot());
      Plot.setEvaluator(new org.matheclipse.core.reflection.system.Plot());
      Plot3D.setEvaluator(new org.matheclipse.core.reflection.system.Plot3D());
      PolarPlot.setEvaluator(new org.matheclipse.core.reflection.system.PolarPlot());
      Product.setEvaluator(new org.matheclipse.core.reflection.system.Product());

      F.Ramp.setEvaluator(new org.matheclipse.core.reflection.system.Ramp());
      Solve.setEvaluator(new org.matheclipse.core.reflection.system.Solve());
      Sum.setEvaluator(new org.matheclipse.core.reflection.system.Sum());
      Taylor.setEvaluator(new org.matheclipse.core.reflection.system.Taylor());
      TrigExpand.setEvaluator(new org.matheclipse.core.reflection.system.TrigExpand());
      TrigReduce.setEvaluator(new org.matheclipse.core.reflection.system.TrigReduce());
      TrigToExp.setEvaluator(new org.matheclipse.core.reflection.system.TrigToExp());
      if (!Config.FUZZY_PARSER) {
        //Compile.setEvaluator(new org.matheclipse.core.reflection.system.Compile());
        //CreateDirectory.setEvaluator(new org.matheclipse.core.reflection.system.CreateDirectory());
        Export.setEvaluator(new org.matheclipse.core.reflection.system.Export());
        F.ExportString.setEvaluator(new org.matheclipse.core.reflection.system.ExportString());
        OptimizeExpression
            .setEvaluator(new org.matheclipse.core.reflection.system.OptimizeExpression());
        Share.setEvaluator(new org.matheclipse.core.reflection.system.Share());
      }
    }

  }

  public static void initialize() {
    Initializer.init();
  }

  private FunctionDefinitions() {

  }
}
