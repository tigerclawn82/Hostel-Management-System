package bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@DatabaseTable(tableName="SERVICE")
public class Service {
	
	@DatabaseField(columnName="S_TITLE",canBeNull=false,id=true)
	private String title;
	@DatabaseField(columnName="S_TYPE",canBeNull=false)
	private String type;
	@DatabaseField(columnName="S_CHTYPE",canBeNull=false)
	private String chargeType;
	@DatabaseField(columnName="S_CHARGE",canBeNull=false)
	private int charge;

}
