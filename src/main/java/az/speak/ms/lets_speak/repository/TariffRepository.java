package az.speak.ms.lets_speak.repository;

import az.speak.ms.lets_speak.model.TariffEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TariffRepository extends JpaRepository<TariffEntity, Integer> {
<<<<<<< HEAD
    TariffEntity getTariffEntityByCountType(String name);
=======

    Page<TariffEntity> findAll(Pageable pageable);

>>>>>>> 544e5c54ddb5e164d8513dbf32ce9bdea74234e5
}
