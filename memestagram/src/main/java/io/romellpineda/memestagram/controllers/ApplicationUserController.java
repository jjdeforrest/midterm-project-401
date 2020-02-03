package io.romellpineda.memestagram.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ApplicationUserController {

    @Autowired
    ApplicationUserController applicationUserController;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //@PostMapping("/signup")
    // YOUR CODE GOES HERE

}
