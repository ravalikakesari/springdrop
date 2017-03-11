package me.farhan.springdrop.services.users;

public interface AuthenticationFacade {
    org.springframework.security.core.Authentication getAuthentication();
}
