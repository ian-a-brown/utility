/**
 * Copyright 2007, 2008, 2009, 2010, 2011 by Ian Andrew Brown<br>
 * All Rights Reserved
 */
package usa.browntrask.utility;

/**
 * A class to hold a pair of values.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @param <F>
 *            the class type for the first value.
 * @param <S>
 *            the class type for the second value.
 * @since V0.1.6 Aug 1, 2007
 * @version V1.6.0 Feb 2, 2011
 */
public final class Pair<F extends Object, S extends Object> {

	/**
	 * the first value of the pair.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 1, 2007
	 * @version Aug 1, 2007
	 */
	public F first;

	/**
	 * the second value of the pair.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.6 Aug 1, 2007
	 * @version Aug 1, 2007
	 */
	public S second;

	/**
	 * Constructs a pair from the input values.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param first
	 *            the first value of the pair.
	 * @param second
	 *            the second value of the pair.
	 * @since V0.1.6 Aug 1, 2007
	 * @version V1.6.0 Feb 2, 2011
	 */
	public Pair(final F first, final S second) {
		super();
		this.first = first;
		this.second = second;
	}

	/** {@inheritDoc} */
	@Override
	public final boolean equals(final Object object) {
		final boolean areEqual;
		if (this == object) {
			areEqual = true;
		} else if (object instanceof Pair<?, ?>) {
			@SuppressWarnings("unchecked")
			final Pair<F, S> other = (Pair<F, S>) object;
			final boolean firstEqual;
			if (null == first) {
				firstEqual = (null == other.first);
			} else if (null == other.first) {
				firstEqual = false;
			} else {
				firstEqual = first.equals(other.first);
			}

			final boolean secondEqual;
			if (null == second) {
				secondEqual = (null == other.second);
			} else if (null == other.second) {
				secondEqual = false;
			} else {
				secondEqual = second.equals(other.second);
			}
			areEqual = firstEqual && secondEqual;
		} else {
			areEqual = false;
		}
		return areEqual;
	}

	/** {@inheritDoc} */
	@Override
	public final int hashCode() {
		return 7 + ((null == first) ? 0 : 31 * first.hashCode()) + ((null == second) ? 0 : 31 * second.hashCode());
	}

	/** {@inheritDoc} */
	@Override
	public final String toString() {
		final StringBuffer stringBuffer = new StringBuffer(getClass().getSimpleName());
		stringBuffer.append(" (").append(first).append(", ").append(second).append(')');
		return stringBuffer.toString();
	}
}
