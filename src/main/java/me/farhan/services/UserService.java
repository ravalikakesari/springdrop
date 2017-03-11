package me.farhan.services;

import me.farhan.dto.UserDto;
import me.farhan.entities.User;
import me.farhan.exception.EmailExistsException;
import me.farhan.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService{

    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    public User registerNewUserAccount(UserDto accountDto) throws EmailExistsException {
        return null;
    }

    private boolean emailExists(final String email){
        return false;
    }
}
