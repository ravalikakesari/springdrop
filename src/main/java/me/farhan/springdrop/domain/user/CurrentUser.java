package me.farhan.springdrop.domain.user;

import me.farhan.springdrop.domain.entities.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by farhan on 4/13/17.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {

  private User user;

  public CurrentUser(User user, Collection<? extends GrantedAuthority> authorities) {
    super(user.getEmail(), user.getPassword(), authorities);
    this.user = user;
  }

  public User getUser() {
    return user;
  }

  public Long getId() {
    return user.getId();
  }

}
