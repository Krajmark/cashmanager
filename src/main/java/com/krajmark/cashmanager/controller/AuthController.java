package com.krajmark.cashmanager.controller;

import com.krajmark.cashmanager.requests.SignupRequest;
import com.krajmark.cashmanager.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String signup(Model model) {
        SignupRequest signupRequest = new SignupRequest();
        model.addAttribute("signupRequest", signupRequest);
        return "register";
    }

    @PostMapping
    public String register(@ModelAttribute("signupRequest") SignupRequest signupRequest) {
        userService.register(signupRequest);
        return "redirect:/login";
    }
}
