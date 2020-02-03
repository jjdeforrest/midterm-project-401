package io.romellpineda.memestagram.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Meme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String name;
    public String url;
    public int likes;
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    ApplicationUser appUser;

    public Meme() {}

    public Meme(String name, String url, int likes) {
        this.name = name;
        this.url = url;
        this.likes = likes;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
