package usa.browntrask.utility;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import usa.browntrask.test.Utility;

/**
 * Test for {@link AdditionalMath}.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.8.0 Oct 6, 2008
 * @version Oct 6, 2008
 */
public final class AdditionalMathTest {

	/**
	 * Test method for {@link usa.browntrask.utility.AdditionalMath#sign(int)} for a negative value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	@Test
	public final void testSign_negative() {
		final int value = -Utility.nextInt();

		final int signValue = AdditionalMath.sign(value);

		assertEquals("Sign of " + value, -1, signValue);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AdditionalMath#sign(int)} for a value of zero.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	@Test
	public final void testSign_zero() {

		final int signZero = AdditionalMath.sign(0);

		assertEquals("Sign of 0", 0, signZero);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AdditionalMath#sign(int)} for a positive value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	@Test
	public final void testSign_positive() {
		final int value = Utility.nextInt();

		final int signValue = AdditionalMath.sign(value);

		assertEquals("Sign of " + value, 1, signValue);
	}

}
