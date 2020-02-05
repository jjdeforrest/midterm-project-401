package io.romellpineda.memestagram.controllers;

import io.romellpineda.memestagram.models.Meme;
import io.romellpineda.memestagram.models.MemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    MemeRepository memeRepo;

    @GetMapping("/")
    public String index(Principal p, Model m) {
        if (p != null){
            m.addAttribute("username", p.getName());
        }
        List<Meme> allMemes = memeRepo.findAll();
        if (allMemes.size() == 0) {
            m.addAttribute("empty", true);
        }
        m.addAttribute("allMemes", allMemes);
        return "index";
    }


    @GetMapping("/signup")
    public String signUp() {

        return "signup";
    }

    @GetMapping("/login")
    public String showLoginForm(){

        return "login";
    }

    @GetMapping("/developers")
    public String showDevelopers(){

        return "developers";
    }

    @GetMapping("/signout")
    public String signout(){

        return "signout";
    }

    @GetMapping("/loggedinindex")
    public String loggedinindex(){

        return "loggedinindex";
    }

    @GetMapping("/loggedingenerator")
    public String loggedingenerator(){

        return "loggedingenerator";
    }

    @GetMapping("/loggedindevelopers")
    public String loggedindevelopers(){

        return "loggedindevelopers";
    }








}
