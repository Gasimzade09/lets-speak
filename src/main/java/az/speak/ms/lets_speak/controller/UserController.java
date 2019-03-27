package az.speak.ms.lets_speak.controller;

import az.speak.ms.lets_speak.service.UserService;
import org.springframework.web.bind.annotation.*;

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
}
