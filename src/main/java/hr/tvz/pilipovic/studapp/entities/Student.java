package hr.tvz.pilipovic.studapp.entities;

import lombok.Data;

import java.time.LocalDate;


public class Student {
    private String firstName;
    private String lastName;
    private Integer numberOfECTS;
    private LocalDate dateOfBirth;
    private String JMBAG;

    public Student(){}

    public Student(String firstName, String lastName, Integer numberOfECTS, LocalDate dateOfBirth, String JMBAG) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberOfECTS = numberOfECTS;
        this.dateOfBirth = dateOfBirth;
        this.JMBAG = JMBAG;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumberOfECTS() {
        return numberOfECTS;
    }

    public void setNumberOfECTS(Integer numberOfECTS) {
        this.numberOfECTS = numberOfECTS;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getJMBAG() {
        return JMBAG;
    }

    public void setJMBAG(String JMBAG) {
        this.JMBAG = JMBAG;
    }
}