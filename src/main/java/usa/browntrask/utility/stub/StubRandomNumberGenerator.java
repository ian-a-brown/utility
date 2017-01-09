/**
 * Copyright 2008, 2009, 2010, 2011, 2015 by Ian Andrew Brown<br>
 * All Rights Reserved
 */
package usa.browntrask.utility.stub;

import usa.browntrask.utility.RandomNumberGenerator;

/**
 * Stub implementation of a {@link RandomNumberGenerator}.
 * <p>
 *
 * @author Ian Andrew Brown
 * @since V0.1.1 Jul 26, 2008
 * @version V2.2.0 Nov 21, 2015
 */
public final class StubRandomNumberGenerator implements RandomNumberGenerator {

	/** {@inheritDoc} */
	@Override
	public final int compareTo(@SuppressWarnings("unused") final RandomNumberGenerator arg0) {
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public final boolean nextBoolean() {
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public final double nextDouble() {
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public final float nextFloat() {
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public final int nextInt() {
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public final int nextInt(@SuppressWarnings("unused") final int number) {
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public final long nextLong() {
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public final void setSeed(@SuppressWarnings("unused") final long seed) {
		throw new UnsupportedOperationException();
	}
}
