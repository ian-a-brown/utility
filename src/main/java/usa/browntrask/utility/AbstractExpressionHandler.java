package usa.browntrask.utility;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.parser.ASTIdentifier;
import org.apache.commons.jexl2.parser.ASTJexlScript;
import org.apache.commons.jexl2.parser.ASTMethodNode;
import org.apache.commons.jexl2.parser.ASTReference;
import org.apache.commons.jexl2.parser.Node;
import org.apache.commons.jexl2.parser.ParseException;
import org.apache.commons.jexl2.parser.Parser;
import org.apache.commons.jexl2.parser.ParserTokenManager;
import org.apache.commons.jexl2.parser.SimpleCharStream;

/**
 * Abstract wrapper around a Jexl Expression handler to allow for the expression values to be set from a map of entries rather than
 * explicitly in the expression.
 * <p>
 *
 * This capability is used so that it is possible to get the expression values simply by asking the expression rather than having to
 * some how interpret the expression.
 * <p>
 *
 * @author Ian Andrew Brown
 * @since V0.1.6 Jul 28, 2007
 * @version V2.2.0 Oct 19, 2008
 */
public abstract class AbstractExpressionHandler {

	/**
	 * the JEXL engine.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V2.2.0 Oct 19, 2014
	 * @version V2.2.0 Oct 19, 2014
	 */
	protected static final JexlEngine jexlEngine = new JexlEngine();

	static {
		jexlEngine.setLenient(false);
		jexlEngine.setSilent(false);
	}

	/**
	 * the Jexl Expression to evaluate.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1 July 18, 2005
	 * @version July 28, 2007
	 */
	private transient Expression expression;

	/**
	 * the string used to create the expression.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1 July 18, 2005
	 * @version July 28, 2007
	 */
	private String string;

	/**
	 * the list of variables used by the expression.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1 April 25, 2005
	 * @version June 28, 2007
	 */
	private List<String> variables;

	/**
	 * the map of variable values to check.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1 March 18, 2005
	 * @version December 16, 2006
	 */
	private Map<String, Object> vars = null;

	/**
	 * Builds a <code>AbstractExpressionHandler</code>.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.6 July 28, 2007
	 * @version July 28, 2007
	 */
	public AbstractExpressionHandler() {
		super();
	}

	/**
	 * Builds a <code>AbstractExpressionHandler</code> from the input string.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param string
	 *            the string.
	 * @exception ExpressionException
	 *                if there is a problem parsing the expression.
	 * @since V0.1.6 July 28, 2007
	 * @version July 28, 2007
	 */
	public AbstractExpressionHandler(final String string) {
		this();

		setString(string);
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(final Object object) {
		final boolean equalsR;

		if (object instanceof AbstractExpressionHandler) {
			final AbstractExpressionHandler other = (AbstractExpressionHandler) object;

			if (null == getString()) {
				equalsR = null == other.getString();
			} else {
				equalsR = null == other.getString() ? false : getString().equals(other.getString());
			}
		} else {
			equalsR = false;
		}

		return equalsR;
	}

	/**
	 * Gets the expression.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @return the expression.
	 * @since V0.1 March 18, 2005
	 * @version June 13, 2007
	 */
	public final Expression getExpression() {
		return expression;
	}

	/**
	 * Gets the string used to define the expression.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @return the string.
	 * @since V0.1 July 18, 2005
	 * @version June 13, 2007
	 */
	public final String getString() {
		return string;
	}

	/**
	 * Gets the map of variable values.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @return the variables.
	 * @since V0.1 March 18, 2005
	 * @version June 13, 2007
	 */
	public final Map<String, Object> getVars() {
		return vars;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		return 7 + (null == getString() ? 0 : 31 * getString().hashCode());
	}

	/**
	 * Sets the expression.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param expression
	 *            the expression.
	 * @exception ExpressionException
	 *                if there is a problem with the expression.
	 * @since V0.1 April 25, 2005
	 * @version Dec 4, 2007
	 */
	public final void setExpression(final Expression expression) {
		this.expression = expression;
		parseVariables();
	}

	/**
	 * Sets the string used to define the expression.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param string
	 *            the string.
	 * @exception ExpressionException
	 *                if there is a problem parsing the expression.
	 * @since V0.1 July 18, 2005
	 * @version V2.2.0 Oct 18, 2014
	 */
	public final void setString(final String string) {
		this.string = string;

		try {
			setExpression(jexlEngine.createExpression(string));
		} catch (final java.lang.Exception e) {
			throw new ExpressionException("Failed to create comparator for " + string + ".", e);
		}
	}

	/**
	 * Sets the map of variable values.
	 *
	 * @author Ian Andrew Brown
	 * @param vars
	 *            the variables.
	 * @since V0.1 March 18, 2005
	 * @version June 13, 2007
	 */
	public final void setVars(final Map<String, Object> vars) {
		this.vars = vars;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		final StringBuffer stringBuffer = new StringBuffer(getClass().getSimpleName());
		stringBuffer.append(": ").append(null == getExpression() ? "null" : getExpression().getExpression()).append(" from ")
				.append(getString()).append(' ').append(getVars());

		return stringBuffer.toString();
	}

	/**
	 * Gets the variables from the expression.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @return the variables.
	 * @since V0.1.6 Jul 28, 2007
	 * @version Jul 28, 2007
	 */
	protected final List<String> getVariables() {
		return variables;
	}

	/**
	 * Convert the input AST reference node to variables.
	 * <p>
	 *
	 * @param variable
	 *            the variable value.
	 * @since V0.1 April 25, 2005
	 * @version Aug 20, 2007
	 */
	private final void astReferenceNodeToVariables(final String variable) {
		if (null != variable) {
			final int dot = variable.indexOf('.');
			if (!"agr".equals(variable)) {
				if (-1 == dot) {
					getVariables().add(variable);
				} else {
					getVariables().add(variable.substring(0, dot));
				}
			}
		}
	}

	/**
	 * Gets the variable from the input node.
	 * <p>
	 *
	 * @param node
	 *            the node.
	 * @return the variable.
	 * @since V0.1 April 25, 2005
	 * @version July 28, 2007
	 */
	private final String getVariableFromNode(final Node node) {
		String variable = null;

		for (int idx = 0; idx < node.jjtGetNumChildren(); ++idx) {
			final Node childNode = node.jjtGetChild(idx);
			final String lowerVariable = nodeToVariables(childNode);
			if (variable == null) {
				variable = lowerVariable;
			}
		}

		return variable;
	}

	/**
	 * Extracts the variable names out of the input node.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param node
	 *            the JEXL node.
	 * @return the variable name being built.
	 * @since V0.1 April 25, 2005
	 * @version V2.2.0 Oct 18, 2014
	 */
	private final String nodeToVariables(final Node node) {
		String variableR = null;
		final String variable = getVariableFromNode(node);

		if (node instanceof ASTReference) {
			astReferenceNodeToVariables(variable);
		} else if (!(node instanceof ASTMethodNode) && node instanceof ASTIdentifier) {
			final StringBuffer variableBuffer = new StringBuffer(((ASTIdentifier) node).image);
			if (null != variable) {
				variableBuffer.append(variable);
			}
			variableR = variableBuffer.toString();
		} else {
			final StringBuffer variableBuffer = new StringBuffer();
			for (int i = 0; i < node.jjtGetNumChildren(); ++i) {
				variableBuffer.append(nodeToVariables(node.jjtGetChild(i)));
			}
			variableR = variableBuffer.toString();
		}

		return variableR;
	}

	/**
	 * Parses the variable names out of the expression.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @exception ExpressionException
	 *                if there is a problem with the expression.
	 * @since V0.1 April 25, 2005
	 * @version V2.2.0 Oct 18, 2014
	 */
	private final void parseVariables() {
		try {
			final Parser parser = new Parser(new ParserTokenManager(new SimpleCharStream(new StringReader(getExpression()
					.getExpression()))));
			final ASTJexlScript script = parser.JexlScript();
			setVariables(new ArrayList<String>());
			nodeToVariables(script);
		} catch (final ParseException e) {
			throw new ExpressionException("Failed to parse the variables from " + getExpression().getExpression() + ".", e);
		}
	}

	/**
	 * Sets the variables from the expression.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param variables
	 *            the variables.
	 * @since V0.1.6 Jul 28, 2007
	 * @version Jul 28, 2007
	 */
	private final void setVariables(final List<String> variables) {
		this.variables = variables;
	}
}