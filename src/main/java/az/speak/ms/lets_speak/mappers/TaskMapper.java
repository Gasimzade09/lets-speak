package az.speak.ms.lets_speak.mappers;

import az.speak.ms.lets_speak.dto.TaskDto;
import az.speak.ms.lets_speak.model.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    @Mappings({
            @Mapping(source = "teacher.name", target = "teacherName"),
            @Mapping(source = "student.name", target = "studentName")
    })

    TaskDto entityToDto(TaskEntity entity);

    List<TaskDto> entityListToDtoList(List<TaskEntity> entity);
}
