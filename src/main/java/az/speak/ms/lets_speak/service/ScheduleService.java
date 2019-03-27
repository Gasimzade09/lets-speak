package az.speak.ms.lets_speak.service;

import az.speak.ms.lets_speak.dto.ScheduleDto;
import az.speak.ms.lets_speak.mappers.ScheduleMapper;
import az.speak.ms.lets_speak.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<ScheduleDto> getScheduleByStudentId(int id){
        return ScheduleMapper.entityListToDtoList(scheduleRepository.getScheduleEntitiesByStudent(id));
    }

    public List<ScheduleDto> getScheduleByTeacherId(Integer id) {
        return ScheduleMapper.entityListToDtoList(scheduleRepository.getScheduleEntitiesByTeacher(id));
    }
}
