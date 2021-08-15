package com.babmukja.server.domain.user;

import java.util.Arrays;

public enum Gender {

    MALE("남성", "male", "M"),

    FEMALE("여성", "female", "F"),

    NONE("성별무관", "none", "U");

    private final String value;

    private final String kakao;

    private final String naver;

    Gender(String value, String kakao, String naver) {
        this.value = value;
        this.kakao = kakao;
        this.naver = naver;
    }

    public String value() {
        return value;
    }

    public String kakao() {
        return kakao;
    }

    public String naver() {
        return naver;
    }

    public static Gender of(String value) {
        return Arrays.stream(Gender.values())
                .filter(gender -> gender.value().equals(value) || gender.kakao().equals(value) || gender.naver().equals(value))
                .findFirst()
                .orElse(Gender.NONE);
    }

}
