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
        LOGGER.info("Register request for {}", user.getEmail());
        if (userRepository.getUserByEmail(user.getEmail()) == null) {
            LOGGER.info("- Registered for {}", user.getEmail());
            userRepository.register(user);
        }else{
            LOGGER.info("* Email {} is already taken", user.getEmail());
            throw new RuntimeException("Email is already taken");
        }
        return user;
    }

    public boolean check(String email, String passwd) {
        LOGGER.info("Credentials check for email {}", email);
        User u = userRepository.getUserByEmail(email);
        if (u.getPassword().equals(passwd)) {
            LOGGER.info("- Credentials check OK");
            return true;
        }
        return false;
    }

    public User getUserByEmail(String email) {
        LOGGER.info("getting user by email {}", email);
        return userRepository.getUserByEmail(email);
    }

    public User getUserById(int id) {
        LOGGER.info("getting user by id {}", id);
        return userRepository.getUserById(id);
    }
}
