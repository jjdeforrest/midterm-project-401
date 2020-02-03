package io.romellpineda.memestagram.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;

@Entity
public class ApplicationUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

///////
    String username;
    String password;
    String profilePicture;
    String bio;
    String userCreated;
    String firstName;

    public ApplicationUser() {
    }



    public ApplicationUser(String username, String password, String profilePicture, String bio, String userCreated,String firstName) {
        this.username = username;
        this.password = password;
        this.profilePicture = profilePicture;
        this.bio = bio;
        this.userCreated = userCreated;
        this.firstName= firstName;
    }


    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
