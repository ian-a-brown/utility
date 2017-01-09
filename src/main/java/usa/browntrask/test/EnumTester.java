/**
 * Copyright 2011, 2015 by Ian Andrew Brown<br>
 * All Rights Reserved
 */

package usa.browntrask.test;

/**
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V1.2.0 Mar 25, 2011
 * @version V2.2.0 Mar 25, 2015
 */
public interface EnumTester {

	/**
	 * Test method for {@link java.lang.Enum#compareTo(java.lang.Enum)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.2.0 Mar 25, 2011
	 * @version V1.2.0 Mar 25, 2011
	 */
	void testCompareTo();

	/**
	 * Test method for {@link java.lang.Enum#equals(java.lang.Object)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.2.0 Mar 25, 2011
	 * @version V1.2.0 Mar 25, 2011
	 */
	void testEquals();

	/**
	 * Test method for {@link java.lang.Enum#getDeclaringClass()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.2.0 Mar 25, 2011
	 * @version V1.2.0 Mar 25, 2011
	 */
	void testGetDeclaringClass();

	/**
	 * Test method for {@link java.lang.Enum#hashCode()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.2.0 Mar 25, 2011
	 * @version V1.2.0 Mar 25, 2011
	 */
	void testHashCode();

	/**
	 * Test method for {@link java.lang.Enum#name()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.2.0 Mar 25, 2011
	 * @version V1.2.0 Mar 25, 2011
	 */
	void testName();

	/**
	 * Test method for {@link java.lang.Enum#ordinal()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.2.0 Mar 25, 2011
	 * @version V1.2.0 Mar 25, 2011
	 */
	void testOrdinal();

	/**
	 * Test method for {@link java.lang.Enum#toString()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.2.0 Mar 25, 2011
	 * @version V1.2.0 Mar 25, 2011
	 */
	void testToString();

	/**
	 * Test method for {@link java.lang.Enum#valueOf(Class, String)}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.2.0 Mar 25, 2011
	 * @version V2.2.0 Nov 21, 2015
	 */
	@SuppressWarnings("javadoc")
	void testValueOf();
}