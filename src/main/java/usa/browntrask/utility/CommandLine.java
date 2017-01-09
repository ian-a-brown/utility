/*
 * Copyright © 2014 by Ian Andrew Brown
 * All rights reserved
 */
package usa.browntrask.utility;

import java.util.Map;

/**
 * Interface for objects that convert the command line arguments to a map.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V2.2.0 Apr 21, 2014
 * @version V2.2.0 Oct 4, 2014
 */
public interface CommandLine {

	/**
	 * the key used to indicate an argument w/o a switch.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V2.2.0 Apr 21, 2014
	 * @version V2.2.0 Apr 25, 2014
	 */
	String ARGUMENT = "<argument>";

	/**
	 * Converts the input command line arguments to a map.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param args
	 *            the command line arguments.
	 * @return the map.
	 * @since V2.2.0 Apr 21, 2014
	 * @version V2.2.0 Sep 1, 2014
	 */
	Map<String, Object> convertCommandLineToMap(String[] args);

	/**
	 * Extracts a parameter of the specified class from the map.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param map
	 *            the map by parameter key.
	 * @param parameter
	 *            the parameter key.
	 * @param clazz
	 *            the class of object to return.
	 * @return the object returned - this is either a value of the specified class, or an array of such values.
	 * @since V2.2.0 Apr 21, 2014
	 * @version V2.2.0 Oct 4, 2014
	 */
	<T> Object extractParameter(Map<String, Object> map, String parameter, Class<T> clazz);
}
