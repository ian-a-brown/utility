package usa.browntrask.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.Test;

/**
 * Test for Dice.
 * <p>
 * 
 * @author IanBrown
 * @since V0.1.7 Aug 19, 2007
 * @version V2.2.0 Oct 24, 2014
 */
public final class DiceTest {

    /**
     * values for testing the parsing.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.7 Aug 19, 2007
     * @version Aug 19, 2007
     */
    private final static Object[][] PARSE_VALUES = new Object[][] {
	    new Object[] { "2d6", 2, 6, null },
	    new Object[] { "6D4", 6, 4, null },
	    new Object[] { "", 0, 0, new ParseException(null, 0) },
	    new Object[] { "0d0", 0, 0, new IllegalArgumentException() },
	    new Object[] { "1d0", 1, 0, new IllegalArgumentException() } };

    /**
     * expected rolls.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.7 Aug 19, 2007
     * @version Aug 19, 2007
     */
    private static final int[] TEST_ROLLS = new int[] { 9, 6, 8, 8, 10 };

    /**
     * the number of dice.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.7 Aug 19, 2007
     * @version Aug 19, 2007
     */
    private static final int NUMBER_OF_DICE = 2;

    /**
     * the number of sides.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.7 Aug 19, 2007
     * @version Aug 19, 2007
     */
    private static final int NUMBER_OF_SIDES = 6;

    /**
     * Test for constructor {@link usa.browntrask.utility.Dice#Dice(int, int)}.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.7 Aug 19, 2007
     * @version Aug 19, 2007
     */
    @Test
    public final void testDice_intInt() {
	final Dice dice = new Dice(NUMBER_OF_DICE, NUMBER_OF_SIDES);

	assertEquals("Number of dice set", NUMBER_OF_DICE, dice.getNumberDice());
	assertEquals("Number of sides set", NUMBER_OF_SIDES, dice
		.getNumberSides());
    }

    /**
     * Test method for
     * {@link usa.browntrask.utility.Dice#getInstance(java.lang.String)} for a
     * null.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @throws ParseException
     *                 if there is a problem parsing the dice.
     * @since V0.1.7 Aug 19, 2007
     * @version Sep 25, 2007
     */
    @Test(expected = NullPointerException.class)
    public final void testGetInstance_null() throws ParseException {
	Dice.getInstance(null);
    }

    /**
     * Test method for
     * {@link usa.browntrask.utility.Dice#getInstance(java.lang.String)}.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.7 Aug 19, 2007
     * @version Sep 25, 2007
     * @throws ParseException
     *                 if there is a problem parsing the dice.
     */
    @Test
    public final void testGetInstance() throws ParseException {
	Dice dice = Dice.getInstance("2d6");

	assertNotNull("Got dice object", dice);
	assertEquals("Got expected number of dice", 2, dice.getNumberDice());
	assertEquals("Got expected number of sides", 6, dice.getNumberSides());
    }

    /**
     * Test method for
     * {@link usa.browntrask.utility.Dice#parse(java.lang.String)}.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.7 Aug 19, 2007
     * @version Aug 23, 2007
     */
    @Test
    public final void testParse() {
	final Dice dice = new Dice();
	for (final Object[] values : PARSE_VALUES) {
	    try {
		dice.parse((String) values[0]);
		assertEquals("Number of dice set", values[1], Integer
			.valueOf(dice.getNumberDice()));
		assertEquals("Number of sides set", values[2], Integer
			.valueOf(dice.getNumberSides()));

	    } catch (IllegalArgumentException e) {
		final String traceback = new ThrowableHelper()
			.buildTraceback(e);
		assertEquals(traceback, IllegalArgumentException.class,
			values[3].getClass());
	    } catch (ParseException e) {
		final String traceback = new ThrowableHelper()
			.buildTraceback(e);
		assertEquals(traceback, ParseException.class, values[3]
			.getClass());
	    }
	}
    }

    /**
     * Test method for {@link usa.browntrask.utility.Dice#roll()} without a
     * number generator.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.7 Aug 19, 2007
     * @version Aug 19, 2007
     * @throws ParseException
     *                 if there is a problem parsing the expression.
     */
    @Test
    public final void testRoll_noRandom() throws ParseException {
	final Dice dice = Dice.getInstance("2d6");

	final int roll = dice.roll();

	assertTrue("Dice rolled", (2 <= roll) && (12 >= roll));
    }

    /**
     * Test method for {@link usa.browntrask.utility.Dice#roll()}.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.7 Aug 19, 2007
     * @version Mar 8, 2008
     * @throws ParseException
     *                 if there is a problem parsing the expression.
     */
    @Test
    public final void testRoll() throws ParseException {
	final RandomNumberGenerator random = new RandomNumberGeneratorImpl(1L);
	final Dice dice = Dice.getInstance("2d6");
	dice.setRandom(random);

	for (int value : TEST_ROLLS) {
	    assertEquals("Roll", value, dice.roll());
	}
    }

    /**
     * Test for method {@link java.lang.Object#toString()}.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @throws ParseException
     *                 if there is a problem parsing the string.
     * @since V0.1.7 Aug 19, 2007
     * @version Sep 25, 2007
     */
    @Test
    public final void testToString() throws ParseException {
	final Dice dice = Dice.getInstance("2d6");

	final String string = dice.toString();

	assertTrue("String contains dice generator", string.endsWith("2d6"));
    }
}
