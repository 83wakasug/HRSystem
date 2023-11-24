package com.web.hr.controller;

import com.web.hr.Constatnt.ErrorMessageConst;
import com.web.hr.form.LoginForm;
import com.web.hr.service.LoginService;
import com.web.hr.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Login Controller
 */

@Controller
@RequiredArgsConstructor
public class LoginController {

    /**Login screen service*/
     private final LoginService loginService;

    /**PasswordEncoder*/
    private final PasswordEncoder passwordEncoder;
    private final MessageSource messageSource;

    /**
     *
     * @param model  model
     * @param form input info
     * @return display
     */
    @GetMapping("/login")
    public String menu(Model model, LoginForm form){

        return "login";
    }

    /**
     *
     * @param model model
     * @param form input info
     * @return login display
     */
    @PostMapping("/login")
    public String login(Model model,LoginForm form){
        var userInfo = loginService.searchUserByID(form.getLoginId());
        var isCorrectUserAuth=userInfo.isPresent()&& passwordEncoder.matches(form.getPassword(),userInfo.get().getPassword());
     if(isCorrectUserAuth){
         return "redirect:/menu";
     }else{
            var errorMsg = AppUtil.getMessage(messageSource, ErrorMessageConst.LOGIN_WRONG_INPUT);
            model.addAttribute("errorMsg",errorMsg);
        }
        return "login";
    }



}
