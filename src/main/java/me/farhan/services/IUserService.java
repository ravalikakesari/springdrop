package me.farhan.services;

import me.farhan.dto.UserDto;
import me.farhan.entities.User;
import me.farhan.exception.EmailExistsException;

public interface IUserService {
    User registerNewUserAccount(UserDto accountDto) throws EmailExistsException;
}
