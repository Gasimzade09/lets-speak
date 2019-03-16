package az.speak.ms.lets_speak.controller;

import az.speak.ms.lets_speak.dto.CourseDto;
import az.speak.ms.lets_speak.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses/get/{id}")
    public CourseDto getAllCourses(@PathVariable Integer id){
        return courseService.getOne(id);
    }

    @GetMapping("/courses/get")
    public List<CourseDto> getAll(){
        return courseService.getAll();
    }
}
