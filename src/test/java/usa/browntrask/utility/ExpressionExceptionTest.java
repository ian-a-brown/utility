package usa.browntrask.utility;

/**
 * Test for ExpressionException.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.7 Aug 18, 2007
 * @version Mar 8, 2008
 */
public final class ExpressionExceptionTest extends
	AbstractExceptionHandler<ExpressionException> {

    /** {@inheritDoc} */
    @Override
    protected final ExpressionException createInstance() {
	return new ExpressionException();
    }

    /** {@inheritDoc} */
    @Override
    protected final ExpressionException createInstance(final String message) {
	return new ExpressionException(message);
    }

    /** {@inheritDoc} */
    @Override
    protected final ExpressionException createInstance(final Throwable cause) {
	return new ExpressionException(cause);
    }

    /** {@inheritDoc} */
    @Override
    protected final ExpressionException createInstance(final String message,
	    final Throwable cause) {
	return new ExpressionException(message, cause);
    }
}
