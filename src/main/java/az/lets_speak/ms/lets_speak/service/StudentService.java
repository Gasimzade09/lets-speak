package az.lets_speak.ms.lets_speak.service;

import az.lets_speak.ms.lets_speak.dto.StudentDto;
import az.lets_speak.ms.lets_speak.mappers.StudentMapper;
import az.lets_speak.ms.lets_speak.model.StudentEntity;
import az.lets_speak.ms.lets_speak.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private StudentDto dto = new StudentDto();

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> getStudentsByTeacherId(int id){
        List<StudentDto> dtos = StudentMapper.INSTANCE.studentListToStudentDtoList(studentRepository.getStudentsByTeacherId(id));
        return dtos;
    }


}
