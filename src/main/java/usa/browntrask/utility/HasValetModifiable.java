/**
 * Copyright 2011 by Ian Andrew Brown<br>
 * All Rights Reserved
 */

package usa.browntrask.utility;

/**
 * Extended {@link HasValet} interface for objects that allow the valet to be replaced.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @param <V>
 *            the type of valet.
 * @since V1.6.0 Mar 27, 2011
 * @version V1.6.0 Mar 27, 2011
 */
public interface HasValetModifiable<V extends Valet> extends HasValet<V> {

	/**
	 * Sets the valet to acquire resources.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param valet
	 *            the valet.
	 * @since V1.6.0 Mar 27, 2011
	 * @version V1.6.0 Mar 27, 2011
	 */
	void setValet(V valet);
}
