/**
 * Copyright 2008, 2009, 2010, 2011 Ian Brown<br/>
 * All Rights Reserved
 * 
 * Permission is granted to use and distribute this software so long as this copyright message is maintained. This software is
 * provided without a warranty or guarantee of any kind.
 */
package usa.browntrask.test;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Generic class to test other classes.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.7.0 Jul 26, 2008
 * @version V1.2.0 Mar 25, 2011
 */
public final class GenericTester {

	/**
	 * Interface for objects that can be used to invoke methods to be tested.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Aug 2, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	/* package */interface MethodInvoker {

		/**
		 * Invokes a {@link Method} with the specified arguments.
		 * <p>
		 * 
		 * @author Ian Andrew Brown
		 * @param <O>
		 *            the type of object to invoke the method on.
		 * @param object
		 *            the object to invoke the method on.
		 * @param method
		 *            the method to be invoked.
		 * @param args
		 *            the arguments to provide to the method.
		 * @return the return value of the method.
		 * @throws IllegalArgumentException
		 *             if an argument to the method does not match its type.
		 * @throws IllegalAccessException
		 *             if the method cannot be accessed.
		 * @throws InvocationTargetException
		 *             if the method cannot be invoked on the
		 * @since V0.8.0 Aug 2, 2008
		 * @version V1.1.0 Feb 4, 2011
		 */
		<O extends Object> Object invoke(O object, Method method, Object... args) throws IllegalArgumentException,
				IllegalAccessException, InvocationTargetException;
	}

	/**
	 * Implementation of {@link MethodInvoker}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Aug 2, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	private final static class MethodInvokerImpl implements MethodInvoker {

		/** {@inheritDoc} */
		@Override
		public final <O> Object invoke(final O object, final Method method, final Object... args) throws IllegalArgumentException,
				IllegalAccessException, InvocationTargetException {
			return method.invoke(object, args);
		}
	}

	/**
	 * the default {@link MethodInvoker} to be used.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@SuppressWarnings("synthetic-access")
	private final static MethodInvoker defaultMethodInvoker = new MethodInvokerImpl();

	/**
	 * the maximum number of calls to make when checking methods.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	private static final int MAXIMUM_CALLS = 64;

	/**
	 * the {@link MethodInvoker} to be used.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	private static MethodInvoker methodInvoker = defaultMethodInvoker;

	/**
	 * Checks that all of the methods of a class that should be a stub implementation are, in fact, stubs.
	 * <p>
	 * This method assumes that, if the class is a subclass, the parent class's methods have been tested.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param <O>
	 *            the type of object to test.
	 * @param <E>
	 *            the type of exception expected.
	 * @param stub
	 *            the object to be tested.
	 * @param exceptionClass
	 *            the class of exception expected.
	 * @return <code>true</code> if all of the stub methods throw the exception exception.
	 * @throws AssertionError
	 *             if a stub method fails to throw an exception of the specified type.
	 * @since V0.7.0 Jul 26, 2008
	 * @version V1.2.0 Mar 25, 2011
	 */
	public static final <O extends Object, E extends Exception> boolean checkAllMethodsOfStub(final O stub,
			final Class<E> exceptionClass) {

		final Class<? extends Object> stubClass = stub.getClass();
		final Method[] methods = stubClass.getDeclaredMethods();
		for (final Method method : methods) {
			if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
				final boolean check = checkStubMethod(stub, method, exceptionClass);
				org.junit.Assert.assertTrue("Method " + method + " should have thrown " + exceptionClass, check);
			}
		}
		return true;
	}

	/**
	 * Checks to see that a {@link Comparable} object properly implements the {@link Comparable#compareTo(Object)} method.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param <T>
	 *            the type of object to check.
	 * @param comparable
	 *            the comparable object to check.
	 * @param before
	 *            an object that should compare before the comparable.
	 * @param after
	 *            an object that should compare after the comparable.
	 * @return <code>true</code> if the compareTo method works properly, <code>false</code> if it doesn't.
	 * @since V0.8.0 Oct 6, 2008
	 * @version V1.2.0 Mar 25, 2011
	 */
	public static final <T extends Comparable<? super T>> boolean checkCompareTo(final T comparable, final T before, final T after) {
		if (!checkCompareToNull(comparable)) {
			return false;
		} else if (!checkCompareToSelf(comparable)) {
			return false;
		} else if ((before != null) && !checkCompareToBefore(comparable, before)) {
			return false;
		} else if ((after != null) && !checkCompareToAfter(comparable, after)) {
			return false;
		} else if (!checkCompareToTransitivity(comparable, before, after)) {
			return false;
		}
		return true;
	}

	/**
	 * Checks the equals method of the input object to ensure that it works properly.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param <T>
	 *            the type of object.
	 * @param object
	 *            the object to be tested.
	 * @return <code>true</code> if the equals method works properly, <code>false</code> if it does not.
	 * @since V0.8.0 Oct 6, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	public final static <T extends Object> boolean checkEquals(final T object) {
		try {
			if (object.equals(null)) {
				// LOGGER.debug(object + " equals null");
				return false;
			} else if (!object.equals(object)) {
				// LOGGER.debug(object + " does not equal itself");
				return false;
			} else {
				final Object o = new Serializable() {
					private static final long serialVersionUID = 1L;

				};
				if (object.equals(o)) {
					// LOGGER.debug(object +
					// " equals a different type of object");
					return false;
				}
			}
		} catch (final NullPointerException e) {
			// LOGGER.debug(object.getClass()
			// + " equals throws null pointer exception", e);
			org.junit.Assert.fail("Equals throws null pointer exception: " + e);
		}

		return true;
	}

	/**
	 * Checks the hashCode method of the input object to ensure that works properly.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param <T>
	 *            the type of object.
	 * @param object
	 *            the object to be tested.
	 * @return <code>true</code> if the hashCode method works properly, <code>false</code> if it does not.
	 * @since V0.8.0 Oct 6, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	public final static <T extends Object> boolean checkHashCode(final T object) {
		try {
			final int firstHashCode = object.hashCode();

			if (firstHashCode == 0) {
				// LOGGER.debug(object + " hashCode can return 0");
				return false;
			}

			for (int count = 0; count < MAXIMUM_CALLS; ++count) {
				final int hashCode = object.hashCode();
				if (hashCode != firstHashCode) {
					// LOGGER.debug(object + " hashCode is unstable, expected: "
					// + firstHashCode + ", actual: " + hashCode);
					return false;
				}
			}

		} catch (final NullPointerException e) {
			// LOGGER.debug(object.getClass()
			// + " hashCode throws null pointer exception", e);
			org.junit.Assert.fail("HashCode throws null pointer exception " + e);
		}
		return true;
	}

	/**
	 * Checks that the specified method of the stub class properly throws an exception of the expected type.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param <O>
	 *            the type of object to test.
	 * @param <E>
	 *            the type of exception expected.
	 * @param stub
	 *            the object to be tested.
	 * @param method
	 *            the method to be tested.
	 * @param exceptionClass
	 *            the class of exception expected.
	 * @return <code>true</code> if the method throws the expected exception.
	 * @throws AssertionError
	 *             if a stub method fails to throw an exception of the specified type.
	 * @since V0.7.0 Jul 26, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	public static final <O extends Object, E extends Exception> boolean checkStubMethod(final O stub, final Method method,
			final Class<E> exceptionClass) {
		final Object[] args = populateArguments(method.getParameterTypes());
		try {
			getMethodInvoker().invoke(stub, method, args);
			return false;

		} catch (final IllegalArgumentException e) {
			// LOGGER.debug(
			// "Failed to invoke " + method.getName() + " on " + stub, e);
			return false;
		} catch (final IllegalAccessException e) {
			// LOGGER.debug(
			// "Failed to invoke " + method.getName() + " on " + stub, e);
			return false;
		} catch (final InvocationTargetException e) {
			org.junit.Assert.assertTrue("Exception should be caused by " + exceptionClass, exceptionClass.isInstance(e.getCause()));
			return true;
		}
	}

	/**
	 * Checks the toString method to ensure that it returns a legal (non- <code>null</code>) value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param <T>
	 *            the type of object.
	 * @param object
	 *            the object to be tested.
	 * @return <code>true</code> if the toString method works properly, <code>false</code> if it does not.
	 * @since V0.9.0 Nov 2, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	public final static <T extends Object> boolean checkToString(final T object) {
		final String string = object.toString();
		return string != null;
	}

	/**
	 * Gets the {@link MethodInvoker}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the method invoker.
	 * @since V0.1.1 Aug 2, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	static final MethodInvoker getMethodInvoker() {
		return methodInvoker;
	}

	/**
	 * Populates the arguments for a method call based on the input parameter types.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param parameterTypes
	 *            the array of parameter type classes.
	 * @return the array of parameter values.
	 * @since V0.1.1 Aug 2, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	/* package */final static Object[] populateArguments(final Class<?>[] parameterTypes) {
		final Object[] args = new Object[parameterTypes.length];
		int count = 0;
		for (final Class<?> parameterType : parameterTypes) {
			if (parameterType == boolean.class) {
				args[count] = false;
			} else if (parameterType == byte.class) {
				args[count] = (byte) 1;
			} else if (parameterType == char.class) {
				args[count] = '1';
			} else if (parameterType == double.class) {
				args[count] = 3.0d;
			} else if (parameterType == float.class) {
				args[count] = 4.f;
			} else if (parameterType == int.class) {
				args[count] = 5;
			} else if (parameterType == long.class) {
				args[count] = 6l;
			} else if (parameterType == short.class) {
				args[count] = (short) 8;
			} else if (parameterType == String.class) {
				args[count] = "7";
			} else {
				// We cannot depend on there being a constructor that we can
				// easily call. As such, we simply punt and provide a
				// null. Since the method is supposed to simply throw the
				// exception without any other checks, this should work.
				args[count] = parameterType.cast(null);
			}
			++count;
		}
		return args;
	}

	/**
	 * Sets the {@link MethodInvoker}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param methodInvoker
	 *            the method invoker to set.
	 * @since V0.1.1 Aug 2, 2008
	 * @version F1.1.0 Feb 4, 2011
	 */
	static final void setMethodInvoker(final MethodInvoker methodInvoker) {
		synchronized (GenericTester.class) {
			if (methodInvoker == null) {
				GenericTester.methodInvoker = defaultMethodInvoker;
			} else {
				GenericTester.methodInvoker = methodInvoker;
			}
		}
	}

	/**
	 * Checks to see that a {@link Comparable} object properly compares to an object that should come after it.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param <T>
	 *            the type of object to check.
	 * @param comparable
	 *            the comparable object to check.
	 * @param after
	 *            an object that should compare after the comparable.
	 * @return <code>true</code> if the object compares before the other, <code>false</code> if it does not.
	 * @since V0.8.0 Oct 6, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	private static final <T extends Comparable<? super T>> boolean checkCompareToAfter(final T comparable, final T after) {
		final int compared = comparable.compareTo(after);
		final int reversed = after.compareTo(comparable);

		if (Math.signum(reversed) == Math.signum(compared)) {
			// LOGGER.debug(comparable + " compared to " + after
			// + " should have reversed sign when comparison is reversed");
			return false;
		}

		return compared < 0;
	}

	/**
	 * Checks to see that a {@link Comparable} object properly compares to an object that should come before it.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param <T>
	 *            the type of object to check.
	 * @param comparable
	 *            the comparable object to check.
	 * @param before
	 *            an object that should compare before the comparable.
	 * @return <code>true</code> if the object compares after the other, <code>false</code> if it does not.
	 * @since V0.8.0 Oct 6, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	private static final <T extends Comparable<? super T>> boolean checkCompareToBefore(final T comparable, final T before) {
		final int compared = comparable.compareTo(before);
		final int reversed = before.compareTo(comparable);

		if (Math.signum(reversed) == Math.signum(compared)) {
			// LOGGER.debug(comparable + " compared to " + before
			// + " should have reversed sign when comparison is reversed");
			return false;
		}

		return compared > 0;
	}

	/**
	 * Checks to see that a {@link Comparable} object properly throws a null pointer exception when compared to <code>null</code>.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param <T>
	 *            the type of object to check.
	 * @param comparable
	 *            the comparable object to check.
	 * @return <code>true</code> if the comparison produces the exception, <code>false</code> otherwise.
	 * @since V0.8.0 Oct 6, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	private static final <T extends Comparable<? super T>> boolean checkCompareToNull(final T comparable) {
		try {
			comparable.compareTo(null);
			// LOGGER.debug(comparable
			// + " does not throw NPE when compared to null");
			return false;
		} catch (final NullPointerException e) {
			return true;
		}
	}

	/**
	 * Checks to see that a {@link Comparable} properly compares equal to itself.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param <T>
	 *            the type of object to check.
	 * @param comparable
	 *            the comparable object to check.
	 * @return <code>true</code> if the object compares equal to itself, <code>false</code> otherwise.
	 * @since V0.8.0 Oct 6, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	private static final <T extends Comparable<? super T>> boolean checkCompareToSelf(final T comparable) {
		final int compared = comparable.compareTo(comparable);

		// if (compared != 0) {
		// LOGGER.debug(comparable + " does not compare equal to itself");
		// }
		return compared == 0;
	}

	/**
	 * Checks to see if the three input {@link Comparable}s satisfy transitivity, namely
	 * <code>comparable.compareTo(before) &gt; 0</code> and <code>after.compareTo(comparable) &gt; 0</code> implies
	 * <code>after.compareTo(before) &gt; 0</code>.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param <T>
	 *            the type of objects to compare.
	 * @param comparable
	 *            the object to be compared.
	 * @param before
	 *            the object that should compare before the comparable.
	 * @param after
	 *            the object that should compare after the comparable.
	 * @return <code>true</code> if transitivity is satisfied, <code>false</code> if it is not.
	 * @since V0.8.0 Oct 6, 2008
	 * @version V1.2.0 Mar 25, 2011
	 */
	private static final <T extends Comparable<? super T>> boolean checkCompareToTransitivity(final T comparable, final T before,
			final T after) {
		final int comparableBefore = (before == null) ? 1 : comparable.compareTo(before);
		final int afterComparable = (after == null) ? 1 : after.compareTo(comparable);
		final int afterBefore = (after == null) ? 1 : (before == null) ? 1 : after.compareTo(before);

		return comparableBefore > 0 && afterComparable > 0 && afterBefore > 0;
	}

	/**
	 * Private constructor - this class should not be instantiated.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.7.0 Jul 26, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	// /CLOVER:OFF
	private GenericTester() {
		throw new UnsupportedOperationException(getClass() + " should not be instantiated");
	}
	// /CLOVER:ON
}
