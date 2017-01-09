/*
 * Copyright 2008, 2009, 2014 Ian Brown All Rights Reserved
 * 
 * Permission is granted to use and distribute this software so long as this copyright message is maintained. This software is
 * provided without a warranty or guarantee of any kind.
 */
package usa.browntrask.test;

import java.lang.reflect.Field;

/**
 * Helper class containing utility methods for testing.
 * <p>
 *
 * @author Ian Andrew Brown
 * @since V0.7.2 Sep 20, 2008
 * @version V2.2.0 Oct 4, 2014
 */
public final class Utility {

	/**
	 * the delta value between consecutive double values.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.7.2 Sep 30, 2008
	 * @version Sep 30, 2008
	 */
	public static final double DOUBLE_DELTA = 1.0;

	/**
	 * the delta value between consecutive float values.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.7.2 Sep 30, 2008
	 * @version Sep 30, 2008
	 */
	public static final float FLOAT_DELTA = 1.0F;

	/**
	 * the base string value.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.7.2 Sep 30, 2008
	 * @version Sep 30, 2008
	 */
	private static final String STRING_BASE = "String";

	/**
	 * the value to be used.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.7.2 Sep 26, 2008
	 * @version Sep 26, 2008
	 */
	private static long value = 0L;

	/**
	 * Returns the next boolean value (alternates between <code>false</code> and <code>true</code>).
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @return the next boolean value.
	 * @since V0.7.2 Sep 20, 2008
	 * @version Sep 20, 2008
	 */
	public final static boolean nextBoolean() {
		final long longValue = nextLong();

		return longValue % 2L == 1L;
	}

	/**
	 * Returns the next unique double value.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @return the unique double value.
	 * @since V0.7.2 Sep 20, 2008
	 * @version Sep 30, 2008
	 */
	public final static double nextDouble() {
		return DOUBLE_DELTA * nextLong();
	}

	/**
	 * Returns the next selected enumerated value from the available in the specified class.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param <E>
	 *            the type of enumeration.
	 * @param enumClass
	 *            the class of enumeration.
	 * @return the enumerated value.
	 * @since V0.9.2 Nov 15, 2008
	 * @version Nov 15, 2008
	 */
	public final static <E> E nextEnum(final Class<E> enumClass) {
		final E[] values = enumClass.getEnumConstants();
		final int index = nextInt() % values.length;
		return values[index];
	}

	/**
	 * Returns the next unique floating point value.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @return the unique floating point value.
	 * @since V0.7.2 Sep 20, 2008
	 * @version Sep 30, 2008
	 */
	public final static float nextFloat() {
		return FLOAT_DELTA * nextLong();
	}

	/**
	 * Returns a unique string value starting with the prefix and ending with the suffix. A value of <code>null</code> is treated as
	 * a blank.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param prefix
	 *            the prefix value.
	 * @param suffix
	 *            the suffix value.
	 * @return the unique string value in the form <i>prefix</i>unique value<i>suffix</i>.
	 * @since V0.7.2 Sep 20, 2008
	 * @version Sep 30, 2008
	 */
	public final static String nextFormattedString(final String prefix, final String suffix) {
		return prefix + nextLong() + suffix;
	}

	/**
	 * Returns the next unique integer value.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @return the next integer value.
	 * @since V0.7.2 Sep 20, 2008
	 * @version Sep 25, 2008
	 */
	public final static int nextInt() {
		return (int) (nextLong() % Integer.MAX_VALUE);
	}

	/**
	 * Returns the next unique long value.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @return the unique long value.
	 * @since V0.7.2 Sep 20, 2008
	 * @version Sep 25, 2008
	 */
	public final static long nextLong() {
		synchronized (Utility.class) {
			return ++value;
		}
	}

	/**
	 * Returns the next unique short value.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @return the next short value.
	 * @since V0.7.2 Sep 20, 2008
	 * @version Sep 25, 2008
	 */
	public final static short nextShort() {
		return (short) (nextLong() % Short.MAX_VALUE);
	}

	/**
	 * Returns the next unique string value.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @return the unique string value.
	 * @since V0.7.2 Sep 20, 2008
	 * @version Sep 20, 2008
	 */
	public final static String nextString() {
		return STRING_BASE + nextLong();
	}

	/**
	 * Resets the seed value to the starting point.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.9.2 Nov 15, 2008
	 * @version Nov 15, 2008
	 */
	public final static void reset() {
		value = 0L;
	}

	/**
	 * Sets a field on an object, even if the field would not normally be accessible (such as a private field).
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param <O>
	 *            the type of object to update.
	 * @param <V>
	 *            the type of value to set.
	 * @param object
	 *            the object.
	 * @param fieldName
	 *            the name of the field to set.
	 * @param value
	 *            the value to set.
	 * @return the old value.
	 * @throws SecurityException
	 *             if there is a problem getting the field of the object.
	 * @throws NoSuchFieldException
	 *             if the field does not exist.
	 * @throws IllegalAccessException
	 *             if the field cannot be accessed.
	 * @throws IllegalArgumentException
	 *             if the object is not a valid field.
	 * @since V2.2.0 Oct 4, 2014
	 * @version V2.2.0 Oct 4, 2014
	 */
	public final static <O, V> V setField(final O object, final String fieldName, final V value) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException {
		Field objectField = null;
		Class<?> workingClass = object.getClass();
		while (objectField == null) {
			try {
				objectField = workingClass.getDeclaredField(fieldName);
			} catch (final NoSuchFieldException e) {
				if (workingClass == Object.class) {
					throw e;
				}
				workingClass = workingClass.getSuperclass();
			}
		}
		objectField.setAccessible(true);
		@SuppressWarnings("unchecked")
		final V oldValue = (V) objectField.get(object);
		objectField.set(object, value);
		return oldValue;
	}

	/**
	 * Private constructor - all methods are statics.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.7.2 Sep 22, 2008
	 * @version Sep 22, 2008
	 */
	// /CLOVER:OFF
	private Utility() {
		throw new UnsupportedOperationException("Cannot create utilities objects");
	}
	// /CLOVER:ON
}
