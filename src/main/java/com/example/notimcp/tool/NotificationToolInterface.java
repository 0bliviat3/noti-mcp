package com.example.notimcp.tool;

/**
 * Interface for MCP Notification Tools
 * Defines the contract for notification sending tools
 */
public interface NotificationToolInterface {
    
    /**
     * Send a notification via various channels
     * @param message The notification message to send
     * @param channel The notification channel (sms, email, messenger)
     * @return Confirmation message
     */
    String sendNotification(String message, String channel);
    
    /**
     * Get notification status by ID
     * @param id The notification ID
     * @return Status information
     */
    String getNotificationStatus(String id);
    
    /**
     * Get available notification channels
     * @return List of supported channels
     */
    String getAvailableChannels();
}