package com.example.notimcp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Configuration for MCP tool registration with Spring AI 1.1.6 WebMVC
 */
@Configuration
@Import(org.springframework.ai.mcp.server.McpToolAutoConfiguration.class)
public class McpToolConfig {
    
}