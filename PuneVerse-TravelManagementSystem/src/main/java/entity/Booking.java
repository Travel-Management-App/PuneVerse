package entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "booking")
public class Booking {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Integer bookingId;

    @ManyToOne @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne @JoinColumn(name = "package_id")
    private TravelPackage travelPackage;

    private LocalDate travelDate;
    private Integer numberOfPeople;

    @Column(nullable = false)
    private Double totalCost;

    private LocalDate bookingDate;
    @Column(nullable = false)
    private String status;
}
