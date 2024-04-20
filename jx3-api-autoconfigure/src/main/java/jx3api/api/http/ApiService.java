package jx3api.api.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import jx3api.api.config.ApiProperties;
import jx3api.api.http.data.ActiveCalendarData;
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

    /*
     * free api
     * */

//    active_list_calendar 活动月历
//    active_celebrity 行侠事件

    // exam_answer 科举试题
    public RequestResult examAnswer(String match, int limit) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("match", match);
        params.add("limit", String.valueOf(limit));
        Mono<RequestResult> mono = doGetRequest("/data/exam/answer", params);
        RequestResult requestResult = mono.block();
        return requestResult;
    }
//    home_flower 鲜花价格
//     home_furniture 家园装饰
//     home_travel 器物图谱
//   news_allnews 新闻资讯
//    news_announce 维护公告
//    school_stoxic 小药清单
//    server_master 搜索区服
//    server_check 开服检查
//    server_status 查看状态

    /*
     * VIP I API
     */

    /**
     * active_calendar 活动日历
     * 今天、明天、后天、日常任务。
     * 只有 星期三、星期五、星期六、星期日 才有美人画图，星期三、星期五 才有世界首领，若非活动时间不返回相关键与值。
     *
     * @param server (str, optional): 区服名称，查找该区服的记录。
     * @param num    (int, optional): 预测时间，预测指定时间的日常，默认值: ``0`` 为当天，``1`` 为明天，以此类推。
     * @return ActiveCalendarData
     */
    public ActiveCalendarData activeCalendar(String server, int num) {
        MethodEnum methodEnum = MethodEnum.DATA_ACTIVE_CALENDAR;
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("server", server);
        params.add("num", String.valueOf(num));
        Mono<RequestResult> mono = doGetRequest(methodEnum.getMethodPath(), params);
        RequestResult requestResult = mono.block();
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * activeCalendar 的图片服务器
     *
     * @param server 区服名称，查找该区服的记录。
     * @param num    预测时间，预测指定时间的日常，默认值: ``0`` 为当天，``1`` 为明天，以此类推。
     * @param robot  描述文本，一般设置机器人名称，
     * @param cache  设置缓存，可有效提高响应速度，默认值：1为开启，0为关闭。
     * @return 图片地址
     */
    public String viewActiveCurrent(String server, int num, String robot, int cache) {
        MethodEnum methodEnum = MethodEnum.VIEW_ACTIVE_CALENDAR;
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("server", server);
        params.add("num", String.valueOf(num));
        params.add("robot", String.valueOf(robot));
        params.add("cache", String.valueOf(cache));
        Mono<RequestResult> mono = doGetRequest(methodEnum.getMethodPath(), params);
        RequestResult requestResult = mono.block();
        return getResultRealData(requestResult, methodEnum);
    }
//     save_detailed 角色更新, 数据服务
//    role_detailed 角色信息
//     school_matrix 阵法效果
//  school_force 奇穴效果
//    school_skills 技能效果
//    tieba_random 八卦帖子
//    role_attribute 装备属性
//    role_teamcdlist 副本记录
//    luck_adventure 奇遇记录
//     luck_statistical 奇遇统计
//    luck_server_statistical 全服统计
//    luck_collect 奇遇汇总
//     role_achievement 成就百科
//    match_recent 名剑战绩
//    match_awesome 名剑排行
//     match_schools 名剑统计
//     member_recruit 团队招募
//    member_teacher 师父列表
//    member_student 徒弟列表
//    server_sand 沙盘信息
//    server_event 阵营事件
//    trade_demon 金币比例
//     trade_record 物品价格
//    tieba_item_records 贴吧记录
//    valuables_statistical 掉落统计
//    valuables_server_statistical 全服掉落
//    valuables_collect 掉落汇总
//    server_antivice 诛恶事件
//    rank_statistical 风云榜单
//    server_rank 全服榜单
//    rank_statistical 资历榜单
//    duowan_statistical 歪歪频道
    /*
     *  VIP II API
     * */
//    active_monster 百战首领
//    horse_records 的卢统计
//     horse_event 马场事件
//     watch_record 烟花记录
//    watch_statistical 烟花统计
//    watch_collect 烟花汇总
//    rank_statistical 烟花排行


    /*
     * VRF API
     * */
//    chat_mixed 智障聊天
//    music_tencent 腾讯音乐
//    music_netease 网易音乐
//    music_kugou 酷狗音乐
//    fraud_detail 骗子记录
//    idiom_solitaire 成语接龙
//    saohua_random 撩人骚话
//    saohua_content 舔狗日记
//    converter 语音合成 阿里云语音合成（TTS）。

    /**
     * 执行get请求
     *
     * @param path   请求地址
     * @param params 使用的参数
     * @return 返回内容
     */
    public Mono<RequestResult> doGetRequest(String path, MultiValueMap<String, String> params) {
        return this.webClient.method(HttpMethod.GET)
                .uri(uriBuilder -> uriBuilder.path(path)
                        .queryParams(params)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(RequestResult.class);
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
        if (requestResult == null || HttpStatus.OK.value() != requestResult.getCode()) {
            logger.error("返回值不能为空，请求名称=>{},请求地址=>{},返回值信息=>{}", methodEnum.getMethodName(), methodEnum.getMethodPath(),
                    requestResult);
            return null;
        }
        // 需要进行适配，有可能 requestResult.data 是一个linkedHashMap也有可能是一个List<LinkedHashMap>
        if (requestResult.getData() instanceof Map) {
            // 特殊处理，对于所有以VIEW开头的请求类型，由于其返回值只有一个url，所以这个地方进行特殊处理
            // TODO: 2024/4/20 还需要对其他某几个接口进行特殊处理
            if (methodEnum.getMethodPath().startsWith("/view")) {
                return (T) ((Map<String, String>) requestResult.getData()).get("url");
            } else {
                return (T) OBJECT_MAPPER.convertValue(requestResult.getData(), methodEnum.getResultBeanClass());
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

