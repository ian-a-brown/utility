/**
 * Copyright 2008, 2010, 2015 by Ian Andrew Brown<br>
 * All Rights Reserved
 */
package usa.browntrask.find;

/**
 * Interface for objects that can be used to determine if an object of the type to be found is one that should be found.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @param <S>
 *            the type of object to search.
 * @param <F>
 *            the type of object to be found.
 * @since V0.1.1 Aug 2, 2008
 * @version V2.2.0 Feb 28, 2015
 */
public interface Criteria<S extends Searchable, F extends Findable<F>> {

	/**
	 * Determine if the input object to be checked matches the criteria or if it should be ordered before or after objects matching
	 * the criteria.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param container
	 *            the container being searched.
	 * @param check
	 *            the object to be matched.
	 * @return the result of the match: 0 means match, &lt;0 means the object comes before those that match, &gt;0 means the object comes
	 *         after those that match.
	 * @since V0.1.1 Aug 2, 2008
	 * @version V2.2.0 Feb 28, 2015
	 */
	int match(S container, F check);
}
