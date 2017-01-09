/**
 * 
 */
package usa.browntrask.utility;

/**
 * Represents an exception with a match for a comparator.
 * <p>
 * 
 * @author IanBrown
 * 
 * @since V0.1.1 November 27, 2006
 * @version Dec 27, 2007
 */
public final class MatchException extends IllegalStateException {

    /**
     * the serial version ID for this class.
     * <p>
     */
    private static final long serialVersionUID = 1766105449536082546L;

    /**
     * Creates a match exception.
     * <p>
     * 
     * @since V0.1.1 November 27, 2006
     * @version November 27, 2006
     */
    public MatchException() {
	super();
    }

    /**
     * Creates a match exception with the input detail message.
     * <p>
     * 
     * @param message
     *                the detail message.
     * @since V0.1.1 November 27, 2006
     * @version Dec 27, 2007
     */
    public MatchException(final String message) {
	super(message);
    }

    /**
     * Creates a match exception wrapping the input cause.
     * <p>
     * 
     * @param cause
     *                the throwable that caused this exception.
     * @since V0.1.1 November 27, 2006
     * @version Dec 27, 2007
     */
    public MatchException(final Throwable cause) {
	super(cause);
    }

    /**
     * Creates a match exception wrapping the input cause with the specified
     * detail message.
     * 
     * @param message
     *                the detail message.
     * @param cause
     *                the throwable that caused this exception.
     * @since V0.1.1 November 27, 2006
     * @version Dec 27, 2007
     */
    public MatchException(final String message, final Throwable cause) {
	super(message, cause);
    }

}
