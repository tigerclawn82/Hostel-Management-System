package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DatabaseTable(tableName="SER_BILL")

/*
 * JUNCTION TABLE OF STUDENT_SERVICE AND BILL
 */

public class ServiceBill {

	/*
	 * RELATIONSHIP WITH STUDENT and SERVICE
	 */
	@DatabaseField(columnName="STD_ID",canBeNull=false,foreign=true,foreignAutoRefresh=true)
	private Student student;
	@DatabaseField(columnName="S_TITLE",canBeNull=false,foreign=true,foreignAutoRefresh=true)
	private Service service;
	
}
