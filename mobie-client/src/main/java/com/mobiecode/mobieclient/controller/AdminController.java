package com.mobiecode.mobieclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @GetMapping(value = {"", "/dashboard"})
    public String getDashBoard(Model model) {
        return "admin/dashboard";
    }
}
