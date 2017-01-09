/**
 * Copyright 2011 by Ian Andrew Brown<br>
 * All Rights Reserved
 */

package usa.browntrask.utility;

/**
 * Abstract implementation of {@link HasValet}.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @param <V>
 *            the type of valet.
 * @since V1.6.0 Mar 27, 2011
 * @version V1.6.0 Mar 27, 2011
 */
public abstract class AbstractHasValet<V extends Valet> implements HasValet<V> {

	/**
	 * the valet.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	private final V valet;

	/**
	 * Constructs a has valet object using the specified valet to acquire resources.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param valet
	 *            the valet.
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	protected AbstractHasValet(final V valet) {
		this.valet = valet;
	}

	/** {@inheritDoc} */
	@Override
	public final V getValet() {
		return this.valet;
	}

}
