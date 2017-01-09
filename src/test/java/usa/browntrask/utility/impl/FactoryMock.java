/**
 * Copyright 2011 by Ian Andrew Brown<br>
 * All Rights Reserved
 */
package usa.browntrask.utility.impl;

import usa.browntrask.utility.Factory;

/**
 * Singleton mock implementation of {@link Factory} for use by {@link FactoryFinderImplTest}.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V1.7.0 May 3, 2011
 * @version V1.7.0 May 6, 2011
 */
public enum FactoryMock implements Factory {

	/**
	 * the singleton instance of the factory.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.7.0 May 3, 2011
	 * @version V1.7.0 May 6, 2011
	 */
	INSTANCE;

	/**
	 * Gets an instance of the factory.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the factory.
	 * @since V1.7.0 May 3, 2011
	 * @version V1.7.0 May 6, 2011
	 */
	public final static Factory getInstance() {
		return INSTANCE;
	}
}
