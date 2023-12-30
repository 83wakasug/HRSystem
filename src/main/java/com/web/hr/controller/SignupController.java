package com.web.hr.controller;


import com.web.hr.Constatnt.MessageConst;
import com.web.hr.Constatnt.SignupMessage;
import com.web.hr.entity.UserInfo;
import com.web.hr.form.SignupForm;
import com.web.hr.service.SignupService;
import com.web.hr.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public void Signup(Model model, @Validated SignupForm form, BindingResult bdResult){
        if(bdResult.hasErrors()){
            editGuideMessage(model,MessageConst.FORM_ERROR,true);
            return;
        }
        var userInfoOpt= service.resistUserInfo(form);
        var signupMessage = judgeMessageKey(userInfoOpt);
        editGuideMessage(model,signupMessage.getMessageID(), signupMessage.isError());

    }

    private void editGuideMessage(Model model,String messageID,boolean isError){
        var message = AppUtil.getMessage(messageSource,messageID);
        model.addAttribute("message",message);
        model.addAttribute("isError",isError);
    }

     private SignupMessage judgeMessageKey(Optional<UserInfo> userInfoOpt){
        if(userInfoOpt.isEmpty()){
            return SignupMessage.EXISTED_LOGIN_ID;
        }else{
            return SignupMessage.SUCCEED;
        }
     }

}
