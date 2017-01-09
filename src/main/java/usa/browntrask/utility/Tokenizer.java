package usa.browntrask.utility;

import java.util.StringTokenizer;

/**
 * String parser to that uses whitespace as delimiters, with support for quoted characters or strings within the tokens.
 * <p>
 * 
 * 
 * 
 * @author Ian Andrew Brown
 * @since V0.1 November 16, 2004
 * @version Mar 8, 2008
 */
public final class Tokenizer {

	/**
	 * the quote delimiters.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1 April 25, 2005
	 * @version June 16, 2007
	 */
	private final static String QUOTE_DELIMITERS = "\"'\\";

	/**
	 * the standard whitespace delimiters.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1 November 16, 2004
	 * @version June 16, 2007
	 */
	public final static String WHITESPACE_DELIMITERS = " \t\r\n\f";

	/**
	 * Maps the first character of the input string according to the standard Java string rules.
	 * <p>
	 * 
	 * The remainder of the string is left unchanged.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param string
	 *            the string to map.
	 * @return the mapped string.
	 * @since V0.1 March 7, 2005
	 * @version June 15, 2007
	 */
	private final static String mapFirstCharacter(final String string) {
		final StringBuffer mapped = new StringBuffer();
		final char theChar = string.charAt(0);

		switch (theChar) {
		case 'b':
			mapped.append('\b');
			break;
		case 't':
			mapped.append('\t');
			break;
		case 'n':
			mapped.append('\n');
			break;
		case 'f':
			mapped.append('\f');
			break;
		case 'r':
			mapped.append('\r');
			break;
		case '\"':
			mapped.append('\"');
			break;
		case '\'':
			mapped.append('\'');
			break;
		case '\\':
			mapped.append('\\');
			break;
		default:
			break;
		}

		if (string.length() > 1) {
			mapped.append(string.substring(1));
		}

		return mapped.toString();
	}

	/**
	 * the user delimiters.
	 * <p>
	 * 
	 * 
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1 April 25, 2005
	 * @version June 15, 2007
	 */
	private transient final String delimiters;

	/**
	 * the string stringTokenizer used to build the whitespace delimited tokens.
	 * <p>
	 * 
	 * 
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1 April 25, 2005
	 * @version June 15, 2007
	 */
	private transient final StringTokenizer stringTokenizer;

	/**
	 * Builds a stringTokenizer for the input string.
	 * <p>
	 * 
	 * The default whitespace delimiters are used.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param string
	 *            the string to parse.
	 * @since V0.1 April 25, 2005
	 * @version Aug 18, 2007
	 */
	public Tokenizer(final String string) {
		this(string, WHITESPACE_DELIMITERS);
	}

	/**
	 * Builds a stringTokenizer for the input string using the specified delimiters.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param string
	 *            the string to parse.
	 * @param delimiters
	 *            the delimiters (aside from the quote characters) to use.
	 * @since V0.1 April 25, 2005
	 * @version June 15, 2007
	 */
	public Tokenizer(final String string, final String delimiters) {
		super();

		this.delimiters = delimiters;
		stringTokenizer = new StringTokenizer(string, delimiters + QUOTE_DELIMITERS, true);
	}

	/**
	 * Adds a token delimited by double quotes to the parameter.
	 * <p>
	 * Characters within the double quotes can be mapped to special characters using the backslash (\).
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param parameter
	 *            the parameter.
	 * @return the string buffer containing the new parameter.
	 * @since V0.1.4 June 16, 2007
	 * @version Mar 8, 2008
	 */
	private final StringBuffer addDoubleQuotedTokenToParameter(final StringBuffer parameter) {
		StringBuffer newParameter = parameter;
		while (hasMoreTokens()) {
			final String token = stringTokenizer.nextToken("\\\"");
			if ("\\".equals(token)) {
				newParameter = addGeneralTokenToParameter(newParameter, mapFirstCharacter(stringTokenizer.nextToken("\\\"")));

			} else if ("\"".equals(token)) {
				break;
			} else {
				newParameter = addGeneralTokenToParameter(newParameter, token);
			}
		}

		return newParameter;
	}

	/**
	 * Adds a general (not a delimiter or whitespace) token to a parameter.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param parameter
	 *            the parameter (can be <code>null</code>).
	 * @param token
	 *            the token to add.
	 * @return the new parameter.
	 * @since V0.1.4 June 16, 2007
	 * @version June 16, 2007
	 */
	private StringBuffer addGeneralTokenToParameter(final StringBuffer parameter, final String token) {
		StringBuffer newParameter = parameter;
		if (null == newParameter) {
			newParameter = new StringBuffer(token);
		} else {
			newParameter.append(token);
		}
		return newParameter;
	}

	/**
	 * Adds a general (not a delimiter or whitespace) token to a parameter.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param parameter
	 *            the parameter (can be <code>null</code>).
	 * @return the new parameter.
	 * @since V0.1.4 June 16, 2007
	 * @version June 16, 2007
	 */
	private final StringBuffer addQuotedCharacterToParameter(final StringBuffer parameter) {
		return addGeneralTokenToParameter(parameter, mapFirstCharacter(stringTokenizer.nextToken(delimiters + QUOTE_DELIMITERS)));
	}

	/**
	 * Adds a token delimited by single quotes to the parameter.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param parameter
	 *            the parameter (can be <code>null</code>).
	 * @return the new parameter.
	 * @since V0.1.4 June 16, 2007
	 * @version June 16, 2007
	 */
	private final StringBuffer addSingleQuotedTokenToParameter(final StringBuffer parameter) {
		final String token = stringTokenizer.nextToken("'");
		stringTokenizer.nextToken("'");
		return addGeneralTokenToParameter(parameter, token);
	}

	/**
	 * Does the stringTokenizer have more tokens?
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return stringTokenizer has more tokens?
	 * @since V0.1 April 25, 2005
	 * @version June 15, 2007
	 */
	public final boolean hasMoreTokens() {
		return stringTokenizer.hasMoreTokens();
	}

	/**
	 * Retrieves the next token from the string.
	 * <p>
	 * 
	 * A token consists of a string of characters, separated by whitespace. Quoting characters (' and ") provide a means by which
	 * whitespace may be included in a token.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the next token or <code>null</code> if no more tokens remain to be parsed.
	 * @since V0.1 November 22, 2005
	 * @version June 15, 2007
	 */
	public final String nextToken() {
		StringBuffer parameter = null;

		while (hasMoreTokens()) {
			final String token = stringTokenizer.nextToken(delimiters + QUOTE_DELIMITERS);

			if ((delimiters.indexOf(token) == -1) && (QUOTE_DELIMITERS.indexOf(token) == -1)) {
				parameter = addGeneralTokenToParameter(parameter, token);

			} else if (delimiters.indexOf(token) >= 0) {
				if (null == parameter) {
					continue;
				} else {
					break;
				}

			} else if ("\\".equals(token)) {
				parameter = addQuotedCharacterToParameter(parameter);

			} else if ("'".equals(token)) {
				parameter = addSingleQuotedTokenToParameter(parameter);

			} else {
				parameter = addDoubleQuotedTokenToParameter(parameter);
			}
		}

		return (null == parameter) ? null : parameter.toString();
	}
}
