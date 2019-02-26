package az.lets_speak.ms.lets_speak.service;

import az.lets_speak.ms.lets_speak.dto.TeacherDTO;
import az.lets_speak.ms.lets_speak.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    private TeacherDTO dto = new TeacherDTO();

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public TeacherDTO getTeacherByStudentId(int id){
        dto.setBirthDate(studentRepository.getTeacherByStudentId(id).getBirthDate());
        dto.setName(studentRepository.getTeacherByStudentId(id).getName());
        dto.setSurname(studentRepository.getTeacherByStudentId(id).getSurname());
        dto.setEmail(studentRepository.getTeacherByStudentId(id).getEmail());
        dto.setSkype(studentRepository.getTeacherByStudentId(id).getSkype());
        dto.setPhoneNumber(studentRepository.getTeacherByStudentId(id).getPhoneNumber());
        return dto;
    }
}
