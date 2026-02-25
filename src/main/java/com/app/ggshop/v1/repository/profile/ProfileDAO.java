package com.app.ggshop.v1.repository.profile;

import com.app.ggshop.v1.domain.MemberFileVO;
import com.app.ggshop.v1.dto.profile.ProfileDTO;
import com.app.ggshop.v1.mapper.profile.LeaveMapper;
import com.app.ggshop.v1.mapper.profile.ProfileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProfileDAO {
    private final ProfileMapper memberFileMapper;
    private final ProfileMapper profileMapper;
    private final LeaveMapper leaveMapper;

    //  추가
    public void save(MemberFileVO memberFileVO) {
        memberFileMapper.insertMemberFile(memberFileVO);
    }

    //  제거
    public void deleteByProfile(Long memberId) {
        profileMapper.deleteByProfile(memberId);
    }
    //  조회
    public Optional<ProfileDTO> findProfileByMemberId(Long memberId) {return profileMapper.selectProfileByMemberId(memberId);}

    //  제거
    public void deleteMember(Long id){ leaveMapper.deleteMember(id);}

//    목록
//    public List<PostFileDTO>  findAllByPostId(Long id) {
//        return postFileMapper.selectAllByPostId(id);
//    }
}













