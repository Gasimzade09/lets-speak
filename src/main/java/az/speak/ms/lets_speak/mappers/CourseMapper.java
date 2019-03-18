package az.speak.ms.lets_speak.mappers;

import az.speak.ms.lets_speak.dto.CourseDto;
import az.speak.ms.lets_speak.model.CourseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public class CourseMapper {
    private static CourseDto courseDto = new CourseDto();

    private static CourseEntity courseEntity = new CourseEntity();

    public static CourseDto entityToDto(CourseEntity entity){
        courseDto.setCourseName(entity.getName());
        courseDto.setDescription(entity.getDescription());
        return courseDto;
    }

    public static CourseEntity dtoToEntity(CourseDto dto){
        courseEntity.setName(dto.getCourseName());
        courseEntity.setDescription(dto.getDescription());
        return courseEntity;
    }
}
