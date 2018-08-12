package usa.browntrask.utility.tables;

/**
 * Interface for objects that get {@link TableFinder} objects.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.1 Jun 22, 2008
 * @version Jul 26, 2018
 */
public interface TableFinderFactory {

	/**
	 * Gets a table finder to search objects of the specified class.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param <T>
	 *            the type of searchable tables class.
	 * @param searchableTablesClass
	 *            the searchable tables class.
	 * @return the table finder.
	 * @since V0.1.1 Nov 27, 2007
	 * @version May 9, 2008
	 */
	<T extends SearchableTables> TableFinder<T> getTableFinder(final Class<T> searchableTablesClass);

}