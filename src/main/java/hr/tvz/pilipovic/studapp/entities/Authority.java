package hr.tvz.pilipovic.studapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="authority")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToMany(targetEntity = User.class, mappedBy = "authorities")
    private List<User> users;
}
