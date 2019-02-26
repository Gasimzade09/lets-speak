package az.lets_speak.ms.lets_speak.restController;

import az.lets_speak.ms.lets_speak.dto.TeacherDTO;
import az.lets_speak.ms.lets_speak.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/student/get/teacher/{id}")
    public TeacherDTO getTeacher(@PathVariable int id){
        return service.getTeacherByStudentId(id);
    }
}
