/**
 * Copyright 2011 by Ian Andrew Brown<br>
 * All Rights Reserved
 */

package usa.browntrask.utility;

/**
 * Interface for objects that use a {@link Valet} to acquire resourecs.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @param <V>
 *            the type of valet.
 * @since V1.6.0 Mar 27, 2011
 * @version V1.6.0 Mar 27, 2011
 */
public interface HasValet<V extends Valet> {

	/**
	 * Gets the valet to acquire resources.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the valet.
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	V getValet();
}
