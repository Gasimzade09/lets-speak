package az.lets_speak.ms.lets_speak.restController;

import az.lets_speak.ms.lets_speak.dto.LessonDto;
import az.lets_speak.ms.lets_speak.model.Lesson;
import az.lets_speak.ms.lets_speak.model.Student;
import az.lets_speak.ms.lets_speak.model.Teacher;
import az.lets_speak.ms.lets_speak.service.LessonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LessonController {
    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping(path = "/lesson/save", consumes = "application/json", produces = "application/json")
    public void setLesson(@RequestBody LessonDto lessonDto){
        lessonService.saveLesson(lessonDto);
    }

    @GetMapping("/lesson/get")
    public LessonDto getLesson(){
        return lessonService.getLesson();
    }
}
