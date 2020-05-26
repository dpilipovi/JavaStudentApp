package hr.tvz.pilipovic.studapp.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getCurrentUser() throws Exception {

        // OK
        this.mockMvc.perform(get("/api/user/current-user").with(user("admin").password("adminpassword").roles("ADMIN")))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        // Bad token
        mockMvc.perform(
                get("/api/user/current-user")
                        .header("Authorization", "Bearer test-bearertoken123.123")
        )
                .andExpect(status().isUnauthorized());


        // Bad request
        mockMvc.perform(
                get("/api/user/current-user")
        )
                .andExpect(status().isUnauthorized());
    }

}