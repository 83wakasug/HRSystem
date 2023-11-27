package com.web.hr.controller;

import com.web.hr.Constatnt.MessageConst;
import com.web.hr.form.SignupForm;
import com.web.hr.service.SignupService;
import com.web.hr.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SignupController {

    private final SignupService service;
    private final MessageSource messageSource;

    @GetMapping("/signup")
    public String view(Model model, SignupForm form){
        return "signup";
    }


    @PostMapping("/signup")
    public void Signup(Model model, SignupForm form) {
        var userInfoOpt = service.resistUserInfo(form);

        if (userInfoOpt.isEmpty()) {
            var errorMsg = AppUtil.getMessage(messageSource, MessageConst.SIGNUP_EXISTED_LOGIN_ID);
            model.addAttribute("message",errorMsg);
        }
        else{
            var message = AppUtil.getMessage(messageSource, MessageConst.SIGNUP_RESIST_SUCCEED);
                    model.addAttribute("message",message);
        }

    }
}
