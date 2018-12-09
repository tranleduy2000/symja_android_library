package org.matheclipse.core.interfaces;

/**
 * (I)nterface for a (String) e(X)pression
 * 
 */
public interface IDataExpr extends IExpr {

	/**
	 *
	 * @return the data part of the IDataExpr
	 */
	public Object toData();
}
