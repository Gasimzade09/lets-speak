package az.speak.ms.lets_speak.mappers;

import az.speak.ms.lets_speak.dto.CourseDto;
import az.speak.ms.lets_speak.model.CourseEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseMapper {

    public static CourseDto entityToDto(CourseEntity entity){
        CourseDto courseDto = new CourseDto();
        courseDto.setCourseName(entity.getName());
        courseDto.setDescription(entity.getDescription());
        return courseDto;
    }

    public static CourseEntity dtoToEntity(CourseDto dto){
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setName(dto.getCourseName());
        courseEntity.setDescription(dto.getDescription());
        return courseEntity;
    }

    public static List<CourseDto> entityListToDtoList(List<CourseEntity> entity){
        List<CourseDto> dtos = new ArrayList<>();
        for (CourseEntity e : entity) {
            dtos.add(entityToDto(e));
        }
        return dtos;
    }
}
