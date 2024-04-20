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
    @JsonProperty("old_version")
    private String oldVersion;

    @JsonProperty("new_version")
    private String newVersion;

    @JsonProperty("package_num")
    private Integer packageNum;

    @JsonProperty("package_size")
    private String packageSize;
}
