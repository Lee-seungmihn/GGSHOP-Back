package com.app.ggshop.v1.repository.profile;

import com.app.ggshop.v1.dto.profile.AddressDTO;
import com.app.ggshop.v1.dto.profile.NicknameDTO;
import com.app.ggshop.v1.mapper.profile.AddressMapper;
import com.app.ggshop.v1.mapper.profile.NicknameMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AddressDAO {

    private final NicknameMapper nicknameMapper;
    private final AddressMapper addressMapper;

    // 수정
    public void updateAddress(AddressDTO addressDTO) { addressMapper.updateAddress(addressDTO); }

    // 조회
    public AddressDTO findId(Long id) { return addressMapper.selectAddressById(id); }

}
