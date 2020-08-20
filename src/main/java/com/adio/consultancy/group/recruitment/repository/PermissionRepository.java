package com.adio.consultancy.group.recruitment.repository;

import com.adio.consultancy.group.recruitment.model.constants.Status;
import com.adio.consultancy.group.recruitment.model.entity.Permission;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Kolawole
 */
@Repository
public interface PermissionRepository extends PagingAndSortingRepository<Permission, Long> {

  List<Permission> findAllByIdIn(List<Integer> ids);

  Permission findOneById(String id);

  List<Permission> findAllByStatus(Status status);

  List<String> findAllCodeByIdIn(List<Integer> ids);

  List<Permission> findAllByStatusAndIsHidden(Status status, Status isHidden);
}
