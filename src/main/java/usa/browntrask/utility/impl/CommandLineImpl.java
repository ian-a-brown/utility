/*
 * Copyright © 2014 by Ian Andrew Brown
 * All rights reserved
 */
package usa.browntrask.utility.impl;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import usa.browntrask.utility.CommandLine;

/**
 * Implementation of {@link CommandLine}.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V2.2.0 Apr 25, 2014
 * @version V2.2.0 May 11, 2014
 */
public final class CommandLineImpl implements CommandLine {

	/** {@inheritDoc} */
	@Override
	public final Map<String, Object> convertCommandLineToMap(final String[] args) {
		final Map<String, Object> map = new LinkedHashMap<String, Object>();
		for (int idx = 0; idx < args.length; ++idx) {
			if (args[idx].equals("-")) {
				continue;
			} else if (args[idx].startsWith("-")) {
				if ((idx == args.length - 1) || args[idx + 1].startsWith("-")) {
					addValueToParameter(map, args[idx], true);
				} else {
					addValueToParameter(map, args[idx], args[idx + 1]);
					++idx;
				}
			} else {
				addValueToParameter(map, ARGUMENT, args[idx]);
			}
		}
		return map;
	}

	/** {@inheritDoc} */
	@Override
	public final <T> Object extractParameter(final Map<String, Object> map,
			final String argument, final Class<T> clazz) {
		final Object value = map.get(argument);
		if (clazz == Boolean.class) {
			return value != null;

		} else if (clazz == String.class) {
			return value;
			
		} else if (clazz == Long.class) {
			return (value instanceof Long) ? (Long) value : Long.parseLong(value.toString());
		}
		
		return null;
	}

	/**
	 * Adds a value for a parameter to the map.
	 * <p>
	 * @author Ian Andrew Brown
	 * @param map the map of parameters and their values.
	 * @param parameter the parameter.
	 * @param value the value to add.
	 * @since V2.2.0 Sep 1, 2014
	 * @version V2.2.0 Sep 1, 2014
	 */
	@SuppressWarnings("unchecked")
	private final void addValueToParameter(final Map<String, Object> map, final String parameter, final Object value) {
		Object parameterValue = map.get(parameter);
		if (parameterValue == null) {
			map.put(parameter, value);
		} else if (value instanceof Boolean) {
			map.put(parameter, value);
		} else if (value instanceof String) {
			final List<String> strings = new LinkedList<String>(Arrays.asList((String) parameterValue, (String) value));
			map.put(parameter, strings);
		} else {
			((List<String>) parameterValue).add((String) value);
		}
	}
}
