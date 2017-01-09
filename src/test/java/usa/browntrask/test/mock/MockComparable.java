package usa.browntrask.test.mock;

import java.util.HashSet;
import java.util.Set;

/**
 * Comparable object that allows the user to control how its {@link #compareTo(MockComparable)} method performs.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.8.0 Oct 6, 2008
 * @version Oct 6, 2008
 */
public final class MockComparable implements Comparable<MockComparable> {

	/**
	 * Enumeration of the types of {@link MockComparable#compareTo(MockComparable)} handling that should fail to operate properly.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	private enum FailHandling {

		/**
		 * fail to handle a <code>null</code> input properly.
		 * <p>
		 * 
		 * @author Ian Andrew Brown
		 * @since V0.8.0 Oct 6, 2008
		 * @version Oct 6, 2008
		 */
		NULL_POINTER,

		/**
		 * fail to handle comparison to self properly.
		 * <p>
		 * 
		 * @author Ian Andrew Brown
		 * @since V0.8.0 Oct 6, 2008
		 * @version Oct 6, 2008
		 */
		SELF,

		/**
		 * fail to handle the sign of the comparison properly.
		 * <p>
		 * 
		 * @author Ian Andrew Brown
		 * @since V0.8.0 Oct 6, 2008
		 * @version Oct 6, 2008
		 */
		SIGN,

		/**
		 * fail to handle transitivity properly.
		 * <p>
		 * 
		 * @author Ian Andrew Brown
		 * @since V0.8.0 Oct 6, 2008
		 * @version Oct 6, 2008
		 */
		TRANSITIVITY

	}

	/**
	 * Constructs a mock comparable that operates properly.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the mock comparable that operates correctly.
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	public final static MockComparable newMockComparable() {
		return new MockComparable(0);
	}

	/**
	 * Constructs a mock comparable that operates correctly and indicates that it comes after the one created by
	 * {@link #newMockComparable()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the mock comparable that comes after the base one.
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	public final static MockComparable newMockComparableAfter() {
		return new MockComparable(1);
	}

	/**
	 * Constructs a mock comparable that comes after the base one that improperly handles the sign of the comparison
	 * (comparable.compareTo(after) == after.compareTo(comparable), when after should be > comparable).
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the mock comparable that messes up the sign.
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	public final static MockComparable newMockComparableAfterSignFailure() {
		return new MockComparable(1, FailHandling.SIGN);
	}

	/**
	 * Constructs a mock comparable that comes after the base and fails the transivity test.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the mock comparable that fails transitivity.
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	public final static MockComparable newMockComparableAfterTransitivityFailure() {
		return new MockComparable(1, FailHandling.TRANSITIVITY);
	}

	/**
	 * Constructs a mock comparable that operates correctly and indicates that it comes before the one created by
	 * {@link #newMockComparable()}.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the mock comparable that comes before the base one.
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	public final static MockComparable newMockComparableBefore() {
		return new MockComparable(-1);
	}

	/**
	 * Constructs a mock comparable that comes before the base one that improperly handles the sign of the comparison
	 * (comparable.compareTo(before) == before.compareTo(comparable), when before should be < comparable).
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the mock comparable that messes up the sign.
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	public final static MockComparable newMockComparableBeforeSignFailure() {
		return new MockComparable(-1, FailHandling.SIGN);
	}

	/**
	 * Constructs a mock comparable that comes before the base and fails the transivity test.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the mock comparable that fails transitivity.
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	public final static MockComparable newMockComparableBeforeTransitivityFailure() {
		return new MockComparable(-1, FailHandling.TRANSITIVITY);
	}

	/**
	 * Constructs a mock comparable object that does not properly compare to itself.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the mock comparable that does not compare to itself.
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	public final static MockComparable newMockComparableDoesNotCompareToSelf() {
		return new MockComparable(2, FailHandling.SELF);
	}

	/**
	 * Constructs a mock comparable object that does not throw a {@link NullPointerException} if provided with a <code>null</code>
	 * to be compared.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the mock comparable that does not properly throw the exception.
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	public final static MockComparable newMockComparableDoesNotThrowNullPointer() {
		return new MockComparable(0, FailHandling.NULL_POINTER);
	}

	/**
	 * Constructs a mock comparable that improperly handles the sign of the comparison (comparable.compareTo(before) ==
	 * before.compareTo(comparable), when before should be < comparable).
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the mock comparable that messes up the sign.
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	public final static MockComparable newMockComparableSignFailure() {
		return new MockComparable(0, FailHandling.SIGN);
	}

	/**
	 * Constructs a mock comparable that fails the transivity test.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the mock comparable that fails transitivity.
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	public final static MockComparable newMockComparableTransitivityFailure() {
		return new MockComparable(0, FailHandling.TRANSITIVITY);
	}

	/**
	 * the types of failures produced when performing the comparisons.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	private final Set<FailHandling> failures = new HashSet<FailHandling>();

	/**
	 * the value for comparison purposes.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	private final int value;

	/**
	 * Constructs a {@link MockComparable} that fails to handle the specified types of comparisons.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param value
	 *            the value for comparison purposes.
	 * @param failures
	 *            the types of comparisons that shouldn't operate correctly.
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	private MockComparable(final int value, final FailHandling... failures) {
		this.value = value;
		for (final FailHandling failure : failures) {
			this.failures.add(failure);
		}
	}

	/** {@inheritDoc} */
	@Override
	public final int compareTo(final MockComparable o) {
		// This implementation does not correctly handle the case where the difference between the two values is less than
		// Integer.MIN_VALUE or greater than Integer.MAX_VALUE.
		if (o == null) {
			if (failures.contains(FailHandling.NULL_POINTER)) {
				return 0;
			}
			throw new NullPointerException("Cannot compare " + this + " to null");

		} else if ((o == this) && failures.contains(FailHandling.SELF)) {
			return -1;

		} else if (failures.contains(FailHandling.TRANSITIVITY)) {
			final int difference = value - o.value;
			if (difference == 0) {
				return 0;
			}

			final int signDifference = difference / Math.abs(difference);
			if ((difference / signDifference % 2) == 1) {
				return difference;
			} else {
				return -difference;
			}

		} else if (failures.contains(FailHandling.SIGN)) {
			return o.value - value;

		}

		return value - o.value;
	}
}
