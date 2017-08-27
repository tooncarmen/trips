package be.kdg.tripsspringapp.dto;

import be.kdg.trips.core.entities.User;
import org.springframework.hateoas.ResourceSupport;

public class UserDTO extends ResourceSupport {
    public String password;
    public String email;
    public String username;

    public UserDTO() {
    }

    public UserDTO(String password, String email, String username) {
        this.password = password;
        this.email = email;
        this.username = username;
    }

    public UserDTO(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public User toEntity() {
        return new User(username, email, password);
    }
}
