package jx3api.api.http;

import jx3api.api.config.ApiProperties;

/**
 * api 服务类
 *
 * @author Grafie
 * @since 1.0.0
 */
public class ApiService {
    /**
     * 相关api参数
     */
    private ApiProperties apiProperties;

    public ApiService(ApiProperties apiProperties) {
        this.apiProperties = apiProperties;
    }

}
