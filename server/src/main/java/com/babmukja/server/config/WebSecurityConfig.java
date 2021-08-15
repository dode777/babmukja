package com.babmukja.server.config;

import com.babmukja.server.config.auth.CustomOAuth2UserService;
import com.babmukja.server.config.auth.OAuth2AuthenticationSuccessHandler;
import com.babmukja.server.domain.user.Role;
import com.babmukja.server.security.*;
import com.babmukja.server.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    private final FrontEndConfig frontEndConfig;

    private final Jwt jwt;

    private final JwtTokenConfig jwtTokenConfig;

    private final JwtProvider jwtProvider;

    private final JwtAccessDeniedHandler accessDeniedHandler;

    private final EntryPointUnauthorizedHandler unauthorizedHandler;

    @Bean
    public JwtTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtTokenFilter(jwtTokenConfig.getHeader(), jwt);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/swagger-ui/**", "/swagger-resources/**", "/v2/api-docs", "/webjars/**", "/static/**", "/templates/**", "/h2/**", "/h2-console/**");
    }

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder builder, JwtProvider jwtProvider) {
        builder.authenticationProvider(jwtProvider);
    }

    @Bean
    public JwtProvider jwtAuthenticationProvider(Jwt jwt, UserService userService) {
        return new JwtProvider(jwt, userService);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(unauthorizedHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                .antMatchers("/api/v1/**").hasAnyRole(Role.USER.name(), Role.ADMIN.name())
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService)
                .and()
                .successHandler(new OAuth2AuthenticationSuccessHandler(frontEndConfig, jwtProvider));
    }

}
