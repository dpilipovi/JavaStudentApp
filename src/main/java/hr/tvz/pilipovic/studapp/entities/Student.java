package hr.tvz.pilipovic.studapp.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="STUDENTS")
public class Student implements Serializable {

    @Id
    private String JMBAG;
    private String firstName;
    private String lastName;
    private Integer numberOfECTS;
    private LocalDate dateOfBirth;
    @ManyToMany(targetEntity = Course.class)
    @JoinTable(
            name = "student_course",
            joinColumns = { @JoinColumn(name = "student_jmbag", referencedColumnName = "JMBAG", nullable = false), },
            inverseJoinColumns = { @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false) }
    )
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

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

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", numberOfECTS=" + numberOfECTS +
                ", dateOfBirth=" + dateOfBirth +
                ", JMBAG='" + JMBAG + '\'' +
                '}';
    }
}