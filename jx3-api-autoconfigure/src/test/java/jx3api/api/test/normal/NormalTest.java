package jx3api.api.test.normal;

import jx3api.api.config.ApiProperties;
import jx3api.api.http.ApiService;
import jx3api.api.http.BaseResult;
import jx3api.api.http.data.*;
import jx3api.api.ws.action.WsActionDataManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    private String ticket = "";
    private ApiService apiService;

    @BeforeEach
    void initApiProperties() {
        ApiProperties apiProperties = new ApiProperties();
        apiProperties.setApiToken("123");
        apiProperties.setApiUrl("https://www.jx3api.com");
        apiService = new ApiService(apiProperties);
    }

    @Test
    void activeCalendar() {
        BaseResult<ActiveCurrentData> activeCurrentData = apiService.activeCalendar("长安城", 0);
        Assert.notNull(activeCurrentData, "日常信息-数据 测试失败");
    }

    @Test
    void activeListCalendar() {
        BaseResult<ActiveCalendarData> activeCurrentData = apiService.activeListCalendar("长安城", 7);
        Assert.notNull(activeCurrentData, "日常信息-数据 测试失败");
    }

    @Test
    void activeCelebrities() {
        BaseResult<List<ActiveCelebritiesData>> result = apiService.activeCelebrities(3);
        assertDataResult(result);
    }

    @Test
    void examAnswer() {
        BaseResult<List<ExamAnswerData>> baseResult = apiService.examAnswer("古琴有几根弦", 10);
        Assert.notNull(baseResult, "科举试题 测试失败");
    }

    // @Test
    // 花价接口报废了，暂时先不测试
    void hoeFlower() {
        BaseResult<Map<String, Object>> baseResult = apiService.homeFlower("梦江南", "绣球花", "九寨沟·镜海");
        Assert.notNull(baseResult, "测试失败");
    }

    @Test
    void homeFurniture() {
        BaseResult<HomeFurnitureData> baseResult = apiService.homeFurniture("龙门香梦");
        Assert.notNull(baseResult, "测试失败");
    }

    private void assertDataResult(BaseResult o) {
        Assert.notNull(o, "测试失败");
    }

    private void assertViewResult(BaseResult o) {
        Assert.isTrue(o != null && o.getData() != null && ((String) o.getData()).startsWith("http"), "测试失败");
    }

    @Test
    void homeTravel() {
        BaseResult<List<HomeTravelData>> baseResult = apiService.homeTravel("七秀");
        assertDataResult(baseResult);
    }

    @Test
    void schoolMatrix() {
        BaseResult<SchoolMatrixData> result = apiService.schoolMatrix("冰心诀");
        assertDataResult(result);
    }

    @Test
    void serverMaster() {
        BaseResult<ServerMasterData> result = apiService.serverMaster("双梦镇");
        assertDataResult(result);
    }

    @Test
    void serverCheck() {
        BaseResult<ServerCheckData> result = apiService.serverCheck("长安城");
        assertDataResult(result);
    }

    @Test
    void serverStatus() {
        BaseResult<ServerStatusData> result = apiService.serverStatus("长安城");
        assertDataResult(result);
    }

    @Test
    void webNewsAllnews() {
        BaseResult<List<WebNewsAllNewsData>> result = apiService.newsAllNews(2);
        assertDataResult(result);
    }

    @Test
    void newsAnnounce() {
        BaseResult<List<WebNewsAnnounceData>> result = apiService.newsAnnounce(2);
        assertDataResult(result);
    }

    @Test
    void schoolToxic() {
        BaseResult<List<SchoolToxicData>> result = apiService.schoolToxic("冰心诀");
        assertDataResult(result);
    }

    @Test
    void roleTeamCdList() {
        BaseResult<RoleTeamCdListData> result = apiService.roleTeamCdList("唯我独尊", "夜温言@长安城", ticket);
        assertDataResult(result);
    }

    @Test
    void fraudDetail(){
        BaseResult<List<FraudDetailData>>  result =  apiService.fraudDetail(123465L);
        assertDataResult(result);
    }

    @Test
    void tiebaItemRecord(){
        BaseResult<List<TiebaItemRecordsData>>  result = apiService.tiebaItemRecords("狐金","长安城",1);
        assertDataResult(result);
    }

    @Test
    void roleAttribute(){
        BaseResult<RoleAttributeData> roleAttributeDataBaseResult = apiService.roleAttribute("唯我独尊", "夜温言@长安城",ticket);
        assertDataResult(roleAttributeDataBaseResult);
    }

    @Test
    void activeMonster(){
        BaseResult<ActiveMonsterData> baseResult =  apiService.activeMonster();
        assertDataResult(baseResult);
    }
    @Test
    void horseRecords(){
        BaseResult<List<HorseRecordsData>>  result = apiService.horseRecords("乾坤一掷");
        assertDataResult(result);
    }
}
