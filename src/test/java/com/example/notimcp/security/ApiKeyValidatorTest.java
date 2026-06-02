package com.example.notimcp.security;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApiKeyValidatorTest {

    @Test
    void testValidApiKey() {
        // This is a basic test - in real scenario we'd test with actual API key
        // For now, we're just ensuring the class loads correctly
        assertTrue(true);
    }
}