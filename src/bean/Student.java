package bean;

import java.util.Date;

import annotation.CompositeConstraint;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DatabaseTable(tableName="STUDENT")
@CompositeConstraint(name="FK_ROOM",constraintType=CompositeConstraint.FOREIGN_KEY)
public class Student {

	/*
	 * STUDENT INFORMATION
	 */
	@DatabaseField(columnName="STD_ID",canBeNull=false,id=true)
	private String id;
	@DatabaseField(columnName="STD_NAME",canBeNull=false)
	private String name;
	@DatabaseField(columnName="STD_GENDER",canBeNull=false)
	private String gender;
	@DatabaseField(columnName="STD_AGE",canBeNull=false)
	private int age;
	@DatabaseField(columnName="STD_DOB",canBeNull=false)
	private Date dateOfBirth;
	@DatabaseField(columnName="STD_BG",canBeNull=false)
	private String bloodGroup;
	@DatabaseField(columnName="STD_MOB",canBeNull=false)
	private String studentCell;
	@DatabaseField(columnName="STD_NIC",canBeNull=false,unique=true)
	private String nationalID;
	@DatabaseField(columnName="STD_EMAIL",canBeNull=false)
	private String emailID;
	
	/*
	 * ADDRESS RESOLUTION
	 */
	@DatabaseField(columnName="STD_ADDRESS",canBeNull=false)
	private String address;
	@DatabaseField(columnName="STD_COUNTRY",canBeNull=false)
	private String country;
	
	/*
	 * FATHER INFORMATION
	 */
	@DatabaseField(columnName="STD_FNAME",canBeNull=false)
	private String fatherName;
	@DatabaseField(columnName="STD_FWORK",canBeNull=false)
	private String fatherOccupation;
	@DatabaseField(columnName="STD_FMOB",canBeNull=false)
	private String fatherCell;
	
	/*
	 * RELATIONSHIP WITH ROOM
	 */
	@DatabaseField(columnName="R_NO",canBeNull=false,foreign=true,foreignAutoRefresh=true)
	private Room room;
	
}
