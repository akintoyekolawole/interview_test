package com.adio.consultancy.group.recruitment.Controller;

import com.adio.consultancy.group.recruitment.Service.facade.AccountFacade;
import com.adio.consultancy.group.recruitment.model.request.UpsertRoleRequest;
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
@RequestMapping("/roles")
public class RoleController {

  private AccountFacade accountFacade;

  public RoleController(AccountFacade accountFacade){
    Assert.notNull(accountFacade);
    this.accountFacade=accountFacade;
  }

  @Transactional
  @RequestMapping(
          method = RequestMethod.POST,
          produces = "application/json")
  public ResponseEntity<RecruitmentApiResponse> createRole(
      @Valid @RequestBody UpsertRoleRequest upsertRoleRequest,
      BindingResult bindingResult
  )throws Exception{
    InputValidator.validate(bindingResult);
    SuccessResponse response = accountFacade.createRole(upsertRoleRequest);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }


  @Transactional
  @RequestMapping(
          method = RequestMethod.PUT,
          path = "/{roleKey}",
          produces = "application/json")
  public ResponseEntity<RecruitmentApiResponse> update(
          @PathVariable String roleKey,
          @RequestBody UpsertRoleRequest upsertRoleRequest
         ) throws Exception {
    SuccessResponse response = accountFacade
            .updateRole(upsertRoleRequest, roleKey);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
