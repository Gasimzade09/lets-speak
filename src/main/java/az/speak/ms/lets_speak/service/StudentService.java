package az.speak.ms.lets_speak.service;

import az.speak.ms.lets_speak.dto.StudentDto;
import az.speak.ms.lets_speak.mappers.StudentMapper;
import az.speak.ms.lets_speak.model.StudentEntity;
import az.speak.ms.lets_speak.repository.StudentRepository;
import az.speak.ms.lets_speak.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;

    public StudentService(StudentRepository studentRepository, UserRepository userRepository) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
    }

    public List<StudentDto> getStudentsByTeacherId(Integer id){
        return StudentMapper.entityListToDtoList(studentRepository.getStudentsByTeacherId(id));

    }

    public StudentDto saveStudent(StudentDto studentDto){
        StudentEntity studentEntity = StudentMapper.dtoToEntity(studentDto);
        return StudentMapper.entityToDto(studentRepository.save(studentEntity));
    }

    public void setRank(Integer id, Double rank){
        studentRepository.setRank(id, rank);
    }

    public Integer getIdByEmail(String email){
        System.out.println(email + " " + studentRepository.getIdByEmail(email));
        return studentRepository.getIdByEmail(email);
    }

    public StudentDto getStudentById(Integer id) {
        return StudentMapper.entityToDto(studentRepository.getOne(id));
    }
}
