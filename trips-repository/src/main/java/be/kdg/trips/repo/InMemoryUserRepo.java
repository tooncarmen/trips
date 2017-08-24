package be.kdg.trips.repo;

import be.kdg.trips.core.boundries.UserRepository;
import be.kdg.trips.core.exceptions.NotFoundException;
import be.kdg.trips.core.entities.User;

import java.util.*;

public class InMemoryUserRepo implements UserRepository {

    private List<User> users;

    public InMemoryUserRepo() {
        users = new ArrayList<>();
        seed();
    }

    @Override
    public User register(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<User> found = users.stream().filter(u -> u.getUsername().equals(username)).findFirst();
        if (!found.isPresent()) {
            throw new NotFoundException("User with username '" + username + "' not found");
        }
        return found.orElse(null);

    }

    @Override
    public User getUserByEmail(String email) {
        Optional<User> found = users.stream().filter(u -> u.getEmail().equals(email)).findFirst();
        if (!found.isPresent()) {
            throw new NotFoundException("User with email '" + email + "' not found");
        }
        return found.orElse(null);
    }

    private void seed() {
        User[] userSeed = {
                new User("James T kirk", "j.t.kirk@enterprise.uni", "Kirk"),
                new User("Luke Skywalker", "luke@jedytemple.uni", "luke")
        };
        Collections.addAll(users, userSeed);
    }
}
