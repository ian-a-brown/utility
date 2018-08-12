package usa.browntrask.utility.tables;

/**
 * Exception thrown when there is a problem with a searchable object provided to a finder.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.1 May 2, 2008
 * @version Jul 26, 2018
 */
public final class IllegalSearchableObjectException extends IllegalArgumentException {

    /**
     * Constructs an illegal searchable object exception with the specified detail message.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @param message the detail message.
     * @since V0.1.1 May 2, 2008
     * @version May 2, 2008
     */
    public IllegalSearchableObjectException(final String message) {

        super(message);
    }

    /**
     * the serial version UID for the class.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.1 May 2, 2008
     * @version May 2, 2008
     */
    private static final long serialVersionUID = 1L;

}
