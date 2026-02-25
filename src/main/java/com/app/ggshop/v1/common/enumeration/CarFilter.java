package com.app.ggshop.v1.common.enumeration;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum CarFilter {
    TWOWAY("twoway"), ONEWAY("oneway");

    private String value;

    private static final Map<String, CarFilter> CAR_FILTER_MAP =
            Arrays.stream(CarFilter.values()).collect(Collectors.toMap(CarFilter::getValue, Function.identity()));

    CarFilter(String value) {
        this.value = value;
    }

    public static CarFilter getCarFilter(String value) {return CAR_FILTER_MAP.get(value);}

    public String getValue() {
        return value;
    }


}

