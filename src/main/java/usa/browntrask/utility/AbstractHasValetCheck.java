/**
 * Copyright 2011 by Ian Andrew Brown<br>
 * All Rights Reserved
 */

package usa.browntrask.utility;

import static org.junit.Assert.assertSame;

import org.easymock.EasyMockSupport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Abstract test for implementations of {@link HasValet}.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @param <H>
 *            the type of has valet.
 * @param <V>
 *            the type of valet.
 * @since V1.6.0 Mar 27, 2011
 * @version V1.6.1 Apr 24, 2011
 */
public abstract class AbstractHasValetCheck<H extends HasValet<V>, V extends Valet> extends EasyMockSupport {

	/**
	 * the object with a valet to test.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	private H hasValet;

	/**
	 * the valet.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	private V valet;

	/**
	 * Sets up to test the object with a valet.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	@Before
	public final void setUpHasValet() {
		setUpForHasValet();
		setValet(createValet());
		setHasValet(createHasValet(getValet()));
	}

	/**
	 * Tears down after testing the object with a valet.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	@After
	public final void tearDownHasValet() {
		setHasValet(null);
		setValet(null);
		tearDownForHasValet();
	}

	/**
	 * Test method for {@link usa.browntrask.utility.HasValet#getValet()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	@Test
	public final void testGetValet() {
		final V actualValet = getHasValet().getValet();

		assertSame("The valet is set", getValet(), actualValet);
	}

	/**
	 * Creates a has valet of the type to test using the valet to acquire resources.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param valet
	 *            the valet.
	 * @return the has valet.
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	protected abstract H createHasValet(V valet);

	/**
	 * Creates a valet of the type to test.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the valet.
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	protected abstract V createValet();

	/**
	 * Gets the has valet.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the has valet.
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	protected final H getHasValet() {
		return hasValet;
	}

	/**
	 * Gets the valet.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the valet.
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	protected final V getValet() {
		return valet;
	}

	/**
	 * Sets up to test the specific type of has valet.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	protected abstract void setUpForHasValet();

	/**
	 * Tears down the set up for the specific type of has valet after testing.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	protected abstract void tearDownForHasValet();

	/**
	 * Sets the has valet.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param hasValet
	 *            the has valet to set.
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	private final void setHasValet(final H hasValet) {
		this.hasValet = hasValet;
	}

	/**
	 * Sets the valet.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param valet
	 *            the valet to set.
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	private final void setValet(final V valet) {
		this.valet = valet;
	}

}
