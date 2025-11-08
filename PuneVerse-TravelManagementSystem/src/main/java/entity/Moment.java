package entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "moment")
public class Moment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "moment_id")
    private Integer momentId;

    @ManyToOne @JoinColumn(name = "user_id")
    private User user;

    private String content;
    private String imageUrl;

    @Column(name = "created_at")
    private Instant createdAt;
}

