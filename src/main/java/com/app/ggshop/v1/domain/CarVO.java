package com.app.ggshop.v1.domain;


import com.app.ggshop.v1.audit.dateTime.Period;
import com.app.ggshop.v1.common.enumeration.CarFilter;
import com.app.ggshop.v1.common.enumeration.Status;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(of = "id", callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class CarVO extends Period {
    private Long id;
    private String carPlateNumber;
    private Status carStatus;    // active, inactive
    private CarFilter carFilter;    // 양방향, 일반
    private Long carMemberId;
//id
//car_plate_number
//car_status
//car_filter
//created_date
//updated_date
//car_member_id
}
