package com.example.notimcp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Configuration for MCP tool registration with Spring AI
 */
@Configuration
@Import(org.springframework.ai.mcp.McpToolAutoConfiguration.class)
public class McpToolConfig {
    
}