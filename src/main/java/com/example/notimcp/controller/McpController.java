package com.example.notimcp.controller;

import com.example.notimcp.service.McpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * MCP Controller for handling HTTP requests and providing MCP tool endpoints
 */
@RestController
@RequestMapping("/mcp")
public class McpController {

    @Autowired
    private McpService mcpService;

    /**
     * Health check endpoint
     */
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("MCP Server is running");
    }

    /**
     * Legacy notification endpoint (maintained for backward compatibility)
     */
    @PostMapping("/notification")
    public ResponseEntity<String> sendNotification(@RequestBody String message) {
        return ResponseEntity.ok(mcpService.sendNotification(message));
    }
}