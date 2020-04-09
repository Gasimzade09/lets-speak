package az.speak.ms.lets_speak.mappers;

import az.speak.ms.lets_speak.dto.TariffDto;
import az.speak.ms.lets_speak.model.TariffEntity;

import java.util.ArrayList;
import java.util.List;

public class TariffMapper {

    public static TariffDto entityToDto(TariffEntity entity){
        TariffDto dto = new TariffDto();
        dto.setId(entity.getId());
        dto.setCount(entity.getCount());
        dto.setCountType(entity.getCountType());
        dto.setDuration(entity.getDuration());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setTimesAWeek(entity.getTimesAWeek());
        return dto;
    }

    public static TariffEntity dtoToEntity(TariffDto tariffDto){
        TariffEntity entity = new TariffEntity();
        entity.setCount(tariffDto.getCount());
        entity.setCountType(tariffDto.getCountType());
        entity.setDuration(tariffDto.getDuration());
        entity.setName(tariffDto.getName());
        entity.setPrice(tariffDto.getPrice());
        entity.setTimesAWeek(tariffDto.getTimesAWeek());
        return entity;
    }

    public static List<TariffDto> entityListToDtoList(List<TariffEntity> tariffEntities){
        List<TariffDto> dtos = new ArrayList<>();
        for (TariffEntity t : tariffEntities) {
            dtos.add(entityToDto(t));
        }
        return dtos;
    }
}
