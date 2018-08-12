package usa.browntrask.utility.tables;

/**
 * Exception thrown if a name is not a legal one.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.1 Nov 27, 2007
 * @version Jul 26, 2018
 */
public final class IllegalNameException extends IllegalArgumentException {

    /**
     * the serial version UID for the class.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.1 Nov 27, 2007
     * @version Nov 27, 2007
     */
    private static final long serialVersionUID = 2L;

    /**
     * Constructs an illegal name exception with the specified detail message.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @param message
     *                the detail message.
     * @since V0.1.1 Nov 27, 2007
     * @version Nov 27, 2007
     */
    public IllegalNameException(final String message) {
	super(message);
    }
}
