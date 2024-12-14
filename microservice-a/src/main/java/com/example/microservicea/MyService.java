
package com.example.microservicea;

import org.springframework.stereotype.Service;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class MyService {

    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "fallbackMethod")
    public String riskyMethod() {
        throw new RuntimeException("Simulated failure");
    }

    public String fallbackMethod(Throwable throwable) {
        return "Fallback response";
    }
}
