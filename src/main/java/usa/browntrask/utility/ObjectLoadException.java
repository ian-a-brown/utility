/**
 * 
 */
package usa.browntrask.utility;

import java.io.IOException;

/**
 * Represents an exception when loading an object.
 * <p>
 * 
 * @author IanBrown
 * 
 * @since V0.1.1 November 27, 2006
 * @version Dec 4, 2006
 */
public final class ObjectLoadException extends IOException {

    /**
     * the serial version ID for this class.
     * <p>
     */
    private static final long serialVersionUID = 1766105449536082547L;

    /**
     * Creates an object load exception.
     * <p>
     * 
     * @since V0.1.1 November 27, 2006
     * @version November 27, 2006
     */
    public ObjectLoadException() {
	super();
    }

    /**
     * Creates an object load exception with the input detail message.
     * <p>
     * 
     * @param message
     *                the detail message.
     * @since V0.1.1 November 27, 2006
     * @version November 27, 2006
     */
    public ObjectLoadException(String message) {
	super(message);
    }

    /**
     * Creates an object load exception wrapping the input cause.
     * <p>
     * 
     * @param cause
     *                the throwable that caused this exception.
     * @since V0.1.1 November 27, 2006
     * @version November 27, 2006
     */
    public ObjectLoadException(Throwable cause) {
	super(cause);
    }

    /**
     * Creates an object load exception wrapping the input cause with the
     * specified detail message.
     * 
     * @param message
     *                the detail message.
     * @param cause
     *                the throwable that caused this exception.
     * @since V0.1.1 November 27, 2006
     * @version November 27, 2006
     */
    public ObjectLoadException(String message, Throwable cause) {
	super(message, cause);
    }

}
