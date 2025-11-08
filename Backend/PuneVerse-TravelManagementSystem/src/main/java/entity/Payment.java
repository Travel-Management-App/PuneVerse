package entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "payment")
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Integer paymentId;

    @ManyToOne @JoinColumn(name = "booking_id")
    private Booking booking;

    private String paymentMethod;

    @Column(nullable = false)
    private Double amount;

    private String status;

    @Column(name = "payment_date")
    private Instant paymentDate;
}

