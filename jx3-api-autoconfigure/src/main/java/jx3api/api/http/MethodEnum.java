package jx3api.api.http;

import jx3api.api.http.data.ActiveCalendarData;

/**
 * 关联请求地址和对应的返回值实体类
 *
 * @author Grafie
 * @since 1.0.0
 */
public enum MethodEnum {
    /**
     * 接口详见 https://api.jx3api.com
     */
    DATA_ACTIVE_CALENDAR("日常信息-数据", "/data/active/current", ActiveCalendarData.class),
    VIEW_ACTIVE_CALENDAR("日常信息-图片服务", "/view/active/current", String.class);
    /**
     * 请求名称
     */
    private final String methodName;
    /**
     * 请求地址
     */
    private final String methodPath;
    /**
     * 请求返回值类型
     */
    private final Class resultBeanClass;

    MethodEnum(String methodName, String methodPath, Class resultBeanClass) {
        this.methodName = methodName;
        this.methodPath = methodPath;
        this.resultBeanClass = resultBeanClass;
    }

    public String getMethodName() {
        return methodName;
    }

    public Class getResultBeanClass() {
        return resultBeanClass;
    }

    public String getMethodPath() {
        return methodPath;
    }
}
