package org.salas.person.service.config;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class MainConfig {

    // Порог медленных вызовов в процентах
    // Порог времени для медленного вызова (1 секунда)
    // Минимальное количество вызовов для активации Circuit Breaker
    // Порог неудачных вызовов .
    // Время ожидания в состоянии OPEN
    @Bean
    public CircuitBreakerConfig circuitBreakerConfig() {
        return CircuitBreakerConfig.custom()
                .slowCallRateThreshold(100)
                .slowCallDurationThreshold(Duration.ofSeconds(1))
                .minimumNumberOfCalls(3)
                .failureRateThreshold(3)
                .waitDurationInOpenState(Duration.ofMillis(1000)).build();
    }

    @Bean
    public CircuitBreaker circuitBreaker() {
        return CircuitBreaker.of("notes-breaker", circuitBreakerConfig());
    }

}
