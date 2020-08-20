package com.adio.consultancy.group.recruitment.model.request;

import com.adio.consultancy.group.recruitment.model.constants.Status;
import com.adio.consultancy.group.recruitment.model.entity.User;
import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @author Kolawole
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class UpsertUserRequest {
    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NotNull
    @NotEmpty
    private String address;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String phone;
    private String roleId;
    private Status status;


    public User toUser() {
        User user = new User();
        user.setAddress(address);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        user.setRoleId(roleId);
        if (status != null) {
            user.setStatus(status);
        }
        return user;
    }
}
