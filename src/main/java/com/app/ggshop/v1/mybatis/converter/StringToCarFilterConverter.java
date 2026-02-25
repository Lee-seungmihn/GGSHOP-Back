package com.app.ggshop.v1.mybatis.converter;

import com.app.ggshop.v1.common.enumeration.CarFilter;
import com.app.ggshop.v1.common.enumeration.Provider;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class StringToCarFilterConverter implements Converter<String, CarFilter> {

    @Override
    public CarFilter convert(String source) {
        return CarFilter.getCarFilter(source);
    }
}


