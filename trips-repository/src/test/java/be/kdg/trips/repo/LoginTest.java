package be.kdg.trips.repo;

import be.kdg.trips.core.entities.User;
import be.kdg.trips.core.exceptions.NotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginTest {

    be.kdg.trips.core.boundries.UserRepository UserRepository;

    @Before
    public void setUp() throws Exception {
        UserRepository = new InMemoryUserRepo();
    }

    @Test
    public void testUserRegister() throws Exception {
        User newUser = new User("Bob Dylan","bdyllan@mail.com","123123");
        UserRepository.register(newUser);
        Assert.assertEquals("saved user should match given user", newUser,UserRepository.getUserByUsername("Bob Dylan"));
    }

    @Test(expected = NotFoundException.class)
    public void testWrongUserLoginFail() throws Exception {
       User x = UserRepository.getUserByUsername("NoOne");
    }
}
