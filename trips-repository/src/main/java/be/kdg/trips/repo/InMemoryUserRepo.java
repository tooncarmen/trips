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
        user.setId(users.size());
        System.out.println("added: " + user.getId() + ":" + user.getUsername());
        users.add(user);
        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        System.out.println("try to find " + username);
        Optional<User> found = users.stream().filter(u -> u.getUsername().equals(username)).findFirst();
        return found.orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        System.out.println("Finding Email:" + email);
        Optional<User> found = users.stream().filter(u -> u.getEmail().equals(email)).findFirst();
        return found.orElse(null);
    }

    @Override
    public User getUserById(int id) {
        Optional<User> found = users.stream().filter(u -> u.getId() == (id)).findFirst();
        return found.orElse(null);
    }

    private void seed() {
        User[] userSeed = {
                new User("James T kirk", "j.t.kirk@enterprise.uni", "Kirk"),
                new User("test", "test@test.be", "nothing"),
                new User("Luke Skywalker", "luke@jedytemple.uni", "luke")
        };
        for (User user : userSeed) {
            register(user);

        }

    }
}
