package com.adio.consultancy.group.recruitment.model.request;

import com.adio.consultancy.group.recruitment.model.constants.Status;
import com.adio.consultancy.group.recruitment.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Kolawole
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class UpsertRoleRequest {

  @NotNull
  @NotEmpty
  private String name;

  @NotNull
  @NotEmpty
  private String description;

  @NotNull
  @NotEmpty
  private List<Integer> permissionIds;

  private Status status;

  private Status isHidden;

  public Role toRole() {
    Role role = new Role();
    role.setName(name);
    role.setDescription(description);
    if (status == null) {
      role.setStatus(Status.INACTIVE);
    } else {
      role.setStatus(status);
    }
    if (isHidden == null) {
      role.setIsHidden(Status.INACTIVE);
    } else {
      role.setIsHidden(isHidden);
    }
    return role;
  }

}
