package usa.browntrask.utility.tables;

/**
 * Interface for objects that can find tables.
 * <p>
 * 
 * @param <T>
 *                the searchable tables type.
 * @author Ian Andrew Brown
 * @since V0.1.1 Nov 27, 2007
 * @version Jul 26, 2018
 */
public interface TableFinder<T extends SearchableTables> {

    /**
     * Finds the table with the specified name.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @param searchableTables
     *                the object to search.
     * @param tableName
     *                the name of the table.
     * @return the table.
     * @throws IllegalNameException
     *                 if the table name is null.
     * @since V0.1.1 Nov 27, 2007
     * @version Dec 4, 2007
     */
    Table findTableByName(T searchableTables, String tableName);
}
