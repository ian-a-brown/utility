package usa.browntrask.utility;

import java.io.Serializable;
import java.util.Map;

import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.MapContext;

/**
 * Extended AbstractExpressionHandler that generates a value using the supplied equation.
 * <p>
 *
 * @param <O>
 *            the type of object from which generate the value.
 * @param <V>
 *            the type of value to generate.
 * @author Ian Andrew Brown
 * @since V0.1.6 Jul 28, 2007
 * @version V2.4.0 Aug 11, 2018
 */
public final class ValueGenerator<O extends Serializable, V extends Serializable> extends AbstractExpressionHandler {

	/**
	 * Helper class to provide math functions.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.5.0 Dec 27, 2007
	 * @version June 10, 2008
	 */
	public static final class MathHelper {

		/**
		 * Returns the smallest integer value greater than or equal to the input value.
		 * <p>
		 *
		 * @author Ian Andrew Brown
		 * @param value
		 *            the value.
		 * @return the ceiling of the value.
		 * @since V0.6.0 Jun 10, 2008
		 * @version Jun 10, 2008
		 */
		public final int ceil(final double value) {
			return (int) Math.ceil(value);
		}

		/**
		 * Returns the largest integer value less than or equal to the input value.
		 * <p>
		 *
		 * @author Ian Andrew Brown
		 * @param value
		 *            the value.
		 * @return the floor of the value.
		 * @since V0.6.0 Jun 10, 2008
		 * @version Jun 10, 2008
		 */
		public final int floor(final double value) {
			return (int) Math.floor(value);
		}

		/**
		 * Returns the maximum of the two input values.
		 * <p>
		 *
		 * @author Ian Andrew Brown
		 * @param first
		 *            the first value.
		 * @param second
		 *            the second value.
		 * @return the minimum of the two values.
		 * @since V0.5.0 Dec 27, 2007
		 * @version Dec 27, 2007
		 */
		public final double max(final double first, final double second) {
			return Math.max(first, second);
		}

		/**
		 * Returns the maximum of the two input values.
		 * <p>
		 *
		 * @author Ian Andrew Brown
		 * @param first
		 *            the first value.
		 * @param second
		 *            the second value.
		 * @return the minimum of the two values.
		 * @since V0.5.0 Dec 27, 2007
		 * @version Dec 27, 2007
		 */
		public final int max(final int first, final int second) {
			return Math.max(first, second);
		}

		/**
		 * Returns the minimum of the two input values.
		 * <p>
		 *
		 * @author Ian Andrew Brown
		 * @param first
		 *            the first value.
		 * @param second
		 *            the second value.
		 * @return the minimum of the two values.
		 * @since V0.5.0 Dec 27, 2007
		 * @version Dec 27, 2007
		 */
		public final double min(final double first, final double second) {
			return Math.min(first, second);
		}

		/**
		 * Returns the minimum of the two input values.
		 * <p>
		 *
		 * @author Ian Andrew Brown
		 * @param first
		 *            the first value.
		 * @param second
		 *            the second value.
		 * @return the minimum of the two values.
		 * @since V0.5.0 Dec 27, 2007
		 * @version Dec 27, 2007
		 */
		public final int min(final int first, final int second) {
			return Math.min(first, second);
		}
	}

	/**
	 * Builds a <code>ValueGenerator</code>.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Jul 28, 2007
	 * @version Jul 28, 2007
	 */
	public ValueGenerator() {
		super();
	}

	/**
	 * Builds a <code>ValueGenerator</code> from the input string.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param string
	 *            the string.
	 * @exception ExpressionException
	 *                if there is a problem parsing the expression.
	 * @since V0.1.6 Jul 28, 2007
	 * @version Dec 4, 2007
	 */
	public ValueGenerator(final String string) {
		super(string);
	}

	/** {@inheritDoc} */
	@Override
	public final boolean equals(final Object object) {
		final boolean equalsR;

		if (object instanceof ValueGenerator<?, ?>) {
			equalsR = super.equals(object);
		} else {
			equalsR = false;
		}

		return equalsR;
	}

	/**
	 * Generates a value based on the input object.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param objectName
	 *            the variable name to assign to the object.
	 * @param object
	 *            the object.
	 * @return the value generated.
	 * @since V0.1.6 Jul 28, 2007
	 * @version V2.2.0 Oct 18, 2014
	 * @throws IllegalArgumentException
	 *             if there is a problem with the object name or object.
	 * @throws GenerateException
	 *             if there is a problem generating the value.
	 */
	@SuppressWarnings("unchecked")
	public final V generate(final String objectName, final O object) {
		if (null == getString()) {
			throw new IllegalStateException("Cannot generate a value without a generator string");
		}
		if (null == objectName) {
			throw new IllegalArgumentException("Cannot generate a value without an object name");
		}
		if (null == object) {
			throw new IllegalArgumentException("Cannot generate a value without an object");
		}
		final JexlContext context = new MapContext();

		final MathHelper math = new MathHelper();

		context.set(objectName, object);
		context.set("math", math);
		if (null != getVars()) {
			for (final Map.Entry<String, Object> varEntry : getVars().entrySet()) {
				context.set(varEntry.getKey(), varEntry.getValue());
			}
		}

		try {
			return (V) getExpression().evaluate(context);
		} catch (final java.lang.Exception e) {
			throw new GenerateException("Failed to get value for " + objectName, e);
		}

	}

	/** {@inheritDoc} */
	@Override
	public final int hashCode() {
		return 7 + 31 * super.hashCode() + 31 * ValueGenerator.class.hashCode();
	}
}
