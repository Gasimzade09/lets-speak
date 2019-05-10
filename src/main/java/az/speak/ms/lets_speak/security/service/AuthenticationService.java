package az.speak.ms.lets_speak.security.service;

import az.speak.ms.lets_speak.dto.StudentDto;
import az.speak.ms.lets_speak.dto.UserDto;
import az.speak.ms.lets_speak.mappers.StudentMapper;
import az.speak.ms.lets_speak.model.StudentEntity;
import az.speak.ms.lets_speak.model.TeacherEntity;
import az.speak.ms.lets_speak.model.UserEntity;
import az.speak.ms.lets_speak.repository.ScheduleRepository;
import az.speak.ms.lets_speak.repository.StudentRepository;
import az.speak.ms.lets_speak.repository.TeacherRepository;
import az.speak.ms.lets_speak.repository.UserRepository;
import az.speak.ms.lets_speak.security.exceptions.AuthenticationException;
import az.speak.ms.lets_speak.security.model.Role;
import az.speak.ms.lets_speak.security.model.dto.JwtAuthenticationRequest;
import az.speak.ms.lets_speak.security.model.dto.JwtAuthenticationResponse;
import az.speak.ms.lets_speak.security.util.TokenUtils;
import az.speak.ms.lets_speak.service.EmailService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Random;

@Service
public class AuthenticationService {

    private final TokenUtils tokenUtils;

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final StudentRepository studentRepository;

    private final TeacherRepository teacherRepository;

    private final ScheduleRepository scheduleRepository;

    private final EmailService emailService;

    public AuthenticationService(
            TokenUtils tokenUtils,
            AuthenticationManager authenticationManager,
            UserRepository userRepository,
            StudentRepository studentRepository,
            TeacherRepository teacherRepository, ScheduleRepository scheduleRepository, EmailService emailService) {
        this.tokenUtils = tokenUtils;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.scheduleRepository = scheduleRepository;
        this.emailService = emailService;
    }

    public JwtAuthenticationResponse createAuthenticationToken(JwtAuthenticationRequest request) {
        authenticate(request.getUsername(), request.getPassword());
        String token = tokenUtils.generateToken(request.getUsername());
        UserEntity user = userRepository.getByEmail(request.getUsername());
        user.setToken(token);
        userRepository.save(user);

        //userRepository.setTokenByUsername(token, request.getUsername());
        return new JwtAuthenticationResponse(token, user.getRole(), userRepository.getByEmail(request.getUsername()).getPrivateId());
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
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //LocalDate birthDate = LocalDate.parse(studentDto.getBirthDate(), formatter);
        UserEntity checkEmail = userRepository.getByEmail(studentDto.getEmail());
        if (checkEmail == null && emailValidation(studentDto.getEmail())) {
            String password = new BCryptPasswordEncoder().encode(studentDto.getPassword());
            StudentEntity student = StudentMapper.dtoToEntity(studentDto);
            studentRepository.save(student);
            UserEntity userEntity = UserEntity.builder()
                                    .name(studentDto.getName())
                                    .surname(studentDto.getSurname())
                                    .email(studentDto.getEmail())
                                    //.birthDate(birthDate)
                                    .skype(student.getSkype())
                                    .phoneNumber(studentDto.getPhoneNumber())
                                    .password(password)
                                    .privateId(studentRepository.getIdByEmail(studentDto.getEmail()))
                                    .role(Role.ROLE_STUDENT.toString())
                                    .build();
            userRepository.save(userEntity);
            return userEntity;
        } else {
            throw new AuthenticationException("This email is already exists");
        }
    }

    public String passwordGenerator(){
        Random random = new Random();
        int len = (int) (Math.random()*10);
        return random.ints(48, 122)
                .filter(t -> (t < 57 || t > 65) && (t < 90 || t > 97))
                .mapToObj(t -> (char) t)
                .limit(10)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    public Integer signUpTeacher(String email, String name, String surname){
        UserEntity checkEmail = userRepository.getByEmail(email);
        String pass = passwordGenerator();
        if (checkEmail == null && emailValidation(email)) {
            String password = new BCryptPasswordEncoder().encode(pass);
            TeacherEntity teacherEntity = TeacherEntity.builder()
                                                        .email(email)
                                                        .name(name)
                                                        .surname(surname)
                                                        .build();
            teacherRepository.save(teacherEntity);
            System.out.println(pass);
            emailService.send(email, "Registration completing", "Your password is "+pass);
            UserEntity userEntity = UserEntity.builder()
                                                .name(name)
                                                .email(email)
                                                .surname(surname)
                                                .password(password)
                                                .privateId(teacherRepository.getIdByEmail(email))
                                                .role(Role.ROLE_TEACHER.toString()).build();


            userRepository.save(userEntity);

            return userRepository.getByEmail(email).getPrivateId();
        } else {
            throw new AuthenticationException("This email is already exists");
        }
    }

    public void logOut(String username) {
        userRepository.removeTokenByUsername(username);
    }

    public boolean resetPassword(UserDto userDto) {
        boolean reset = false;
        UserEntity userEntity = userRepository.getByEmail(userDto.getEmail());
        if (userDto.getEmail().equals(userEntity.getEmail())){
            reset = true;
            emailService.send(userDto.getEmail(), "Password was changed", "Hi "+userEntity.getName() + "! Your password was changed to "+userDto.getPassword());
            userEntity.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));
            userRepository.save(userEntity);
        }
        return reset;
    }
}
