package annotation;

@Table(name="STUDENT",relationshipClass=Qualification.class,relationshipType=RelationshipType.ONE_TO_MANY)
public class Student {

	@Column(name="S_ID",primaryKey=true)
	String id;
	
}
