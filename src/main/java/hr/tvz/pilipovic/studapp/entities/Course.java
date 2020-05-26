package hr.tvz.pilipovic.studapp.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="courses")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    @Column(name="numberofects")
    private int numberOfEcts;

    @ManyToMany(targetEntity = Student.class, mappedBy = "courses")
    private List<Student> students;

    /*public List<Student> getStudents() {
        return students;
    }

     */

     public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Course(long id, String name, int numberOfEcts) {
        this.id = id;
        this.name = name;
        this.numberOfEcts = numberOfEcts;
    }

    public Course() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfEcts() {
        return numberOfEcts;
    }

    public void setNumberOfEcts(int numberOfEcts) {
        this.numberOfEcts = numberOfEcts;
    }

}


