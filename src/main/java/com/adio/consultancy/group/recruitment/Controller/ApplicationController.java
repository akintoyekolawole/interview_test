package com.adio.consultancy.group.recruitment.Controller;

import com.adio.consultancy.group.recruitment.Service.facade.AccountFacade;
import com.adio.consultancy.group.recruitment.model.request.UpsertApplicationRequest;
import com.adio.consultancy.group.recruitment.model.response.RecruitmentApiResponse;
import com.adio.consultancy.group.recruitment.model.response.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author Kolawole
 */
@RestController
@RequestMapping(path = "/v1/apply")
public class ApplicationController {

    private final AccountFacade accountFacade;

    public ApplicationController(AccountFacade accountFacade) {
        Assert.notNull(accountFacade);
        this.accountFacade = accountFacade;
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<RecruitmentApiResponse> toCreateApplication(
          UpsertApplicationRequest request ) throws Exception {
        SuccessResponse response = accountFacade.toCreateApplication(request);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}
