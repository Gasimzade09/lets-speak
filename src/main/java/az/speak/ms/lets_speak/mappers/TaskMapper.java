package az.speak.ms.lets_speak.mappers;

import az.speak.ms.lets_speak.dto.StudentDto;
import az.speak.ms.lets_speak.dto.TaskDto;
import az.speak.ms.lets_speak.model.StudentEntity;
import az.speak.ms.lets_speak.model.TaskEntity;

import java.util.ArrayList;
import java.util.List;

public class TaskMapper {
    private static TaskEntity taskEntity = new TaskEntity();

    private static TaskDto taskDto = new TaskDto();

    public static TaskEntity dtoToEntity(TaskDto dto){
        taskEntity.setName(dto.getName());
        taskEntity.setCreatedDate(dto.getCreatedDate());
        taskEntity.setExpirationDate(dto.getExpirationDate());
        taskEntity.setUrl(dto.getUrl());
        return taskEntity;
    }

    public static TaskDto entityToDto(TaskEntity entity){
        taskDto.setCreatedDate(entity.getCreatedDate());
        taskDto.setExpirationDate(entity.getExpirationDate());
        taskDto.setName(entity.getName());
        taskDto.setUrl(entity.getUrl());
        taskDto.setTeacherName(entity.getTeacher().getName());
        return taskDto;
    }

    public static List<TaskDto> entityListToDtoList(List<TaskEntity> entities){
        List<TaskDto> dtos = new ArrayList();
        for (TaskEntity t:entities) {
            dtos.add(entityToDto(t));
        }
        return dtos;
    }
}
