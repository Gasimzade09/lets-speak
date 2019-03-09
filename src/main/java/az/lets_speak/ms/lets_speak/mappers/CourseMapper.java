package az.lets_speak.ms.lets_speak.mappers;

import az.lets_speak.ms.lets_speak.dto.CourseDto;
import az.lets_speak.ms.lets_speak.model.CourseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    @Mapping(source = "name", target = "courseName")
    CourseDto entityToDto(CourseEntity entity);
}
