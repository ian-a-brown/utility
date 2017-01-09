/**
 * Copyright 2011 by Ian Andrew Brown<br>
 * All Rights Reserved
 */
package usa.browntrask.utility.impl;

import static org.junit.Assert.assertEquals;
import usa.browntrask.utility.AbstractFactoryFinderCheck;
import usa.browntrask.utility.Factory;

/**
 * Extended {@link AbstractFactoryFinderCheck} test for {@link FactoryFinderImpl}.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V1.7.0 May 3, 2011
 * @version V1.7.0 May 6, 2011
 */
public final class FactoryFinderImplTest extends AbstractFactoryFinderCheck<FactoryFinderImpl<Factory>, Factory> {

	/** {@inheritDoc} */
	@Override
	protected final void assertFactory(final Factory factory) {
		assertEquals("The factory is the correct class", FactoryMock.class, factory.getClass());
	}

	/** {@inheritDoc} */
	@Override
	protected final String chooseFactory() {
		return FactoryMock.class.getName();
	}

	/** {@inheritDoc} */
	@Override
	protected final FactoryFinderImpl<Factory> createFactoryFinder() {
		return new FactoryFinderImpl<Factory>();
	}

	/** {@inheritDoc} */
	@Override
	protected final void setUpFactoryFinderType() {
	}

	/** {@inheritDoc} */
	@Override
	protected final void tearDownFactoryFinderType() {
	}

}
