package usa.browntrask.utility;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Helper class providing methods for processing throwables.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.6 Aug 12, 2007
 * @version V2.2.0 Oct 24, 2014
 */
public final class ThrowableHelper {

	/**
	 * Builds a string containing the traceback for the throwable.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param throwable
	 *            the throwable.
	 * @return the traceback string.
	 * @since V0.1.6 Aug 12, 2007
	 * @version V2.2.0 Oct 24, 2014
	 */
	public final String buildTraceback(final Throwable throwable) {
		final StringWriter stringWriter = new StringWriter();
		final PrintWriter printWriter = new PrintWriter(stringWriter);
		throwable.printStackTrace(printWriter);
		printWriter.flush();
		final String traceback = stringWriter.toString();
		try {
			stringWriter.close();
		} catch (final IOException e1) {
		}
		printWriter.close();
		return traceback;
	}

}
