package com.varun.portfolio.contact;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RateLimiter {

    // When a client's current window started, and how many requests it has made in it.
    private record Window(Instant start, int count) {
    }

    private final Map<String, Window> windows = new ConcurrentHashMap<>();
    private final int maxRequests;
    private final Duration window;

    public RateLimiter(@Value("${app.contact.rate-limit.max-requests}") int maxRequests,
                       @Value("${app.contact.rate-limit.window-minutes}") long windowMinutes) {
        this.maxRequests = maxRequests;
        this.window = Duration.ofMinutes(windowMinutes);
    }

    public boolean tryAcquire(String clientKey) {
        Instant now = Instant.now();
        if (windows.size() > 10_000) {
            windows.values().removeIf(w -> now.isAfter(w.start().plus(window)));
        }
        Window updated = windows.compute(clientKey, (key, current) ->
                current == null || now.isAfter(current.start().plus(window))
                        ? new Window(now, 1)
                        : new Window(current.start(), current.count() + 1));
        return updated.count() <= maxRequests;
    }
}