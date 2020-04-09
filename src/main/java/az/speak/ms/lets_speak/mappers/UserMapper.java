package az.speak.ms.lets_speak.mappers;

import az.speak.ms.lets_speak.dto.UserDto;
import az.speak.ms.lets_speak.model.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static UserDto userEntityToUserDto(UserEntity entity){
        UserDto userDto = UserDto.builder()
                .birthDate(entity.getBirthDate())
                .email(entity.getEmail())
                .name(entity.getName())
                .surname(entity.getSurname())
                .phoneNumber(entity.getPhoneNumber())
                .skype(entity.getSkype())
                .photo(entity.getPhoto())
                .build();
        return userDto;
    }

    public static List<UserDto> entityListToDtoList(List<UserEntity> entities){
        List<UserDto> dtos = new ArrayList<>();
        for (UserEntity e : entities) {
            dtos.add(userEntityToUserDto(e));
        }
        return dtos;
    }
}
