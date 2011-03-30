package db;

import annotation.CompositeConstraint;
import annotation.CompositePK;
import annotation.ConstraintProcessor;
import bean.Student;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@CompositeConstraint(name="Test",constraintType=CompositeConstraint.FOREIGN_KEY)
@DatabaseTable(tableName="TEST")
public class Test {
	
	@DatabaseField(columnName="T_ID")
	@CompositePK()
	String id;
	@DatabaseField(columnName="T_NIC")
	@CompositePK()
	String nic;
	
	@DatabaseField(columnName="STD_ID",foreign=true)
	Student student1;
	@DatabaseField(columnName="STD_ID",foreign=true)
	Student student2;
	
	public static void main(String[] args) {
		
		System.out.println("Hello From GitHub");
		
	}

}
