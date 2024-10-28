package Models;

import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "Locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "location_id", updatable = false, nullable = false)
    private UUID location_id;

    @Column(name = "location_code", nullable = false)
    private String location_code;

    @Column(name = "location_name", nullable = false)
    private String location_name;

    @Enumerated(EnumType.STRING)
    @Column(name = "location_type", nullable = false)
    private LocationType location_type;

    /* Self-referencing many-to-one relationship to represent the parent location*/
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Location parentLocation;

    public Location() {}

    // Constructor for initializing Location object
    public Location(String location_code, String location_name, LocationType location_type, Location parentLocation) {
        this.location_code = location_code;
        this.location_name = location_name;
        this.location_type = location_type;
        this.parentLocation = parentLocation;
    }

    // Getters and Setters
    public UUID getLocation_id() {
        return location_id;
    }

    public void setLocation_id(UUID location_id) {
        this.location_id = location_id;
    }

    public String getLocation_code() {
        return location_code;
    }

    public void setLocation_code(String location_code) {
        this.location_code = location_code;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public LocationType getLocation_type() {
        return location_type;
    }

    public void setLocation_type(LocationType location_type) {
        this.location_type = location_type;
    }

    public Location getParentLocation() {
        return parentLocation;
    }

    public void setParentLocation(Location parentLocation) {
        this.parentLocation = parentLocation;
    }
}
