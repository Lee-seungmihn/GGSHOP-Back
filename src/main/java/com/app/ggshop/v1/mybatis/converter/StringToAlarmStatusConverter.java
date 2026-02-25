package com.app.ggshop.v1.mybatis.converter;

import com.app.ggshop.v1.common.enumeration.AlarmStatus;
import com.app.ggshop.v1.common.enumeration.Status;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToAlarmStatusConverter implements Converter<String, AlarmStatus> {
    @Override
    public AlarmStatus convert(String source) {
        return AlarmStatus.getAlarmStatus(source);
    }
}
