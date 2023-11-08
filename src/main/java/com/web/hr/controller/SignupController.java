package com.web.hr.controller;

import com.web.hr.form.SignupForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    @GetMapping("/signup")
    public String view(Model model, SignupForm form){
        return "signup";
    }


    @PostMapping("/signup")
    public String Signup(Model model, SignupForm form){
        return "menu";
    }


}
