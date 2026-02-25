package com.app.ggshop.v1.controller.my;

import com.app.ggshop.v1.dto.MemberDTO;
import com.app.ggshop.v1.service.profile.ProfileService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/profile/")
@RequiredArgsConstructor
@Slf4j
public class MyController {
    private final ProfileService profileService;
    private final HttpSession session;

    @GetMapping("main")
    public String myMovement(Model model) {
        MemberDTO loginmember = (MemberDTO) session.getAttribute("loginMember");
        Long memberId = loginmember.getId();
        model.addAttribute("profileDTO", profileService.getProfile(memberId));
        model.addAttribute("nicknameDTO", profileService.getNickname(memberId));
        model.addAttribute("addressDTO", profileService.getAddress(memberId));

        return "userProfile/profile";
    }

}
