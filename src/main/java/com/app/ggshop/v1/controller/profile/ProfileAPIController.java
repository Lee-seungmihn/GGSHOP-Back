package com.app.ggshop.v1.controller.profile;

import com.app.ggshop.v1.dto.MemberDTO;
import com.app.ggshop.v1.service.profile.ProfileService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api/profile/settings/**")
@RequiredArgsConstructor
public class ProfileAPIController {

    private final HttpSession session;
    private final ProfileService profileService;

    @GetMapping("/leave")
    public String deletePageMovement() {
        MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
        if (loginMember != null) {
            return "/";
        }
        return "deleteaccount/deleteaccount";
    }

    @DeleteMapping("/leave")
    @ResponseBody
    public void deleteMember(HttpSession session) {
        MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
        profileService.leaveMember(loginMember.getId());
        session.invalidate();
    }

}