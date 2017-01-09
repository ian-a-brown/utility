/**
 * Copyright 2011 by Ian Andrew Brown<br>
 * All Rights Reserved
 */
package usa.browntrask.utility;

import java.util.Properties;

/**
 * Interface for objects that find factory objects.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @param <F>
 *            the type of factory to find.
 * @since V1.7.0 May 3, 2011
 * @version V1.7.0 May 6, 2011
 */
public interface FactoryFinder<F extends Factory> {

	/**
	 * Finds the factory by the specified name using the properties.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param properties
	 *            the properties to use.
	 * @param factoryName
	 *            the name of the factory.
	 * @return the factory.
	 * @since V1.7.0 May 3, 2011
	 * @version V1.7.0 May 6, 2011
	 */
	F findFactory(Properties properties, String factoryName);
}
