package jx3api.api.test.normal;

import jx3api.api.config.ApiProperties;
import jx3api.api.http.ApiService;
import jx3api.api.http.data.ActiveCurrentData;
import jx3api.api.ws.action.WsActionDataManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 普通测试类
 *
 * @author Grafie
 * @since 1.0.0
 */
public class NormalTest {
    @Test
    void wsActionManager() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        WsActionDataManager wsActionDataManager = new WsActionDataManager();
        List<String> backPackageNames = new ArrayList<>();
        backPackageNames.add("jx3api.api.ws");
        wsActionDataManager.init(backPackageNames);
        WsActionDataManager.getWsDataByAction(1001);
    }

    private ApiService apiService;

    @BeforeEach
    void initApiProperties() {
        ApiProperties apiProperties = new ApiProperties();
        apiProperties.setApiToken("123");
        apiProperties.setApiUrl("https://api.jx3api.com/");
        apiService = new ApiService(apiProperties);
    }

    @Test
    void activeCurrent() {
        ActiveCurrentData activeCurrentData = apiService.activeCurrent("长安城", 0);
        Assert.notNull(activeCurrentData,"日常信息-数据 测试失败");
        String url = apiService.activeCurrentView("长安城", 0,"神奇",1);
        Assert.isTrue(url !=null && url.startsWith("http"),"日常信息-图片服务 测试失败");
    }
}
