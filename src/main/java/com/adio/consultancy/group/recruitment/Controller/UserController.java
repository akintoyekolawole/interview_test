package com.adio.consultancy.group.recruitment.Controller;

import com.adio.consultancy.group.recruitment.Service.facade.AccountFacade;
import com.adio.consultancy.group.recruitment.model.entity.User;
import com.adio.consultancy.group.recruitment.model.request.AuthenticateUserRequest;
import com.adio.consultancy.group.recruitment.model.request.UpsertUserRequest;
import com.adio.consultancy.group.recruitment.model.response.RecruitmentApiResponse;
import com.adio.consultancy.group.recruitment.model.response.SuccessResponse;
import com.adio.consultancy.group.recruitment.validator.InputValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Kolawole
 */
@RestController
@RequestMapping(path = "/v1/users")
public class UserController {

    private final AccountFacade accountFacade;

    public UserController(AccountFacade accountFacade) {
        Assert.notNull(accountFacade);
        this.accountFacade = accountFacade;
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<RecruitmentApiResponse> toCreateUser(
            @Valid @RequestBody UpsertUserRequest upsertUserRequest,
            BindingResult bindingResult) throws Exception {
        InputValidator.validate(bindingResult);
        SuccessResponse response = accountFacade.createUser(upsertUserRequest);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @RequestMapping(
            path = "/authenticate",
            method = RequestMethod.POST,
            produces = "application/json")
    public ResponseEntity<RecruitmentApiResponse> authenticate(
            @Valid @RequestBody AuthenticateUserRequest request,
            BindingResult bindingResult) throws Exception {
        InputValidator.validate(bindingResult);
        SuccessResponse response = accountFacade.authenticateUser(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/logout",
            produces = "application/json")
    public ResponseEntity<RecruitmentApiResponse> logout(
            @RequestHeader("S-User-Token") String userToken
    ) {
        User user = accountFacade.getAuthenticatedUser(userToken);
        SuccessResponse response = accountFacade.logoutUser(user, userToken);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/applicants",
            produces = "application/json")
    public ResponseEntity<RecruitmentApiResponse> viewAllApplicants(
            @RequestHeader("S-User-Token") String userToken
    ) throws Exception {
        User user = accountFacade.getAuthenticatedUser(userToken);
        SuccessResponse response = accountFacade.viewAllApplicants(user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}