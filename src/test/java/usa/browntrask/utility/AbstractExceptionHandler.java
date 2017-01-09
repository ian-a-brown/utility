package usa.browntrask.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Abstract class for testing exceptions.
 * <p>
 * 
 * @param <E>
 *                the type of exception.
 * @author Ian Andrew Brown
 * @since V0.1.11 Sep 25, 2007
 * @version V2.2.0 Oct 24, 2014
 */
public abstract class AbstractExceptionHandler<E extends Exception> {

    /**
     * the detail message for testing.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.6 Aug 26, 2007
     * @version Aug 26, 2007
     */
    private static final String MESSAGE = "message";

    /**
     * an exception cause for testing.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.6 Aug 26, 2007
     * @version Aug 26, 2007
     */
    private static final Throwable CAUSE = new IllegalStateException("Cause");

    /**
     * Test method for the no-arg constructor of the exception class.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.6 Aug 27, 2007
     * @version Sep 21, 2007
     */
    @Test
    public final void testConstructor() {
	assertNotNull("Constructed", createInstance());
    }

    /**
     * Test method for the detail message constructor of the exception class.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.6 Aug 27, 2007
     * @version Sep 21, 2007
     */
    @Test
    public final void testConstructorString() {
	assertEquals("Message set", MESSAGE, createInstance(MESSAGE)
		.getMessage());
    }

    /**
     * Test method for the throwable cause constructor of the exception class.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.6 Aug 27, 2007
     * @version Aug 27, 2007
     */
    @Test
    public final void testConstructorThrowable() {
	assertEquals("Cause set", CAUSE, createInstance(CAUSE).getCause());
    }

    /**
     * Test method for the detail message and throwable cause constructor of the
     * exception class.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.6 Aug 27, 2007
     * @version Aug 27, 2007
     */
    @Test
    public final void testConstructorStringThrowable() {
	final E exception = createInstance(MESSAGE, CAUSE);

	assertEquals("Message set", MESSAGE, exception.getMessage());
	assertEquals("Cause set", CAUSE, exception.getCause());
    }

    /**
     * Creates the exception using the no-arg constructor.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @return the exception.
     * @since V0.1.6 Aug 27, 2007
     * @version Aug 27, 2007
     */
    protected abstract E createInstance();

    /**
     * Creates the exception using the detail message constructor.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @param message
     *                the detail message.
     * @return the exception.
     * @since V0.1.6 Aug 27, 2007
     * @version Aug 27, 2007
     */
    protected abstract E createInstance(final String message);

    /**
     * Creates the exception using the throwable cause constructor.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @param cause
     *                the throwable cause of the exception.
     * @return the exception.
     * @since V0.1.6 Aug 27, 2007
     * @version Aug 27, 2007
     */
    protected abstract E createInstance(final Throwable cause);

    /**
     * Creates the exception using the detail message and throwable cause
     * constructor.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @param message
     *                the detail message.
     * @param cause
     *                the throwable cause.
     * @return the exception.
     * @since V0.1.6 Aug 27, 2007
     * @version Aug 27, 2007
     */
    protected abstract E createInstance(final String message,
	    final Throwable cause);

}
