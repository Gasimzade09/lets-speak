package az.speak.ms.lets_speak.service;

import az.speak.ms.lets_speak.dto.StudentDto;
import az.speak.ms.lets_speak.mappers.StudentMapper;
import az.speak.ms.lets_speak.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> getStudentsByTeacherId(int id){
        List<StudentDto> dtos = StudentMapper.INSTANCE.studentListToStudentDtoList(studentRepository.getStudentsByTeacherId(id));
        return dtos;
    }


}
