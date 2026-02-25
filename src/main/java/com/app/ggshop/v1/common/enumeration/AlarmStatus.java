package com.app.ggshop.v1.common.enumeration;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum AlarmStatus {
    READ("read"), UNREAD("unread");

    private String value;

    private static final Map<String, AlarmStatus> STATUS_MAP =
            Arrays.stream(AlarmStatus.values()).collect(Collectors.toMap(AlarmStatus::getValue, Function.identity()));

    AlarmStatus(String value) {
        this.value = value;
    }

    public static AlarmStatus getAlarmStatus(String value) {
        return STATUS_MAP.get(value);
    }

    public String getValue() {
        return value;
    }
}
