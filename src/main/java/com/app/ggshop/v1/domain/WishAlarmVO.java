package com.app.ggshop.v1.domain;

import com.app.ggshop.v1.common.enumeration.AlarmStatus;
import com.app.ggshop.v1.common.enumeration.Status;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(of="id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class WishAlarmVO {
    private Long id;
    private AlarmStatus status;
    private Long memberId;

//id
//notification_wish_status    enum ('read', 'unread')
//notification_wish_member_id
}
