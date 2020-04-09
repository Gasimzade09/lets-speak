package az.speak.ms.lets_speak.repository;

import az.speak.ms.lets_speak.model.TariffEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TariffRepository extends JpaRepository<TariffEntity, Integer> {

    TariffEntity getTariffEntityByCountType(String name);

    Page<TariffEntity> findAll(Pageable pageable);

}
