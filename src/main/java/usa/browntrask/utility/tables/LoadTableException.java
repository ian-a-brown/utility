package usa.browntrask.utility.tables;


/**
 * Exception thrown when there is a problem loading a table.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.1 Feb 2, 2008
 * @version Jul 26, 2018
 */
public final class LoadTableException extends IllegalArgumentException {

    /**
     * the serial version UID.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.1 Feb 2, 2008
     * @version Jul 26, 2018
     */
    private static final long serialVersionUID = 2L;

    /**
     * Constructs a load table exception with the specified message.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @param message the detail message.
     * @since V0.1.1 Feb 2, 2008
     * @version Jul 26, 2019
     */
    public LoadTableException(final String message) {
        super(message);
    }

    /**
     * Constructs a load table exception with the specified message and cause.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @param message the detail message.
     * @param cause the cause of the exception.
     * @since V0.1.1 Feb 2, 2008
     * @version Jul 26, 2018
     */
    public LoadTableException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
