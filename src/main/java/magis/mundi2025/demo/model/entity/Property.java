package magis.mundi2025.demo.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String description;
    private Integer starRating;
    private String imageUrl;

    @OneToMany(mappedBy = "property")
    private List<Room> rooms;

//    @OneToMany(mappedBy = "hotel")
//    private List<Review> reviews;
}
