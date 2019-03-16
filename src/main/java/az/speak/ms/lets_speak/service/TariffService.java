package az.speak.ms.lets_speak.service;

import az.speak.ms.lets_speak.model.TariffEntity;
import az.speak.ms.lets_speak.repository.TariffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TariffService {
    private final TariffRepository tariffRepository;

    public TariffService(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    public List<TariffEntity> getAll(){
        return tariffRepository.findAll();
    }
}
