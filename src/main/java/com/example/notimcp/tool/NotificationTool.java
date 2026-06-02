package com.example.notimcp.tool;

import org.springframework.stereotype.Component;

/**
 * MCP Notification Tool Implementation
 * This represents a tool that can send notifications via various channels
 */
@Component
public class NotificationTool implements NotificationToolInterface {
    
    /**
     * Send a notification via various channels
     * @param message The notification message to send
     * @param channel The notification channel (sms, email, messenger)
     * @return Confirmation message
     */
    @Override
    public String sendNotification(String message, String channel) {
        // Validate channel parameter
        if (!isValidChannel(channel)) {
            return "Error: Invalid channel. Supported channels are: sms, email, messenger";
        }
        
        // Simulate notification sending
        return "Notification sent via " + channel + ": \"" + message + "\"";
    }
    
    /**
     * Get notification status by ID
     * @param id The notification ID
     * @return Status information
     */
    @Override
    public String getNotificationStatus(String id) {
        return "Status: completed - Notification ID: " + id;
    }
    
    /**
     * Get available notification channels
     * @return List of supported channels
     */
    @Override
    public String getAvailableChannels() {
        return "Available channels: sms, email, messenger";
    }
    
    /**
     * Validate notification channel
     */
    private boolean isValidChannel(String channel) {
        return "sms".equalsIgnoreCase(channel) || 
               "email".equalsIgnoreCase(channel) || 
               "messenger".equalsIgnoreCase(channel);
    }
}