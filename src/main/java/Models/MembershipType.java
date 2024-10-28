package Models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "membership_type")
public class MembershipType {

    @Id
    @GeneratedValue
    private UUID membership_type_id;

    @Column(nullable = false)
    private String membership_name;

    @Column(nullable = false)
    private int max_books;

    public UUID getMembership_type_id() {
		return membership_type_id;
	}

	public void setMembership_type_id(UUID membership_type_id) {
		this.membership_type_id = membership_type_id;
	}

	public String getMembership_name() {
		return membership_name;
	}

	public void setMembership_name(String membership_name) {
		this.membership_name = membership_name;
	}

	public int getMax_books() {
		return max_books;
	}

	public void setMax_books(int max_books) {
		this.max_books = max_books;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Column(nullable = false)
    private int price;

    // Getters and Setters
	public MembershipType(String membership_name, int max_books, int price) {
        this.membership_name = membership_name;
        this.max_books = max_books;
        this.price = price;
    }
}

