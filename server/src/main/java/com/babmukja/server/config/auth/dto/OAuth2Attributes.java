package com.babmukja.server.config.auth.dto;

import com.babmukja.server.domain.user.Gender;
import com.babmukja.server.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuth2Attributes {

    private final Map<String, Object> attributes;

    private final String nameAttributeKey;

    private final String email;

    private final String name;

    private final String picture;

    private final String nickname;

    private final Gender gender;

    private final String ageRange;

    @Builder
    public OAuth2Attributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture, String nickname, Gender gender, String ageRange) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.email = email;
        this.name = name;
        this.picture = picture;
        this.nickname = nickname;
        this.gender = gender;
        this.ageRange = ageRange;
    }

    public static OAuth2Attributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        if (registrationId.equals("naver")) {
            return ofNaver("id", attributes);
        }
        return ofKakao(userNameAttributeName, attributes);
    }

    private static OAuth2Attributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OAuth2Attributes.builder()
                .nickname((String) response.get("nickname"))
                .email((String) response.get("email"))
                .name((String) response.get("name"))
                .gender(Gender.of((String) response.get("gender")))
                .ageRange(((String) response.get("age")).replace("-", "~"))
                .picture((String) response.get("profile_image"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuth2Attributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
        Map<String, Object> profile = (Map<String, Object>) kakaoAccount.get("profile");

        return OAuth2Attributes.builder()
                .email((String) kakaoAccount.get("email"))
                .name((String) profile.get("nickname"))
                .picture((String) profile.get("profile_image_url"))
                .gender(Gender.of((String) kakaoAccount.get("gender")))
                .ageRange((String) kakaoAccount.get("age_range"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public User toEntity() {
        return new User(email, name, nickname, picture, gender, ageRange);
    }

}
