package be.kdg.tripsspringapp.controllers;


import be.kdg.trips.core.entities.User;
import be.kdg.trips.core.usecases.Login;
import be.kdg.tripsspringapp.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("http://localhost:4200")
public class UserController {

    @Autowired
    private Login login;


    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public boolean login(@RequestBody UserDTO userDTO) {
        User u = userDTO.toEntity();
        return login.check(u.getUsername(), u.getPassword());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public UserDTO register(@RequestBody UserDTO userDTO) {
        User u = login.registerUser(userDTO.toEntity());
        return new UserDTO(u);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/id/{id}")
    public UserDTO register(@PathVariable("id") int id) {
        User u = login.getUserById(id);
        return new UserDTO(u);
    }

}
