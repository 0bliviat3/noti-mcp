package com.example.notimcp.tool;

import com.modelcontextprotocol.McpTool;
import com.modelcontextprotocol.McpParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * SMS 알림 Tool
 * SMS 전송 기능 제공
 */
@Component
public class SmsNotificationTool {
    
    @Autowired
    private SmsNotificationService smsService;
    
    /**
     * SMS 전송
     * @param message SMS 메시지 내용
     * @param recipient 수신자 전화번호
     * @return 전송 결과
     */
    @McpTool
    public String sendSms(
        @McpParam("message") String message,
        @McpParam("recipient") String recipient) {
        
        return smsService.sendSms(message, recipient);
    }
    
    /**
     * SMS 전송 상태 확인
     * @param messageId 메시지 ID
     * @return 전송 상태
     */
    @McpTool
    public String getSmsStatus(@McpParam("messageId") String messageId) {
        return smsService.getSmsStatus(messageId);
    }
}