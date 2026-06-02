package com.example.notimcp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class McpRouterConfig {

    @Bean
    public RouterFunction<ServerResponse> mcpRoutes() {
        return route(POST("/mcp"), 
                request -> ServerResponse.ok().bodyValue("MCP endpoint reached"))
                .andRoute(GET("/mcp"), 
                        request -> ServerResponse.ok().bodyValue("MCP GET endpoint reached"));
    }
}