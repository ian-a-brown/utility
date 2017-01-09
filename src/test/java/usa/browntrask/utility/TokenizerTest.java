package usa.browntrask.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test for Tokenizer.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.7 Aug 18, 2007
 * @version Sep 25, 2007
 */
public final class TokenizerTest {

	/**
	 * the first token for testing.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	private static final String FIRST_TOKEN = "FIRST";

	/**
	 * the second token for testing.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	private static final String SECOND_TOKEN = "SECOND";

	/**
	 * string to tokenize for testing.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	private static final String STRING = FIRST_TOKEN + " " + SECOND_TOKEN;

	/**
	 * the delimiter for testing.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	private static final String DELIMITER = ";";

	/**
	 * string with delimiters for testing.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	private static final String DELIMITED_STRING = FIRST_TOKEN + DELIMITER
			+ SECOND_TOKEN;

	/**
	 * a quoted string ('...') for testing.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	private static final String SINGLE_QUOTED_STRING = "'" + FIRST_TOKEN + "' "
			+ SECOND_TOKEN;

	/**
	 * a quoted string ("...") for testing.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	private static final String DOUBLE_QUOTED_STRING = "\"" + FIRST_TOKEN
			+ "\" " + SECOND_TOKEN;

	/**
	 * a string containing a backspace.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	private static final String BACKSPACE_STRING = "\\b" + FIRST_TOKEN + " "
			+ SECOND_TOKEN;

	/**
	 * a string containing a tab.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	private static final String TAB_STRING = "\\t" + FIRST_TOKEN + " "
			+ SECOND_TOKEN;

	/**
	 * a string containing a newline.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	private static final String NEWLINE_STRING = "\\n" + FIRST_TOKEN + " "
			+ SECOND_TOKEN;

	/**
	 * a string containing a formfeed.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	private static final String FORMFEED_STRING = "\\f" + FIRST_TOKEN + " "
			+ SECOND_TOKEN;

	/**
	 * a string containing a carriage-return.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	private static final String CARRIAGE_RETURN_STRING = "\\r" + FIRST_TOKEN
			+ " " + SECOND_TOKEN;

	/**
	 * a string containing a double quote.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	private static final String DOUBLE_QUOTE_STRING = "\\\"" + FIRST_TOKEN
			+ " " + SECOND_TOKEN;

	/**
	 * a string containing a single quote.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	private static final String SINGLE_QUOTE_STRING = "\\'" + FIRST_TOKEN + " "
			+ SECOND_TOKEN;

	/**
	 * a string containing a backslash.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	private static final String BACKSLASH_STRING = "\\\\" + FIRST_TOKEN + " "
			+ SECOND_TOKEN;

	/**
	 * a quoted string containing a backslash.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	private static final String BACKSLASH_IN_QUOTED_STRING = "\"a \\\\ \"";

	/**
	 * a string containing just a non-standard quoted character.
	 * <p>
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	private static final String NONSTANDARD_STRING = "\\c";
	
	/**
	 * Test method for
	 * {@link usa.browntrask.utility.Tokenizer#Tokenizer(java.lang.String)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	@Test
	public final void testTokenizer_string() {
		final Tokenizer tokenizer = new Tokenizer(STRING);
		
		assertTrue("Tokenizer has tokens", tokenizer.hasMoreTokens());
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.utility.Tokenizer#Tokenizer(java.lang.String, java.lang.String)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	@Test
	public final void testTokenizer_stringString() {
		final Tokenizer tokenizer = new Tokenizer(DELIMITED_STRING, DELIMITER);
		
		assertTrue("Tokenizer has tokens", tokenizer.hasMoreTokens());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Tokenizer#hasMoreTokens()}
	 * for a string with no more tokens.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	@Test
	public final void testHasMoreTokens_noTokens() {
		final Tokenizer tokenizer = new Tokenizer("");
		
		assertFalse("No more tokens", tokenizer.hasMoreTokens());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Tokenizer#hasMoreTokens()}
	 * for a string with more tokens.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	@Test
	public final void testHasMoreTokens() {
		final Tokenizer tokenizer = new Tokenizer(STRING);
		
		assertTrue("Has more tokens", tokenizer.hasMoreTokens());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Tokenizer#nextToken()} with
	 * no more tokens.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	@Test
	public final void testNextToken_noMore() {
		final Tokenizer tokenizer = new Tokenizer("");
		
		assertNull("No next token", tokenizer.nextToken());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Tokenizer#nextToken()} with
	 * more tokens.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	@Test
	public final void testNextToken() {
		final Tokenizer tokenizer = new Tokenizer(DELIMITED_STRING, DELIMITER);
		
		assertNotNull("Next token", tokenizer.nextToken());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Tokenizer#nextToken()} with
	 * a quoted ('...') token.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	@Test
	public final void testNextToken_singleQuoted() {
		final Tokenizer tokenizer = new Tokenizer(SINGLE_QUOTED_STRING,
				DELIMITER);
		
		assertNotNull("Next token", tokenizer.nextToken());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Tokenizer#nextToken()} with
	 * a quoted ("...") token.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	@Test
	public final void testNextToken_doubleQuoted() {
		final Tokenizer tokenizer = new Tokenizer(DOUBLE_QUOTED_STRING,
				DELIMITER);
		
		assertNotNull("Next token", tokenizer.nextToken());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Tokenizer#nextToken()} with
	 * a token containing a quoted character: backspace.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	@Test
	public final void testNextToken_backspace() {
		final Tokenizer tokenizer = new Tokenizer(BACKSPACE_STRING, DELIMITER);
		
		assertTrue("Backspace", tokenizer.nextToken().contains("\b"));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Tokenizer#nextToken()} with
	 * a token containing a quoted character: tab.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	@Test
	public final void testNextToken_tab() {
		final Tokenizer tokenizer = new Tokenizer(TAB_STRING, DELIMITER);
		
		assertTrue("Tab", tokenizer.nextToken().contains("\t"));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Tokenizer#nextToken()} with
	 * a token containing a quoted character: newline.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	@Test
	public final void testNextToken_newline() {
		final Tokenizer tokenizer = new Tokenizer(NEWLINE_STRING, DELIMITER);
		
		assertTrue("Newline", tokenizer.nextToken().contains("\n"));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Tokenizer#nextToken()} with
	 * a token containing a quoted character: formfeed.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	@Test
	public final void testNextToken_formfeed() {
		final Tokenizer tokenizer = new Tokenizer(FORMFEED_STRING, DELIMITER);
		
		assertTrue("Formfeed", tokenizer.nextToken().contains("\f"));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Tokenizer#nextToken()} with
	 * a token containing a quoted character: carriage-return.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	@Test
	public final void testNextToken_carriageReturn() {
		final Tokenizer tokenizer = new Tokenizer(CARRIAGE_RETURN_STRING,
				DELIMITER);
		
		assertTrue("Carriage return", tokenizer.nextToken().contains("\r"));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Tokenizer#nextToken()} with
	 * a token containing a quoted character: double quote (").
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	@Test
	public final void testNextToken_doubleQuote() {
		final Tokenizer tokenizer = new Tokenizer(DOUBLE_QUOTE_STRING,
				DELIMITER);
		
		assertTrue("Double quote", tokenizer.nextToken().contains("\""));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Tokenizer#nextToken()} with
	 * a token containing a quoted character: single quote (').
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	@Test
	public final void testNextToken_singleQuote() {
		final Tokenizer tokenizer = new Tokenizer(SINGLE_QUOTE_STRING,
				DELIMITER);
		
		assertTrue("Single quote", tokenizer.nextToken().contains("'"));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Tokenizer#nextToken()} with
	 * a token containing a quoted character: backslash.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	@Test
	public final void testNextToken_backslash() {
		final Tokenizer tokenizer = new Tokenizer(BACKSLASH_STRING, DELIMITER);
		
		assertTrue("Backslash", tokenizer.nextToken().contains("\\"));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Tokenizer#nextToken()} with
	 * a token containing a quoted character: not a standard one.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	@Test
	public final void testNextToken_nonStandard() {
		final Tokenizer tokenizer = new Tokenizer(NONSTANDARD_STRING, DELIMITER);
		
		assertTrue("Empty", tokenizer.nextToken().isEmpty());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Tokenizer#nextToken()} with
	 * a token containing a quoted character: backslash in a quoted string.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	@Test
	public final void testNextToken_backslashInQuotes() {
		final Tokenizer tokenizer = new Tokenizer(BACKSLASH_IN_QUOTED_STRING, DELIMITER);

		assertTrue("Backslash", tokenizer.nextToken().contains("\\"));
	}

	/**
	 * Test method for {@link usa.browntrask.utility.Tokenizer#nextToken()} with
	 * a token containing just delimiters.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	@Test
	public final void testNextToken_delimiters() {
		final Tokenizer tokenizer = new Tokenizer(DELIMITER + DELIMITER + FIRST_TOKEN, DELIMITER);

		assertEquals("First token", FIRST_TOKEN, tokenizer.nextToken());
	}
	
	/**
	 * Test method for {@link usa.browntrask.utility.Tokenizer#nextToken()} with
	 * a token containing just a double quote.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.7 Aug 18, 2007
	 * @version Aug 18, 2007
	 */
	@Test
	public final void testNextToken_oneDoubleQuote() {
		final Tokenizer tokenizer = new Tokenizer("\"");
		
		assertNull("Empty", tokenizer.nextToken());
	}
}
