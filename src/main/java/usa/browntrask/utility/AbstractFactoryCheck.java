/**
 * Copyright 2011 by Ian Andrew Brown<br>
 * All Rights Reserved
 */

package usa.browntrask.utility;

import org.easymock.EasyMockSupport;
import org.junit.After;
import org.junit.Before;

/**
 * Abstract test for implementations of {@link Factory}.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @param <F>
 *            the type of factory to test.
 * @since V1.6.0 May 28, 2011
 * @version V1.6.0 May 28, 2011
 */
public abstract class AbstractFactoryCheck<F extends Factory> extends EasyMockSupport {

	/**
	 * the factory to test.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.6.0 May 28, 2011
	 * @version V1.6.0 May 28, 2011
	 */
	private F factory;

	/**
	 * Sets up the factory to test.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.6.0 May 28, 2011
	 * @version V1.6.0 May 28, 2011
	 */
	@Before
	public final void setUpFactory() {
		setUpFactoryType();
		setFactory(createFactory());
	}

	/**
	 * Tears down the factory after testing.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.6.0 May 28, 2011
	 * @version V1.6.0 May 28, 2011
	 */
	@After
	public final void tearDownFactory() {
		setFactory(null);
		tearDownFactoryType();
	}

	/**
	 * Creates a factory of the type to test.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the factory.
	 * @since V1.6.0 May 28, 2011
	 * @version V1.6.0 May 28, 2011
	 */
	protected abstract F createFactory();

	/**
	 * Gets the factory.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the factory.
	 * @since V1.6.0 May 28, 2011
	 * @version V1.6.0 May 28, 2011
	 */
	protected final F getFactory() {
		return factory;
	}

	/**
	 * Sets up to test the specific type of factory.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.6.0 May 28, 2011
	 * @version V1.6.0 May 28, 2011
	 */
	protected abstract void setUpFactoryType();

	/**
	 * Tears down the set up for the specific type of factory after testing.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.6.0 May 28, 2011
	 * @version V1.6.0 May 28, 2011
	 */
	protected abstract void tearDownFactoryType();

	/**
	 * Sets the factory.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param factory
	 *            the factory to set.
	 * @since V1.6.0 May 28, 2011
	 * @version V1.6.0 May 28, 2011
	 */
	private final void setFactory(final F factory) {
		this.factory = factory;
	}

}
