/**
 * Copyright 2005-2011. 2015 by Ian Andrew Brown<br>
 * All Rights Reserved
 */
package usa.browntrask.utility;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.MapContext;

/**
 * Extended AbstractExpressionHandler that matches an object against an expression.
 * <p>
 *
 * @author Ian Andrew Brown
 * @since V0.1.0 March 11, 2005
 * @version V2.4.0 Aug 11, 2018
 */
public final class Comparator extends AbstractExpressionHandler implements Serializable, Comparable<Comparator> {

	/**
	 * the serial version ID for this class.
	 * <p>
	 *
	 * @since V0.1 March 11, 2005
	 * @version December 16, 2006
	 */
	private static final long serialVersionUID = -4689626240814195105L;

	/**
	 * Determines if the input object matches the requirements provided.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param name
	 *            the name of the object.
	 * @param object
	 *            the object.
	 * @param requirements
	 *            the requirements.
	 * @return <code>true</code> if the requirements are matched, <code>false</code> otherwise.
	 * @since V0.1.8 Aug 23, 2007
	 * @version Dec 4, 2007
	 * @throws MatchException
	 *             if there is a problem matching a requirement.
	 */
	public final static boolean matchesRequirements(final String name, final Object object,
			final List<Map<String, Comparator>> requirements) {
		boolean matched = false;
		if (requirements == null) {
			matched = true;
		} else {
			for (final Map<String, Comparator> andRequirements : requirements) {
				matched = matchAndRequirements(name, object, andRequirements);
				if (matched) {
					break;
				}
			}
		}
		return matched;
	}

	/**
	 * Builds a requirements list containing <code>Comparators</code> from the input string.
	 * <p>
	 * The string should consist of one or more whitespace separated tokens (use quotes if necessary to include whitespace in the
	 * tokens). The tokens can be:
	 * <p>
	 * <ul>
	 * <li>An expression parsable by the JEXL code,</li>
	 * <li>The word "AND" is optional (it is assumed), indicating the this expression should be grouped with the previous one, or</li>
	 * <li>The word "OR" indicates that the following expressions are to be an alternative to the previous expressions.</li>
	 * </ul>
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param requirementsString
	 *            the string specifying the requirements.
	 * @return the requirements list.
	 * @exception ExpressionException
	 *                if there is a problem with an expression.
	 * @since V0.1 July 17, 2005
	 * @version Dec 4, 2007
	 */
	public final static List<Map<String, Comparator>> parseRequirements(final String requirementsString) {
		final List<Map<String, Comparator>> requirementsR = new ArrayList<Map<String, Comparator>>();
		Map<String, Comparator> requirementMap = new TreeMap<String, Comparator>();
		requirementsR.add(requirementMap);

		if (null != requirementsString) {
			StringBuffer andRequirement = null;
			final Tokenizer tokenizer = new Tokenizer(requirementsString, " \t;\n\r\f");
			while (tokenizer.hasMoreTokens()) {
				final String requirementString = tokenizer.nextToken();
				if ("OR".equalsIgnoreCase(requirementString)) {
					if (andRequirement != null) {
						addAndRequirement(requirementMap, andRequirement.toString());
						andRequirement = null;
					}
					requirementMap = addOrRequirement(requirementsR);
				} else if (!"AND".equalsIgnoreCase(requirementString)) {
					if (andRequirement == null) {
						andRequirement = new StringBuffer(requirementString);
					} else {
						andRequirement.append(' ').append(requirementString);
					}
				} else {
					if (andRequirement != null) {
						addAndRequirement(requirementMap, andRequirement.toString());
						andRequirement = null;
					}
				}
			}
			if (andRequirement != null) {
				addAndRequirement(requirementMap, andRequirement.toString());
			}
		}

		return requirementsR;
	}

	/**
	 * Add AND requirement to requirements map.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param requirementMap
	 *            the requirement mep.
	 * @param requirementString
	 *            the requirement string.
	 * @throws ExpressionException
	 *             if there is a problem with the string.
	 * @since V0.1.3 July 17, 2005
	 * @version Dec 4, 2007
	 */
	private static final void addAndRequirement(final Map<String, Comparator> requirementMap, final String requirementString) {
		final Comparator comparator = new Comparator(requirementString);
		requirementMap.put(comparator.getAttributeName(), comparator);
	}

	/**
	 * Add OR requirement to requirements map.
	 *
	 * @author Ian Andrew Brown
	 * @param requirementsR
	 *            the requirements being built.
	 * @return the new working requirement map.
	 * @since V0.1.3 July 13, 2007
	 * @version June 13, 2007
	 */
	private final static Map<String, Comparator> addOrRequirement(final List<Map<String, Comparator>> requirementsR) {
		final Map<String, Comparator> requirementMap = new TreeMap<String, Comparator>();
		requirementsR.add(requirementMap);
		return requirementMap;
	}

	/**
	 * Determines if the input object matches all of the requirements provided.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param name
	 *            the name of the object.
	 * @param object
	 *            the object.
	 * @param andRequirements
	 *            the requirements that must all be matched.
	 * @return <code>true</code> if all of the requirements are matched, <code>false</code> otherwise.
	 * @since V0.1.8 Aug 23, 2007
	 * @version Dec 4, 2007
	 * @throws MatchException
	 *             if there is a problem matching a requirement.
	 */
	private final static boolean matchAndRequirements(final String name, final Object object,
			final Map<String, Comparator> andRequirements) {
		boolean matched = true;
		for (final Comparator comparator : andRequirements.values()) {
			matched = comparator.matches(name, object);
			if (!matched) {
				break;
			}
		}
		return matched;
	}

	/**
	 * Builds a <code>Comparator</code>.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1 March 18, 2005
	 * @version December 16, 2006
	 */
	public Comparator() {
		super();
	}

	/**
	 * Builds a <code>Comparator</code> from the input string.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param string
	 *            the string.
	 * @exception ExpressionException
	 *                if there is a problem parsing the expression.
	 * @since V0.1 July 18, 2005
	 * @version Dec 4, 2007
	 */
	public Comparator(final String string) {
		super(string);
	}

	/** {@inheritDoc} */
	@Override
	public final int compareTo(final Comparator other) {
		final int differenceR;
		if (null == other) {
			differenceR = 1;
		} else {
			if (null == getExpression()) {
				differenceR = null == other.getExpression() ? 0 : -1;
			} else {
				differenceR = null == other.getExpression() ? 1 : getString().compareTo(other.getString());
			}
		}

		return differenceR;
	}

	/** {@inheritDoc} */
	@Override
	public final boolean equals(final Object object) {
		final boolean equalsR;

		if (object instanceof Comparator) {
			equalsR = super.equals(object);
		} else {
			equalsR = false;
		}

		return equalsR;
	}

	/**
	 * Gets the name of the attribute that this comparator checks.
	 * <p>
	 * The name of the attribute is the first variable in the parsed list of variables that does not appear in the list of supplied
	 * variable values.
	 * <p>
	 * If there are no variables, then see if the expression string has a .get(" part.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @return the attribute name.
	 * @since V0.1 July 18, 2005
	 * @version Aug 19, 2007
	 */
	public final String getAttributeName() {
		String attributeNameR;

		if (null == getVariables() || getVariables().isEmpty()) {
			attributeNameR = "";
		} else {
			attributeNameR = getVariables().get(0);
		}

		return attributeNameR;
	}

	/** {@inheritDoc} */
	@Override
	public final int hashCode() {
		return 7 + 31 * super.hashCode() + 31 * Comparator.class.hashCode();
	}

	/**
	 * Determines if the inputs match this expression.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param name
	 *            the name of the variable.
	 * @param object
	 *            the <code>EnGardeObject</code> to match.
	 * @return is there a match?
	 * @exception MatchException
	 *                if there is a problem.
	 * @since V0.1 December 12, 2005
	 * @version V2.4.0 Aug 11, 2018
	 */
	public final boolean matches(final String name, final Object object) {		
		if (null == getString()) {
			throw new NullPointerException("Comparator string is not set");
		}
		if ((name == null) || (object == null)) {
			return false;
		}

		final JexlContext context = new MapContext();
		context.set(name, object);
		if (null != getVars()) {
			for (final Map.Entry<String, Object> varEntry : getVars().entrySet()) {
				context.set(varEntry.getKey(), varEntry.getValue());
			}
		}

		try {
			return (Boolean) getExpression().evaluate(context);
		} catch (final org.apache.commons.jexl3.JexlException.Property e) {
			throw new MatchException("Failed to check " + name + ".", e);
		} catch (final org.apache.commons.jexl3.JexlException.Variable e) {
			return false;
		} catch (final java.lang.RuntimeException e) {
			throw e;
		} catch (final java.lang.Exception e) {
			throw new MatchException("Failed to check " + name + ".", e);
		}
	}
}
