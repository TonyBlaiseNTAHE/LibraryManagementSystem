package Models;

import java.util.List;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "Shelves")
public class Shelf {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shelf_id", updatable = false, nullable = false)
    private UUID shelf_id;

    @Column(name = "available_stock", nullable = false)
    private int available_stock;

    @Column(name = "book_category", nullable = false)
    private String book_category; // e.g., Fiction, Non-Fiction, Reference, etc.

    @Column(name = "borrowed_number", nullable = false)
    private int borrowed_number;

    @Column(name = "initial_stock", nullable = false)
    private int initial_stock;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room; // Relationship to Room

    @OneToMany(mappedBy = "shelf", cascade = CascadeType.ALL)
    private List<Book> books; // One-to-many relationship with books

    public Shelf() {}

    public Shelf(int available_stock, String book_category, int borrowed_number, int initial_stock, Room room) {
        this.available_stock = available_stock;
        this.book_category = book_category;
        this.borrowed_number = borrowed_number;
        this.initial_stock = initial_stock;
        this.room = room;
    }

	public UUID getShelf_id() {
		return shelf_id;
	}

	public void setShelf_id(UUID shelf_id) {
		this.shelf_id = shelf_id;
	}

	public int getAvailable_stock() {
		return available_stock;
	}

	public void setAvailable_stock(int available_stock) {
		this.available_stock = available_stock;
	}

	public String getBook_category() {
		return book_category;
	}

	public void setBook_category(String book_category) {
		this.book_category = book_category;
	}

	public int getBorrowed_number() {
		return borrowed_number;
	}

	public void setBorrowed_number(int borrowed_number) {
		this.borrowed_number = borrowed_number;
	}

	public int getInitial_stock() {
		return initial_stock;
	}

	public void setInitial_stock(int initial_stock) {
		this.initial_stock = initial_stock;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

    
}

