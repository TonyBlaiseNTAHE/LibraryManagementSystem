package Models;

import java.util.UUID;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Memberships")
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "membership_id", updatable = false, nullable = false)
    private UUID membership_id;

    @Column(name = "membership_code", nullable = false, unique = true)
    private String membership_code;

    @Temporal(TemporalType.DATE)
    @Column(name = "expiring_time", nullable = false)
    private Date expiring_time;

    @Column(name = "membership_type_id", nullable = false)
    private UUID membership_type_id; // Link to the type of membership (Gold, Silver, Striver)

    @Enumerated(EnumType.STRING)
    @Column(name = "membership_status", nullable = false)
    private MembershipStatus membership_status;

    @Column(name = "reader_id", nullable = false)
    private UUID reader_id; // The ID of the user who holds this membership

    @Temporal(TemporalType.DATE)
    @Column(name = "registration_date", nullable = false)
    private Date registration_date; // The date the membership was created

    public Membership() {}

    public Membership(String membership_code, Date expiring_time, UUID membership_type_id,
                      MembershipStatus membership_status, UUID reader_id, Date registration_date) {
        this.membership_code = membership_code;
        this.expiring_time = expiring_time;
        this.membership_type_id = membership_type_id;
        this.membership_status = membership_status;
        this.reader_id = reader_id;
        this.registration_date = registration_date;
    }

    // Getters and Setters
    public UUID getMembership_id() {
        return membership_id;
    }

    public void setMembership_id(UUID membership_id) {
        this.membership_id = membership_id;
    }

    public String getMembership_code() {
        return membership_code;
    }

    public void setMembership_code(String membership_code) {
        this.membership_code = membership_code;
    }

    public Date getExpiring_time() {
        return expiring_time;
    }

    public void setExpiring_time(Date expiring_time) {
        this.expiring_time = expiring_time;
    }

    public UUID getMembership_type_id() {
        return membership_type_id;
    }

    public void setMembership_type_id(UUID membership_type_id) {
        this.membership_type_id = membership_type_id;
    }

    public MembershipStatus getMembership_status() {
        return membership_status;
    }

    public void setMembership_status(MembershipStatus membership_status) {
        this.membership_status = membership_status;
    }

    public UUID getReader_id() {
        return reader_id;
    }

    public void setReader_id(UUID reader_id) {
        this.reader_id = reader_id;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }
}
