package com.adio.consultancy.group.recruitment.model.request;

import com.adio.consultancy.group.recruitment.model.entity.Applicant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author Kolawole
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpsertApplicationRequest {

    private String surname;
    private String firstName;
    private String phoneNumber;
    private String coverLetter;
    private String emailAddress;
    private String uniqueKey;
    private MultipartFile passPort;
    private MultipartFile resume;
    private File attachedFile;
    private File attachedFileTwo;

    public Applicant toApplicant(){
        Applicant applicant = new Applicant();
        applicant.setSurname(surname);
        applicant.setFirstName(firstName);
        applicant.setPhoneNumber(phoneNumber);
        applicant.setCoverLetter(coverLetter);
        applicant.setEmailAddress(emailAddress);
        applicant.setUniqueKey(uniqueKey);
        return applicant;
    }
}
