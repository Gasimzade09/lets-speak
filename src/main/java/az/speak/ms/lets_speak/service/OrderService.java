package az.speak.ms.lets_speak.service;

import az.speak.ms.lets_speak.model.OrderEntity;
import az.speak.ms.lets_speak.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderEntity> getAll(){
        return orderRepository.findAll();
    }
}
