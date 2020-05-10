package hr.tvz.pilipovic.studapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private Set<String> authorities;

}
