package usa.browntrask.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static usa.browntrask.test.Assert.assertNotEquals;

import org.junit.Test;

/**
 * Test for {@link Utility}.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.7.2 Sep 22, 2008
 * @version Sep 30, 2008
 */
public final class UtilityTest {

	/**
	 * An enumeration for testing.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.9.2 Nov 15, 2008
	 * @version Nov 15, 2008
	 */
	private enum TestEnum {

		/**
		 * the first value of the enumeration.
		 * <p>
		 * 
		 * @author Ian Andrew Brown
		 * @since V0.9.2 Nov 15, 2008
		 * @version Nov 15, 2008
		 */
		A_FIRST,

		/**
		 * the first value of the enumeration.
		 * <p>
		 * 
		 * @author Ian Andrew Brown
		 * @since V0.9.2 Nov 15, 2008
		 * @version Nov 15, 2008
		 */
		B_SECOND,

		/**
		 * the first value of the enumeration.
		 * <p>
		 * 
		 * @author Ian Andrew Brown
		 * @since V0.9.2 Nov 15, 2008
		 * @version Nov 15, 2008
		 */
		C_THIRD,

		/**
		 * the first value of the enumeration.
		 * <p>
		 * 
		 * @author Ian Andrew Brown
		 * @since V0.9.2 Nov 15, 2008
		 * @version Nov 15, 2008
		 */
		D_FOURTH;
	}

	/**
	 * the prefix used for the formatted string.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.7.2 Sep 30, 2008
	 * @version Sep 30, 2008
	 */
	private static final String PREFIX = "prefix";

	/**
	 * the suffix used for the formatted string.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.7.2 Sep 30, 2008
	 * @version Sep 30, 2008
	 */
	private static final String SUFFIX = "suffix";

	/**
	 * Test method for {@link usa.browntrask.test.Utility#nextBoolean()} for consecutive return values.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.7.2 Sep 22, 2008
	 * @version Sep 25, 2008
	 */
	@Test
	public final void testNextBoolean_consecutive() {
		final boolean firstValue = Utility.nextBoolean();
		final boolean secondValue = Utility.nextBoolean();

		assertNotEquals("Consecutive values should not be equal", firstValue, secondValue);
	}

	/**
	 * Test method for {@link usa.browntrask.test.Utility#nextBoolean()} for every other return value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.7.2 Sep 22, 2008
	 * @version Sep 25, 2008
	 */
	@Test
	public final void testNextBoolean_everyOther() {
		final boolean firstValue = Utility.nextBoolean();
		Utility.nextBoolean();
		final boolean thirdValue = Utility.nextBoolean();

		assertEquals("Every other value should be equal", firstValue, thirdValue);
	}

	/**
	 * Test method for {@link usa.browntrask.test.Utility#nextDouble()} for the case where consecutive calls are made.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.7.2 Sep 22, 2008
	 * @version Sep 30, 2008
	 */
	@Test
	public final void testNextDouble_consecutive() {
		final double firstDouble = Utility.nextDouble();
		final double secondDouble = Utility.nextDouble();

		assertNotEquals("Consecutive double values should not be equal", firstDouble, secondDouble, Utility.DOUBLE_DELTA / 2.0);
	}

	/**
	 * Test method for {@link Utility#nextEnum(Class)} for the case where consecutive calls are made.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.9.2 Nov 15, 2008
	 * @version Nov 15, 2008
	 */
	@Test
	public final void testNextEnum_consecutive() {
		Utility.reset();

		final TestEnum firstEnum = Utility.nextEnum(TestEnum.class);
		final TestEnum secondEnum = Utility.nextEnum(TestEnum.class);

		assertNotEquals("The first two values should be different", firstEnum, secondEnum);
	}

	/**
	 * Test method for {@link usa.browntrask.test.Utility#nextFloat()} for the case where consecutive calls are made.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.7.2 Sep 22, 2008
	 * @version Sep 30, 2008
	 */
	@Test
	public final void testNextFloat_consecutive() {
		final float firstFloat = Utility.nextFloat();
		final float secondFloat = Utility.nextFloat();

		assertNotEquals("Consecutive float values should not be equal", firstFloat, secondFloat, Utility.FLOAT_DELTA / 2.0F);
	}

	/**
	 * Test method for {@link usa.browntrask.test.Utility#nextFormattedString(java.lang.String, java.lang.String)} for the case
	 * where consecutive calls are made.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.7.2 Sep 22, 2008
	 * @version Sep 30, 2008
	 */
	@Test
	public final void testNextFormattedString_consecutive() {
		final String firstString = Utility.nextFormattedString(PREFIX, SUFFIX);
		final String secondString = Utility.nextFormattedString(PREFIX, SUFFIX);

		assertNotEquals("Consecutive string values should not be equal", firstString, secondString);
	}

	/**
	 * Test method for {@link usa.browntrask.test.Utility#nextFormattedString(java.lang.String, java.lang.String)} to check the
	 * prefix.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.7.2 Sep 22, 2008
	 * @version Sep 30, 2008
	 */
	@Test
	public final void testNextFormattedString_prefix() {
		final String firstString = Utility.nextFormattedString(PREFIX, SUFFIX);

		assertTrue("The string (" + firstString + ") should start with the prefix (" + PREFIX + ")", firstString.startsWith(PREFIX));
	}

	/**
	 * Test method for {@link usa.browntrask.test.Utility#nextFormattedString(java.lang.String, java.lang.String)} to check the
	 * suffix.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.7.2 Sep 22, 2008
	 * @version Sep 30, 2008
	 */
	@Test
	public final void testNextFormattedString_suffix() {
		final String firstString = Utility.nextFormattedString(PREFIX, SUFFIX);

		assertTrue("The string (" + firstString + ") should end with the suffix (" + SUFFIX + ")", firstString.endsWith(SUFFIX));
	}

	/**
	 * Test method for {@link usa.browntrask.test.Utility#nextInt()} for the case where consecutive calls are made.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.7.2 Sep 22, 2008
	 * @version Sep 25, 2008
	 */
	@Test
	public final void testNextInt_consecutive() {
		final int firstInt = Utility.nextInt();
		final int secondInt = Utility.nextInt();

		assertNotEquals("Consecutive integers should not be equal", firstInt, secondInt);
	}

	/**
	 * Test method for {@link usa.browntrask.test.Utility#nextLong()} for the case where consecutive calls are made.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.7.2 Sep 22, 2008
	 * @version Sep 25, 2008
	 */
	@Test
	public final void testNextLong_consecutive() {
		final long firstLong = Utility.nextLong();
		final long secondLong = Utility.nextLong();

		assertNotEquals("Consecutive long values should not be equal", firstLong, secondLong);
	}

	/**
	 * Test method for {@link usa.browntrask.test.Utility#nextShort()} for the case where consecutive calls are made.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.7.2 Sep 22, 2008
	 * @version Sep 25, 2008
	 */
	@Test
	public final void testNextShort_consecutive() {
		final int firstShort = Utility.nextShort();
		final int secondShort = Utility.nextShort();

		assertNotEquals("Consecutive shorts should not be equal", firstShort, secondShort);
	}

	/**
	 * Test method for {@link usa.browntrask.test.Utility#nextString()} for the case where consecutive calls are made.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.7.2 Sep 22, 2008
	 * @version Sep 30, 2008
	 */
	@Test
	public final void testNextString_consecutive() {
		final String firstString = Utility.nextString();
		final String secondString = Utility.nextString();

		assertNotEquals("Consecutive string values should not be equal", firstString, secondString);
	}

	/**
	 * Test method for {@link Utility#reset()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.9.2 Nov 15, 2008
	 * @version Nov 15, 2008
	 */
	@Test
	public final void testReset() {
		Utility.reset();
		final long initialValue = Utility.nextLong();
		final long nextValue = Utility.nextLong();
		assertNotEquals("The second value should not be equal to the first", initialValue, nextValue);

		Utility.reset();
		final long resetValue = Utility.nextLong();
		assertEquals("After reset, the first value should be equal to the first", initialValue, resetValue);
		final long resetNextValue = Utility.nextLong();
		assertEquals("After reset, the next value should be equal to the second", nextValue, resetNextValue);
	}

}
