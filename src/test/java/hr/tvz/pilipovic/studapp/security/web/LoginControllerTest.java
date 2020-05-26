package hr.tvz.pilipovic.studapp.security.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private String token;


    @Test
    void authenticate() throws Exception {

        // Unauthorized
        mockMvc.perform(
                post("/api/authenticate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\": \"test\"," +
                                "\"password\": \"testpassword\"}")
                        .accept(MediaType.APPLICATION_JSON)
                        .with(csrf())
        )
                .andExpect(status().isUnauthorized());

        // Authorized
        this.token = mockMvc.perform(
                post("/api/authenticate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\": \"admin\"," +
                                "\"password\": \"adminpassword\"}")
                        .accept(MediaType.APPLICATION_JSON)
                        .with(csrf())
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getHeader("Authorization");

    }
}