package usa.browntrask.utility.stub;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import usa.browntrask.test.GenericTester;

/**
 * Test for {@link StubRandomNumberGenerator}.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.1 Aug 2, 2008
 * @version Aug 2, 2008
 */
public final class StubRandomNumberGeneratorTest {

	/**
	 * Test all of the stub methods.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.1 Aug 2, 2008
	 * @version Aug 2, 2008
	 */
	@Test
	public final void testStubRandomNumberGenerator() {
		final StubRandomNumberGenerator rng = new StubRandomNumberGenerator();

		assertTrue("All methods should throw exception", GenericTester.checkAllMethodsOfStub(rng,
				UnsupportedOperationException.class));
	}
}
