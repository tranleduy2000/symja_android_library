package org.matheclipse.core.builtin;

import com.duy.lambda.Consumer;
import com.duy.lambda.Predicate;
import org.matheclipse.core.basic.Config;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.FailedException;
import org.matheclipse.core.eval.exception.RuleCreationError;
import org.matheclipse.core.eval.exception.Validate;
import org.matheclipse.core.eval.interfaces.AbstractCoreFunctionEvaluator;
import org.matheclipse.core.eval.interfaces.ISetEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.expression.ID;
import org.matheclipse.core.expression.S;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IBuiltInSymbol;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;

public class AttributeFunctions {

  /**
   * See <a href="https://pangin.pro/posts/computation-in-static-initializer">Beware of computation
   * in static initializer</a>
   */
  private static class Initializer {

    private static void init() {
      F.Attributes.setEvaluator(new Attributes());
      F.ClearAttributes.setEvaluator(new ClearAttributes());
      F.SetAttributes.setEvaluator(new SetAttributes());
      F.Protect.setEvaluator(new Protect());
      F.Unprotect.setEvaluator(new Unprotect());
    }
  }

  /**
   * <pre>
   * Attributes(symbol)
   * </pre>
   *
   * <blockquote>
   * <p>
   * returns the list of attributes which are assigned to <code>symbol</code>
   * </p>
   * </blockquote>
   * <h3>Examples</h3>
   *
   * <pre>
   * &gt;&gt; Attributes(Plus)
   * {Flat,Listable,OneIdentity,Orderless,NumericFunction}
   * </pre>
   */
  private static final class Attributes extends AbstractCoreFunctionEvaluator
      implements ISetEvaluator {

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      if (ast.isAST1()) {
        IExpr arg1 = ast.arg1();
        if (arg1.isList()) {
          IAST list = (IAST) arg1;
          if (list.exists(new Predicate<IExpr>() {
						@Override
						public boolean test(IExpr x) {
							return !x.isSymbol();
						}
					})) {
            return F.NIL;
          }
          final IASTAppendable result = F.ListAlloc(list.size());
          for (int i = 1; i < list.size(); i++) {
            IExpr temp = attributesList(list.get(i), ast, engine);
            if (!temp.isPresent()) {
              return F.NIL;
            }
            result.append(temp);
          }
          return result;
        }
        return attributesList(arg1, ast, engine);
      }

      return F.NIL;
    }

    public IExpr evaluateSet(
        final IExpr leftHandSide,
        IExpr rightHandSide,
        IBuiltInSymbol builtinSymbol,
        EvalEngine engine) {
      if (leftHandSide.isAST(F.Attributes, 2)) {
        if (!leftHandSide.first().isSymbol()) {
          IOFunctions.printMessage(builtinSymbol, "setps", F.List(leftHandSide.first()), engine);
          return rightHandSide;
        }
        IExpr temp = engine.evaluate(F.SetAttributes(leftHandSide.first(), rightHandSide));
        if (temp.equals(S.Null)) {
          return rightHandSide;
        }
      }
      return F.NIL;
    }
  }

  /**
   *
   *
   * <pre>
   * ClearAttributes(symbol, attrib)
   * </pre>
   *
   * <blockquote>
   * <p>
   * removes <code>attrib</code> from <code>symbol</code>'s attributes.
   * </p>
   * </blockquote>
   *
   * <h3>Examples</h3>
   *
   * <pre>
   * &gt;&gt; SetAttributes(f, Flat)
   * &gt;&gt; Attributes(f)
   * {Flat}
   *
   * &gt;&gt; ClearAttributes(f, Flat)
   * &gt;&gt; Attributes(f)
   * {}
   * </pre>
   *
   * <p>Attributes that are not even set are simply ignored:
   *
   * <pre>
   * &gt;&gt; ClearAttributes({f}, {Flat})
   * &gt;&gt; Attributes(f)
   * {}
   * </pre>
   */
  private static final class ClearAttributes extends AbstractCoreFunctionEvaluator {

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      try {
        if (ast.isAST2()) {

          if (ast.arg1().isList()) {
            IAST list = (IAST) ast.arg1();
            IExpr arg2 = engine.evaluate(ast.arg2());
            for (int i = 1; i < list.size(); i++) {
              IExpr temp = clearAttributes(list.get(i), arg2, ast, engine);
              if (!temp.isPresent()) {
                return F.NIL;
              }
            }
            return S.Null;
          }
          if (ast.arg1().isSymbol()) {
            IExpr arg2 = engine.evaluate(ast.arg2());
            final ISymbol sym = ((ISymbol) ast.arg1());
            return clearAttributes(sym, arg2, ast, engine);

          }
        }
      } catch (RuntimeException rex) {
        //
      }
      return F.NIL;
    }

    /**
     * Remove the attribute from the symbols existing attributes bit-set.
     *
     * @param expr
     * @param attributes
     * @param engine
     * @return {@link F#NIL} if <code>expr</code> is not a symbol
     */
    private IExpr clearAttributes(final IExpr expr, IExpr attributes, IAST ast, EvalEngine engine) {
      IExpr x = Validate.checkIdentifierHoldPattern(expr, ast, engine);
      if (!x.isPresent()) {
        return F.NIL;
      }
      ISymbol sym = (ISymbol) x;
      if (!engine.isPackageMode()) {
        if (Config.SERVER_MODE && (sym.toString().charAt(0) != '$')) {
          throw new RuleCreationError(sym);
        }
      }
      if (sym.isProtected()) {
        IOFunctions.printMessage(F.ClearAttributes, "write", F.List(sym), EvalEngine.get());
        throw new FailedException();
      }
      if (attributes.isSymbol()) {
        ISymbol attribute = (ISymbol) attributes;

        clearAttributes(sym, attribute);
        return S.Null;

      } else {
        if (attributes.isList()) {
          final IAST lst = (IAST) attributes;
          // lst.forEach(x -> clearAttributes(sym, (ISymbol) x));
          for (int i = 1; i < lst.size(); i++) {
            ISymbol attribute = (ISymbol) lst.get(i);
            clearAttributes(sym, attribute);
            }
          return S.Null;
        }
      }
      return S.Null;
    }

    /**
     * Remove one single attribute from the symbols existing attributes bit-set.
     *
     * @param sym
     * @param attribute
     */
    private void clearAttributes(final ISymbol sym, ISymbol attribute) {
      int functionID = attribute.ordinal();
      if (functionID > ID.UNKNOWN) {
        switch (functionID) {
          case ID.Constant:
            sym.clearAttributes(ISymbol.CONSTANT);
            break;
          case ID.Flat:
            sym.clearAttributes(ISymbol.FLAT);
            break;

          case ID.Listable:
            sym.clearAttributes(ISymbol.LISTABLE);
            break;

          case ID.OneIdentity:
            sym.clearAttributes(ISymbol.ONEIDENTITY);
            break;

          case ID.Orderless:
            sym.clearAttributes(ISymbol.ORDERLESS);
            break;

          case ID.HoldAll:
            sym.clearAttributes(ISymbol.HOLDALL);
            break;
          case ID.HoldAllComplete:
            sym.clearAttributes(ISymbol.HOLDALLCOMPLETE);
            break;
          case ID.HoldComplete:
            sym.clearAttributes(ISymbol.HOLDCOMPLETE);
            break;
          case ID.HoldFirst:
            sym.clearAttributes(ISymbol.HOLDFIRST);
            break;

          case ID.HoldRest:
            sym.clearAttributes(ISymbol.HOLDREST);
            break;

          case ID.NHoldAll:
            sym.clearAttributes(ISymbol.NHOLDALL);
            break;

          case ID.NHoldFirst:
            sym.clearAttributes(ISymbol.NHOLDFIRST);
            break;

          case ID.NHoldRest:
            sym.clearAttributes(ISymbol.NHOLDREST);
            break;

          case ID.NumericFunction:
            sym.clearAttributes(ISymbol.NUMERICFUNCTION);
            break;
          case ID.SequenceHold:
            sym.clearAttributes(ISymbol.SEQUENCEHOLD);
            break;
        }
      }
    }

  }

  private final static class Protect extends AbstractCoreFunctionEvaluator {

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      if (ast.exists(new Predicate<IExpr>() {
        @Override
        public boolean test(IExpr x) {
          return !x.isSymbol();
        }
      })) {
        return F.NIL;
      }
      final IASTAppendable result = F.ListAlloc(ast.size());
      ast.forEach(new Consumer<IExpr>() {
        @Override
        public void accept(IExpr x) {
          ISymbol symbol = (ISymbol) x;
          if (!symbol.isProtected()) {
            symbol.addAttributes(ISymbol.PROTECTED);
            result.append(x);
          }
        }
      });
      return result;
    }

    @Override
    public void setUp(final ISymbol newSymbol) {
      newSymbol.setAttributes(ISymbol.HOLDALL);
    }
  }

  private final static class Unprotect extends AbstractCoreFunctionEvaluator {

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      if (Config.UNPROTECT_ALLOWED) {
        if (ast.exists(new Predicate<IExpr>() {
          @Override
          public boolean test(IExpr x) {
            return !x.isSymbol();
          }
        })) {
          return F.NIL;
        }

        final IASTAppendable result = F.ListAlloc(ast.size());
        ast.forEach(new Consumer<IExpr>() {
          @Override
          public void accept(IExpr x) {
            ISymbol symbol = (ISymbol) x;
            if (symbol.isProtected()) {
              symbol.clearAttributes(ISymbol.PROTECTED);
              result.append(x);
            }
          }
        });
        return result;
      }
      return engine
          .printMessage("Unprotect: not allowed. Set Config.UNPROTECT_ALLOWED if necessary");
    }

    @Override
    public void setUp(final ISymbol newSymbol) {
      newSymbol.setAttributes(ISymbol.HOLDALL);
    }
  }

  /**
   *
   *
   * <pre>
   * SetAttributes(symbol, attrib)
   * </pre>
   *
   * <blockquote>
   * <p>
   * adds <code>attrib</code> to <code>symbol</code>'s attributes.
   * </p>
   * </blockquote>
   * <h3>Examples</h3>
   *
   * <pre>
   * &gt;&gt; SetAttributes(f, Flat)
   * &gt;&gt; Attributes(f)
   * {Flat}
   * </pre>
   * <p>
   * Multiple attributes can be set at the same time using lists:<br />
   * </p>
   *
   * <pre>
   * &gt;&gt; SetAttributes({f, g}, {Flat, Orderless})
   * &gt;&gt; Attributes(g)
   * {Flat, Orderless}
   * </pre>
   */
  private static final class SetAttributes extends AbstractCoreFunctionEvaluator {

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      try {
        if (ast.isAST2()) {

          if (ast.arg1().isList()) {
            IAST list = (IAST) ast.arg1();
            return setSymbolsAttributes(list, ast.arg2(), ast, engine);
          }
          IExpr arg1 = ast.arg1();
            IExpr arg2 = engine.evaluate(ast.arg2());
            final ISymbol sym = ((ISymbol) ast.arg1());
          return addAttributes(arg1, arg2, ast, engine);
        }
      } catch (RuntimeException rex) {
        //
      }
      return F.NIL;
    }
    private static IExpr setSymbolsAttributes(
        IAST listOfSymbols, IExpr attributes, IAST ast, EvalEngine engine) {
      attributes = engine.evaluate(attributes);
      for (int i = 1; i < listOfSymbols.size(); i++) {
        if (listOfSymbols.get(i).isSymbol()) {
          IExpr temp = addAttributes(listOfSymbols.get(i), attributes, ast, engine);
          if (!temp.isPresent()) {
            return F.NIL;
          }
        }
      }
      return S.Null;
    }

    /**
     * Add the attribute to the symbols existing attributes bit-set.
     *
     * @param sym
     * @param attributes
     * @param engine
     * @return {@link F#NIL} if <code>expr</code> is not a symbol
     */
    private static IExpr addAttributes(
        final IExpr expr, IExpr attributes, IAST ast, EvalEngine engine) {
      IExpr x = Validate.checkIdentifierHoldPattern(expr, ast, engine);
      if (!x.isPresent()) {
        return F.NIL;
      }
      ISymbol sym = (ISymbol) x;
      if (!engine.isPackageMode()) {
        if (Config.SERVER_MODE && (sym.toString().charAt(0) != '$')) {
          throw new RuleCreationError(expr);
        }
      }
      if (attributes.isSymbol()) {
        ISymbol attribute = (ISymbol) attributes;

        addAttributes(sym, attribute);

      } else if (attributes.isList()) {
        final IAST lst = (IAST) attributes;
        // lst.forEach(x -> addAttributes(sym, (ISymbol) x));
        for (int i = 1; i < lst.size(); i++) {
          ISymbol attribute = (ISymbol) lst.get(i);
          addAttributes(sym, attribute);
          }
      }
      return S.Null;
    }

    /**
     * Add one single attribute to the symbols existing attributes bit-set.
     *
     * @param sym
     * @param attribute
     */
    private static void addAttributes(final ISymbol sym, ISymbol attribute) {
      if (sym.isProtected()) {
        IOFunctions.printMessage(F.SetAttributes, "write", F.List(sym), EvalEngine.get());
        throw new FailedException();
      }
      int functionID = attribute.ordinal();
      if (functionID > ID.UNKNOWN) {
        switch (functionID) {
          case ID.Constant:
            sym.addAttributes(ISymbol.CONSTANT);
            break;
          case ID.Flat:
            sym.addAttributes(ISymbol.FLAT);
            break;

          case ID.Listable:
            sym.addAttributes(ISymbol.LISTABLE);
            break;

          case ID.OneIdentity:
            sym.addAttributes(ISymbol.ONEIDENTITY);
            break;

          case ID.Orderless:
            sym.addAttributes(ISymbol.ORDERLESS);
            break;

          case ID.HoldAll:
            sym.addAttributes(ISymbol.HOLDALL);
            break;
          case ID.HoldAllComplete:
            sym.addAttributes(ISymbol.HOLDALLCOMPLETE);
            break;
          case ID.HoldComplete:
            sym.addAttributes(ISymbol.HOLDCOMPLETE);
            break;
          case ID.HoldFirst:
            sym.addAttributes(ISymbol.HOLDFIRST);
            break;

          case ID.HoldRest:
            sym.addAttributes(ISymbol.HOLDREST);
            break;

          case ID.NHoldAll:
            sym.addAttributes(ISymbol.NHOLDALL);
            break;

          case ID.NHoldFirst:
            sym.addAttributes(ISymbol.NHOLDFIRST);
            break;

          case ID.NHoldRest:
            sym.addAttributes(ISymbol.NHOLDREST);
            break;

          case ID.NumericFunction:
            sym.addAttributes(ISymbol.NUMERICFUNCTION);
            break;
          case ID.Protected:
            sym.addAttributes(ISymbol.PROTECTED);
            break;
          case ID.ReadProtected:
            sym.addAttributes(ISymbol.READPROTECTED);
            break;
          case ID.SequenceHold:
            sym.addAttributes(ISymbol.SEQUENCEHOLD);
            break;
        }
      }
    }
  }

  /**
   * Get the attrbutes of this <code>expr</code> as symbolic constants in a list.
   *
   * @param expr
   * @param ast
   * @param engine
   * @return {@link F#NIL} if <code>expr</code> is not a symbol
   */
  public static IAST attributesList(final IExpr expr, IAST ast, EvalEngine engine) {
    IExpr x = Validate.checkIdentifierHoldPattern(expr, ast, engine);
    if (!x.isPresent()) {
      return F.NIL;
    }
    ISymbol symbol = (ISymbol) x;
    return attributesList(symbol);
  }

  /**
   * Get the attrbutes of this <code>symbol</code> as symbolic constants in a list.
   *
   * @param symbol
   * @return
   */
  public static IAST attributesList(final ISymbol symbol) {
    IASTAppendable result = F.ListAlloc(4);
    int attributes = symbol.getAttributes();

    if ((attributes & ISymbol.CONSTANT) != ISymbol.NOATTRIBUTE) {
      result.append(F.Constant);
    }

    if ((attributes & ISymbol.FLAT) != ISymbol.NOATTRIBUTE) {
      result.append(F.Flat);
    }

    if ((attributes & ISymbol.HOLDALLCOMPLETE) == ISymbol.HOLDALLCOMPLETE) {
      result.append(F.HoldAllComplete);
    } else if ((attributes & ISymbol.HOLDCOMPLETE) == ISymbol.HOLDCOMPLETE) {
      result.append(F.HoldComplete);
    } else if ((attributes & ISymbol.HOLDALL) == ISymbol.HOLDALL) {
      result.append(F.HoldAll);
    } else {
      if ((attributes & ISymbol.HOLDFIRST) != ISymbol.NOATTRIBUTE) {
        result.append(F.HoldFirst);
      }

      if ((attributes & ISymbol.HOLDREST) != ISymbol.NOATTRIBUTE) {
        result.append(F.HoldRest);
      }
    }
    if ((attributes & ISymbol.LISTABLE) != ISymbol.NOATTRIBUTE) {
      result.append(F.Listable);
    }

    if ((attributes & ISymbol.NHOLDALL) == ISymbol.NHOLDALL) {
      result.append(F.NHoldAll);
    } else {
      if ((attributes & ISymbol.NHOLDFIRST) != ISymbol.NOATTRIBUTE) {
        result.append(F.NHoldFirst);
      }

      if ((attributes & ISymbol.NHOLDREST) != ISymbol.NOATTRIBUTE) {
        result.append(F.NHoldRest);
      }
    }

    if ((attributes & ISymbol.NUMERICFUNCTION) != ISymbol.NOATTRIBUTE) {
      result.append(F.NumericFunction);
    }
    if ((attributes & ISymbol.ONEIDENTITY) != ISymbol.NOATTRIBUTE) {
      result.append(F.OneIdentity);
    }

    if ((attributes & ISymbol.ORDERLESS) != ISymbol.NOATTRIBUTE) {
      result.append(F.Orderless);
    }

    if ((attributes & ISymbol.PROTECTED) != ISymbol.NOATTRIBUTE) {
      result.append(F.Protected);
    }

    if ((attributes & ISymbol.SEQUENCEHOLD) == ISymbol.SEQUENCEHOLD
        && ((attributes & ISymbol.HOLDALLCOMPLETE) != ISymbol.HOLDALLCOMPLETE)) {
      result.append(F.SequenceHold);
    }
    return result;
  }



  public static void initialize() {
    Initializer.init();
  }

  private AttributeFunctions() {

  }

}
