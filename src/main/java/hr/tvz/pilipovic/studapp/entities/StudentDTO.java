package hr.tvz.pilipovic.studapp.entities;


import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class StudentDTO {

    private final String JMBAG;
    private final Integer numberOfECTS;
    private final boolean tuitionShouldBePaid;

    public StudentDTO(String JMBAG, Integer numberOfECTS, boolean tuitionShouldBePaid) {
        this.JMBAG = JMBAG;
        this.numberOfECTS = numberOfECTS;
        this.tuitionShouldBePaid = tuitionShouldBePaid;
    }

    public String getJMBAG() {
        return JMBAG;
    }
    public Integer getNumberOfECTS() {
        return numberOfECTS;
    }
    public boolean isTuitionShouldBePaid() {
        return tuitionShouldBePaid;
    }
    @Override
    public String toString() {
        return "StudentDTO{" +
                "JMBAG='" + JMBAG + '\'' +
                ", numberOfECTS=" + numberOfECTS +
                ", tuitionShouldBePaid=" + tuitionShouldBePaid +
                '}';
    }

}

