package hr.tvz.pilipovic.studapp.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;

    @ManyToMany(targetEntity = Authority.class)
    @JoinTable(
            name = "user_authority",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "authority_id") }
    )
    private Set<Authority> authorities;


}
