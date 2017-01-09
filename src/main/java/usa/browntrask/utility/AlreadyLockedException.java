package usa.browntrask.utility;

/**
 * An extended illegal state exception thrown when a caller is unable to obtain a single editor lock because someone
 * already has it.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.1 Dec 1, 2007
 * @version Dec 1, 2007
 */
public final class AlreadyLockedException extends IllegalStateException {

    /**
     * the serial version UID of the class.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.1 Dec 1, 2007
     * @version Dec 1, 2007
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs an already locked exception with the specified detail message.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @param message the detail message.
     * @since V0.1.1 Dec 1, 2007
     * @version Dec 1, 2007
     */
    public AlreadyLockedException(final String message) {

        super(message);
    }
}
