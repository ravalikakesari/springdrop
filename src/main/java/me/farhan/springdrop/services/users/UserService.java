package me.farhan.springdrop.services.users;

import me.farhan.springdrop.domain.dto.UserDto;
import me.farhan.springdrop.domain.entities.User;
import me.farhan.springdrop.exception.EmailExistsException;

public interface UserService {
    User registerNewUserAccount(UserDto accountDto) throws EmailExistsException;
}
