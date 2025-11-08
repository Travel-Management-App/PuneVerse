package entity;

import jakarta.persistence.*;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "user")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "u_name", nullable = false)
    private String uName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    @Column(name = "role_name", nullable = false)
    private String roleName = "USER";
}

