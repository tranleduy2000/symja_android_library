package org.matheclipse.core.expression;

import org.matheclipse.core.basic.Config;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.parser.trie.TrieMatch;
import org.matheclipse.parser.trie.Tries;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Context implements Serializable {

  private static final long serialVersionUID = 8656114325955206899L;

  /** The map for predefined (context &quot;System&quot;) symbols */
  public static final Map<String, ISymbol> PREDEFINED_SYMBOLS_MAP =
      Config.TRIE_STRING2SYMBOL_BUILDER.withMatch(TrieMatch.EXACT).build(); // Tries.forStrings();

  public static final String DUMMY_CONTEXT_NAME = "DUMMY`";

  public static final Context DUMMY = new Context(DUMMY_CONTEXT_NAME, null);

  // Global context should not be defined global, but per EvalENgine
  // public final static Context GLOBAL = new Context("Global`");
  public static final String SYSTEM_CONTEXT_NAME = "System`";

  public static final Context SYSTEM =
      new Context(SYSTEM_CONTEXT_NAME, null, PREDEFINED_SYMBOLS_MAP);

  // public final static Context INTEGRATE = new Context("Integrate`");

  public static final String RUBI_STR = "Rubi`";
  public static final Context RUBI = new Context(RUBI_STR);

  private String contextName;

  private transient Context parentContext;
  private Map<String, ISymbol> symbolTable;

  public static final String GLOBAL_CONTEXT_NAME = "Global`";

  public Context(String contextName) {
    this(contextName, null, new HashMap<String, ISymbol>());
  }

  public Context(String contextName, Context parentContext) {
    this(contextName, parentContext, new HashMap<String, ISymbol>());
  }

  private Context(String contextName, Context parentContext, Map<String, ISymbol> symbolTable) {
    this.symbolTable = symbolTable;
    this.contextName = contextName;
    this.parentContext = parentContext;
  }

  public Context copy() {
    if (this == SYSTEM) {
      return SYSTEM;
    }
    return new Context(contextName, parentContext,
        (Map<String, ISymbol>) ((HashMap<String, ISymbol>) symbolTable).clone());
  }

  public Set<Entry<String, ISymbol>> entrySet() {
    return symbolTable.entrySet();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj instanceof Context) {
      return contextName.equals(((Context) obj).contextName);
    }
    return false;
  }

  public ISymbol get(String key) {
    return symbolTable.get(key);
  }

  /**
   * Get the &quot;pure&quot; context name without prepending the parent context name.
   *
   * @return
   */
  public String getContextName() {
    return contextName;
  }

  /**
   * If the current parent context isn't <code>null</code> or <code>Global`</code> get the complete
   * context name prepended with the parent context name.
   *
   * @return
   */
  public String completeContextName() {
    String completeContextName = contextName;
    if (parentContext != null) {
      String packageName = parentContext.getContextName();
      if (!packageName.equals(Context.GLOBAL_CONTEXT_NAME)) {
        completeContextName = packageName.substring(0, packageName.length() - 1) + contextName;
      }
    }
    return completeContextName;
  }

  @Override
  public int hashCode() {
    return 47 + contextName.hashCode();
  }

  public boolean isGlobal() {
    return contextName.equals(Context.GLOBAL_CONTEXT_NAME);
  }

  // private static int counter = 0;

  public ISymbol put(String key, ISymbol value) {
    // if (!contextName.equals("System")) {
    // counter++;
    // if (counter > 500) {
    // System.out.println(contextName + "`" + value);
    // }
    // }
    return symbolTable.put(key, value);
  }

  private void readObject(java.io.ObjectInputStream stream)
      throws IOException, ClassNotFoundException {
    contextName = stream.readUTF();
    int size = stream.readInt();
    symbolTable = new HashMap<String, ISymbol>(size + size / 10);
    EvalEngine.get().getContextPath().setGlobalContext(this);
    String[] table = new String[size];
    for (int i = 0; i < size; i++) {
      table[i] = stream.readUTF();
    }
    for (int i = 0; i < size; i++) {
      ISymbol symbol = (ISymbol) stream.readObject();
      symbolTable.put(table[i], symbol);
    }

  }

  public ISymbol remove(String key) {
    return symbolTable.remove(key);
  }

  public int size() {
    return symbolTable.size();
  }

  @Override
  public String toString() {
    return contextName;
  }

  private Object readResolve() throws ObjectStreamException {
    if (contextName.equals(DUMMY_CONTEXT_NAME)) {
      return DUMMY;
    } else if (contextName.equals(SYSTEM_CONTEXT_NAME)) {
      return SYSTEM;
    }
    return this;
  }

  private void writeObject(java.io.ObjectOutputStream stream) throws java.io.IOException {
    stream.writeUTF(contextName);
    Set<Entry<String, ISymbol>> entrySet = symbolTable.entrySet();
    stream.writeInt(entrySet.size());
    for (Entry<String, ISymbol> entry : entrySet) {
      stream.writeUTF(entry.getKey());
    }
    for (Entry<String, ISymbol> entry : entrySet) {
      stream.writeObject(entry.getValue());
    }
  }
}
