package az.speak.ms.lets_speak.service;

import az.speak.ms.lets_speak.dto.TeacherDTO;
import az.speak.ms.lets_speak.mappers.TeacherMapper;
import az.speak.ms.lets_speak.model.StudentEntity;
import az.speak.ms.lets_speak.model.TeacherEntity;
import az.speak.ms.lets_speak.repository.StudentRepository;
import az.speak.ms.lets_speak.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    private TeacherDTO dto = new TeacherDTO();

    public TeacherService(TeacherRepository teacherRepository, StudentRepository studentRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    public TeacherEntity getTeacherById(int id){

        return teacherRepository.getOne(id);
    }

    public TeacherDTO getTeacherByStudentId(int id){
        StudentEntity student = studentRepository.getOne(id);
        dto = TeacherMapper.entityToDto(teacherRepository.getByStudents(student));
        return dto;
    }

    public Integer getIdByEmail(String email) {
        return teacherRepository.getIdByEmail(email);
    }
}
