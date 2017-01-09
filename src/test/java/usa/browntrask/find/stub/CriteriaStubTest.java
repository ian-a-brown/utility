/**
 * Copyright (C) 2009 by Ian Andrew Brown<br>
 * All Rights Reserved
 */

package usa.browntrask.find.stub;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import usa.browntrask.test.GenericTester;

/**
 * Test for {@link CriteriaStub}.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.10.0 Apr 27, 2009
 * @version V1.3.0 Feb 6, 2010
 */
public final class CriteriaStubTest {

	/**
	 * Tests all methods of the stub.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.10.0 Apr 27, 2009
	 * @version V1.3.0 Feb 6, 2010
	 */
	@Test
	public final void testStub() {
		final CriteriaStub<SearchableStub, FindableStub> stub = new CriteriaStub<SearchableStub, FindableStub>();

		final boolean checkedStub = GenericTester.checkAllMethodsOfStub(stub, UnsupportedOperationException.class);

		assertTrue("All methods of the stub should check out", checkedStub);
	}
}
