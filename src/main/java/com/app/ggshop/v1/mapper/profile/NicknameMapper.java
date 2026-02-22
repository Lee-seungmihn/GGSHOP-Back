package com.app.ggshop.v1.mapper.profile;

import com.app.ggshop.v1.dto.profile.NicknameDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface NicknameMapper {
    public void updateNickname(NicknameDTO nicknameDTO);

    public NicknameDTO selectNicknameById(Long id);

}
