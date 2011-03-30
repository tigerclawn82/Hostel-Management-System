package bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DatabaseTable(tableName="ROOM")
public class Room {

	@DatabaseField(columnName="R_NO",canBeNull=false,id=true)
	private int no;
	@DatabaseField(columnName="R_CAP",canBeNull=false)
	private int capacity;
	@DatabaseField(columnName="R_LOC",canBeNull=false)
	private String location;
	@DatabaseField(columnName="R_COUNT",canBeNull=false,defaultValue="0")
	private int count;
	@DatabaseField(columnName="R_FULL",canBeNull=false,defaultValue="0")
	private boolean full;
	
}
