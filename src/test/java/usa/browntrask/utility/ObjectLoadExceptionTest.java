package usa.browntrask.utility;

/**
 * Test for ObjectLoadException.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.7 Aug 18, 2007
 * @version Mar 8, 2008
 */
public final class ObjectLoadExceptionTest extends
	AbstractExceptionHandler<ObjectLoadException> {

    /** {@inheritDoc} */
    @Override
    protected final ObjectLoadException createInstance() {
	return new ObjectLoadException();
    }

    /** {@inheritDoc} */
    @Override
    protected final ObjectLoadException createInstance(final String message) {
	return new ObjectLoadException(message);
    }

    /** {@inheritDoc} */
    @Override
    protected final ObjectLoadException createInstance(final Throwable cause) {
	return new ObjectLoadException(cause);
    }

    /** {@inheritDoc} */
    @Override
    protected final ObjectLoadException createInstance(final String message,
	    final Throwable cause) {
	return new ObjectLoadException(message, cause);
    }
}
