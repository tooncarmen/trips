package be.kdg.trips.core.usecases;

import be.kdg.trips.core.boundries.UserRepository;
import be.kdg.trips.core.entities.Label;
import be.kdg.trips.core.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Login {
    private static final Logger LOGGER = LoggerFactory.getLogger(Login.class);
    UserRepository userRepository;

    public Login(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        LOGGER.info("Register request for {}", user.getUsername());
        if (userRepository.getUserByUsername(user.getUsername()).equals(null)) {
            LOGGER.info("- Registered for {}", user.getUsername());
            userRepository.register(user);
        }
        return user;
    }
    public boolean check(String email, String passwd){
        LOGGER.info("Credentials check for email {}", email);
        User u = userRepository.getUserByEmail(email);
        if(u.getPassword().equals(passwd)){
            LOGGER.info("- Credentials check OK");
            return true;
        }
        return false;
    }
}
