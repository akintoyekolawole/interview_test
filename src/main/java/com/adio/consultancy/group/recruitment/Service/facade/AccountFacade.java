package com.adio.consultancy.group.recruitment.Service.facade;

import ch.qos.logback.core.read.ListAppender;
import com.adio.consultancy.group.recruitment.Service.ApplicantService;
import com.adio.consultancy.group.recruitment.Service.PermissionService;
import com.adio.consultancy.group.recruitment.Service.RoleService;
import com.adio.consultancy.group.recruitment.Service.UserService;
import com.adio.consultancy.group.recruitment.model.entity.*;
import com.adio.consultancy.group.recruitment.model.request.*;
import com.adio.consultancy.group.recruitment.model.response.*;
import com.adio.consultancy.group.recruitment.util.TimeUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kolawole
 */
@Component
public class AccountFacade extends RequestFacade {

    private final UserService userService;
    private final RoleService roleService;
    private final PermissionHandler permissionHandler;
    private static final Integer USER_ROLE_ID = 2;
    private final PermissionService permissionService;
    private final ApplicantService applicantService;

    public AccountFacade(UserService userService,
                         RoleService roleService,
                         PermissionHandler permissionHandler,
                         PermissionService permissionService,
                         ApplicantService applicantService){
        Assert.notNull(userService);
        Assert.notNull(roleService);
        Assert.notNull(permissionHandler);
        Assert.notNull(permissionService);
        Assert.notNull(applicantService);
        this.roleService = roleService;
        this.userService= userService;
        this.permissionHandler = permissionHandler;
        this.permissionService = permissionService;
        this.applicantService = applicantService;
    }

    public SuccessResponse createUser(
            UpsertUserRequest upsertUserRequest) throws Exception {
        upsertUserRequest.setRoleId(fetchRoleId(upsertUserRequest));
        User user = userService.createUser(upsertUserRequest.toUser());
        return buildSuccessResponse(createUserResponseData(user));
    }

    public User getAuthenticatedUser(String userToken) {
        return userService.getAuthenticatedUser(userToken);
    }

    public SuccessResponse authenticateUser(
            AuthenticateUserRequest authenticateUserRequest) throws Exception {
        User userToAuthenticate = authenticateUserRequest.toUser();
        User authenticatedUser = userService.authenticateUser(userToAuthenticate);
        Role userRole = roleService.getRole(authenticatedUser.getRoleId());
        ArrayList permissions = roleService.getPermissionCodesForRole(userRole.getId());
        Token token = userService.createToken(authenticatedUser);
        Map<String, Object> data = createUserResponseData(authenticatedUser);
        data.put("permission", permissions);
        data.put("auth", AuthResponse.fromToken(token));
        return buildSuccessResponse(data);
    }

    public SuccessResponse logoutUser(User user, String token) {
        userService.logout(token);
        user.setLastLoginDate(TimeUtil.now());
        return buildSuccessResponse(createUserResponseData(user));
    }

    private String fetchRoleId(UpsertUserRequest upsertUserRequest){
        if(upsertUserRequest.getRoleId()==null ){
            upsertUserRequest.setRoleId(roleService.fetchRoleById(USER_ROLE_ID).getUniqueKey());
        }
        return upsertUserRequest.getRoleId();
    }

    private Map<String, Object> createUserResponseData(User user) {
        UserResponse userResponse = UserResponse.fromUser(user);
        Map<String, Object> data = new HashMap<>(1);
        data.put("user", userResponse);
        return data;
    }

    public SuccessResponse createRole(UpsertRoleRequest roleRequest) throws Exception {
        Role role = roleService.createRole(roleRequest);
        return buildSuccessResponse(createRoleResponseData(role));
    }

    public SuccessResponse createPermission(
            UpsertPermissionRequest upsertPermissionRequest) throws Exception {
        Permission permission = permissionService.createPermission(upsertPermissionRequest);
        return buildSuccessResponse(createPermissionResponseData(permission));
    }

    public SuccessResponse updateRole(
            UpsertRoleRequest upsertRoleRequest, String roleKey) throws Exception {
        Role roleToUpdate = roleService.fetchByUniqueKey(roleKey);
        Role savedRole = roleService.updateRole(roleToUpdate, upsertRoleRequest);
        return buildSuccessResponse(createRoleResponseData(savedRole));
    }

    private Map<String, Object> createRoleResponseData(Role role) {
        RoleResponse roleResponse = RoleResponse.fromRole(role);
        Map<String, Object> data = new HashMap<>(1);
        data.put("role", roleResponse);
        return data;
    }

    private Map<String, Object> createPermissionResponseData(Permission permission) {
        PermissionResponse permissionResponse = PermissionResponse.fromPermission(permission);
        Map<String, Object> data = new HashMap<>(1);
        data.put("permission", permissionResponse);
        return data;
    }

    public SuccessResponse toCreateApplication(
            UpsertApplicationRequest request) throws Exception {
        ApplicantResponse createdApplicantResponse = applicantService
                .createApplicant(request, request.toApplicant());
        return buildSuccessResponse(createApplicantResponseData(createdApplicantResponse));
    }

    private Map<String, Object> createApplicantResponseData(
            ApplicantResponse createdApplicantResponse) {
        Map<String, Object> data = new HashMap<>(1);
        data.put("applicant", createdApplicantResponse);
        return data;
    }

    public SuccessResponse viewAllApplicants(User authenticatedUser) throws Exception {
        ArrayList permissions = roleService
                .getPermissionCodesForRole(roleService.getRole(authenticatedUser.getRoleId()).getId());
        permissionHandler.hasPermission(permissions, "applicant_view");
        List<Applicant> allApplicants = applicantService
                .fetchAllApplicants();
        return buildSuccessResponse(getApplicantsResponseData(allApplicants));
    }

    private Map<String, Object> getApplicantsResponseData(
            List<Applicant> allApplicants) {
        List<ApplicantResponse> response = ApplicantResponse.fromSavedApplicants(allApplicants);
        Map<String, Object> data = new HashMap<>(1);
        data.put("applicant", response);
        return data;
    }
}