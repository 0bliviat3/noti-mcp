package com.example.notimcp.client;

import com.example.notimcp.model.ApiRequest;
import com.example.notimcp.model.ApiResponse;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class NotificationApiClient {

    @Autowired
    private CloseableHttpClient httpClient;

    public ApiResponse callApi(ApiRequest request) {
        try {
            switch (request.getMethod().toUpperCase()) {
                case "GET":
                    return executeGet(request);
                case "POST":
                    return executePost(request);
                case "PUT":
                    return executePut(request);
                case "DELETE":
                    return executeDelete(request);
                default:
                    return ApiResponse.builder()
                            .success(false)
                            .message("Unsupported HTTP method: " + request.getMethod())
                            .build();
            }
        } catch (Exception e) {
            return ApiResponse.builder()
                    .success(false)
                    .message("API call failed: " + e.getMessage())
                    .build();
        }
    }

    private ApiResponse executeGet(ApiRequest request) throws IOException {
        HttpGet httpGet = new HttpGet(request.getUrl());
        if (request.getAccessToken() != null && !request.getAccessToken().isEmpty()) {
            httpGet.setHeader("Authorization", "Bearer " + request.getAccessToken());
        }
        
        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            String responseBody = EntityUtils.toString(response.getEntity());
            return ApiResponse.builder()
                    .success(true)
                    .message("GET request successful")
                    .data(responseBody)
                    .build();
        } catch (Exception e) {
            throw new IOException("Failed to execute GET request: " + e.getMessage(), e);
        }
    }

    private ApiResponse executePost(ApiRequest request) throws IOException {
        HttpPost httpPost = new HttpPost(request.getUrl());
        if (request.getAccessToken() != null && !request.getAccessToken().isEmpty()) {
            httpPost.setHeader("Authorization", "Bearer " + request.getAccessToken());
        }
        if (request.getBody() != null) {
            StringEntity entity = new StringEntity(request.getBody(), ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
        }
        
        try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
            String responseBody = EntityUtils.toString(response.getEntity());
            return ApiResponse.builder()
                    .success(true)
                    .message("POST request successful")
                    .data(responseBody)
                    .build();
        } catch (Exception e) {
            throw new IOException("Failed to execute POST request: " + e.getMessage(), e);
        }
    }

    private ApiResponse executePut(ApiRequest request) throws IOException {
        HttpPut httpPut = new HttpPut(request.getUrl());
        if (request.getAccessToken() != null && !request.getAccessToken().isEmpty()) {
            httpPut.setHeader("Authorization", "Bearer " + request.getAccessToken());
        }
        if (request.getBody() != null) {
            StringEntity entity = new StringEntity(request.getBody(), ContentType.APPLICATION_JSON);
            httpPut.setEntity(entity);
        }
        
        try (CloseableHttpResponse response = httpClient.execute(httpPut)) {
            String responseBody = EntityUtils.toString(response.getEntity());
            return ApiResponse.builder()
                    .success(true)
                    .message("PUT request successful")
                    .data(responseBody)
                    .build();
        } catch (Exception e) {
            throw new IOException("Failed to execute PUT request: " + e.getMessage(), e);
        }
    }

    private ApiResponse executeDelete(ApiRequest request) throws IOException {
        HttpDelete httpDelete = new HttpDelete(request.getUrl());
        if (request.getAccessToken() != null && !request.getAccessToken().isEmpty()) {
            httpDelete.setHeader("Authorization", "Bearer " + request.getAccessToken());
        }
        
        try (CloseableHttpResponse response = httpClient.execute(httpDelete)) {
            String responseBody = EntityUtils.toString(response.getEntity());
            return ApiResponse.builder()
                    .success(true)
                    .message("DELETE request successful")
                    .data(responseBody)
                    .build();
        } catch (Exception e) {
            throw new IOException("Failed to execute DELETE request: " + e.getMessage(), e);
        }
    }
}