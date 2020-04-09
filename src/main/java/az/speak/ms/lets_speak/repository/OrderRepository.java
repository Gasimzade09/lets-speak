package az.speak.ms.lets_speak.repository;

import az.speak.ms.lets_speak.model.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
<<<<<<< HEAD
    @Query(value = "SELECT * FROM orders o WHERE o.student_id = ?1", nativeQuery = true)
    List<OrderEntity> getOrderEntitiesByStudentId(Integer id);
=======

    Page<OrderEntity> findAll(Pageable pageable);

    Page<OrderEntity> getOrderEntitiesByStudentId(Integer id, Pageable pageable);
>>>>>>> 544e5c54ddb5e164d8513dbf32ce9bdea74234e5


}
