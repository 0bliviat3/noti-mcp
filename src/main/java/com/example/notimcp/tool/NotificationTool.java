package com.example.notimcp.tool;

import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * MCP Notification Tool using Spring AI MCP Annotations
 * This implements the MCP protocol with proper tool annotations
 */
@Component
public class NotificationTool {
    
    @Autowired
    private com.example.notimcp.service.SmsNotificationService smsService;
    
    @Autowired
    private com.example.notimcp.service.EmailNotificationService emailService;
    
    @Autowired
    private com.example.notimcp.service.MessengerNotificationService messengerService;
    
    /**
     * Send notification via specified channel
     * This method is annotated as an MCP tool
     * 
     * @param message notification message content
     * @param channel notification channel (sms, email, messenger)
     * @return send result
     */
    @McpTool
    public String sendNotification(
        @McpParam("message") String message,
        @McpParam("channel") String channel) {
        
        switch (channel.toLowerCase()) {
            case "sms":
                return smsService.sendSms(message, "default");
            case "email":
                return emailService.sendEmail(message, "default@example.com", "Notification");
            case "messenger":
                return messengerService.sendMessenger(message, "default_user");
            default:
                return "Error: Invalid channel - " + channel;
        }
    }
    
    /**
     * Get notification status by ID
     * This method is also registered as an MCP tool
     * 
     * @param messageId notification message ID
     * @return status information
     */
    @McpTool
    public String getNotificationStatus(@McpParam("messageId") String messageId) {
        return "Status: Completed - ID: " + messageId;
    }
    
    /**
     * List all available notification channels
     * This method provides channel information to MCP clients
     * 
     * @return list of supported channels
     */
    @McpTool
    public String getAvailableChannels() {
        return "Supported channels: sms, email, messenger";
    }
}