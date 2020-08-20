package com.adio.consultancy.group.recruitment.repository;

import com.adio.consultancy.group.recruitment.model.entity.Applicant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicantRepository extends PagingAndSortingRepository<Applicant, Long> {

    List<Applicant> findAll();
}
