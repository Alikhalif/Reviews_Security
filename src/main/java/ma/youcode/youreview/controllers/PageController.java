package ma.youcode.youreview.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class PageController {
    
    @GetMapping
    public String home(Model model) {
        model.addAttribute("authenticatedUserName", SecurityContextHolder.getContext().getAuthentication().getName());
        return "index";
    }

    @GetMapping("/404")
    public String notFound() {
        return "404";
    }
    
}
