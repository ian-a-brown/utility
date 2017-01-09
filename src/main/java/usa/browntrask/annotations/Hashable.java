package usa.browntrask.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for types that can be safely used in <i>hashing containers</i>.
 * <P>
 * Adding this annotation to a class amounts to a guarantee that
 * {@link Object#hashCode()} and {@link Object#equals(Object)} have been
 * overridden "by the book", and that objects of the annotated class will be
 * fully compatible with any properly implemented containers that rely on
 * hashing (e.g. HashMap, HashSet, etc..).
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Hashable {
}
