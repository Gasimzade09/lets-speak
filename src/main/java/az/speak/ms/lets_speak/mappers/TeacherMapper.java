package az.speak.ms.lets_speak.mappers;

import az.speak.ms.lets_speak.dto.TeacherDTO;
import az.speak.ms.lets_speak.model.TeacherEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TeacherMapper {

    public static TeacherDTO entityToDto(TeacherEntity entity){
        TeacherDTO dto = new TeacherDTO();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        dto.setBirthDate(entity.getBirthDate().format(formatter));
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setEmail(entity.getEmail());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setSkype(entity.getSkype());
        dto.setCourses(CourseMapper.entityToDto(entity.getCourse()));
        return dto;
    }

    public static TeacherEntity dtoToEntity(TeacherDTO dto){
        TeacherEntity teacherEntity = new TeacherEntity();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(dto.getBirthDate(), formatter);

        teacherEntity.setName(dto.getName());
        teacherEntity.setSurname(dto.getSurname());
        teacherEntity.setEmail(dto.getEmail());
        teacherEntity.setBirthDate(birthDate);
        teacherEntity.setCv(dto.getCv());
        return teacherEntity;
    }
}
