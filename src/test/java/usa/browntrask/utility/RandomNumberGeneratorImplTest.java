package usa.browntrask.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import usa.browntrask.test.GenericTester;

/**
 * Test for {@link usa.browntrask.utility.RandomNumberGeneratorImpl}.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.6.0 Mar 8, 2008
 * @version V1.4.0 Mar 7, 2010
 */
public final class RandomNumberGeneratorImplTest {

	/**
	 * the expected integer value when getting an integer between 0 and a limit.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Mar 8, 2008
	 * @version Mar 8, 2008
	 */
	private static final int BETWEEN_INTEGER = 5;

	/**
	 * the expected double value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Mar 8, 2008
	 * @version Mar 8, 2008
	 */
	private static final double DOUBLE = 0.7308781907032909;

	/**
	 * the expected floating point value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Mar 8, 2008
	 * @version Mar 8, 2008
	 */
	private static final float FLOAT = (float) 0.7308781743049622;

	/**
	 * the expected integer value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Mar 8, 2008
	 * @version Mar 8, 2008
	 */
	private static final int INTEGER = -1155869325;

	/**
	 * the expected long value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Mar 8, 2008
	 * @version Mar 8, 2008
	 */
	private static final long LONG = -4964420948893066024L;

	/**
	 * the limit value for getting the next integer between 0 and a limit.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Mar 8, 2008
	 * @version Mar 8, 2008
	 */
	private static final int NUMBER = 10;

	/**
	 * the seed value to test.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Mar 8, 2008
	 * @version Mar 8, 2008
	 */
	private static final long SEED = 1L;

	/**
	 * the random number generator to test.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Mar 8, 2008
	 * @version Mar 8, 2008
	 */
	private RandomNumberGeneratorImpl random;

	/**
	 * Sets up the random number generator to test.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Mar 8, 2008
	 * @version Mar 8, 2008
	 */
	@Before
	public final void setUp() {
		random = new RandomNumberGeneratorImpl();
		random.setSeed(SEED);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.RandomNumberGeneratorImpl#compareTo(RandomNumberGenerator)} for the basic
	 * contract of compareTo.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.4.0 Mar 7, 2010
	 * @version V1.4.0 Mar 7, 2010
	 */
	@Test
	public final void testCompareTo_basicContract() {
		final RandomNumberGeneratorImpl one = new RandomNumberGeneratorImpl();
		final RandomNumberGeneratorImpl two = new RandomNumberGeneratorImpl();
		final RandomNumberGeneratorImpl before;
		final RandomNumberGeneratorImpl comparable;
		final RandomNumberGeneratorImpl after;
		if (one.hashCode() < two.hashCode()) {
			if (random.hashCode() < one.hashCode()) {
				before = random;
				comparable = one;
				after = two;
			} else if (random.hashCode() < two.hashCode()) {
				before = one;
				comparable = random;
				after = two;
			} else {
				before = one;
				comparable = two;
				after = random;
			}
		} else {
			if (one.hashCode() < random.hashCode()) {
				before = two;
				comparable = one;
				after = random;
			} else if (random.hashCode() < two.hashCode()) {
				before = random;
				comparable = two;
				after = one;
			} else {
				before = two;
				comparable = random;
				after = one;
			}
		}

		final boolean checkCompareTo = GenericTester.checkCompareTo(comparable, before, after);

		assertTrue("compareTo(...) should implement the basic contract", checkCompareTo);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.RandomNumberGeneratorImpl#nextBoolean()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Mar 8, 2008
	 * @version Mar 8, 2008
	 */
	@Test
	public final void testNextBoolean() {
		assertTrue("The next boolean value should be true", random.nextBoolean());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.RandomNumberGeneratorImpl#nextDouble()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Mar 8, 2008
	 * @version Mar 8, 2008
	 */
	@Test
	public final void testNextDouble() {
		assertEquals("Should get the next double value", DOUBLE, random.nextDouble(), 0.);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.RandomNumberGeneratorImpl#nextFloat()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Mar 8, 2008
	 * @version Mar 8, 2008
	 */
	@Test
	public final void testNextFloat() {
		assertEquals("Should get the next floating point value", FLOAT, random.nextFloat(), 0.);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.RandomNumberGeneratorImpl#nextInt()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Mar 8, 2008
	 * @version Mar 8, 2008
	 */
	@Test
	public final void testNextInt() {
		assertEquals("Should get the next integer value", INTEGER, random.nextInt());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.RandomNumberGeneratorImpl#nextInt(int)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Mar 8, 2008
	 * @version Mar 8, 2008
	 */
	@Test
	public final void testNextIntInt() {
		assertEquals("Should get the next integer value between 0 and " + NUMBER, BETWEEN_INTEGER, random.nextInt(NUMBER));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.RandomNumberGeneratorImpl#nextLong()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Mar 8, 2008
	 * @version Mar 8, 2008
	 */
	@Test
	public final void testNextLong() {
		assertEquals("Should get the next long value", LONG, random.nextLong());
	}
}
