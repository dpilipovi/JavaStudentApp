package hr.tvz.pilipovic.studapp.entities;

public class CourseDTO {

    private String naziv;
    private int brojECTS;

    public CourseDTO(String naziv, int brojECTS) {
        this.naziv = naziv;
        this.brojECTS = brojECTS;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getBrojECTS() {
        return brojECTS;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "naziv='" + naziv + '\'' +
                ", brojECTS=" + brojECTS +
                '}';
    }
}
