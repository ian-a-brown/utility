/**
 * Copyright 2007, 2008, 2009, 2010, 2011 by Ian Andrew Brown<br>
 * All Rights Reserved
 */
package usa.browntrask.utility.impl.tables;

import usa.browntrask.utility.tables.Table;
import usa.browntrask.utility.tables.TableFactory;

/**
 * Factory object to create Table objects for the game of En Garde.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.1 Nov 7, 2007
 * @version Jul 26, 2018
 */
public enum TableFactoryImpl implements TableFactory {

	/**
	 * the singleton instance of the factory.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.1 Jul 13, 2008
	 * @version Jul 13, 2008
	 */
	INSTANCE;

	/**
	 * Gets an instance of the factory.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the factory instance.
	 * @since V0.1.1 Aug 8, 2009
	 * @version Aug 8, 2009
	 */
	public final static TableFactory getInstance() {
		return INSTANCE;
	}

	/** {@inheritDoc} */
	@Override
	public final Table createTable(final String tableName) {
		return new TableImpl(tableName);
	}
}
