package com.app.ggshop.v1.mapper.profile;

import com.app.ggshop.v1.dto.profile.AddressDTO;
import com.app.ggshop.v1.dto.profile.NicknameDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressMapper {
    public void updateAddress(AddressDTO addressDTO);

    public AddressDTO selectAddressById(Long id);

}
