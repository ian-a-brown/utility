/**
 * Copyright 2011 by Ian Andrew Brown<br>
 * All Rights Reserved
 */

package usa.browntrask.utility;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Abstract test for implementations of {@link HasValetModifiable}.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @param <H>
 *            the type of has valet modifiable.
 * @param <V>
 *            the type of valet.
 * @since V1.6.0 Mar 27, 2011
 * @version V1.6.0 Mar 27, 2011
 */
public abstract class AbstractHasValetModifiableCheck<H extends HasValetModifiable<V>, V extends Valet> {

	/**
	 * the object with a valet to test.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	private H hasValetModifiable;

	/**
	 * Sets up to test the object with a valet.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	@Before
	public final void setUpHasValetModifiable() {
		setUpForHasValetModifiable();
		setHasValetModifiable(createHasValetModifiable());
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
	public final void tearDownHasValetModifiable() {
		setHasValetModifiable(null);
		tearDownForHasValetModifiable();
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
		final V actualValet = getHasValetModifiable().getValet();

		assertNull("The valet is not set", actualValet);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.HasValetModifiable#setValet(Valet)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	@Test
	public final void testSetValet() {
		final V valet = createValet();

		getHasValetModifiable().setValet(valet);

		assertSame("The valet is set", valet, getHasValetModifiable().getValet());
	}

	/**
	 * Creates a has valet modifiable of the type to test;
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the has valet modifiable.
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	protected abstract H createHasValetModifiable();

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
	 * Gets the has valet modifiable.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the has valet modifiable.
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	protected final H getHasValetModifiable() {
		return hasValetModifiable;
	}

	/**
	 * Sets up to test the specific type of has valet modifiable.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	protected abstract void setUpForHasValetModifiable();

	/**
	 * Tears down the set up for the specific type of has valet after testing.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	protected abstract void tearDownForHasValetModifiable();

	/**
	 * Sets the has valet modifiable.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param hasValetModifiable
	 *            the has valet modifiable to set.
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	private final void setHasValetModifiable(final H hasValetModifiable) {
		this.hasValetModifiable = hasValetModifiable;
	}
}
