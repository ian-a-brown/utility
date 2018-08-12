package usa.browntrask.utility.tables;

import java.io.Reader;

/**
 * Interface for objects that load other objects via JAXB.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.1 Feb 2, 2008
 * @version Jul 26, 2018
 */
public interface JAXBLoader {

    /**
     * Loads an object of the expected type from a reader.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @param packageName name of the package to read.
     * @param classToRead the class to be read.
     * @param reader the reader to use.
     * @param <O> the type of object to load.
     * @return the object read.
     * @since V0.1.1 Feb 2, 2008
     * @version Feb 2, 2008
     */
    <O extends Object> O loadFromReader(String packageName, Class<O> classToRead, Reader reader);
}
