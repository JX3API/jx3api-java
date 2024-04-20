package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 团队招募
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class MemberRecruitData {
    @JsonProperty("zone")
    private String zone;

    @JsonProperty("server")
    private String server;

    @JsonProperty("time")
    private long time;

    @JsonProperty("data")
    private List<ActivityInfo> data;
}

class ActivityInfo {
    @JsonProperty("activityId")
    private Integer activityId;

    @JsonProperty("activity")
    private String activity;

    @JsonProperty("level")
    private Integer level;

    @JsonProperty("leader")
    private String leader;

    @JsonProperty("pushId")
    private Integer pushId;

    @JsonProperty("roleId")
    private Integer roleId;

    @JsonProperty("createTime")
    private Long createTime;

    @JsonProperty("number")
    private Integer number;

    @JsonProperty("maxNumber")
    private Integer maxNumber;

    @JsonProperty("label")
    private List<Object> label;

    @JsonProperty("content")
    private String content;
}
