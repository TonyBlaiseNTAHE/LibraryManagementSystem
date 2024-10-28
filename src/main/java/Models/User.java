package Models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user")
public class User extends Person {
    
	public User(String person_id, String first_name, String last_name, String phone_number, Gender gender, 
            String user_name, String password, Role role, Location village) {
    super(person_id, first_name, last_name, phone_number, gender);
    this.user_name = user_name;
    this.password = password;
    this.role = role;
    this.village = village;
}

	@Id
    @GeneratedValue
    private UUID user_id;

    @Column(nullable = false)
    private String user_name;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "village_id")
    private Location village;

    public enum Role {
        STUDENT, MANAGER, TEACHER, DEAN, HOD, LIBRARIAN
    }

    // Getters and Setters
}
