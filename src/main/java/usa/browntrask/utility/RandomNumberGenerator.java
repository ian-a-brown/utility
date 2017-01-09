package usa.browntrask.utility;

/**
 * Interface for objects that generate random numbers.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.1 Mar 8, 2008
 * @version V1.4.0 Mar 7, 2010
 */
public interface RandomNumberGenerator extends Comparable<RandomNumberGenerator> {

	/**
	 * Returns the next random boolean.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the random boolean value.
	 * @since V0.6.0 Mar 8, 2008
	 * @version V0.6.0 Mar 8, 2008
	 */
	boolean nextBoolean();

	/**
	 * Returns the next random double.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the random double value.
	 * @since V0.6.0 Mar 8, 2008
	 * @version V0.6.0 Mar 8, 2008
	 */
	double nextDouble();

	/**
	 * Returns the next random floating point.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the random floating point value.
	 * @since V0.6.0 Mar 8, 2008
	 * @version V0.6.0 Mar 8, 2008
	 */
	float nextFloat();

	/**
	 * Returns the next random integer.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the random integer value.
	 * @since V0.6.0 Mar 8, 2008
	 * @version V0.6.0 Mar 8, 2008
	 */
	int nextInt();

	/**
	 * Returns the next random integer between 0 (inclusive) and <code>number</code> (exclusive).
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param number
	 *            the limit value.
	 * @return the random integer value.
	 * @since V0.6.0 Mar 8, 2008
	 * @version V0.6.0 Mar 8, 2008
	 */
	int nextInt(int number);

	/**
	 * Returns the next random long value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the random long value.
	 * @since V0.6.0 Mar 8, 2008
	 * @version V0.6.0 Mar 8, 2008
	 */
	long nextLong();

	/**
	 * Sets the seed value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param seed
	 *            the seed value.
	 * @since V0.6.0 Mar 8, 2008
	 * @version V0.6.0 Mar 8, 2008
	 */
	void setSeed(long seed);
}
