package spbt.hstore.storage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spbt.hstore.storage.Forms.SignInForm;
import spbt.hstore.storage.services.UserServices;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class SIgnInController {

    @Autowired
    private UserServices userServices;

    @GetMapping(value = "/signIn")
    public String getSignInPage() {
        return "signIn";
    }

}
