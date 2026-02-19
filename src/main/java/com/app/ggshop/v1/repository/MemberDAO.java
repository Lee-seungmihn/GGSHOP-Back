package com.app.ggshop.v1.repository;

import com.app.ggshop.v1.domain.MemberVO;
import com.app.ggshop.v1.domain.OAuthVO;
import com.app.ggshop.v1.dto.MemberDTO;
import com.app.ggshop.v1.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
//  의존성 주입
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;
    //    이메일 검사
    public Optional<MemberDTO> findByMemberEmail(String memberEmail){
        return memberMapper.selectByMemberEmail(memberEmail);
    }

    //    회원가입
    public void save(MemberDTO memberDTO){
        memberMapper.insert(memberDTO);
    }
    //    kako
    public void saveOAuth(OAuthVO oAuthVO){
        memberMapper.insertOauth(oAuthVO);
    }
    //    로그인
    public Optional<MemberVO> findForLogin(MemberDTO memberDTO){
        return memberMapper.selectMemberForLogin(memberDTO);
    }

}
