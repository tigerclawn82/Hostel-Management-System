package annotation;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="TEST")
public class Test {
	
	@DatabaseField(columnName="T_ID")
	@Unique(name="U_1")
	String id;
	@DatabaseField(columnName="T_NIC")
	@Unique(name="U_1")
	String nic;
	
	@DatabaseField(columnName="T_PH")
	@Unique(name="U_2")
	String phoneNo;
	
	public static void main(String[] args) {
		
		ConstraintProcessor.uniqueProcessor(Test.class);
		
	}
}
