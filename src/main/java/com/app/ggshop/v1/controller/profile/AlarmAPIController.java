package com.app.ggshop.v1.controller.profile;

import com.app.ggshop.v1.dto.MemberDTO;
import com.app.ggshop.v1.dto.profile.AlarmDTO;
import com.app.ggshop.v1.service.profile.AlarmService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alarm")
@RequiredArgsConstructor
@Slf4j
public class AlarmAPIController {

    private final AlarmService alarmService;
    private final HttpSession session;

    @PostMapping("/confirm")
    public String confirmAlarm(@RequestBody AlarmDTO alarmDTO) {
        MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");

        if (loginMember == null) {
            return "fail: no session";
        }

        alarmDTO.setMemberId(loginMember.getId());
        alarmService.ConfirmAlarm(alarmDTO);
        return "success";
    }

}
