package com.app.ggshop.v1.service.profile;

import com.app.ggshop.v1.common.enumeration.FileContentType;
import com.app.ggshop.v1.domain.FileVO;
import com.app.ggshop.v1.dto.profile.*;
import com.app.ggshop.v1.repository.MemberDAO;
import com.app.ggshop.v1.repository.profile.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class ProfileService {
    private final FileDAO fileDAO;
    private final ProfileDAO profileDAO;
    private final NicknameDAO nicknameDAO;
    private final PasswordDAO passwordDAO;
    private final AddressDAO addressDAO;


    public void changeProfileImage(ProfileDTO profileDTO, MultipartFile file) throws IOException {
        profileDAO.deleteByProfile(profileDTO.getMemberId());

        String rootPath = "C:/file/";
        String todayPath = getTodayPath();
        String path = rootPath + todayPath;

        UUID uuid = UUID.randomUUID();
        profileDTO.setFilePath(todayPath);
        profileDTO.setFileSize(String.valueOf(file.getSize()));
        profileDTO.setFileOriginalName(file.getOriginalFilename());
        profileDTO.setFileName(uuid.toString() + "_" + file.getOriginalFilename());
        profileDTO.setFileContentType(file.getContentType().contains("image") ? FileContentType.IMAGE : FileContentType.OTHER);

        FileVO fileVO = profileDTO.tofileVO();
        fileDAO.save(fileVO);

        profileDTO.setId(fileVO.getId());
        profileDAO.save(profileDTO.toMemberFileVO());

        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        try {
            file.transferTo(new File(path, profileDTO.getFileName()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getTodayPath(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
    public ProfileDTO getProfile(Long memberId) {
        Optional<ProfileDTO> profileDTO = profileDAO.findProfileByMemberId(memberId);
        if (profileDTO.isEmpty() || profileDTO.get().getFileName() == null) {
            profileDTO = Optional.of(new ProfileDTO());
            profileDTO.get().setFilePath("/image/profile/");
            profileDTO.get().setFileName("profile.jpg");
            profileDTO.get().setMemberId(memberId);
        }

        return profileDTO.orElse(null);
    }

//  닉네임
//    조회
    public NicknameDTO getNickname(Long id) {
        return nicknameDAO.findId(id);
    }
//    수정
    public void nicknameUpdate(NicknameDTO nicknameDTO) {
        nicknameDAO.updateNickname(nicknameDTO);
    }

//  주소
//    조회
    public AddressDTO getAddress(Long id) {return addressDAO.findId(id);}
//    수정
    public void addressUpdate(AddressDTO addressDTO) {
        addressDAO.updateAddress(addressDTO);
    }

//  패스워드
//    조회
    public PasswordDTO getPassword(Long id) {
        return passwordDAO.findId(id);
    }
//    수정
    public void passwordUpdate(PasswordDTO passwordDTO) {
        passwordDAO.updatePassword(passwordDTO);
    }
//  회원탈퇴
//    탈퇴
    public void leaveMember(Long id) {profileDAO.deleteMember(id);}
//

}
