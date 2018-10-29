package ch.ethz.idsc.tensor.qty;

public class IUnitStatic {

    /**
     * @param string, for instance "m*s^-2"
     * @return
     */
    public static IUnit of(String string) {
        return UnitHelper.MEMO.lookup(string);
    }
}
