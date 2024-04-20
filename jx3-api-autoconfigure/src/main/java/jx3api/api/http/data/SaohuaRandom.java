package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 撩人骚话
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class SaohuaRandom {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("text")
    private String text;
}
