# Noti-MCP - Model Context Protocol Server

A simple MCP (Model Context Protocol) server that provides notification services.

## Features

- **MCP Compliant**: Implements the Model Context Protocol specification
- **Multiple Notification Channels**: Supports SMS, Email, and Messenger notifications  
- **Simple API**: Easy integration with MCP clients
- **Spring Boot Integration**: Built on Spring Boot for easy deployment

## MCP Tools

This server provides the following MCP tools:

### 1. Notification Tool (`mcp.notification`)
- `sendNotification(message, channel)`: Send a notification via specified channel
- `getNotificationStatus(id)`: Get status of specific notification  
- `getAvailableChannels()`: List all supported channels

## Usage

### Running the Server
```bash
mvn spring-boot:run
```

Or build and run:
```bash
mvn clean package
java -jar target/noti-mcp-0.0.1-SNAPSHOT.jar
```

### Connecting MCP Client
```json
{
  "noti": {
    "command": "npx",
    "args": [
      "-y",
      "mcp-remote",
      "http://localhost:8080/mcp",
      "--allow-http"
    ]
  }
}
```

## Endpoints

- `GET /mcp/health` - Health check endpoint
- `POST /mcp/notification` - Legacy notification endpoint

## MCP Tool Methods

The server exposes the following MCP methods:
- `mcp.notification.send`
- `mcp.notification.getStatus` 
- `mcp.notification.getChannels`

## Configuration

### Environment Variables
- `SERVER_PORT` - Port to listen on (default: 8080)
- `NOTI_API_URL` - Notification API URL (default: https://noti.skpsnm.com/api/v1/notification)
- `NOTI_API_TOKEN` - Notification API token (default: your-access-token-here)

## Development

### Prerequisites
- Java 21+
- Maven 3.8+

### Building
```bash
mvn clean package
```

### Running Tests
```bash
mvn test
```

## License

MIT