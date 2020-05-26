package hr.tvz.pilipovic.studapp.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @JsonIgnoreProperties("students")
    private List<Course> courses;



}

