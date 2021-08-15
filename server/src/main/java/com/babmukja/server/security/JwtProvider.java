package com.babmukja.server.security;

import com.babmukja.server.domain.user.User;
import com.babmukja.server.error.NotFoundException;
import com.babmukja.server.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.ClassUtils.isAssignable;
import static org.springframework.security.core.authority.AuthorityUtils.commaSeparatedStringToAuthorityList;

@RequiredArgsConstructor
@Component
public class JwtProvider implements AuthenticationProvider {

    private final Jwt jwt;

    private final UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;
        if (oAuth2AuthenticationToken.getAuthorizedClientRegistrationId().equals("kakao")) {
            DefaultOAuth2User defaultOAuth2User = (DefaultOAuth2User) authentication.getPrincipal();
            Map<String, Object> kakaoAccount = (HashMap<String, Object>) defaultOAuth2User.getAttributes().get("kakao_account");
            return processUserAuthentication((String) kakaoAccount.get("email"));
        }

        DefaultOAuth2User defaultOAuth2User = (DefaultOAuth2User) authentication.getPrincipal();
        return processUserAuthentication((String) defaultOAuth2User.getAttributes().get("email"));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return isAssignable(JwtToken.class, authentication);
    }

    private Authentication processUserAuthentication(String principal) {
        try {
            User user = userService.findByEmail(principal).orElseThrow();
            JwtToken authenticated = new JwtToken(
                    new JwtAuthentication(user.getUserId(), user.getEmail()),
                    null,
                    commaSeparatedStringToAuthorityList(
                            user.getRole().value()
                    )
            );
            authenticated.setDetails(
                    user.createToken(jwt, new String[]{user.getRole().value()})
            );
            return authenticated;
        } catch (NotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw new BadCredentialsException(e.getMessage());
        } catch (DataAccessException e) {
            throw new AuthenticationServiceException(e.getMessage(), e);
        }
    }

}
