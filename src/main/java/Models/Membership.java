package Models;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "membership")
public class Membership {

    @Id
    @GeneratedValue
    private UUID membership_id;

    @Column(nullable = false)
    private String membership_code;

    @Column(nullable = false)
    private int fine;

    @Column(nullable = false)
    private Date expiring_time;

    @Enumerated(EnumType.STRING)
    private Status membership_status;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private User reader;

    public enum Status {
        APPROVED, REJECTED, PENDING
    }

    // Getters and Setters
    public Membership(String membership_code, int fine, Date expiring_time, Status membership_status, User reader) {
        this.membership_code = membership_code;
        this.fine = fine;
        this.expiring_time = expiring_time;
        this.membership_status = membership_status;
        this.reader = reader;
    }
}

