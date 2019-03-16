package az.speak.ms.lets_speak.service;

import az.speak.ms.lets_speak.dto.TaskDto;
import az.speak.ms.lets_speak.mappers.TaskMapper;
import az.speak.ms.lets_speak.model.TaskEntity;
import az.speak.ms.lets_speak.repository.TaskRepository;
import az.speak.ms.lets_speak.repository.StudentRepository;
import az.speak.ms.lets_speak.repository.TeacherRepository;
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

    public TaskDto getTask(){
        TaskDto dto = TaskMapper.INSTANCE.entityToDto(taskRepository.getOne(1));
        return dto;
    }

    public List<TaskDto> getTasksByStudentId(int id){
        List<TaskDto> dtos = TaskMapper.INSTANCE.entityListToDtoList(taskRepository.getTaskEntitiesByStudentId(id));
        return dtos;
    }
}
