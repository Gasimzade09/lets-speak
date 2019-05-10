package az.speak.ms.lets_speak.mappers;

import az.speak.ms.lets_speak.dto.ScheduleDto;
import az.speak.ms.lets_speak.model.ScheduleEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ScheduleMapper {

    public static ScheduleEntity dtoToEntity(ScheduleDto dto){
        ScheduleEntity scheduleEntity = new ScheduleEntity();
        scheduleEntity.setDate(dto.getDate());
        scheduleEntity.setTime(dto.getTime());
        return scheduleEntity;
    }

    public static ScheduleDto entityToDto(ScheduleEntity entity){

        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setDate(entity.getDate());
        scheduleDto.setTime(entity.getTime());
        scheduleDto.setStudentName(entity.getStudent().getName());
        scheduleDto.setTeacherName(entity.getTeacher().getName());
        return scheduleDto;
    }

    public static List<ScheduleDto> entityListToDtoList(List<ScheduleEntity> entity){
        List<ScheduleDto> dtos = new ArrayList<>();
        for (ScheduleEntity e : entity) {
            dtos.add(entityToDto(e));
        }
        return dtos;
    }
}
