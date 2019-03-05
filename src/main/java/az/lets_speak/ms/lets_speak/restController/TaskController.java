package az.lets_speak.ms.lets_speak.restController;

import az.lets_speak.ms.lets_speak.dto.TaskDto;
import az.lets_speak.ms.lets_speak.model.TaskEntity;
import az.lets_speak.ms.lets_speak.service.TaskService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "/api", description = "Операции с профилем")
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
        return taskService.getLesson();
    }

    @GetMapping("/tasks/get")
    public List<TaskEntity> getTasksByStudentId(){
        return taskService.getTasksByStudentId();
    }
}