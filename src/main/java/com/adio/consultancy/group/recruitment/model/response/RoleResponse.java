package com.adio.consultancy.group.recruitment.model.response;

import com.adio.consultancy.group.recruitment.model.constants.Status;
import com.adio.consultancy.group.recruitment.model.entity.Role;
import com.adio.consultancy.group.recruitment.util.TimeUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author KOLAWOLE
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class RoleResponse {

  private String uniqueKey;
  private String name;
  private String description;
  private Status status;
  private Status isHidden;
  private String createdAt;
  private String updatedAt;


  public static RoleResponse fromRole(Role role) {
    if (role == null) {
      return null;
    }
    return RoleResponse.builder()
        .uniqueKey(role.getUniqueKey())
        .name(role.getName())
        .description(role.getDescription())
        .status(role.getStatus())
        .isHidden(role.getIsHidden())
        .createdAt(TimeUtil.getIsoTime(role.getCreatedAt()))
        .updatedAt(TimeUtil.getIsoTime(role.getUpdatedAt()))
        .build();
  }

  public static List<RoleResponse> fromRoles(List<Role> roles) {
    return roles.stream().map(role -> {
      return fromRole(role);
    }).collect(
        Collectors.toList());
  }


}
