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
@DatabaseTable(tableName="BILL_RECORD")
public class BillingRecord {
	
	@DatabaseField(columnName="B_ID",canBeNull=false,generatedId=true)
	private int id;
	@DatabaseField(columnName="B_GDATE",canBeNull=false)
	private Date generationDate;
	@DatabaseField(columnName="B_DDATE",canBeNull=false)
	private Date dueDate;
	@DatabaseField(columnName="B_ADD",canBeNull=false)
	private boolean additional;
	@DatabaseField(columnName="B_DESP",canBeNull=true)
	private String description;
	@DatabaseField(columnName="B_TOTAL",canBeNull=false)
	private int totalAmount;
	@DatabaseField(columnName="B_PAID",canBeNull=false)
	private boolean paidStatus;
	
	/*
	 * RELATIONSHIP WITH STUDENT
	 */
	@DatabaseField(columnName="STD_ID",canBeNull=false,foreign=true,foreignAutoRefresh=true)
	private Student student;
	
}
