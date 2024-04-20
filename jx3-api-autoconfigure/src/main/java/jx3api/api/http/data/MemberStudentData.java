package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 徒弟列表
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class MemberStudentData {
    @JsonProperty("roleId")
    private Integer roleId;

    @JsonProperty("roleName")
    private String roleName;

    @JsonProperty("roleLevel")
    private Integer roleLevel;

    @JsonProperty("campName")
    private String campName;

    @JsonProperty("tongName")
    private String tongName;

    @JsonProperty("tongMasterName")
    private String tongMasterName;

    @JsonProperty("bodyId")
    private Integer bodyId;

    @JsonProperty("bodyName")
    private String bodyName;

    @JsonProperty("forceId")
    private Integer forceId;

    @JsonProperty("forceName")
    private String forceName;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("time")
    private Long time;

}
