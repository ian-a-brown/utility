/*
 * Copyright © 2014, 2015 by Ian Andrew Brown All rights reserved
 */
package usa.browntrask.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import usa.browntrask.test.Utility;

/**
 * Abstract test for implementations of {@link CommandLine}.
 * <p>
 *
 * @author Ian Andrew Brown
 * @param <L>
 *            the type of command line to test.
 * @since V2.2.0 Apr 25, 2014
 * @version V2.2.0 Jan 31, 2015
 */
public abstract class AbstractCommandLineCheck<L extends CommandLine> {

	/**
	 * the command line object to test.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V2.2.0 Apr 25, 2014
	 * @version V2.2.0 Apr 25, 2014
	 */
	private CommandLine commandLine;

	/**
	 * Sets up to test a command line object.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V2.2.0 Apr 25, 2014
	 * @version V2.2.0 Apr 25, 2014
	 */
	@Before
	public final void setUpCommandLine() {
		setCommandLine(createCommandLine());
	}

	/**
	 * Tears down the command line object.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V2.2.0 Apr 25, 2014
	 * @version V2.2.0 Apr 25, 2014
	 */
	@After
	public final void tearDownCommandLine() {
		setCommandLine(null);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.CommandLine#convertCommandLineToMap(java.lang.String[])} for the case where
	 * there are no arguments.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V2.2.0 Apr 25, 2014
	 * @version V2.2.0 Apr 25, 2014
	 */
	@Test
	public final void testConvertCommandLineToMap_noArguments() {
		final String[] args = new String[0];

		final Map<String, Object> actualMap = getCommandLine().convertCommandLineToMap(args);

		assertTrue("The returned map is empty", actualMap.isEmpty());
	}

	/**
	 * Test method for {@link usa.browntrask.utility.CommandLine#convertCommandLineToMap(java.lang.String[])} for the case where
	 * there are no parameters.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V2.2.0 Apr 25, 2014
	 * @version V2.2.0 Sep 1, 2014
	 */
	@Test
	public final void testConvertCommandLineToMap_noParameters() {
		final String argument1 = Utility.nextString();
		final String argument2 = Utility.nextString();
		final String[] args = new String[] { argument1, argument2 };

		final Map<String, Object> actualMap = getCommandLine().convertCommandLineToMap(args);

		assertEquals("The returned map has one entry", 1, actualMap.size());
		assertTrue("The map contains the key " + CommandLine.ARGUMENT, actualMap.containsKey(CommandLine.ARGUMENT));
		final Object actualValue = actualMap.get(CommandLine.ARGUMENT);
		final List<String> expectedValue = Arrays.asList(args);
		assertEquals("The value list is returned for the key " + CommandLine.ARGUMENT, expectedValue, actualValue);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.CommandLine#convertCommandLineToMap(java.lang.String[])} for the case where
	 * there is a parameter that is provided multiple times.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V2.2.0 Sep 1, 2014
	 * @version V2.2.0 Sep 1, 2014
	 */
	@Test
	public final void testConvertCommandLineToMap_parameterMultipleTimes() {
		final String parameter = "-" + Utility.nextString();
		final String value1 = Utility.nextString();
		final String value2 = Utility.nextString();
		final String[] args = new String[] { parameter, value1, parameter, value2 };

		final Map<String, Object> actualMap = getCommandLine().convertCommandLineToMap(args);

		assertEquals("The returned map has one entry", 1, actualMap.size());
		assertTrue("The map contains the key " + parameter, actualMap.containsKey(parameter));
		final Object actualValue = actualMap.get(parameter);
		final List<String> expectedValue = Arrays.asList(value1, value2);
		assertEquals("The value is returned for the key " + parameter, expectedValue, actualValue);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.CommandLine#convertCommandLineToMap(java.lang.String[])} for the case where
	 * there is a parameter with no value.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V2.2.0 Sep 1, 2014
	 * @version V2.2.0 Sep 1, 2014
	 */
	@Test
	public final void testConvertCommandLineToMap_parameterNoValue() {
		final String parameter = "-" + Utility.nextString();
		final String[] args = new String[] { parameter };

		final Map<String, Object> actualMap = getCommandLine().convertCommandLineToMap(args);

		assertEquals("The returned map has one entry", 1, actualMap.size());
		assertTrue("The map contains the key " + parameter, actualMap.containsKey(parameter));
		final Object actualValue = actualMap.get(parameter);
		final Boolean expectedValue = true;
		assertEquals("The value is returned for the key " + parameter, expectedValue, actualValue);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.CommandLine#convertCommandLineToMap(java.lang.String[])} for the case where
	 * there is a parameter with no value followed by an argument.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V2.2.0 Sep 1, 2014
	 * @version V2.2.0 Sep 1, 2014
	 */
	@Test
	public final void testConvertCommandLineToMap_parameterNoValueArgument() {
		final String parameter = "-" + Utility.nextString();
		final String argument = Utility.nextString();
		final String[] args = new String[] { parameter, "-", argument };

		final Map<String, Object> actualMap = getCommandLine().convertCommandLineToMap(args);

		assertEquals("The returned map has two entries", 2, actualMap.size());
		assertTrue("The map contains the key " + parameter, actualMap.containsKey(parameter));
		final Object actualValue = actualMap.get(parameter);
		final Boolean expectedValue = true;
		assertEquals("The value is returned for the key " + parameter, expectedValue, actualValue);
		assertTrue("The map contains the key " + CommandLine.ARGUMENT, actualMap.containsKey(CommandLine.ARGUMENT));
		final Object actualArgument = actualMap.get(CommandLine.ARGUMENT);
		assertEquals("The argument is returned for the key " + CommandLine.ARGUMENT, argument, actualArgument);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.CommandLine#convertCommandLineToMap(java.lang.String[])} for the case where
	 * there is a parameter with a value.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V2.2.0 Sep 1, 2014
	 * @version V2.2.0 Sep 1, 2014
	 */
	@Test
	public final void testConvertCommandLineToMap_parameterWithValue() {
		final String parameter = "-" + Utility.nextString();
		final String value = Utility.nextString();
		final String[] args = new String[] { parameter, value };

		final Map<String, Object> actualMap = getCommandLine().convertCommandLineToMap(args);

		assertEquals("The returned map has one entry", 1, actualMap.size());
		assertTrue("The map contains the key " + parameter, actualMap.containsKey(parameter));
		final Object actualValue = actualMap.get(parameter);
		assertEquals("The value is returned for the key " + parameter, value, actualValue);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.CommandLine#convertCommandLineToMap(java.lang.String[])} for the case where
	 * there is a parameter with a value, followed by an argument.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V2.2.0 Sep 1, 2014
	 * @version V2.2.0 Sep 1, 2014
	 */
	@Test
	public final void testConvertCommandLineToMap_parameterWithValueArgument() {
		final String parameter = "-" + Utility.nextString();
		final String value = Utility.nextString();
		final String argument = Utility.nextString();
		final String[] args = new String[] { parameter, value, argument };

		final Map<String, Object> actualMap = getCommandLine().convertCommandLineToMap(args);

		assertEquals("The returned map has two entries", 2, actualMap.size());
		assertTrue("The map contains the key " + parameter, actualMap.containsKey(parameter));
		final Object actualValue = actualMap.get(parameter);
		assertEquals("The value is returned for the key " + parameter, value, actualValue);
		assertTrue("The map contains the key " + CommandLine.ARGUMENT, actualMap.containsKey(CommandLine.ARGUMENT));
		final Object actualArgument = actualMap.get(CommandLine.ARGUMENT);
		assertEquals("The argument is returned for key " + CommandLine.ARGUMENT, argument, actualArgument);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.CommandLine#extractParameter(java.util.Map, java.lang.String, java.lang.Class)}
	 * for the case where the parameter is an argument and there were multiple.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V2.2.0 Apr 25, 2014
	 * @version V2.2.0 Jan 31, 2015
	 */
	@Test
	public final void testExtractParameter_argument() {
		final Map<String, Object> map = new LinkedHashMap<String, Object>();
		final String argument1 = Utility.nextString();
		final String argument2 = Utility.nextString();
		final List<String> expectedValue = Arrays.asList(argument1, argument2);
		map.put(CommandLine.ARGUMENT, expectedValue);

		final Object actualValue = getCommandLine().extractParameter(map, CommandLine.ARGUMENT, String.class);

		assertEquals("The arguments are returned", expectedValue, actualValue);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.CommandLine#extractParameter(java.util.Map, java.lang.String, java.lang.Class)}
	 * for the case where there are no parameters.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V2.2.0 Apr 25, 2014
	 * @version V2.2.0 Sep 1, 2014
	 */
	@Test
	public final void testExtractParameter_noParameters() {
		final Map<String, Object> map = new LinkedHashMap<String, Object>();
		final String parameter = "-" + Utility.nextString();

		final Object actualValue = getCommandLine().extractParameter(map, parameter, String.class);

		assertNull("No value is returned", actualValue);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.CommandLine#extractParameter(java.util.Map, java.lang.String, java.lang.Class)}
	 * for the case where there are no parameters and the expected value is boolean.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V2.2.0 Apr 25, 2014
	 * @version V2.2.0 Sep 1, 2014
	 */
	@Test
	public final void testExtractParameter_noParametersBoolean() {
		final Map<String, Object> map = new LinkedHashMap<String, Object>();
		final String parameter = "-" + Utility.nextString();

		final Object actualValue = getCommandLine().extractParameter(map, parameter, Boolean.class);

		assertFalse("A false value is returned", (Boolean) actualValue);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.CommandLine#extractParameter(java.util.Map, java.lang.String, java.lang.Class)}
	 * for the case where the parameter does not exist.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V2.2.0 Apr 25, 2014
	 * @version V2.2.0 Sep 1, 2014
	 */
	@Test
	public final void testExtractParameter_noSuchParameter() {
		final Map<String, Object> map = new LinkedHashMap<String, Object>();
		final String parameter = "-" + Utility.nextString();
		map.put(CommandLine.ARGUMENT, Utility.nextString());

		final Object actualValue = getCommandLine().extractParameter(map, parameter, String.class);

		assertNull("No value is returned", actualValue);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.CommandLine#extractParameter(java.util.Map, java.lang.String, java.lang.Class)}
	 * for the case where the parameter does exist.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V2.2.0 Apr 25, 2014
	 * @version V2.2.0 Sep 1, 2014
	 */
	@Test
	public final void testExtractParameter_parameter() {
		final Map<String, Object> map = new LinkedHashMap<String, Object>();
		final String parameter = "-" + Utility.nextString();
		final String value = Utility.nextString();
		map.put(parameter, value);

		final Object actualValue = getCommandLine().extractParameter(map, parameter, String.class);

		assertEquals("The value is returned", value, actualValue);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.CommandLine#extractParameter(java.util.Map, java.lang.String, java.lang.Class)}
	 * for the case where the parameter is boolean.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V2.2.0 Apr 25, 2014
	 * @version V2.2.0 Sep 1, 2014
	 */
	@Test
	public final void testExtractParameter_parameterBoolean() {
		final Map<String, Object> map = new LinkedHashMap<String, Object>();
		final String parameter = "-" + Utility.nextString();
		map.put(parameter, true);

		final Object actualValue = getCommandLine().extractParameter(map, parameter, String.class);

		assertTrue("The value is returned", (Boolean) actualValue);
	}

	/**
	 * Test method for {@link usa.browntrask.utility.CommandLine#extractParameter(java.util.Map, java.lang.String, java.lang.Class)}
	 * for the case where the parameter is a long.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V2.2.0 Jan 31, 2015
	 * @version V2.2.0 Jan 31, 2015
	 */
	@Test
	public final void testExtractParameter_parameterLong() {
		final Map<String, Object> map = new LinkedHashMap<String, Object>();
		final String parameter = "-" + Utility.nextString();
		final String value = Long.toString(Utility.nextLong());
		map.put(parameter, value);

		final Object actualValue = getCommandLine().extractParameter(map, parameter, Long.class);

		assertEquals("The value is returned", Long.parseLong(value), ((Long) actualValue).longValue());
	}

	/**
	 * Creates a command line object of the type to test.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @return the command line object.
	 * @since V2.2.0 Apr 25, 2014
	 * @version V2.2.0 Apr 25, 2014
	 */
	protected abstract L createCommandLine();

	/**
	 * Gets the command line.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @return the command line.
	 * @since V2.2.0 Apr 25, 2014
	 * @version V2.2.0 Apr 25, 2014
	 */
	protected final CommandLine getCommandLine() {
		return commandLine;
	}

	/**
	 * Sets the command line.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param commandLine
	 *            the command line to set.
	 * @since V2.2.0 Apr 25, 2014
	 * @version V2.2.0 Apr 25, 2014
	 */
	private final void setCommandLine(final CommandLine commandLine) {
		this.commandLine = commandLine;
	}

}
