package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 物品价格
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class TradeRecordData {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("class")
    private String classType;

    @JsonProperty("subclass")
    private String subclass;

    @JsonProperty("name")
    private String name;

    @JsonProperty("alias")
    private String alias;

    @JsonProperty("subalias")
    private String subalias;

    @JsonProperty("row")
    private String row;

    @JsonProperty("level")
    private Integer level;

    @JsonProperty("desc")
    private String desc;

    @JsonProperty("view")
    private String view;

    @JsonProperty("date")
    private String date;

    @JsonProperty("data")
    private HairSaleData[] data;
}

@Data
class HairSaleData {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("index")
    private Integer index;

    @JsonProperty("class")
    private String classType;

    @JsonProperty("zone")
    private String zone;

    @JsonProperty("server")
    private String server;

    @JsonProperty("value")
    private Integer value;

    @JsonProperty("sales")
    private Integer sales;

    @JsonProperty("token")
    private String token;

    @JsonProperty("source")
    private Integer source;

    @JsonProperty("date")
    private String date;

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("datetime")
    private String datetime;

}