package jx3api.api.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Api相关配置信息
 *
 * @author Grafie
 * @since 1.0.0
 */
@Configuration
@ConfigurationProperties(prefix = "jx3api.api")
@Data
public class ApiProperties {
    /**
     * api访问地址
     */
    private String apiUrl;
    /**
     * api访问token，有些api接口，需要校验你的token
     */
    private String apiToken;
    /**
     * api部分接口需要使用到的ticket
     */
    private String ticket;
}
