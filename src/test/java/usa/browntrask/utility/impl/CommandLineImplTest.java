/*
 * Copyright © 2014 by Ian Andrew Brown
 * All rights reserved
 */
package usa.browntrask.utility.impl;

import usa.browntrask.utility.AbstractCommandLineCheck;

/**
 * Extended {@link AbstractCommandLineCheck} test for {@link CommandLineImpl}.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V2.2.0 Apr 25, 2014
 * @version V2.2.0 Apr 25, 2014
 */
public final class CommandLineImplTest extends
		AbstractCommandLineCheck<CommandLineImpl> {

	/** {@inheritDoc} */
	@Override
	protected final CommandLineImpl createCommandLine() {
		return new CommandLineImpl();
	}
}
