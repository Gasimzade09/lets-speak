package az.speak.ms.lets_speak.mappers;

import az.speak.ms.lets_speak.dto.StudentDto;
import az.speak.ms.lets_speak.model.StudentEntity;
import org.mapstruct.Mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Mapper
public class StudentMapper {
    private static StudentDto studentDto = new StudentDto();
    private static StudentEntity studentEntity = new StudentEntity();

    public static StudentDto entityToDto(StudentEntity entity){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        studentDto.setBirthDate(entity.getBirthDate().format(formatter));
        studentDto.setName(entity.getName());
        studentDto.setSurname(entity.getSurname());
        studentDto.setEmail(entity.getEmail());
        studentDto.setPhoneNumber(entity.getPhoneNumber());
        studentDto.setSkype(entity.getSkype());
        studentDto.setRank(entity.getRank());
        return studentDto;
    }

    public static StudentEntity dtoToEntity(StudentDto studentDto){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(studentDto.getBirthDate(), formatter);
        studentEntity.setName(StudentMapper.studentDto.getName());
        studentEntity.setSurname(StudentMapper.studentDto.getSurname());
        studentEntity.setEmail(StudentMapper.studentDto.getEmail());
        studentEntity.setSkype(StudentMapper.studentDto.getSkype());
        studentEntity.setBirthDate(birthDate);
        studentEntity.setRank(StudentMapper.studentDto.getRank());
        return studentEntity;
    }

    public static List<StudentDto> entityListToDtoList(List<StudentEntity> entities){
        List<StudentDto> dtos = new ArrayList();
        for (StudentEntity s:entities) {
            dtos.add(entityToDto(s));
        }
        return dtos;
    }
}