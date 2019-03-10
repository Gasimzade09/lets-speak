package az.speak.ms.lets_speak.mappers;

import az.speak.ms.lets_speak.dto.StudentDto;
import az.speak.ms.lets_speak.model.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper( StudentMapper.class );

    @Mapping(source = "teacher.name", target = "teacherName")
    StudentDto studentToStudentDto(StudentEntity entity);

    List<StudentDto> studentListToStudentDtoList(List<StudentEntity> entity);

    @Mapping(source = "teacherName", target = "teacher.name")
    StudentEntity dtoToStudentEntity(StudentDto dto);

    List<StudentEntity> studentDtoListToStudentEntityList(List<StudentEntity> entity);
}