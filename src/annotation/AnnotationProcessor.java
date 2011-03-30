package annotation;

import java.lang.annotation.Annotation;

public class AnnotationProcessor {
	
	public static void main(String[] args) {
		
		createTable(Student.class);
		
	}
	
	public static <E> void createTable(Class<E> className) {
		
		Table table = null;
		
		Annotation[] declaredAnnotations = className.getDeclaredAnnotations();
		
		for (Annotation annotation : declaredAnnotations) {
			
			if (annotation instanceof Table) {
				
				table = (Table) annotation;
				
			}
			
		}
		
	}

}
