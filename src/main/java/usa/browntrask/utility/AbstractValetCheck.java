/**
 * Copyright 2011, 2014 by Ian Andrew Brown<br>
 * All Rights Reserved
 */

package usa.browntrask.utility;

import org.easymock.EasyMockSupport;
import org.junit.After;
import org.junit.Before;

/**
 * Abstract test for implementations of {@link Valet}.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @param <V>
 *            the type of valet.
 * @since V1.6.0 Mar 27, 2011
 * @version V2.2.0 Sep 27, 2014
 */
public abstract class AbstractValetCheck<V extends Valet> extends EasyMockSupport {

	/**
	 * the valet to test.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	private V valet;

	/**
	 * Sets up the valet to test.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @throws Exception if there is a problem setting up the valet.
	 * @since V1.6.0 Mar 27, 2011
	 * @version V2.2.0 Sep 27, 2014
	 */
	@Before
	public final void setUpValet() throws Exception {
		setUpForValet();
		setValet(createValet());
	}

	/**
	 * Tears down after testing the valet.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @throws Exception if there is a problem tearing down the valet.
	 * @since V1.6.0 Mar 27, 2011
	 * @version V2.2.0 Sep 27, 2014
	 */
	@After
	public final void tearDownValet() throws Exception {
		setValet(null);
		tearDownForValet();
	}

	/**
	 * Creates a valet of the type to test.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the valet.
	 * @throws Exception if there is a problem creating the valet.
	 * @since V1.6.0 Mar 27, 2011
	 * @version V2.2.0 Sep 27, 2014
	 */
	protected abstract V createValet() throws Exception;

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
	 * Sets up anything required to test the specific type of valet.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	protected abstract void setUpForValet();

	/**
	 * Tears down the set up for the specific type of valet after testing.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @throws Exception if there is a problem tearing down the set up.
	 * @since V1.6.0 Mar 27, 2011
	 * @version V2.2.0 Sep 27, 2014
	 */
	protected abstract void tearDownForValet() throws Exception;

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
