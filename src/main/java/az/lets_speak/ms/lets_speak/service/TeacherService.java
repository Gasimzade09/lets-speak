package az.lets_speak.ms.lets_speak.service;

import az.lets_speak.ms.lets_speak.model.Student;
import az.lets_speak.ms.lets_speak.model.Teacher;
import az.lets_speak.ms.lets_speak.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher getTeacherByStudentId(int id){
        return teacherRepository.getTeacherByStudentId(id);
    }

    public List<Student> getStudentsByTeacherId(int id){
        return teacherRepository.getStudentsByTeacherId(id);
    }
}
