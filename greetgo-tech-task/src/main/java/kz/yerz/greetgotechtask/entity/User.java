package kz.yerz.greetgotechtask.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="t_users", uniqueConstraints =
        {@UniqueConstraint(columnNames = { "email"})})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="email")
    @NotEmpty(message = "Email should be not empty")
    private String email;

    @Column(name="password")
//    @Size(min = 8, message = "Password must be at least 8 characters long")
//    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",
//            message = "Password must contain at least one lowercase letter, one uppercase letter, and one digit")
    private String password;

    @Column(name="full_name")
    @Size(min=2, max=200, message="Name must be at least 2 characters long")
    private String fullName;

}
