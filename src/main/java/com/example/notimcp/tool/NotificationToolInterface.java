package com.example.notimcp.tool;

import org.springframework.stereotype.Component;

/**
 * Notification Tool Interface for MCP compatibility
 */
public interface NotificationToolInterface {
    
    /**
     * Send notification via specified channel
     * @param message notification message
     * @param channel notification channel (sms, email, messenger)
     * @return send result
     */
    String sendNotification(String message, String channel);
}