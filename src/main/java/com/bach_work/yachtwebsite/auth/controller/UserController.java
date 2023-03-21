package com.bach_work.yachtwebsite.auth.controller;
import com.bach_work.yachtwebsite.auth.model.Role;
import com.bach_work.yachtwebsite.auth.model.Status;
import com.bach_work.yachtwebsite.auth.model.User;
import com.bach_work.yachtwebsite.auth.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }
    @PostMapping("/process_register")
    public String addUser(User user, Model model) {
        User userFromDb = userService.findByEnterEmail(user.getEmail());
        if (userFromDb == null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            user.setRole(Role.USER);
            user.setStatus(Status.ACTIVE);
            userService.saveUser(user);
            return "/login";
        }else{
            model.addAttribute("UserAlreadyExist", true);
            return "/registration";
        }
    }

}