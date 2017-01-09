/**
 * 
 */
package usa.browntrask.utility;

/**
 * Represents an exception with a match for a value generator.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.6 July 28, 2007
 * @version Dec 27, 2007
 */
public final class GenerateException extends IllegalStateException {

    /**
     * the serial version ID for this class.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.6 July 28, 2007
     * @version July 28, 2007
     */
    private static final long serialVersionUID = 1766105449536082546L;

    /**
     * Creates a generate exception.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.6 July 28, 2007
     * @version July 28, 2007
     * 
     */
    public GenerateException() {
	super();
    }

    /**
     * Creates a generate exception with the input detail message.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @param message
     *                the detail message.
     * @since V0.1.6 July 28, 2007
     * @version Dec 27, 2007
     * 
     */
    public GenerateException(final String message) {
	super(message);
    }

    /**
     * Creates a generate exception wrapping the input cause.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @param cause
     *                the throwable that caused this exception.
     * @since V0.1.6 July 28, 2007
     * @version Dec 27, 2007
     * 
     */
    public GenerateException(final Throwable cause) {
	super(cause);
    }

    /**
     * Creates a generate exception wrapping the input cause with the specified
     * detail message.
     * 
     * @author Ian Andrew Brown
     * @param message
     *                the detail message.
     * @param cause
     *                the throwable that caused this exception.
     * @since V0.1.6 July 28, 2007
     * @version Dec 27, 2007
     * 
     */
    public GenerateException(final String message, final Throwable cause) {
	super(message, cause);
    }

}
