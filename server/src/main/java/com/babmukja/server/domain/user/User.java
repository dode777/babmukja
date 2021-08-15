package com.babmukja.server.domain.user;

import com.babmukja.server.domain.BaseTimeEntity;
import com.babmukja.server.security.Jwt;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import java.time.LocalDateTime;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.time.LocalDateTime.now;
import static java.util.regex.Pattern.matches;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

@EqualsAndHashCode(of = "userId", callSuper = false)
@Getter
@ToString
public class User extends BaseTimeEntity {

    @Id
    private final Long userId;

    private final String email;

    private String name;

    private String nickname;

    private String picture;

    private final Gender gender;

    private String ageRange;

    private final Role role;

    private LocalDateTime lastLoginAt;

    public User(String email, String name, String nickname, String picture, Gender gender, String ageRange) {
        this(null, email, name, nickname, picture, gender, ageRange, Role.USER, null);
    }

    @Builder
    @PersistenceConstructor
    public User(Long userId, String email, String name, String nickname, String picture, Gender gender, String ageRange, Role role, LocalDateTime lastLoginAt) {
        checkArgument(
                email.length() >= 4 && email.length() <= 50,
                "email length must be between 4 and 50 characters."
        );
        checkArgument(checkEmail(email), "Invalid email address: " + email);
        checkArgument(isNotEmpty(name), "name must be provided.");
        checkArgument(
                name.length() >= 1 && name.length() <= 10,
                "name length must be between 1 and 10 characters."
        );
        checkArgument(isNotEmpty(picture), "picture must be provided.");
        checkNotNull(gender, "gender must be provided.");
        checkNotNull(ageRange, "ageRange must be provided.");

        this.userId = userId;
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.picture = picture;
        this.gender = gender;
        this.ageRange = ageRange;
        this.role = role;
        this.lastLoginAt = lastLoginAt;
    }

    private static boolean checkEmail(String email) {
        return matches("[\\w~\\-.+]+@[\\w~\\-]+(\\.[\\w~\\-]+)+", email);
    }

    public void afterLoginSuccess() {
        lastLoginAt = now();
    }

    public String createToken(Jwt jwt, String[] roles) {
        Jwt.Claims claims = Jwt.Claims.of(userId, email, roles);
        return jwt.newToken(claims);
    }

    public void updateUserInfo(String name, String nickname, String picture, String ageRange) {
        checkArgument(isNotEmpty(name), "name must be provided.");
        checkArgument(
                name.length() >= 1 && name.length() <= 10,
                "name length must be between 1 and 10 characters."
        );
        checkArgument(isNotEmpty(picture), "picture must be provided.");
        checkNotNull(ageRange, "ageRange must be provided.");

        this.name = name;
        this.nickname = nickname;
        this.picture = picture;
        this.ageRange = ageRange;
    }

}
