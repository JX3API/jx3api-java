package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 名剑战绩
 * 需要特殊处理
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class MatchRecentData {
    @JsonProperty("zoneName")
    private String zoneName;

    @JsonProperty("serverName")
    private String serverName;

    @JsonProperty("roleName")
    private String roleName;

    @JsonProperty("roleId")
    private String roleId;

    @JsonProperty("globalRoleId")
    private String globalRoleId;

    @JsonProperty("forceName")
    private String forceName;

    @JsonProperty("forceId")
    private String forceId;

    @JsonProperty("bodyName")
    private String bodyName;

    @JsonProperty("bodyId")
    private String bodyId;

    @JsonProperty("tongName")
    private String tongName;

    @JsonProperty("tongId")
    private String tongId;

    @JsonProperty("campName")
    private String campName;

    @JsonProperty("campId")
    private String campId;

    @JsonProperty("personName")
    private String personName;

    @JsonProperty("personId")
    private String personId;

    @JsonProperty("personAvatar")
    private String personAvatar;

    @JsonProperty("performance")
    private Map<String, PerformanceInfo> performance;
    @JsonProperty("history")
    private List<HistoryEntry> history;

    @JsonProperty("trend")
    private List<TrendEntry> trend;
}

@Data
class HistoryEntry {
    @JsonProperty("zone")
    private String zone;

    @JsonProperty("server")
    private String server;

    @JsonProperty("avgGrade")
    private Integer avgGrade;

    @JsonProperty("totalMmr")
    private Integer totalMmr;

    @JsonProperty("mmr")
    private Integer mmr;

    @JsonProperty("kungfu")
    private String kungfu;

    @JsonProperty("pvpType")
    private Integer pvpType;

    @JsonProperty("won")
    private Boolean won;

    @JsonProperty("mvp")
    private Boolean mvp;

    @JsonProperty("startTime")
    private Integer startTime;

    @JsonProperty("endTime")
    private Integer endTime;
}

@Data
class TrendEntry {
    @JsonProperty("matchDate")
    private Long matchDate;

    @JsonProperty("mmr")
    private Integer mmr;

    @JsonProperty("winRate")
    private Double winRate;
}

@Data
class PerformanceInfo {
    @JsonProperty("mmr")
    private Integer mmr;

    @JsonProperty("grade")
    private Integer grade;

    @JsonProperty("ranking")
    private String ranking;

    @JsonProperty("winCount")
    private Integer winCount;

    @JsonProperty("totalCount")
    private Integer totalCount;

    @JsonProperty("mvpCount")
    private Integer mvpCount;

    @JsonProperty("pvpType")
    private String pvpType;

    @JsonProperty("winRate")
    private Integer winRate;
}