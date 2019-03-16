package az.speak.ms.lets_speak.controller;

import az.speak.ms.lets_speak.dto.StudentDto;
import az.speak.ms.lets_speak.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/teacher/get/students/{id}")
    public List<StudentDto> getStudentsByTeacherId(@PathVariable int id){
        return service.getStudentsByTeacherId(id);
    }

    @PostMapping(path = "/student/save", consumes = "application/json", produces = "application/json")
    public StudentDto saveStudent(StudentDto studentDto){
        return service.saveStudent(studentDto);
    }

    @GetMapping(path = "/get/id/{email}")
    public Integer getIdByEmail(@PathVariable String email){
        return service.getIdByEmail(email);
    }
}