package az.speak.ms.lets_speak.mappers;

import az.speak.ms.lets_speak.dto.ScheduleDto;
import az.speak.ms.lets_speak.model.ScheduleEntity;

public class ScheduleMapper {
    private static ScheduleEntity scheduleEntity = new ScheduleEntity();

    private static ScheduleDto scheduleDto = new ScheduleDto();

    public static ScheduleEntity dtoToEntity(ScheduleDto dto){
        scheduleEntity.setDate(dto.getDate());
        scheduleEntity.setTime(dto.getTime());
        return scheduleEntity;
    }

    public static ScheduleDto entityToDto(ScheduleEntity entity){
        scheduleDto.setDate(entity.getDate());
        scheduleDto.setTime(entity.getTime());
        scheduleDto.setStudentName(entity.getStudent().getName());
        scheduleDto.setTeacherName(entity.getTeacher().getName());
        return scheduleDto;
    }
}
