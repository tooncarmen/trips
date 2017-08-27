package be.kdg.trips.core.boundries;

import be.kdg.trips.core.entities.User;

public interface UserRepository {
   User register(User user);
   User getUserByUsername(String username);
   User getUserByEmail(String email);
   User getUserById(int id);

}
