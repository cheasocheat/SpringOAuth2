package com.mobiecode.mobieclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Developer : cheasocheat
 * Created on 1/5/18 00:22
 */
@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String getHomePage(Model model){
        model.addAttribute("message", "Big olo");
        return "index";
    }

    @RequestMapping(value = {"/about"}, method = RequestMethod.GET)
    public String getAboutPage(Model model){
        model.addAttribute("message", "Big olo");
        return "about";
    }

    @GetMapping(value = {"/login"})
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        return "login";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }
}
