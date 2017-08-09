package be.kdg.trips.core.usecases;

import be.kdg.trips.core.boundries.UserRepository;
import be.kdg.trips.core.entities.User;

public class Login {
    UserRepository userRepository;

    public User registerUser(User user) {
        if (userRepository.getUserByUsername(user.getUsername()).equals(null)) {
            userRepository.register(user);
        }
        return user;
    }
    public boolean Login(String email, String passwd){
        User u = userRepository.getUserByEmail(email);
        if(u.getPassword().equals(passwd)) return true;
        return false;
    }
}
