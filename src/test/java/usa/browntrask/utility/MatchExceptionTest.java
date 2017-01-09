package usa.browntrask.utility;

/**
 * Test for MatchException.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.7 Aug 18, 2007
 * @version Mar 8, 2008
 */
public final class MatchExceptionTest extends
	AbstractExceptionHandler<MatchException> {

    /** {@inheritDoc} */
    @Override
    protected final MatchException createInstance() {
	return new MatchException();
    }

    /** {@inheritDoc} */
    @Override
    protected final MatchException createInstance(final String message) {
	return new MatchException(message);
    }

    /** {@inheritDoc} */
    @Override
    protected final MatchException createInstance(final Throwable cause) {
	return new MatchException(cause);
    }

    /** {@inheritDoc} */
    @Override
    protected final MatchException createInstance(final String message,
	    final Throwable cause) {
	return new MatchException(message, cause);
    }
}
