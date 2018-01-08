package com.mobiecode.mobieclient.controller;

import com.mobiecode.core.service.RoleService;
import com.mobiecode.core.service.UserService;
import com.mobiecode.domain.entity.Role;
import com.mobiecode.domain.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Developer : cheasocheat
 * Created on 1/5/18 00:22
 */
@Controller
public class HomeController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = {"/role"}, method = RequestMethod.GET)
    public String getRolePage(Model model) {
        model.addAttribute("role", new Role());
        return "role";
    }

    @RequestMapping(value = {"/role"}, method = RequestMethod.POST)
    public String createRole(@Valid Role role, Model model) {
        logger.info(role.getName());
        roleService.saveRole(role);
        model.addAttribute("role", new Role());
        model.addAttribute("successMessage", "Big olo");
        return "role";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public String getRegisterPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getListRoles());
        return "register";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public String registerUser(@Valid User user, BindingResult result, Model model) {
        logger.info(user.getFirstName());
        User tmpUser = userService.findByUsername(user.getUsername());
        if (tmpUser != null) {
            result
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");

        } else {
            userService.saveUser(user);
        }
        model.addAttribute("successMessage", "Created!");
        return "register";
    }


    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String getHomePage(Model model) {
        model.addAttribute("message", "Big olo");
        return "index";
    }

    @RequestMapping(value = {"/about"}, method = RequestMethod.GET)
    public String getAboutPage(Model model) {
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
