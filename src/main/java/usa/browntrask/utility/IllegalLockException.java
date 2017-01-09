package usa.browntrask.utility;

/**
 * Extended illegal state exception thrown on an attempt to obtain a write lock without the edit lock from a single
 * editor lock.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.1 Dec 1, 2007
 * @version Dec 1, 2007
 */
public final class IllegalLockException extends IllegalStateException {

    /**
     * the serial version UID for the class.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.1 Dec 1, 2007
     * @version Dec 1, 2007
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs an illegal lock exception specifying a detail message.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @param message the detail message.
     * @since V0.1.1 Dec 1, 2007
     * @version Dec 1, 2007
     */
    public IllegalLockException(final String message) {

        super(message);
    }
}
