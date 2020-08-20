package com.adio.consultancy.group.recruitment.model.response;

import com.adio.consultancy.group.recruitment.model.entity.Applicant;
import com.adio.consultancy.group.recruitment.util.TimeUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kolawole
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ApplicantResponse {

    private String code;
    private String message;
    private String surname;
    private String firstName;
    private String phoneNumber;
    private String coverLetter;
    private String emailAddress;
    private String uniqueKey;
    private String passPort;
    private String resume;
    private String createdAt;
    private String updatedAt;

    public static ApplicantResponse fromSavedApplicant(Applicant applicant){
        return ApplicantResponse
                .builder()
                .surname(applicant.getSurname())
                .firstName(applicant.getFirstName())
                .phoneNumber(applicant.getPhoneNumber())
                .coverLetter(applicant.getCoverLetter())
                .emailAddress(applicant.getEmailAddress())
                .uniqueKey(applicant.getUniqueKey())
                .passPort(applicant.getPassPort())
                .resume(applicant.getResume())
                .createdAt(TimeUtil.getIsoTime(applicant.getCreatedAt()))
                .updatedAt(TimeUtil.getIsoTime(applicant.getUpdatedAt()))
                .build();
    }

    public static List<ApplicantResponse> fromSavedApplicants(List<Applicant> applicants) {
        return applicants.stream().map(applicant -> {
            return fromSavedApplicant(applicant);
        }).collect(
                Collectors.toList());
    }
}
