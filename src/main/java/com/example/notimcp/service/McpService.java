package com.example.notimcp.service;

import com.example.notimcp.client.NotificationApiClient;
import com.example.notimcp.model.ApiRequest;
import com.example.notimcp.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class McpService {

    @Autowired
    private NotificationApiClient notificationApiClient;

    @Value("${noti.api.url}")
    private String apiUrl;

    @Value("${noti.api.token}")
    private String accessToken;

    public String sendNotification(String message) {
        try {
            ApiRequest request = ApiRequest.builder()
                    .url(apiUrl)
                    .method("POST")
                    .body(message)
                    .accessToken(accessToken)
                    .build();
            
            ApiResponse response = notificationApiClient.callApi(request);
            if (response.isSuccess()) {
                return "Notification sent successfully: " + response.getMessage();
            } else {
                return "Failed to send notification: " + response.getMessage();
            }
        } catch (Exception e) {
            return "Error sending notification: " + e.getMessage();
        }
    }

    public String getNotification(String id) {
        try {
            // This is a placeholder - in real implementation you'd need to 
            // implement actual GET request for specific notification
            return "Retrieved notification with ID: " + id;
        } catch (Exception e) {
            return "Error retrieving notification: " + e.getMessage();
        }
    }
}