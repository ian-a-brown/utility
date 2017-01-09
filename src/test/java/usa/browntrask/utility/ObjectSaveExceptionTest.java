package usa.browntrask.utility;

/**
 * Test for ObjectSaveException.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.7 Aug 18, 2007
 * @version Mar 8, 2008
 */
public final class ObjectSaveExceptionTest extends
	AbstractExceptionHandler<ObjectSaveException> {

    /** {@inheritDoc} */
    @Override
    protected final ObjectSaveException createInstance() {
	return new ObjectSaveException();
    }

    /** {@inheritDoc} */
    @Override
    protected final ObjectSaveException createInstance(final String message) {
	return new ObjectSaveException(message);
    }

    /** {@inheritDoc} */
    @Override
    protected final ObjectSaveException createInstance(final Throwable cause) {
	return new ObjectSaveException(cause);
    }

    /** {@inheritDoc} */
    @Override
    protected final ObjectSaveException createInstance(final String message,
	    final Throwable cause) {
	return new ObjectSaveException(message, cause);
    }
}
