package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 角色更新
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class SaveDetailedData {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("zone_name")
    private String zoneName;

    @JsonProperty("server_name")
    private String serverName;

    @JsonProperty("role_name")
    private String roleName;

    @JsonProperty("role_id")
    private String roleId;

    @JsonProperty("global_role_id")
    private String globalRoleId;

    @JsonProperty("force_name")
    private String forceName;

    @JsonProperty("force_id")
    private String forceId;

    @JsonProperty("body_name")
    private String bodyName;

    @JsonProperty("body_id")
    private String bodyId;

    @JsonProperty("camp_name")
    private String campName;

    @JsonProperty("camp_id")
    private String campId;

    @JsonProperty("tong_name")
    private String tongName;

    @JsonProperty("tong_id")
    private String tongId;

    @JsonProperty("person_name")
    private String personName;

    @JsonProperty("person_id")
    private String personId;

    @JsonProperty("person_avatar")
    private String personAvatar;

    @JsonProperty("source")
    private Integer source;

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("datetime")
    private String datetime;
}
