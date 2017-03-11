package me.farhan.springdrop.services;

import me.farhan.springdrop.domain.dto.UserDto;
import me.farhan.springdrop.domain.entities.User;
import me.farhan.springdrop.exception.EmailExistsException;
import me.farhan.springdrop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    public User registerNewUserAccount(UserDto accountDto) throws EmailExistsException {
        if (emailExist(accountDto.getEmail())) {
            throw new EmailExistsException("There is an account with that email address:"+ accountDto.getEmail());
        }
        User user = new User();
        user.setFullName(accountDto.getFullName());
        user.setPassword(accountDto.getPassword());
        user.setEmail(accountDto.getEmail());
        return userRepository.save(user);
    }

    private boolean emailExist(final String email){
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
}
