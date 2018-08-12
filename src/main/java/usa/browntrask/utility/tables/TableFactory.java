package usa.browntrask.utility.tables;


/**
 * Interface for objects that create {@link Table}s.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.1 Jun 22, 2008
 * @version Jul 26, 2018
 */
public interface TableFactory {

	/**
	 * Creates a Table object.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param tableName
	 *            the name of the table.
	 * @return the table object.
	 * @since V0.1.1 Nov 7, 2007
	 * @version Nov 10, 2007
	 */
	Table createTable(final String tableName);

}