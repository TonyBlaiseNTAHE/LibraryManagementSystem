package Models;

import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "Books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id", updatable = false, nullable = false)
    private UUID book_id;

    @Enumerated(EnumType.STRING)
    @Column(name = "book_status", nullable = false)
    private BookStatus book_status; // BORROWED, RESERVED, AVAILABLE

    @Column(name = "edition", nullable = false)
    private int edition;

    @Column(name = "isbn_code", nullable = false, unique = true)
    private String isbn_code;

    @Column(name = "publication_year", nullable = false)
    private int publication_year;

    @Column(name = "publisher_name", nullable = false)
    private String publisher_name;

    @ManyToOne
    @JoinColumn(name = "shelf_id", nullable = false)
    private Shelf shelf; // Relationship to Shelf

    @Column(name = "title", nullable = false)
    private String title;

    public Book() {}

    public Book(String title, String isbn_code, int edition, int publication_year, 
                String publisher_name, BookStatus book_status, Shelf shelf) {
        this.title = title;
        this.isbn_code = isbn_code;
        this.edition = edition;
        this.publication_year = publication_year;
        this.publisher_name = publisher_name;
        this.book_status = book_status;
        this.shelf = shelf;
    }

	public UUID getBook_id() {
		return book_id;
	}

	public void setBook_id(UUID book_id) {
		this.book_id = book_id;
	}

	public BookStatus getBook_status() {
		return book_status;
	}

	public void setBook_status(BookStatus book_status) {
		this.book_status = book_status;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public String getIsbn_code() {
		return isbn_code;
	}

	public void setIsbn_code(String isbn_code) {
		this.isbn_code = isbn_code;
	}

	public int getPublication_year() {
		return publication_year;
	}

	public void setPublication_year(int publication_year) {
		this.publication_year = publication_year;
	}

	public String getPublisher_name() {
		return publisher_name;
	}

	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}

	public Shelf getShelf() {
		return shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

    
}
