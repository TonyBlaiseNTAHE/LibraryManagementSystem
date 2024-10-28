package Models;

import java.util.List;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "Rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_id", updatable = false, nullable = false)
    private UUID room_id;

    @Column(name = "room_code", nullable = false, unique = true)
    private String room_code; // Code for the room (e.g., "R101")

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Shelf> shelves; // One-to-many relationship with shelves

    public Room() {}

    public Room(String room_code) {
        this.room_code = room_code;
    }

	public UUID getRoom_id() {
		return room_id;
	}

	public void setRoom_id(UUID room_id) {
		this.room_id = room_id;
	}

	public String getRoom_code() {
		return room_code;
	}

	public void setRoom_code(String room_code) {
		this.room_code = room_code;
	}

	public List<Shelf> getShelves() {
		return shelves;
	}

	public void setShelves(List<Shelf> shelves) {
		this.shelves = shelves;
	}

   
}
