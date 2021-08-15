package com.babmukja.server.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "front-end")
@Getter
@Setter
@ToString
public class FrontEndConfig {

    private String uri;

}
