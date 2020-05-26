package hr.tvz.pilipovic.studapp.entities;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CourseCommand implements Serializable   {

    @NotNull(message = "ID must be entered")
    private Long id;
    @NotBlank(message = "Naziv must be entered")
    private String name;
    @NotNull(message = "Number of ECTS points must be entered")
    @Max(message = "Number of ECTS can not be higher than 7", value = 7)
    @Min(message = "Number of ECTS can not be lower than 1", value = 1)
    private int numberOfEcts;

    public CourseCommand(@NotNull(message = "ID must be entered") Long id, @NotBlank(message = "Name must be entered") String name, @NotNull(message = "Number of ECTS points must be entered") @Max(message = "Number of ECTS can not be higher than 7", value = 7) @Min(message = "Number of ECTS can not be lower than 1", value = 1) int numberOfEcts) {
        this.id = id;
        this.name = name;
        this.numberOfEcts = numberOfEcts;
    }

    public CourseCommand(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setNumberOfEcts (int numberOfEcts) {
        this.numberOfEcts = numberOfEcts;
    }

    @Override
    public String toString() {
        return "CourseCommand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfEcts=" + numberOfEcts +
                '}';
    }
}


