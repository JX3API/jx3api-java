package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 新闻资讯
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class WebNewsAllNewsData {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("value")
    private Long value;

    @JsonProperty("type")
    private String type;

    @JsonProperty("title")
    private String title;

    @JsonProperty("date")
    private String date;

    @JsonProperty("url")
    private String url;
}
