package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 鲜花价格  返回值需要特殊处理
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class HomeFlowerData {
    @JsonProperty("name")
    private String name;

    @JsonProperty("color")
    private String color;

    @JsonProperty("price")
    private double price;

    @JsonProperty("line")
    private List<String> line;
}
