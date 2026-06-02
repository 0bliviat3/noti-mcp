# MCP Notification Tool Documentation

## Overview
This is a Model Context Protocol (MCP) tool suite for sending notifications via various channels including SMS, Email, and Messenger.

## Available Tools

### 1. SMS Notification Tool (`mcp.notification.sms`)
- `sendSms(message, recipient)`: Send an SMS to specified recipient
- `getSmsStatus(messageId)`: Get status of specific SMS message

#### Parameters:
- `message` (string): The SMS message content
- `recipient` (string): Recipient's phone number

#### Example:
```json
{
  "method": "mcp.notification.sms.send",
  "params": {
    "message": "Hello from SMS!",
    "recipient": "+1234567890"
  }
}
```

### 2. Email Notification Tool (`mcp.notification.email`)
- `sendEmail(message, recipient, subject)`: Send an email to specified recipient
- `getEmailStatus(messageId)`: Get status of specific email message

#### Parameters:
- `message` (string): The email message content  
- `recipient` (string): Recipient's email address
- `subject` (string): Email subject line

#### Example:
```json
{
  "method": "mcp.notification.email.send",
  "params": {
    "message": "Hello from Email!",
    "recipient": "user@example.com",
    "subject": "Test Email"
  }
}
```

### 3. Messenger Notification Tool (`mcp.notification.messenger`)
- `sendMessenger(message, recipient)`: Send a messenger message to specified recipient
- `getMessengerStatus(messageId)`: Get status of specific messenger message

#### Parameters:
- `message` (string): The messenger message content
- `recipient` (string): Recipient's messenger ID

#### Example:
```json
{
  "method": "mcp.notification.messenger.send",
  "params": {
    "message": "Hello from Messenger!",
    "recipient": "messenger_user_123"
  }
}
```

## Implementation Details

### Supported Channels:
- **SMS**: Text message delivery via phone numbers
- **Email**: Email message delivery via email addresses  
- **Messenger**: Instant messaging delivery via messenger IDs

### Error Handling:
- Invalid channel parameters return error messages
- All methods return descriptive status messages
- Message ID tracking for status monitoring

## Usage Examples

### 1. Sending SMS
```bash
curl -X POST http://localhost:8080/mcp/notification/sms \
  -H "Content-Type: application/json" \
  -d '{"message":"Test SMS","recipient":"+1234567890"}'
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