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
@DatabaseTable(tableName="FINE_RECORD")
public class FineRecord {
	
	@DatabaseField(columnName="F_ID",canBeNull=false,generatedId=true)
	private int id;
	@DatabaseField(columnName="F_GDATE",canBeNull=false)
	private Date date;
	@DatabaseField(columnName="F_REASON",canBeNull=false)
	private String reason;
	@DatabaseField(columnName="F_CHARGES",canBeNull=false)
	private int charges;
	
	/*
	 * RELATIONSHIP WITH STUDENT
	 */
	@DatabaseField(columnName="STD_ID",canBeNull=false,foreign=true,foreignAutoRefresh=true)
	private Student student;
	
	/*
	 * RELATIONSHIP WITH BILL_RECORD	
	 */
	@DatabaseField(columnName="B_ID",canBeNull=true,foreign=true,foreignAutoRefresh=true)
	private BillingRecord billingRecord;
	
}
