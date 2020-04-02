package hr.tvz.pilipovic.studapp.entities;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CourseCommand {

    @NotNull(message = "ID must be entered")
    private int id;
    @NotBlank(message = "Naziv must be entered")
    private String naziv;
    @NotNull(message = "Number of ECTS points must be entered")
    @Max(message = "Number of ECTS can not be higher than 7", value = 7)
    @Min(message = "Number of ECTS can not be lower than 1", value = 1)
    private int brojECTS;

    public CourseCommand(@NotNull(message = "ID must be entered") int id, @NotBlank(message = "Naziv must be entered") String naziv, @NotNull(message = "Number of ECTS points must be entered") @Max(message = "Number of ECTS can not be higher than 7", value = 7) @Min(message = "Number of ECTS can not be lower than 1", value = 1) int brojECTS) {
        this.id = id;
        this.naziv = naziv;
        this.brojECTS = brojECTS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojECTS() {
        return brojECTS;
    }

    public void setBrojECTS(int brojECTS) {
        this.brojECTS = brojECTS;
    }
}
