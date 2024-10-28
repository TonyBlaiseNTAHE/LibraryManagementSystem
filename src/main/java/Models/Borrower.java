package Models;

import java.util.UUID;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Borrowers")
public class Borrower {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "borrow_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "book_id", nullable = false)
    private UUID book_id;

    @Column(name = "reader_id", nullable = false)
    private UUID reader_id;  // This is the User who borrowed the book

    @Temporal(TemporalType.DATE)
    @Column(name = "due_date", nullable = false)
    private Date due_date;

    @Temporal(TemporalType.DATE)
    @Column(name = "pickup_date", nullable = false)
    private Date pickup_date;

    @Temporal(TemporalType.DATE)
    @Column(name = "return_date")
    private Date return_date;  // Can be null if the book hasn't been returned yet

    @Column(name = "late_change_fees", nullable = false)
    private int late_change_fees = 0;

    public Borrower() {}

    public Borrower(UUID book_id, UUID reader_id, Date due_date, Date pickup_date) {
        this.book_id = book_id;
        this.reader_id = reader_id;
        this.due_date = due_date;
        this.pickup_date = pickup_date;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getBook_id() {
        return book_id;
    }

    public void setBook_id(UUID book_id) {
        this.book_id = book_id;
    }

    public UUID getReader_id() {
        return reader_id;
    }

    public void setReader_id(UUID reader_id) {
        this.reader_id = reader_id;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public Date getPickup_date() {
        return pickup_date;
    }

    public void setPickup_date(Date pickup_date) {
        this.pickup_date = pickup_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public int getLate_change_fees() {
        return late_change_fees;
    }

    public void setLate_change_fees(int late_change_fees) {
        this.late_change_fees = late_change_fees;
    }
}
