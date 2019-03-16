package az.speak.ms.lets_speak.controller;

import az.speak.ms.lets_speak.model.TariffEntity;
import az.speak.ms.lets_speak.service.TariffService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TariffController {
    private final TariffService tariffService;

    public TariffController(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @GetMapping("/get/tariffs")
    public List<TariffEntity> getAll(){
        return tariffService.getAll();
    }
}
