package entity;


import jakarta.persistence.*;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "package")
public class TravelPackage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_id")
    private Integer packageId;

    private String title;

    @Column(columnDefinition = "tinytext")
    private String description;

    @Column(name = "duration_days")
    private Integer durationDays;

    @Column(name = "cost_per_person", nullable = false)
    private Integer costPerPerson;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;
}
