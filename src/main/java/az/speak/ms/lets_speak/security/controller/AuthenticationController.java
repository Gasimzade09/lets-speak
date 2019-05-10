package az.speak.ms.lets_speak.security.controller;

import az.speak.ms.lets_speak.dto.StudentDto;
import az.speak.ms.lets_speak.dto.UserDto;
import az.speak.ms.lets_speak.model.UserEntity;
import az.speak.ms.lets_speak.security.model.dto.JwtAuthenticationRequest;
import az.speak.ms.lets_speak.security.model.dto.JwtAuthenticationResponse;
import az.speak.ms.lets_speak.security.service.AuthenticationService;
import az.speak.ms.lets_speak.service.EmailService;
import az.speak.ms.lets_speak.service.FileUploadService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "http://localhost:63342")
public class AuthenticationController {

    private final AuthenticationService service;
    private final EmailService emailService;
    private final FileUploadService fileUploadService;

    public AuthenticationController(AuthenticationService service, EmailService emailService, FileUploadService fileUploadService) {
        this.service = service;
        this.emailService = emailService;
        this.fileUploadService = fileUploadService;
    }

    @PutMapping("/auth")
    public JwtAuthenticationResponse signIn(@RequestBody JwtAuthenticationRequest request) {
        return service.createAuthenticationToken(request);
    }

    @PutMapping("/logout")
    public void logOut(@RequestParam String username){
        service.logOut(username);
    }

    @ApiOperation(value = "controller for student registration")
    @PostMapping("/reg/student")
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity signUpStudent(@RequestBody StudentDto student) {
        return service.signUp(student);
    }

    @ApiOperation(value = "controller for teacher registration")
    @RequestMapping(value="/reg/teacher/{email}/{name}/{surname}", method=RequestMethod.POST)
    public @ResponseBody void signUpTeacher(@PathVariable String email,
                                                  @PathVariable String name,
                                                  @PathVariable String surname,
                                                  @RequestParam("file") MultipartFile file) {
        Integer id = service.signUpTeacher(email, name, surname);
        fileUploadService.setCvForTeacher(id, file);
    }

    @ApiOperation(value = "Controller for reset password")
    @PutMapping("/reset/pass")
    public Boolean resetPassword(@RequestBody UserDto userDto){
        return service.resetPassword(userDto);

    }

}