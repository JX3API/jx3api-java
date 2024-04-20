package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 百战首领
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class ActiveMonsterData {
    @JsonProperty("index")
    private int index;

    @JsonProperty("name")
    private String name;

    @JsonProperty("extras")
    private String extras;

    @JsonProperty("extract")
    private List<String> extract;

    @JsonProperty("desc")
    private String description;
}
