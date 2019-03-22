package org.matheclipse.core.expression;

import com.duy.lambda.Function;

import org.hipparchus.complex.Complex;
import org.matheclipse.core.basic.Config;
import org.matheclipse.core.builtin.AttributeFunctions;
import org.matheclipse.core.convert.AST2Expr;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.RuleCreationError;
import org.matheclipse.core.eval.exception.WrongArgumentType;
import org.matheclipse.core.form.output.OutputFormFactory;
import org.matheclipse.core.generic.UnaryVariable2Slot;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IASTMutable;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.INumber;
import org.matheclipse.core.interfaces.ISignedNumber;
import org.matheclipse.core.interfaces.IStringX;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.interfaces.ISymbolImpl;
import org.matheclipse.core.patternmatching.IPatternMatcher;
import org.matheclipse.core.patternmatching.PatternMap;
import org.matheclipse.core.patternmatching.PatternMatcherAndInvoker;
import org.matheclipse.core.patternmatching.RulesData;
import org.matheclipse.core.polynomials.ExprPolynomialRing;
import org.matheclipse.core.visit.IVisitor;
import org.matheclipse.core.visit.IVisitorBoolean;
import org.matheclipse.core.visit.IVisitorInt;
import org.matheclipse.core.visit.IVisitorLong;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Locale;
import java.util.Map;

public class Symbol extends ISymbolImpl implements ISymbol, Serializable {

    protected transient Context fContext;
    /**
     * The attribute values of the symbol represented by single bits.
     */
    protected int fAttributes = NOATTRIBUTE;
    /**
     * The value associate with this symbol.
     */
    protected transient IExpr fValue;
    /**
     * The pattern matching &quot;down value&quot; rules associated with this symbol.
     */
    protected transient RulesData fRulesData;

    /**
     * The name of this symbol. The characters may be all lower-cases if the system doesn't distinguish between lower-
     * and upper-case function names.
     */
    protected String fSymbolName;

    // public static ISymbol valueOf(final String symbolName, final Context context) {
    // return new Symbol(symbolName, context);
    // }
    public Symbol(final String symbolName, final Context context) {
        super();
        fContext = context;
        fSymbolName = symbolName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean accept(IVisitorBoolean visitor) {
        return visitor.visit(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int accept(IVisitorInt visitor) {
        return visitor.visit(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long accept(IVisitorLong visitor) {
        return visitor.visit(this);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public final IExpr apply(IExpr... expressions) {
        return F.ast(expressions, this);
    }

    /**
     * Compares this expression with the specified expression for order. Returns a negative integer, zero, or a positive
     * integer as this expression is canonical less than, equal to, or greater than the specified expression.
     */
    @Override
    public int compareTo(final IExpr expr) {
        if (expr instanceof ISymbol) {
            // O-2
            if (this == expr) {
                // Symbols are unique objects
                // Makes no sense to compare the symbol names, if they are equal
                return 0;
            }
            // sort lexicographically
            return StringX.US_COLLATOR.compare(fSymbolName, ((ISymbol) expr).getSymbolName());
        }
        if (expr.isAST()) {
        if (expr.isNot() && expr.first().isSymbol()) {
                final int cp = compareTo(expr.first());
            return cp != 0 ? cp : -1;
        }
            if (!expr.isDirectedInfinity()) {
                return -1 * expr.compareTo(this);
            }
    }
        int x = hierarchy();
        int y = expr.hierarchy();
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final Complex evalComplex() {
        INumber number = evalNumber();
        if (number != null) {
            return number.complexNumValue().complexValue();
        }
        throw new WrongArgumentType(this, "Conversion into a complex numeric value is not possible!");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final INumber evalNumber() {
        if (isNumericFunction()) {
            IExpr result = F.evaln(this);
            if (result.isNumber()) {
                return (INumber) result;
            }
        } else if (fValue != null) {
            IExpr temp = assignedValue();
            if (temp != null && temp.isNumericFunction()) {
                IExpr result = F.evaln(this);
                if (result.isNumber()) {
                    return (INumber) result;
                }
            }
            // } else {
            // IExpr temp = evalDownRule(EvalEngine.get(), this);
            // if (temp.isPresent() && temp.isNumericFunction()) {
            // IExpr result = F.evaln(this);
            // if (result.isNumber()) {
            // return (INumber) result;
            // }
            // }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final ISignedNumber evalReal() {
        if (isNumericFunction()) {
            IExpr result = F.evaln(this);
            if (result.isReal()) {
                return (ISignedNumber) result;
            }
        } else if (fValue != null) {
            IExpr temp = assignedValue();
            if (temp != null && temp.isNumericFunction()) {
                IExpr result = F.evaln(this);
                if (result.isReal()) {
                    return (ISignedNumber) result;
                }
            }
            // } else {
            // IExpr temp = evalDownRule(EvalEngine.get(), this);
            // if (temp.isPresent() && temp.isNumericFunction()) {
            // IExpr result = F.evaln(this);
            // if (result.isReal()) {
            // return (ISignedNumber) result;
            // }
            // }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IExpr evaluate(EvalEngine engine) {
        if (fValue != null) {
            return fValue;
        }
        // if (hasLocalVariableStack()) {
        // return ExprUtil.ofNullable(get());
        // }
        IExpr result;
        if ((result = evalDownRule(engine, this)).isPresent()) {
            return result;
        }
        return F.NIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IExpr evaluateHead(IAST ast, EvalEngine engine) {
        IExpr result = evaluate(engine);
        if (result.isPresent()) {
            // set the new evaluated header !
            return ast.apply(result);
        }
        return F.NIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String fullFormString() {
        if (Config.PARSER_USE_LOWERCASE_SYMBOLS) {
            String str = AST2Expr.PREDEFINED_SYMBOLS_MAP.get(fSymbolName);
            if (str != null) {
                return str;
            }
        }
        return fSymbolName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ISymbol head() {
        return F.Symbol;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hierarchy() {
        return SYMBOLID;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String internalFormString(boolean symbolsAsFactoryMethod, int depth) {
        return internalJavaString(symbolsAsFactoryMethod, depth, false, false, false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String internalJavaString(boolean symbolsAsFactoryMethod, int depth, boolean useOperators, boolean usePrefix,
                                     boolean noSymbolPrefix) {
        String prefix = usePrefix ? "F." : "";
        if (symbolsAsFactoryMethod) {
            return prefix + internalJavaStringAsFactoryMethod();
        }
        if (Config.PARSER_USE_LOWERCASE_SYMBOLS) {
            String name;
            if (fSymbolName.length() == 1) {
                name = AST2Expr.PREDEFINED_SYMBOLS_MAP.get(fSymbolName);
            } else {
                name = AST2Expr.PREDEFINED_SYMBOLS_MAP.get(fSymbolName.toLowerCase(Locale.ENGLISH));
            }
            if (name != null) {
                return prefix + name;
            }
        } else {
            String name = AST2Expr.PREDEFINED_SYMBOLS_MAP.get(fSymbolName.toLowerCase(Locale.ENGLISH));
            if (name != null && name.equals(fSymbolName)) {
                return prefix + name;
            }
        }
        char ch = fSymbolName.charAt(0);
        if (!noSymbolPrefix && fSymbolName.length() == 1 && ('a' <= ch && ch <= 'z')) {
            return prefix + fSymbolName;
        } else {
            return fSymbolName;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String internalScalaString(boolean symbolsAsFactoryMethod, int depth) {
        return internalJavaString(symbolsAsFactoryMethod, depth, true, false, false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean isAtom() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean isConstant() {
        return (fAttributes & CONSTANT) == CONSTANT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isNegative() {
        if (isNumericFunction()) {
            IExpr temp = F.evaln(this);
            if (temp.isReal() && temp.isNegative()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isNumericFunction() {
        if (isConstant()) {
            return true;
        }
        if (fValue != null) {
            IExpr temp = assignedValue();
            if (temp != null && temp != this && temp.isNumericFunction()) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isPolynomial(IAST variables) {
        if (variables.isAST0()) {
            return true;
        }
        // if (isConstant()) {
        // return true;
        // }
        ExprPolynomialRing ring = new ExprPolynomialRing(variables);
        return ring.isPolynomial(this);
        // return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isPolynomial(IExpr variable) {
        return isPolynomial(F.List(variable));
        // if (variable == null) {
        // return true;
        // }
        // return this.equals(variable);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isPolynomialOfMaxDegree(ISymbol variable, long maxDegree) {
        if (maxDegree == 0L) {
            if (this.equals(variable)) {
                return false;
            }
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isPositive() {
        if (isNumericFunction()) {
            IExpr temp = F.evaln(this);
            if (temp.isReal() && temp.isPositive()) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean isValue() {
        return evaluate(EvalEngine.get()).isPresent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isVariable() {
        return (fAttributes & CONSTANT) != CONSTANT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IExpr variables2Slots(final Map<IExpr, IExpr> map, final Collection<IExpr> variableCollector) {
        final UnaryVariable2Slot uv2s = new UnaryVariable2Slot(map, variableCollector);
        return uv2s.apply(this);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public final void addAttributes(final int attributes) {
        fAttributes |= attributes;
        if (isLocked()) {
            throw new RuleCreationError(this);
        }
        EvalEngine engine = EvalEngine.get();
        engine.addModifiedVariable(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void assign(final IExpr value) {
        fValue = value;
        // final Deque<IExpr> localVariableStack = EvalEngine.get().localStack(this);
        // localVariableStack.remove();
        // localVariableStack.push(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IExpr assignedValue() {
        return fValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void clear(EvalEngine engine) {
        if (!engine.isPackageMode()) {
            if (isLocked()) {
                throw new RuleCreationError(this);
            }
        }
        fValue = null;
        if (fRulesData != null) {
            fRulesData = null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void clearAll(EvalEngine engine) {
        clear(engine);
        fAttributes = NOATTRIBUTE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void clearAttributes(final int attributes) {
        fAttributes &= (0xffff ^ attributes);
        if (isLocked()) {
            throw new RuleCreationError(this);
        }
        EvalEngine engine = EvalEngine.get();
        engine.addModifiedVariable(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsRules() {
        return fRulesData != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final RulesData createRulesData(int[] sizes) {
        if (fRulesData == null) {
            fRulesData = new RulesData(EvalEngine.get().getContext(), sizes);
        }
        return fRulesData;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IAST definition() {
        IASTAppendable result = F.ListAlloc();
        if (fValue != null) {
            result.append(F.Set(this, fValue));
        }
        if (fRulesData != null) {
            result.appendAll(fRulesData.definition());
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String definitionToString() throws IOException {
        StringWriter buf = new StringWriter();
        IAST attributesList = AttributeFunctions.attributesList(this);
        OutputFormFactory off = OutputFormFactory.get(EvalEngine.get().isRelaxedSyntax());
        off.setIgnoreNewLine(true);
        IAST list = definition();
        buf.append("Attributes(");
        buf.append(this.toString());
        buf.append(")=");
        buf.append(attributesList.toString());
        buf.append("\n");
        for (int i = 1; i < list.size(); i++) {
            off.convert(buf, list.get(i));
            if (i < list.size() - 1) {
                buf.append("\n");
                off.setColumnCounter(0);
            }
        }
        return buf.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final IExpr evalDownRule(final EvalEngine engine, final IExpr expression) {
        if (fRulesData == null) {
            return F.NIL;
        }
        return fRulesData.evalDownRule(expression, engine);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final IExpr evalUpRule(final EvalEngine engine, final IExpr expression) {
        if (fRulesData == null) {
            return F.NIL;
        }
        return fRulesData.evalUpRule(expression, engine);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final int getAttributes() {
        return fAttributes;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void setAttributes(final int attributes) {
        fAttributes = attributes;
        if (isLocked()) {
            throw new RuleCreationError(this);
        }
        EvalEngine engine = EvalEngine.get();
        engine.addModifiedVariable(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Context getContext() {
        return fContext;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IExpr getDefaultValue() {
        // special case for a general default value
        return fRulesData != null ? fRulesData.getDefaultValue(RulesData.DEFAULT_VALUE_INDEX) : null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDefaultValue(IExpr expr) {
        // special case for a general default value
        setDefaultValue(RulesData.DEFAULT_VALUE_INDEX, expr);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IExpr getDefaultValue(int pos) {
        // default value at this position
        return fRulesData != null ? fRulesData.getDefaultValue(pos) : null;
    }

    /**
     * Get the rules for initializing the pattern matching rules of this symbol.
     *
     * @return <code>null</code> if no rule is defined
     */
    @Override
    public RulesData getRulesData() {
        return fRulesData;
    }

    public void setRulesData(RulesData rd) {
        fRulesData = rd;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String getSymbolName() {
        return fSymbolName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasAssignedSymbolValue() {
        return fValue != null;
    }

    @Override
    public boolean hasFlatAttribute() {
        return (fAttributes & FLAT) == FLAT;
    }

    @Override
    public boolean hasOneIdentityAttribute() {
        return (fAttributes & ONEIDENTITY) == ONEIDENTITY;
    }

    @Override
    public boolean hasOrderlessAttribute() {
        return (fAttributes & ORDERLESS) == ORDERLESS;
    }

    @Override
    public boolean hasOrderlessFlatAttribute() {
        return (fAttributes & FLATORDERLESS) == FLATORDERLESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isLocked() {
        return !EvalEngine.get().isPackageMode() && (fContext == Context.SYSTEM || fContext == Context.RUBI);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isLocked(boolean packageMode) {
        return !packageMode && (fContext == Context.SYSTEM || fContext == Context.RUBI);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean isString(final String str) {
        return fSymbolName.equals(str);
    }

    @Override
    public final boolean isSymbolName(String name) {
        if (Config.PARSER_USE_LOWERCASE_SYMBOLS) {
            if (fSymbolName.length() == 1) {
                return fSymbolName.equals(name);
            }
            return fSymbolName.equalsIgnoreCase(name);
        }
        return fSymbolName.equals(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IExpr of(EvalEngine engine, IExpr... args) {
        IAST ast = F.ast(args, this);
        return engine.evaluate(ast);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public IExpr of(IExpr... args) {
        return of(EvalEngine.get(), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean ofQ(EvalEngine engine, IExpr... args) {
        IAST ast = F.ast(args, this);
        return engine.evalTrue(ast);
    }

    @Override
    public boolean ofQ(IExpr... args) {
        return ofQ(EvalEngine.get(), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void putDownRule(final PatternMatcherAndInvoker pmEvaluator) {
        if (fRulesData == null) {
            fRulesData = new RulesData(EvalEngine.get().getContext());
        }
        fRulesData.insertMatcher(pmEvaluator);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void putDownRule(final int setSymbol, final boolean equalRule, final IExpr leftHandSide,
                                  final IExpr rightHandSide, boolean packageMode) {
        putDownRule(setSymbol, equalRule, leftHandSide, rightHandSide, PatternMap.DEFAULT_RULE_PRIORITY, packageMode);
    }

    public IExpr evalMessage(String messageName) {
        if (fRulesData != null) {
            IExpr temp = fRulesData.getMessages().get(messageName);
            if (temp != null) {
                return temp;
            }
        }
        return F.NIL;
    }

    public void putMessage(final int setSymbol, String messageName, IStringX message) {
        if (fRulesData == null) {
            fRulesData = new RulesData(EvalEngine.get().getContext());
        }
        fRulesData.getMessages().put(messageName, message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void putDownRule(final int setSymbol, final boolean equalRule, final IExpr leftHandSide,
                                  final IExpr rightHandSide, final int priority, boolean packageMode) {
        EvalEngine engine = EvalEngine.get();
        if (!packageMode) {
            if (isLocked(packageMode)) {
                throw new RuleCreationError(leftHandSide);
            }
            engine.addModifiedVariable(this);
        }
        if (leftHandSide.isSymbol()) {
            fValue = rightHandSide;
            return;
        }
        if (fRulesData == null) {
            fRulesData = new RulesData(engine.getContext());
        }
        fRulesData.putDownRule(setSymbol, equalRule, leftHandSide, rightHandSide, priority);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final IPatternMatcher putUpRule(final int setSymbol, boolean equalRule, IAST leftHandSide,
                                           IExpr rightHandSide) {
        return putUpRule(setSymbol, equalRule, leftHandSide, rightHandSide, PatternMap.DEFAULT_RULE_PRIORITY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final IPatternMatcher putUpRule(final int setSymbol, final boolean equalRule,
                                           final IAST leftHandSide, final IExpr rightHandSide, final int priority) {
        EvalEngine engine = EvalEngine.get();
        if (!engine.isPackageMode()) {
            if (isLocked(false)) {
                throw new RuleCreationError(leftHandSide);
            }

            engine.addModifiedVariable(this);
        }
        if (fRulesData == null) {
            fRulesData = new RulesData(engine.getContext());
        }
        return fRulesData.putUpRule(setSymbol, equalRule, leftHandSide, rightHandSide);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void readRules(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
        fSymbolName = stream.readUTF();
        fAttributes = stream.read();
        boolean hasDownRulesData = stream.readBoolean();
        if (hasDownRulesData) {
            fRulesData = new RulesData(EvalEngine.get().getContext());
            fRulesData = (RulesData) stream.readObject();
        }
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public IExpr[] reassignSymbolValue(IASTMutable ast, ISymbol functionSymbol, EvalEngine engine) {
        if (fValue != null) {
            IExpr[] result = new IExpr[2];
            result[0] = fValue;
            ast.set(1, fValue);
            IExpr calculatedResult = engine.evaluate(ast);// F.binaryAST2(this, symbolValue, value));
            if (calculatedResult != null) {
                assign(calculatedResult);
                result[1] = calculatedResult;
                return result;
            }

        }
        throw new WrongArgumentType(this, functionSymbol.toString() + " - Symbol: " + toString()
                + " has no value! Reassignment with a new value is not possible");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean removeRule(final int setSymbol, final boolean equalRule, final IExpr leftHandSide,
                                    boolean packageMode) {
        if (!packageMode) {
            if (isLocked(packageMode)) {
                throw new RuleCreationError(leftHandSide);
            }

            EvalEngine.get().addModifiedVariable(this);
        }
        if (leftHandSide.isSymbol()) {
            fValue = null;
            return true;
        } else if (fRulesData != null) {
            return fRulesData.removeRule(setSymbol, equalRule, leftHandSide);

        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDefaultValue(int pos, IExpr expr) {
        // default value at this position
        if (fRulesData == null) {
            fRulesData = new RulesData(EvalEngine.get().getContext());
        }
        fRulesData.putfDefaultValues(pos, expr);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean writeRules(java.io.ObjectOutputStream stream) throws java.io.IOException {
        stream.writeUTF(fSymbolName);
        stream.write(fAttributes);
        // if (!containsRules()) {
        // return false;
        // }
        if (fRulesData == null) {
            stream.writeBoolean(false);
        } else {
            stream.writeBoolean(true);
            stream.writeObject(fRulesData);
        }
        return true;
    }

    @Override
    public IExpr copy() {
        try {
            return (IExpr) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        return this == obj;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return (fSymbolName == null) ? 31 : fSymbolName.hashCode();
    }

    @Override
    public String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            OutputFormFactory.get(EvalEngine.get().isRelaxedSyntax()).convertSymbol(sb, this);
            return sb.toString();
        } catch (Exception e1) {
            return fSymbolName;
        }
    }

    /**
     * Used to generate special Symja Java code
     *
     * @return
     */
    protected String internalJavaStringAsFactoryMethod() {
        if (fSymbolName.length() == 1) {
            char ch = fSymbolName.charAt(0);
            if ('a' <= ch && ch <= 'z') {
                return fSymbolName;
            }
            if ('A' <= ch && ch <= 'G' && ch != 'D' && ch != 'E') {
                return fSymbolName + "Symbol";
            }
            if ('P' == ch || ch == 'Q') {
                return fSymbolName + "Symbol";
            }
        }
        if (Config.RUBI_CONVERT_SYMBOLS) {
            if (fSymbolName.length() == 2 && '§' == fSymbolName.charAt(0)
                    && Character.isLowerCase(fSymbolName.charAt(1))) {
                char ch = fSymbolName.charAt(1);
                if ('a' <= ch && ch <= 'z') {
                    return "p" + ch;
                }
            } else if (fSymbolName.equals("Int")) {
                return "Integrate";
            }
        }
        if (Character.isUpperCase(fSymbolName.charAt(0))) {
            String alias = F.PREDEFINED_INTERNAL_FORM_STRINGS.get(fSymbolName);
            if (alias != null) {
                if (Config.RUBI_CONVERT_SYMBOLS) {
                    if (alias.startsWith("Rubi`")) {
                        return "$rubi(\"" + alias.substring(5) + "\")";
                    }
                }
                return alias;
            }
        }
        return "$s(\"" + fSymbolName + "\")";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IExpr ofNIL(EvalEngine engine, IExpr... args) {
        IAST ast = F.ast(args, this);
        IExpr temp = engine.evalLoop(ast);
        if (temp.isPresent() && temp.head() == this) {
            return F.NIL;
        }
        return temp;
    }
    private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
        fSymbolName = stream.readUTF();
        fAttributes = stream.read();
        fValue = (IExpr) stream.readObject();
        int contextNumber = stream.readInt();
        switch (contextNumber) {
            case 1:
                fContext = Context.SYSTEM;
                break;
            case 2:
                fContext = Context.RUBI;
                break;
            case 3:
                fContext = Context.DUMMY;
                break;
            default:
                String contextName = stream.readUTF();
                fContext = EvalEngine.get().getContextPath().getContext(contextName);
                Symbol symbol = (Symbol) fContext.get(fSymbolName);
                if (symbol == null) {
                    fContext.put(fSymbolName, this);
                    symbol = this;
                } else {
                    symbol.fAttributes = fAttributes;
                    symbol.fValue = fValue;
                }
                boolean hasDownRulesData = stream.readBoolean();
                if (hasDownRulesData) {
                    symbol.fRulesData = (RulesData) stream.readObject();
                }
        }
    }

    public Object readResolve() throws ObjectStreamException {
        return fContext == Context.DUMMY ? this : fContext.get(fSymbolName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IExpr[] reassignSymbolValue(Function<IExpr, IExpr> function, ISymbol functionSymbol, EvalEngine engine) {
        if (fValue != null) {
            IExpr[] result = new IExpr[2];
            result[0] = fValue;
            IExpr calculatedResult = function.apply(fValue);
            if (calculatedResult.isPresent()) {
                assign(calculatedResult);
                result[1] = calculatedResult;
                return result;
            }
        }
        engine.printMessage(toString() + " is not a variable with a value, so its value cannot be changed.");
        return null;
    }
    private void writeObject(java.io.ObjectOutputStream stream) throws java.io.IOException {
        stream.writeUTF(fSymbolName);
        stream.write(fAttributes);
        stream.writeObject(fValue);
        if (fContext.equals(Context.SYSTEM)) {
            stream.writeInt(1);
        } else if (fContext.equals(Context.RUBI)) {
            stream.writeInt(2);
        } else if (fContext.equals(Context.DUMMY)) {
            stream.writeInt(3);
        } else {
            stream.writeInt(0);
            stream.writeUTF(fContext.getContextName());
            if (fRulesData == null) {
                stream.writeBoolean(false);
            } else {
                stream.writeBoolean(true);
                stream.writeObject(fRulesData);
            }
        }
    }

    private Object writeReplace() throws ObjectStreamException {
        return optional(F.GLOBAL_IDS_MAP.get(this));
    }

    void addValue(IdentityHashMap<ISymbol, IExpr> map) {
        map.put(this, fValue);
    }

}
