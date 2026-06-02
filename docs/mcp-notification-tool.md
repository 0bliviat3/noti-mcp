# MCP Notification Tool Documentation

## Overview
This is a Model Context Protocol (MCP) tool for sending notifications via various channels including SMS, Email, and Messenger.

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
- `id` (string): The notification ID

#### Example:
```json
{
  "method": "mcp.notification.getStatus",
  "params": {
    "id": "12345"
  }
}
```

### 3. getAvailableChannels
Lists all available notification channels.

#### Example:
```json
{
  "method": "mcp.notification.getChannels",
  "params": {}
}
```

## Implementation Details

### Supported Channels:
- SMS: Text message delivery
- Email: Email message delivery  
- Messenger: Instant messaging delivery

### Error Handling:
- Invalid channel parameter returns error message
- All methods return descriptive status messages