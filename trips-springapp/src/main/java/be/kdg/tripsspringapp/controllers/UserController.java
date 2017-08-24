package be.kdg.tripsspringapp.controllers;


import be.kdg.trips.core.entities.User;
import be.kdg.trips.core.usecases.Login;
import be.kdg.tripsspringapp.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private Login login;


    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public boolean login(@RequestBody UserDTO userDTO) {
        return login.check(userDTO.email, userDTO.password);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public UserDTO register(@RequestBody UserDTO userDTO) {
        User u = login.registerUser(userDTO.toEntity());
        return new UserDTO(u);
    }


}
