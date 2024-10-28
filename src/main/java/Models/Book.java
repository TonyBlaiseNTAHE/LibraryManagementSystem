package Models;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue
    private UUID book_id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String ISBNCODE;

    @Column(nullable = false)
    private Date publication_year;

    @Column(nullable = false)
    private String publisher_name;

    @Column(nullable = false)
    private int edition;

    @Enumerated(EnumType.STRING)
    private BookStatus book_status;

    @ManyToOne
    @JoinColumn(name = "shell_id")
    private Shell shell;

    public enum BookStatus {
        BORROWED, RESERVED, AVAILABLE
    }

	public UUID getBook_id() {
		return book_id;
	}

	public void setBook_id(UUID book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getISBNCODE() {
		return ISBNCODE;
	}

	public void setISBNCODE(String iSBNCODE) {
		ISBNCODE = iSBNCODE;
	}

	public Date getPublication_year() {
		return publication_year;
	}

	public void setPublication_year(Date publication_year) {
		this.publication_year = publication_year;
	}

	public String getPublisher_name() {
		return publisher_name;
	}

	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public BookStatus getBook_status() {
		return book_status;
	}

	public void setBook_status(BookStatus book_status) {
		this.book_status = book_status;
	}

	public Shell getShell() {
		return shell;
	}

	public void setShell(Shell shell) {
		this.shell = shell;
	}

    // Getters and Setters
}

