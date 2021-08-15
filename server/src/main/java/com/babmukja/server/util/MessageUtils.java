package com.babmukja.server.util;

import org.springframework.context.support.MessageSourceAccessor;

import static com.google.common.base.Preconditions.checkState;

public class MessageUtils {

    private static MessageSourceAccessor messageSourceAccessor;

    private MessageUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String getMessage(String key) {
        checkState(null != messageSourceAccessor, "MessageSourceAccessor is not initialized.");
        return messageSourceAccessor.getMessage(key);
    }

    public static String getMessage(String key, Object... params) {
        checkState(null != messageSourceAccessor, "MessageSourceAccessor is not initialized.");
        return messageSourceAccessor.getMessage(key, params);
    }

    public static void setMessageSourceAccessor(MessageSourceAccessor messageSourceAccessor) {
        MessageUtils.messageSourceAccessor = messageSourceAccessor;
    }

}
