package com.app.ggshop.v1.dto.profile;

import com.app.ggshop.v1.domain.MemberVO;
import lombok.*;

@Getter @Setter
@ToString
@EqualsAndHashCode(of="id")
@NoArgsConstructor
public class NicknameDTO {
    private Long id;
    private String memberNickname;

    public MemberVO toMemberVO() {
        return MemberVO.builder()
            .id(id)
            .memberNickname(memberNickname)
            .build();
    }
}
