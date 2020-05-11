package hr.tvz.pilipovic.studapp.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private String firstName;
    private String lastName;
    private String JMBAG;
    private Integer numberOfECTS;
    private boolean tuitionShouldBePaid;
    private String dateOfBirth;


}

