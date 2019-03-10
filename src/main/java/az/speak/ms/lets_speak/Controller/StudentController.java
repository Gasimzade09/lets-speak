package az.speak.ms.lets_speak.Controller;

import az.speak.ms.lets_speak.dto.StudentDto;
import az.speak.ms.lets_speak.service.StudentService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Api(value = "/api", description = "Операции с профилем")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/teacher/get/students/{id}")
    public List<StudentDto> getStudentsByTeacherId(@PathVariable int id){
        return service.getStudentsByTeacherId(id);
    }
}
