package hr.tvz.pilipovic.studapp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class StudentCommand implements Serializable {

    DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy.");

    @NotBlank(message = "First name must not be empty")
    private String firstName;
    @NotBlank(message = "Last name must not be empty")
    private String lastName;
    @NotBlank(message = "JMBAG must not be empty")
    @Pattern(message = "JMBAG must have 10 digits", regexp="[\\d]{10}")
    private String JMBAG;
    @JsonFormat(pattern = "dd.MM.yyyy.")
    @NotNull(message = "Date of birth must be entered")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;
    @NotNull(message = "Number of ECTS points must be entered")
    @PositiveOrZero(message = "Number of ECTS must be entered as a positive integer")
    @Max(message = "Number of ECTS can not be higher than 480", value = 480)
    private Integer numberOfECTS;


    public StudentCommand(@NotBlank(message = "First name must not be empty") String firstName, @NotBlank(message = "Last name must not be empty") String lastName, @NotBlank(message = "JMBAG must not be empty") @Pattern(message = "JMBAG must have 10 digits", regexp = "[\\d]{10}") String JMBAG, @NotNull(message = "Date of birth must be entered") @Past(message = "Date of birth must be in the past") String dateOfBirth, @NotNull(message = "Number of ECTS points must be entered") @PositiveOrZero(message = "Number of ECTS must be entered as a positive integer") @Max(message = "Number of ECTS can not be higher than 480", value = 480) Integer numberOfECTS) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.JMBAG = JMBAG;
        this.dateOfBirth = LocalDate.parse(dateOfBirth,df); // salje se u stringu pa parsa u localdate zbog errora
        this.numberOfECTS = numberOfECTS;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setJMBAG(String JMBAG) {
        this.JMBAG = JMBAG;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setNumberOfECTS(Integer numberOfECTS) {
        this.numberOfECTS = numberOfECTS;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getJMBAG() {
        return JMBAG;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getNumberOfECTS() {
        return numberOfECTS;
    }
}
