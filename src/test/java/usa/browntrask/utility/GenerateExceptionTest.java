package usa.browntrask.utility;

/**
 * Test for GenerateException.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.7 Aug 18, 2007
 * @version Mar 8, 2008
 */
public final class GenerateExceptionTest extends
	AbstractExceptionHandler<GenerateException> {

    /** {@inheritDoc} */
    @Override
    protected final GenerateException createInstance() {
	return new GenerateException();
    }

    /** {@inheritDoc} */
    @Override
    protected final GenerateException createInstance(final String message) {
	return new GenerateException(message);
    }

    /** {@inheritDoc} */
    @Override
    protected final GenerateException createInstance(final Throwable cause) {
	return new GenerateException(cause);
    }

    /** {@inheritDoc} */
    @Override
    protected final GenerateException createInstance(final String message,
	    final Throwable cause) {
	return new GenerateException(message, cause);
    }
}
