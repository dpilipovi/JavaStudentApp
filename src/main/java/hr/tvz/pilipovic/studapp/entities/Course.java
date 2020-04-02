package hr.tvz.pilipovic.studapp.entities;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Course {

    private int id;
    private String naziv;
    private int brojECTS;

    public Course(int id,  String naziv, int brojECTSa) {
        this.id = id;
        this.naziv = naziv;
        this.brojECTS = brojECTSa;
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

    public int getBrojECTSa() {
        return brojECTS;
    }

    public void setBrojECTSa(int brojECTSa) {
        this.brojECTS = brojECTSa;
    }
}
