package hr.tvz.pilipovic.studapp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.tvz.pilipovic.studapp.entities.Student;
import hr.tvz.pilipovic.studapp.entities.StudentCommand;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void getAllStudents() throws Exception {
        this.mockMvc.perform(get("/student").with(user("admin").password("adminpassword").roles("ADMIN")))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    @WithMockUser(username = "admin", password = "adminpassword", roles = {"ADMIN"})
    void getStudent() throws Exception {

        // OK
        this.mockMvc.perform(get("/student/" + "0246077777"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName").exists())
                .andExpect(jsonPath("$.lastName").exists())
                .andExpect(jsonPath("$.jmbag").exists())
                .andExpect(jsonPath("$.numberOfECTS").exists())
                .andExpect(jsonPath("$.tuitionShouldBePaid").exists())
                .andExpect(jsonPath("$.dateOfBirth").exists())
                .andExpect(jsonPath("$.courses").isArray());


      /*  // NOT FOUND
        this.mockMvc.perform(get("/student/" + "fakejmbag"))
                .andExpect(status().isNotFound());

       */

    }

    @Test
    @WithMockUser(username = "admin", password = "adminpassword", roles = {"ADMIN"})
    void getStudentsByFirstname() throws Exception {

        // OK
        this.mockMvc.perform(get("/student/getStudentsByFirstName/"+ "Pero"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));


    }

    @Test
    @WithMockUser(username = "admin", password = "adminpassword", roles = {"ADMIN"})
    void getStudentsByCourse() throws Exception {

        this.mockMvc.perform(get("/student/getStudentsByCourse/" + "Android"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    //@DirtiesContext  -- ako se ukljuci @DirtiesContext iz nekog razloga dode do errora ( java.lang.IllegalStateException: Failed to load ApplicationContext)
    @Test
    @WithMockUser(username = "admin", password = "adminpassword", roles = {"ADMIN"})
    void addStudent() throws Exception {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
        StudentCommand sc = new StudentCommand();
        sc.setFirstName("Marko");
        sc.setLastName("Markic");
        sc.setJMBAG("0246076711");
        sc.setDateOfBirth(LocalDate.parse("01.01.1999.",df));
        sc.setNumberOfECTS(25);
        this.mockMvc.perform( MockMvcRequestBuilders
                .post("/student")
                //.with(user("admin").password("adminpassword")roles("ADMIN"))
                //.content(objectMapper.writeValueAsString(new StudentCommand("Marko", "Markic", "0246076711",  LocalDate.parse("01.01.1999.",df), 25)))//.content(asJsonString(new StudentCommand("Marko", "Markic", "0246076711", LocalDate.now(), 25)))
                .content(objectMapper.writeValueAsString(sc))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @WithMockUser(username = "admin", password = "adminpassword", roles = {"ADMIN"})
    //@DirtiesContext
    void editStudent() throws Exception {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
        StudentCommand s = new StudentCommand( "Pero", "Peric","0246077777" ,LocalDate.parse("01.01.1999.",df),160);

        this.mockMvc.perform( MockMvcRequestBuilders
                .put("/student")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(s))
                //.content(asJsonString(s))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @WithMockUser(username = "admin", password = "adminpassword", roles = {"ADMIN"})
    //@DirtiesContext
    void delete() throws Exception {

        //OK
        this.mockMvc.perform( MockMvcRequestBuilders.delete("/student/{JMBAG}", "0246033333"))
                //.with(user("admin").password("adminpassword").roles("ADMIN")))
                .andExpect(status().isOk());

        //NOT FOUND
        this.mockMvc.perform( MockMvcRequestBuilders.delete("/student/{JMBAG}", "fake"))
                //.with(user("admin").password("adminpassword").roles("ADMIN")))
                .andExpect(status().isNotFound());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}