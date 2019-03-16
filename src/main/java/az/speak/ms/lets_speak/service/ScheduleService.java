package az.speak.ms.lets_speak.service;

import az.speak.ms.lets_speak.model.ScheduleEntity;
import az.speak.ms.lets_speak.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<ScheduleEntity> getScheduleByStudentId(int id){
        return scheduleRepository.getScheduleEntitiesByStudent(id);
    }

}
