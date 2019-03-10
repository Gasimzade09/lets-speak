package az.speak.ms.lets_speak.Controller;

import az.speak.ms.lets_speak.model.ScheduleEntity;
import az.speak.ms.lets_speak.service.ScheduleService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public List<ScheduleEntity> getScheduleByStudentId(int id){
        return scheduleService.getScheduleByStudentId(id);
    }
}
