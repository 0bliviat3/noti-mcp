package com.example.notimcp.service;

import org.springframework.stereotype.Service;

/**
 * Email 알림 서비스
 * 이메일 전송 관련 로직 구현
 */
@Service
public class EmailNotificationService {
    
    /**
     * 이메일 전송
     * @param message 이메일 메시지 내용
     * @param recipient 수신자 이메일 주소
     * @param subject 이메일 제목
     * @return 전송 결과
     */
    public String sendEmail(String message, String recipient, String subject) {
        // 실제 이메일 전송 로직 (예시)
        return "Email sent to " + recipient + " (" + subject + "): \"" + message + "\"";
    }
    
    /**
     * 이메일 전송 상태 확인
     * @param messageId 메시지 ID
     * @return 전송 상태
     */
    public String getEmailStatus(String messageId) {
        return "Email Status: Completed - ID: " + messageId;
    }
}