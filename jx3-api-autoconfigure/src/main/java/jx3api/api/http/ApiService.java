package jx3api.api.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import jx3api.api.config.ApiProperties;
import jx3api.api.http.data.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * api 服务类
 *
 * @author Grafie
 * @since 1.0.0
 */
@SuppressWarnings("unchecked")
public class ApiService {
    private static final Logger logger = LoggerFactory.getLogger(ApiService.class);
    private final WebClient webClient;
    /**
     * 相关api参数
     */
    private ApiProperties apiProperties;

    public ApiService(ApiProperties apiProperties) {
        this.apiProperties = apiProperties;
        this.webClient = WebClient.builder()
                .baseUrl(apiProperties.getApiUrl())
                .defaultHeader("token", apiProperties.getApiToken())
                .defaultHeader(HttpHeaders.USER_AGENT, "Nonebot2-jx3-bot")
                .build();
    }

    private void addViewParam(MultiValueMap<String, Object> params, String robot, Integer cache, Integer scale) {
        if (cache == null) {
            params.add("cache", 1);
        }
        if (scale == null) {
            params.add("scale", 1);
        }
        if (!(robot == null || robot.isBlank())) {
            params.add("robot", robot);
        }
    }

    /*
     * free api
     * */

    /**
     * active_current 日常信息
     * 今天、明天、后天、日常任务。
     * 只有 星期三、星期五、星期六、星期日 才有美人画图，星期三、星期五 才有世界首领，若非活动时间不返回相关键与值。
     *
     * @param server (str, optional): 区服名称，查找该区服的记录。
     * @param num    (int, optional): 预测时间，预测指定时间的日常，默认值: ``0`` 为当天，``1`` 为明天，以此类推。
     * @return ActiveCalendarData
     */
    public ActiveCurrentData activeCurrent(String server, int num) {
        MethodEnum methodEnum = MethodEnum.DATA_ACTIVE_CURRENT;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        params.add("num", num);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * activeCurrent 的图片服务器
     *
     * @param server 区服名称，查找该区服的记录。
     * @param num    预测时间，预测指定时间的日常，默认值: ``0`` 为当天，``1`` 为明天，以此类推。
     * @param robot  描述文本，一般设置机器人名称，
     * @param cache  设置缓存，可有效提高响应速度，默认值：1为开启，0为关闭。
     * @return 图片地址
     */
    public String activeCurrentView(String server, int num, String robot, Integer cache) {
        MethodEnum methodEnum = MethodEnum.VIEW_ACTIVE_CURRENT;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        params.add("num", num);
        addViewParam(params, robot, cache, null);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * @see ApiService#activeCurrentView(String, int, String, Integer)
     */
    public String activeCurrentView(String server, int num) {
        return activeCurrentView(server, num, null, null);
    }

    /**
     * 说明:
     * 搜索科举试题的答案
     *
     * @param match 科举题目，搜索目标题目答案
     * @param limit 单页数量，设置单页返回的数量；默认值 : 10。
     * @return ExamAnswerData
     */
    public ExamAnswerData examAnswer(String match, int limit) {
        MethodEnum methodEnum = MethodEnum.DATA_EXAM_ANSWER;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("match", match);
        params.add("limit", limit);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    public HomeFlowerData homeFlower(String server, String flower, String map) {
        MethodEnum methodEnum = MethodEnum.DATA_HOME_FLOWER;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        params.add("flower", flower);
        params.add("map", map);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 家园鲜花最高价格线路
     *
     * @param server 区服名称，查找目标区服鲜花最高价格线路，
     * @param robot  描述文本，一般设置机器人名称，
     * @param cache  设置缓存，可有效提高响应速度，默认值：1为开启，0为关闭。
     * @param scale  网页规模，设置网页分辨率，可选范围：[1/2]，默认值：1，设置的值越大图片体积也会越大，
     * @return 图片地址
     */
    public String homeFlowerView(String server, String robot, Integer cache, Integer scale) {
        MethodEnum methodEnum = MethodEnum.VIEW_HOME_FLOWER;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        addViewParam(params, robot, cache, scale);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * @see ApiService#homeFlowerView(String, String, Integer, Integer)
     */
    public String homeFlowerView(String server) {
        return homeFlowerView(server, null, null, null);
    }

    /**
     * 家园装饰
     *
     * @param name 装饰名称，查找装饰的详细数据。
     * @return HomeFurnitureData
     */
    public HomeFurnitureData homeFurniture(String name) {
        MethodEnum methodEnum = MethodEnum.DATA_HOME_FURNITURE;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 器物图谱
     *
     * @param name 地图名称，查找目标地图产出家具。
     * @return HomeTravelData
     */
    public HomeTravelData homeTravel(String name) {
        MethodEnum methodEnum = MethodEnum.DATA_HOME_TRAVEL;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }


    /**
     * 阵法效果
     *
     * @param name 心法名称，查找目标心法的阵法效果。
     * @return SchoolMatrixData
     */
    public SchoolMatrixData schoolMatrix(String name) {
        MethodEnum methodEnum = MethodEnum.DATA_SCHOOL_MATRIX;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 搜索区服
     *
     * @param name 区服别名，查找目标简称的服务器组。
     * @return ServerMasterData
     */
    public ServerMasterData serverMaster(String name) {
        MethodEnum methodEnum = MethodEnum.DATA_SERVER_MASTER;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 开服检查
     *
     * @param server 区服名称，查找目标区服的状态。
     * @return ServerCheckData
     */
    public ServerCheckData serverCheck(String server) {
        MethodEnum methodEnum = MethodEnum.DATA_SERVER_CHECK;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 查看状态
     *
     * @param server 区服名称，查找目标区服的状态。
     * @return ServerStatusData
     */
    public ServerStatusData serverStatus(String server) {
        MethodEnum methodEnum = MethodEnum.DATA_SERVER_STATUS;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 新闻资讯
     *
     * @param limit 单页数量，单页返回的数量，默认值 : 10。
     * @return WebNewsAllNewsData
     */
    public List<WebNewsAllNewsData> newsAllNews(Integer limit) {
        MethodEnum methodEnum = MethodEnum.DATA_WEB_NEWS_ALLNEWS;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        if (limit == null) {
            limit = 10;
        }
        params.add("limit", limit);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 维护公告
     *
     * @param limit 单页数量，单页返回的数量，默认值 : 10。
     * @return WebNewsAnnounceData
     */
    public List<WebNewsAnnounceData> newsAnnounce(Integer limit) {
        MethodEnum methodEnum = MethodEnum.DATA_WEB_NEWS_ANNOUNCE;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        if (limit == null) {
            limit = 10;
        }
        params.add("limit", limit);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 维护公告
     *
     * @param scale 网页规模，设置网页分辨率，可选范围：[1/2]，默认值：1，设置的值越大图片体积也会越大，
     * @param robot 描述文本，一般设置机器人名称，
     * @param cache 设置缓存，可有效提高响应速度，默认值：1为开启，0为关闭。
     * @return
     */
    public String newsAnnounceView(Integer scale, String robot, Integer cache) {
        MethodEnum methodEnum = MethodEnum.VIEW_WEB_NEWS_ANNOUNCE;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        addViewParam(params, robot, cache, scale);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * @see ApiService#newsAnnounceView(Integer, String, Integer)
     */
    public String newsAnnounceView() {
        return newsAnnounceView(1, null, 1);
    }

    /**
     * 撩人骚话
     *
     * @return SaohuaRandomData
     */
    public SaohuaRandomData saohuaRandom() {
        MethodEnum methodEnum = MethodEnum.DATA_SAOHUA_RANDOM;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /*
     * VIP I API
     */

    /**
     * 活动日历
     *
     * @param num 预测时间，预测指定时间内的日常，默认值 : 15。
     * @return ActiveCalendarData
     */
    public ActiveCalendarData activeCalendar(Integer num) {
        MethodEnum methodEnum = MethodEnum.DATA_ACTIVE_CALENDAR;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("num", num);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 活动日历 图片服务
     *
     * @param scale 网页规模，设置网页分辨率，可选：[1/2]，默认值：1，设置的值越大图片体积也会越大，
     * @param num   预测时间，预测指定时间内的日常，默认值 : 15，
     * @param cache 设置缓存，可有效提高响应速度，默认值：1为开启，0为关闭。
     * @param robot 描述文本，一般设置机器人名称，
     * @return 图片地址
     */
    public String activeCalendarView(Integer scale, Integer num, Integer cache, String robot) {
        MethodEnum methodEnum = MethodEnum.VIEW_ACTIVE_CALENDAR;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("num", num);
        addViewParam(params, robot, cache, scale);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * @see ApiService#activeCalendarView(Integer, Integer, Integer, String)
     */
    public String activeCalendarView(Integer num) {
        return activeCalendarView(1, num, 1, null);
    }

    /**
     * @see ApiService#activeCalendarView(Integer, Integer, Integer, String)
     */
    public String activeCalendarView() {
        return activeCalendarView(15);
    }

    /**
     * 金币比例
     *
     * @param server 区服名称，查找目标区服的金价比例信息，
     * @param limit  单页数量，单页返回的数量，默认值 : 10
     * @return TradeDemonData
     */
    public TradeDemonData tradeDemon(String server, Integer limit) {
        MethodEnum methodEnum = MethodEnum.DATA_TRADE_DEMON;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        if (limit == null) {
            limit = 10;
        }
        params.add("limit", limit);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 金币比例-图片服务
     *
     * @param server 区服名称，查找目标区服的金价比例信息，
     * @param scale  网页规模，设置网页分辨率，可选范围：[1/2]，默认值：1，设置的值越大图片体积也会越大，
     * @param cache  设置缓存，可有效提高响应速度，默认值：1为开启，0为关闭。
     * @param robot  描述文本，一般设置机器人名称，
     * @return 图片地址
     */
    public String tradeDemonView(String server, Integer scale, Integer cache, String robot) {
        MethodEnum methodEnum = MethodEnum.VIEW_TRADE_DEMON;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        addViewParam(params, robot, cache, scale);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * @see ApiService#tradeDemonView(String, Integer, Integer, String)
     */
    public String tradeDemonView(String server) {
        return tradeDemonView(server, 1, 1, null);
    }

    /**
     * 金币比例-图片服务-全服
     *
     * @param robot 描述文本，一般设置机器人名称，
     * @param scale 网页规模，设置网页分辨率，可选范围：[1/2]，默认值：1，设置的值越大图片体积也会越大，
     * @param cache 设置缓存，可有效提高响应速度，默认值：1为开启，0为关闭。
     * @return 图片地址
     */
    public String tradeServerDemonView(String robot, Integer scale, Integer cache) {
        MethodEnum methodEnum = MethodEnum.VIEW_TRADE_SERVER_DEMON;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        addViewParam(params, robot, cache, scale);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 行侠事件
     *
     * @return ActiveCelebritiesData
     */
    public ActiveCelebritiesData activeCelebrities() {
        MethodEnum methodEnum = MethodEnum.DATA_ACTIVE_CELEBRITIES;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 奇遇记录
     *
     * @param server 区服名称，查找目标区服的数据，
     * @param name   角色名称，筛选角色记录，
     * @param ticket 推栏标识，检查并补充奇遇的完整性，
     * @param filter 是否过滤，过滤无效的奇遇，需要提供有效的ticket，默认值 : 1为开启，0为关闭，
     * @return LuckAdventureData
     */
    public LuckAdventureData luckAdventure(String server, String name, String ticket, Integer filter) {
        MethodEnum methodEnum = MethodEnum.DATA_LUCK_ADVENTURE;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        params.add("name", name);
        params.add("ticket", ticket);
        params.add("filter", filter);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 奇遇记录 - 图片服务
     *
     * @param scale  网页规模，设置网页分辨率，可选范围：[1/2]，默认值：1，设置的值越大图片体积也会越大
     * @param server 区服名称，查找目标区服的数据，
     * @param name   角色名称，筛选角色记录，
     * @param filter 是否过滤，过滤无效的奇遇，需要提供有效的ticket，默认值 : 1为开启，0为关闭，
     * @param robot  描述文本，一般设置机器人名称，
     * @param ticket 推栏标识，检查并补充奇遇的完整性，
     * @return 图片地址
     */
    public String luckAdventureView(Integer scale, String server, String name, Integer filter, String robot, String ticket) {
        MethodEnum methodEnum = MethodEnum.VIEW_LUCK_ADVENTURE;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        params.add("name", name);
        params.add("ticket", ticket);
        params.add("filter", filter);
        params.add("scale", scale);
        params.add("robot", robot);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * @see ApiService#luckAdventureView(Integer, String, String, Integer, String, String)
     */
    public String luckAdventureView(String server, String name, String ticket) {
        return luckAdventureView(1, server, name, 1, null, ticket);
    }

    /**
     * 奇遇统计
     *
     * @param server 区服名称，查找目标区服的奇遇记录，
     * @param name   奇遇名称，筛选奇遇记录，
     * @param limit  单页数量，单页返回的数量，默认值 : 20，
     * @return 奇遇统计
     */
    public List<LuckStatisticalData> luckStatistical(String server, String name, Integer limit) {
        MethodEnum methodEnum = MethodEnum.DATA_LUCK_STATISTICAL;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        params.add("name", name);
        params.add("limit", limit);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 奇遇统计
     *
     * @param scale  网页规模，设置网页分辨率，可选范围：[1/2]，默认值：1，设置的值越大图片体积也会越大，
     * @param server 区服名称，查找目标区服的奇遇记录，
     * @param name   奇遇名称，筛选奇遇记录，
     * @param robot  描述文本，一般设置机器人名称，
     * @return 图片地址
     */
    public String luckStatisticalView(Integer scale, String server, String name, String robot) {
        MethodEnum methodEnum = MethodEnum.VIEW_LUCK_STATISTICAL;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        params.add("name", name);
        params.add("scale", scale);
        params.add("robot", robot);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * @see ApiService#luckStatisticalView(Integer, String, String, String)
     */
    public String luckStatisticalView(String server, String name, String robot) {
        return luckStatisticalView(1, server, name, robot);
    }


    /**
     * 奇遇汇总
     *
     * @param server 区服名称，查找目标区服的记录，
     * @param num    汇总时间，汇总指定天数内的奇遇记录，默认值 : 7，
     * @return LuckCollectData List
     */
    public List<LuckCollectData> luckCollect(String server, Integer num) {
        MethodEnum methodEnum = MethodEnum.DATA_LUCK_COLLECT;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        params.add("num", num);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 奇遇汇总
     *
     * @param scale  网页规模，设置网页分辨率，可选范围：[1/2]，默认值：1，设置的值越大图片体积也会越大，
     * @param server 区服名称，查找目标区服的记录，
     * @param robot  描述文本，一般设置机器人名称，
     * @param cache  设置缓存，可有效提高响应速度，默认值：1为开启，0为关闭，
     * @return 图片地址
     */
    public String luckCollectView(Integer scale, String server, String robot, Integer cache) {
        MethodEnum methodEnum = MethodEnum.VIEW_LUCK_COLLECT;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        addViewParam(params, robot, cache, scale);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * @see ApiService#luckCollectView(Integer, String, String, Integer)
     */
    public String luckCollectView(String server) {
        return luckCollectView(1, server, null, 1);
    }

    /**
     * 全服统计
     *
     * @param name  奇遇名称，查找目标区服的奇遇记录，
     * @param limit 单页数量，单页返回的数量，默认值 : 20，
     * @return LuckServerStatisticalData list
     */
    public List<LuckServerStatisticalData> luckServerStatistical(String name, Integer limit) {
        MethodEnum methodEnum = MethodEnum.DATA_LUCK_SERVER_STATISTICAL;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("name", name);
        params.add("limit", limit);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 全服统计
     *
     * @param scale 网页规模，设置网页分辨率，可选范围：[1/2]，默认值：1，设置的值越大图片体积也会越大，
     * @param name  奇遇名称，查找目标区服的奇遇记录，
     * @param robot 描述文本，一般设置机器人名称，
     * @return 图片地址
     */
    public String luckServerStatisticalView(Integer scale, String name, String robot) {
        MethodEnum methodEnum = MethodEnum.VIEW_LUCK_SERVER_STATISTICAL;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("name", name);
        addViewParam(params, robot, null, scale);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * @see ApiService#luckServerStatisticalView(Integer, String, String)
     */
    public String luckServerStatisticalView(String name) {
        return luckServerStatisticalView(1, name, null);
    }

    /**
     * 名剑战绩
     * 未输入比赛模式时，将返回推栏全部角色近期的比赛记录(推栏个人页面，会出现返回结果非指定角色数据)
     *
     * @param server 区服名称，查找目标区服的比赛记录，
     * @param name   角色名称，筛选记录，
     * @param mode   比赛模式，筛选记录，
     * @param ticket 推栏标识，检查请求权限，
     * @return MatchRecentData
     */
    public MatchRecentData matchRecent(String server, String name, Integer mode, String ticket) {
        MethodEnum methodEnum = MethodEnum.DATA_MATCH_RECENT;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("name", name);
        params.add("server", server);
        params.add("mode", mode);
        params.add("ticket", ticket);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 名剑战绩
     * 未输入比赛模式时，将返回推栏全部角色近期的比赛记录(推栏个人页面，会出现返回结果非指定角色数据)
     *
     * @param scale  网页规模，设置网页分辨率，可选范围：[1/2]，默认值：1，设置的值越大图片体积也会越大，
     * @param server 区服名称，查找目标区服的比赛记录，
     * @param name   角色名称，筛选记录，
     * @param mode   比赛模式，筛选记录，
     * @param robot  描述文本，一般设置机器人名称，
     * @param ticket 推栏标识，检查请求权限，
     * @return 图片地址
     */
    public String matchRecentView(Integer scale, String server, String name, Integer mode, String robot, String ticket) {
        MethodEnum methodEnum = MethodEnum.VIEW_MATCH_RECENT;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("name", name);
        params.add("server", server);
        params.add("mode", mode);
        params.add("ticket", ticket);
        addViewParam(params, robot, null, scale);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * @see ApiService#matchRecentView(Integer, String, String, Integer, String, String)
     */
    public String matchRecentView(String server, String name, String ticket) {
        return matchRecentView(1, server, name, null, null, ticket);
    }


    /**
     * 名剑排行
     *
     * @param mode   比赛模式，查找目标比赛模式的记录，默认值 : 33，
     * @param limit  单页数量，单页返回的数量，默认值 : 20，
     * @param ticket 推栏标识，检查请求权限，
     * @return MatchAwesomeData List
     */
    public List<MatchAwesomeData> matchAwesome(Integer mode, Integer limit, String ticket) {
        MethodEnum methodEnum = MethodEnum.DATA_MATCH_AWESOME;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("limit", limit);
        params.add("mode", mode);
        params.add("ticket", ticket);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 名剑排行
     *
     * @param scale  网页规模，设置网页分辨率，可选范围：[1/2]，默认值：1，设置的值越大图片体积也会越大，
     * @param mode   比赛模式，查找目标比赛模式的记录，默认值 : 33，
     * @param robot  描述文本，一般设置机器人名称，
     * @param cache  设置缓存，可有效提高响应速度，默认值：1为开启，0为关闭，
     * @param ticket 推栏标识，检查请求权限，
     * @return 图片地址
     */
    public String matchAwesomeView(Integer scale, Integer mode, String robot, Integer cache, String ticket) {
        MethodEnum methodEnum = MethodEnum.VIEW_MATCH_AWESOME;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("mode", mode);
        params.add("ticket", ticket);
        addViewParam(params, robot, cache, scale);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * @see ApiService#matchAwesomeView(Integer, Integer, String, Integer, String)
     */
    public String matchAwesomeView(Integer mode, String ticket) {
        return matchAwesomeView(1, mode, null, 1, ticket);
    }

    /**
     * 名剑统计
     *
     * @param ticket 推栏标识，检查请求权限，
     * @param mode   比赛模式，查找目标比赛模式的记录，默认值 : 33，
     * @return MatchSchoolsData List
     */
    public List<MatchSchoolsData> matchSchools(String ticket, Integer mode) {
        MethodEnum methodEnum = MethodEnum.DATA_MATCH_SCHOOLS;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("mode", mode);
        params.add("ticket", ticket);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 名剑统计
     *
     * @param scale  网页规模，设置网页分辨率，可选范围：[1/2]，默认值：1，设置的值越大图片体积也会越大，
     * @param mode   比赛模式，查找目标比赛模式的记录，默认值 : 33，
     * @param robot  描述文本，一般设置机器人名称，
     * @param cache  设置缓存，可有效提高响应速度，默认值：1为开启，0为关闭，
     * @param ticket 推栏标识，检查请求权限，
     * @return 图片地址
     */
    public String matchSchoolsView(Integer scale, Integer mode, String robot, Integer cache, String ticket) {
        MethodEnum methodEnum = MethodEnum.VIEW_MATCH_SCHOOLS;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("mode", mode);
        params.add("ticket", ticket);
        addViewParam(params, robot, cache, scale);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * @see ApiService#matchSchoolsView(Integer, Integer, String, Integer, String)
     */
    public String matchSchoolsView(Integer mode, String ticket) {
        return matchSchoolsView(1, mode, null, 1, ticket);
    }

//     member_recruit 团队招募

    /**
     * 团队招募
     *
     * @param server  区服名称，查找目标区服的招募信息，
     * @param keyword 关键字，模糊匹配记录，用=关键字完全匹配记录，
     * @return MemberRecruitData
     */
    public MemberRecruitData memberRecruit(String server, String keyword) {
        MethodEnum methodEnum = MethodEnum.DATA_MEMBER_RECRUIT;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        params.add("keyword", keyword);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 团队招募
     *
     * @param scale   网页规模，设置网页分辨率，可选范围：[1/2]，默认值：1，设置的值越大图片体积也会越大，
     * @param server  区服名称，查找目标区服的招募信息，
     * @param keyword 关键字，模糊匹配记录，用=关键字完全匹配记录，
     * @param robot   描述文本，一般设置机器人名称，
     * @param cache   设置缓存，可有效提高响应速度，默认值：1为开启，0为关闭。
     * @return 图片地址
     */
    public String memberRecruitView(Integer scale, String server, String keyword, String robot, Integer cache) {
        MethodEnum methodEnum = MethodEnum.VIEW_MEMBER_RECRUIT;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        params.add("keyword", keyword);
        addViewParam(params, robot, cache, scale);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * @see ApiService#memberRecruitView(Integer, String, String, String, Integer)
     */
    public String memberRecruitView(String server, String keyword) {
        return memberRecruitView(1, server, keyword, null, 1);
    }

    /**
     * 动画编辑
     *
     * @param name 外观名称，查找目标外观的动画编辑器编号。
     * @return MovieEditorData
     */
    public MovieEditorData movieEditor(String name) {
        MethodEnum methodEnum = MethodEnum.DATA_MOVIE_EDITOR;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 风云榜单
     * <p>
     * 必选的 [table] [name] 榜单类型与榜单名称，[table] 与 [name] 的关联：
     * [table] : 个人，[name] : [名士五十强 老江湖五十强 兵甲藏家五十强 名师五十强 阵营英雄五十强 薪火相传五十强 庐园广记一百强]，
     * [table] : 帮会，[name] : [浩气神兵宝甲五十强 恶人神兵宝甲五十强 浩气爱心帮会五十强 恶人爱心帮会五十强]，
     * [table] : 阵营，[name] : [赛季恶人五十强 赛季浩气五十强 上周恶人五十强 上周浩气五十强 本周恶人五十强 本周浩气五十强]，
     * [table] : 试炼，[name] : [万花 七秀 少林 纯阳 天策 五毒 唐门 明教 苍云 长歌 藏剑 丐帮 霸刀 蓬莱 凌雪 衍天 药宗 刀宗]
     * 各个table的数据结构不同，最终数据以返回为准。
     *
     * @param server 区服名称，查找目标区服的榜单，
     * @param table  1
     * @param name   2
     * @return RankStatisticalData List
     */
    public List<Map<String, Object>> rankStatistical(String server, String table, String name) {
        MethodEnum methodEnum = MethodEnum.DATA_RANK_STATISTICAL;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        params.add("table", table);
        params.add("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 风云榜单
     *
     * @param scale  网页规模，设置网页分辨率，可选范围：[1/2]，默认值：1，设置的值越大图片体积也会越大，
     * @param server 区服名称，查找目标区服的榜单，
     * @param table  [name] 榜单类型与榜单名称，[table] 与 [name] 的关联
     * @param name   [name] 榜单类型与榜单名称，[table] 与 [name] 的关联
     *               [table] : 个人，[name] : [名士五十强 老江湖五十强 兵甲藏家五十强 名师五十强 阵营英雄五十强 薪火相传五十强 庐园广记一百强]，
     *               [table] : 帮会，[name] : [浩气神兵宝甲五十强 恶人神兵宝甲五十强 浩气爱心帮会五十强 恶人爱心帮会五十强]，
     *               [table] : 阵营，[name] : [赛季恶人五十强 赛季浩气五十强 上周恶人五十强 上周浩气五十强 本周恶人五十强 本周浩气五十强]，
     *               [table] : 试炼，[name] : [万花 七秀 少林 纯阳 天策 五毒 唐门 明教 苍云 长歌 藏剑 丐帮 霸刀 蓬莱 凌雪 衍天 药宗 刀宗]
     * @param robot  描述文本，一般设置机器人名称，
     * @param cache  设置缓存，可有效提高响应速度，默认值：1为开启，0为关闭，
     * @return 图片地址
     */
    public String rankStatisticalView(Integer scale, String server, String table, String name, String robot, Integer cache) {
        MethodEnum methodEnum = MethodEnum.VIEW_RANK_STATISTICAL;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        params.add("table", table);
        params.add("name", name);
        addViewParam(params, robot, cache, scale);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * @see ApiService#rankStatisticalView(Integer, String, String, String, String, Integer)
     */
    public String rankStatisticalView(String server, String table, String name) {
        return rankStatisticalView(1, server, table, name, null, 1);
    }

    /**
     * 角色信息
     *
     * @param server 区服名称，查找目标区服的记录，
     * @param name   角色名称，筛选记录，
     * @return RoleDetailedData
     */
    public RoleDetailedData roleDetailed(String server, String name) {
        MethodEnum methodEnum = MethodEnum.DATA_ROLE_DETAILED;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        params.add("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 成就百科
     *
     * @param server 区服名称，查找目标区服的记录，
     * @param role   角色名称，筛选记录，
     * @param name   成就/系列名称，查询指定成就/系列的完成进度，
     * @param ticket 推栏标识，检查请求权限，
     * @return RoleAchievementData
     */
    public RoleAchievementData roleAchievement(String server, String role, String name, String ticket) {
        MethodEnum methodEnum = MethodEnum.DATA_ROLE_ACHIEVEMENT;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        params.add("name", name);
        params.add("role", role);
        params.add("ticket", ticket);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 成就百科
     *
     * @param scale  网页规模，设置网页分辨率，可选范围：[1/2]，默认值：1，设置的值越大图片体积也会越大，
     * @param server 区服名称，查找目标区服的记录，
     * @param role   角色名称，筛选记录
     * @param name   成就/系列名称，查询指定成就/系列的完成进度
     * @param robot  描述文本，一般设置机器人名称
     * @param cache  设置缓存，可有效提高响应速度，默认值：1为开启，0为关闭，
     * @param ticket 推栏标识，检查请求权限
     * @return 图片地址
     */
    public String roleAchievementView(Integer scale, String server, String role, String name, String robot, Integer cache, String ticket) {
        MethodEnum methodEnum = MethodEnum.VIEW_ROLE_ACHIEVEMENT;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        params.add("name", name);
        params.add("role", role);
        params.add("ticket", ticket);
        addViewParam(params, robot, cache, scale);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * @see ApiService#roleAchievementView(Integer, String, String, String, String, Integer, String)
     */
    public String roleAchievementView(String server, String role, String name, String ticket) {
        return roleAchievementView(1, server, role, name, null, 1, ticket);
    }

    /**
     * 装备属性
     *
     * @param server 区服名称，查找目标区服的角色属性记录，
     * @param name   角色名称，筛选记录
     * @param ticket 推栏标识，检查请求权限，
     * @return RoleAttributeData
     */
    public RoleAttributeData roleAttribute(String server, String name, String ticket) {
        MethodEnum methodEnum = MethodEnum.DATA_ROLE_ATTRIBUTE;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        params.add("name", name);
        params.add("ticket", ticket);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 装备属性
     *
     * @param scale  网页规模，设置网页分辨率，可选范围：[1/2]，默认值：1，设置的值越大图片体积也会越大，
     * @param server 区服名称，查找目标区服的角色属性记录，
     * @param name   角色名称，筛选记录，
     * @param robot  描述文本，一般设置机器人名称
     * @param cache  设置缓存，可有效提高响应速度，默认值：1为开启，0为关闭
     * @param ticket 推栏标识，检查请求权限
     * @return 图片地址
     */
    public String roleAttributeView(Integer scale, String server, String name, String robot, Integer cache, String ticket) {
        MethodEnum methodEnum = MethodEnum.VIEW_ROLE_ATTRIBUTE;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        params.add("name", name);
        params.add("ticket", ticket);
        addViewParam(params, robot, cache, scale);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * @see ApiService#roleAttributeView(Integer, String, String, String, Integer, String)
     */
    public String roleAttributeView(String server, String name, String ticket) {
        return roleAttributeView(1, server, name, null, 1, ticket);
    }

    /**
     * 角色更新
     *
     * @param server 区服名称，上传目标服务器的角色信息，
     * @param roleId 角色数字标识，上传指定角色的信息，
     * @param ticket 推栏标识，检查请求权限
     * @return SaveDetailedData
     */
    public SaveDetailedData saveDetailed(String server, String roleId, String ticket) {
        MethodEnum methodEnum = MethodEnum.DATA_SAVE_DETAILED;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        params.add("roleId", roleId);
        params.add("ticket", ticket);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 资历榜单
     *
     * @param school 门派简称，查找目标心法的榜单，默认值 : ALL，
     * @param server 区服名称，筛选记录，默认值 : ALL，
     * @param ticket 推栏标识，检查请求权限，
     * @return SchoolSeniorityData list
     */
    public List<SchoolSeniorityData> schoolSeniority(String school, String server, String ticket) {
        MethodEnum methodEnum = MethodEnum.DATA_SCHOOL_SENIORITY;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        params.add("school", school);
        params.add("ticket", ticket);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 资历榜单
     *
     * @param scale  网页规模，设置网页分辨率，可选范围：[1/2]，默认值：1，设置的值越大图片体积也会越大
     * @param school 门派简称，查找目标心法的榜单，默认值 : ALL
     * @param server 区服名称，筛选记录，默认值 : ALL
     * @param robot  描述文本，一般设置机器人名称
     * @param cache  设置缓存，可有效提高响应速度，默认值：1为开启，0为关闭
     * @param ticket 推栏标识，检查请求权限
     * @return 图片地址
     */
    public String schoolSeniorityView(Integer scale, String school, String server, String robot, Integer cache, String ticket) {
        MethodEnum methodEnum = MethodEnum.VIEW_SCHOOL_SENIORITY;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        params.add("school", school);
        params.add("ticket", ticket);
        addViewParam(params, robot, cache, scale);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * @see ApiService#schoolSeniorityView(Integer, String, String, String, Integer, String)
     */
    public String schoolSeniorityView(String school, String server, String ticket) {
        return schoolSeniorityView(1, school, server, null, 1, ticket);
    }

    /**
     * 奇穴效果
     *
     * @param name 心法名称，查找目标心法的奇穴效果。
     * @return SchoolForceData list
     */
    public List<SchoolForceData> schoolForce(String name) {
        MethodEnum methodEnum = MethodEnum.DATA_SCHOOL_FORCE;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 技能效果
     *
     * @param name 心法名称，查找目标心法的技能详细效果。
     * @return SchoolSkillsData List
     */
    public List<SchoolSkillsData> schoolSkills(String name) {
        MethodEnum methodEnum = MethodEnum.DATA_SCHOOL_SKILL;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 沙盘信息
     *
     * @param server 区服名称，查找目标区服的沙盘信息，
     * @return ServerSandData
     */
    public ServerSandData serverSand(String server) {
        MethodEnum methodEnum = MethodEnum.DATA_SERVER_SAND;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 沙盘信息
     *
     * @param scale  网页规模，设置网页分辨率，可选范围：[1/2]，默认值：1，设置的值越大图片体积也会越大
     * @param server 区服名称，查找目标区服的沙盘信息
     * @param robot  描述文本，一般设置机器人名称
     * @param cache  设置缓存，可有效提高响应速度，默认值：1为开启，0为关闭
     * @param desc   描述文本，可设置任意文字，
     * @return 图片地址
     */
    public String serverSandView(Integer scale, String server, String robot, Integer cache, String desc) {
        MethodEnum methodEnum = MethodEnum.DATA_SERVER_SAND;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        params.add("desc", desc);
        addViewParam(params, robot, cache, scale);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * @see ApiService#serverSandView(Integer, String, String, Integer, String)
     */
    public String serverSandView(String server) {
        return serverSandView(1, server, null, 1, null);
    }

    /**
     * 阵营事件
     *
     * @param name  阵营名称，筛选记录
     * @param limit 单页数量，默认 : 100
     * @return ServerEventData List
     */
    public List<ServerEventData> serverEvent(String name, Integer limit) {
        MethodEnum methodEnum = MethodEnum.DATA_SERVER_EVENT;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("name", name);
        params.add("limit", limit);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 阵营事件
     *
     * @param scale 网页规模，设置网页分辨率，可选范围：[1/2]，默认值：1，设置的值越大图片体积也会越大
     * @param robot 描述文本，一般设置机器人名称
     * @param cache 设置缓存，可有效提高响应速度，默认值：1为开启，0为关闭，
     * @return 图片地址
     */
    public String serverEventView(Integer scale, String robot, Integer cache) {
        MethodEnum methodEnum = MethodEnum.VIEW_SERVER_EVENT;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        addViewParam(params, robot, cache, scale);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * @see ApiService#serverEventView(Integer, String, Integer)
     */
    public String serverEventView() {
        return serverEventView(1, null, 1);
    }

    /**
     * 诛恶事件
     *
     * @return ServerAntiviceData List
     */
    public List<ServerAntiviceData> serverAntivice() {
        MethodEnum methodEnum = MethodEnum.DATA_SERVER_ANTIVICE;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 关隘首领
     *
     * @return ServerLeaderData List
     */
    public List<ServerLeaderData> serverLeader() {
        MethodEnum methodEnum = MethodEnum.DATA_SERVER_LEADER;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 八卦帖子
     *
     * @param subclass 帖子分类，可选范围：818 616 鬼网三 鬼网3 树洞 记录 教程 街拍 故事 避雷 吐槽 提问
     * @param server   区服名称，查找目标区服的帖子，默认值：- 为全区服
     * @param limit    单页数量，单页返回的数量
     * @return TiebaRandomData List
     */
    public List<TiebaRandomData> tiebaRandom(String subclass, String server, Integer limit) {
        MethodEnum methodEnum = MethodEnum.DATA_TIEBA_RANDOM;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("subclass", subclass);
        params.add("server", server);
        params.add("limit", limit);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 物品价格
     * [sales] : [1 = 出售，2 = 收购，3 = 想出，4 = 想收，5 = 成交，6 = 正出，7 = 公示]
     *
     * @param name 外观名称，查找目标外观的价格信息
     * @return TradeRecordData
     */
    public TradeRecordData tradeRecord(String name) {
        MethodEnum methodEnum = MethodEnum.DATA_TRADE_RECORD;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 物品价格
     *
     * @param scale 网页规模，设置网页分辨率，可选范围：[1/2]，默认值：1，设置的值越大图片体积也会越大，
     * @param name  外观名称，查找目标外观的价格信息，
     * @param robot 描述文本，一般设置机器人名称，
     * @param cache 设置缓存，可有效提高响应速度，默认值：1为开启，0为关闭
     * @return 图片地址
     */
    public String tradeRecordView(Integer scale, String name, String robot, Integer cache) {
        MethodEnum methodEnum = MethodEnum.VIEW_TRADE_RECORD;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("name", name);
        addViewParam(params, robot, cache, scale);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * jx3api.api.http.ApiService#tradeRecordView(java.lang.Integer, java.lang.String, java.lang.String, java.lang.Integer)
     */
    public String tradeRecordView(String name) {
        return tradeRecordView(1, name, null, 1);
    }

    /**
     * 挂件详情
     *
     * @param name 挂件名称，查找目标挂件详细信息。
     * @return OtherPendantData List
     */
    public List<OtherPendantData> otherPendant(String name) {
        MethodEnum methodEnum = MethodEnum.DATA_OTHER_PENDANT;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 贴吧物价
     *
     * @param name 外观名称，查找目标外观物价信息。
     * @return TiebaItemRecordsData List
     */
    public List<TiebaItemRecordsData> tiebaItemRecords(String name) {
        MethodEnum methodEnum = MethodEnum.DATA_TIEBA_ITEM_RECORDS;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 推栏标识
     *
     * @param ticket 推栏标识，检查推栏标识的有效性
     * @return ticket
     */
    public String tokenWebTicket(String ticket) {
        MethodEnum methodEnum = MethodEnum.DATA_TIEBA_ITEM_RECORDS;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("ticket", ticket);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 站点标识
     *
     * @return TokenWebTokenData
     */
    public TokenWebTokenData tokenWebToken() {
        MethodEnum methodEnum = MethodEnum.DATA_TOKEN_WEB_TOKEN;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /*
     *  VIP II API
     * */

    /**
     * 百战首领
     *
     * @return ActiveMonsterData
     */
    public ActiveMonsterData activeMonster() {
        MethodEnum methodEnum = MethodEnum.DATA_ACTIVE_MONSTER;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 百战首领
     *
     * @param scale 网页规模，设置网页分辨率，可选：[1/2]，默认值：1，设置的值越大图片体积也会越大
     * @param robot 描述文本，一般设置机器人名称，
     * @param cache 设置缓存，可有效提高响应速度，默认值：1为开启，0为关闭
     * @return 图片地址
     */
    public String activeMonsterView(Integer scale, String robot, Integer cache) {
        MethodEnum methodEnum = MethodEnum.VIEW_ACTIVE_MONSTER;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        addViewParam(params, robot, cache, scale);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * @see ApiService#activeMonsterView(Integer, String, Integer)
     */
    public String activeMonsterView() {
        return activeMonsterView(1, null, 1);
    }

    /**
     * 歪歪频道
     *
     * @param server 区服名称，查找目标服务器的统战歪歪频道与在线人数。
     * @return DuowanStatisticalData List
     */
    public List<DuowanStatisticalData> duowanStatistical(String server) {
        MethodEnum methodEnum = MethodEnum.DATA_DUOWAN_STATISTICAL;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 师父列表
     *
     * @param server  区服名称，查找目标区服的师傅列表，
     * @param keyword 关键字，筛选记录
     * @return MemberTeacherData
     */
    public MemberTeacherData memberTeacher(String server, String keyword) {
        MethodEnum methodEnum = MethodEnum.DATA_MEMBER_TEACHER;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        params.add("keyword", keyword);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }
//    member_student

    /**
     * 徒弟列表
     *
     * @param server  区服名称，查找目标区服的徒弟列表
     * @param keyword 关键字，筛选记录
     * @return MemberStudentData
     */
    public MemberStudentData memberStudent(String server, String keyword) {
        MethodEnum methodEnum = MethodEnum.DATA_MEMBER_STUDENT;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        params.add("keyword", keyword);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 全服榜单
     * 各个table的数据结构不同，最终数据以返回为准。
     *
     * @param table 榜单类型
     * @param name  榜单名称
     *              [table] 与 [name] 的关联：
     *              [table] : 个人，[name] : [名士五十强 老江湖五十强 兵甲藏家五十强 名师五十强 阵营英雄五十强 薪火相传五十强 庐园广记一百强]，
     *              [table] : 帮会，[name] : [浩气神兵宝甲五十强 恶人神兵宝甲五十强 浩气爱心帮会五十强 恶人爱心帮会五十强]，
     *              [table] : 阵营，[name] : [赛季恶人五十强 赛季浩气五十强 上周恶人五十强 上周浩气五十强 本周恶人五十强 本周浩气五十强]，
     *              [table] : 试炼，[name] : [万花 七秀 少林 纯阳 天策 五毒 唐门 明教 苍云 长歌 藏剑 丐帮 霸刀 蓬莱 凌雪 衍天 药宗 刀宗]
     * @return RankServerStatisticalData List
     */
    public Map<String, Object> rankServerStatistical(String table, String name) {
        MethodEnum methodEnum = MethodEnum.DATA_RANK_SERVER_STATISTICAL;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("table", table);
        params.add("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 全服榜单
     *
     * @param scale 网页规模，设置网页分辨率，可选范围：[1/2]，默认值：1，设置的值越大图片体积也会越大，
     * @param table 榜单类型
     * @param name  榜单名称
     *              [table] 与 [name] 的关联：
     *              [table] : 个人，[name] : [名士五十强 老江湖五十强 兵甲藏家五十强 名师五十强 阵营英雄五十强 薪火相传五十强 庐园广记一百强]，
     *              [table] : 帮会，[name] : [浩气神兵宝甲五十强 恶人神兵宝甲五十强 浩气爱心帮会五十强 恶人爱心帮会五十强]，
     *              [table] : 阵营，[name] : [赛季恶人五十强 赛季浩气五十强 上周恶人五十强 上周浩气五十强 本周恶人五十强 本周浩气五十强]，
     *              [table] : 试炼，[name] : [万花 七秀 少林 纯阳 天策 五毒 唐门 明教 苍云 长歌 藏剑 丐帮 霸刀 蓬莱 凌雪 衍天 药宗 刀宗]
     * @param robot 描述文本，一般设置机器人名称，
     * @param cache 设置缓存，可有效提高响应速度，默认值：1为开启，0为关闭，
     * @return 图片地址
     */
    public String rankServerStatisticalView(Integer scale, String table, String name, String robot, Integer cache) {
        MethodEnum methodEnum = MethodEnum.VIEW_RANK_SERVER_STATISTICAL;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("table", table);
        params.add("name", name);
        addViewParam(params, robot, cache, scale);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * @see ApiService#rankServerStatisticalView(Integer, String, String, String, Integer)
     */
    public String rankServerStatisticalView(String table, String name) {
        return rankServerStatisticalView(1, table, name, null, 1);
    }

    /**
     * 掉落统计
     *
     * @param server 区服名称，查找目标区服的掉落记录，
     * @param name   物品名称，筛选记录，
     * @param limit  单页数量，单页返回的数量，默认值：20，
     * @return ValuablesStatisticalData List
     */
    public List<ValuablesStatisticalData> valuablesStatistical(String server, String name, Integer limit) {
        MethodEnum methodEnum = MethodEnum.DATA_VALUABLES_STATISTICAL;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        params.add("name", name);
        params.add("limit", limit);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 掉落统计
     *
     * @param scale  网页规模，设置网页分辨率，可选范围：[1/2]，默认值：1，设置的值越大图片体积也会越大，
     * @param server 区服名称，查找目标区服的掉落记录，
     * @param name   物品名称，筛选记录，
     * @param robot  描述文本，一般设置机器人名称，
     * @return 图片地址
     */
    public String valuablesStatisticalView(Integer scale, String server, String name, String robot) {
        MethodEnum methodEnum = MethodEnum.VIEW_VALUABLES_STATISTICAL;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        params.add("name", name);
        addViewParam(params, robot, null, scale);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * @see ApiService#valuablesStatisticalView(Integer, String, String, String)
     */
    public String valuablesStatisticalView(String server, String name) {
        return valuablesStatisticalView(1, server, name, null);
    }

    /**
     * 全服掉落
     *
     * @param name  物品名称，查找目标物品的掉落记录
     * @param limit 单页数量，单页返回的数量，默认值：30
     * @return ValuablesServerStatisticalData List
     */
    public List<ValuablesServerStatisticalData> valuablesServerStatistical(String name, Integer limit) {
        MethodEnum methodEnum = MethodEnum.DATA_VALUABLES_SERVER_STATISTICAL;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("name", name);
        params.add("limit", limit);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 全服掉落
     *
     * @param scale 网页规模，设置网页分辨率，可选范围：[1/2]，默认值：1，设置的值越大图片体积也会越大
     * @param name  物品名称，查找目标物品的掉落记录
     * @param robot 描述文本，一般设置机器人名称
     * @return 图片地址
     */
    public String valuablesServerStatisticalView(Integer scale, String name, String robot) {
        MethodEnum methodEnum = MethodEnum.VIEW_VALUABLES_SERVER_STATISTICAL;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("name", name);
        addViewParam(params, robot, null, scale);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * @see ApiService#valuablesServerStatisticalView(Integer, String, String)
     */
    public String valuablesServerStatisticalView(String name) {
        return valuablesServerStatisticalView(1, name, null);
    }

    /**
     * 掉落汇总
     *
     * @param server 区服名称，汇总目标区服的掉落记录
     * @param num    统计范围，默认值 7 天
     * @return ValuablesCollectData List
     */
    public List<ValuablesCollectData> valuablesCollect(String server, Integer num) {
        MethodEnum methodEnum = MethodEnum.DATA_VALUABLES_COLLECT;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        params.add("num", num);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 掉落汇总
     *
     * @param scale  网页规模，设置网页分辨率，可选范围：[1/2]，默认值：1，设置的值越大图片体积也会越大
     * @param server 区服名称，汇总目标区服的掉落记录
     * @param robot  描述文本，一般设置机器人名称
     * @return 图片地址
     */
    public String valuablesCollectView(Integer scale, String server, String robot) {
        MethodEnum methodEnum = MethodEnum.VIEW_VALUABLES_COLLECT;
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("server", server);
        addViewParam(params, robot, null, scale);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * @see ApiService#valuablesCollectView(Integer, String, String)
     */
    public String valuablesCollectView(String server) {
        return valuablesCollectView(1, server, null);
    }
    // TODO: 2024/6/19
//     watch_record 烟花记录
//    watch_statistical 烟花统计
//    watch_collect 烟花汇总
//    horse_records 的卢统计
//     horse_event 马场事件
//    rank_statistical 烟花排行

//    role_teamcdlist 副本记录
//    tieba_item_records 贴吧记录
//    valuables_server_statistical 全服掉落

    /*
     * VRF API
     * */
//    chat_mixed 智障聊天
//    music_tencent 腾讯音乐
//    music_netease 网易音乐
//    music_kugou 酷狗音乐
//    fraud_detail 骗子记录
//    idiom_solitaire 成语接龙
//    saohua_content 舔狗日记
//    converter 语音合成 阿里云语音合成（TTS）。

    /**
     * 执行get请求
     *
     * @param path   请求地址
     * @param params 使用的参数
     * @return 返回内容
     */
    public RequestResult doPostRequest(String path, MultiValueMap<String, Object> params) {
        params.add("token", apiProperties.getApiToken());
        Mono<RequestResult> mono = this.webClient.method(HttpMethod.POST)
                .uri(uriBuilder -> uriBuilder.path(path)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(params)
                .retrieve()
                .bodyToMono(RequestResult.class);
        return mono.block();
    }


    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * 获取序列化后的返回值
     *
     * @param requestResult 返回值信息
     * @param methodEnum    请求枚举
     * @return 序列化后的返回值，根据 MethodEnum.resultBeanClass 进行序列化
     */
    public static <T> T getResultRealData(RequestResult requestResult, MethodEnum methodEnum) {
        if (requestResult == null) {
            logger.error("返回值不能为空，请求名称=>{},请求地址=>{},返回值信息=>{}", methodEnum.getMethodName(), methodEnum.getMethodPath(),
                    requestResult);
            throw new RuntimeException("请求返回值为空");
        }
        if (HttpStatus.OK.value() != requestResult.getCode()) {
            logger.error("返回值不能成功，请求名称=>{},请求地址=>{},返回值信息=>{}", methodEnum.getMethodName(), methodEnum.getMethodPath(),
                    requestResult);
            throw new RuntimeException(requestResult.getMsg());
        }
        // 1、先根据是否是Map来判断，如果不是map，那就一定是一个对象数组，不需要考虑图片接口等特殊情况
        // 2、如果是map，则需要根据methodEnum 的jsonKey来判断，如果是null。则说明不需要特殊处理，否则就需要根据jsonKey来获取对应的值，再转换成resultBeanClass
        if (requestResult.getData() instanceof Map) {
            if (methodEnum.getJsonKey() == null) {
                return (T) OBJECT_MAPPER.convertValue(requestResult.getData(), methodEnum.getResultBeanClass());
            } else {
                return (T) OBJECT_MAPPER.convertValue(((Map<String, String>) requestResult.getData()).get(methodEnum.getJsonKey()), methodEnum.getResultBeanClass());
            }
        } else if (requestResult.getData() instanceof List) {
            List<T> result = new ArrayList<>();
            ((List<?>) requestResult.getData())
                    .forEach(data -> result.add((T) OBJECT_MAPPER.convertValue(requestResult.getData(), methodEnum.getResultBeanClass())));
        } else {
            logger.error("返回值类型不受支持，请求名称=>{},请求地址=>{},返回值信息=>{}", methodEnum.getMethodName(), methodEnum.getMethodPath(),
                    requestResult);
        }
        return null;
    }
}

