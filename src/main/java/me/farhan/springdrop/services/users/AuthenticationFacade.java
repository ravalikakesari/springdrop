package me.farhan.springdrop.services.users;

import me.farhan.springdrop.domain.entities.User;
import me.farhan.springdrop.domain.user.CurrentUser;

public interface AuthenticationFacade {
    org.springframework.security.core.Authentication getAuthentication();

    CurrentUser currentUser();
}
