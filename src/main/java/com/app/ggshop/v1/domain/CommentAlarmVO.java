package com.app.ggshop.v1.domain;

import com.app.ggshop.v1.common.enumeration.AlarmStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(of="id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class CommentAlarmVO {
    private Long id;
    private AlarmStatus status;
    private Long memberId;
}
