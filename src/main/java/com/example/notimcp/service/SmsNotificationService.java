package com.example.notimcp.service;

import org.springframework.stereotype.Service;

/**
 * SMS 알림 서비스
 * SMS 전송 관련 로직 구현
 */
@Service
public class SmsNotificationService {
    
    /**
     * SMS 전송
     * @param message SMS 메시지 내용
     * @param recipient 수신자 전화번호
     * @return 전송 결과
     */
    public String sendSms(String message, String recipient) {
        // 실제 SMS API 호출 로직 (예시)
        return "SMS sent to " + recipient + ": \"" + message + "\"";
    }
    
    /**
     * SMS 전송 상태 확인
     * @param messageId 메시지 ID
     * @return 전송 상태
     */
    public String getSmsStatus(String messageId) {
        return "SMS Status: Completed - ID: " + messageId;
    }
}