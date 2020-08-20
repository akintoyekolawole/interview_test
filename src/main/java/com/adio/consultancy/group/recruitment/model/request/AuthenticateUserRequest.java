package com.adio.consultancy.group.recruitment.model.request;

import com.adio.consultancy.group.recruitment.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @author Kolawole
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticateUserRequest {

  @NotNull
  @NotEmpty
  private String email;

  @NotNull
  @NotEmpty
  private String password;

  public User toUser() {
    User user = new User();
    user.setEmail(email);
    user.setPassword(password);
    return user;
  }
}
