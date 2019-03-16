package az.speak.ms.lets_speak.security.controller;

import az.speak.ms.lets_speak.dto.StudentDto;
import az.speak.ms.lets_speak.dto.UserDto;
import az.speak.ms.lets_speak.model.UserEntity;
import az.speak.ms.lets_speak.security.model.dto.JwtAuthenticationRequest;
import az.speak.ms.lets_speak.security.model.dto.JwtAuthenticationResponse;
import az.speak.ms.lets_speak.security.service.AuthenticationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "http://localhost:63342")
public class AuthenticationController {

    private final AuthenticationService service;

    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @PutMapping("/auth")
    public JwtAuthenticationResponse signIn(@RequestBody JwtAuthenticationRequest request) {
        return service.createAuthenticationToken(request);
    }

    @ApiOperation(value = "controller for registration")
    @PostMapping("/reg/student")
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity signUp(@RequestBody StudentDto student) {
        return service.signUp(student);
    }

}