package com.example.notimcp.tool;

import com.modelcontextprotocol.McpTool;
import com.modelcontextprotocol.McpParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Email 알림 Tool
 * 이메일 전송 기능 제공
 */
@Component
public class EmailNotificationTool {
    
    @Autowired
    private EmailNotificationService emailService;
    
    /**
     * 이메일 전송
     * @param message 이메일 메시지 내용
     * @param recipient 수신자 이메일 주소
     * @param subject 이메일 제목
     * @return 전송 결과
     */
    @McpTool
    public String sendEmail(
        @McpParam("message") String message,
        @McpParam("recipient") String recipient,
        @McpParam("subject") String subject) {
        
        return emailService.sendEmail(message, recipient, subject);
    }
    
    /**
     * 이메일 전송 상태 확인
     * @param messageId 메시지 ID
     * @return 전송 상태
     */
    @McpTool
    public String getEmailStatus(@McpParam("messageId") String messageId) {
        return emailService.getEmailStatus(messageId);
    }
}