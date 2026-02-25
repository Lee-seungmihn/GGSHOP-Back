package com.app.ggshop.v1.controller.car;

import com.app.ggshop.v1.common.enumeration.CarFilter;
import com.app.ggshop.v1.dto.MemberDTO;
import com.app.ggshop.v1.dto.car.CarDTO;
import com.app.ggshop.v1.service.car.CarService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile/settings/**")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;
    private final HttpSession session;

    @GetMapping("car")
    public String carMovement(Model model) {
        MemberDTO loginmember = (MemberDTO) session.getAttribute("loginMember");
        Long memberId = loginmember.getId();
        model.addAttribute("carDTO", carService.getCar(memberId));
        return "/carSettings/carSettings";
    }

    @PostMapping("register-car")
    @ResponseBody
    public String registerCar(@RequestBody CarDTO carDTO) {
        MemberDTO loginmember = (MemberDTO) session.getAttribute("loginMember");
        Long memberId = loginmember.getId();
        if (memberId == null) return "fail: no session";
        carDTO.setCarMemberId(memberId);
        if (carDTO.getCarFilter() == null) {
             carDTO.setCarFilter(CarFilter.ONEWAY);
        }

        carService.registerCar(carDTO.toCarVO());
        return "success";
    }

    @PostMapping("delete-car")
    @ResponseBody
    public String deleteCar() {
        MemberDTO loginmember = (MemberDTO) session.getAttribute("loginMember");
        Long memberId = loginmember.getId();
        if (memberId == null) {
            return "fail: no session";
        }
        carService.deleteCar(memberId);
        return "success";
    }


}
