package Models;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "location")
public class Location {
    
    @Id
    @GeneratedValue
    private UUID location_id;
    
    @Column(nullable = false)
    private String location_code;
    
    @Column(nullable = false)
    private String location_name;
    
    @Enumerated(EnumType.STRING)
    private LocationType location_type;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Location parent;

    public enum LocationType {
        PROVINCE, DISTRICT, SECTOR, CELL, VILLAGE
    }
    
    public Location(String location_code, String location_name, LocationType location_type, Location parent) {
        this.location_code = location_code;
        this.location_name = location_name;
        this.location_type = location_type;
        this.parent = parent;
    }
    // Getters and Setters
}
