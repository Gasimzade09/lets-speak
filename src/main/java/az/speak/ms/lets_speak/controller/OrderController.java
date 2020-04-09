package az.speak.ms.lets_speak.controller;

import az.speak.ms.lets_speak.dto.OrderDto;
import az.speak.ms.lets_speak.model.OrderEntity;
import az.speak.ms.lets_speak.service.OrderService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping ("/get/orders/student/{id}")
    public List<OrderDto> getByStudentId(@PathVariable Integer id){
        return orderService.getByStudentId(id);
    }

    @GetMapping("/exit")
    public void exit(){
        System.exit(-1);
    }
}
