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
}
