# MCP Notification Tool Documentation

## Overview
This is a Model Context Protocol (MCP) tool suite for sending notifications via various channels including SMS, Email, and Messenger.

## Available Methods

### 1. sendNotification
Sends a notification message via specified channel.

#### Parameters:
- `message` (string): The notification message to send
- `channel` (string): The notification channel - one of: sms, email, messenger

#### Example:
```json
{
  "method": "mcp.notification.send",
  "params": {
    "message": "Hello from MCP!",
    "channel": "email"
  }
}
```

### 2. getNotificationStatus  
Gets the status of a specific notification by ID.

#### Parameters:
- `messageId` (string): The notification message ID

#### Example:
```json
{
  "method": "mcp.notification.getStatus",
  "params": {
    "messageId": "12345"
  }
}
```

## Implementation Details

### Supported Channels:
- SMS: Text message delivery via phone numbers
- Email: Email message delivery via email addresses  
- Messenger: Instant messaging delivery via messenger IDs

### Error Handling:
- Invalid channel parameter returns error message
- All methods return descriptive status messages
- Message ID tracking for status monitoring

## Usage Examples

### 1. Sending SMS
```bash
curl -X POST http://localhost:8080/mcp/notification/sms \
  -H "Content-Type: application/json" \
  -d '{"message":"Test SMS","recipient":"+123****7890"}'
```

### 2. Sending Email
```bash
curl -X POST http://localhost:8080/mcp/notification/email \
  -H "Content-Type: application/json" \
  -d '{"message":"Test Email","recipient":"user@example.com","subject":"Test Subject"}'
```

### 3. Getting Status
```bash
curl -X GET http://localhost:8080/mcp/notification/status?messageId=12345
```

## Configuration

The notification tools support the following configuration properties:

- `noti.api.url`: Notification API URL (default: https://noti.skpsnm.com/api/v1/notification)
- `noti.api.token`: Notification API token (default: your-access-token-here)

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