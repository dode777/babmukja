package com.babmukja.server.config;

import com.babmukja.server.security.Jwt;
import com.babmukja.server.util.MessageUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;

@Configuration
public class ServiceConfig {

    @Bean
    public MessageSourceAccessor messageSourceAccessor(MessageSource messageSource) {
        MessageSourceAccessor messageSourceAccessor = new MessageSourceAccessor(messageSource);
        MessageUtils.setMessageSourceAccessor(messageSourceAccessor);
        return messageSourceAccessor;
    }

    @Bean
    public Jwt jwt(JwtTokenConfig jwtTokenConfig) {
        return new Jwt(jwtTokenConfig.getIssuer(), jwtTokenConfig.getSecret(), jwtTokenConfig.getExpirationTime());
    }

}
