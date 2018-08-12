package usa.browntrask.utility.tables;

/**
 * Extended IllegalArgumentException thrown when a table is not a legal one.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.1 Nov 10, 2007
 * @version jul 26, 2018
 */
public final class IllegalTableException extends IllegalArgumentException {

    /**
     * the serial version UID for the class.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.1 Nov 10, 2007
     * @version Jan 31, 2008
     */
    private static final long serialVersionUID = 2L;

    /**
     * Constructs an IllegalTableException with the specified message..
     * <p>
     * 
     * @author Ian Andrew Brown
     * @param message the detail message.
     * @since V0.1.1 Nov 10, 2007
     * @version Nov 10, 2007
     */
    public IllegalTableException(final String message) {

        super(message);
    }

    /**
     * Constructs an IllegalTableException with the specified message and underlying cause.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @param message the detail message.
     * @param cause the cause of the exception.
     * @since V0.1.1 Jan 31, 2008
     * @version Jan 31, 2008
     */
    public IllegalTableException(final String message, final Throwable cause) {

        super(message, cause);
    }
}
