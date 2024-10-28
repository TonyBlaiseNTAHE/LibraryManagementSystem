/**
 * 
 */
package Models;
import java.util.UUID;

import javax.persistence.*;
import javax.persistence.MappedSuperclass;

/**
 * Person - This is a super class that identify a person and it is an abstract class
 */
@MappedSuperclass
public abstract class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "person_id", updatable = false, nullable = false)
	private UUID person_id;
	
	@Column(name = "first_name", nullable = false, length = 50)
	private String first_name;
	@Column(name = "last_name", nullable = false, length = 50)
	private String last_name;
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private PersonGender gender;
	
	@Column(name = "phone_number", nullable = false, length = 15)
	private String phone_number;
	
	public Person() {}
	
	 public Person(String first_name, String last_name, PersonGender gender, String phone_number) {
	        this.first_name = first_name;
	        this.last_name = last_name;
	        this.gender = gender;
	        this.phone_number = phone_number;
	    }

	public UUID getPerson_id() {
		return person_id;
	}

	public void setPerson_id(UUID person_id) {
		this.person_id = person_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public PersonGender getGender() {
		return gender;
	}

	public void setGender(PersonGender gender) {
		this.gender = gender;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	 
}
