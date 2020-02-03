package io.romellpineda.memestagram.models;

public class ApplicationUser {

    String username;
    String password;
    String profilePicture;
    String bio;
    String userCreated;

    public ApplicationUser() {
    }

    public ApplicationUser(String username, String password, String profilePicture, String bio, String userCreated) {
        this.username = username;
        this.password = password;
        this.profilePicture = profilePicture;
        this.bio = bio;
        this.userCreated = userCreated;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getBio() {
        return bio;
    }

    public String getUserCreated() {
        return userCreated;
    }
}
