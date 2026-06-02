package com.example.notimcp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * MCP Tool configuration to enable automatic tool registration
 */
@Configuration
@Import(com.modelcontextprotocol.McpToolAutoConfiguration.class)
public class McpToolConfig {
    
}