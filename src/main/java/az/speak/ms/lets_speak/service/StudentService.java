package az.speak.ms.lets_speak.service;

import az.speak.ms.lets_speak.dto.StudentDto;
import az.speak.ms.lets_speak.mappers.StudentMapper;
import az.speak.ms.lets_speak.model.StudentEntity;
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

    public StudentDto saveStudent(StudentDto studentDto){
        StudentEntity studentEntity = StudentMapper.INSTANCE.dtoToStudentEntity(studentDto);
        return StudentMapper.INSTANCE.studentToStudentDto(studentRepository.save(studentEntity));
    }

    public void setRank(double rank, int id){
        studentRepository.setRank(rank, id);
    }

    public Integer getIdByEmail(String email){
        return studentRepository.getIdByEmail(email);
    }
}
