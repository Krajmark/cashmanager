package com.krajmark.cashmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManualTestController {
    @GetMapping("/asd")
    public String manualTestEndpoint(Model model) {
        model.addAttribute("asd_attr", "ASD");
        return "asd";
    }

    @GetMapping( "/asds")
    public String manualTestEndpointAuth() {
        return "asd_success";
    }
}
