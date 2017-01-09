/**
 * Copyright 2007, 2008, 2009, 2010, 2011, 2014, 2015 by Ian Andrew Brown<br>
 * All Rights Reserved
 */
package usa.browntrask.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlEngine;
import org.junit.Test;

/**
 * Test for AbstractExpressionHandler.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.7 Aug 19, 2007
 * @version V2.2.0 Nov 21, 2015
 */
public final class TestAbstractExpressionHandler {

	/**
	 * Spy implementation of AbstractExpressionHandler.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version Aug 19, 2007
	 */
	private final class SpyExpressionHandler extends AbstractExpressionHandler {

		/**
		 * Constructs a SpyExpressionHandler.
		 * <p>
		 * <p>
		 * 
		 * @author Ian Andrew Brown
		 * @since V0.1.7 Aug 19, 2007
		 * @version Aug 19, 2007
		 */
		public SpyExpressionHandler() {
			super();
		}

		/**
		 * Constructs a SpyExpressionHandler for the specified string.
		 * <p>
		 * 
		 * @author Ian Andrew Brown
		 * @param string
		 *            the string providing the expression.
		 * @throws ExpressionException
		 *             if there is a problem with parsing the expression.
		 * @since V0.1.7 Aug 19, 2007
		 * @version Aug 19, 2007
		 */
		public SpyExpressionHandler(final String string) throws ExpressionException {
			super(string);
		}

	}

	/**
	 * a different simple expression.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version Aug 19, 2007
	 */
	private static final String DIFFFERENT_EXPRESSION = "b==7";

	/**
	 * an expression including a quoted value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.10 Aug 26, 2007
	 * @version Aug 26, 2007
	 */
	private static final String QUOTE_EXPRESSION = "character.a == \"character\"";

	/**
	 * the expected result for the quoted expression.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.10 Aug 26, 2007
	 * @version Aug 26, 2007
	 */
	private static final String QUOTE_RESULT = "character.a == \"character\"";

	/**
	 * a simple expression.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version Aug 19, 2007
	 */
	private static final String SIMPLE_EXPRESSION = "a==6";

	/**
	 * Test method for {@link usa.browntrask.utility.AbstractExpressionHandler#AbstractExpressionHandler()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version Aug 19, 2007
	 */
	@Test
	public final void testAbstractExpressionHandler() {
		assertNull("Expression", new SpyExpressionHandler().getExpression());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AbstractExpressionHandler#AbstractExpressionHandler(java.lang.String)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @throws ExpressionException
	 *             if there is a problem with the expression.
	 * @since V0.1.7 Aug 19, 2007
	 * @version V1.6.0 Feb 2, 2011
	 */
	@Test
	public final void testAbstractExpressionHandler_string() throws ExpressionException {
		assertEquals("Expression set", SIMPLE_EXPRESSION, new SpyExpressionHandler(SIMPLE_EXPRESSION).getExpression()
				.getExpression());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AbstractExpressionHandler#equals(java.lang.Object)} initialized against another
	 * with a different expression.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @throws ExpressionException
	 *             if there is a problem parsing the expression.
	 * @since V0.1.7 Aug 19, 2007
	 * @version V1.6.0 Feb 2, 2011
	 */
	@Test
	public final void testEquals_different() throws ExpressionException {
		final SpyExpressionHandler handler = new SpyExpressionHandler(SIMPLE_EXPRESSION);

		assertFalse("Not equal to another with different string", handler.equals(new SpyExpressionHandler(DIFFFERENT_EXPRESSION)));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AbstractExpressionHandler#equals(java.lang.Object)} against a different type of
	 * object.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version Aug 19, 2007
	 */
	@Test
	public final void testEquals_differentObject() {
		assertFalse("Not equal to differentobject type", new SpyExpressionHandler().equals(new Object()));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AbstractExpressionHandler#equals(java.lang.Object)} initialized against itself.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @throws ExpressionException
	 *             if there is a problem parsing the expression.
	 * @since V0.1.7 Aug 19, 2007
	 * @version V1.6.0 Feb 2, 2011
	 */
	@Test
	public final void testEquals_itself() throws ExpressionException {
		final SpyExpressionHandler handler = new SpyExpressionHandler(SIMPLE_EXPRESSION);

		assertTrue("Equal to itself", handler.equals(handler));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AbstractExpressionHandler#equals(java.lang.Object)} against null.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version Aug 19, 2007
	 */
	@Test
	public final void testEquals_null() {
		assertFalse("Not equal to null", new SpyExpressionHandler().equals(null));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AbstractExpressionHandler#equals(java.lang.Object)} initialized against another
	 * with the same expression.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @throws ExpressionException
	 *             if there is a problem parsing the expression.
	 * @since V0.1.7 Aug 19, 2007
	 * @version V1.6.0 Feb 2, 2011
	 */
	@Test
	public final void testEquals_same() throws ExpressionException {
		final SpyExpressionHandler handler = new SpyExpressionHandler(SIMPLE_EXPRESSION);

		assertTrue("Equal to another with same string", handler.equals(new SpyExpressionHandler(SIMPLE_EXPRESSION)));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AbstractExpressionHandler#equals(java.lang.Object)} uninitialized against an
	 * uninitialized one.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @throws ExpressionException
	 *             if there is a problem with the expression.
	 * @since V0.1.7 Aug 19, 2007
	 * @version V1.6.0 Feb 2, 2011
	 */
	@Test
	public final void testEquals_stringUninitialized() throws ExpressionException {
		final SpyExpressionHandler handler = new SpyExpressionHandler();

		assertFalse("String not equal to uninitialized", new SpyExpressionHandler(SIMPLE_EXPRESSION).equals(handler));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AbstractExpressionHandler#equals(java.lang.Object)} uninitialized against
	 * another uninitialized.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version Aug 19, 2007
	 */
	@Test
	public final void testEquals_uninitialized() {
		final SpyExpressionHandler handler = new SpyExpressionHandler();

		assertTrue("Equal to another (uninitialized)", handler.equals(new SpyExpressionHandler()));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AbstractExpressionHandler#equals(java.lang.Object)} uninitialized against
	 * itself.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version Aug 19, 2007
	 */
	@Test
	public final void testEquals_uninitializedItself() {
		final SpyExpressionHandler handler = new SpyExpressionHandler();

		assertTrue("Equal to itself (uninitialized)", handler.equals(handler));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AbstractExpressionHandler#equals(java.lang.Object)} uninitialized against an
	 * ininitialized one.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @throws ExpressionException
	 *             if there is a problem with the expression.
	 * @since V0.1.7 Aug 19, 2007
	 * @version V1.6.0 Feb 2, 2011
	 */
	@Test
	public final void testEquals_uninitializedString() throws ExpressionException {
		final SpyExpressionHandler handler = new SpyExpressionHandler();

		assertFalse("Uninitialized not equal to string", handler.equals(new SpyExpressionHandler(SIMPLE_EXPRESSION)));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AbstractExpressionHandler#getExpression()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @throws ExpressionException
	 *             if there is a problem with the expression.
	 * @since V0.1.7 Aug 19, 2007
	 * @version V1.6.0 Feb 2, 2011
	 */
	@Test
	public final void testGetExpression() throws ExpressionException {
		assertEquals("Expression set", SIMPLE_EXPRESSION, new SpyExpressionHandler(SIMPLE_EXPRESSION).getExpression()
				.getExpression());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AbstractExpressionHandler#getExpression()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @throws ExpressionException
	 *             if there is a problem with the expression.
	 * @since V0.1.10 Aug 26, 2007
	 * @version V1.6.0 Feb 2, 2011
	 */
	@Test
	public final void testGetExpression_quoted() throws ExpressionException {
		assertEquals("Expression set", QUOTE_RESULT, new SpyExpressionHandler(QUOTE_EXPRESSION).getExpression().getExpression());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AbstractExpressionHandler#getExpression()} uninitialized.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version Aug 19, 2007
	 */
	@Test
	public final void testGetExpression_uninitialized() {
		assertNull("Expression", new SpyExpressionHandler().getExpression());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AbstractExpressionHandler#getString()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @throws ExpressionException
	 *             if there is a problem with the expression.
	 * @since V0.1.7 Aug 19, 2007
	 * @version V1.6.0 Feb 2, 2011
	 */
	@Test
	public final void testGetString() throws ExpressionException {
		assertEquals("String set", SIMPLE_EXPRESSION, new SpyExpressionHandler(SIMPLE_EXPRESSION).getString());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AbstractExpressionHandler#getString()} uninitialized.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version Aug 19, 2007
	 */
	@Test
	public final void testGetString_uninitialized() {
		assertNull("String", new SpyExpressionHandler().getString());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AbstractExpressionHandler#getVariables()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version Aug 19, 2007
	 */
	@Test
	public final void testGetVariables() {
		assertNull("Variables", new SpyExpressionHandler().getVariables());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AbstractExpressionHandler#getVars()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version Aug 19, 2007
	 */
	@Test
	public final void testGetVars() {
		assertNull("Vars", new SpyExpressionHandler().getVars());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AbstractExpressionHandler#hashCode()} for an initialized handler.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @throws ExpressionException
	 *             if there is a problem with the expression.
	 * @since V0.1.7 Aug 19, 2007
	 * @version V1.6.0 Feb 2, 2011
	 */
	@Test
	public final void testHashCode() throws ExpressionException {
		assertTrue("Hash code computed", 7 != new SpyExpressionHandler(SIMPLE_EXPRESSION).hashCode());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AbstractExpressionHandler#hashCode()} for an uninitialized handler.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version Aug 19, 2007
	 */
	@Test
	public final void testHashCode_uninitialized() {
		assertEquals("Hash code computed", 7, new SpyExpressionHandler().hashCode());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AbstractExpressionHandler#setExpression(Expression)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @throws Exception
	 *             if there is a problem creating the expression.
	 * @since V0.1.7 Aug 19, 2007
	 * @version V2.2.0 Nov 21, 2015
	 */
	@Test
	public final void testSetExpression() throws Exception {
		final JexlEngine engine = new JexlEngine();
		engine.setLenient(true);
		engine.setSilent(true);
		final AbstractExpressionHandler handler = new SpyExpressionHandler();
		final Expression expression = engine.createExpression(SIMPLE_EXPRESSION);

		handler.setExpression(expression);

		assertEquals("Expression set", expression, handler.getExpression());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AbstractExpressionHandler#setString(java.lang.String)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @throws ExpressionException
	 *             if there is a problem with the expression.
	 * @since V0.1.7 Aug 19, 2007
	 * @version V1.6.0 Feb 2, 2011
	 */
	@Test
	public final void testSetString() throws ExpressionException {
		final AbstractExpressionHandler handler = new SpyExpressionHandler();

		handler.setString(SIMPLE_EXPRESSION);

		assertEquals("String set", SIMPLE_EXPRESSION, handler.getString());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AbstractExpressionHandler#setString(java.lang.String)} for a string that is
	 * null.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @throws ExpressionException
	 *             if there is a problem processing the expression.
	 * @since V0.1.7 Aug 20, 2007
	 * @version V1.6.0 Feb 2, 2011
	 */
	@Test(expected = ExpressionException.class)
	public final void testSetString_null() throws ExpressionException {
		final AbstractExpressionHandler handler = new SpyExpressionHandler();
		handler.setString(null);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AbstractExpressionHandler#setVars(java.util.Map)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version Aug 19, 2007
	 */
	@Test
	public final void testSetVars() {
		final AbstractExpressionHandler handler = new SpyExpressionHandler();
		final Map<String, Object> vars = new HashMap<String, Object>();

		handler.setVars(vars);

		assertEquals("Vars set", vars, handler.getVars());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AbstractExpressionHandler#toString()} for an initialized value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @throws ExpressionException
	 *             if there is a problem with the expression.
	 * @since V0.1.7 Aug 19, 2007
	 * @version V1.6.0 Feb 2, 2011
	 */
	@Test
	public final void testToString() throws ExpressionException {
		assertTrue("String representation", new SpyExpressionHandler(SIMPLE_EXPRESSION).toString().contains("null"));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.AbstractExpressionHandler#toString()} for an uninitialized value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 19, 2007
	 * @version Aug 19, 2007
	 */
	@Test
	public final void testToString_uninitialized() {
		assertTrue("String representation", new SpyExpressionHandler().toString().contains("null"));
	}
}
