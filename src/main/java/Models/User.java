/**
 * 
 */
package Models;

import java.util.UUID;

import javax.persistence.*;

/**
 * User - A subclass from Person class
 */
@Entity
@Table(name = "users")
public class User extends Person{
	@Column(name = "password", nullable = false)
	private String password;
	@Enumerated(EnumType.STRING)
	private UserRole role;
	@Column(name = "user_name", nullable = false)
	private String user_name;
	@Column(name = "village_id", nullable = false)
	private UUID village_id;
	
	public User(String first_name, String last_name, PersonGender gender, String phone_number, String user_name, String password, UUID village_id) {
        /* Call to the constructor of Person to initialize common fields*/
        super(first_name, last_name, gender, phone_number);
        
        
        this.user_name = user_name;
        this.password = password;
        this.village_id = village_id;
        
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public UUID getVillage_id() {
		return village_id;
	}

	public void setVillage_id(UUID village_id) {
		this.village_id = village_id;
	}
	
	
}
