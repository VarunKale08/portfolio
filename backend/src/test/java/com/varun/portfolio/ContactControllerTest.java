package com.varun.portfolio.contact;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.varun.portfolio.contact.dto.ContactRequest;

@WebMvcTest(ContactController.class)
class ContactControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ContactService contactService;   // fake: no database, no email

    @MockitoBean
    private RateLimiter rateLimiter;         // fake: we decide allow or refuse

    @BeforeEach
    void allowRequestsByDefault() {
        when(rateLimiter.tryAcquire(anyString())).thenReturn(true);
    }

    @Test
    void validMessageReturns201AndIsPassedToTheService() throws Exception {
        mockMvc.perform(post("/api/contact")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"name":"Test User","email":"test@example.com",
                                 "subject":"Hello","message":"Testing the form"}
                                """))
                .andExpect(status().isCreated());

        verify(contactService).submit(any(ContactRequest.class));
    }

    @Test
    void invalidMessageReturns400WithFieldErrors() throws Exception {
        mockMvc.perform(post("/api/contact")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"name":"","email":"abc","subject":"Hello","message":"Hi"}
                                """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors.name").exists())
                .andExpect(jsonPath("$.errors.email").exists());

        verify(contactService, never()).submit(any());
    }

    @Test
    void returns429WhenTheRateLimitIsExceeded() throws Exception {
        when(rateLimiter.tryAcquire(anyString())).thenReturn(false);

        mockMvc.perform(post("/api/contact")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isTooManyRequests());
    }
}