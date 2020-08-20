package com.adio.consultancy.group.recruitment.repository;

import com.adio.consultancy.group.recruitment.model.constants.Status;
import com.adio.consultancy.group.recruitment.model.entity.Role;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kolawole
 */
@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Long>,
    QueryDslPredicateExecutor<Role> {

  List<Role> findAllByUniqueKey(String uniqueKey);

  List<Role> findAll();

  Role findOneByUniqueKey(String uniqueKey);

  Role findOneById(Integer id);

  List<Role> findAllByIsHidden(Status isHidden);
}
