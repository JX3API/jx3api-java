package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 关隘首领
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class ServerLeaderData {
    @JsonProperty("server")
    private String server;

    @JsonProperty("data")
    private List<CastleData> castleDataList;
}

@Data
class CastleData {
    @JsonProperty("server")
    private String server;

    @JsonProperty("leader")
    private String leader;

    @JsonProperty("camp_name")
    private String campName;

    @JsonProperty("castle")
    private String castle;

    @JsonProperty("status")
    private int status;

    @JsonProperty("str_status")
    private String strStatus;

    @JsonProperty("start_time")
    private long startTime;

    @JsonProperty("end_time")
    private long endTime;
}