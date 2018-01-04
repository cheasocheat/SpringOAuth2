package com.mobiecode.mobieclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Developer : cheasocheat
 * Created on 1/5/18 00:22
 */
@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String getWelcomePage(Model model){
        model.addAttribute("message", "Big olo");
        return "index";
    }
}
