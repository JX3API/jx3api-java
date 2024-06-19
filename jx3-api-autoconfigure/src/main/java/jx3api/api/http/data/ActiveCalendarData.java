package jx3api.api.http.data;

import lombok.Data;

import java.util.List;

/**
 * active_calendar
 *
 * @author Grafie
 * @since 2024/6/19  10:38
 */
@Data
public class ActiveCalendarData {
    /**
     * 日期
     */
    private Today today;
    /**
     * 数据
     */
    private List<DataInfo> data;
}

@Data
class Today {
    private String date;
    private String week;
    private String year;
    private String month;
    private String day;
}

@Data
class DataInfo {
    private String date;
    private String day;
    private String week;
    private String war;
    private String battle;
    private String orecar;
    private String school;
    private String rescue;
    private List<String> luck;
    private List<String> card;
}
