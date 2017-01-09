/**
 * Copyright 2011 by Ian Andrew Brown<br>
 * All Rights Reserved
 */

package usa.browntrask.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Implemented of {@link EnumTester} for {@link TestingEnum}.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V1.2.0 Mar 25, 2011
 * @version V1.2.0 Mar 25, 2011
 */
public final class TestingEnumTest implements EnumTester {

	/**
	 * helper class for testing standard enumeration methods.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.2.0 Mar 25, 2011
	 * @version V1.2.0 Mar 25, 2011
	 */
	private EnumHelper<TestingEnum> enumHelper;

	/**
	 * the enumeration to test.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.2.0 Mar 25, 2011
	 * @version V1.2.0 Mar 25, 2011
	 */
	private TestingEnum testingEnum;

	/**
	 * Sets up to test the enumeration.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.2.0 Mar 25, 2011
	 * @version V1.2.0 Mar 25, 2011
	 */
	@Before
	public final void setUpTestingEnum() {
		setEnumHelper(new EnumHelper<TestingEnum>());
		setTestingEnum(Utility.nextEnum(TestingEnum.class));
	}

	/**
	 * Tears down after testing the enumeration.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.2.0 Mar 25, 2011
	 * @version V1.2.0 Mar 25, 2011
	 */
	@After
	public final void tearDownTestingEnum() {
		setTestingEnum(null);
		setEnumHelper(null);
	}

	/** {@inheritDoc} */
	@Override
	@Test
	public final void testCompareTo() {
		final int ordinal = getTestingEnum().ordinal();
		final TestingEnum before = (ordinal == 0) ? null : TestingEnum.values()[ordinal - 1];
		final TestingEnum after = (ordinal == TestingEnum.values().length - 1) ? null : TestingEnum.values()[ordinal + 1];

		getEnumHelper().testCompareTo(getTestingEnum(), before, after);
	}

	/** {@inheritDoc} */
	@Override
	@Test
	public final void testEquals() {
		getEnumHelper().testEquals(getTestingEnum());
	}

	/** {@inheritDoc} */
	@Override
	@Test
	public final void testGetDeclaringClass() {
		getEnumHelper().testGetDeclaringClass(getTestingEnum(), TestingEnum.class);
	}

	/** {@inheritDoc} */
	@Override
	@Test
	public final void testHashCode() {
		getEnumHelper().testHashCode(getTestingEnum());
	}

	/** {@inheritDoc} */
	@Override
	@Test
	public final void testName() {
		getEnumHelper().testName(getTestingEnum());
	}

	/** {@inheritDoc} */
	@Override
	@Test
	public final void testOrdinal() {
		getEnumHelper().testOrdinal(getTestingEnum());
	}

	/** {@inheritDoc} */
	@Override
	@Test
	public final void testToString() {
		getEnumHelper().testToString(getTestingEnum());
	}

	/** {@inheritDoc} */
	@Override
	@Test
	public final void testValueOf() {
		getEnumHelper().testValueOf(getTestingEnum());
	}

	/**
	 * Gets the enum helper.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the enum helper.
	 * @since V1.2.0 Mar 25, 2011
	 * @version V1.2.0 Mar 25, 2011
	 */
	private final EnumHelper<TestingEnum> getEnumHelper() {
		return enumHelper;
	}

	/**
	 * Gets the testing enum.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the testing enum.
	 * @since V1.2.0 Mar 25, 2011
	 * @version V1.2.0 Mar 25, 2011
	 */
	private final TestingEnum getTestingEnum() {
		return testingEnum;
	}

	/**
	 * Sets the enum helper.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param enumHelper
	 *            the enum helper to set.
	 * @since V1.2.0 Mar 25, 2011
	 * @version V1.2.0 Mar 25, 2011
	 */
	private final void setEnumHelper(final EnumHelper<TestingEnum> enumHelper) {
		this.enumHelper = enumHelper;
	}

	/**
	 * Sets the testing enum.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param testingEnum
	 *            the testing enum to set.
	 * @since V1.2.0 Mar 25, 2011
	 * @version V1.2.0 Mar 25, 2011
	 */
	private final void setTestingEnum(final TestingEnum testingEnum) {
		this.testingEnum = testingEnum;
	}

}
