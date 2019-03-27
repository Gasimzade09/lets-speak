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
    public List<StudentDto> getStudentsByTeacherId(@PathVariable Integer id){
        return service.getStudentsByTeacherId(id);
    }

    @PostMapping(path = "/student/save", consumes = "application/json", produces = "application/json")
    public StudentDto saveStudent(StudentDto studentDto){
        return service.saveStudent(studentDto);
    }

    @GetMapping(path = "/get/id")
    public Integer getIdByEmail(@RequestParam String email){
        return service.getIdByEmail(email);
    }

    @GetMapping(path = "/student/get/{id}")
    public StudentDto getStudentById(@PathVariable Integer id){
        return service.getStudentById(id);
    }

    @PostMapping(path = "/set/student/rank/{id}/{rank}")
    public void setRank(@PathVariable Integer id, @PathVariable Double rank){
        service.setRank(id, rank);
    }
}