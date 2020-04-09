package az.speak.ms.lets_speak.service;

import az.speak.ms.lets_speak.dto.OrderDto;
import az.speak.ms.lets_speak.mappers.OrderMapper;
import az.speak.ms.lets_speak.model.OrderEntity;
import az.speak.ms.lets_speak.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Page<OrderEntity> getAll(Pageable pageable){
        return orderRepository.findAll(pageable);
    }

<<<<<<< HEAD
    public List<OrderDto> getByStudentId(Integer id){
        return OrderMapper.entityListToDto(orderRepository.getOrderEntitiesByStudentId(id));
    }
}
=======
    public List<OrderDto> getByStudentId(Integer id, Pageable pageable){
        return OrderMapper.entityListToDto(orderRepository.getOrderEntitiesByStudentId(id, pageable).getContent());
    }
}
>>>>>>> 544e5c54ddb5e164d8513dbf32ce9bdea74234e5
