package io.romellpineda.memestagram.controllers;

import io.romellpineda.memestagram.models.Meme;
import io.romellpineda.memestagram.models.MemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MemeController {

    @Autowired
    MemeRepository memeRepo;

    @PostMapping("/meme/add")
//    For future route
//    public RedirectView addMeme(String name, String url) {
    public void addMeme(String name, String url) {
        Meme freshMeme = new Meme(name, url);
        memeRepo.save(freshMeme);
        System.out.println("/////" + name + " " + url);
        System.out.println(freshMeme.name);
    }
}
