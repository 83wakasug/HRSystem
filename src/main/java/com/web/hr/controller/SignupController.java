package com.web.hr.controller;


import com.web.hr.Constatnt.MessageConst;
import com.web.hr.entity.UserInfo;
import com.web.hr.form.SignupForm;
import com.web.hr.service.SignupService;
import com.web.hr.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

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
    public void Signup(Model model, SignupForm form){
        var userInfoOpt= service.resistUserInfo(form);

            var message = AppUtil.getMessage(messageSource, judgeMessageKey(userInfoOpt));
            model.addAttribute("message",message);

    }

     private String judgeMessageKey(Optional<UserInfo> userInfoOpt){
        if(userInfoOpt.isEmpty()){
            return MessageConst.SIGNUP_EXISTED_LOGIN;
        }else{
            return MessageConst.SIGNUP_RESIST_SUCCEED;
        }
     }

}
