package az.speak.ms.lets_speak.Controller;

import az.speak.ms.lets_speak.dto.TeacherDTO;
import az.speak.ms.lets_speak.service.TeacherService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Api(value = "/api", description = "Операции с профилем")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/student/get/teacher/{id}")
    public TeacherDTO getTeacherByStudentId(@PathVariable int id){
        return teacherService.getTeacherByStudentId(id);
    }
}
