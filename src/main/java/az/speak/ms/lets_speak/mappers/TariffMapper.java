package az.speak.ms.lets_speak.mappers;

import az.speak.ms.lets_speak.dto.TariffDto;
import az.speak.ms.lets_speak.model.TariffEntity;

public class TariffMapper {

    public static TariffDto entityToDto(TariffEntity entity){
        TariffDto dto = new TariffDto();
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
}
