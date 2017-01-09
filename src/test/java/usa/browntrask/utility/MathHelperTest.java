package usa.browntrask.utility;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import usa.browntrask.utility.ValueGenerator.MathHelper;

/**
 * Test for {@link ValueGenerator.MathHelper}.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.6.0 Jun 10, 2008
 * @version Jun 10, 2008
 */
public final class MathHelperTest {

	/**
	 * the low integer value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Jun 10, 2008
	 * @version Jun 10, 2008
	 */
	private static final int LOW_INT = 1;

	/**
	 * the high integer value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Jun 10, 2008
	 * @version Jun 10, 2008
	 */
	private static final int HIGH_INT = 10;

	/**
	 * the low double value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Jun 10, 2008
	 * @version Jun 10, 2008
	 */
	private static final double LOW_DOUBLE = 0.01;

	/**
	 * the high double value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Jun 10, 2008
	 * @version Jun 10, 2008
	 */
	private static final double HIGH_DOUBLE = 0.1;

	/**
	 * the {@link MathHelper} to be tested.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Jun 10, 2008
	 * @version Jun 10, 2008
	 */
	private MathHelper mathHelper;

	/**
	 * Sets up the {@link MathHelper} to be tested.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Jun 10, 2008
	 * @version Jun 10, 2008
	 */
	@Before
	public final void setUpHelper() {
		mathHelper = new MathHelper();
	}

	/**
	 * Test method for {@link usa.browntrask.utility.ValueGenerator.MathHelper#min(int, int)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Jun 10, 2008
	 * @version Jun 10, 2008
	 */
	@Test
	public final void testMinIntInt() {
		assertEquals("Should have chosen the low value", LOW_INT, mathHelper.min(LOW_INT, HIGH_INT));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.ValueGenerator.MathHelper#min(double, double)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Jun 10, 2008
	 * @version Jun 10, 2008
	 */
	@Test
	public final void testMinDoubleDouble() {
		assertEquals("Should have chosen the low value", LOW_DOUBLE, mathHelper.min(LOW_DOUBLE, HIGH_DOUBLE), 0.);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.ValueGenerator.MathHelper#max(int, int)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Jun 10, 2008
	 * @version Jun 10, 2008
	 */
	@Test
	public final void testMaxIntInt() {
		assertEquals("Should have chosen the high value", HIGH_INT, mathHelper.max(LOW_INT, HIGH_INT));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.ValueGenerator.MathHelper#max(double, double)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Jun 10, 2008
	 * @version Jun 10, 2008
	 */
	@Test
	public final void testMaxDoubleDouble() {
		assertEquals("Should have chosen the high value", HIGH_DOUBLE, mathHelper.max(LOW_DOUBLE, HIGH_DOUBLE), 0.);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.ValueGenerator.MathHelper#floor(double)} for a positive value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Jun 10, 2008
	 * @version Jun 10, 2008
	 */
	@Test
	public final void testFloor_positive() {
		assertEquals("Should have chosen zero", 0, mathHelper.floor(LOW_DOUBLE));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.ValueGenerator.MathHelper#floor(double)} for a negative value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Jun 10, 2008
	 * @version Jun 10, 2008
	 */
	@Test
	public final void testFloor_negative() {
		assertEquals("Should have chosen negative one", -1, mathHelper.floor(-LOW_DOUBLE));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.ValueGenerator.MathHelper#ceil(double)} for a positive value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Jun 10, 2008
	 * @version Jun 10, 2008
	 */
	@Test
	public final void testCeil_positive() {
		assertEquals("Should have chosen one", 1, mathHelper.ceil(LOW_DOUBLE));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.ValueGenerator.MathHelper#ceil(double)} for a negative value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.6.0 Jun 10, 2008
	 * @version Jun 10, 2008
	 */
	@Test
	public final void testCeil_negative() {
		assertEquals("Should have chosen zero", 0, mathHelper.ceil(-LOW_DOUBLE));
	}

}
