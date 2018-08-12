package usa.browntrask.utility.tables;

/**
 * Interface for objects that can be searched for tables.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.1 Nov 27, 2007
 * @version jul 26, 2018
 */
public interface SearchableTables {

    /**
     * Gets the path to the files containing the tables.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @return the file system path to the tables folder.
     * @since V0.1.1 Mar 8, 2008
     * @version Mar 8, 2008
     */
    String getTablePath();

}
