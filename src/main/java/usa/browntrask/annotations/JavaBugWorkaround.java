package usa.browntrask.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation for marking workarounds for bugs in core Java. This provides a
 * formal searchable marker for noting bug fixes that may need to be removed
 * when migrating to future versions of Java.
 * <p>
 * The annotation should be placed on the method containing the bug fix.
 * <p>
 * 
 * @author Troy T. Collinsworth
 */
@Retention(RetentionPolicy.SOURCE)
// @Target(ANY)
public @interface JavaBugWorkaround {

    /**
     * The ID from the Sun Bug Database.
     * <p>
     * 
     * @return the identification of the bug.
     */
    String javaBugId();

    /**
     * A description of the problem.
     * <p>
     * 
     * @return the description.
     */
    String synopsis();

    /**
     * The engineer implementing the fix.
     * <p>
     * 
     * @return the name of the engineer.
     */
    String engineer();
}
