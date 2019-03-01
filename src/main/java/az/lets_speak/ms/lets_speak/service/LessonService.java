package az.lets_speak.ms.lets_speak.service;

import az.lets_speak.ms.lets_speak.dto.LessonDto;
import az.lets_speak.ms.lets_speak.model.Lesson;
import az.lets_speak.ms.lets_speak.model.Student;
import az.lets_speak.ms.lets_speak.model.Teacher;
import az.lets_speak.ms.lets_speak.repository.LessonRepository;
import az.lets_speak.ms.lets_speak.repository.StudentRepository;
import az.lets_speak.ms.lets_speak.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public LessonService(LessonRepository lessonRepository, TeacherRepository teacherRepository, StudentRepository studentRepository) {
        this.lessonRepository = lessonRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    public void saveLesson(LessonDto lessonDto){
        Lesson lesson = new Lesson();
        lesson.setUrl(lessonDto.getUrl());
        lesson.setName(lessonDto.getName());
        lesson.setCreatedDate(lessonDto.getCreatedDate());
        lesson.setExpirationDate(lessonDto.getCreatedDate().plusDays(lessonDto.getDeadLine()));
        lesson.setTeacher(teacherRepository.getOne(1));
        lesson.setStudent(studentRepository.getOne(2));
        lessonRepository.save(lesson);
    }

    public LessonDto getLesson(){
        Lesson lesson = lessonRepository.getOne(1);
        LessonDto dto = new LessonDto(lesson.getName(), lesson.getUrl(), lesson.getCreatedDate(), lesson.getExpirationDate(), 7);
        return dto;
    }
}
