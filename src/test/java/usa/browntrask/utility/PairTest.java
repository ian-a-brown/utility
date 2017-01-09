package usa.browntrask.utility;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test for the Pair class.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.6 Aug 1, 2007
 * @version V2.2.0 Oct 24, 2014
 */
public final class PairTest {

	/**
	 * a value that is not a pair.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 1, 2007
	 * @version Aug 1, 2007
	 */
	private static final Integer NOT_A_PAIR = Integer.valueOf(10);

	/**
	 * the first value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 1, 2007
	 * @version Aug 1, 2007
	 */
	private static final Integer ONE = Integer.valueOf(1);

	/**
	 * the second value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 1, 2007
	 * @version Aug 1, 2007
	 */
	private static final Integer TWO = Integer.valueOf(2);

	/**
	 * Test method for {@link usa.browntrask.utility.Pair#hashCode()} for a pair
	 * of nulls.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 1, 2007
	 * @version Aug 1, 2007
	 */
	@Test
	public final void testHashCode_nulls() {
		final Pair<Integer, Integer> pair = new Pair<Integer, Integer>(null,
				null);

		assertTrue("Hash code set", pair.hashCode() != 0);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Pair#hashCode()} for a
	 * value and a null.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 1, 2007
	 * @version Aug 1, 2007
	 */
	@Test
	public final void testHashCode_valueAndNull() {
		final Pair<Integer, Integer> pair = new Pair<Integer, Integer>(ONE,
				null);

		assertTrue("Hash code set", pair.hashCode() != 0);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Pair#hashCode()} for a null
	 * and a value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 1, 2007
	 * @version Aug 1, 2007
	 */
	@Test
	public final void testHashCode_nullAndValue() {
		final Pair<Integer, Integer> pair = new Pair<Integer, Integer>(null,
				TWO);

		assertTrue("Hash code set", pair.hashCode() != 0);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Pair#hashCode()} for a
	 * couple of values.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 1, 2007
	 * @version Aug 1, 2007
	 */
	@Test
	public final void testHashCode_values() {
		final Pair<Integer, Integer> pair = new Pair<Integer, Integer>(ONE, TWO);

		assertTrue("Hash code set", pair.hashCode() != 0);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.utility.Pair#equals(java.lang.Object)} to a null
	 * object.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 1, 2007
	 * @version Aug 1, 2007
	 */
	@Test
	public final void testEqualsObject_null() {
		final Pair<Integer, Integer> pair = new Pair<Integer, Integer>(ONE, TWO);

		assertFalse("Pair is not equal to null", pair.equals(null));
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.utility.Pair#equals(java.lang.Object)} to a
	 * different type of object.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 1, 2007
	 * @version Aug 1, 2007
	 */
	@Test
	public final void testEqualsObject_nonPair() {
		final Pair<Integer, Integer> pair = new Pair<Integer, Integer>(ONE, TWO);

		assertFalse("Pair is not equal to a non-pair", pair.equals(NOT_A_PAIR));
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.utility.Pair#equals(java.lang.Object)} to itself.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 1, 2007
	 * @version Aug 1, 2007
	 */
	@Test
	public final void testEqualsObject_itself() {
		final Pair<Integer, Integer> pair = new Pair<Integer, Integer>(ONE, TWO);

		assertTrue("Pair is equal to itself", pair.equals(pair));
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.utility.Pair#equals(java.lang.Object)} to an
	 * equivalent pair.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 1, 2007
	 * @version Aug 1, 2007
	 */
	@Test
	public final void testEqualsObject_equivalent() {
		final Pair<Integer, Integer> pair = new Pair<Integer, Integer>(ONE, TWO);
		final Pair<Integer, Integer> equivalent = new Pair<Integer, Integer>(
				ONE, TWO);

		assertTrue("Pair is equal to an equivalent pair", pair
				.equals(equivalent));
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.utility.Pair#equals(java.lang.Object)} to a
	 * different pair.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 1, 2007
	 * @version Aug 1, 2007
	 */
	@Test
	public final void testEqualsObject_different() {
		final Pair<Integer, Integer> pair = new Pair<Integer, Integer>(ONE, TWO);
		final Pair<Integer, Integer> different = new Pair<Integer, Integer>(
				TWO, ONE);

		assertFalse("Pair is not equal to an different pair", pair
				.equals(different));
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.utility.Pair#equals(java.lang.Object)} to a pair
	 * with a null key.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 1, 2007
	 * @version Aug 19, 2007
	 */
	@Test
	public final void testEqualsObject_goodPairNullKey() {
		final Pair<Integer, Integer> pair = new Pair<Integer, Integer>(ONE, TWO);
		final Pair<Integer, Integer> different = new Pair<Integer, Integer>(
				null, TWO);

		assertFalse("Pair is not equal to a pair with a null key", pair
				.equals(different));
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.utility.Pair#equals(java.lang.Object)} to a pair
	 * with a null value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 1, 2007
	 * @version Aug 19, 2007
	 */
	@Test
	public final void testEqualsObject_goodPairNullValue() {
		final Pair<Integer, Integer> pair = new Pair<Integer, Integer>(ONE, TWO);
		final Pair<Integer, Integer> different = new Pair<Integer, Integer>(
				ONE, null);

		assertFalse("Pair is not equal to a pair with a null key", pair
				.equals(different));
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.utility.Pair#equals(java.lang.Object)} with a null
	 * key to another with a null key.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 1, 2007
	 * @version Aug 1, 2007
	 */
	@Test
	public final void testEqualsObject_nullKeys() {
		final Pair<Integer, Integer> pair = new Pair<Integer, Integer>(null,
				TWO);
		final Pair<Integer, Integer> another = new Pair<Integer, Integer>(null,
				TWO);

		assertTrue("Null key is equal to null key", pair.equals(another));
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.utility.Pair#equals(java.lang.Object)} with a null
	 * key to another pair that does not have a null key.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 1, 2007
	 * @version Aug 1, 2007
	 */
	@Test
	public final void testEqualsObject_nullKeyGoodPair() {
		final Pair<Integer, Integer> pair = new Pair<Integer, Integer>(null,
				TWO);
		final Pair<Integer, Integer> another = new Pair<Integer, Integer>(ONE,
				TWO);

		assertFalse("Null key is not equal to non-null key", pair
				.equals(another));
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.utility.Pair#equals(java.lang.Object)} with a null
	 * value to another pair that does not have a null value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 1, 2007
	 * @version Aug 1, 2007
	 */
	@Test
	public final void testEqualsObject_nullValueGoodPair() {
		final Pair<Integer, Integer> pair = new Pair<Integer, Integer>(ONE,
				null);
		final Pair<Integer, Integer> another = new Pair<Integer, Integer>(ONE,
				TWO);

		assertFalse("Null value is not equal to non-null value", pair
				.equals(another));
	}

	/**
	 * Test for method {@link java.lang.Object#toString()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version Aug 19, 2007
	 */
	@Test
	public final void testToString() {
		final Pair<Integer, Integer> pair = new Pair<Integer, Integer>(ONE, TWO);

		final String string = pair.toString();

		assertTrue("String contains key", string.contains(ONE.toString()));
		assertTrue("String contains value", string.contains(TWO.toString()));
	}
}
