package com.varun.portfolio.contact;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import com.varun.portfolio.contact.dto.ContactRequest;

@Component
public class ContactNotifier {

    private static final Logger log = LoggerFactory.getLogger(ContactNotifier.class);

    private final RestClient restClient = RestClient.create("https://api.resend.com");
    private final String apiKey;
    private final String to;

    public ContactNotifier(@Value("${app.mail.resend-api-key}") String apiKey,
                           @Value("${app.mail.to}") String to) {
        this.apiKey = apiKey;
        this.to = to;
    }

    public void notifyNewMessage(ContactRequest request) {
        if (apiKey.isBlank() || to.isBlank()) {
            log.info("Email is not configured, skipping notification");
            return;
        }
        Map<String, Object> email = Map.of(
                "from", "Portfolio <onboarding@resend.dev>",
                "to", List.of(to),
                "reply_to", request.email(),
                "subject", "Portfolio contact: " + request.subject(),
                "text", "From: " + request.name() + " <" + request.email() + ">\n\n" + request.message());
        try {
            restClient.post()
                    .uri("/emails")
                    .headers(headers -> headers.setBearerAuth(apiKey))
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(email)
                    .retrieve()
                    .toBodilessEntity();
            log.info("Contact notification sent");
        } catch (RestClientException ex) {
            // The message is already saved, so log the failure and carry on.
            log.error("Could not send contact notification", ex);
        }
    }
}