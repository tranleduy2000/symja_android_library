package org.matheclipse.core.reflection.system.rules;

import static org.matheclipse.core.expression.F.*;
import org.matheclipse.core.interfaces.IAST;

/**
 * <p>Generated by <code>org.matheclipse.core.preprocessor.RulePreprocessor</code>.</p>
 * <p>See GIT repository at: <a href="https://github.com/axkr/symja_android_library">github.com/axkr/symja_android_library under the tools directory</a>.</p>
 */
public interface WhittakerWRules {
  final public static IAST RULES = List(
    // WhittakerW(n_,m_,0):=0/;-1/2<Re(m)<1/2
    ISetDelayed(WhittakerW(n_,m_,C0),
      Condition(C0,Less(CN1D2,Re(m),C1D2)))
  );
}