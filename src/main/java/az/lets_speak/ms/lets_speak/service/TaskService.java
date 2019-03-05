package az.lets_speak.ms.lets_speak.service;

import az.lets_speak.ms.lets_speak.dto.TaskDto;
import az.lets_speak.ms.lets_speak.model.TaskEntity;
import az.lets_speak.ms.lets_speak.repository.TaskRepository;
import az.lets_speak.ms.lets_speak.repository.StudentRepository;
import az.lets_speak.ms.lets_speak.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public TaskService(TaskRepository taskRepository, TeacherRepository teacherRepository, StudentRepository studentRepository) {
        this.taskRepository = taskRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    public void saveLesson(TaskDto taskDto){
        TaskEntity lesson = new TaskEntity();
        lesson.setUrl(taskDto.getUrl());
        lesson.setName(taskDto.getName());
        lesson.setCreatedDate(taskDto.getCreatedDate());
        lesson.setExpirationDate(taskDto.getCreatedDate().plusDays(taskDto.getDeadLine()));
        lesson.setTeacher(teacherRepository.getOne(1));
        lesson.setStudent(studentRepository.getOne(2));
        taskRepository.save(lesson);
    }

    public TaskDto getLesson(){
        TaskEntity lesson = taskRepository.getOne(1);
        TaskDto dto = new TaskDto(lesson.getName(), lesson.getUrl(), lesson.getCreatedDate(), lesson.getExpirationDate(), 7, lesson.getTeacher().getId(), lesson.getStudent().getId());
        return dto;
    }

    public List<TaskEntity> getTasksByStudentId(){
        return taskRepository.getTaskEntitiesByStudentId(2);
    }
}
