package jx3api.api.test.normal;

import jx3api.api.ws.action.WsActionDataManager;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 普通测试类
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
}
