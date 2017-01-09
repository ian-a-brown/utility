/*
 * Copyright 2008, 2009 Ian Brown All Rights Reserved
 *
 * Permission is granted to use and distribute this software so long as this copyright message is maintained. This software is
 * provided without a warranty or guarantee of any kind.
 */
package usa.browntrask.test;

import static org.junit.Assert.assertTrue;

/**
 * Custom JUnit assertion class that adds methods that establish relationships between values (greater than, less than).
 * <p>
 *
 * @author Ian Andrew Brown
 * @since V0.8.0 Oct 6, 2008
 * @version V2.2.0 Oct 24, 2014
 */
public final class Assert {

	/**
	 * Assertion to check that the <code>greater</code> value is greater than the <code>lesser</code> value.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param lesser
	 *            the value that should be the lesser one.
	 * @param greater
	 *            the value that should be the greater one.
	 * @since V1.0.0 Nov 11, 2009
	 * @version Nov 11, 2009
	 */
	public final static void assertGreaterThan(final double lesser, final double greater) {
		assertGreaterThan("", lesser, greater);
	}

	/**
	 * Assertion to check that the <code>greater</code> value is greater than the <code>lesser</code> value.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param lesser
	 *            the value that should be the lesser one.
	 * @param greater
	 *            the value that should be the greater one.
	 * @since V0.8.0 Oct 6, 2008
	 * @version Nov 11, 2009
	 */
	public final static void assertGreaterThan(final int lesser, final int greater) {
		assertGreaterThan("", lesser, greater);
	}

	/**
	 * Assertion to check that the <code>greater</code> value is greater than the <code>lesser</code> value with a message.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param message
	 *            the message explaining the reason for the assertion.
	 * @param lesser
	 *            the value that should be the lesser one.
	 * @param greater
	 *            the value that should be the greater one.
	 * @since V1.0.0 Nov 11, 2009
	 * @version Nov 11, 2009
	 */
	public static void assertGreaterThan(final String message, final double lesser, final double greater) {
		final double difference = greater - lesser;

		assertTrue(message + " lesser: " + lesser + ", greater: " + greater, difference > 0);
	}

	/**
	 * Assertion to check that the <code>greater</code> value is greater than the <code>lesser</code> value with a message.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param message
	 *            the message explaining the reason for the assertion.
	 * @param lesser
	 *            the value that should be the lesser one.
	 * @param greater
	 *            the value that should be the greater one.
	 * @since V0.8.0 Oct 6, 2008
	 * @version Nov 11, 2009
	 */
	public final static void assertGreaterThan(final String message, final int lesser, final int greater) {
		final long difference = greater - lesser;
		final String prefix = message == null ? "" : message + "; ";

		assertTrue(prefix + "lesser: " + lesser + ", greater: " + greater, difference > 0);
	}

	/**
	 * Assertion to check that the <code>lesser</code> value is less than the <code>greater</code> value.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param greater
	 *            the value that should be the greater one.
	 * @param lesser
	 *            the value that should be the lesser one.
	 * @since V1.0.0 Nov 11, 2009
	 * @version Nov 11, 2009
	 */
	public final static void assertLessThan(final double greater, final double lesser) {
		assertLessThan("", greater, lesser);
	}

	/**
	 * Assertion to check that the <code>lesser</code> value is less than the <code>greater</code> value.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param greater
	 *            the value that should be the greater one.
	 * @param lesser
	 *            the value that should be the lesser one.
	 * @since V0.8.0 Oct 6, 2008
	 * @version Nov 11, 2009
	 */
	public final static void assertLessThan(final int greater, final int lesser) {
		assertLessThan("", greater, lesser);
	}

	/**
	 * Assertion to check that the <code>lesser</code> value is less than the <code>greater</code> value with a message.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param message
	 *            the message explaining the reason for the assertion.
	 * @param greater
	 *            the value that should be the greater one.
	 * @param lesser
	 *            the value that should be the lesser one.
	 * @since V1.0.0 Nov 11, 2009
	 * @version Nov 11, 2009
	 */
	public final static void assertLessThan(final String message, final double greater, final double lesser) {
		final double difference = lesser - greater;
		final String prefix = message == null ? "" : message + "; ";

		assertTrue(prefix + "greater: " + greater + ", lesser: " + lesser, difference < 0);
	}

	/**
	 * Assertion to check that the <code>lesser</code> value is less than the <code>greater</code> value with a message.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param message
	 *            the message explaining the reason for the assertion.
	 * @param greater
	 *            the value that should be the greater one.
	 * @param lesser
	 *            the value that should be the lesser one.
	 * @since V0.8.0 Oct 6, 2008
	 * @version Nov 11, 2009
	 */
	public final static void assertLessThan(final String message, final int greater, final int lesser) {
		final long difference = lesser - greater;
		final String prefix = message == null ? "" : message + "; ";

		assertTrue(prefix + "greater: " + greater + ", lesser: " + lesser, difference < 0);
	}

	/**
	 * Assertion to check that the boolean <code>actual</code> value equals the <code>expected</code> one.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param expected
	 *            the expected value.
	 * @param actual
	 *            the actual value.
	 * @since V2.2.0 Oct 24, 2014
	 * @version V2.2.0 Oct 24, 2014
	 */
	public final static void assertNotEquals(final boolean expected, final boolean actual) {
		assertNotEquals("", expected, actual);
	}

	/**
	 * Custom assertion to check for the inequality (within a delta) of two double values.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param expected
	 *            the (not) expected value.
	 * @param actual
	 *            the actual value.
	 * @param delta
	 *            the delta value.
	 * @since V0.9.1 Jun 21, 2008
	 * @version Nov 14, 2008
	 */
	public final static void assertNotEquals(final double expected, final double actual, final double delta) {
		assertNotEquals("", expected, actual, delta);
	}

	/**
	 * Custom assertion to check for the inequality of two long values.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param expected
	 *            the (not) expected value.
	 * @param actual
	 *            the actual value.
	 * @since V0.9.1 Jun 21, 2008
	 * @version Nov 14, 2008
	 */
	public final static void assertNotEquals(final long expected, final long actual) {
		assertNotEquals("", expected, actual);
	}

	/**
	 * Custom assertion to check for inequality of two object values.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param expected
	 *            the (not) expected value.
	 * @param actual
	 *            the actual value.
	 * @since V0.9.1 Jun 21, 2008
	 * @version Nov 14, 2008
	 */
	public final static void assertNotEquals(final Object expected, final Object actual) {
		assertNotEquals("", expected, actual);
	}

	/**
	 * Assertion to check that the boolean <code>actual</code> value equals the <code>expected</code> one.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param message
	 *            the message.
	 * @param expected
	 *            the expected value.
	 * @param actual
	 *            the actual value.
	 * @since V2.2.0 Oct 24, 2014
	 * @version V2.2.0 Oct 24, 2014
	 */
	public final static void assertNotEquals(final String message, final boolean expected, final boolean actual) {
		assertTrue(message + "; Expected " + expected + ", Actual: " + actual, expected != actual);
	}

	/**
	 * Custom assertion to check for the inequality (within a delta) of two double values.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param message
	 *            the message produced if the assertion fails.
	 * @param expected
	 *            the (not) expected value.
	 * @param actual
	 *            the actual value.
	 * @param delta
	 *            the delta value.
	 * @since V0.9.1 Jun 21, 2008
	 * @version Nov 14, 2008
	 */
	public final static void assertNotEquals(final String message, final double expected, final double actual, final double delta) {
		if (!(Math.abs(expected - actual) <= delta)) {
			return;
		}
		failEquals(message, Double.valueOf(expected), Double.valueOf(actual));
	}

	/**
	 * Custom assertion to check for the inequality of two long values.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param message
	 *            the message produced if the assertion fails.
	 * @param expected
	 *            the (not) expected value.
	 * @param actual
	 *            the actual value.
	 * @since V0.9.1 Jun 21, 2008
	 * @version Nov 14, 2008
	 */
	public final static void assertNotEquals(final String message, final long expected, final long actual) {
		assertNotEquals(message, Long.valueOf(expected), Long.valueOf(actual));
	}

	/**
	 * Custom assertion to check for the inequality of two object values.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param message
	 *            the message produced if the assertion fails.
	 * @param expected
	 *            the (not) expected value.
	 * @param actual
	 *            the actual value.
	 * @since V0.9.1 Jun 21, 2008
	 * @version Nov 14, 2008
	 */
	public final static void assertNotEquals(final String message, final Object expected, final Object actual) {
		if (expected == null) {
			if (actual != null) {
				return;
			}
		} else if (!expected.equals(actual)) {
			return;
		}

		failEquals(message, expected, actual);
	}

	/**
	 * Formats a detail message from the input message, and the expected and actual values.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param message
	 *            the message to produce.
	 * @param expected
	 *            the (not) expected value.
	 * @param actual
	 *            the actual value.
	 * @return the formatted detail message.
	 * @since V0.9.1 Jun 21, 2008
	 * @version Nov 14, 2008
	 */
	final static String format(final String message, final Object expected, final Object actual) {
		String formatted = "";
		if (message != null && !message.equals("")) {
			formatted = message + " ";
		}
		final String expectedString = String.valueOf(expected);
		final String actualString = String.valueOf(actual);
		if (expectedString.equals(actualString)) {
			String expectations = formatted + "unexpected: ";
			if (expected == null) {
				expectations += "<null>";
			} else {
				expectations += expected.getClass().getName() + "<" + expectedString + ">";
			}
			expectations += ", but was: ";
			if (actual == null) {
				expectations += "<null>";
			} else {
				expectations += actual.getClass().getName() + "<" + actualString + ">";
			}
			return expectations;
		} else {
			return formatted + "unexpected:<" + expectedString + "> but was:<" + actualString + ">";
		}
	}

	/**
	 * Fail if two values are equal.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param message
	 *            the message to produce.
	 * @param expected
	 *            the (not) expected value.
	 * @param actual
	 *            the actual value.
	 * @since V0.9.1 Jun 21, 2008
	 * @version Nov 14, 2008
	 */
	final static private void failEquals(final String message, final Object expected, final Object actual) {
		org.junit.Assert.fail(format(message, expected, actual));
	}

	/**
	 * Private constructor - this class should not be instantiated.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	// /CLOVER:OFF
	private Assert() {
		throw new UnsupportedOperationException("Class should not be instantiated");
	}
	// /CLOVER:ON
}
