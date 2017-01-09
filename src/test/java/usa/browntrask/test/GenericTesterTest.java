/**
 * Copyright 2008, 2009, 2010, 2011, 2015 Ian Brown<br/>
 * All Rights Reserved
 * 
 * Permission is granted to use and distribute this software so long as this copyright message is maintained. This software is
 * provided without a warranty or guarantee of any kind.
 */
package usa.browntrask.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Test;

import usa.browntrask.test.GenericTester.MethodInvoker;
import usa.browntrask.test.mock.MockComparable;

/**
 * Test for {@link GenericTester}.
 * <p>
 * Note: methods marked as unused are actually used during testing via reflection.
 * 
 * @author Ian Andrew Brown
 * @since V0.7.0 Jul 26, 2008
 * @version V2.2.0 Nov 21, 2015
 */
public final class GenericTesterTest {

	/**
	 * The good stub class to be tested.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.7.0 Jul 26, 2008
	 * @version V2.2.0 Nov 21, 2015
	 */
	static final class GoodStubClass {

		/**
		 * A method that takes multiple parameters.
		 * <p>
		 * 
		 * @author Ian Andrew Brown
		 * @param booleanParameter
		 *            the boolean parameter.
		 * @param byteParameter
		 *            the byte parameter.
		 * @param characterParameter
		 *            the character parameter.
		 * @param integerParameter
		 *            the integer parameter.
		 * @param longParameeter
		 *            the long parameter.
		 * @param floatParameter
		 *            the float parameter.
		 * @param doubleParameter
		 *            the double parameter.
		 * @throws UnsupportedOperationException
		 *             the expected exception.
		 * @since V0.7.0 Jul 26, 2008
		 * @version V2.2.0 Nov 21, 2015
		 */
		public final void methodWithMultipleParameters(@SuppressWarnings("unused") final Boolean booleanParameter,
				@SuppressWarnings("unused") final Byte byteParameter,
				@SuppressWarnings("unused") final Character characterParameter,
				@SuppressWarnings("unused") final Integer integerParameter, @SuppressWarnings("unused") final Long longParameeter,
				@SuppressWarnings("unused") final Float floatParameter, @SuppressWarnings("unused") final Double doubleParameter) {
			throw new UnsupportedOperationException();
		}

		/**
		 * A method that takes an object parameter.
		 * <p>
		 * 
		 * @author Ian Andrew Brown
		 * @param objectParameter
		 *            the object parameter.
		 * @throws UnsupportedOperationException
		 *             the expected exception.
		 * @since V0.7.0 Jul 26, 2008
		 * @version V2.2.0 Nov 21, 2015
		 */
		public final void methodWithObjectParameter(@SuppressWarnings("unused") final Object objectParameter) {
			throw new UnsupportedOperationException();
		}

		/**
		 * A method that takes a primitive value.
		 * <p>
		 * 
		 * @author Ian Andrew Brown
		 * @param primitiveParameter
		 *            the primitive value.
		 * @throws UnsupportedOperationException
		 *             the expected exception.
		 * @since V0.7.0 Jul 26, 2008
		 * @version V2.2.0 Nov 21, 2015
		 */
		public final void methodWithPrimitiveParameter(@SuppressWarnings("unused") final int primitiveParameter) {
			throw new UnsupportedOperationException();
		}

		/**
		 * A method that has a return value.
		 * <p>
		 * 
		 * @author Ian Andrew Brown
		 * @return the return value.
		 * @throws UnsupportedOperationException
		 *             the expected exception.
		 * @since V0.7.0 Jul 26, 2008
		 * @version V1.1.0 Feb 4, 2011
		 */
		public final int methodWithReturnValue() {
			throw new UnsupportedOperationException();
		}

		/**
		 * A method that takes a string parameter.
		 * <p>
		 * 
		 * @author Ian Andrew Brown
		 * @param stringParameter
		 *            the string parameter.
		 * @throws UnsupportedOperationException
		 *             the expected exception.
		 * @since V0.7.0 Jul 26, 2008
		 * @version V2.2.0 Nov 21, 2015
		 */
		public final void methodWithStringParameter(@SuppressWarnings("unused") final String stringParameter) {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * Implementation of a {@link MethodInvoker} that throws an {@link IllegalAccessException}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Aug 2, 2008
	 * @version V2.2.0 Nov 21, 2015
	 */
	private static final class IllegalAccessExceptionMethodInvoker implements MethodInvoker {

		/** {@inheritDoc} */
		@Override
		public final <O> Object invoke(@SuppressWarnings("unused") final O object, @SuppressWarnings("unused") final Method method,
				@SuppressWarnings("unused") final Object... args) throws IllegalArgumentException, IllegalAccessException,
				InvocationTargetException {
			throw new IllegalAccessException();
		}

	}

	/**
	 * Implementation of a {@link MethodInvoker} that throws an {@link IllegalArgumentException}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Aug 2, 2008
	 * @version V2.2.0 Nov 21, 2015
	 */
	private static final class IllegalArgumentExceptionMethodInvoker implements MethodInvoker {

		/** {@inheritDoc} */
		@Override
		public final <O> Object invoke(@SuppressWarnings("unused") final O object, @SuppressWarnings("unused") final Method method,
				@SuppressWarnings("unused") final Object... args) throws IllegalArgumentException, IllegalAccessException,
				InvocationTargetException {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * The stub class to be tested that does not throw an exception.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.7.0 Jul 26, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	private static final class NoExceptionStubClass {

		/**
		 * A method that does not throw an exception.
		 * <p>
		 * 
		 * @author Ian Andrew Brown
		 * @since V0.7.0 Jul 26, 2008
		 * @version V1.1.0 Feb 4, 2011
		 */
		@SuppressWarnings("unused")
		public final void methodThatDoesNotThrowException() {

		}
	}

	/**
	 * The stub class to be tested that throws the wrong exception.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.7.0 Aug 2, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	private static final class WrongExceptionStubClass {

		/**
		 * A method that throws the wrong exception.
		 * <p>
		 * 
		 * @author Ian Andrew Brown
		 * @since V0.7.0 Aug 2, 2008
		 * @version V1.1.0 Feb 4, 2011
		 */
		@SuppressWarnings("unused")
		public final void methodThatThrowsWrongException() {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Tears down the method invoker used so that the default will be used next time.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Aug 2, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@After
	public final void tearDownInvoker() {
		GenericTester.setMethodInvoker(null);
	}

	/**
	 * Test method for {@link usa.browntrask.test.GenericTester#checkAllMethodsOfStub(java.lang.Object, java.lang.Class)} .
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.7.0 Jul 26, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@Test
	public final void testCheckAllMethodsOfStub() {
		final GoodStubClass stub = new GoodStubClass();

		final boolean check = GenericTester.checkAllMethodsOfStub(stub, UnsupportedOperationException.class);

		assertTrue("All methods should succeed", check);
	}

	/**
	 * Test method for {@link GenericTester#checkCompareTo(Comparable, Comparable, Comparable)} for the case where the comparable
	 * properly implements the compareTo method.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@Test
	public final void testCheckCompareTo() {
		final MockComparable comparable = MockComparable.newMockComparable();
		final MockComparable before = MockComparable.newMockComparableBefore();
		final MockComparable after = MockComparable.newMockComparableAfter();

		final boolean checkCompareTo = GenericTester.checkCompareTo(comparable, before, after);

		assertTrue("Compare to should succeed", checkCompareTo);
	}

	/**
	 * Test method for {@link GenericTester#checkCompareTo(Comparable, Comparable, Comparable)} for the case where the compareTo
	 * method doesn't correctly return the sign when handling the after object.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@Test
	public final void testCheckCompareTo_afterSignFailure() {
		final MockComparable comparable = MockComparable.newMockComparable();
		final MockComparable before = MockComparable.newMockComparableBefore();
		final MockComparable after = MockComparable.newMockComparableAfterSignFailure();

		final boolean checkCompareTo = GenericTester.checkCompareTo(comparable, before, after);

		assertFalse("Compare to after should fail", checkCompareTo);
	}

	/**
	 * Test method for {@link GenericTester#checkCompareTo(Comparable, Comparable, Comparable)} for the case where the compareTo
	 * method doesn't correctly return the sign when handling the before object.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@Test
	public final void testCheckCompareTo_beforeSignFailure() {
		final MockComparable comparable = MockComparable.newMockComparable();
		final MockComparable before = MockComparable.newMockComparableBeforeSignFailure();

		final boolean checkCompareTo = GenericTester.checkCompareTo(comparable, before, null);

		assertFalse("Compare to before should fail", checkCompareTo);
	}

	/**
	 * Test method for {@link GenericTester#checkCompareTo(Comparable, Comparable, Comparable)} for the case where the comparable
	 * properly implements the compareTo method, but for which there is no after value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.2.0 Mar 25, 2011
	 * @version V1.2.0 Mar 25, 2011
	 */
	@Test
	public final void testCheckCompareTo_noAfter() {
		final MockComparable comparable = MockComparable.newMockComparable();
		final MockComparable before = MockComparable.newMockComparableBefore();

		final boolean checkCompareTo = GenericTester.checkCompareTo(comparable, before, null);

		assertTrue("Compare to should succeed", checkCompareTo);
	}

	/**
	 * Test method for {@link GenericTester#checkCompareTo(Comparable, Comparable, Comparable)} for the case where the comparable
	 * properly implements the compareTo method, but for which there is no before value.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.2.0 Mar 25, 2011
	 * @version V1.2.0 Mar 25, 2011
	 */
	@Test
	public final void testCheckCompareTo_noBefore() {
		final MockComparable comparable = MockComparable.newMockComparable();
		final MockComparable after = MockComparable.newMockComparableAfter();

		final boolean checkCompareTo = GenericTester.checkCompareTo(comparable, null, after);

		assertTrue("Compare to should succeed", checkCompareTo);
	}

	/**
	 * Test method for {@link GenericTester#checkCompareTo(Comparable, Comparable, Comparable)} for the case where the comparable
	 * does not properly throw a null pointer exception on a <code>null</code> input.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@Test
	public final void testCheckCompareTo_nullFailure() {
		final MockComparable comparable = MockComparable.newMockComparableDoesNotThrowNullPointer();

		final boolean checkCompareTo = GenericTester.checkCompareTo(comparable, null, null);

		assertFalse("Compare to null should fail", checkCompareTo);
	}

	/**
	 * Test method for {@link GenericTester#checkCompareTo(Comparable, Comparable, Comparable)} for the case where the comparable
	 * does not properly compare to itself.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@Test
	public final void testCheckCompareTo_selfFailure() {
		final MockComparable comparable = MockComparable.newMockComparableDoesNotCompareToSelf();

		final boolean checkCompareTo = GenericTester.checkCompareTo(comparable, null, null);

		assertFalse("Compare to self should fail", checkCompareTo);
	}

	/**
	 * Test method for {@link GenericTester#checkCompareTo(Comparable, Comparable, Comparable)} for the case where the compareTo
	 * method doesn't correctly handle transitivity.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@Test
	public final void testCheckCompareTo_transitivityFailure() {
		final MockComparable comparable = MockComparable.newMockComparableTransitivityFailure();
		final MockComparable before = MockComparable.newMockComparableBeforeTransitivityFailure();
		final MockComparable after = MockComparable.newMockComparableAfterTransitivityFailure();

		final boolean checkCompareTo = GenericTester.checkCompareTo(comparable, before, after);

		assertFalse("Compare to should fail transitivity", checkCompareTo);
	}

	/**
	 * Test method for {@link GenericTester#checkEquals(Object)} for the case where the equals method performs correctly.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@Test
	public final void testCheckEquals() {
		final Object object = new Object() {
			@Override
			public final boolean equals(final Object o) {
				if (o == null) {
					return false;
				} else if (!getClass().isInstance(o)) {
					return false;
				}
				return true;
			}

			@Override
			public final int hashCode() {
				return super.hashCode();
			}
		};

		assertTrue("Equals method should properly return true", GenericTester.checkEquals(object));
	}

	/**
	 * Test method for {@link GenericTester#checkEquals(Object)} for the case where the equals method returns <code>true</code> when
	 * comparing to a different type of object.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@Test
	public final void testCheckEquals_equalsDifferent() {
		final Object object = new Object() {
			@Override
			public final boolean equals(final Object o) {
				return (o != null);
			}

			@Override
			public final int hashCode() {
				return super.hashCode();
			}
		};

		assertFalse("Equals method should improperly return false", GenericTester.checkEquals(object));
	}

	/**
	 * Test method for {@link GenericTester#checkEquals(Object)} for the case where the equals method returns <code>true</code> when
	 * comparing to a <code>null</code>.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version V2.2.0 Nov 21, 2015
	 */
	@Test
	public final void testCheckEquals_equalsNull() {
		final Object object = new Object() {
			@Override
			public final boolean equals(@SuppressWarnings("unused") final Object o) {
				return true;
			}

			@Override
			public final int hashCode() {
				return super.hashCode();
			}
		};

		assertFalse("Equals method should improperly return true", GenericTester.checkEquals(object));
	}

	/**
	 * Test method for {@link GenericTester#checkEquals(Object)} for the case where the equals method returns <code>false</code>
	 * when comparing to itself.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version V2.2.0 Nov 21, 2015
	 */
	@Test
	public final void testCheckEquals_notEqualsItself() {
		final Object object = new Object() {
			@Override
			public final boolean equals(@SuppressWarnings("unused") final Object o) {
				return false;
			}

			@Override
			public final int hashCode() {
				return super.hashCode();
			}
		};

		assertFalse("Equals method should improperly return false", GenericTester.checkEquals(object));
	}

	/**
	 * Test method for {@link GenericTester#checkEquals(Object)} for the case where the equals method fails due to a null pointer
	 * comparison.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version V2.2.0 Nov 21, 2015
	 */
	@Test(expected = AssertionError.class)
	public final void testCheckEquals_nullException() {
		final Object object = new Object() {
			@Override
			public final boolean equals(@SuppressWarnings("unused") final Object o) {
				throw new NullPointerException("Expected null pointer exception");
			}

			@Override
			public final int hashCode() {
				return super.hashCode();
			}
		};

		GenericTester.checkEquals(object);
	}

	/**
	 * Test method for {@link GenericTester#checkHashCode(Object)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@Test
	public final void testCheckHashcode() {
		final Object object = new Object() {

			@Override
			public final int hashCode() {
				return 17;
			}
		};

		assertTrue("Hash code should work properly", GenericTester.checkHashCode(object));
	}

	/**
	 * Test method for {@link GenericTester#checkHashCode(Object)} for the case where the hashCode throws a null pointer exception.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@Test(expected = AssertionError.class)
	public final void testCheckHashcode_nullException() {
		final Object object = new Object() {
			@Override
			public final int hashCode() {
				throw new NullPointerException("Expected null pointer exception");
			}
		};

		GenericTester.checkHashCode(object);
	}

	/**
	 * Test method for {@link GenericTester#checkHashCode(Object)} for the case where the hashCode is unstable (can return different
	 * values).
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@Test
	public final void testCheckHashcode_unstable() {
		final Object object = new Object() {
			private int count = 0;

			@Override
			public final int hashCode() {
				return (++count == 10) ? count : 17;
			}
		};

		assertFalse("Hash code should improperly return unstable value", GenericTester.checkHashCode(object));
	}

	/**
	 * Test method for {@link GenericTester#checkHashCode(Object)} for the case where the hashCode returns 0.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@Test
	public final void testCheckHashcode_zero() {
		final Object object = new Object() {
			@Override
			public final int hashCode() {
				return 0;
			}
		};

		assertFalse("Hash code should improperly return 0", GenericTester.checkHashCode(object));
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.GenericTester#checkStubMethod(java.lang.Object, java.lang.reflect.Method, java.lang.Class)} .
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @throws NoSuchMethodException
	 *             if the method to be tested doesn't exist in the class to be tested.
	 * @throws SecurityException
	 *             if there is a problem getting the method to be tested.
	 * @since V0.7.0 Jul 26, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@Test
	public final void testCheckStubMethod() throws SecurityException, NoSuchMethodException {
		final GoodStubClass stub = new GoodStubClass();
		final Method method = stub.getClass().getMethod("methodWithPrimitiveParameter", new Class<?>[] { int.class });

		final boolean check = GenericTester.checkStubMethod(stub, method, UnsupportedOperationException.class);

		assertTrue("Check should return true", check);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.GenericTester#checkStubMethod(java.lang.Object, java.lang.reflect.Method, java.lang.Class)} when
	 * the invokation fails due to an {@link IllegalAccessException}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @throws NoSuchMethodException
	 *             if the method to be tested doesn't exist in the class to be tested.
	 * @throws SecurityException
	 *             if there is a problem getting the method to be tested.
	 * @since V0.7.0 Aug 2, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@SuppressWarnings("synthetic-access")
	@Test
	public final void testCheckStubMethod_illegalAccessException() throws SecurityException, NoSuchMethodException {
		final NoExceptionStubClass stub = new NoExceptionStubClass();
		final Method method = stub.getClass().getMethod("methodThatDoesNotThrowException", new Class<?>[0]);
		GenericTester.setMethodInvoker(new IllegalAccessExceptionMethodInvoker());

		final boolean check = GenericTester.checkStubMethod(stub, method, UnsupportedOperationException.class);

		assertFalse("Check should return false", check);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.GenericTester#checkStubMethod(java.lang.Object, java.lang.reflect.Method, java.lang.Class)} when
	 * the invokation fails due to an {@link IllegalArgumentException}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @throws NoSuchMethodException
	 *             if the method to be tested doesn't exist in the class to be tested.
	 * @throws SecurityException
	 *             if there is a problem getting the method to be tested.
	 * @since V0.7.0 Aug 2, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@SuppressWarnings("synthetic-access")
	@Test
	public final void testCheckStubMethod_illegalArgumentException() throws SecurityException, NoSuchMethodException {
		final NoExceptionStubClass stub = new NoExceptionStubClass();
		final Method method = stub.getClass().getMethod("methodThatDoesNotThrowException", new Class<?>[0]);
		GenericTester.setMethodInvoker(new IllegalArgumentExceptionMethodInvoker());

		final boolean check = GenericTester.checkStubMethod(stub, method, UnsupportedOperationException.class);

		assertFalse("Check should return false", check);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.GenericTester#checkStubMethod(java.lang.Object, java.lang.reflect.Method, java.lang.Class)} for a
	 * class that does not throw an exception.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @throws NoSuchMethodException
	 *             if the method to be tested doesn't exist in the class to be tested.
	 * @throws SecurityException
	 *             if there is a problem getting the method to be tested.
	 * @since V0.7.0 Aug 2, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@SuppressWarnings("synthetic-access")
	@Test
	public final void testCheckStubMethod_noException() throws SecurityException, NoSuchMethodException {
		final NoExceptionStubClass stub = new NoExceptionStubClass();
		final Method method = stub.getClass().getMethod("methodThatDoesNotThrowException", new Class<?>[0]);

		final boolean check = GenericTester.checkStubMethod(stub, method, UnsupportedOperationException.class);

		assertFalse("Check should return false", check);
	}

	/**
	 * Test method for
	 * {@link usa.browntrask.test.GenericTester#checkStubMethod(java.lang.Object, java.lang.reflect.Method, java.lang.Class)} for a
	 * class that throws the wrong exception.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @throws NoSuchMethodException
	 *             if the method to be tested doesn't exist in the class to be tested.
	 * @throws SecurityException
	 *             if there is a problem getting the method to be tested.
	 * @since V0.7.0 Aug 2, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@SuppressWarnings("synthetic-access")
	@Test(expected = AssertionError.class)
	public final void testCheckStubMethod_wrongException() throws SecurityException, NoSuchMethodException {
		final WrongExceptionStubClass stub = new WrongExceptionStubClass();
		final Method method = stub.getClass().getMethod("methodThatThrowsWrongException", new Class<?>[0]);

		GenericTester.checkStubMethod(stub, method, UnsupportedOperationException.class);
	}

	/**
	 * Test method for {@link usa.browntrask.test.GenericTester#checkToString(Object)} for a normal object.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.9.0 Nov 2, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@Test
	public final void testCheckToString() {
		final Object object = new Object();

		assertTrue("ToString should properly return a string", GenericTester.checkToString(object));
	}

	/**
	 * Test method for {@link usa.browntrask.test.GenericTester#checkToString(Object)} for an object that returns <code>null</code>
	 * in its {@link java.lang.Object#toString()} method.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.9.0 Nov 2, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@Test
	public final void testCheckToString_badToString() {
		final Object object = new Object() {
			@Override
			public final String toString() {
				return null;
			}
		};

		assertFalse("ToString should improperly return a null", GenericTester.checkToString(object));
	}

	/**
	 * Test method for {@link GenericTester#populateArguments(Class[])} for a boolean argument.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.1 Aug 2, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@Test
	public final void testPopulateArguments_boolean() {
		final Object[] args = GenericTester.populateArguments(new Class[] { boolean.class });

		assertEquals("There should be one argument", 1, args.length);
		assertSame("The argument should be a boolean", Boolean.class, args[0].getClass());
	}

	/**
	 * Test method for {@link GenericTester#populateArguments(Class[])} for a byte argument.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.1 Aug 2, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@Test
	public final void testPopulateArguments_byte() {
		final Object[] args = GenericTester.populateArguments(new Class[] { byte.class });

		assertEquals("There should be one argument", 1, args.length);
		assertSame("The argument should be a byte", Byte.class, args[0].getClass());
	}

	/**
	 * Test method for {@link GenericTester#populateArguments(Class[])} for a char argument.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.1 Aug 2, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@Test
	public final void testPopulateArguments_char() {
		final Object[] args = GenericTester.populateArguments(new Class[] { char.class });

		assertEquals("There should be one argument", 1, args.length);
		assertSame("The argument should be a char", Character.class, args[0].getClass());
	}

	/**
	 * Test method for {@link GenericTester#populateArguments(Class[])} for a double argument.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.1 Aug 2, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@Test
	public final void testPopulateArguments_double() {
		final Object[] args = GenericTester.populateArguments(new Class[] { double.class });

		assertEquals("There should be one argument", 1, args.length);
		assertSame("The argument should be a double", Double.class, args[0].getClass());
	}

	/**
	 * Test method for {@link GenericTester#populateArguments(Class[])} for a float argument.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.1 Aug 2, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@Test
	public final void testPopulateArguments_float() {
		final Object[] args = GenericTester.populateArguments(new Class[] { float.class });

		assertEquals("There should be one argument", 1, args.length);
		assertSame("The argument should be a float", Float.class, args[0].getClass());
	}

	/**
	 * Test method for {@link GenericTester#populateArguments(Class[])} for an int argument.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.1 Aug 2, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@Test
	public final void testPopulateArguments_int() {
		final Object[] args = GenericTester.populateArguments(new Class[] { int.class });

		assertEquals("There should be one argument", 1, args.length);
		assertSame("The argument should be an int", Integer.class, args[0].getClass());
	}

	/**
	 * Test method for {@link GenericTester#populateArguments(Class[])} for a long argument.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.1 Aug 2, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@Test
	public final void testPopulateArguments_long() {
		final Object[] args = GenericTester.populateArguments(new Class[] { long.class });

		assertEquals("There should be one argument", 1, args.length);
		assertSame("The argument should be a long", Long.class, args[0].getClass());
	}

	/**
	 * Test method for {@link GenericTester#populateArguments(Class[])} for an object argument.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.1 Aug 2, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@Test
	public final void testPopulateArguments_object() {
		final Object[] args = GenericTester.populateArguments(new Class[] { Object.class });

		assertEquals("There should be one argument", 1, args.length);
		assertNull("The argument should be null", args[0]);
	}

	/**
	 * Test method for {@link GenericTester#populateArguments(Class[])} for a long argument.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.9.3 Dec 13, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@Test
	public final void testPopulateArguments_short() {
		final Object[] args = GenericTester.populateArguments(new Class[] { short.class });

		assertEquals("There should be one argument", 1, args.length);
		assertSame("The argument should be a short", Short.class, args[0].getClass());
	}

	/**
	 * Test method for {@link GenericTester#populateArguments(Class[])} for a String argument.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.1 Aug 2, 2008
	 * @version V1.1.0 Feb 4, 2011
	 */
	@Test
	public final void testPopulateArguments_string() {
		final Object[] args = GenericTester.populateArguments(new Class[] { String.class });

		assertEquals("There should be one argument", 1, args.length);
		assertSame("The argument should be a String", String.class, args[0].getClass());
	}
}
