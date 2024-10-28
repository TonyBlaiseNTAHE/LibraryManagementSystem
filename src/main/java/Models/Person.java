package Models;


import javax.persistence.MappedSuperclass;
import javax.persistence.*;

@MappedSuperclass
public abstract class Person {

    private String person_id;
    private String first_name;
    private String last_name;
    private String phone_number;
    
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public enum Gender {
        MALE, FEMALE
    }
    public Person(String person_id, String first_name, String last_name, String phone_number, Gender gender) {
        this.person_id = person_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.gender = gender;
    }

 // Getters and Setters
	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getPerson_id() {
		return person_id;
	}

	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

    
}
