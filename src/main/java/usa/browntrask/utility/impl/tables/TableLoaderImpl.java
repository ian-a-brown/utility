/**
 * Copyright 2008, 2009, 2012 by Ian Andrew Brown<br>
 * All Rights Reserved
 */
package usa.browntrask.utility.impl.tables;

import usa.browntrask.utility.tables.JAXBLoader;
import usa.browntrask.utility.tables.LoadTableException;
import usa.browntrask.utility.tables.Table;
import usa.browntrask.utility.tables.TableFactory;
import usa.browntrask.utility.tables.TableLoader;
import usa.browntrask.utility.tables.xml.XmlTable;
import usa.browntrask.utility.tables.xml.XmlTableColumn;
import usa.browntrask.utility.tables.xml.XmlTableRow;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Implementation of {@link TableLoader} for the game of WotR En Garde.
 * <p>
 *
 * @author Ian Andrew Brown
 * @version Jul 26, 2018
 * @since V0.1.1 Feb 1, 2008
 */
final class TableLoaderImpl implements TableLoader {

    /**
     * the class to be loaded.
     * <p>
     *
     * @author Ian Andrew Brown
     * @version Jul 26, 2018
     * @since V0.1.1 Feb 2, 2008
     */
    static final Class<XmlTable> LOAD_CLASS = XmlTable.class;

    /**
     * the name of the package containing the objects to be loaded.
     * <p>
     *
     * @author Ian Andrew Brown
     * @version Jul 26, 2018
     * @since V0.1.1 Feb 2, 2008
     */
    static final String PACKAGE_NAME = "usa.browntrask.utility.tables.xml";

    /**
     * Constructs a table loader.
     * <p>
     *
     * @author Ian Andrew Brown
     * @version Jul 26, 2018
     * @since V0.1.1 Feb 2, 2008
     */
    TableLoaderImpl() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Table load(final String tablePath, final String tableName) {
        final Reader tableReader = acquireTableReader(tablePath, tableName);
        final XmlTable xmlTable = acquireXmlTable(tableReader);
        releaseTableReader(tableReader);

        final Table table = acquireTable(xmlTable.getName());
        addKeyColumnToTable(xmlTable, table);
        addColumnsToTable(xmlTable, table);
        addRowsToTable(xmlTable, table);
        return table;
    }

    /**
     * Acquires a table with the specified name.
     *
     * @param tableName the name of the table.
     * @return the table.
     */
    private final Table acquireTable(final String tableName) {
        final TableFactory factory = TableFactoryImpl.getInstance();
        return factory.createTable(tableName);
    }

    /**
     * Acquires a reader for the table.
     *
     * @param tablePath the path to the table.
     * @param tableName the name of the table.
     * @return the reader for the table.
     */
    private final Reader acquireTableReader(final String tablePath, final String tableName) {
        final File tableFile = new File(tablePath, tableName + ".xml");
        try {
            return new FileReader(tableFile);
        } catch (final FileNotFoundException e) {
            throw new LoadTableException("Cannot load table " + tableName + " from " + tablePath, e);
        }
    }

    /**
     * Acquires an XML table from the input reader.
     *
     * @param tableReader the table reader.
     * @return the XML table.
     */
    private final XmlTable acquireXmlTable(final Reader tableReader) {
        final JAXBLoader jaxbLoader = new JAXBLoaderImpl();
        return jaxbLoader.loadFromReader(PACKAGE_NAME, LOAD_CLASS, tableReader);
    }

    /**
     * Adds a column to a table row.
     * <p>
     *
     * @param rowIndex the index of the row.
     * @param column   the column to add, read via JAXB.
     * @param table    the regular table object.
     * @author Ian Andrew Brown
     * @version Jul 26, 2018
     * @since V0.1.1 Feb 2, 2008
     */
    private final void addColumnToTableRow(final int rowIndex, final XmlTableColumn column, final Table table) {
        table.setValue(rowIndex, column.getColumnName(), column.getValue());
    }

    /**
     * Adds the columns from the input En Garde table object to the regular table object.
     * <p>
     *
     * @param xmlTable the XML table object read via JAXB.
     * @param table    the regular table object.
     * @author Ian Andrew Brown
     * @version Jul 26, 2018
     * @since V0.1.1 Feb 2, 2008
     */
    private final void addColumnsToTable(final XmlTable xmlTable, final Table table) {
        for (final String columnName : xmlTable.getColumnName()) {
            table.addColumn(columnName);
        }
    }

    /**
     * Adds the key column (if any) from the input En Garde table object to the regular table object.
     * <p>
     *
     * @param xmlTable the XML table object read via JAXB.
     * @param table    the table object to update.
     * @author Ian Andrew Brown
     * @version Jul 26, 2018
     * @since V0.1.1 Feb 2, 2008
     */
    private final void addKeyColumnToTable(final XmlTable xmlTable, final Table table) {
        table.addKeyColumn(xmlTable.getKeyColumnName());
    }

    /**
     * Adds a row specified by the input En Garde table row object to the regular table object.
     * <p>
     *
     * @param row   the row to add, read via JAXB.
     * @param table the regular table object.
     * @author Ian Andrew Brown
     * @version Jul 26, 2018
     * @since V0.1.1 Feb 2, 2008
     */
    private final void addRowToTable(final XmlTableRow row, final Table table) {
        final int rowIndex = table.addRow(row.getRowName());
        for (final XmlTableColumn column : row.getColumn()) {
            addColumnToTableRow(rowIndex, column, table);
        }
    }

    /**
     * Adds the rows from the input En Garde table object to the regular table object.
     * <p>
     *
     * @param engardeTable the En Garde table object read via JAXB.
     * @param table        the regular table object.
     * @author Ian Andrew Brown
     * @version Jul 26, 2018
     * @since V0.1.1 Feb 2, 2008
     */
    private void addRowsToTable(final XmlTable engardeTable, final Table table) {
        for (final XmlTableRow row : engardeTable.getRow()) {
            addRowToTable(row, table);
        }
    }

    /**
     * Releases the table reader.
     *
     * @param tableReader the table reader.
     */
    private final void releaseTableReader(final Reader tableReader) {
        try {
            tableReader.close();
        } catch (final IOException e) {
            throw new LoadTableException("Failed to close table", e);
        }
    }
}
