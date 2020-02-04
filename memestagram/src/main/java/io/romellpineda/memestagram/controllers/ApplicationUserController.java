package io.romellpineda.memestagram.controllers;

import io.romellpineda.memestagram.models.ApplicationUser;
import io.romellpineda.memestagram.models.ApplicationUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;

@Controller
public class ApplicationUserController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public RedirectView createNewApplicationUser(String username, String password, String profilePicture,
                                                 String bio, String firstName){
        ApplicationUser newUser = new ApplicationUser(username, passwordEncoder.encode(password), profilePicture, bio
                , firstName);

        applicationUserRepository.save(newUser);

        Authentication authentication = new UsernamePasswordAuthenticationToken(newUser, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new RedirectView("/profile");
    }

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @GetMapping("/users/{id}")
    public String showUserDetails(@PathVariable long id, Principal p, Model m){
        ApplicationUser usernameWeAreVisiting = applicationUserRepository.findById(id).get();

        m.addAttribute("usernameWeAreVisiting", usernameWeAreVisiting);
        m.addAttribute("principalName", p.getName());
        return "public-view";
    }

    @GetMapping("/profile")
    public String showMyProfile(Principal p, Model m){
        ApplicationUser loggedInUser = applicationUserRepository.findByUsername(p.getName());

        m.addAttribute("user", loggedInUser);
        return "profile";
    }
}
