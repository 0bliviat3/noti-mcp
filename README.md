# Noti-MCP - Model Context Protocol Server

A simple MCP (Model Context Protocol) server that provides notification services.

## Features

- **MCP Compliant**: Implements the Model Context Protocol specification
- **Multiple Notification Channels**: Supports SMS, Email, and Messenger notifications  
- **Simple API**: Easy integration with MCP clients
- **Spring Boot Integration**: Built on Spring Boot for easy deployment
- **Real API Integration**: Connects to actual Notification API endpoints

## MCP Tools

This server provides the following MCP tools:

### 1. Notification Tool (`mcp.notification`)

#### Available Methods:
- `sendNotification(message, channel)`: Send a notification via specified channel (SMS, Email, Messenger)
- `getNotificationStatus(id)`: Get status of specific notification  
- `getAvailableChannels()`: List all supported channels

#### Supported Channels:
- SMS: Mobile phone numbers
- Email: Email addresses  
- Messenger: Internal messaging system

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

#### Using mcp-remote (Node.js):
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

#### Using Python MCP Client:
```python
import asyncio
from mcp import Client

async def main():
    # Connect to the MCP server
    async with Client("http://localhost:8080/mcp") as client:
        # Use the notification tool
        result = await client.call_tool(
            tool="mcp.notification.send",
            args={
                "message": "Hello World!",
                "channel": "sms"
            }
        )
        print(result)

if __name__ == "__main__":
    asyncio.run(main())
```

## MCP Tool Methods

The server exposes the following MCP methods:

- `mcp.notification.send`: Send notification via specified channel
- `mcp.notification.getStatus`: Get notification status by ID
- `mcp.notification.getChannels`: List all available notification channels

## Configuration

### Environment Variables

The server supports the following environment variables:

- `SERVER_PORT` - Port to listen on (default: 8080)
- `NOTI_API_URL` - Notification API URL (default: https://noti.skpsnm.com/api/v1/notification)
- `NOTI_API_TOKEN` - Notification API token (required for real API calls)

### Example Configuration

```properties
# Server settings
SERVER_PORT=8080

# Notification API settings
NOTI_API_URL=https://noti.skpsnm.com/api/v1/notification
NOTI_API_TOKEN=your-real-api-token-here
```

### MCP Client Configuration

For MCP clients like `mcp-remote`, add this to your config.json:

```json
{
  "tools": {
    "notification": {
      "command": "java",
      "args": [
        "-jar",
        "/path/to/noti-mcp.jar"
      ]
    }
  },
  "server": {
    "url": "http://localhost:8080/mcp"
  }
}
```

## Endpoints

- `GET /mcp/health` - Health check endpoint
- `POST /mcp/notification` - Legacy notification endpoint

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