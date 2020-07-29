package com.example.NameSelect.Controller;

import com.example.NameSelect.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NameController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/signup")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
