package az.speak.ms.lets_speak.service;

import az.speak.ms.lets_speak.dto.CourseDto;
import az.speak.ms.lets_speak.mappers.CourseMapper;
import az.speak.ms.lets_speak.model.CourseEntity;
import az.speak.ms.lets_speak.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseDto getOne(int id){
        CourseDto dto = CourseMapper.INSTANCE.entityToDto(courseRepository.getOne(id));
        return dto;
    }

    public List<CourseDto> getAll(){
        List<CourseDto> dtos = new ArrayList<>();
        for (CourseEntity entity:courseRepository.findAll()) {
            dtos.add(CourseMapper.INSTANCE.entityToDto(entity));
        }
        return dtos;
    }
}
