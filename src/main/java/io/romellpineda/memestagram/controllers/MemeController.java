package io.romellpineda.memestagram.controllers;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import io.romellpineda.memestagram.models.ApplicationUser;
import io.romellpineda.memestagram.models.ApplicationUserRepository;
import io.romellpineda.memestagram.models.Meme;
import io.romellpineda.memestagram.models.MemeRepository;
import io.romellpineda.memestagram.service.AmazonClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Principal;

@Controller
public class MemeController {

    private AmazonClient amazonClient;

    @Autowired
    MemeController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

    @Autowired
    ApplicationUserRepository appUserRepo;

    @Autowired
    MemeRepository memeRepo;

    boolean displayDiv = false;

    @GetMapping("/generator")
    public String getToGenerator(Model m, boolean a) {
        m.addAttribute("displayDiv", a);
        return "generator";
    }

    @PostMapping("/generator")
    public RedirectView generateMeme(String linkMeme, String textToAdd, String name, Model m, Principal p) throws IOException {
        final BufferedImage image = ImageIO.read(new URL(linkMeme));
        if (image == null) {

            System.out.println("----->" + textToAdd);
            displayDiv = true;
            m.addAttribute("displayDiv", true);
            return new RedirectView("/generator?a=true");
        }
        System.out.println("are u here?");
        Graphics g = null;

        if (image != null) {
            g = image.getGraphics();
        }
        g.setFont(g.getFont().deriveFont(30f));
        g.drawString(textToAdd, 100, 100);
        g.dispose();

        try {
            File memeGenerated = new File(name + ".png");
            ImageIO.write(image, "png", memeGenerated);
            String fileName = this.amazonClient.uploadGeneratedMeme(memeGenerated);

            ApplicationUser poster = appUserRepo.findByUsername(p.getName());
            Meme freshMeme = new Meme(poster, name, fileName);
            poster.memes.add(freshMeme);
            appUserRepo.save(poster);
            memeRepo.save(freshMeme);
            return new RedirectView("/");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new RedirectView("/generator");
    }

    @GetMapping("/delete/{id}")
    public RedirectView deleteMeme(@PathVariable long id) {

        memeRepo.deleteById(id);
        return new RedirectView("/");
    }
}
