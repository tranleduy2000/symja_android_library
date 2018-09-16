package cc.redberry.combinatorics;

/**
 * Iterator over all compositions of specified integer into N parts.
 *
 * <p>Implementation note: the description of the algorithm can be found here <a href="https://stackoverflow.com/a/6609080/946635">https://stackoverflow.com/a/6609080/946635</a>
 *
 * @author Stanislav Poslavsky
 * @since 2.0
 */
public final class IntCompositions implements IntCombinatorialPort {
    private static final long serialVersionUID = 7938373353634964549L;
    private final int integer;
    private final int nCompositions;
    private final IntCombinations generator;
    private int[] array;

    public IntCompositions(int integer, int nCompositions) {
        this.integer = integer;
        this.nCompositions = nCompositions;
        this.generator = new IntCombinations(integer + nCompositions - 1, nCompositions - 1);
        this.array = new int[nCompositions];
    }

    @Override
    public void reset() {generator.reset();}

    @Override
    public int[] getReference() {
        return array;
    }

    @Override
    public int[] take() {
        if (!generator.hasNext())
            return array = null;

        int[] gen = generator.next();
        if (gen.length == 0) {
            array[0] = integer;
            return array;
        }
        array[0] = gen[0];
        array[array.length - 1] = integer + nCompositions - 1 - gen[gen.length - 1] - 1;
        for (int i = 1; i < array.length - 1; ++i)
            array[i] = gen[i] - gen[i - 1] - 1;

        return array;
    }
}
