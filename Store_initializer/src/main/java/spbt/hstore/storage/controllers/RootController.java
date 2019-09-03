package spbt.hstore.storage.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String getRootPage(Authentication authentication) {
        if (authentication != null){
            return "redirect:/itemsPage";
        } else {
            return "redirect:/signIn";
        }
    }
}
