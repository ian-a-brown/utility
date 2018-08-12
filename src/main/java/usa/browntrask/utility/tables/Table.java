package usa.browntrask.utility.tables;

import java.util.List;

/**
 * Interface for objects representing a table in the game of En Garde.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.1 Nov 6, 2007
 * @version Jul 26, 2018
 */
public interface Table {

    /**
     * Adds a column with the specified name to the table.
     * <p>
     *
     * @author Ian Andrew Brown
     * @param columnName the name of the column.
     * @return the index of the column.
     * @since V0.1.1 Nov 7, 2007
     * @version Dec 4, 2007
     * @throws IllegalTableException if there is already a column with the specified name.
     */
    int addColumn(String columnName);

    /**
     * Adds the column that acts as the key for finding a row.
     * <p>
     *
     * @author Ian Andrew Brown
     * @param columnName the name of the column.
     * @return the index of the column.
     * @since V0.1.1 Nov 15, 2007
     * @version Dec 4, 2007
     * @throws IllegalTableException if the key column has already been set.
     */
    int addKeyColumn(String columnName);

    /**
     * Adds a row specifying the value of its key column.
     * <p>
     *
     * @author Ian Andrew Brown
     * @param rowName the name of the row.
     * @return the row index.
     * @since V0.1.1 Nov 15, 2007
     * @version Dec 4, 2007
     * @throws IllegalTableException if there is already a row with the specified name.
     */
    int addRow(String rowName);

    /**
     * Returns the index of the column with the specified name.
     * <p>
     *
     * @author Ian Andrew Brown
     * @param columnName the name of the column.
     * @return the index of the column.
     * @since V0.1.1 Feb 18, 2008
     * @version Feb 18, 2008
     */
    int columnIndex(String columnName);

    /**
     * Gets the name of the table.
     * <p>
     *
     * @author Ian Andrew Brown
     * @return the name.
     * @since V0.1.1 Nov 28, 2007
     * @version Jul 26, 2018
     */
    String getName();

    /**
     * Gets the value at the specified row and column.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @param rowIndex the index of the desired row.
     * @param columnIndex the index of the desired column.
     * @return the value.
     * @since V0.1.1 Nov 7, 2007
     * @version Nov 7, 2007
     */
    String getValue(int rowIndex, int columnIndex);

    /**
     * Gets the value of the table entry on the specified row and in the specified column.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @param rowIndex the index of the row.
     * @param columnName the name of the column.
     * @return the value as a string.
     * @since V0.1.1 Nov 6, 2007
     * @version Nov 6, 2007
     */
    String getValue(int rowIndex, String columnName);

    /**
     * Gets the value of the table at the specified row and in the specified column.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @param rowName the name of the row.
     * @param columnName the name of the column.
     * @return the value.
     * @since V0.1.1 Nov 15, 2007
     * @version Nov 15, 2007
     */
    String getValue(String rowName, String columnName);

    /**
     * Returns the number of columns in the table.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @return the number of columns
     * @since V0.1.1 Feb 2, 2008
     * @version Feb 2, 2008
     */
    int numberOfColumns();

    /**
     * Returns the number of rows in the table.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @return the number of rows.
     * @since V0.1.1 Dec 25, 2007
     * @version Dec 25, 2007
     */
    int numberOfRows();

    /**
     * Returns the index of the row with the specified name.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @param rowName the name of the row.
     * @return the index of the row.
     * @since V0.1.1 Feb 18, 2008
     * @version Feb 18, 2008
     */
    int rowIndex(final String rowName);

    /**
     * Returns the names of the rows in the table.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @return the names of the rows in the table.
     * @since V0.1.1 Dec 29, 2007
     * @version Dec 29, 2007
     */
    List<String> rowNames();

    /**
     * Sets the value of the entry at the specified row and column.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @param rowIndex the index of the row.
     * @param columnIndex the index of the column.
     * @param value the value.
     * @since V0.1.1 Nov 7, 2007
     * @version Dec 4, 2007
     * @throws IllegalTableException if the value at the specified location has previously been set.
     */
    void setValue(int rowIndex, int columnIndex, String value);

    /**
     * Sets the value of the entry at the specified row and column.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @param rowIndex the index of the row.
     * @param columnName the name of the column.
     * @param value the value.
     * @since V0.1.1 Nov 15, 2007
     * @version Dec 4, 2007
     * @throws IllegalTableException if the value at the specified location has previously been set.
     */
    void setValue(int rowIndex, String columnName, String value);
}
