package az.speak.ms.lets_speak.mappers;

import az.speak.ms.lets_speak.dto.OrderDto;
import az.speak.ms.lets_speak.model.OrderEntity;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    public static OrderDto entityToDto(OrderEntity entity){
        OrderDto orderDto = new OrderDto();
        orderDto.setCourseName(entity.getCourse().getName());
        orderDto.setTariffName(entity.getTariff().getCountType());
        orderDto.setStudentName(entity.getStudent().getName());
        orderDto.setTeacherName(entity.getTeacher().getName());
        orderDto.setPrice(entity.getTariff().getPrice());
        return orderDto;
    }


    public static List<OrderDto> entityListToDto(List<OrderEntity> entity){
        List<OrderDto> dtos = new ArrayList<>();
        for (OrderEntity o:entity) {
            dtos.add(entityToDto(o));
        }
        return dtos;
    }
}
