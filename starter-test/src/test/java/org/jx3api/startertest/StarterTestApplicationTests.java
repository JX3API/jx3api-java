package org.jx3api.startertest;

import jakarta.annotation.Resource;
import jx3api.api.config.EnableJX3Api;
import jx3api.api.config.JX3ApiHttpAutoConfiguration;
import jx3api.api.ws.CustomWebSocketHandler;
import jx3api.api.ws.IWsDataPushService;
import jx3api.api.ws.WebSocketClientInitializer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@SpringBootTest

@EnableJX3Api
@TestPropertySource(locations = "classpath:test.properties")
class StarterTestApplicationTests {
    @Autowired
    private ApplicationContext applicationContext;
    @Resource
    private WebSocketClientInitializer webSocketClientInitializer;
    @Resource
    private JX3ApiHttpAutoConfiguration jx3ApiHttpAutoConfiguration;
    @Resource
    private IWsDataPushService iWsDataPushService;

    @Test
    void contextLoads() throws Exception {
        // 创建模拟的 WebSocketSession
        WebSocketSession mockSession = createMockWebSocketSession();
        CustomWebSocketHandler customWebSocketHandler = new CustomWebSocketHandler(webSocketClientInitializer,
                iWsDataPushService);
        // 在 mockSession 上模拟收到一条消息
        TextMessage message = new TextMessage("{\n" +
                "  \"action\": 1001,\n" +
                "  \"data\": {\n" +
                "    \"zone\": \"电信五区\",\n" +
                "    \"server\": \"斗转星移\",\n" +
                "    \"name\": \"莫问归时@梦 江南\",\n" +
                "    \"event\": \"惜往日\",\n" +
                "    \"level\": 1,\n" +
                "    \"time\": 1640438124\n" +
                "  }\n" +
                "}");
        customWebSocketHandler.handleMessage(mockSession, message);
    }

    private WebSocketSession createMockWebSocketSession() {
        // 创建模拟的 WebSocketSession
        return Mockito.mock(WebSocketSession.class);
    }
}
