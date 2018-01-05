package com.mobiecode.mobieclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    /*@Autowired
    private RoleService roleService;

    @RequestMapping(value="/role", method = RequestMethod.GET)
    public ModelAndView getRole(){
        ModelAndView modelAndView = new ModelAndView();
        Role role = new Role();
        modelAndView.addObject("role", role);
        modelAndView.setViewName("role");
        return modelAndView;
    }

    @RequestMapping(value="/role", method = RequestMethod.POST)
    public ModelAndView createRole(@Valid Role role, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        roleService.saveRole(role);
        modelAndView.addObject("successMessage", "Role has been registered successfully");
        modelAndView.addObject("role", new Role());
        modelAndView.setViewName("role");
        return modelAndView;
    }*/


    @GetMapping(value = {"", "/dashboard"})
    public String getDashBoard(Model model) {
        return "index";
    }
}
