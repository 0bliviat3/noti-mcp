package com.example.notimcp.tool;

import com.modelcontextprotocol.McpTool;
import com.modelcontextprotocol.McpParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * MCP Notification Tool for Model Context Protocol compliance
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
     * @param message notification message
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
     * @param messageId notification message ID
     * @return status information
     */
    @McpTool
    public String getNotificationStatus(@McpParam("messageId") String messageId) {
        return "Status: Completed - ID: " + messageId;
    }
}