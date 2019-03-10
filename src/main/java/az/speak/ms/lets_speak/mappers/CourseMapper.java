package az.speak.ms.lets_speak.mappers;

import az.speak.ms.lets_speak.dto.CourseDto;
import az.speak.ms.lets_speak.model.CourseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    @Mapping(source = "name", target = "courseName")
    CourseDto entityToDto(CourseEntity entity);
}