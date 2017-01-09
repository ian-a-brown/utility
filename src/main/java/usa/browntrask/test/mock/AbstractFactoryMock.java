/**
 * Copyright 2012, 2015 by Ian Andrew Brown<br>
 * All Rights Reserved
 */
package usa.browntrask.test.mock;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import usa.browntrask.utility.Factory;

/**
 * Abstract implementation of {@link Factory} to support mock factories by providing the ability to stack return values.
 * <p>
 *
 * @author Ian Andrew Brown
 * @since V1.0.0 Nov 7, 2012
 * @version V2.2.0 Feb 28, 2015
 */
public abstract class AbstractFactoryMock implements Factory {

	/**
	 * the OBJECTS to provide.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V1.0.0 Nov 7, 2012
	 * @version V1.0.0 Nov 21, 2012
	 */
	private final static Map<Class<?>, Stack<?>> OBJECTS = new HashMap<Class<?>, Stack<?>>();

	/**
	 * Returns the number of pushed OBJECTS of the specified object class.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param <O>
	 *            the type of object.
	 * @param objectClass
	 *            the object class.
	 * @return the number of pushed OBJECTS of the specified class.
	 * @since V1.0.0 Nov 7, 2012
	 * @version V2.2.0 Feb 28, 2015
	 */
	@SuppressWarnings("unchecked")
	public static final <O> int numberOfPushedObjects(final Class<O> objectClass) {
		synchronized (OBJECTS) {
			final Stack<O> classObjects = (Stack<O>) OBJECTS.get(objectClass);
			return classObjects == null ? 0 : classObjects.size();
		}
	}

	/**
	 * Pops an object of the specified class.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param <O>
	 *            the type of object.
	 * @param objectClass
	 *            the class of object to pop.
	 * @return the object.
	 * @since V1.0.0 Nov 7, 2012
	 * @version V2.2.0 Feb 28, 2015
	 */
	@SuppressWarnings("unchecked")
	public static final <O> O pop(final Class<O> objectClass) {
		synchronized (OBJECTS) {
			final Stack<O> classObjects = (Stack<O>) OBJECTS.get(objectClass);
			if (classObjects != null) {
				return classObjects.pop();
			}

			throw new EmptyStackException();
		}
	}

	/**
	 * Pushes an object of the specified class.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param <O>
	 *            the type of object.
	 * @param objectClass
	 *            the class.
	 * @param object
	 *            the object.
	 * @since V1.0.0 Nov 7, 2012
	 * @version V2.2.0 Feb 28, 2015
	 */
	@SuppressWarnings("unchecked")
	public static final <O> void push(final Class<O> objectClass, final O object) {
		synchronized (OBJECTS) {
			Stack<O> classObjects = (Stack<O>) OBJECTS.get(objectClass);
			if (classObjects == null) {
				classObjects = new Stack<O>();
				OBJECTS.put(objectClass, classObjects);
			}
			classObjects.push(object);
		}
	}
}