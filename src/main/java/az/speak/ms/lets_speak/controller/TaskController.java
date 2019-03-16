package az.speak.ms.lets_speak.controller;

import az.speak.ms.lets_speak.dto.TaskDto;
import az.speak.ms.lets_speak.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService lessonService) {
        this.taskService = lessonService;
    }

    @PostMapping(path = "/task/save", consumes = "application/json", produces = "application/json")
    public void setLesson(@RequestBody TaskDto lessonDto){
        taskService.saveLesson(lessonDto);
    }

    @GetMapping("/task/get")
    public TaskDto getLesson(){
        return taskService.getTask();
    }

    @GetMapping("/tasks/get/{id}")
    public List<TaskDto> getTasksByStudentId(@PathVariable int id){
        return taskService.getTasksByStudentId(id);
    }
}