package com.krajmark.cashmanager.controller;

import com.krajmark.cashmanager.dto.RegisterFormUserDTO;
import com.krajmark.cashmanager.service.UserManagementService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserManagementController {

    private final UserManagementService userManagementService;

    public UserManagementController(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    @GetMapping("/register")
    public String registerView(
            Model model,
            @ModelAttribute String usernameAlreadyInUse,
            @ModelAttribute RegisterFormUserDTO user
    ) {
        if (!usernameAlreadyInUse.isBlank()) {
            model.addAttribute("usernameAlreadyInUse", usernameAlreadyInUse);
            model.addAttribute("user", user);
        } else {
            model.addAttribute("user", new RegisterFormUserDTO("", ""));
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerAction(
            Model model,
            @Valid @ModelAttribute RegisterFormUserDTO user,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        if (this.userManagementService.userAlreadyExists(user)) {
            String usernameAlreadyInUse = "Username already in use";
            redirectAttributes.addFlashAttribute(usernameAlreadyInUse);
            redirectAttributes.addFlashAttribute(user);
            return "redirect:/register";
        }
        if (this.userManagementService.registerUser(user)) {
            redirectAttributes.addFlashAttribute(user);
            return "redirect:/login";
        }
        return "redirect:/register";
    }

    @GetMapping("/login")
    public String loginView(Model model, @ModelAttribute RegisterFormUserDTO user) {
        if (user.username() != null) {
            model.addAttribute("user", user);
        } else {
            model.addAttribute("user", new RegisterFormUserDTO("", ""));
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginAction(@ModelAttribute RegisterFormUserDTO user) {
        if (this.userManagementService.userAlreadyExists(user)) {
            return "redirect:/login";
        }
        if (this.userManagementService.registerUser(user)) {
            return "redirect:/login";
        }
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String loadLogoutPage() {

        return "temp_logout";
    }
}
