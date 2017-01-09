/**
 * Copyright 2011 by Ian Andrew Brown<br>
 * All Rights Reserved
 */

package usa.browntrask.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

/**
 * Abstract test for {@link Exception} implementations.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @param <E>
 *            the type of exception to test.
 * @since V1.6.0 Mar 27, 2011
 * @version V1.7.1 Sep 25, 2011
 */
public abstract class AbstractExceptionCheck<E extends Exception> {

	/**
	 * Test method for {@link java.lang.Exception#Exception()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	@Test
	public final void testException() {
		final E actualException = createException();

		assertNotNull("An exception is created", actualException);
		assertNull("There is no detail message", actualException.getMessage());
		assertNull("There is no cause", actualException.getCause());
	}

	/**
	 * Test method for {@link java.lang.Exception#Exception(java.lang.String)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	@Test
	public final void testExceptionString() {
		final String message = Utility.nextFormattedString("Detail", "Message");

		final E actualException = createException(message);

		assertNotNull("An exception is created", actualException);
		assertEquals("The detail message is set", message, actualException.getMessage());
		assertNull("There is no cause", actualException.getCause());
	}

	/**
	 * Test method for {@link java.lang.Exception#Exception(java.lang.String, java.lang.Throwable)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	@Test
	public final void testExceptionStringThrowable() {
		final String message = Utility.nextFormattedString("Detail", "Message");
		final Throwable cause = new Throwable();

		final E actualException = createException(message, cause);

		assertNotNull("An exception is created", actualException);
		assertEquals("The detail message is set", message, actualException.getMessage());
		assertSame("The cause is set", cause, actualException.getCause());
	}

	/**
	 * Test method for {@link java.lang.Exception#Exception(java.lang.Throwable)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.7.1 Sep 25, 2011
	 */
	@Test
	public final void testExceptionThrowable() {
		final Throwable cause = new Throwable();

		final E actualException = createException(cause);

		assertNotNull("An exception is created", actualException);
		assertNotNull("There is a detail message", actualException.getMessage());
		assertSame("The cause is set", cause, actualException.getCause());
	}

	/**
	 * Creates an exception of the type to test without any parameters.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the exception.
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	protected abstract E createException();

	/**
	 * Creates an exception of the type to test with the specified detail message.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param message
	 *            the detail message.
	 * @return the exception.
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	protected abstract E createException(String message);

	/**
	 * Creates an exception of the type to test with a detail message and cause.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param message
	 *            the detail message.
	 * @param cause
	 *            the cause of the exception.
	 * @return the exception.
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	protected abstract E createException(String message, Throwable cause);

	/**
	 * Creates an exception of the type to test with a cause.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param cause
	 *            the cause of the exception.
	 * @return the exception.
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	protected abstract E createException(Throwable cause);

}
