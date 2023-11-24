package com.web.hr.controller;

import com.web.hr.form.SignupForm;
import com.web.hr.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SignupController {

    private final SignupService service;

    @GetMapping("/signup")
    public String view(Model model, SignupForm form){
        return "signup";
    }


    @PostMapping("/signup")
    public String Signup(Model model, SignupForm form){
        var userInfoOpt= service.resistUserInfo(form);
        return "menu";
    }


}
