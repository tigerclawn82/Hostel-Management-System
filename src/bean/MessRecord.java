package bean;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@DatabaseTable(tableName="MESS_RECORD")
public class MessRecord {
	
	@DatabaseField(columnName="MR_ID",canBeNull=false,generatedId=true)
	private int id;
	@DatabaseField(columnName="MR_DATE",canBeNull=false)
	private Date date;
	@DatabaseField(columnName="MR_TYPE",canBeNull=false)
	private String type;
	@DatabaseField(columnName="MR_STATUS",canBeNull=false)
	private boolean status;
	@DatabaseField(columnName="MR_CHARGES",canBeNull=false)
	private int charges;
	
	/*
	 * RELATIONSHIP WITH STUDENT_SERVICE
	 */
	@DatabaseField(columnName="STD_ID",canBeNull=false,foreign=true,foreignAutoRefresh=true)
	private Student student;
	@DatabaseField(columnName="S_TITLE",canBeNull=false,foreign=true,foreignAutoRefresh=true)
	private Service service;
	
	/*
	 * RELATIONSHIP WITH BILL
	 */
	@DatabaseField(columnName="B_ID",canBeNull=true,foreign=true,foreignAutoRefresh=true)
	private BillingRecord billingRecord;
	
}
