package az.lets_speak.ms.lets_speak.restController;

import az.lets_speak.ms.lets_speak.model.Student;
import az.lets_speak.ms.lets_speak.model.Teacher;
import az.lets_speak.ms.lets_speak.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teacher/get/{id}")
    public Teacher getTeacherByStudentId(@PathVariable int id){
        return teacherService.getTeacherByStudentId(id);
    }

    @GetMapping("/teacher/get/students/{id}")
    public List<Student> getStudentsByTeacherId(@PathVariable int id){
        return teacherService.getStudentsByTeacherId(id);
    }
}
