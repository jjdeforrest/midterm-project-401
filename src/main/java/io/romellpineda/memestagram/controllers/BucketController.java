package io.romellpineda.memestagram.controllers;

import io.romellpineda.memestagram.service.AmazonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/storage/")
public class BucketController {

    private AmazonClient amazonClient;

    @Autowired
    BucketController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

    @PostMapping("/uploadFile")
    public RedirectView uploadFile(@RequestParam("file") MultipartFile file) {

        String fileName = this.amazonClient.uploadFile(file);
        System.out.println("fileName = " + fileName);
        return new RedirectView("/");
    }

    @DeleteMapping("/deleteFile")
    public String deleteFile(@RequestParam(value = "url") String fileUrl) {
        return this.amazonClient.deleteFileFromS3(fileUrl);
    }

}