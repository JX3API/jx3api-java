package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 开服检查
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class ServerCheckData {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("zone")
    private String zone;

    @JsonProperty("server")
    private String server;

    @JsonProperty("status")
    private Integer status;
}
