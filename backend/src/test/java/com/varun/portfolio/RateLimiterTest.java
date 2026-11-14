package com.varun.portfolio.contact;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RateLimiterTest {

    @Test
    void allowsRequestsUpToTheLimit() {
        RateLimiter limiter = new RateLimiter(3, 60);

        assertThat(limiter.tryAcquire("1.1.1.1")).isTrue();
        assertThat(limiter.tryAcquire("1.1.1.1")).isTrue();
        assertThat(limiter.tryAcquire("1.1.1.1")).isTrue();
    }

    @Test
    void blocksRequestsOverTheLimit() {
        RateLimiter limiter = new RateLimiter(2, 60);
        limiter.tryAcquire("1.1.1.1");
        limiter.tryAcquire("1.1.1.1");

        assertThat(limiter.tryAcquire("1.1.1.1")).isFalse();
    }

    @Test
    void countsEachClientSeparately() {
        RateLimiter limiter = new RateLimiter(1, 60);
        limiter.tryAcquire("1.1.1.1");

        assertThat(limiter.tryAcquire("2.2.2.2")).isTrue();
    }

    @Test
    void blocksSecondAndThirdRequestWhenLimitIsOne() {
        RateLimiter limiter = new RateLimiter(1, 60);

        // 1. First request should be allowed
        assertThat(limiter.tryAcquire("1.1.1.1")).isTrue();

        // 2. Second request should be blocked
        assertThat(limiter.tryAcquire("1.1.1.1")).isFalse();

        // 3. Third request should also be blocked
        assertThat(limiter.tryAcquire("1.1.1.1")).isFalse();
    }
}