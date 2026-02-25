package com.app.ggshop.v1.controller.profile;

import com.app.ggshop.v1.dto.MemberDTO;
import com.app.ggshop.v1.dto.profile.AddressDTO;
import com.app.ggshop.v1.dto.profile.NicknameDTO;
import com.app.ggshop.v1.dto.profile.PasswordDTO;
import com.app.ggshop.v1.dto.profile.ProfileDTO;
import com.app.ggshop.v1.service.profile.AlarmService;
import com.app.ggshop.v1.service.profile.ProfileService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/profile/")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;
    private final HttpSession session;
    private final AlarmService alarmService;

    @GetMapping("settings")
    public String profileMovement(Model model) {
        MemberDTO loginmember = (MemberDTO) session.getAttribute("loginMember");
        Long memberId = loginmember.getId();
        model.addAttribute("profileDTO", profileService.getProfile(memberId));
        model.addAttribute("nicknameDTO", profileService.getNickname(memberId));
        model.addAttribute("passwordDTO", profileService.getPassword(memberId));
        model.addAttribute("addressDTO", profileService.getAddress(memberId));
        return "myPageSettings/myPageSettings";
    }

    @PostMapping("update")
    @ResponseBody
    public String changeProfileImage(ProfileDTO profileDTO, @RequestParam("file") MultipartFile file) throws IOException {
        MemberDTO loginmember = (MemberDTO) session.getAttribute("loginMember");
        Long memberId = loginmember.getId();
        if (memberId == null) {
            return "fail: no session"; // 세션 만료 대응
        }
        profileDTO.setMemberId(memberId);
        profileService.changeProfileImage(profileDTO, file);
        return "success";
    }

    @PostMapping("update-nickname")
    @ResponseBody
    public String changeNickname(@RequestBody NicknameDTO nicknameDTO) {
        MemberDTO loginmember = (MemberDTO) session.getAttribute("loginMember");
        Long memberId = loginmember.getId();
        if (memberId == null) {
            return "fail: no session"; // 세션 만료 대응
        }
        nicknameDTO.setId(memberId);
        profileService.nicknameUpdate(nicknameDTO);
        return "success";
    }

    @PostMapping("update-password")
    @ResponseBody
    public String changePassword(@RequestBody PasswordDTO passwordDTO) {
        MemberDTO loginmember = (MemberDTO) session.getAttribute("loginMember");
        Long memberId = loginmember.getId();
        if (memberId == null) {
            return "fail: no session"; // 세션 만료 대응
        }
        passwordDTO.setId(memberId);
        profileService.passwordUpdate(passwordDTO);
        return "success";
    }

    @PostMapping("update-address")
    @ResponseBody
    public String changeAddress(@RequestBody AddressDTO addressDTO) {
        MemberDTO loginmember = (MemberDTO) session.getAttribute("loginMember");
        Long memberId = loginmember.getId();
        if (memberId == null) {
            return "fail: no session"; // 세션 만료 대응
        }
        addressDTO.setId(memberId);
        profileService.addressUpdate(addressDTO);
        return "success";
    }

    @GetMapping("settings/leaveConfirm")
    public String deletePageMovement() {
        MemberDTO MemberChk = (MemberDTO) session.getAttribute("loginMember");
        if (MemberChk != null) {
            return "deleteaccount/deleteaccount";
        }
        return "/";
    }

    @GetMapping("settings/alarmConfirm")
    public String alarmPageMovement(Model model) {
        MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
        if (loginMember == null) {
            return "/";
        }
        Long memberId = loginMember.getId();
        model.addAttribute("alarmDTO", alarmService.getAlarmStatus(memberId));
        return "MyPageSettings/notificationSetting";
    }

}
