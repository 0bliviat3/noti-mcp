package com.example.notimcp.service;

import com.example.notimcp.client.NotificationApiClient;
import com.example.notimcp.model.ApiRequest;
import com.example.notimcp.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

    @Autowired
    private NotificationApiClient notificationApiClient;

    public ApiResponse sendNotification(String url, String accessToken, String message) {
        ApiRequest request = ApiRequest.builder()
                .url(url)
                .method("POST")
                .body(message)
                .accessToken(accessToken)
                .build();
        
        return notificationApiClient.callApi(request);
    }

    public ApiResponse getNotificationInfo(String url, String accessToken) {
        ApiRequest request = ApiRequest.builder()
                .url(url)
                .method("GET")
                .accessToken(accessToken)
                .build();
        
        return notificationApiClient.callApi(request);
    }
}