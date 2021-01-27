package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Table(name = "client_user")
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

}
