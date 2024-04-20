package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 智障聊天
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class ChatMixedData {
    @JsonProperty("session")
    private String session;

    @JsonProperty("submit")
    private String submit;

    @JsonProperty("answer")
    private String answer;
}
