package org.matheclipse.core.interfaces;


public interface INumericArray extends IDataExpr<Object> {

  /**
   * Get the dimensions of the sparse array.
   *
   * @return
   */
  public int[] getDimension();

  /**
   * Get the type of the numeric array.
   *
   * @return
   */
  public String getType();

  public IExpr get(int position);

  /** Returns <code>true</code> for a numeric array object */
  public boolean isNumericArray();

  public IASTMutable normal(boolean nilIfUnevaluated);

  public IASTMutable normal(int[] dims);
}
