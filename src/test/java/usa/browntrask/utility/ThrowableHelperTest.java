package usa.browntrask.utility;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test class for the ThrowableHelper.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.6 Aug 12, 2007
 * @version V2.2.0 Oct 24, 2014
 */
public final class ThrowableHelperTest {

    /**
     * Test method for
     * {@link usa.browntrask.utility.ThrowableHelper#buildTraceback(java.lang.Throwable)}.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.6 Aug 12, 2007
     * @version Mar 8, 2008
     */
    @Test
    public final void testBuildTraceback() {
	final Exception exception = new IllegalArgumentException(
		"Test exception");
	exception.fillInStackTrace();

	final String traceback = (new ThrowableHelper())
		.buildTraceback(exception);
	assertNotNull("Traceback created", traceback);
	assertTrue("Traceback is for exception", traceback
		.contains("Test exception"));
    }

}
