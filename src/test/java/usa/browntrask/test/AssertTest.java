package usa.browntrask.test;

import org.junit.Before;
import org.junit.Test;

/**
 * Test for {@link Assert}.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.8.0 Oct 6, 2008
 * @version Nov 11, 2009
 */
public final class AssertTest {

	/**
	 * the message produced when comparing the greater value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	private static final String GREATER_MESSAGE = "Greater value should compare greater";

	/**
	 * the greater double value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.0.0 Nov 11, 2009
	 * @version Nov 11, 2009
	 */
	private double greaterDouble;

	/**
	 * the greater integer value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Nov 11, 2009
	 */
	private int greaterInteger;

	/**
	 * the lesser integer value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.0.0 Nov 11, 2009
	 * @version Nov 11, 2009
	 */
	private double lesserDouble;

	/**
	 * the lesser integer value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Nov 11, 2009
	 */
	private int lesserInteger;

	/**
	 * Sets up the values to be tested.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Nov 11, 2009
	 */
	@Before
	public final void setUpValues() {
		lesserInteger = Utility.nextInt();
		greaterInteger = Utility.nextInt();
		lesserDouble = Utility.nextDouble();
		greaterDouble = Utility.nextDouble();
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertGreaterThan(double, double)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.0.0 Nov 11, 2009
	 * @version Nov 11, 2009
	 */
	@Test
	public final void testAssertGreaterThanDoubleDouble() {
		Assert.assertGreaterThan(lesserDouble, greaterDouble);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertGreaterThan(double, double)} for
	 * the case where the values are equal.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.0.0 Nov 11, 2009
	 * @version Nov 11, 2009
	 */
	@Test(expected = AssertionError.class)
	public final void testAssertGreaterThanDoubleDouble_equals() {
		Assert.assertGreaterThan(lesserDouble, lesserDouble);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertGreaterThan(double, double)} for
	 * the case where the values are reversed.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.0.0 Nov 11, 2009
	 * @version Nov 11, 2009
	 */
	@Test(expected = AssertionError.class)
	public final void testAssertGreaterThanDoubleDouble_reversed() {
		Assert.assertGreaterThan(greaterDouble, lesserDouble);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertGreaterThan(int, int)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	@Test
	public final void testAssertGreaterThanIntInt() {
		Assert.assertGreaterThan(lesserInteger, greaterInteger);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertGreaterThan(int, int)} for the
	 * case where the values are equal.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	@Test(expected = AssertionError.class)
	public final void testAssertGreaterThanIntInt_equals() {
		Assert.assertGreaterThan(lesserInteger, lesserInteger);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertGreaterThan(int, int)} for the
	 * case where the values are reversed.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	@Test(expected = AssertionError.class)
	public final void testAssertGreaterThanIntInt_reversed() {
		Assert.assertGreaterThan(greaterInteger, lesserInteger);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertGreaterThan(java.lang.String, double, double)}
	 * .
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.0.0 Nov 11, 2009
	 * @version Nov 11, 2009
	 */
	@Test
	public final void testAssertGreaterThanStringDoubleDouble() {
		Assert.assertGreaterThan(GREATER_MESSAGE, lesserDouble, greaterDouble);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertGreaterThan(java.lang.String, double, double)}
	 * for the case where the values are equal.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.0.0 Nov 11, 2009
	 * @version Nov 11, 2009
	 */
	@Test(expected = AssertionError.class)
	public final void testAssertGreaterThanStringDoubleDouble_equals() {
		Assert.assertGreaterThan(GREATER_MESSAGE, lesserDouble, lesserDouble);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertGreaterThan(java.lang.String, double, double)}
	 * for the case where the values are reversed.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.0.0 Nov 11, 2009
	 * @version Nov 11, 2009
	 */
	@Test(expected = AssertionError.class)
	public final void testAssertGreaterThanStringDoubleDouble_reversed() {
		Assert.assertGreaterThan(GREATER_MESSAGE, greaterDouble, lesserDouble);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertGreaterThan(java.lang.String, int, int)}
	 * .
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	@Test
	public final void testAssertGreaterThanStringIntInt() {
		Assert
				.assertGreaterThan(GREATER_MESSAGE, lesserInteger,
						greaterInteger);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertGreaterThan(java.lang.String, int, int)}
	 * for the case where the values are equal.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	@Test(expected = AssertionError.class)
	public final void testAssertGreaterThanStringIntInt_equals() {
		Assert.assertGreaterThan(GREATER_MESSAGE, lesserInteger, lesserInteger);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertGreaterThan(java.lang.String, int, int)}
	 * for the case where the values are reversed.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	@Test(expected = AssertionError.class)
	public final void testAssertGreaterThanStringIntInt_reversed() {
		Assert
				.assertGreaterThan(GREATER_MESSAGE, greaterInteger,
						lesserInteger);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertLessThan(double, double)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.0.0 Nov 11, 2009
	 * @version Nov 11, 2009
	 */
	@Test
	public final void testAssertLessThanDoubleDouble() {
		Assert.assertLessThan(greaterDouble, lesserDouble);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertLessThan(double, double)} for the
	 * case where the values are equal.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.0.0 Nov 11, 2009
	 * @version Nov 11, 2009
	 */
	@Test(expected = AssertionError.class)
	public final void testAssertLessThanDoubleDouble_equals() {
		Assert.assertLessThan(greaterDouble, greaterDouble);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertLessThan(double, double)} for the
	 * case where the values are reversed.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.0.0 Nov 11, 2009
	 * @version Nov 11, 2009
	 */
	@Test(expected = AssertionError.class)
	public final void testAssertLessThanDoubleDouble_reversed() {
		Assert.assertLessThan(lesserDouble, greaterDouble);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertLessThan(int, int)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	@Test
	public final void testAssertLessThanIntInt() {
		Assert.assertLessThan(greaterInteger, lesserInteger);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertLessThan(int, int)} for the case
	 * where the values are equal.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	@Test(expected = AssertionError.class)
	public final void testAssertLessThanIntInt_equals() {
		Assert.assertLessThan(greaterInteger, greaterInteger);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertLessThan(int, int)} for the case
	 * where the values are reversed.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	@Test(expected = AssertionError.class)
	public final void testAssertLessThanIntInt_reversed() {
		Assert.assertLessThan(lesserInteger, greaterInteger);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertLessThan(java.lang.String, double, double)}
	 * .
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.0.0 Nov 11, 2009
	 * @version Nov 11, 2009
	 */
	@Test
	public final void testAssertLessThanStringDoubleDouble() {
		Assert.assertLessThan(GREATER_MESSAGE, greaterDouble, lesserDouble);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertLessThan(java.lang.String, double, double)}
	 * for the case where the values are equal.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.0.0 Nov 11, 2009
	 * @version Nov 11, 2009
	 */
	@Test(expected = AssertionError.class)
	public final void testAssertLessThanStringDoubleDouble_equals() {
		Assert.assertLessThan(GREATER_MESSAGE, greaterDouble, greaterDouble);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertLessThan(java.lang.String, double, double)}
	 * for the case where the values are reversed.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.0.0 Nov 11, 2009
	 * @version Nov 11, 2009
	 */
	@Test(expected = AssertionError.class)
	public final void testAssertLessThanStringDoubleDouble_reversed() {
		Assert.assertLessThan(GREATER_MESSAGE, lesserDouble, greaterDouble);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertLessThan(java.lang.String, int, int)}
	 * .
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	@Test
	public final void testAssertLessThanStringIntInt() {
		Assert.assertLessThan(GREATER_MESSAGE, greaterInteger, lesserInteger);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertLessThan(java.lang.String, int, int)}
	 * for the case where the values are equal.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	@Test(expected = AssertionError.class)
	public final void testAssertLessThanStringIntInt_equals() {
		Assert.assertLessThan(GREATER_MESSAGE, greaterInteger, greaterInteger);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertLessThan(java.lang.String, int, int)}
	 * for the case where the values are reversed.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	@Test(expected = AssertionError.class)
	public final void testAssertLessThanStringIntInt_reversed() {
		Assert.assertLessThan(GREATER_MESSAGE, lesserInteger, greaterInteger);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertNotEquals(double, double, double)}
	 * for two values that are equal within a delta.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.9.1 Jun 21, 2008
	 * @version Jun 21, 2008
	 */
	@Test(expected = AssertionError.class)
	public final void testAssertNotEqualsDoubleDoubleDouble_equalWithinDelta() {
		Assert.assertNotEquals(1.0, 1.01, 1.01 - 1);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertNotEquals(double, double, double)}
	 * for two values that are exactly equal.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.9.1 Jun 21, 2008
	 * @version Jun 21, 2008
	 */
	@Test(expected = AssertionError.class)
	public final void testAssertNotEqualsDoubleDoubleDouble_exactEqual() {
		Assert.assertNotEquals(1.0, 1.0, 0.);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertNotEquals(double, double, double)}
	 * for two values that are not equal within a delta.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.9.1 Jun 21, 2008
	 * @version Jun 21, 2008
	 */
	@Test
	public final void testAssertNotEqualsDoubleDoubleDouble_notEqualWithinDelta() {
		Assert.assertNotEquals(1.0, 1.011, 0.01);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertNotEquals(long, long)} for two
	 * values that are different.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.9.1 Jun 21, 2008
	 * @version Jun 21, 2008
	 */
	@Test
	public final void testAssertNotEqualsLongLong_different() {
		Assert.assertNotEquals(1L, 2L);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertNotEquals(long, long)} for two
	 * values that are the same.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.9.1 Jun 21, 2008
	 * @version Jun 21, 2008
	 */
	@Test(expected = AssertionError.class)
	public final void testAssertNotEqualsLongLong_same() {
		Assert.assertNotEquals(1L, 1L);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertNotEquals(java.lang.Object, java.lang.Object)}
	 * for different objects.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.9.1 Jun 21, 2008
	 * @version Jun 21, 2008
	 */
	@Test
	public final void testAssertNotEqualsObjectObject_differentObjects() {
		Assert.assertNotEquals(new Object(), new Object());
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertNotEquals(java.lang.Object, java.lang.Object)}
	 * for the same object.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.9.1 Jun 21, 2008
	 * @version Jun 21, 2008
	 */
	@Test(expected = AssertionError.class)
	public final void testAssertNotEqualsObjectObject_sameObject() {
		final Object object = new Object();

		Assert.assertNotEquals(object, object);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertNotEquals(String, double, double, double)}
	 * for two values that are equal within a delta.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.9.1 Jun 21, 2008
	 * @version Jun 21, 2008
	 */
	@Test(expected = AssertionError.class)
	public final void testAssertNotEqualsStringDoubleDoubleDouble_equalWithinDelta() {
		Assert.assertNotEquals("The values should be equal within a delta",
				-1.0, -1.01, Math.abs(-1.0 - (-1.01)));
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertNotEquals(String, double, double, double)}
	 * for two values that are exactly equal.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.9.1 Jun 21, 2008
	 * @version Jun 21, 2008
	 */
	@Test(expected = AssertionError.class)
	public final void testAssertNotEqualsStringDoubleDoubleDouble_exactEqual() {
		Assert.assertNotEquals("The values should be exactly equal", -1.0,
				-1.0, 0.);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertNotEquals(String, double, double, double)}
	 * for two values that are not equal within a delta.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.9.1 Jun 21, 2008
	 * @version Jun 21, 2008
	 */
	@Test
	public final void testAssertNotEqualsStringDoubleDoubleDouble_notEqualWithinDelta() {
		Assert.assertNotEquals("The values should not be equal within a delta",
				-1.0, -1.011, 0.01);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertNotEquals(java.lang.String, long, long)}
	 * for two values that are different.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.9.1 Jun 21, 2008
	 * @version Jun 21, 2008
	 */
	@Test
	public final void testAssertNotEqualsStringLongLong_different() {
		Assert.assertNotEquals("The values should be different", -1L, -2L);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertNotEquals(java.lang.String, long, long)}
	 * for two values that are the same.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.9.1 Jun 21, 2008
	 * @version Jun 21, 2008
	 */
	@Test(expected = AssertionError.class)
	public final void testAssertNotEqualsStringLongLong_same() {
		Assert.assertNotEquals("The values should the same", -1L, -1L);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertNotEquals(java.lang.String, java.lang.Object, java.lang.Object)}
	 * for non-equal objects.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.9.1 Jun 21, 2008
	 * @version Jun 21, 2008
	 */
	@Test
	public final void testAssertNotEqualsStringObjectObject_differentObjects() {
		Assert.assertNotEquals("Different Objects should not be equal",
				new Object(), new Object());
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertNotEquals(java.lang.String, java.lang.Object, java.lang.Object)}
	 * for a <code>null</code> versus a <code>null</code>.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.9.1 Jun 21, 2008
	 * @version August 27, 2008
	 */
	@Test(expected = AssertionError.class)
	public final void testAssertNotEqualsStringObjectObject_nullnull() {
		Assert.assertNotEquals("An object should not be equal to null", null,
				null);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertNotEquals(java.lang.String, java.lang.Object, java.lang.Object)}
	 * for a <code>null</code> versus an object.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.9.1 Jun 21, 2008
	 * @version Jun 21, 2008
	 */
	@Test
	public final void testAssertNotEqualsStringObjectObject_nullObject() {
		Assert.assertNotEquals("An object should not be equal to null", null,
				new Object());
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertNotEquals(java.lang.String, java.lang.Object, java.lang.Object)}
	 * for an object versus a <code>null</code>.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.9.1 Jun 21, 2008
	 * @version Jun 21, 2008
	 */
	@Test
	public final void testAssertNotEqualsStringObjectObject_objectNull() {
		Assert.assertNotEquals("A null should not be equal to an object",
				new Object(), null);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertNotEquals(java.lang.String, java.lang.Object, java.lang.Object)}
	 * for the same object.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.9.1 Jun 21, 2008
	 * @version Jun 21, 2008
	 */
	@Test(expected = AssertionError.class)
	public final void testAssertNotEqualsStringObjectObject_sameObject() {
		final Object object = new Object();

		Assert.assertNotEquals("The same object should be equal", object,
				object);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertNotEquals(java.lang.String, java.lang.Object, java.lang.Object)}
	 * for a string that equals another string.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.9.1 Jun 21, 2008
	 * @version Jun 21, 2008
	 */
	@Test(expected = AssertionError.class)
	public final void testAssertNotEqualsStringObjectObject_stringEquals() {
		Assert.assertNotEquals("A null should not be equal to an object",
				new String("a"), new String("a"));
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.Assert#assertNotEquals(java.lang.String, java.lang.Object, java.lang.Object)}
	 * for a string that does not equal another string.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.9.1 Jun 21, 2008
	 * @version Jun 21, 2008
	 */
	@Test
	public final void testAssertNotEqualsStringObjectObject_stringNotEquals() {
		Assert.assertNotEquals("A null should not be equal to an object", "a",
				"b");
	}
}
