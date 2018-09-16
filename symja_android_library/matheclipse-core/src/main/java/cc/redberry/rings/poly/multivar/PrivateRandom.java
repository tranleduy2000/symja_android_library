package cc.redberry.rings.poly.multivar;

import org.hipparchus.random.RandomGenerator;
import org.hipparchus.random.Well1024a;

/**
 * @since 1.0
 */
final class PrivateRandom {
    /**
     * thread local instance of random
     */
    private static final RandomGenerator sRandom;

    static {
        sRandom = new Well1024a(System.currentTimeMillis());
    }

    private PrivateRandom() {
    }

    /**
     * Returns random generator associated with current thread
     */
    static RandomGenerator getRandom() {
        return sRandom;
    }
}
