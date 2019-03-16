package az.speak.ms.lets_speak.controller;

import az.speak.ms.lets_speak.model.OrderEntity;
import az.speak.ms.lets_speak.service.OrderService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/get/orders")
    public List<OrderEntity> getAll(){
        return orderService.getAll();
    }
}
