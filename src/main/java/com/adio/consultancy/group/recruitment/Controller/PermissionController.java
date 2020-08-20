package com.adio.consultancy.group.recruitment.Controller;

import com.adio.consultancy.group.recruitment.model.request.UpsertPermissionRequest;
import com.adio.consultancy.group.recruitment.model.response.RecruitmentApiResponse;
import com.adio.consultancy.group.recruitment.model.response.SuccessResponse;
import com.adio.consultancy.group.recruitment.validator.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author kolawole
 */
@RestController
@RequestMapping("/permissions")
public class PermissionController {

  private final AccountFacade accountFacade;

  @Autowired
  public PermissionController(AccountFacade accountFacade) {
    Assert.notNull(accountFacade);
    this.accountFacade = accountFacade;
  }

  @Transactional
  @RequestMapping(
          method = RequestMethod.POST,
          produces = "application/json")
  public ResponseEntity<RecruitmentApiResponse> createPermissions(
          @Valid @RequestBody UpsertPermissionRequest upsertPermissionRequest,
          BindingResult bindingResult
  )throws Exception{
    InputValidator.validate(bindingResult);
    SuccessResponse response = accountFacade
            .createPermission(upsertPermissionRequest);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @Transactional
  @RequestMapping(
          method = RequestMethod.GET,
          produces = "application/json")
  public ResponseEntity<RecruitmentApiResponse> getPermissions(
      @RequestHeader("Token") String userToken)
      throws Exception {
    SuccessResponse response = accountFacade
            .getAllPermissions(authenticatedUser);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

}
