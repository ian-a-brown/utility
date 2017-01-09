/**
 * Copyright 2011 by Ian Andrew Brown<br>
 * All Rights Reserved
 */

package usa.browntrask.utility;

/**
 * Abstract implementation of {@link HasValetModifiable}.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @param <V>
 *            the type of valet.
 * @since V1.6.0 Mar 27, 2011
 * @version V1.6.0 Mar 27, 2011
 */
public abstract class AbstractHasValetModifiable<V extends Valet> implements HasValetModifiable<V> {

	/**
	 * the valet.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	private V valet;

	/** {@inheritDoc} */
	@Override
	public final V getValet() {
		return valet;
	}

	/** {@inheritDoc} */
	@Override
	public final void setValet(final V valet) {
		this.valet = valet;
	}

}
