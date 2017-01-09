/**
 * Copyright 2009, 2010, 2011 by Ian Andrew Brown<br>
 * All Rights Reserved
 */

package usa.browntrask.utility;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;

import usa.browntrask.annotations.ThreadSafe;

/**
 * Implementation of an iterator on a single object.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @param <T>
 *            the type of object to iterate over.
 * @since V0.10.0 Apr 27, 2009
 * @version V1.6.0 Feb 2, 2011
 */
@ThreadSafe(author = "Ian Andrew Brown", synopsis = "The object passed in is stored in a final field and cannot be accessed directly from the outside. The iterator tracks its progress using an atomic")
public final class SingletonIterator<T> implements Iterator<T> {

	/**
	 * has this iterator been run?
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.10.0 Apr 27, 2009
	 * @version Apr 27, 2009
	 */
	private final AtomicBoolean iterated = new AtomicBoolean(false);

	/**
	 * the singleton object to iterate over.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.10.0 Apr 27, 2009
	 * @version Apr 27, 2009
	 */
	private final T object;

	/**
	 * Constructs a singleton iterator for the input object.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param object
	 *            the object to "iterate" over.
	 * @since V0.10.0 Apr 27, 2009
	 * @version Apr 27, 2009
	 */
	public SingletonIterator(final T object) {
		if (object == null) {
			throw new NullPointerException("An object to be iterated over must be provided");
		}
		this.object = object;
	}

	/** {@inheritDoc} */
	@Override
	public final boolean hasNext() {
		return !iterated.get();
	}

	/** {@inheritDoc} */
	@Override
	public final T next() {
		if (iterated.getAndSet(true)) {
			throw new NoSuchElementException("Singleton iterator has already iterated over the object");
		}
		return object;
	}

	/** {@inheritDoc} */
	@Override
	public final void remove() {
		throw new UnsupportedOperationException("Removal of the singleton object is not supported");
	}

}
