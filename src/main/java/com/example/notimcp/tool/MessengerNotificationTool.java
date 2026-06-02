package com.example.notimcp.tool;

import com.modelcontextprotocol.McpTool;
import com.modelcontextprotocol.McpParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Messenger 알림 Tool
 * 메신저 전송 기능 제공
 */
@Component
public class MessengerNotificationTool {
    
    @Autowired
    private MessengerNotificationService messengerService;
    
    /**
     * 메신저 전송
     * @param message 메신저 메시지 내용
     * @param recipient 수신자 메신저 ID
     * @return 전송 결과
     */
    @McpTool
    public String sendMessenger(
        @McpParam("message") String message,
        @McpParam("recipient") String recipient) {
        
        return messengerService.sendMessenger(message, recipient);
    }
    
    /**
     * 메신저 전송 상태 확인
     * @param messageId 메시지 ID
     * @return 전송 상태
     */
    @McpTool
    public String getMessengerStatus(@McpParam("messageId") String messageId) {
        return messengerService.getMessengerStatus(messageId);
    }
}