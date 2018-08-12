package usa.browntrask.utility.tables;

/**
 * Interface for objects that load tables into the game of En Garde.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.1 Feb 1, 2008
 * @version Jul 26, 2018
 */
public interface TableLoader {

    /**
     * Loads the specified table from the table path.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @param tablePath the path to the folder containing the tables.
     * @param tableName the name of the table.
     * @return the table.
     * @since V0.1.1 Feb 1, 2008
     * @version Feb 1, 2008
     */
    Table load(String tablePath, String tableName);
}
