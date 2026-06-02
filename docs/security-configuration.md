# Security Configuration for MCP Server

## Overview
This document describes the security configuration for the MCP server that integrates with the notification API. The implementation includes JWT-based authentication and API key validation.

## Security Features

### 1. API Key Validation
- **Method**: HTTP Header `X-API-Key`
- **Purpose**: Basic access control to the server
- **Implementation**: `ApiKeyValidator` component checks against configured valid key

### 2. JWT Token Authentication  
- **Method**: HTTP Header `Authorization: Bearer <token>`
- **Purpose**: Secure session management for authenticated requests
- **Implementation**: 
  - `JwtConfig`: JWT configuration and token generation
  - `JwtTokenProvider`: Token creation and validation logic

## Configuration Properties

### Required Properties:
```properties
# API Key for basic access control
api.key=your-api-key-here

# JWT Secret Key (should be kept secure)
jwt.secret=your-secret-key-here

# JWT Expiration time in milliseconds (e.g., 86400000 = 24 hours)
jwt.expiration=86400000
```

### Optional Properties:
```properties
# Security settings can be customized as needed
server.ssl.enabled=false
```

## Security Endpoints

### 1. Authentication
- **Endpoint**: `POST /mcp/auth/login`
- **Header**: `X-API-Key: [your-api-key]`
- **Response**: Success or failure message

### 2. Token Validation
- **Endpoint**: `GET /mcp/auth/validate`  
- **Header**: `Authorization: Bearer [jwt-token]`
- **Response**: Validity status of the token

## Security Best Practices

### 1. API Key Management
- Store API keys as environment variables
- Rotate keys periodically
- Use different keys for development and production

### 2. JWT Security
- Use strong secret keys (minimum 256-bit)
- Set appropriate expiration times
- Implement refresh token mechanisms if needed

### 3. Input Validation
- Validate all input parameters
- Sanitize user inputs
- Implement rate limiting to prevent abuse

## Implementation Details

### JWT Implementation
The JWT implementation uses:
- HS512 signing algorithm
- Base64 encoded secret key
- Expiration time setting

### API Key Implementation  
The API key validation:
- Checks for presence of X-API-Key header
- Compares with configured valid key
- Returns appropriate HTTP status codes

## Testing Considerations

### 1. Authentication Tests
- Valid API key should grant access
- Invalid API key should return 401
- Missing API key should return 401

### 2. JWT Tests
- Valid JWT token should pass validation
- Expired tokens should fail validation
- Invalid tokens should fail validation

## Deployment Recommendations

1. **Environment Variables**: Store sensitive values as environment variables
2. **HTTPS**: Enable HTTPS in production environments
3. **Logging**: Log security events appropriately
4. **Monitoring**: Monitor for unauthorized access attempts

## Security Vulnerabilities to Avoid

1. **Insecure Storage**: Never store secrets in source code
2. **Weak Keys**: Use cryptographically strong keys
3. **Missing Validation**: Always validate inputs and headers
4. **Excessive Permissions**: Follow principle of least privilege

This security implementation provides a foundation for protecting your MCP server while maintaining usability for authorized clients.