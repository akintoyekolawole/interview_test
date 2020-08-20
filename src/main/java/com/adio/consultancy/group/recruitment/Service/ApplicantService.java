package com.adio.consultancy.group.recruitment.Service;

import com.adio.consultancy.group.recruitment.model.entity.Applicant;
import com.adio.consultancy.group.recruitment.model.request.UpsertApplicationRequest;
import com.adio.consultancy.group.recruitment.model.response.ApplicantResponse;
import com.adio.consultancy.group.recruitment.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @author Kolawole
 */
@Service
public class ApplicantService {

    private final ApplicantRepository applicantRepository;
    private final String UPLOADS_FILE_PATH = "files//";

    public ApplicantService(
            ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public ApplicantResponse createApplicant(
            UpsertApplicationRequest request, Applicant applicantToCreate) throws Exception {
        ApplicantResponse applicantResponse = new ApplicantResponse();
        int checker = checkApplicantCount();
        if(checker == 01){
            applicantResponse.setCode("01");
            applicantResponse.setMessage("Application Closed");
            return applicantResponse;
        }else {
            treatuploadedFile(request, applicantToCreate);
            applicantResponse.setCode("00");
            applicantResponse.setMessage("Application Submitted Successfully");
            return applicantResponse;
        }
    }

    private int checkApplicantCount() {
        List<Applicant> fetchAllApplicants = applicantRepository.findAll();
        Long applicantCount = fetchAllApplicants.stream().count();
        int count = applicantCount.intValue();
        int responseCode = 0;
        if (count >= 4) {
            responseCode = 01;
            return responseCode;
        }
        return responseCode;
    }

    private void treatuploadedFile(
            UpsertApplicationRequest request, Applicant applicantToCreate) throws Exception {
        File attachedFile = null;
        if (request.getResume() != null) {
            String uploadedResume = convertMultipartFileToFile(request, attachedFile);
            String uploadedPassport = convertMultipartFileToFilePassport(request, attachedFile);
            applicantToCreate.setResume(uploadedResume);
            applicantToCreate.setPassPort(uploadedPassport);
        }

        applicantRepository.save(applicantToCreate);
    }

    private String convertMultipartFileToFile(UpsertApplicationRequest request, File attachedFile)
            throws Exception {
        attachedFile = new File(
                UPLOADS_FILE_PATH + "-" + request.getResume()
                        .getOriginalFilename());
        attachedFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(attachedFile);
        fos.write(request.getResume().getBytes());
        fos.close();
        request.setAttachedFile(attachedFile);
        attachedFile.getAbsolutePath();
        return String.valueOf(request.getAttachedFile());
    }

    private String convertMultipartFileToFilePassport(UpsertApplicationRequest request, File attachedFile)
            throws Exception {
        attachedFile = new File(
                UPLOADS_FILE_PATH + "-" + request.getPassPort()
                        .getOriginalFilename());
        attachedFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(attachedFile);
        fos.write(request.getPassPort().getBytes());
        fos.close();
        request.setAttachedFile(attachedFile);
        attachedFile.getAbsolutePath();
        return String.valueOf(request.getAttachedFile());
    }

    public List<Applicant> fetchAllApplicants(){
        List<Applicant> allApplicants = applicantRepository.findAll();
        return allApplicants;
    }

}
