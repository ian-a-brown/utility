/**
 * Copyright 2008, 2009, 2010, 2011 by Ian Andrew Brown<br>
 * All Rights Reserved
 */
package usa.browntrask.utility.impl.tables;

import usa.browntrask.utility.tables.JAXBLoader;
import usa.browntrask.utility.tables.JAXBLoaderException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.Reader;

/**
 * Implementation of a JAXB loader for the game of WotR En Garde.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.1 Feb 2, 2008
 * @version Jul 26, 2018
 */
public final class JAXBLoaderImpl implements JAXBLoader {

	/** {@inheritDoc} */
	@Override
	public final <O> O loadFromReader(final String packageName, final Class<O> classToRead, final Reader reader) {
		try {
			final JAXBContext context = JAXBContext.newInstance(packageName);
			final Unmarshaller unmarshaller = context.createUnmarshaller();
			@SuppressWarnings("unchecked")
			final JAXBElement<O> element = (JAXBElement<O>) unmarshaller.unmarshal(new StreamSource(reader));
			return element.getValue();

		} catch (final JAXBException e) {
			throw new JAXBLoaderException("Unable to set up JAXB context", e);
		}
	}

}
