package org.genzo.spring.PP_2_3_1_spring_mvc_hibernate.controller;

import org.genzo.spring.PP_2_3_1_spring_mvc_hibernate.entity.User;
import org.genzo.spring.PP_2_3_1_spring_mvc_hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showAllUsers(Model model) {

        model.addAttribute("allUsrs", userService.getAllUsers());
        return "all-users";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "user-info";
    }

    @PostMapping("saveUser")
    public String saveUser(@ModelAttribute("user") User user) {

        userService.saveUser(user);

        return "redirect:/";
    }

    @GetMapping("/updateInfo")
    public String updateUser(@RequestParam("usrId") int id, Model model) {

        model.addAttribute("user", userService.getUser(id));

        return "user-info";

    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("usrId") int id) {

        userService.deleteUser(id);

        return "redirect:/";


    }

}
