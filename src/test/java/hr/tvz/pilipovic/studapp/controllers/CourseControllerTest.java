package hr.tvz.pilipovic.studapp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.tvz.pilipovic.studapp.entities.Course;
import hr.tvz.pilipovic.studapp.entities.CourseCommand;
import hr.tvz.pilipovic.studapp.services.CourseServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void getAllCourses() throws Exception {
        this.mockMvc.perform(get("/course").with(user("admin").password("adminpassword").roles("ADMIN")))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @WithMockUser(username = "admin", password = "adminpassword", roles = {"ADMIN"})
    void getCoursesByStudentJmbag() throws Exception {
        this.mockMvc.perform(get("/course/}" + "0246077777"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @WithMockUser(username = "admin", password = "adminpassword", roles = {"ADMIN"})
    void getCoursesByStudentJmbag2() throws Exception {
        this.mockMvc.perform(get("/course/" + "0246077777"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @WithMockUser(username = "admin", password = "adminpassword", roles = {"ADMIN"})
    void getAllCoursesByName() throws Exception {
        this.mockMvc.perform(get("/course/findByName/" + "Android"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @WithMockUser(username = "admin", password = "adminpassword", roles = {"ADMIN"})
    void getCourseByName() throws Exception {
        this.mockMvc.perform(get("/course/findCourseByName/" + "Android"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.numberOfEcts").exists());

    }

    @Test
    @WithMockUser(username = "admin", password = "adminpassword", roles = {"ADMIN"})
    //@DirtiesContext
    void editCourse() throws Exception {

        CourseCommand c = new CourseCommand();
        c.setId(new Long(2));
        c.setName("AndroidTest");
        c.setNumberOfEcts(6);

        Course course = new Course();
        course.setId(new Long(2));
        course.setName("AndroidTest");
        course.setNumberOfEcts(6);

        //Da se testiraju geteri i seteri
        Long id = c.getId();
        String name = c.getName();
        int ects = c.getNumberOfEcts();

        Long id2 = course.getId();
        String name2= course.getName();
        int ects2 = course.getNumberOfEcts();

        assertNotNull(id);
        assertNotNull(name);
        assertNotNull(ects);

        assertNotNull(id2);
        assertNotNull(name2);
        assertNotNull(ects2);



        this.mockMvc.perform( MockMvcRequestBuilders
                .put("/course")
              //  .with(user("admin").password("adminpassword").roles("ADMIN"))
                .contentType(MediaType.APPLICATION_JSON)
                //.content(asJsonString(c))
                .content(objectMapper.writeValueAsString(c))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.numberOfEcts").exists());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}