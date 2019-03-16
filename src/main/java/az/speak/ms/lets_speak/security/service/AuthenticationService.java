package az.speak.ms.lets_speak.security.service;

import az.speak.ms.lets_speak.dto.StudentDto;
import az.speak.ms.lets_speak.mappers.StudentMapper;
import az.speak.ms.lets_speak.model.StudentEntity;
import az.speak.ms.lets_speak.model.UserEntity;
import az.speak.ms.lets_speak.repository.StudentRepository;
import az.speak.ms.lets_speak.repository.TeacherRepository;
import az.speak.ms.lets_speak.repository.UserRepository;
import az.speak.ms.lets_speak.security.exceptions.AuthenticationException;
import az.speak.ms.lets_speak.security.model.Role;
import az.speak.ms.lets_speak.security.model.dto.JwtAuthenticationRequest;
import az.speak.ms.lets_speak.security.model.dto.JwtAuthenticationResponse;
import az.speak.ms.lets_speak.security.util.TokenUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Service
public class AuthenticationService {

    private final TokenUtils tokenUtils;

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final StudentRepository studentRepository;

    private final TeacherRepository teacherRepository;

    public AuthenticationService(
            TokenUtils tokenUtils,
            AuthenticationManager authenticationManager,
            UserRepository userRepository,
            StudentRepository studentRepository,
            TeacherRepository teacherRepository) {
        this.tokenUtils = tokenUtils;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    public JwtAuthenticationResponse createAuthenticationToken(JwtAuthenticationRequest request) {

        authenticate(request.getUsername(), request.getPassword());

        String token = tokenUtils.generateToken(request.getUsername());

        return new JwtAuthenticationResponse(token);
    }

    public void authenticate(String username, String password) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new AuthenticationException("User is disabled", e);
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("Bad credentials", e);
        }
    }

    public boolean emailValidation(String email){
        boolean valid = email.matches("^[A-z0-9._%+-]+@[A-z0-9.-]+\\.[A-z]{2,6}$");
        return valid;
    }

    public UserEntity signUp(StudentDto studentDto){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(studentDto.getBirthDate(), formatter);
        UserEntity checkEmail = userRepository.getByEmail(studentDto.getEmail());
        if (checkEmail == null && emailValidation(studentDto.getEmail())) {
            String password = new BCryptPasswordEncoder().encode(studentDto.getPassword());
            UserEntity user = new UserEntity();
            StudentEntity student = new StudentEntity();
            student.setName(studentDto.getName());
            student.setSurname(studentDto.getSurname());
            student.setEmail(studentDto.getEmail());
            student.setPhoneNumber(studentDto.getPhoneNumber());
            student.setSkype(studentDto.getSkype());
            student.setBirthDate(birthDate);

            studentRepository.save(student);

            user.setName(studentDto.getName());
            user.setSurname(studentDto.getSurname());
            user.setEmail(studentDto.getEmail());
            user.setBirthDate(birthDate);
            user.setSkype(studentDto.getSkype());
            user.setPhoneNumber(studentDto.getPhoneNumber());
            user.setPassword(password);
            user.setPrivateId(studentRepository.getIdByEmail(studentDto.getEmail()));
            user.setRole(Role.ROLE_STUDENT.toString());
            userRepository.save(user);
            return user;
        } else {
            throw new AuthenticationException("This email is already exists");
        }
    }
}
