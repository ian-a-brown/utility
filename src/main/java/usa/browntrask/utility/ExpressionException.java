/**
 * 
 */
package usa.browntrask.utility;

/**
 * Represents an exception with an expression for a comparator.
 * <p>
 * 
 * @author IanBrown
 * 
 * @since V0.1.1 November 27, 2006
 * @version Dec 27, 2007
 */
public final class ExpressionException extends IllegalArgumentException {

    /**
     * the serial version ID for this class.
     * <p>
     */
    private static final long serialVersionUID = 1766105449536082548L;

    /**
     * Creates an expression exception.
     * <p>
     * 
     * @since V0.1.1 November 27, 2006
     * @version November 27, 2006
     */
    public ExpressionException() {
	super();
    }

    /**
     * Creates an expression exception with the input detail message.
     * <p>
     * 
     * @param message
     *                the detail message.
     * @since V0.1.1 November 27, 2006
     * @version Dec 27, 2007
     */
    public ExpressionException(final String message) {
	super(message);
    }

    /**
     * Creates an expression exception wrapping the input cause.
     * <p>
     * 
     * @param cause
     *                the throwable that caused this exception.
     * @since V0.1.1 November 27, 2006
     * @version Dec 27, 2007
     */
    public ExpressionException(final Throwable cause) {
	super(cause);
    }

    /**
     * Creates an expression exception wrapping the input cause with the
     * specified detail message.
     * 
     * @param message
     *                the detail message.
     * @param cause
     *                the throwable that caused this exception.
     * @since V0.1.1 November 27, 2006
     * @version Dec 27, 2007
     */
    public ExpressionException(final String message, final Throwable cause) {
	super(message, cause);
    }

}
