package az.speak.ms.lets_speak.mappers;

import az.speak.ms.lets_speak.dto.TeacherDTO;
import az.speak.ms.lets_speak.model.TeacherEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TeacherMapper {

    private static TeacherDTO dto = new TeacherDTO();
    private static TeacherEntity entity = new TeacherEntity();

    public static TeacherDTO entityToDto(TeacherEntity entity){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        dto.setBirthDate(entity.getBirthDate().format(formatter));
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setEmail(entity.getEmail());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setSkype(entity.getSkype());
        return dto;
    }

    public static TeacherEntity dtoToEntity(TeacherDTO dto){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(dto.getBirthDate(), formatter);
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setEmail(dto.getEmail());
        entity.setCourse(CourseMapper.dtoToEntity(dto.getCourses()));
        entity.setBirthDate(birthDate);
        entity.setCv(dto.getCv());
        return entity;
    }
}
