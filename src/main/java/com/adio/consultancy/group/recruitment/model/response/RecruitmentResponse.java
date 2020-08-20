package com.adio.consultancy.group.recruitment.model.response;

import com.emmanuel.appraisal.model.entity.Recruitment;
import com.emmanuel.appraisal.util.TimeUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kolawole
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecruitmentResponse {

    private String surname;
    private String firstName;
    private String middleName;
    private String sex;
    private String age;
    private String maritalStatus;
    private String employeeNumber;
    private String nameOfSchool;
    private String level;
    private String status;
    private String createdAt;
    private String updatedAt;
    private String uniqueKey;
    private String email;
    private String department;
    private String entitleNumberOfDays;

    public static RecruitmentResponse fromStaffUpdate(Recruitment recruitment){
        return RecruitmentResponse.builder()
                .age(recruitment.getAge())
                .email(recruitment.getEmail())
                .uniqueKey(recruitment.getUniqueKey())
                .status(String.valueOf(recruitment.getStatus()))
                .firstName(recruitment.getFirstName())
                .middleName(recruitment.getMiddleName())
                .surname(recruitment.getSurname())
                .sex(recruitment.getSex())
                .maritalStatus(String.valueOf(recruitment.getMaritalStatus()))
                .employeeNumber(recruitment.getEmployeeNumber())
                .nameOfSchool(recruitment.getNameOfSchool())
                .level(recruitment.getLevel())
                .department(recruitment.getDepartment())
                .entitleNumberOfDays(recruitment.getEntitledLeaveDays())
                .createdAt(TimeUtil.getIsoTime(recruitment.getCreatedAt()))
                .updatedAt(TimeUtil.getIsoTime(recruitment.getUpdatedAt()))
                .build();
    }

    public static List<RecruitmentResponse> fromStaff(List<Recruitment> staffs) {
        return staffs.stream().map(staff -> {
            return fromStaffUpdate(staff);
        }).collect(
                Collectors.toList());
    }
}
