/**
 * Copyright 2008, 2009, 2010, 2011, 2012 by Ian Andrew Brown<br>
 * All Rights Reserved
 */
package usa.browntrask.utility.impl.tables;

import usa.browntrask.utility.tables.TableLoader;
import usa.browntrask.utility.tables.TableLoaderFactory;

/**
 * Factory object to create table loaders for the game of WotR En Garde.
 * <p>
 *
 * @author Ian Andrew Brown
 * @version Jul 26, 2018
 * @since V0.1.1 Feb 1, 2008
 */
public enum TableLoaderFactoryImpl implements TableLoaderFactory {

    /**
     * the singleton instance of the factory.
     * <p>
     *
     * @author Ian Andrew Brown
     * @version Jul 26, 2018
     * @since V0.1.1 Jul 14, 2008
     */
    INSTANCE;

    /**
     * Gets an instance of the factory.
     * <p>
     *
     * @return the factory instance.
     * @author Ian Andrew Brown
     * @version Jul 26, 2018
     * @since V0.1.1 Aug 8, 2009
     */
    public final static TableLoaderFactory getInstance() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final TableLoader createTableLoader() {
        return new TableLoaderImpl();
    }
}
