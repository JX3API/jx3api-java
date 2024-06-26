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

    @JsonProperty("campName")
    private String campName;

    @JsonProperty("campId")
    private String campId;

    @JsonProperty("tongName")
    private String tongName;

    @JsonProperty("tongId")
    private String tongId;

    @JsonProperty("personName")
    private String personName;

    @JsonProperty("personId")
    private String personId;

    @JsonProperty("personAvatar")
    private String personAvatar;

    @JsonProperty("source")
    private Integer source;

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("datetime")
    private String datetime;
}
