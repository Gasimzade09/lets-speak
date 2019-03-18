package az.speak.ms.lets_speak.mappers;

import az.speak.ms.lets_speak.dto.OrderDto;
import az.speak.ms.lets_speak.model.OrderEntity;

public class OrderMapper {
    private static OrderEntity orderEntity = new OrderEntity();

    private static OrderDto orderDto = new OrderDto();

    public static OrderDto entityToDto(OrderEntity entity){
        orderDto.setCourseName(entity.getCourse().getName());
        orderDto.setTariffName(entity.getTariff().getName());
        orderDto.setStudentName(entity.getStudent().getName());
        orderDto.setTeacherName(entity.getTeacher().getName());
        return orderDto;
    }
}
