/**
 * Copyright 2009, 2010, 2011, 2015 by Ian Andrew Brown<br>
 * All Rights Reserved
 */
package usa.browntrask.find.stub;

import usa.browntrask.find.Criteria;
import usa.browntrask.find.Findable;
import usa.browntrask.find.Searchable;

/**
 * Stub implementation of {@link Criteria}.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @param <S>
 *            the searchable class to pretend to be the container containing the matching findable.
 * @param <F>
 *            the findable class to pretend to be criteria for matching.
 * @since V0.10.0 Apr 27, 2009
 * @version V2.2.0 Nov 21, 2015
 */
public final class CriteriaStub<S extends Searchable, F extends Findable<F>> implements Criteria<S, F> {

	/** {@inheritDoc} */
	@Override
	public final int match(@SuppressWarnings("unused") final S container, final F check) {
		throw new UnsupportedOperationException("find(" + check + ") is not supported by the stub");
	}

}
