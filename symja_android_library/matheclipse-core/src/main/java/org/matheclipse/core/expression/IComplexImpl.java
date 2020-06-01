package org.matheclipse.core.expression;

import org.matheclipse.core.interfaces.IBigNumberImpl;
import org.matheclipse.core.interfaces.IComplex;
import org.matheclipse.core.interfaces.IRational;

/**
 * Created by Duy on 2/20/2018.
 */
public abstract class IComplexImpl extends IBigNumberImpl implements IComplex {
    @Override
    public abstract IComplex inverse();

    @Override
    public abstract IRational im();

    @Override
    public abstract IRational re();

}
