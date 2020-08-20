package com.adio.consultancy.group.recruitment.Service.facade;

import com.adio.consultancy.group.recruitment.exception.AccessException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Kolawole
 */
@Component
public class PermissionHandler {

  private static final String ACCESS_DENIED = "Access Denied";

  public void hasPermission(List permissions, String permission) {
    if (!permissions.contains(permission)) {
      throw new AccessException(ACCESS_DENIED);
    }
  }
}
