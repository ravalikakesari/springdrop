package me.farhan.springdrop.services.users;

import me.farhan.springdrop.domain.entities.User;
import me.farhan.springdrop.domain.user.CurrentUser;
import org.springframework.security.core.Authentication;

public interface AuthenticationFacade {
  Authentication getAuthentication();

  CurrentUser currentUser();
}
