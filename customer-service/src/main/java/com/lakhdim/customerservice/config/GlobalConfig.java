package com.lakhdim.customerservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter @Setter
@ConfigurationProperties(prefix = "global.params")
public class GlobalConfig {
    private int p1;
    private int p2;
}
