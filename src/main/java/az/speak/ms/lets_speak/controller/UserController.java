package az.speak.ms.lets_speak.controller;

import az.speak.ms.lets_speak.dto.UserDto;
import az.speak.ms.lets_speak.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/set/user/token/{username}/{token}")
    public void setTokenByUsername(@PathVariable String username, @PathVariable String token){
        userService.setTokenByUsername(username, token);
    }

    @PostMapping(path = "/delete/token/{username}")
    public void removeToken(@PathVariable String username){
        userService.deleteToken(username);
    }
<<<<<<< HEAD
=======

    @GetMapping(path = "/get/user/id/{id}/{role}")
    public UserDto getUser(@PathVariable Integer id, @PathVariable String role){
        return userService.getUserById(id, role);
    }

    @GetMapping(path="/users/get/all")
    public List<UserDto> getAll(){
        return userService.getlAll();
    }
>>>>>>> 544e5c54ddb5e164d8513dbf32ce9bdea74234e5
}
