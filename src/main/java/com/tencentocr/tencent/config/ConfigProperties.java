package com.tencentocr.tencent.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Create by jiuyv on 2020/5/20
 */
@Configuration
@Data
@ConfigurationProperties("tencent")
public class ConfigProperties {

    private String secretId;

    private String secretKey;

    private String region;

}



