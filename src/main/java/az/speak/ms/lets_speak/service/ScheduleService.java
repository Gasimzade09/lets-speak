package az.speak.ms.lets_speak.service;

import az.speak.ms.lets_speak.dto.OrderDto;
import az.speak.ms.lets_speak.dto.ScheduleDto;
import az.speak.ms.lets_speak.dto.StudentDto;
import az.speak.ms.lets_speak.mappers.ScheduleMapper;
import az.speak.ms.lets_speak.model.ScheduleEntity;
import az.speak.ms.lets_speak.model.TariffEntity;
import az.speak.ms.lets_speak.model.TeacherEntity;
import az.speak.ms.lets_speak.repository.ScheduleRepository;
import az.speak.ms.lets_speak.repository.StudentRepository;
import az.speak.ms.lets_speak.repository.TariffRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final TariffRepository tariffRepository;
    private final StudentRepository studentRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, TariffRepository tariffRepository, StudentRepository studentRepository) {
        this.scheduleRepository = scheduleRepository;
        this.tariffRepository = tariffRepository;
        this.studentRepository = studentRepository;
    }

    public List<ScheduleDto> getScheduleByStudentId(int id){
        return ScheduleMapper.entityListToDtoList(scheduleRepository.getScheduleEntitiesByStudent(id));
    }

    public List<ScheduleDto> getScheduleByTeacherId(Integer id) {
        return ScheduleMapper.entityListToDtoList(scheduleRepository.getScheduleEntitiesByTeacher(id));
    }
}
