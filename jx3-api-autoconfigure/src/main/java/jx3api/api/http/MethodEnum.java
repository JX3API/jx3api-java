package jx3api.api.http;

import jx3api.api.http.data.*;

import java.util.Map;

/**
 * 关联请求地址和对应的返回值实体类
 *
 * @author Grafie
 * @since 1.0.0
 */
public enum MethodEnum {
    /**
     * 接口详见 https://api.jx3api.com
     */
    /**
     * FREE API
     */
    DATA_ACTIVE_CURRENT("日常信息-数据", "/data/active/current", ActiveCurrentData.class,null),
    VIEW_ACTIVE_CURRENT("日常信息-图片服务", "/view/active/current", String.class,"url"),
    DATA_HOME_FLOWER("鲜花价格-数据", "/data/home/flower", String.class,null),
    VIEW_HOME_FLOWER("鲜花价格-图片服务", "/view/home/flower", HomeFlowerData.class,"url"),
    DATA_WEB_NEWS_ANNOUNCE("维护公告-数据", "/data/web/news/announce", WebNewsAllNewsData.class,null),
    VIEW_WEB_NEWS_ANNOUNCE("维护公告-图片服务", "/view/web/news/announce", String.class,"url"),
    /*纯数据接口*/
    DATA_EXAM_ANSWER("科举试题-数据", "/data/active/current", ExamAnswerData.class,null),
    DATA_HOME_FURNITURE("家园装饰-数据", "/data/home/furniture", HomeFurnitureData.class,null),
    DATA_HOME_TRAVEL("器物图谱-数据", "/data/home/travel", HomeTravelData.class,null),
    DATA_SCHOOL_MATRIX("阵法效果-数据", "/data/school/matrix", SchoolMatrixData.class,null),
    DATA_SERVER_MASTER("搜索区服-数据", "/data/server/master", ServerMasterData.class,null),
    DATA_SERVER_CHECK("开服检查-数据", "/data/server/check", ServerCheckData.class,null),
    DATA_SERVER_STATUS("查看状态-数据", "/data/server/status", ServerStatusData.class,null),
    DATA_WEB_NEWS_ALLNEWS("新闻资讯-数据", "/data/web/news/allnews", WebNewsAllNewsData.class,null),
    DATA_SAOHUA_RANDOM("骚话-数据", "/data/saohua/random", SaohuaRandomData.class,null),
    /**
     * VIP1 API
     */
    DATA_ACTIVE_CALENDAR("活动日历-数据", "/data/active/calendar", ActiveCalendarData.class,null),
    VIEW_ACTIVE_CALENDAR("活动日历-图片服务", "/view/active/calendar", String.class,"url"),
    DATA_TRADE_DEMON("金币比例-数据", "/data/trade/demon", TradeDemonData.class,null),
    VIEW_TRADE_DEMON("金币比例-图片服务", "/view/trade/demon", String.class,"url"),
    VIEW_TRADE_SERVER_DEMON("金币比例-图片服务", "/view/trade/server/demon", String.class,"url"),
    DATA_ACTIVE_CELEBRITIES("行侠事件-数据", "/data/active/celebrities", ActiveCelebritiesData.class,null),
    DATA_LUCK_ADVENTURE("奇遇记录-数据", "/data/luck/adventure", LuckAdventureData.class,null),
    VIEW_LUCK_ADVENTURE("奇遇记录-图片服务", "/view/luck/adventure", String.class,"url"),
    DATA_LUCK_STATISTICAL("奇遇统计-数据", "/data/luck/statistical", LuckStatisticalData.class,null),
    VIEW_LUCK_STATISTICAL("奇遇统计-图片服务", "/view/luck/statistical", String.class,"url"),
    DATA_LUCK_COLLECT("奇遇汇总-数据", "/data/luck/collect", LuckCollectData.class,null),
    VIEW_LUCK_COLLECT("奇遇汇总-图片服务", "/view/luck/collect", String.class,"url"),
    DATA_LUCK_SERVER_STATISTICAL("全服统计-数据", "/data/luck/server/statistical", LuckServerStatisticalData.class,null),
    VIEW_LUCK_SERVER_STATISTICAL("全服统计-图片服务", "/view/luck/server/statistical", String.class,"url"),
    DATA_MATCH_RECENT("名剑战绩-数据", "/data/match/recent", MatchRecentData.class,null),
    VIEW_MATCH_RECENT("名剑战绩-图片服务", "/view/match/recent", String.class,"url"),
    DATA_MATCH_AWESOME("名剑排行-数据", "/data/match/awesome", MatchAwesomeData.class,null),
    VIEW_MATCH_AWESOME("名剑排行-图片服务", "/view/match/awesome", String.class,"url"),
    DATA_MATCH_SCHOOLS("名剑统计-数据", "/data/match/schools", MatchSchoolsData.class,null),
    VIEW_MATCH_SCHOOLS("名剑统计-图片服务", "/view/match/schools", String.class,"url"),
    DATA_MEMBER_RECRUIT("团队招募-数据", "/data/member/recruit", MemberRecruitData.class,null),
    VIEW_MEMBER_RECRUIT("团队招募-图片服务", "/view/member/recruit", String.class,"url"),
    DATA_RANK_STATISTICAL("风云榜单-数据", "/data/rank/statistical", Map.class,null),
    VIEW_RANK_STATISTICAL("风云榜单-图片服务", "/view/rank/statistical", String.class,"url"),
    DATA_ROLE_ACHIEVEMENT("成就百科-数据", "/data/role/achievement", RoleAchievementData.class,null),
    VIEW_ROLE_ACHIEVEMENT("成就百科-图片服务", "/view/role/achievement", String.class,"url"),
    DATA_ROLE_ATTRIBUTE("装备属性-数据", "/data/role/attribute", RoleAttributeData.class,null),
    VIEW_ROLE_ATTRIBUTE("装备属性-图片服务", "/view/role/attribute", String.class,"url"),
    DATA_SCHOOL_SENIORITY("资历榜单-数据", "/data/school/seniority", SchoolSeniorityData.class,null),
    VIEW_SCHOOL_SENIORITY("资历榜单-图片服务", "/view/school/seniority", String.class,"url"),
    DATA_SCHOOL_FORCE("奇穴效果-数据", "/data/school/force", SchoolForceData.class,null),
    DATA_SCHOOL_SKILL("技能效果-数据", "/data/school/skills", SchoolSkillsData.class,null),
    DATA_SERVER_SAND("沙盘信息-数据", "/data/server/sand", ServerSandData.class,null),
    VIEW_SERVER_SAND("沙盘信息-图片服务", "/view/server/sand", String.class,"url"),
    DATA_SERVER_EVENT("阵营事件-数据", "/data/server/event", ServerSandData.class,null),
    VIEW_SERVER_EVENT("阵营事件-图片服务", "/view/server/event", String.class,"url"),
    DATA_TRADE_RECORD("物品价格-数据", "/data/trade/record", TradeRecordData.class,null),
    VIEW_TRADE_RECORD("物品价格-图片服务", "/view/trade/record", String.class,"url"),
    /*纯数据接口*/
    DATA_MOVIE_EDITOR("动画编辑-数据", "/data/movie/editor", MovieEditorData.class,null),
    DATA_SAVE_DETAILED("角色更新-数据", "/data/save/detailed", SaveDetailedData.class,null),
    DATA_ROLE_DETAILED("角色信息-数据", "/data/role/detailed", RoleDetailedData.class,null),
    DATA_SERVER_ANTIVICE("诛恶事件-数据", "/data/server/antivice", ServerAntiviceData.class,null),
    DATA_SERVER_LEADER("关隘首领-数据", "/data/server/leader", ServerLeaderData.class,null),
    DATA_TIEBA_RANDOM("八卦帖子-数据", "/data/tieba/random", TiebaRandomData.class,null),
    DATA_OTHER_PENDANT("挂件详情-数据", "/data/other/pendant", OtherPendantData.class,null),
    DATA_TIEBA_ITEM_RECORDS("贴吧物价-数据", "/data/tieba/item/records", TiebaItemRecordsData.class,null),
    DATA_TOKEN_WEB_TICKET("推栏标识-数据", "/data/token/web/ticket", String.class,"ticket"),
    DATA_TOKEN_WEB_TOKEN("站点标识-数据", "/data/token/web/token", TokenWebTokenData.class,null),

    /**
     * VIP2 API
     */
    DATA_ACTIVE_MONSTER("百战首领-数据", "/data/active/monster", ActiveMonsterData.class,null),
    VIEW_ACTIVE_MONSTER("百战首领-图片服务", "/view/active/monster", String.class,"url"),
    DATA_RANK_SERVER_STATISTICAL("全服榜单-数据", "/data/rank/server/statistical", Map.class,null),
    VIEW_RANK_SERVER_STATISTICAL("全服榜单-图片服务", "/view/rank/server/statistical", String.class,"url"),
    DATA_VALUABLES_STATISTICAL("掉落统计-数据", "/data/valuables/statistical", ValuablesStatisticalData.class,null),
    VIEW_VALUABLES_STATISTICAL("掉落统计-图片服务", "/view/valuables/statistical", String.class,"url"),
    DATA_VALUABLES_SERVER_STATISTICAL("全服掉落-数据", "/data/valuables/server/statistical", ValuablesServerStatisticalData.class,null),
    VIEW_VALUABLES_SERVER_STATISTICAL("全服掉落-图片服务", "/view/valuables/server/statistical", String.class,"url"),
    DATA_VALUABLES_COLLECT("掉落汇总-数据", "/data/valuables/collect", ValuablesCollectData.class,null),
    VIEW_VALUABLES_COLLECT("掉落汇总-图片服务", "/view/valuables/collect", String.class,"url"),
    DATA_WATCH_RECORD("烟花记录-数据", "/data/watch/record", WatchRecordData.class,null),
    VIEW_WATCH_RECORD("烟花记录-图片服务", "/view/watch/record", String.class,"url"),
    DATA_WATCH_STATISTICAL("烟花统计-数据", "/data/watch/statistical", WatchStatisticalData.class,null),
    VIEW_WATCH_STATISTICAL("烟花统计-图片服务", "/view/watch/statistical", String.class,"url"),
    DATA_WATCH_COLLECT("烟花汇总-数据", "/data/watch/collect", WatchCollectData.class,null),
    VIEW_WATCH_COLLECT("烟花汇总-图片服务", "/view/watch/collect", String.class,"url"),
    /*纯数据接口*/
    DATA_DUOWAN_STATISTICAL("歪歪频道-数据", "/data/duowan/statistical", DuowanStatisticalData.class,null),
    DATA_MEMBER_TEACHER("师父列表-数据", "/data/member/teacher", MemberTeacherData.class,null),
    DATA_MEMBER_STUDENT("徒弟列表-数据", "/data/member/student", DuowanStatisticalData.class,null),
    DATA_WATCH_RANK_STATISTICAL("烟花排行-数据", "/data/watch/rank/statistical", WatchRankStatisticalData.class,null),
    DATA_HORSE_RECORDS("的卢统计-数据", "/data/horse/records", HorseRecordsData.class,"data"),

    /**
     * VRF API
     */
    DATA_CHAT_MIXED("智障聊天-数据", "/data/chat/mixed", ChatMixedData.class,null),
    DATA_IDIOM_SOLITAIRE("成语接龙-数据", "/data/idiom/solitaire", IdiomSolitaireData.class,null),
    DATA_SAOHUA_CONTENT("舔狗日记-数据", "/data/saohua/content", SaohuaContentData.class,null),
    DATA_SOUND_CONVERTER("语音合成-数据", "/data/sound/converter", SoundConverterData.class,null),
    DATA_MUSIC_TENCENT("腾讯音乐-数据", "/data/music/tencent", MusicTencentData.class,null),
    DATA_MUSIC_NETEASE("网易音乐-数据", "/data/music/netease", MusicNeteaseData.class,null)
    ;
    /**
     * 请求名称
     */
    private final String methodName;
    /**
     * 请求地址
     */
    private final String methodPath;
    /**
     * 请求返回值类型
     */
    private final Class resultBeanClass;
    /**
     * 返回的json中的key
     */
    private final String jsonKey;

    MethodEnum(String methodName, String methodPath, Class resultBeanClass, String jsonKey) {
        this.methodName = methodName;
        this.methodPath = methodPath;
        this.resultBeanClass = resultBeanClass;
        this.jsonKey = jsonKey;
    }

    public String getMethodName() {
        return methodName;
    }

    public Class getResultBeanClass() {
        return resultBeanClass;
    }

    public String getMethodPath() {
        return methodPath;
    }

    public String getJsonKey() {
        return jsonKey;
    }
}
