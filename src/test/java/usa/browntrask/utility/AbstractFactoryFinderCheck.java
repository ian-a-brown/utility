/**
 * Copyright 2011 by Ian Andrew Brown<br>
 * All Rights Reserved
 */
package usa.browntrask.utility;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import usa.browntrask.test.Utility;

/**
 * Abstract test for implementations of {@link FactoryFinder}.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @param <L>
 *            the type of factory finder to test.
 * @param <F>
 *            the type of factory to find.
 * @since V1.7.0 May 3, 2011
 * @version V1.7.0 May 6, 2011
 */
public abstract class AbstractFactoryFinderCheck<L extends FactoryFinder<F>, F extends Factory> {

	/**
	 * the factory finder to test.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.7.0 May 3, 2011
	 * @version V1.7.0 May 3, 2011
	 */
	private L factoryFinder;

	/**
	 * Sets up to test the factory finder.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.7.0 May 3, 2011
	 * @version V1.7.0 May 6, 2011
	 */
	@Before
	public final void setUpFactoryFinder() {
		setUpFactoryFinderType();
		setFactoryFinder(createFactoryFinder());
	}

	/**
	 * Tears down after testing the factory finder.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.7.0 May 3, 2011
	 * @version V1.7.0 May 3, 2011
	 */
	@After
	public final void tearDownFactoryFinder() {
		setFactoryFinder(null);
		tearDownFactoryFinderType();
	}

	/**
	 * Test method for {@link usa.browntrask.utility.FactoryFinder#findFactory(java.util.Properties, java.lang.String)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.7.0 May 3, 2011
	 * @version V1.7.0 May 6, 2011
	 */
	@Test
	public final void testFindFactory() {
		final Properties properties = new Properties();
		final String factoryName = Utility.nextFormattedString("factory", "Name");
		properties.put(factoryName, chooseFactory());

		final F factory = getFactoryFinder().findFactory(properties, factoryName);

		assertFactory(factory);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.FactoryFinder#findFactory(java.util.Properties, java.lang.String)} for the case
	 * where the factory specified cannot be found.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.7.0 May 3, 2011
	 * @version V1.7.0 May 6, 2011
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testFindFactory_noFactory() {
		final Properties properties = new Properties();
		final String factoryName = Utility.nextFormattedString("factory", "Name");
		properties.put(factoryName, "No such factory");

		getFactoryFinder().findFactory(properties, factoryName);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.FactoryFinder#findFactory(java.util.Properties, java.lang.String)} for the case
	 * where no factory name is provided.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.7.0 May 3, 2011
	 * @version V1.7.0 May 6, 2011
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testFindFactory_noFactoryName() {
		final Properties properties = new Properties();

		getFactoryFinder().findFactory(properties, null);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.FactoryFinder#findFactory(java.util.Properties, java.lang.String)} for the case
	 * where no properties are provided.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.7.0 May 3, 2011
	 * @version V1.7.0 May 6, 2011
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testFindFactory_noProperties() {
		getFactoryFinder().findFactory(null, null);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.FactoryFinder#findFactory(java.util.Properties, java.lang.String)} for the case
	 * where no property for the factory name is provided.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.7.0 May 3, 2011
	 * @version V1.7.0 May 6, 2011
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testFindFactory_noPropertyForFactoryName() {
		final Properties properties = new Properties();
		final String factoryName = Utility.nextFormattedString("factory", "Name");

		getFactoryFinder().findFactory(properties, factoryName);
	}

	/**
	 * Custom assertion to ensure that the factory is the correct one.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param factory
	 *            the factory.
	 * @since V1.7.0 May 3, 2011
	 * @version V1.7.0 May 6, 2011
	 */
	protected abstract void assertFactory(F factory);

	/**
	 * Choose a factory to test.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the factory specification for the factory finder.
	 * @since V1.7.0 May 3, 2011
	 * @version V1.7.0 May 6, 2011
	 */
	protected abstract String chooseFactory();

	/**
	 * Creates a factory finder of the type to test.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the factory finder.
	 * @since V1.7.0 May 3, 2011
	 * @version V1.7.0 May 6, 2011
	 */
	protected abstract L createFactoryFinder();

	/**
	 * Gets the factory finder.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the factory finder.
	 * @since V1.7.0 May 3, 2011
	 * @version V1.7.0 May 6, 2011
	 */
	protected final L getFactoryFinder() {
		return factoryFinder;
	}

	/**
	 * Sets up to test the specific type of factory finder.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.7.0 May 3, 2011
	 * @version V1.7.0 May 6, 2011
	 */
	protected abstract void setUpFactoryFinderType();

	/**
	 * Tears down the set up for the specific type of factory finder after testing.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.7.0 May 3, 2011
	 * @version V1.7.0 May 6, 2011
	 */
	protected abstract void tearDownFactoryFinderType();

	/**
	 * Sets the factory finder.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param factoryFinder
	 *            the factory finder to set.
	 * @since V1.7.0 May 3, 2011
	 * @version V1.7.0 May 6, 2011
	 */
	private final void setFactoryFinder(final L factoryFinder) {
		this.factoryFinder = factoryFinder;
	}

}
