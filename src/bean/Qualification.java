package bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DatabaseTable(tableName="QUALIFICATION")
public class Qualification {
	
	/*
	 * QUALIFICATION INFORMATION
	 */
	@DatabaseField(columnName="Q_TITLE",canBeNull=false)
	private String title;
	@DatabaseField(columnName="Q_INST",canBeNull=false)
	private String institute;
	@DatabaseField(columnName="Q_DUR",canBeNull=false)
	private int duration;
	@DatabaseField(columnName="Q_YOP",canBeNull=false)
	private String yearOfPassing;
	@DatabaseField(columnName="Q_TMARK",canBeNull=false)
	private int totalMarks;
	@DatabaseField(columnName="Q_OMARK",canBeNull=false)
	private int obtainedMarks;
	@DatabaseField(columnName="Q_PER",canBeNull=false)
	private double percentage;
	
	/*
	 * RELATIONSHIP WITH STUDENT
	 */
	@DatabaseField(columnName="STD_ID",canBeNull=false,foreign=true,foreignAutoRefresh=true)
	private Student student;

}
