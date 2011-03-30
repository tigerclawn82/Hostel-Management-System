package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface Column {

	String name();
	String dataType() default "VARCHAR";
	int length() default 100;
	
	boolean primaryKey() default false;
	boolean unique() default false;
	boolean foreignKey() default false;
	boolean notNull() default false;
	
}
