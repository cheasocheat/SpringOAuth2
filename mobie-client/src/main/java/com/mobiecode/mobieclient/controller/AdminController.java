package com.mobiecode.mobieclient.controller;

import com.mobiecode.domain.entity.Role;
import com.mobiecode.mobieclient.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
public class AdminController {

    @Autowired
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
    }
}
