package az.speak.ms.lets_speak.controller;

import az.speak.ms.lets_speak.dto.ScheduleDto;
import az.speak.ms.lets_speak.dto.StudentDto;
import az.speak.ms.lets_speak.service.ScheduleService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Api(value = "/api", description = "Операции с рассписанием")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/get/schedules/{id}")
    public List<ScheduleDto> getScheduleByStudentId(@PathVariable int id){
        return scheduleService.getScheduleByStudentId(id);
    }

    @GetMapping("/get/teacher/schedules/{id}")
    public List<ScheduleDto> getScheduleByTeacherId(@PathVariable Integer id){
        return scheduleService.getScheduleByTeacherId(id);
    }

}
