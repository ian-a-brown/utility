/**
 * Copyright 2011 by Ian Andrew Brown<br>
 * All Rights Reserved
 */
package usa.browntrask.utility.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import usa.browntrask.utility.Factory;
import usa.browntrask.utility.FactoryFinder;

/**
 * Implementation of {@link FactoryFinder} that assumes that the name of the factory class is stored in the properties under the
 * factory name.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @param <F>
 *            the type of factory to find.
 * @since V1.7.0 May 3, 2011
 * @version V1.7.0 May 6, 2011
 */
public final class FactoryFinderImpl<F extends Factory> implements FactoryFinder<F> {

	/** {@inheritDoc} */
	@SuppressWarnings("unchecked")
	@Override
	public final F findFactory(final Properties properties, final String factoryName) {
		if (properties == null) {
			throw new IllegalArgumentException("Properties must be provided to find factory " + factoryName);
		} else if (factoryName == null) {
			throw new IllegalArgumentException("A factory name must be provided");
		}

		final String factoryClassName = (String) properties.get(factoryName);
		if (factoryClassName == null) {
			throw new IllegalArgumentException("A property for " + factoryName + " must be provided");
		}

		try {
			final Class<F> factoryClass = (Class<F>) Class.forName(factoryClassName);
			final Method getInstanceMethod = factoryClass.getMethod("getInstance");
			return (F) getInstanceMethod.invoke(null);
		} catch (final ClassNotFoundException e) {
			throw new IllegalArgumentException("Cannot find class " + factoryClassName + " for " + factoryName, e);
		} catch (final SecurityException e) {
			throw new IllegalArgumentException(factoryClassName + " for " + factoryName
					+ " does not properly implement getInstance()", e);
		} catch (final NoSuchMethodException e) {
			throw new IllegalArgumentException(factoryClassName + " for " + factoryName
					+ " does not properly implement getInstance()", e);
		} catch (final IllegalAccessException e) {
			throw new IllegalArgumentException(factoryClassName + " for " + factoryName
					+ " does not properly implement getInstance()", e);
		} catch (final InvocationTargetException e) {
			throw new IllegalArgumentException(factoryClassName + " for " + factoryName
					+ " does not properly implement getInstance()", e);
		}
	}

}
