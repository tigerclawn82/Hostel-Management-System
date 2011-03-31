package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import db.Database;

public class CompositeProcessor {

	public static <E> void compositeProcessor(Class<E> className) {

		try {

			CompositeConstraint compositeConstraint = null;
			DatabaseTable databaseTable = null;

			Annotation[] annotations = className.getAnnotations();

			for (Annotation annotation : annotations) {

				if (annotation instanceof CompositeConstraint) {

					compositeConstraint = (CompositeConstraint) annotation;					

				}

				if (annotation instanceof DatabaseTable) {

					databaseTable = (DatabaseTable) annotation;

				}

			}

			if (databaseTable!=null) {

				if (compositeConstraint!=null) {

					String[] columnName = compositeConstraint.columnName();
					StringBuilder alterQuery = new StringBuilder();
					alterQuery.append("ALTER TABLE "+databaseTable.tableName()+"\n");
					alterQuery.append("ADD CONSTRAINT "+compositeConstraint.name()+" "+compositeConstraint.constraintType()+" (");

					for (int i = 0; i < columnName.length; i++) {

						if (i==columnName.length-1) {

							alterQuery.append(columnName[i]+")");

						} else {

							alterQuery.append(columnName[i]+",");

						}

					}
					
					System.out.println(alterQuery.toString());

					try {
						
						if (!Database.executeSQL(alterQuery.toString())) {
							
							throw new Exception("ALTER QUERY NOT EXECUTED!");
							
						}
						
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						
					} finally {
						
						Database.closeConnection();
						
					}

				}

			}


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static <E> void compositePKProcessor(Class<E> className) {
	
		try {
	
			CompositeConstraint compositeConstraint = null;
			DatabaseTable databaseTable = null;
			DatabaseField databaseField = null;
			CompositePK compositePK = null;
			
			ArrayList<String> columnNames = new ArrayList<String>();
	
			Annotation[] annotations = className.getAnnotations();
	
			for (Annotation annotation : annotations) {
	
				if (annotation instanceof CompositeConstraint) {
	
					compositeConstraint = (CompositeConstraint) annotation;					
	
				}
	
				if (annotation instanceof DatabaseTable) {
	
					databaseTable = (DatabaseTable) annotation;
	
				}
	
			}
			
			Field[] declaredFields = className.getDeclaredFields();
			
			for (Field field : declaredFields) {
				
				annotations = field.getAnnotations();
				
				for (Annotation annotation : annotations) {
					
					if (annotation instanceof DatabaseField) {
					
						databaseField = (DatabaseField) annotation;
						
					}
					
					if (annotation instanceof CompositePK) {
						
						compositePK = (CompositePK) annotation;
						
						if (compositePK.isComposite()) {
							
							columnNames.add(databaseField.columnName());
							
						}
						
					}
					
				}
				
			}
	
			if (databaseTable!=null) {
	
				if (compositeConstraint!=null) {
	
					StringBuilder alterQuery = new StringBuilder();
					alterQuery.append("ALTER TABLE "+databaseTable.tableName()+"\n");
					alterQuery.append("ADD CONSTRAINT "+compositeConstraint.name()+" "+compositeConstraint.constraintType()+" (");
	
					for (int i = 0; i < columnNames.size(); i++) {
	
						if (i==columnNames.size()-1) {
	
							alterQuery.append(columnNames.get(i)+")");
	
						} else {
	
							alterQuery.append(columnNames.get(i)+",");
	
						}
	
					}
					
					System.out.println(alterQuery.toString());
	
					/*try {
						
						if (!Database.executeSQL(alterQuery.toString())) {
							
							throw new Exception("ALTER QUERY NOT EXECUTED!");
							
						}
						
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						
					} finally {
						
						Database.closeConnection();
						
					}*/
	
				}
	
			}
	
	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	}

}
