package usa.browntrask.utility.tables;


/**
 * Exception thrown if there is a problem loading a file via JAXB.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.11. Feb 2, 2008
 * @version Jul 26, 2018
 */
public final class JAXBLoaderException extends IllegalStateException {

    /**
     * Constructs a JAXB loader exception with the specified message and cause.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @param message the detail message.
     * @param cause the cause of the exception.
     * @since V0.1.1 Feb 2, 2008
     * @version Jul 26, 2018
     */
    public JAXBLoaderException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * the serial version UID for the class.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.1 Feb 2, 2008
     * @version Jul 26, 2018
     */
    private static final long serialVersionUID = 2L;
}
