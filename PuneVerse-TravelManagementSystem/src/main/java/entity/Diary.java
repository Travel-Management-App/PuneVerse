package entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "diary")
public class Diary {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_id")
    private Integer diaryId;

    @ManyToOne @JoinColumn(name = "user_id")
    private User user;

    private String bucketList;
    private String checklist;
    private String journey;

    @Column(name = "created_at")
    private Instant createdAt;
}
