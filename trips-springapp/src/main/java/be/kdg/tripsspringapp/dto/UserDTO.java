package be.kdg.tripsspringapp.dto;

import be.kdg.trips.core.entities.User;

public class UserDTO {
    public String password;
    public String email;
    public String username;

    public UserDTO(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public User toEntity() {
        return new User(username, email, password);
    }
}
