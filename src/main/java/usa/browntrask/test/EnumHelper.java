/**
 * Copyright 2011, 2015 by Ian Andrew Brown<br>
 * All Rights Reserved
 */
package usa.browntrask.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Helper class for testing implementations of {@link java.lang.Enum}.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @param <E>
 *            the enumerated type to test.
 * @since V1.2.0 Mar 25, 2011
 * @version V2.2.0 Nov 21, 2015
 */
public final class EnumHelper<E extends java.lang.Enum<E>> {

	/**
	 * Test method for {@link java.lang.Enum#compareTo(java.lang.Enum)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param enumeration
	 *            the enumeration to test.
	 * @param before
	 *            an enumeration that comes before the input one (may be <code>null</code>).
	 * @param after
	 *            an enumeration that comes after the input one (may be <code>null</code>).
	 * @since V1.2.0 Mar 25, 2011
	 * @version V1.2.0 Mar 25, 2011
	 */
	public final void testCompareTo(final E enumeration, final E before, final E after) {
		final boolean checkCompareTo = GenericTester.checkCompareTo(enumeration, before, after);

		assertTrue("compareTo() implements the basic contract", checkCompareTo);
	}

	/**
	 * Test method for {@link java.lang.Enum#equals(java.lang.Object)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param enumeration
	 *            the enumeration to test.
	 * @since V1.2.0 Mar 25, 2011
	 * @version V1.2.0 Mar 25, 2011
	 */
	public final void testEquals(final E enumeration) {
		final boolean checkEquals = GenericTester.checkEquals(enumeration);

		assertTrue("equals() implements the basic contract", checkEquals);
	}

	/**
	 * Test method for {@link java.lang.Enum#getDeclaringClass()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param enumeration
	 *            the enumeration to test.
	 * @param expectedDeclaringClass
	 *            the expected declaring class.
	 * @since V1.2.0 Mar 25, 2011
	 * @version V1.2.0 Mar 25, 2011
	 */
	public final void testGetDeclaringClass(final E enumeration, final Class<E> expectedDeclaringClass) {
		final Class<E> actualDeclaringClass = enumeration.getDeclaringClass();

		assertSame("The declaring class is the expected one", expectedDeclaringClass, actualDeclaringClass);
	}

	/**
	 * Test method for {@link java.lang.Enum#hashCode()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param enumeration
	 *            the enumeration to test.
	 * @since V1.2.0 Mar 25, 2011
	 * @version V1.2.0 Mar 25, 2011
	 */
	public final void testHashCode(final E enumeration) {
		final boolean checkHashCode = GenericTester.checkHashCode(enumeration);

		assertTrue("hashCode() implements the basic contract", checkHashCode);
	}

	/**
	 * Test method for {@link java.lang.Enum#name()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param enumeration
	 *            the enumeration to test.
	 * @since V1.2.0 Mar 25, 2011
	 * @version V1.2.0 Mar 25, 2011
	 */
	public final void testName(final E enumeration) {
		final String actualName = enumeration.name();

		assertNotNull("The name is set", actualName);
	}

	/**
	 * Test method for {@link java.lang.Enum#ordinal()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param enumeration
	 *            the enumeration to test.
	 * @since V1.2.0 Mar 25, 2011
	 * @version V1.2.0 Mar 25, 2011
	 */
	public final void testOrdinal(final E enumeration) {
		final int actualOrdinal = enumeration.ordinal();

		assertSame("The value for the ordinal is the enumeration", enumeration,
				findEnumerationForOrdinal(enumeration.getClass(), actualOrdinal));
	}

	/**
	 * Test method for {@link java.lang.Enum#toString()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param enumeration
	 *            the enumeration to test.
	 * @since V1.2.0 Mar 25, 2011
	 * @version V1.2.0 Mar 25, 2011
	 */
	public final void testToString(final E enumeration) {
		final boolean checkToString = GenericTester.checkToString(enumeration);

		assertTrue("toString() implements the basic contract", checkToString);
		assertEquals("toString() returns name()", enumeration.name(), enumeration.toString());
	}

	/**
	 * Test method for {@link java.lang.Enum#valueOf(Class, String)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param enumeration
	 *            the enumeration to test.
	 * @since V1.2.0 Mar 25, 2011
	 * @version V2.2.0 Nov 21, 2015
	 */
	@SuppressWarnings("javadoc")
	public final void testValueOf(final E enumeration) {
		final String name = enumeration.name();

		@SuppressWarnings("unchecked") final E actualEnumeration = (E) Enum.valueOf(enumeration.getClass(), name);

		assertSame("valueOf() returns the input enumeration", enumeration, actualEnumeration);
	}

	/**
	 * Finds the enumeration for the input ordinal.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param enumClass
	 *            the enumeration class.
	 * @param ordinal
	 *            the ordinal.
	 * @return the enumeration.
	 * @since V1.2.0 Mar 25, 2011
	 * @version V1.2.0 Mar 25, 2011
	 */
	@SuppressWarnings("unchecked")
	private final E findEnumerationForOrdinal(final Class<?> enumClass, final int ordinal) {
		try {
			final Method valuesMethod = enumClass.getMethod("values");
			return ((E[]) valuesMethod.invoke(null))[ordinal];
		} catch (final SecurityException e) {
			fail(enumClass + " does not properly implement values(): " + e.getMessage());
		} catch (final NoSuchMethodException e) {
			fail(enumClass + " does not properly implement values(): " + e.getMessage());
		} catch (final IllegalArgumentException e) {
			fail(enumClass + " does not properly implement values(): " + e.getMessage());
		} catch (final IllegalAccessException e) {
			fail(enumClass + " does not properly implement values(): " + e.getMessage());
		} catch (final InvocationTargetException e) {
			fail(enumClass + " does not properly implement values(): " + e.getMessage());
		}
		return null;
	}

}
