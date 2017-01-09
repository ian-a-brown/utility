/**
 * Copyright (C) 2008 by Ian Andrew Brown<br>
 * All Rights Reserved
 */
package usa.browntrask.find;

/**
 * Interface for objects used to locate {@link Findable} objects in {@link Searchable} objects.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @param <S>
 *            the type of object to be searched (the container).
 * @param <F>
 *            the type of object to be located.
 * @since V0.1.1 Aug 2, 2008
 * @version V1.3.0 Feb 6, 2010
 */
public interface Finder<S extends Searchable, F extends Findable<F>> {

	/**
	 * Finds the objects of the desired type matching the specified criteria in the container.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param container
	 *            the container to be searched for matching objects.
	 * @param criteria
	 *            the criteria to be met for matching those objects.
	 * @return the matching objects.
	 * @since V0.1.1 Aug 2, 2008
	 * @version V1.3.0 Feb 6, 2010
	 */
	Iterable<F> find(S container, Criteria<S, F> criteria);
}
