package bean;

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
	
	@DatabaseField(columnName="FR_ID",canBeNull=false,generatedId=true)
	private int id;
	@DatabaseField(columnName="FR_DATE",canBeNull=false)
	private String date;
	@DatabaseField(columnName="FR_REASON",canBeNull=false)
	private String reason;
	@DatabaseField(columnName="FR_CHARGES",canBeNull=false)
	private int charges;
	
	/*
	 * RELATIONSHIP WITH STUDENT
	 */
	@DatabaseField(columnName="STD_ID",canBeNull=false,foreign=true,foreignAutoRefresh=true)
	private Student student;
	
}
