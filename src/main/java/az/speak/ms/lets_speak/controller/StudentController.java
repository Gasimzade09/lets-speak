package az.speak.ms.lets_speak.controller;

import az.speak.ms.lets_speak.dto.OrderDto;
import az.speak.ms.lets_speak.dto.StudentDto;
import az.speak.ms.lets_speak.service.ScheduleService;
import az.speak.ms.lets_speak.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class StudentController {
    private final StudentService service;
    private final ScheduleService scheduleService;
    public StudentController(StudentService service, ScheduleService scheduleService) {
        this.service = service;
        this.scheduleService = scheduleService;
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

    @PostMapping(path = "/set/order/{tariffId}")
    public void setOrder(@PathVariable Integer tariffId, @RequestBody StudentDto studentDto){
        service.getTeacherByDate(tariffId, studentDto);
    }
<<<<<<< HEAD
=======


>>>>>>> 544e5c54ddb5e164d8513dbf32ce9bdea74234e5
}