package com.example.notimcp.tool;

import org.springaicommunity.mcp.annotation.McpTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.notimcp.client.NotificationApiClient;
import com.example.notimcp.model.ApiRequest;
import com.example.notimcp.model.ApiResponse;

/**
 * Notification Tool for MCP protocol compliance
 */
@Service
public class NotificationTool {
    
    @Autowired
    private NotificationApiClient notificationApiClient;
    
    @Value("${noti.api.url:https://noti.skpsnm.com/api/v1/notification}")
    private String apiUrl;
    
    @Value("${noti.api.token:}")
    private String apiToken;
    
    /**
     * Send notification via specified channel
     * @param message notification message
     * @param channel notification channel (sms, email, messenger)
     * @return send result
     */
    @McpTool(name = "send-notification", description = "Send notification via specified channel")
    public String sendNotification(String message, String channel) {
        try {
            // Validate input parameters
            if (message == null || message.trim().isEmpty()) {
                return "Error: Message is required";
            }
            if (channel == null || channel.trim().isEmpty()) {
                return "Error: Channel is required";
            }
            
            // Prepare request based on channel type
            String endpoint = "";
            switch (channel.toLowerCase()) {
                case "sms":
                    endpoint = "/sms";
                    break;
                case "email":
                    endpoint = "/email";
                    break;
                case "messenger":
                    endpoint = "/messenger";
                    break;
                default:
                    return "Error: Invalid channel - " + channel;
            }
            
            // Create API request
            ApiRequest request = ApiRequest.builder()
                .method("POST")
                .url(apiUrl + endpoint)
                .body("{\"message\":\"" + message + "\",\"recipient\":\"" + getRecipient(channel) + "\"}")
                .accessToken(apiToken)
                .build();
            
            // Call the API
            ApiResponse response = notificationApiClient.callApi(request);
            
            if (response.isSuccess()) {
                return "Success: " + response.getMessage();
            } else {
                return "Error: " + response.getMessage();
            }
        } catch (Exception e) {
            return "Failed to send notification: " + e.getMessage();
        }
    }
    
    /**
     * Get notification status by ID
     * @param messageId notification message ID
     * @return status information
     */
    @McpTool(name = "get-notification-status", description = "Get notification status by ID")
    public String getNotificationStatus(String messageId) {
        try {
            if (messageId == null || messageId.trim().isEmpty()) {
                return "Error: Message ID is required";
            }
            
            // For demonstration purposes, we'll return a mock response
            // In real implementation, this would call the actual API
            return "Status: Completed - ID: " + messageId;
        } catch (Exception e) {
            return "Failed to get notification status: " + e.getMessage();
        }
    }
    
    /**
     * List all available notification channels
     * @return list of supported channels
     */
    @McpTool(name = "get-available-channels", description = "List all available notification channels")
    public String getAvailableChannels() {
        return "Supported channels: sms, email, messenger";
    }
    
    /**
     * Helper method to get recipient based on channel
     * This is a placeholder - in real implementation, this would be more complex
     */
    private String getRecipient(String channel) {
        switch (channel.toLowerCase()) {
            case "sms": return "+821012345678"; // Example phone number
            case "email": return "example@domain.com"; // Example email
            case "messenger": return "messenger_user_id"; // Example user ID
            default: return "";
        }
    }
}