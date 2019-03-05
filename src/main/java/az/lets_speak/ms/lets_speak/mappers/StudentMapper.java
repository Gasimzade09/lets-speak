package az.lets_speak.ms.lets_speak.mappers;

import az.lets_speak.ms.lets_speak.dto.StudentDto;
import az.lets_speak.ms.lets_speak.model.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper( StudentMapper.class );

    @Mapping(source = "teacher.name", target = "teacherName")
    StudentDto studentToStudentDto(StudentEntity entity);

   // @Mapping(source = "teacher.name", target = "teacherName")
    List<StudentDto> studentListToStudentDtoList(List<StudentEntity> entity);
}
