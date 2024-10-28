package Models;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "borrower")
public class Borrower {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private Date pickup_date;

    @Column(nullable = false)
    private Date due_date;

    @Column
    private Date return_date;

    @Column
    private int late_change_fees;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private User reader;

    // Getters and Setters
    
}

