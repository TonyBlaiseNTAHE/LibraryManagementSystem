package Models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "shell")
public class Shell {

    @Id
    @GeneratedValue
    private UUID shell_id;

    @Column(nullable = false)
    private String book_category;

    @Column(nullable = false)
    private int initial_stock;

    @Column(nullable = false)
    private int available_stock;

    @Column(nullable = false)
    private int borrowed_number;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    // Getters and Setters
}

