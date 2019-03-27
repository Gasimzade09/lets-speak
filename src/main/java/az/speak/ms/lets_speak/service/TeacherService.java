package az.speak.ms.lets_speak.service;

import az.speak.ms.lets_speak.dto.TeacherDTO;
import az.speak.ms.lets_speak.mappers.TeacherMapper;
import az.speak.ms.lets_speak.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    private TeacherDTO dto = new TeacherDTO();

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public TeacherDTO getTeacherById(int id){
        dto = TeacherMapper.entityToDto(teacherRepository.getOne(id));
        return dto;
    }

    public TeacherDTO getTeacherByStudentId(int id){
        dto = TeacherMapper.entityToDto(teacherRepository.getTeacherByStudentId(id));
        return dto;
    }

    public Integer getIdByEmail(String email) {
        return teacherRepository.getIdByEmail(email);
    }
}
