package entity;

import jakarta.persistence.*;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "itinerary")
public class Itinerary {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itinerary_id")
    private Integer itineraryId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "package_id")
    private TravelPackage travelPackage;

    @Column(name = "day_number", nullable = false)
    private Integer dayNumber;

    @Column(columnDefinition = "tinytext")
    private String activities;
}
