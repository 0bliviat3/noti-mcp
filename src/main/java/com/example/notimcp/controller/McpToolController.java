package com.example.notimcp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * MCP Tool metadata endpoint for tool discovery
 * Provides list of available tools for MCP clients
 */
@RestController
@RequestMapping("/mcp")
public class McpToolController {
    
    /**
     * Get list of available MCP tools
     * This endpoint provides tool metadata for MCP client discovery
     * 
     * @return JSON object with tool list and metadata
     */
    @GetMapping("/tools")
    public ResponseEntity<Map<String, Object>> getAvailableTools() {
        Map<String, Object> response = new HashMap<>();
        
        // Tool metadata
        Map<String, Object> toolMetadata = new HashMap<>();
        toolMetadata.put("name", "noti-mcp-tools");
        toolMetadata.put("version", "1.0.0");
        toolMetadata.put("description", "Notification tools for MCP protocol");
        
        // Available tools
        List<Map<String, Object>> tools = new ArrayList<>();
        
        // Notification tool - send notification
        Map<String, Object> sendTool = new HashMap<>();
        sendTool.put("name", "mcp.notification.send");
        sendTool.put("description", "Send notification via specified channel (sms, email, messenger)");
        Map<String, Object> sendParams = new HashMap<>();
        sendParams.put("message", Map.of("type", "string", "description", "Notification message"));
        sendParams.put("channel", Map.of("type", "string", "description", "Channel type: sms, email, messenger"));
        sendTool.put("parameters", sendParams);
        tools.add(sendTool);
        
        // Status tool - get notification status  
        Map<String, Object> statusTool = new HashMap<>();
        statusTool.put("name", "mcp.notification.getStatus");
        statusTool.put("description", "Get status of specific notification by ID");
        Map<String, Object> statusParams = new HashMap<>();
        statusParams.put("messageId", Map.of("type", "string", "description", "Notification message ID"));
        statusTool.put("parameters", statusParams);
        tools.add(statusTool);
        
        // Channel tool - get available channels
        Map<String, Object> channelTool = new HashMap<>();
        channelTool.put("name", "mcp.notification.getChannels");
        channelTool.put("description", "List all available notification channels");
        channelTool.put("parameters", new HashMap<>());
        tools.add(channelTool);
        
        response.put("metadata", toolMetadata);
        response.put("tools", tools);
        
        return ResponseEntity.ok(response);
    }
}