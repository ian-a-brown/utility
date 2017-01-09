package usa.browntrask.test.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static usa.browntrask.test.Assert.assertGreaterThan;
import static usa.browntrask.test.Assert.assertLessThan;
import static usa.browntrask.test.Assert.assertNotEquals;

import org.junit.Test;

/**
 * Test for {@link MockComparable}.
 * <p>
 *
 * @author Ian Andrew Brown
 * @since V0.8.0 Oct 6, 2008
 * @version V2.2. 0 Oct 24, 2014
 */
public final class MockComparableTest {

	/**
	 * Custom assertion to see that the mock comparable properly handles being compared to something that should come after it.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param mockComparable
	 *            the mock comparable.
	 * @param after
	 *            the object that should come after it.
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	private final static void assertHandlesAfterCorrectly(final MockComparable mockComparable, final MockComparable after) {
		final int compared = mockComparable.compareTo(after);
		assertLessThan(mockComparable + " should compare less than " + after, 0, compared);

		final int reversed = after.compareTo(mockComparable);
		assertGreaterThan(after + " should compare greater than " + mockComparable, 0, reversed);
	}

	/**
	 * Custom assertion to see that the mock comparable properly handles being compared to something that should come before it.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param mockComparable
	 *            the mock comparable.
	 * @param before
	 *            the object that should come before it.
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	private final static void assertHandlesBeforeCorrectly(final MockComparable mockComparable, final MockComparable before) {
		final int compared = mockComparable.compareTo(before);
		assertGreaterThan(mockComparable + " should compare greater than " + before, 0, compared);

		final int reversed = before.compareTo(mockComparable);
		assertLessThan(before + " should compare less than " + mockComparable, 0, reversed);
	}

	/**
	 * Custom assertion to see that the mock comparable properly handles being compared to <code>null</code> by throwing a
	 * {@link NullPointerException}.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param mockComparable
	 *            the mock comparable to be checked.
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	private static final void assertHandlesNullCorrectly(final MockComparable mockComparable) {
		try {
			mockComparable.compareTo(null);
			fail(mockComparable + " does not properly throw null pointer exception when compared to null");
		} catch (final NullPointerException e) {
			// Expected exception.
		}
	}

	/**
	 * Custom assertion to see that the mock comparable properly handles being compared to itself.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @param mockComparable
	 *            the mock comparable to be checked.
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	private final static void assertHandlesSelfCorrectly(final MockComparable mockComparable) {
		final int compared = mockComparable.compareTo(mockComparable);

		assertEquals(mockComparable + " should compare equal to itself", 0, compared);
	}

	/**
	 * Test method for {@link MockComparable#newMockComparable()}.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	@Test
	public final void testNewMockComparable() {
		final MockComparable mockComparable = MockComparable.newMockComparable();

		assertHandlesNullCorrectly(mockComparable);
		assertHandlesSelfCorrectly(mockComparable);
	}

	/**
	 * Test method for the sequence {@link MockComparable#newMockComparableBefore()}, {@link MockComparable#newMockComparable()},
	 * {@link MockComparable#newMockComparableAfter()}.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	@Test
	public final void testNewMockComparable_sequence() {
		final MockComparable before = MockComparable.newMockComparableBefore();
		final MockComparable mockComparable = MockComparable.newMockComparable();
		final MockComparable after = MockComparable.newMockComparableAfter();

		assertHandlesBeforeCorrectly(mockComparable, before);
		assertHandlesAfterCorrectly(mockComparable, after);
		assertHandlesBeforeCorrectly(after, before);
		assertHandlesAfterCorrectly(before, after);
	}

	/**
	 * Test method for {@link MockComparable#newMockComparableAfter()}.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	@Test
	public final void testNewMockComparableAfter() {
		final MockComparable mockComparable = MockComparable.newMockComparableAfter();

		assertHandlesNullCorrectly(mockComparable);
		assertHandlesSelfCorrectly(mockComparable);
	}

	/**
	 * Test method for {@link MockComparable#newMockComparableAfterSignFailure()}.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	@Test
	public final void testNewMockComparableAfterSignFailure() {
		final MockComparable mockComparable = MockComparable.newMockComparable();
		final MockComparable after = MockComparable.newMockComparableAfterSignFailure();

		final int compared = mockComparable.compareTo(after);
		final int reversed = after.compareTo(mockComparable);

		assertLessThan("Forward should compare properly", 0, compared);
		assertEquals("Reverse compare should fail to produce correct sign", compared, reversed);
	}

	/**
	 * Test method for {@link MockComparable#newMockComparableBefore()}.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	@Test
	public final void testNewMockComparableBefore() {
		final MockComparable mockComparable = MockComparable.newMockComparableBefore();

		assertHandlesNullCorrectly(mockComparable);
		assertHandlesSelfCorrectly(mockComparable);
	}

	/**
	 * Test method for {@link MockComparable#newMockComparableBeforeSignFailure()}.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	@Test
	public final void testNewMockComparableBeforeSignFailure() {
		final MockComparable mockComparable = MockComparable.newMockComparable();
		final MockComparable before = MockComparable.newMockComparableBeforeSignFailure();

		final int compared = mockComparable.compareTo(before);
		final int reversed = before.compareTo(mockComparable);

		assertGreaterThan("Forward should compare properly", 0, compared);
		assertEquals("Reverse compare should fail to produce correct sign", compared, reversed);
	}

	/**
	 * Test method for {@link MockComparable#newMockComparableDoesNotCompareToSelf()}.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	@Test
	public final void testNewMockComparableDoesNotCompareToSelf() {
		final MockComparable mockComparable = MockComparable.newMockComparableDoesNotCompareToSelf();

		final int compared = mockComparable.compareTo(mockComparable);

		assertNotEquals(mockComparable + " should not compare equal to itself", 0, compared);
	}

	/**
	 * Test method for {@link usa.browntrask.test.mock.MockComparable#newMockComparableDoesNotThrowNullPointer()}.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	@Test
	public final void testNewMockComparableDoesNotThrowNullPointer() {
		final MockComparable mockComparable = MockComparable.newMockComparableDoesNotThrowNullPointer();

		final int compared = mockComparable.compareTo(null);

		assertEquals("Compare to null", 0, compared);
	}

	/**
	 * Test method for {@link MockComparable#newMockComparableSignFailure()}.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	@Test
	public final void testNewMockComparableSignFailure() {
		final MockComparable mockComparable = MockComparable.newMockComparableSignFailure();
		final MockComparable before = MockComparable.newMockComparableBefore();

		final int compared = mockComparable.compareTo(before);
		final int reversed = before.compareTo(mockComparable);

		assertLessThan("Reversed should compare properly", 0, reversed);
		assertEquals("Forward compare should fail to produce correct sign", reversed, compared);
	}

	/**
	 * Test method for {@link MockComparable#newMockComparableBeforeTransitivityFailure()},
	 * {@link MockComparable#newMockComparableTransitivityFailure()}, and
	 * {@link MockComparable#newMockComparableAfterTransitivityFailure()}.
	 * <p>
	 *
	 * @author Ian Andrew Brown
	 * @since V0.8.0 Oct 6, 2008
	 * @version Oct 6, 2008
	 */
	@Test
	public final void testNewMockComparableTransitivityFailure() {
		final MockComparable mockComparable = MockComparable.newMockComparableTransitivityFailure();
		final MockComparable before = MockComparable.newMockComparableBeforeTransitivityFailure();
		final MockComparable after = MockComparable.newMockComparableAfterTransitivityFailure();

		final int mockBefore = mockComparable.compareTo(before);
		final int afterMock = after.compareTo(mockComparable);
		final int afterBefore = after.compareTo(before);

		assertGreaterThan("Mock should be after before", 0, mockBefore);
		assertGreaterThan("After should be after mock", 0, afterMock);
		assertLessThan("After should be before before", 0, afterBefore);
	}
}
