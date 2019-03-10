package az.speak.ms.lets_speak.mappers;

import az.speak.ms.lets_speak.dto.ScheduleDto;
import az.speak.ms.lets_speak.model.ScheduleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScheduleMapper {
    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);

    @Mappings({
            @Mapping(source = "teacher.name", target = "teacherName"),
            @Mapping(source = "student.name", target = "studentName")
    })
    ScheduleDto entityToDto(ScheduleEntity entity);

    @Mappings({
            @Mapping(source = "teacherName", target = "teacher.name"),
            @Mapping(source = "studentName", target = "student.name")
    })
    ScheduleEntity DtoToEntity(ScheduleDto dto);
}
