package com.app.ggshop.v1.dto.profile;

import com.app.ggshop.v1.domain.MemberVO;
import lombok.*;

@Getter @Setter
@ToString
@EqualsAndHashCode(of="id")
@NoArgsConstructor
public class AddressDTO {
    private Long id;
    private String memberAddress;

    public MemberVO toMemberVO() {
        return MemberVO.builder()
            .id(id)
            .memberAddress(memberAddress)
            .build();
    }
}
