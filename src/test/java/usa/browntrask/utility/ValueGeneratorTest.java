package usa.browntrask.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Test;

/**
 * Test class for the value generator class.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.6 Jul 28, 2007
 * @version V2.2.0 Oct 24, 2014
 */
public final class ValueGeneratorTest {

	/**
	 * Test method for {@link usa.browntrask.utility.ValueGenerator#hashCode()}.
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Jul 28, 2007
	 * @version Sep 25, 2007
	 * @throws ExpressionException
	 *             if there is a problem with the expression.
	 */
	@Test
	public final void testHashCode() throws ExpressionException {
		final ValueGenerator<String, String> noString = new ValueGenerator<String, String>();
		final ValueGenerator<String, String> withString = new ValueGenerator<String, String>("player");

		assertFalse("Hash code for blank entry is not the same as that for one with a string", noString.hashCode() == withString
				.hashCode());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.ValueGenerator#equals(java.lang.Object)} for a null object.
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Jul 28, 2007
	 * @version Sep 25, 2007
	 */
	@Test
	public final void testEqualsObjectNull() {
		final ValueGenerator<String, String> noString = new ValueGenerator<String, String>();

		assertFalse("Value generator is not equal to null", noString.equals(null));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.ValueGenerator#equals(java.lang.Object)} for a non-value generator object.
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Jul 28, 2007
	 * @version Sep 25, 2007
	 */
	@Test
	public final void testEqualsObjectString() {
		final ValueGenerator<String, String> noString = new ValueGenerator<String, String>();

		assertFalse("Value generator is not equal to string", noString.equals("Hello"));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.ValueGenerator#equals(java.lang.Object)} against itself (no string).
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Jul 28, 2007
	 * @version Sep 25, 2007
	 */
	@Test
	public final void testEqualsObjectItselfNoString() {
		final ValueGenerator<String, String> noString = new ValueGenerator<String, String>();

		assertTrue("Value generator is equal to itself", noString.equals(noString));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.ValueGenerator#equals(java.lang.Object)} against another (no string).
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Jul 28, 2007
	 * @version Sep 25, 2007
	 */
	@Test
	public final void testEqualsObjectAnotherNoString() {
		final ValueGenerator<String, String> noString = new ValueGenerator<String, String>();
		final ValueGenerator<String, String> anotherNoString = new ValueGenerator<String, String>();

		assertTrue("Value generator is equal to another without a string", noString.equals(anotherNoString));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.ValueGenerator#equals(java.lang.Object)} no no string versus string.
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Jul 28, 2007
	 * @version Sep 25, 2007
	 * @throws ExpressionException
	 *             if there is a problem creating the expression.
	 */
	@Test
	public final void testEqualsObjectNoStringString() throws ExpressionException {
		final ValueGenerator<String, String> noString = new ValueGenerator<String, String>();
		final ValueGenerator<String, String> anotherWithString = new ValueGenerator<String, String>("player");

		assertFalse("Value generator without string is not equal to another with a string", noString.equals(anotherWithString));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.ValueGenerator#equals(java.lang.Object)} no string versus no string.
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Jul 28, 2007
	 * @version Sep 25, 2007
	 * @throws ExpressionException
	 *             if there is a problem creating the expression.
	 */
	@Test
	public final void testEqualsObjectStringNoString() throws ExpressionException {
		final ValueGenerator<String, String> noString = new ValueGenerator<String, String>();
		final ValueGenerator<String, String> anotherWithString = new ValueGenerator<String, String>("player");

		assertFalse("Value generator with string is not equal to another without a string", anotherWithString.equals(noString));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.ValueGenerator#equals(java.lang.Object)} no string versus string (equal).
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Jul 28, 2007
	 * @version Sep 25, 2007
	 * @throws ExpressionException
	 *             if there is a problem creating the expression.
	 */
	@Test
	public final void testEqualsObjectStringStringEqual() throws ExpressionException {
		final ValueGenerator<String, String> withString = new ValueGenerator<String, String>("player");
		final ValueGenerator<String, String> anotherWithString = new ValueGenerator<String, String>("player");

		assertTrue("Value generator with string is equal to another with the same string", withString.equals(anotherWithString));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.ValueGenerator#equals(java.lang.Object)} no string versus string (different).
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Jul 28, 2007
	 * @version Sep 25, 2007
	 * @throws ExpressionException
	 *             if there is a problem creating the expression.
	 */
	@Test
	public final void testEqualsObjectStringStringDifferent() throws ExpressionException {
		final ValueGenerator<String, String> withString = new ValueGenerator<String, String>("player");
		final ValueGenerator<String, String> anotherWithString = new ValueGenerator<String, String>("player2");

		assertFalse("Value generator with string is not equal to another with a different string", withString
				.equals(anotherWithString));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.ValueGenerator#generate(java.lang.String, java.io.Serializable)} without a
	 * string.
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Jul 28, 2007
	 * @version Sep 25, 2007
	 * @throws GenerateException
	 *             if there is a problem generating the value.
	 */
	@Test(expected = IllegalStateException.class)
	public final void testGenerateNoString() throws GenerateException {
		final ValueGenerator<String, String> noString = new ValueGenerator<String, String>();

		noString.generate(null, null);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.ValueGenerator#generate(java.lang.String, java.io.Serializable)} without an
	 * object name.
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Jul 28, 2007
	 * @version Sep 25, 2007
	 * @throws ExpressionException
	 *             if there is a problem generating the expression.
	 * @throws GenerateException
	 *             if there is a problem generating the value.
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testGenerateNoObjectName() throws ExpressionException, GenerateException {
		final ValueGenerator<String, String> withString = new ValueGenerator<String, String>("player");

		withString.generate(null, null);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.ValueGenerator#generate(java.lang.String, java.io.Serializable)} without an
	 * object.
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Jul 28, 2007
	 * @version Sep 25, 2007
	 * @throws ExpressionException
	 *             if there is a problem generating the expression.
	 * @throws GenerateException
	 *             if there is a problem generating the value.
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testGenerateNoObject() throws ExpressionException, GenerateException {
		final ValueGenerator<String, String> withString = new ValueGenerator<String, String>("player");

		withString.generate("player", null);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.ValueGenerator#generate(java.lang.String, java.io.Serializable)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Jul 28, 2007
	 * @version Sep 25, 2007
	 * @throws ExpressionException
	 *             if there is a problem generating the expression.
	 * @throws GenerateException
	 *             if there is a problem generating the value.
	 */
	@Test
	public final void testGenerate() throws ExpressionException, GenerateException {
		final ValueGenerator<String, String> withString = new ValueGenerator<String, String>("player");

		assertEquals("Generated value", "name", withString.generate("player", "name"));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.ValueGenerator#generate(java.lang.String, java.io.Serializable)} for the
	 * integer math functions.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.5.1 Dec 27, 2007
	 * @version Dec 27, 2007
	 * @throws ExpressionException
	 *             if there is a problem generating the expression.
	 * @throws GenerateException
	 *             if there is a problem generating the value.
	 */
	@Test
	public final void testGenerate_intMath() throws ExpressionException, GenerateException {
		ValueGenerator<Integer, Integer> mathFunc = new ValueGenerator<Integer, Integer>("math.min(a, 2)");

		assertEquals("Minimum should be 1", Integer.valueOf(1), mathFunc.generate("a", 1));

		mathFunc = new ValueGenerator<Integer, Integer>("math.max(a, 2)");

		assertEquals("Maximum should be 2", Integer.valueOf(2), mathFunc.generate("a", 1));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.ValueGenerator#generate(java.lang.String, java.io.Serializable)} for the double
	 * math functions.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.5.1 Dec 27, 2007
	 * @version Dec 27, 2007
	 * @throws ExpressionException
	 *             if there is a problem generating the expression.
	 * @throws GenerateException
	 *             if there is a problem generating the value.
	 */
	@Test
	public final void testGenerate_doubleMath() throws ExpressionException, GenerateException {
		ValueGenerator<Double, Double> mathFunc = new ValueGenerator<Double, Double>("math.min(a, 2.0)");

		assertEquals("Minimum should be 1.0", Double.valueOf(1.0), mathFunc.generate("a", 1.0));

		mathFunc = new ValueGenerator<Double, Double>("math.max(a, 2.0)");

		assertEquals("Maximum should be 2.0", Double.valueOf(2.0), mathFunc.generate("a", 1.0));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.ValueGenerator#generate(java.lang.String, java.io.Serializable)} with variables
	 * set.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 20, 2007
	 * @version Aug 20, 2007
	 * @throws ExpressionException
	 *             if there is a problem generating the expression.
	 * @throws GenerateException
	 *             if there is a problem generating the value.
	 */
	@Test
	public final void testGenerate_variables() throws ExpressionException, GenerateException {
		final ValueGenerator<String, String> withString = new ValueGenerator<String, String>("player + dummy");
		withString.setVars(new HashMap<String, Object>());
		withString.getVars().put("dummy", "dummy");

		assertEquals("Generated value", "namedummy", withString.generate("player", "name"));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.ValueGenerator#generate(java.lang.String, java.io.Serializable)} where the
	 * expression cannot be evaluated.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 20, 2007
	 * @version Sep 25, 2007
	 * 
	 * @throws ExpressionException
	 *             if there is a problem generating the expression.
	 * @throws GenerateException
	 *             if there is a problem generating the value.
	 */
	@Test(expected = GenerateException.class)
	public final void testGenerate_notGenerated() throws ExpressionException, GenerateException {
		final ValueGenerator<String, String> withString = new ValueGenerator<String, String>("player + garbage");

		withString.generate("player", "name");
	}
}
