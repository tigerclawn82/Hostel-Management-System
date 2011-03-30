package annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CompositeConstraint {

	static String PRIMARY_KEY = "PRIMARY KEY";
	static String UNIQUE = "UNIQUE";
	static String FOREIGN_KEY = "FOREIGN KEY";
	
	String name();
	String constraintType();
	String[] columnName() default {};
	
}
