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
    private static final ThreadLocal<RandomGenerator> ThreadLocalRandom
            = ThreadLocal.withInitial(() -> new Well1024a(0x7f67fcad528cfae9L));

    private PrivateRandom() {
    }

    /**
     * Returns random generator associated with current thread
     */
    static RandomGenerator getRandom() {
        return ThreadLocalRandom.get();
    }
}
