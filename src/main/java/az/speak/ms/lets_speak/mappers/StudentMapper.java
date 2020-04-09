package az.speak.ms.lets_speak.mappers;

import az.speak.ms.lets_speak.dto.StudentDto;
import az.speak.ms.lets_speak.model.StudentEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StudentMapper {

    public static StudentDto entityToDto(StudentEntity entity){
        StudentDto studentDto = new StudentDto();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        studentDto.setBirthDate(entity.getBirthDate().format(formatter));
        studentDto.setName(entity.getName());
        studentDto.setSurname(entity.getSurname());
        studentDto.setEmail(entity.getEmail());
        studentDto.setPhoneNumber(entity.getPhoneNumber());
        studentDto.setSkype(entity.getSkype());
        studentDto.setRank(entity.getRank());
        studentDto.setPhoto(entity.getPhoto());
        studentDto.setId(entity.getId());
        return studentDto;
    }

    public static String replaceFirstSymToUpperCase(String changeable){
        char sym;
        String changed = changeable.toUpperCase();
        sym = changed.charAt(0);
        changed = changeable.replace(changeable.charAt(0), sym);
        return changed;
    }

    public static StudentEntity dtoToEntity(StudentDto studentDto){
        StudentEntity studentEntity = new StudentEntity();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(studentDto.getBirthDate(), formatter);

        studentEntity.setName(replaceFirstSymToUpperCase(studentDto.getName()));
        studentEntity.setSurname(replaceFirstSymToUpperCase(studentDto.getSurname()));
        studentEntity.setEmail(studentDto.getEmail());
        studentEntity.setSkype(studentDto.getSkype());
        studentEntity.setBirthDate(birthDate);
        studentEntity.setPhoto(studentDto.getPhoto());
        return studentEntity;
    }

    public static List<StudentDto> entityListToDtoList(List<StudentEntity> entities){
        List<StudentDto> dtos = new ArrayList<>();
        for (StudentEntity s:entities) {
            dtos.add(entityToDto(s));
        }
        return dtos;
    }
}