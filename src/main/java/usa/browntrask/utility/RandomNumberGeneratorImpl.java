package usa.browntrask.utility;

import java.util.Random;

/**
 * Implementation of a random number generator using the standard Java {@link java.util.Random} class.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.6.0 Mar 8, 2008
 * @version V2.2.0 Feb 28, 2015
 */
public final class RandomNumberGeneratorImpl implements RandomNumberGenerator {

	/**
	 * the Java random number generator.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Mar 8, 2008
	 * @version Mar 8, 2008
	 */
	private final Random random;

	/**
	 * Constructs a random number generator with a default seed.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Mar 8, 2008
	 * @version Mar 8, 2008
	 */
	public RandomNumberGeneratorImpl() {
		random = new Random();
	}

	/**
	 * Constructs a random number generator with the specified seed.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param seed
	 *            the initial seed value.
	 * @since V0.6.0 Mar 8, 2008
	 * @version Mar 8, 2008
	 */
	public RandomNumberGeneratorImpl(final long seed) {
		random = new Random(seed);
	}

	/** {@inheritDoc} */
	@Override
	public final int compareTo(final RandomNumberGenerator o) {
		final long difference = (long) hashCode() - o.hashCode();
		return difference < 0l ? -1 : difference > 0l ? 1 : 0;
	}

	/** {@inheritDoc} */
	@Override
	public final boolean nextBoolean() {
		return random.nextBoolean();
	}

	/** {@inheritDoc} */
	@Override
	public final double nextDouble() {
		return random.nextDouble();
	}

	/** {@inheritDoc} */
	@Override
	public final float nextFloat() {
		return random.nextFloat();
	}

	/** {@inheritDoc} */
	@Override
	public final int nextInt() {
		return random.nextInt();
	}

	/** {@inheritDoc} */
	@Override
	public final int nextInt(final int number) {
		return random.nextInt(number);
	}

	/** {@inheritDoc} */
	@Override
	public final long nextLong() {
		return random.nextLong();
	}

	/** {@inheritDoc} */
	@Override
	public final void setSeed(final long seed) {
		random.setSeed(seed);
	}

}
