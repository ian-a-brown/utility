package usa.browntrask.utility.tables;

/**
 * Interface for objects that create {@link TableLoader}s to load {@link Table} objects.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.1 Jun 24, 2008
 * @version Jul 26, 2018
 */
public interface TableLoaderFactory {

	/**
	 * Creates a table loader.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the table loader.
	 * @since V0.1.1 Feb 1, 2008
	 * @version Jul 26, 2018
	 */
	TableLoader createTableLoader();
}