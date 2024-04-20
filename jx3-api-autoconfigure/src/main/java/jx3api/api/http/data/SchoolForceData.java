package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 奇穴效果
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class SchoolForceData {
    @JsonProperty("level")
    private int level;

    @JsonProperty("data")
    private List<SkillInfo> data;

}

@Data
class SkillInfo {
    @JsonProperty("name")
    private String name;

    @JsonProperty("class")
    private Integer skillClass;

    @JsonProperty("desc")
    private String description;

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("kind")
    private String kind;

    @JsonProperty("subKind")
    private String subKind;
}
