package be.kdg.tripsspringapp.dto;

import be.kdg.trips.core.entities.User;
import org.springframework.hateoas.ResourceSupport;

public class UserDTO extends ResourceSupport {
    private int id;
    private String password;
    private String email;
    private String username;

    public UserDTO() {
    }

    public UserDTO(int id, String password, String email, String username) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.username = username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
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
