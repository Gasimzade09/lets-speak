package az.lets_speak.ms.lets_speak.repository;

import az.lets_speak.ms.lets_speak.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}
