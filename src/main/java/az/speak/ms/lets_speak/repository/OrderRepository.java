package az.speak.ms.lets_speak.repository;

import az.speak.ms.lets_speak.model.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    Page<OrderEntity> findAll(Pageable pageable);

    Page<OrderEntity> getOrderEntitiesByStudentId(Integer id, Pageable pageable);


}
