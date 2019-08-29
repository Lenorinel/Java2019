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

    @PostMapping(value = "/signIn")
    public String singIn(SignInForm form, HttpServletResponse response){
        userServices.signIn(form);

        Optional<String> cookieCandidate = userServices.signIn(form);
        if (cookieCandidate.isPresent()){
            Cookie cookie = new Cookie("clientId", cookieCandidate.get());
            response.addCookie(cookie);
            return "redirect:/workPlace";
        }
        else return "redirekt:/signIn";
    }
}
