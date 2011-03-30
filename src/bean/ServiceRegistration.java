package bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@DatabaseTable(tableName="STD_SER")

/*
 * JUNCTION TABLE OF STUDENT AND SERVICE
 */

public class ServiceRegistration {
	
	@DatabaseField(columnName="STD_ID",canBeNull=false,foreign=true,foreignAutoRefresh=true)
	private Student student;
	@DatabaseField(columnName="S_TITLE",canBeNull=false,foreign=true,foreignAutoRefresh=true)
	private Service service;

}
