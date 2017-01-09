package usa.browntrask.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * Test for Comparator.
 * <p>
 *
 * @author IanBrown
 *         <p>
 * @author Ian Andrew Brown
 * @since V0.1.7 Aug 18, 2007
 * @version V2.2.0 Nov 21, 2015
 */
public final class ComparatorTest {

	/**
	 * An object to used to check matches.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 */
	public final class CheckObject {

		/**
		 * an int value.
		 * <p>
		 *
		 * @author Ian Andrew Brown
		 * @since V0.1.7 Aug 19, 2007
		 * @version Aug 19, 2007
		 */
		private int c;

		/**
		 * Gets the value of the c field.
		 * <p>
		 *
		 * @author Ian Andrew Brown
		 * @return the value.
		 * @since V0.1.7 Aug 19, 2007
		 * @version V2.2.0 Oct 18, 2014
		 */
		public final int getC() {
			return c;
		}

		/**
		 * Sets the value of the c field.
		 * <p>
		 *
		 * @author Ian Andrew Brown
		 * @param c
		 *            the value.
		 * @since V0.1.7 Aug 19, 2007
		 * @version V2.2.0 Oct 18, 2014
		 */
		public final void setC(final int c) {
			this.c = c;
		}

		/** {@inheritDoc} */
		@Override
		// /CLOVER:OFF
		public final String toString() {
			return getClass().getSimpleName() + "(c=" + getC() + ")";
		}
		// /CLOVER:ON
	}

	/**
	 * An object used to check matches that throws an exception in the getter.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Nov 21, 2015
	 */
	public final class ExceptionObject {

		/**
		 * A field on the object.
		 * <p>
		 * 
		 * @author Ian Andrew Brown
		 * @since V2.2.0 Nov 21, 2015
		 * @version V2.2.0 Nov 21, 2015
		 */
		public int c;

		/**
		 * Gets the value of the c field.
		 * <p>
		 *
		 * @author Ian Andrew Brown
		 * @return always throws an exception.
		 * @throws IllegalAccessException
		 *             the exception thrown.
		 * @since V0.1.7 Aug 19, 2007
		 * @version V2.2.0 Oct 18, 2014
		 */
		public final int getC() throws IllegalAccessException {
			throw new IllegalAccessException("Not supported");
		}

		/**
		 * Sets the value of the c field.
		 * <p>
		 * 
		 * @author Ian Andrew Brown
		 * @param c
		 *            the c field.
		 * @throws IllegalAccessException
		 *             the exception thrown.
		 * @since V2.2.0 Oct 18, 2014
		 * @version V2.2.0 Nov 21, 2015
		 */
		public final void setC(@SuppressWarnings("unused") final int c) throws IllegalAccessException {
			throw new IllegalAccessException("Not supported");
		}
	}

	/**
	 * the value for testing.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 */
	private static final Integer BASIC_VALUE = 5;

	/**
	 * entries containing an AND for testing.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	private final static int[] ENTRIES_AND = new int[] { 2 };

	/**
	 * entries containing an AND and an OR for testing.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	private final static int[] ENTRIES_AND_OR = new int[] { 2, 1 };

	/**
	 * entries containing an OR for testing.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	private final static int[] ENTRIES_OR = new int[] { 1, 1 };

	/**
	 * entries containing a quoted string.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 26, 2007
	 * @version Aug 26, 2007
	 */
	private static final int[] ENTRIES_QUOTE = { 1 };

	/**
	 * simple entries for testing.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	private final static int[] ENTRIES_SIMPLE = new int[] { 1 };

	/**
	 * the name of the attribute.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version Aug 19, 2007
	 */
	private static final String NAME = "a";

	/**
	 * another name.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.8 Aug 23, 2007
	 * @version Aug 23, 2007
	 */
	private static final String OTHER_NAME = "b";

	/**
	 * another value for testing.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.8 Aug 23, 2007
	 * @version Aug 23, 2007
	 */
	private static final Integer OTHER_VALUE = 10;

	/**
	 * requirements containing an AND for testing.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 23, 2007
	 */
	private final static String REQUIREMENTS_AND = NAME + ".c>0 AND " + OTHER_NAME + ".c<10";

	/**
	 * requirements containing an AND and an OR for testing.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 23, 2007
	 */
	private final static String REQUIREMENTS_AND_OR = NAME + ".c>5 AND " + OTHER_NAME + ".c<10 OR " + NAME + ".c==5";

	/**
	 * requirements containing an OR for testing.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 23, 2007
	 */
	private final static String REQUIREMENTS_OR = NAME + ".c==" + BASIC_VALUE + " OR " + NAME + ".c==" + OTHER_VALUE;

	/**
	 * requirements containing a quoted string.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.11 Aug 26, 2007
	 * @version Aug 26, 2007
	 */
	private static final String REQUIREMENTS_QUOTE = "character.getName()==\\\"character\\\"";

	/**
	 * simple requirements for testing.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 23, 2007
	 */
	private final static String REQUIREMENTS_SIMPLE = NAME + ".c==5";

	/**
	 * complicated string for testing.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version Aug 23, 2007
	 */
	private final static String STRING_COMPLICATED = NAME + ".c==" + BASIC_VALUE + " || " + NAME + ".c==" + OTHER_VALUE + " && "
			+ OTHER_NAME + ".c<" + OTHER_VALUE;

	/**
	 * constant string for testing.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version Aug 19, 2007
	 */
	private static final String STRING_CONSTANT = "5";

	/**
	 * simple string for testing.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 19, 2007
	 */
	private final static String STRING_SIMPLE = NAME + ".c==" + BASIC_VALUE;

	/**
	 * the wrong value for testing.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.8 Aug 23, 2007
	 * @version Aug 23, 2007
	 */
	private static final Integer WRONG_VALUE = 0;

	/**
	 * Test method for {@link usa.browntrask.utility.Comparator#compareTo(usa.browntrask.utility.Comparator)} with itself.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version V2.2.0 Oct 18, 2014
	 */
	@Test
	public final void testCompareTo_itself() {
		final Comparator comparator = new Comparator();

		assertEquals("Comparator compares to itself", 0, comparator.compareTo(comparator));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Comparator#compareTo(usa.browntrask.utility.Comparator)} with a null.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version V2.2.0 Oct 18, 2014
	 */
	@Test
	public final void testCompareTo_null() {
		assertEquals("Comparator greater than null", 1, new Comparator().compareTo(null));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Comparator#compareTo(usa.browntrask.utility.Comparator)} with another that is
	 * alike (string).
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws ExpressionException
	 *             if there is a problem with an expression.
	 */
	@Test
	public final void testCompareTo_stringAlike() throws ExpressionException {
		final Comparator comparator = new Comparator(STRING_SIMPLE);
		final Comparator alike = new Comparator(STRING_SIMPLE);

		assertEquals(STRING_SIMPLE + " compares to " + STRING_SIMPLE, 0, comparator.compareTo(alike));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Comparator#compareTo(usa.browntrask.utility.Comparator)} that has a string
	 * requirement to one that doesn't.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws ExpressionException
	 *             if there is a problem with an expression.
	 */
	@Test
	public final void testCompareTo_stringUninitialized() throws ExpressionException {
		final Comparator comparator = new Comparator(STRING_SIMPLE);
		final Comparator uninitialized = new Comparator();

		assertEquals(STRING_SIMPLE + " compares to uninitialized", 1, comparator.compareTo(uninitialized));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Comparator#compareTo(usa.browntrask.utility.Comparator)} with another that is
	 * alike (uninitialized).
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version V2.2.0 Oct 18, 2014
	 */
	@Test
	public final void testCompareTo_uninitializedAlike() {
		final Comparator comparator = new Comparator();
		final Comparator alike = new Comparator();

		assertEquals("Comparator compares to uninitialized alike", 0, comparator.compareTo(alike));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Comparator#compareTo(usa.browntrask.utility.Comparator)} uninialized to one
	 * that has a string requirement.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws ExpressionException
	 *             if there is a problem with an expression.
	 */
	@Test
	public final void testCompareTo_uninitializedString() throws ExpressionException {
		final Comparator comparator = new Comparator(STRING_SIMPLE);
		final Comparator uninitialized = new Comparator();

		assertEquals("Uninitialized Comparator compares to " + STRING_SIMPLE, -1, uninitialized.compareTo(comparator));
	}

	/**
	 * Test for method {@link java.lang.Object#equals(Object)} comparated to another (string).
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws ExpressionException
	 *             if there is a problem with an expression.
	 */
	@Test
	public final void testEquals_anotherString() throws ExpressionException {
		assertTrue(STRING_SIMPLE + " is equal to another", new Comparator(STRING_SIMPLE).equals(new Comparator(STRING_SIMPLE)));
	}

	/**
	 * Test for method {@link java.lang.Object#equals(Object)} comparated to another (uninitialized).
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 */
	@Test
	public final void testEquals_anotherUnitialized() {
		assertTrue("Uninitialized comparator is equal to another", new Comparator().equals(new Comparator()));
	}

	/**
	 * Test for method {@link java.lang.Object#equals(Object)} (string) comparated to another (different string).
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws ExpressionException
	 *             if there is a problem with an expression.
	 */
	@Test
	public final void testEquals_differentString() throws ExpressionException {
		assertFalse(STRING_SIMPLE + " is not equal to " + STRING_COMPLICATED,
				new Comparator(STRING_SIMPLE).equals(new Comparator(STRING_COMPLICATED)));
	}

	/**
	 * Test for method {@link java.lang.Object#equals(Object)} comparated to itself (string).
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws ExpressionException
	 *             if there is a problem with the expression.
	 */
	@Test
	public final void testEquals_itselfString() throws ExpressionException {
		final Comparator comparator = new Comparator(STRING_SIMPLE);

		assertTrue(STRING_SIMPLE + " is equal to itself", comparator.equals(comparator));
	}

	/**
	 * Test for method {@link java.lang.Object#equals(Object)} comparated to itself (uninitialized).
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 */
	@Test
	public final void testEquals_itselfUnitialized() {
		final Comparator comparator = new Comparator();

		assertTrue("Uninitialilzed comparator is equal to itself", comparator.equals(comparator));
	}

	/**
	 * Test for method {@link java.lang.Object#equals(Object)} comparated to null.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 */
	@Test
	public final void testEquals_null() {
		assertFalse("Comparator is not equal to null", new Comparator().equals(null));
	}

	/**
	 * Test for method {@link java.lang.Object#equals(Object)} (string) comparated to another (unitialized).
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws ExpressionException
	 *             if there is a problem with an expression.
	 */
	@Test
	public final void testEquals_stringUnitialized() throws ExpressionException {
		assertFalse(STRING_SIMPLE + " is not equal to uninitialized", new Comparator(STRING_SIMPLE).equals(new Comparator()));
	}

	/**
	 * Test for method {@link java.lang.Object#equals(Object)} uninitialized comparated to another with a string.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws ExpressionException
	 *             if there is a problem with an expression.
	 */
	@Test
	public final void testEquals_uninitializedString() throws ExpressionException {
		assertFalse("Uninitialized Comparator is not equal to " + STRING_SIMPLE,
				new Comparator().equals(new Comparator(STRING_SIMPLE)));
	}

	/**
	 * Test for method {@link usa.browntrask.utility.Comparator#getAttributeName()} on an Comparator with a complicated string.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws ExpressionException
	 *             if there is a problem with the expression.
	 */
	@Test
	public final void testGetAttributeName_complicatedString() throws ExpressionException {
		assertEquals("Attribute name in " + STRING_COMPLICATED, NAME, new Comparator(STRING_COMPLICATED).getAttributeName());
	}

	/**
	 * Test for method {@link usa.browntrask.utility.Comparator#getAttributeName()} on an Comparator with a constant.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws ExpressionException
	 *             if there is a problem with the expression.
	 */
	@Test
	public final void testGetAttributeName_constant() throws ExpressionException {
		assertEquals("No attribute name in " + STRING_CONSTANT, "", new Comparator(STRING_CONSTANT).getAttributeName());
	}

	/**
	 * Test for method {@link usa.browntrask.utility.Comparator#getAttributeName()} on an Comparator with a simple string.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws ExpressionException
	 *             if there is a problem with the expression.
	 */
	@Test
	public final void testGetAttributeName_simpleString() throws ExpressionException {
		assertEquals("Attribute name in " + STRING_SIMPLE, NAME, new Comparator(STRING_SIMPLE).getAttributeName());
	}

	/**
	 * Test for method {@link usa.browntrask.utility.Comparator#getAttributeName()} on an uninitialized Comparator.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 */
	@Test
	public final void testGetAttributeName_uninitialized() {
		assertEquals("No attribute name in uninitialized", "", new Comparator().getAttributeName());
	}

	/**
	 * Test for method {@link java.lang.Object#hashCode()}.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 */
	@Test
	public final void testHashCode() {
		assertTrue("Hash code computed", 0 != new Comparator().hashCode());
	}

	/**
	 * Test for method {@link usa.browntrask.utility.Comparator#matches(String, Object)} on an comparator to which we pass an object
	 * that throws an exception.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws MatchException
	 *             if there is a problem performing the match.
	 * @throws ExpressionException
	 *             if there is a problem with the expression.
	 */
	@Test(expected = MatchException.class)
	public final void testMatches_exceptionObject() throws MatchException, ExpressionException {
		new Comparator(STRING_SIMPLE).matches(NAME, new ExceptionObject());
	}

	/**
	 * Test for method {@link usa.browntrask.utility.Comparator#matches(String, Object)} on an comparator to which we pass an object
	 * without the field.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 24, 2014
	 * @throws MatchException
	 *             if there is a problem performing the match.
	 * @throws ExpressionException
	 *             if there is a problem with the expression.
	 */
	@Test(expected = MatchException.class)
	public final void testMatches_genericObject() throws MatchException, ExpressionException {
		new Comparator(STRING_SIMPLE).matches(NAME, new Object());
	}

	/**
	 * Test for method {@link usa.browntrask.utility.Comparator#matches(String, Object)} on an comparator to which we pass an object
	 * with the field set to the wrong value.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws MatchException
	 *             if there is a problem performing the match.
	 * @throws ExpressionException
	 *             if there is a problem with the expression.
	 */
	@Test
	public final void testMatches_goodValue() throws MatchException, ExpressionException {
		final CheckObject check = new CheckObject();
		check.setC(BASIC_VALUE);

		assertTrue("Match to value for " + STRING_SIMPLE, new Comparator(STRING_SIMPLE).matches(NAME, check));
	}

	/**
	 * Test for method {@link usa.browntrask.utility.Comparator#matches(String, Object)} on an comparator to which we pass an object
	 * with the field set to the wrong value.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws MatchException
	 *             if there is a problem performing the match.
	 * @throws ExpressionException
	 *             if there is a problem with the expression.
	 */
	@Test
	public final void testMatches_goodValueInVars() throws MatchException, ExpressionException {
		final Comparator comparator = new Comparator(STRING_SIMPLE);
		comparator.setVars(new HashMap<String, Object>());
		final CheckObject check = new CheckObject();
		check.setC(BASIC_VALUE);
		comparator.getVars().put(NAME, check);

		assertTrue("Match to value in vars for " + STRING_SIMPLE, comparator.matches("Not" + NAME, new Object()));
	}

	/**
	 * Test for method {@link usa.browntrask.utility.Comparator#matches(String, Object)} on an comparator to which we pass a null
	 * name.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws MatchException
	 *             if there is a problem performing the match.
	 * @throws ExpressionException
	 *             if there is a problem with the expression.
	 */
	@Test
	public final void testMatches_nullName() throws MatchException, ExpressionException {
		assertFalse("No match to null name for " + STRING_SIMPLE, new Comparator(STRING_SIMPLE).matches(null, null));
	}

	/**
	 * Test for method {@link usa.browntrask.utility.Comparator#matches(String, Object)} on an comparator to which we pass a null
	 * object.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws MatchException
	 *             if there is a problem performing the match.
	 * @throws ExpressionException
	 *             if there is a problem with the expression.
	 */
	@Test
	public final void testMatches_nullObject() throws MatchException, ExpressionException {
		assertFalse("No match to null object for " + STRING_SIMPLE, new Comparator(STRING_SIMPLE).matches(NAME, null));
	}

	/**
	 * Test for method {@link usa.browntrask.utility.Comparator#matches(String, Object)} on an uninitialized comparator.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws MatchException
	 *             if there is a problem performing the match.
	 */
	@Test(expected = NullPointerException.class)
	public final void testMatches_uninitialized() throws MatchException {
		new Comparator().matches(NAME, new Object());
	}

	/**
	 * Test for method {@link usa.browntrask.utility.Comparator#matches(String, Object)} on an uninitialized comparator to which we
	 * pass a null name.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws MatchException
	 *             if there is a problem performing the match.
	 */
	@Test(expected = NullPointerException.class)
	public final void testMatches_uninitializedNullName() throws MatchException {
		new Comparator().matches(null, null);
	}

	/**
	 * Test for method {@link usa.browntrask.utility.Comparator#matches(String, Object)} on an uninitialized comparator to which we
	 * pass a null object.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws MatchException
	 *             if there is a problem performing the match.
	 */
	@Test(expected = NullPointerException.class)
	public final void testMatches_uninitializedNullObject() throws MatchException {
		new Comparator().matches(NAME, null);
	}

	/**
	 * Test for method {@link usa.browntrask.utility.Comparator#matches(String, Object)} on an comparator to which we pass an object
	 * with the field set to the wrong value.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws MatchException
	 *             if there is a problem performing the match.
	 * @throws ExpressionException
	 *             if there is a problem with the expression.
	 */
	@Test
	public final void testMatches_wrongValue() throws MatchException, ExpressionException {
		final CheckObject badCheck = new CheckObject();
		badCheck.setC(WRONG_VALUE);

		assertFalse("No match to wrong value for " + STRING_SIMPLE, new Comparator(STRING_SIMPLE).matches(NAME, badCheck));
	}

	/**
	 * Test for method {@link usa.browntrask.utility.Comparator#matchesRequirements(String, Object, List)} with the wrong values for
	 * AND requirements.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 23, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws MatchException
	 *             if there is a problem matching a requirement.
	 * @throws ExpressionException
	 *             if there is a problem creating the requirements.
	 */
	@Test
	public final void testMatchRequirements_andWrongValues() throws MatchException, ExpressionException {
		final CheckObject badCheck1 = new CheckObject();
		badCheck1.setC(WRONG_VALUE);
		final List<Map<String, Comparator>> requirements = Comparator.parseRequirements(REQUIREMENTS_AND);

		assertFalse("Wrong values do not match " + REQUIREMENTS_AND, Comparator.matchesRequirements(NAME, badCheck1, requirements));
	}

	/**
	 * Test for method {@link usa.browntrask.utility.Comparator#matchesRequirements(String, Object, List)} with a null name.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 23, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws MatchException
	 *             if there is a problem matching a requirement.
	 * @throws ExpressionException
	 *             if there is a problem creating the requirements.
	 */
	@Test
	public final void testMatchRequirements_noName() throws MatchException, ExpressionException {
		assertFalse("No name fails to match for " + REQUIREMENTS_SIMPLE,
				Comparator.matchesRequirements(null, new Object(), Comparator.parseRequirements(REQUIREMENTS_SIMPLE)));
	}

	/**
	 * Test for method {@link usa.browntrask.utility.Comparator#matchesRequirements(String, Object, List)} with a null object.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 23, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws MatchException
	 *             if there is a problem matching a requirement.
	 * @throws ExpressionException
	 *             if there is a problem creating the requirements.
	 */
	@Test
	public final void testMatchRequirements_noObject() throws MatchException, ExpressionException {
		assertFalse("No object fails to match for " + REQUIREMENTS_SIMPLE,
				Comparator.matchesRequirements(null, null, Comparator.parseRequirements(REQUIREMENTS_SIMPLE)));
	}

	/**
	 * Test for method {@link usa.browntrask.utility.Comparator#matchesRequirements(String, Object, List)} with null requirements.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 23, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws MatchException
	 *             if there is a problem matching a requirement.
	 */
	@Test
	public final void testMatchRequirements_noRequirements() throws MatchException {
		assertTrue("Should always match null requirements", Comparator.matchesRequirements(null, null, null));
	}

	/**
	 * Test for method {@link usa.browntrask.utility.Comparator#matchesRequirements(String, Object, List)} with the right first
	 * value for an OR requirements.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 23, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws MatchException
	 *             if there is a problem matching a requirement.
	 * @throws ExpressionException
	 *             if there is a problem creating the requirements.
	 */
	@Test
	public final void testMatchRequirements_orRightFirstValue() throws MatchException, ExpressionException {
		final CheckObject goodCheck = new CheckObject();
		goodCheck.setC(BASIC_VALUE);

		assertTrue("Right first value matches " + REQUIREMENTS_OR,
				Comparator.matchesRequirements(NAME, goodCheck, Comparator.parseRequirements(REQUIREMENTS_OR)));
	}

	/**
	 * Test for method {@link usa.browntrask.utility.Comparator#matchesRequirements(String, Object, List)} with the right second
	 * value for an OR requirements.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 23, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws MatchException
	 *             if there is a problem matching a requirement.
	 * @throws ExpressionException
	 *             if there is a problem creating the requirements.
	 */
	@Test
	public final void testMatchRequirements_orRightSecondValue() throws MatchException, ExpressionException {
		final CheckObject goodCheck = new CheckObject();
		goodCheck.setC(OTHER_VALUE);

		assertTrue("Right second value matches " + REQUIREMENTS_OR,
				Comparator.matchesRequirements(NAME, goodCheck, Comparator.parseRequirements(REQUIREMENTS_OR)));
	}

	/**
	 * Test for method {@link usa.browntrask.utility.Comparator#matchesRequirements(String, Object, List)} with the wrong value for
	 * OR requirements.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 23, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws MatchException
	 *             if there is a problem matching a requirement.
	 * @throws ExpressionException
	 *             if there is a problem creating the requirements.
	 */
	@Test
	public final void testMatchRequirements_orWrongValue() throws MatchException, ExpressionException {
		final CheckObject badCheck = new CheckObject();
		badCheck.setC(WRONG_VALUE);

		assertFalse("Wrong value does not match " + REQUIREMENTS_OR,
				Comparator.matchesRequirements(NAME, badCheck, Comparator.parseRequirements(REQUIREMENTS_OR)));
	}

	/**
	 * Test for method {@link usa.browntrask.utility.Comparator#matchesRequirements(String, Object, List)} with the right value.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 23, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws MatchException
	 *             if there is a problem matching a requirement.
	 * @throws ExpressionException
	 *             if there is a problem creating the requirements.
	 */
	@Test
	public final void testMatchRequirements_rightValue() throws MatchException, ExpressionException {
		final CheckObject goodCheck = new CheckObject();
		goodCheck.setC(BASIC_VALUE);

		assertTrue("Right value matches " + REQUIREMENTS_SIMPLE,
				Comparator.matchesRequirements(NAME, goodCheck, Comparator.parseRequirements(REQUIREMENTS_SIMPLE)));
	}

	/**
	 * Test for method {@link usa.browntrask.utility.Comparator#matchesRequirements(String, Object, List)} with a wrong name.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 23, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws MatchException
	 *             if there is a problem matching a requirement.
	 * @throws ExpressionException
	 *             if there is a problem creating the requirements.
	 */
	@Test
	public final void testMatchRequirements_wrongName() throws MatchException, ExpressionException {
		assertFalse("Wrong name fails to match for " + REQUIREMENTS_SIMPLE,
				Comparator.matchesRequirements(OTHER_NAME, new Object(), Comparator.parseRequirements(REQUIREMENTS_SIMPLE)));
	}

	/**
	 * Test for method {@link usa.browntrask.utility.Comparator#matchesRequirements(String, Object, List)} with a wrong object.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 23, 2007
	 * @version V2.2.0 Oct 24, 2014
	 * @throws MatchException
	 *             if there is a problem matching a requirement.
	 * @throws ExpressionException
	 *             if there is a problem creating the requirements.
	 */
	@Test(expected = MatchException.class)
	public final void testMatchRequirements_wrongObject() throws MatchException, ExpressionException {
		Comparator.matchesRequirements(NAME, new Object(), Comparator.parseRequirements(REQUIREMENTS_SIMPLE));
	}

	/**
	 * Test for method {@link usa.browntrask.utility.Comparator#matchesRequirements(String, Object, List)} with the wrong value.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 23, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws MatchException
	 *             if there is a problem matching a requirement.
	 * @throws ExpressionException
	 *             if there is a problem creating the requirements.
	 */
	@Test
	public final void testMatchRequirements_wrongValue() throws MatchException, ExpressionException {
		final CheckObject badCheck = new CheckObject();
		badCheck.setC(WRONG_VALUE);

		assertFalse("Wrong value fails to match for " + REQUIREMENTS_SIMPLE,
				Comparator.matchesRequirements(NAME, badCheck, Comparator.parseRequirements(REQUIREMENTS_SIMPLE)));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Comparator#parseRequirements(java.lang.String)} containing both an AND and an
	 * OR.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws ExpressionException
	 *             if there is a problem with the requirements expressions.
	 */
	@Test
	public final void testParseRequirements_andOrRequirements() throws ExpressionException {
		assertTrue("Parsed requirements " + REQUIREMENTS_AND_OR, assertRequirementsCorrect(REQUIREMENTS_AND_OR, ENTRIES_AND_OR));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Comparator#parseRequirements(java.lang.String)} with requirements containing an
	 * AND.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws ExpressionException
	 *             if there is a problem with the requirements expressions.
	 */
	@Test
	public final void testParseRequirements_andRequirements() throws ExpressionException {
		assertTrue("Parsed requirements " + REQUIREMENTS_AND, assertRequirementsCorrect(REQUIREMENTS_AND, ENTRIES_AND));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Comparator#parseRequirements(java.lang.String)} without requirements.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws ExpressionException
	 *             if there is a problem with the requirements expressions.
	 */
	@Test
	public final void testParseRequirements_noRequirements() throws ExpressionException {
		assertTrue("Parsed requirements for null", assertRequirementsCorrect(null, ENTRIES_SIMPLE));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Comparator#parseRequirements(java.lang.String)} with requirements containing an
	 * OR.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws ExpressionException
	 *             if there is a problem with the requirements expressions.
	 */
	@Test
	public final void testParseRequirements_orRequirements() throws ExpressionException {
		assertTrue("Parsed requirements " + REQUIREMENTS_OR, assertRequirementsCorrect(REQUIREMENTS_OR, ENTRIES_OR));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Comparator#parseRequirements(java.lang.String)} with quoted requirements.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 26, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws ExpressionException
	 *             if there is a problem with the requirements expressions.
	 */
	@Test
	public final void testParseRequirements_quoteRequirements() throws ExpressionException {
		assertTrue("Parsed requirements for " + REQUIREMENTS_QUOTE, assertRequirementsCorrect(REQUIREMENTS_QUOTE, ENTRIES_QUOTE));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Comparator#parseRequirements(java.lang.String)} with simple requirements.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 23, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws ExpressionException
	 *             if there is a problem with the requirements expressions.
	 */
	@Test
	public final void testParseRequirements_simpleRequirements() throws ExpressionException {
		assertTrue("Parsed requirements for " + REQUIREMENTS_SIMPLE, assertRequirementsCorrect(REQUIREMENTS_SIMPLE, ENTRIES_SIMPLE));
	}

	/**
	 * Checks the input requirements to see if they produce a map with the specified structure.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param requirements
	 *            the requirements.
	 * @param entries
	 *            the entries in the map.
	 * @return <code>true</code> if this method runs to completion.
	 * @since V0.1.7 Aug 18, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws ExpressionException
	 *             if there is a problem with the requirements expressions.
	 */
	private final boolean assertRequirementsCorrect(final String requirements, final int[] entries) throws ExpressionException {
		final List<Map<String, Comparator>> results = Comparator.parseRequirements(requirements);

		assertEquals(requirements + " produces expected list size", entries.length, results.size());
		final Iterator<Map<String, Comparator>> requirementItr = results.iterator();
		if (null != requirements) {
			for (final int entry : entries) {
				final Map<String, Comparator> result = requirementItr.next();
				assertEquals(result + " has expected map size", entry, result.size());
			}
		}

		return true;
	}
}
