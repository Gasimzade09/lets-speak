package az.speak.ms.lets_speak.repository;

import az.speak.ms.lets_speak.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    @Query(value = "SELECT * FROM orders o WHERE o.student_id = ?1", nativeQuery = true)
    List<OrderEntity> getOrderEntitiesByStudentId(Integer id);


}
