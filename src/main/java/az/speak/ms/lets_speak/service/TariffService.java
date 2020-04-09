package az.speak.ms.lets_speak.service;

import az.speak.ms.lets_speak.dto.TariffDto;
import az.speak.ms.lets_speak.mappers.TariffMapper;
<<<<<<< HEAD
=======
import az.speak.ms.lets_speak.model.TariffEntity;
>>>>>>> 544e5c54ddb5e164d8513dbf32ce9bdea74234e5
import az.speak.ms.lets_speak.repository.TariffRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TariffService {
    private final TariffRepository tariffRepository;

    public TariffService(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

<<<<<<< HEAD
    public List<TariffDto> getAll(){
        return TariffMapper.entityListToDtoList(tariffRepository.findAll());
=======
    public List<TariffDto> getAll(Pageable pageable){
        return TariffMapper.entityListToDtoList(tariffRepository.findAll(pageable));
>>>>>>> 544e5c54ddb5e164d8513dbf32ce9bdea74234e5
    }
}
