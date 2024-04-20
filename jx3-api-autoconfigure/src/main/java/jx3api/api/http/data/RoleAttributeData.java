package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 装备属性
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class RoleAttributeData {
    @JsonProperty("zoneName")
    private String zoneName;

    @JsonProperty("serverName")
    private String serverName;

    @JsonProperty("roleName")
    private String roleName;

    @JsonProperty("roleId")
    private String roleId;

    @JsonProperty("globalRoleId")
    private String globalRoleId;

    @JsonProperty("forceName")
    private String forceName;

    @JsonProperty("forceId")
    private String forceId;

    @JsonProperty("bodyName")
    private String bodyName;

    @JsonProperty("bodyId")
    private String bodyId;

    @JsonProperty("tongName")
    private String tongName;

    @JsonProperty("tongId")
    private String tongId;

    @JsonProperty("campName")
    private String campName;

    @JsonProperty("campId")
    private String campId;

    @JsonProperty("personName")
    private String personName;

    @JsonProperty("personId")
    private String personId;

    @JsonProperty("personAvatar")
    private String personAvatar;

    @JsonProperty("kungfuName")
    private String kungfuName;

    @JsonProperty("kungfuId")
    private String kungfuId;

    @JsonProperty("equipList")
    private List<EquipItem> equipList;

    @JsonProperty("qixueList")
    private List<QixueItem> qixueList;

    @JsonProperty("panelList")
    private PanelList panelList;
}

@Data
class EquipItem {
    @JsonProperty("name")
    private String name;

    @JsonProperty("class")
    private String equipClass;

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("kind")
    private String kind;

    @JsonProperty("subKind")
    private String subKind;

    @JsonProperty("quality")
    private String quality;

    @JsonProperty("strengthLevel")
    private String strengthLevel;

    @JsonProperty("maxStrengthLevel")
    private String maxStrengthLevel;

    @JsonProperty("color")
    private String color;

    @JsonProperty("desc")
    private String desc;

    @JsonProperty("source")
    private String source;

    @JsonProperty("modifyType")
    private List<ModifyType> modifyType;

    @JsonProperty("permanentEnchant")
    private List<EnchantItem> permanentEnchant;
}

@Data
class ModifyType {
    @JsonProperty("name")
    private String name;

    @JsonProperty("max")
    private String max;

    @JsonProperty("min")
    private String min;

    @JsonProperty("desc")
    private String desc;

    @JsonProperty("percent")
    private Boolean percent;
}

@Data
class EnchantItem {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("level")
    private String level;

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("attributes")
    private List<Attribute> attributes;
}

@Data
class Attribute {
    @JsonProperty("max")
    private String max;

    @JsonProperty("min")
    private String min;

    @JsonProperty("attrib")
    private List<AttribDesc> attrib;
}

@Data
class AttribDesc {
    @JsonProperty("desc")
    private String desc;
}

@Data
class QixueItem {
    @JsonProperty("name")
    private String name;

    @JsonProperty("level")
    private int level;

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("kind")
    private String kind;

    @JsonProperty("subKind")
    private String subKind;

    @JsonProperty("desc")
    private String desc;
}

@Data
class PanelList {
    @JsonProperty("score")
    private int score;

    @JsonProperty("panel")
    private List<PanelItem> panel;
}

@Data
class PanelItem {
    @JsonProperty("name")
    private String name;

    @JsonProperty("percent")
    private boolean percent;

    @JsonProperty("value")
    private Integer value;
}
