/**
 * Copyright (C) 2009 by Ian Andrew Brown<br>
 * All Rights Reserved
 */

package usa.browntrask.utility;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 * Test for {@link SingletonIterator}.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.10.0 Apr 27, 2009
 * @version Apr 27, 2009
 */
public final class SingletonIteratorTest {

	/**
	 * the singleton iterator to test.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.10.0 Apr 27, 2009
	 * @version Apr 27, 2009
	 */
	private SingletonIterator<Object> iterator;

	/**
	 * the object to iterate over.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.10.0 Apr 27, 2009
	 * @version Apr 27, 2009
	 */
	private Object theObject;

	/**
	 * Sets up the {@link SingletonIterator} to test.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.10.0 Apr 27, 2009
	 * @version Apr 27, 2009
	 */
	@Before
	public final void setUpIterator() {
		theObject = new Object();
		iterator = new SingletonIterator<Object>(theObject);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.SingletonIterator#hasNext()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.10.0 Apr 27, 2009
	 * @version Apr 27, 2009
	 */
	@Test
	public final void testHasNext() {
		final boolean hasNext = iterator.hasNext();

		assertTrue("Initially the iterator should have a next", hasNext);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.SingletonIterator#next()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.10.0 Apr 27, 2009
	 * @version Apr 27, 2009
	 */
	@Test
	public final void testNext() {
		final Object next = iterator.next();

		assertSame("The object returned should be the one provided", theObject, next);
		assertFalse("There should be no more objects to iterate over", iterator.hasNext());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.SingletonIterator#next()} the second time.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.10.0 Apr 27, 2009
	 * @version Apr 27, 2009
	 */
	@Test(expected = NoSuchElementException.class)
	public final void testNext_secondTime() {
		try {
			iterator.next();
		} catch (final NoSuchElementException e) {
			fail("Initial run of iterator threw exception " + e);
		}

		iterator.next();
	}

	/**
	 * Test method for {@link usa.browntrask.utility.SingletonIterator#remove()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.10.0 Apr 27, 2009
	 * @version Apr 27, 2009
	 */
	@Test(expected = UnsupportedOperationException.class)
	public final void testRemove() {
		iterator.remove();
	}

	/**
	 * Test method for {@link usa.browntrask.utility.SingletonIterator#SingletonIterator(java.lang.Object)} for a null object.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.10.0 Apr 27, 2009
	 * @version Apr 27, 2009
	 */
	@Test(expected = NullPointerException.class)
	public final void testSingletonIterator_null() {
		new SingletonIterator<Object>(null);
	}

}
