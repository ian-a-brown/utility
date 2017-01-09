/**
 * 
 */
package usa.browntrask.utility;

import java.io.IOException;

/**
 * Represents an exception when saving an object.
 * <p>
 * 
 * @author IanBrown
 * 
 * @since V0.1.1 November 27, 2006
 * @version Dec 4, 2006
 */
public final class ObjectSaveException extends IOException {

    /**
     * the serial version ID for this class.
     * <p>
     */
    private static final long serialVersionUID = 1766105449536082547L;

    /**
     * Creates an object save exception.
     * <p>
     * 
     * @since V0.1.1 November 27, 2006
     * @version November 27, 2006
     */
    public ObjectSaveException() {
	super();
    }

    /**
     * Creates an object save exception with the input detail message.
     * <p>
     * 
     * @param message
     *                the detail message.
     * @since V0.1.1 November 27, 2006
     * @version November 27, 2006
     */
    public ObjectSaveException(String message) {
	super(message);
    }

    /**
     * Creates an object save exception wrapping the input cause.
     * <p>
     * 
     * @param cause
     *                the throwable that caused this exception.
     * @since V0.1.1 November 27, 2006
     * @version November 27, 2006
     */
    public ObjectSaveException(Throwable cause) {
	super(cause);
    }

    /**
     * Creates an object save exception wrapping the input cause with the
     * specified detail message.
     * 
     * @param message
     *                the detail message.
     * @param cause
     *                the throwable that caused this exception.
     * @since V0.1.1 November 27, 2006
     * @version November 27, 2006
     */
    public ObjectSaveException(String message, Throwable cause) {
	super(message, cause);
    }

}
