package az.speak.ms.lets_speak.controller;

import az.speak.ms.lets_speak.dto.TeacherDTO;
import az.speak.ms.lets_speak.service.TeacherService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
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
