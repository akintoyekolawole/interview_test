package com.adio.consultancy.group.recruitment.Service;

import com.adio.consultancy.group.recruitment.model.constants.Status;
import com.adio.consultancy.group.recruitment.model.entity.Permission;
import com.adio.consultancy.group.recruitment.model.request.UpsertPermissionRequest;
import com.adio.consultancy.group.recruitment.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author kolawole
 */
@Service
public class PermissionService {

  private static final String PERMISSION_NOT_FOUND = "Permission not found";
  private final PermissionRepository permissionRepository;
  private static final Integer GLOBAL_INSTITUTION = 1;

  @Autowired
  public PermissionService(PermissionRepository permissionRepository) {
    Assert.notNull(permissionRepository);
    this.permissionRepository = permissionRepository;
  }

  public Permission createPermission(UpsertPermissionRequest upsertPermissionRequest)
          throws Exception {
    Permission permission = upsertPermissionRequest.toPermission();
    permission = permissionRepository.save(permission);
    return permission;
  }

}
