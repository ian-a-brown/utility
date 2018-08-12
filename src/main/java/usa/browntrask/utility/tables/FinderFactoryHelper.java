/**
 * Copyright 2007, 2008, 2009, 2010, 2011 by Ian Andrew Brown<br>
 * All Rights Reserved
 */
package usa.browntrask.utility.tables;

import usa.browntrask.annotations.Immutable;

/**
 * Helper class for object finder factories.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.1 Nov 27, 2007
 * @version Jul 26, 2018
 */
@Immutable
public final class FinderFactoryHelper {

	/**
	 * Determines the best searchable object interface for the specified class.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param <T>
	 *            the type of searchable object.
	 * @param <I>
	 *            the type of searchable interface.
	 * @param searchableObjectClass
	 *            the class of searchable object.
	 * @param searchableInterface
	 *            the interface for the searchable object.
	 * @return the interface.
	 * @since V0.1.1 Nov 27, 2007
	 * @version Jul 26, 2018
	 */
	@SuppressWarnings("unchecked")
	public static final <T, I> Class<? extends I> findInterfaceForClass(final Class<T> searchableObjectClass,
			final Class<I> searchableInterface) {
		Class<? extends I> searchableObjectInterface = findSearchableObjectInterface(searchableObjectClass, searchableInterface);
		if (searchableObjectInterface == null) {
			if (searchableInterface.isAssignableFrom(searchableObjectClass)) {
				searchableObjectInterface = (Class<? extends I>) searchableObjectClass;
			} else {
				throw new ClassCastException(searchableObjectClass + " does not implement" + searchableInterface);
			}
		}
		return searchableObjectInterface;
	}

	/**
	 * Finds the interface that directly implements the searchable interface.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param <T>
	 *            the type of searchable object.
	 * @param <I>
	 *            the type of searchable interface.
	 * @param searchableObjectClass
	 *            the class of object to search.
	 * @param searchableInterface
	 *            the interface to match.
	 * @return the interface.
	 * @since V0.1.1 Nov 27, 2007
	 * @version Jul 26, 2018
	 */
	@SuppressWarnings("unchecked")
	private static final <T, I> Class<? extends I> findSearchableObjectInterface(final Class<T> searchableObjectClass,
			final Class<I> searchableInterface) {
		for (final Class<?> searchableObjectClassInterface : searchableObjectClass.getInterfaces()) {
			if (searchableObjectClassInterface == searchableInterface) {
				continue;
			} else if (searchableInterface.isAssignableFrom(searchableObjectClassInterface)) {
				final Class<? extends I> parentInterface = findSearchableObjectInterface(
						(Class<? extends I>) searchableObjectClassInterface, searchableInterface);
				return (parentInterface == null) ? (Class<? extends I>) searchableObjectClassInterface : parentInterface;
			}
		}
		return null;
	}

	/**
	 * Private constructor - this class should not be instantiated.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.1 Nov 27, 2007
	 * @version Jul 26, 2018
	 */
	private FinderFactoryHelper() {
	}
}
