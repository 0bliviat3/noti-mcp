package com.example.notimcp.controller;

import com.example.notimcp.service.McpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mcp")
public class McpController {

    @Autowired
    private McpService mcpService;

    @PostMapping("/notification")
    public ResponseEntity<String> sendNotification(@RequestBody String message) {
        return ResponseEntity.ok(mcpService.sendNotification(message));
    }

    @GetMapping("/notification/{id}")
    public ResponseEntity<String> getNotification(@PathVariable String id) {
        return ResponseEntity.ok(mcpService.getNotification(id));
    }

    @PostMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("MCP Server is running");
    }
}