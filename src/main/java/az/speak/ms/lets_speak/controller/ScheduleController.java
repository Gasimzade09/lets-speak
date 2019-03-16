package az.speak.ms.lets_speak.controller;

import az.speak.ms.lets_speak.model.ScheduleEntity;
import az.speak.ms.lets_speak.service.ScheduleService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Api(value = "/api", description = "Операции с профилем")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/get/schedules/{id}")
    public List<ScheduleEntity> getScheduleByStudentId(@PathVariable int id){
        return scheduleService.getScheduleByStudentId(id);
    }
}
