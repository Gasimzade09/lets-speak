package az.lets_speak.ms.lets_speak.service;

import az.lets_speak.ms.lets_speak.dto.StudentDto;
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
        List<StudentEntity> students = studentRepository.getStudentsByTeacherId(id);
        List<StudentDto> studentsDto = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            dto.setName(students.get(i).getName());
            dto.setSurname(students.get(i).getSurname());
            dto.setEmail(students.get(i).getEmail());
            dto.setSkype(students.get(i).getSkype());
            dto.setPhoneNumber(students.get(i).getPhoneNumber());
            dto.setBirthDate(students.get(i).getBirthDate());
            studentsDto.add(dto);
        }
        return studentsDto;
    }


}
