package az.speak.ms.lets_speak.mappers;

import az.speak.ms.lets_speak.dto.TaskDto;
import az.speak.ms.lets_speak.model.TaskEntity;

import java.util.ArrayList;
import java.util.List;

public class TaskMapper {

    public static TaskEntity dtoToEntity(TaskDto dto){
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setName(dto.getName());
        taskEntity.setCreatedDate(dto.getCreatedDate());
        taskEntity.setExpirationDate(dto.getExpirationDate());
        taskEntity.setUrl(dto.getUrl());
        return taskEntity;
    }

    public static TaskDto entityToDto(TaskEntity entity){
        TaskDto taskDto = new TaskDto();
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
