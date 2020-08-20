package com.adio.consultancy.group.recruitment.model.response;

import com.adio.consultancy.group.recruitment.model.constants.Status;
import lombok.*;

import java.util.Map;

/**
 * @author Kolawole
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SuccessResponse extends RecruitmentApiResponse {

  private Status status;
  private Map<String, Object> data;
}
