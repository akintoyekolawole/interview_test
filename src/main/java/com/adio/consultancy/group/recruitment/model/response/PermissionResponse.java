package com.adio.consultancy.group.recruitment.model.response;

import com.adio.consultancy.group.recruitment.model.entity.Permission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kolawole
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class PermissionResponse {

  private Integer id;
  private String name;
  private String description;
  private String code;

  public static PermissionResponse fromPermission(Permission permission) {
    if (permission == null) {
      return null;
    }
    return PermissionResponse.builder()
        .id(permission.getId())
        .name(permission.getName())
        .description(permission.getDescription())
        .code(permission.getCode())
        .build();
  }

  public static List<PermissionResponse> fromPermissions(List<Permission> permissions) {
    return permissions.stream().map(permission -> {
      return fromPermission(permission);
    }).collect(
        Collectors.toList());
  }

}
