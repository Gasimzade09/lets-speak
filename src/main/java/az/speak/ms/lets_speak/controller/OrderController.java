package az.speak.ms.lets_speak.controller;

import az.speak.ms.lets_speak.dto.OrderDto;
import az.speak.ms.lets_speak.model.OrderEntity;
import az.speak.ms.lets_speak.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public Page<OrderEntity> getAll(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable){
        return orderService.getAll(pageable);
    }

    @GetMapping ("/get/orders/student/{id}")
    public List<OrderDto> getByStudentId(@PathVariable Integer id){
        return orderService.getByStudentId(id);
    }

    @GetMapping("/exit")
    public void exit(){
        System.exit(-1);
    }
    List<OrderDto> getByStudentId(@PathVariable Integer id, @RequestParam Integer pageNum){
        Pageable sortedByPriceDesc = PageRequest.of(pageNum, 10, Sort.by("id").descending());
        return orderService.getByStudentId(id, sortedByPriceDesc);
    }
}

