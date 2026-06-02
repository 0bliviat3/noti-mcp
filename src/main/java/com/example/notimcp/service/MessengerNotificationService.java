package com.example.notimcp.service;

import org.springframework.stereotype.Service;

/**
 * Messenger 알림 서비스
 * 메신저 전송 관련 로직 구현
 */
@Service
public class MessengerNotificationService {
    
    /**
     * 메신저 전송
     * @param message 메신저 메시지 내용
     * @param recipient 수신자 메신저 ID
     * @return 전송 결과
     */
    public String sendMessenger(String message, String recipient) {
        // 실제 메신저 전송 로직 (예시)
        return "Messenger sent to " + recipient + ": \"" + message + "\"";
    }
    
    /**
     * 메신저 전송 상태 확인
     * @param messageId 메시지 ID
     * @return 전송 상태
     */
    public String getMessengerStatus(String messageId) {
        return "Messenger Status: Completed - ID: " + messageId;
    }
}