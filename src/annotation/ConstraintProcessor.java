package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import db.Database;

public class ConstraintProcessor {

	public static <E> void compositeProcessorWithColumns(Class<E> className) {

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

	public static <E> void compositeProcessor(Class<E> className) {

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

	public static <E> void foreignKeyProcessor(Class<E> className) {

		try {

			StringBuilder alterQuery = null;
			
			CompositeConstraint compositeConstraint = null;
			DatabaseTable databaseTable = null;
			DatabaseField databaseField = null;

			Set<String> tables = new HashSet<String>();
			ArrayList<String> columns = new ArrayList<String>();

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

						if (databaseField.foreign()) {

							Annotation[] annotations2 = field.getType().getAnnotations();

							for (Annotation annotation2 : annotations2) {

								if (annotation2 instanceof DatabaseTable) {

									tables.add(((DatabaseTable) annotation2).tableName());
									columns.add(databaseField.columnName());

								}

							}

						}

					}

				}

			}

			if (databaseTable!=null) {

				if (compositeConstraint!=null) {

					for (String tableName : tables) {
						
						alterQuery = new StringBuilder();
						
						alterQuery.append("ALTER TABLE "+databaseTable.tableName()+"\n");
						alterQuery.append("ADD CONSTRAINT "+compositeConstraint.name()+" "+compositeConstraint.constraintType()+" (");
						StringBuilder columnNames = new StringBuilder();
						for (int i = 0; i < columns.size(); i++) {
							
							if (i==columns.size()-1) {
								
								columnNames.append(columns.get(i));
								alterQuery.append(columns.get(i)+")");
								
								alterQuery.append(" REFERENCES "+tableName+" ("+columnNames.toString()+")");

							} else {

								alterQuery.append(columns.get(i)+",");
								columnNames.append(columns.get(i)+",");

							}

						}
						
						System.out.println(alterQuery.toString());
					}

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
	
	public static <E> void uniqueProcessor(Class<E> className) {

		try {

			DatabaseTable databaseTable = null;
			DatabaseField databaseField = null;
			Unique unique = null;
			Map<String, String> constraintColumn = new HashMap<String, String>();
			String columnNames = new String();
			StringBuilder alterQuery = null;

			Annotation[] annotations = className.getAnnotations();

			for (Annotation annotation : annotations) {

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

					if (annotation instanceof Unique) {

						unique = (Unique) annotation;
						
						if (constraintColumn.get(unique.name())==null) {
							
							constraintColumn.put(unique.name(), databaseField.columnName());
							
						} else {

							columnNames = constraintColumn.get(unique.name());
							columnNames+= "," + databaseField.columnName();
							constraintColumn.put(unique.name(), columnNames);
							
						}

					}

				}

			}

			if (databaseTable!=null) {

				Set<String> keySet = constraintColumn.keySet();
				
				for (String key : keySet) {
					
					columnNames = constraintColumn.get(key);
					
					alterQuery = new StringBuilder();
					
					alterQuery.append("ALTER TABLE "+databaseTable.tableName()+"\n");
					alterQuery.append("ADD CONSTRAINT " +unique.name()+ " UNIQUE ("+columnNames+")");
					
					System.out.println(alterQuery.toString());
					
				}

			}


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
