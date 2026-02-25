package com.app.ggshop.v1.controller.error;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ErrorLocationController implements ErrorController {
    // 경로가 없을 경우 loginmember 감지하여 경로 이동
    @GetMapping()
    public RedirectView defaultErrPageMovement(HttpSession session) {
        return new RedirectView("/login/main");
    }
    // 에러 페이지 이동
    @GetMapping("/error")
    public String locationErrPageMovement() {
        return ("error/error");
    }

}
