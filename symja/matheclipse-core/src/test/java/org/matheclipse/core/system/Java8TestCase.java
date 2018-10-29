package org.matheclipse.core.system;

import com.duy.lambda.Consumer;

import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IExpr;

import static org.matheclipse.core.expression.F.C10;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.e;

/**
 * Tests for the Java port of the
 * <a href="http://www.apmaths.uwo.ca/~arich/">Rubi - rule-based integrator</a>.
 */
public class Java8TestCase extends AbstractTestCase {
    public Java8TestCase(String name) {
        super(name);
    }
}
