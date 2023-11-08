package com.web.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 *Menu Controller
 *
 *
 *
 *
 */
@Controller
public class MenuContoller {

    /**
     * First page
     * @return display
     */
    @GetMapping("/menu")
    public String toString() {
        return "menu";
    }
}
