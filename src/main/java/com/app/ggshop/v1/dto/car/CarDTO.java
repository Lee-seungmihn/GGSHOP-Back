package com.app.ggshop.v1.dto.car;

import com.app.ggshop.v1.common.enumeration.CarFilter;
import com.app.ggshop.v1.common.enumeration.Status;
import com.app.ggshop.v1.domain.CarVO;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of="id")
@NoArgsConstructor
public class CarDTO {
    private Long id;
    private String carPlateNumber;
    private Status carStatus;
    private CarFilter carFilter;
    private Long carMemberId;

    public CarVO toCarVO() {
        return CarVO
        .builder()
        .carPlateNumber(carPlateNumber)
        .carStatus(carStatus)
        .carFilter(carFilter)
        .carMemberId(carMemberId)
        .build();
    }
}
