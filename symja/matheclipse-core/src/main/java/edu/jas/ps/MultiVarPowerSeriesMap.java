/*
 * $Id$
 */

package edu.jas.ps;


import edu.jas.structure.elem.RingElem;


/**
 * Multivariate power series map interface. Defines method for mapping of power
 * series.
 *
 * @param <C> ring element type
 * @author Heinz Kredel
 */

public interface MultiVarPowerSeriesMap<C extends RingElem<C>> {


    /**
     * Map.
     *
     * @return new power series resulting from mapping elements of ps.
     */
    MultiVarPowerSeries<C> map(MultiVarPowerSeries<C> ps);

}
