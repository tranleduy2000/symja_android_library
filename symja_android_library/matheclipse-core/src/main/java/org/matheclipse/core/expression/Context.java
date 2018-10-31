package org.matheclipse.core.expression;

import org.matheclipse.core.interfaces.ISymbol;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Context implements Serializable {

	private static final long serialVersionUID = 8656114325955206899L;

	/**
	 * The map for predefined (context &quot;System&quot;) symbols
	 */
	public final static HashMap<String, ISymbol> PREDEFINED_SYMBOLS_MAP = new HashMap<String, ISymbol>(2053);

	public final static Context DUMMY = new Context("DUMMY`", null);

	// Global context should not be defined global, but per EvalENgine
	// public final static Context GLOBAL = new Context("Global`");

	public final static Context SYSTEM = new Context("System`", PREDEFINED_SYMBOLS_MAP);

	// public final static Context INTEGRATE = new Context("Integrate`");

	public final static String RUBI_STR = "Rubi`";
	public final static Context RUBI = new Context(RUBI_STR);

	private String contextName;

	private HashMap<String, ISymbol> symbolTable;

	public Context(String contextName) {
		this(contextName, new HashMap<String, ISymbol>());
	}

	private Context(String contextName, HashMap<String, ISymbol> symbolTable) {
		this.symbolTable = symbolTable;
		this.contextName = contextName;
	}

	public Context copy() {
		if (this == SYSTEM) {
			return SYSTEM;
		}
		return new Context(contextName, (HashMap<String, ISymbol>) symbolTable.clone());
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

	public ISymbol get(Object key) {
		return symbolTable.get(key);
	}

	public String getContextName() {
		return contextName;
	}

	@Override
	public int hashCode() {
		if (contextName != null) {
			return contextName.hashCode();
		}
		return 47;
	}

	public boolean isGlobal() {
		return contextName.equals(ContextPath.GLOBAL_CONTEXT_NAME);
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

	private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
		contextName = stream.readUTF();
		symbolTable = (HashMap<String, ISymbol>) stream.readObject();
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

	private void writeObject(java.io.ObjectOutputStream stream) throws java.io.IOException {
		stream.writeUTF(contextName);
		stream.writeObject(symbolTable);
	}
}
