/*
 * Copyright 2008, 2009 Ian Brown All Rights Reserved
 * 
 * Permission is granted to use and distribute this software so long as this copyright message is maintained. This software is
 * provided without a warranty or guarantee of any kind.
 */
package usa.browntrask.utility;

/**
 * Additional math functions.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.8.0 Oct 6, 2008
 * @version Oct 6, 2008
 */
public final class AdditionalMath {

	/**
	 * Determines the sign of the input value as -1, 0, 1 depending on whether the value is less than, equal to, or greater than 0.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param value
	 *            the value.
	 * @return the sign of the value.
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	public final static int sign(final int value) {
		return value == 0 ? 0 : value / Math.abs(value);
	}

	/**
	 * Private constructor - class should not be instantiated.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	// /CLOVER:OFF
	private AdditionalMath() {
		throw new UnsupportedOperationException("Class cannot be instantiated");
	}
	// /CLOVER:ON
}
