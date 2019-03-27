package az.speak.ms.lets_speak.security.service;

import az.speak.ms.lets_speak.dto.StudentDto;
import az.speak.ms.lets_speak.dto.TeacherDTO;
import az.speak.ms.lets_speak.mappers.StudentMapper;
import az.speak.ms.lets_speak.mappers.TeacherMapper;
import az.speak.ms.lets_speak.model.ScheduleEntity;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        //userRepository.setTokenByUsername(token, request.getUsername());
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
            StudentEntity student = StudentMapper.dtoToEntity(studentDto);

            studentRepository.save(student);
            System.out.println(studentDto.getFreeDays().get(0));
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
            return setTeacherForStudent(studentDto, user);

        } else {
            throw new AuthenticationException("This email is already exists");
        }
    }

    public UserEntity setTeacherForStudent(StudentDto studentDto, UserEntity userEntity){
        List<ScheduleEntity> e = scheduleRepository.findAll();
        List<Integer> ids = new ArrayList<>();
        int i = 0;
        for (ScheduleEntity entity : e) {
            if (entity.getDate().getDayOfWeek().equals(studentDto.getFreeDays().get(i)) &&
                entity.getTime().equals(studentDto.getFreeTimes().get(i)))
                ids.add(entity.getId());
            i++;
        }
        return searchTeacherForStudent(ids, userEntity);
    }

    public UserEntity searchTeacherForStudent(List<Integer> ids, UserEntity userEntity){
        List<TeacherEntity> teachers = teacherRepository.findAll();
        List<String> emails = new ArrayList<>();
        ids.add(0);
        for (int i = 0; i < teachers.size(); i++) {
            for (int j = 0; j < ids.size(); j++) {
                if (!(teachers.get(i).getId().equals(ids.get(i))))
                    emails.add(teachers.get(i).getEmail());
            }
        }

        for (int i = 0; i < emails.size(); i++) {
            emailService.send(emails.get(i), "Apply new student", "Message");
            System.out.println("Send message");
        }
        return userEntity;
    }

    public UserEntity signUpTeacher(TeacherDTO teacherDTO){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(teacherDTO.getBirthDate(), formatter);
        UserEntity checkEmail = userRepository.getByEmail(teacherDTO.getEmail());
        if (checkEmail == null && emailValidation(teacherDTO.getEmail())) {
            String password = new BCryptPasswordEncoder().encode(teacherDTO.getPassword());
            UserEntity user = new UserEntity();
            TeacherEntity teacherEntity = TeacherMapper.dtoToEntity(teacherDTO);

            teacherRepository.save(teacherEntity);

            user.setName(teacherDTO.getName());
            user.setSurname(teacherDTO.getSurname());
            user.setEmail(teacherDTO.getEmail());
            user.setBirthDate(birthDate);
            user.setSkype(teacherDTO.getSkype());
            user.setPhoneNumber(teacherDTO.getPhoneNumber());
            user.setPassword(password);
            user.setPrivateId(teacherRepository.getIdByEmail(teacherDTO.getEmail()));
            user.setRole(Role.ROLE_TEACHER.toString());
            userRepository.save(user);
            return user;
        } else {
            throw new AuthenticationException("This email is already exists");
        }
    }

    public void logOut(String username) {
        userRepository.removeTokenByUsername(username);
    }
}
