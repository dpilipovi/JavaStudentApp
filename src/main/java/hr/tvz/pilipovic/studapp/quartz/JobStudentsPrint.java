package hr.tvz.pilipovic.studapp.quartz;


import hr.tvz.pilipovic.studapp.entities.StudentDTO;
import hr.tvz.pilipovic.studapp.services.StudentService;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

public class JobStudentsPrint extends QuartzJobBean {

    @Autowired
    private StudentService studentService;

    private List<StudentDTO> studentList;

    private void setStudentList(List<StudentDTO> lista)
    {
        this.studentList = lista;
    }


    @Override
    protected void executeInternal(org.quartz.JobExecutionContext jobExecutionContext) throws JobExecutionException {

        setStudentList(studentService.findAll());

        System.out.println("---------------");
        System.out.println("Ovo su trenutno upisani studenti:");
        System.out.println("---------------");
        this.studentList.forEach(studentDTO -> System.out.println(studentDTO.getJMBAG() + " - " + studentDTO.getFirstName() + " " + studentDTO.getLastName()));
        System.out.println("---------------");

    }
}
