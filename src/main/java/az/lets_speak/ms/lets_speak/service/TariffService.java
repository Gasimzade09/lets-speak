package az.lets_speak.ms.lets_speak.service;

import az.lets_speak.ms.lets_speak.repository.TariffRepository;
import org.springframework.stereotype.Service;

@Service
public class TariffService {
    private final TariffRepository tariffRepository;

    public TariffService(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }
}
