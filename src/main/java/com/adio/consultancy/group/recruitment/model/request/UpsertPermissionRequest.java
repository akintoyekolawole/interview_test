package com.adio.consultancy.group.recruitment.model.request;

import com.adio.consultancy.group.recruitment.model.constants.Status;
import com.adio.consultancy.group.recruitment.model.entity.Permission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Kolawole
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class UpsertPermissionRequest {

    private String name;
    private String description;
    private String code;
    private Status status;
    private Status isHidden;

    public Permission toPermission(){
        Permission permission = new Permission();
        permission.setCode(code);
        permission.setDescription(description);
        permission.setName(name);
        permission.setStatus(Status.ACTIVE);
        permission.setIsHidden(isHidden);
        return permission;
    }
}
