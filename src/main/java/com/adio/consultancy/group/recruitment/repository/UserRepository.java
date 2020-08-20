package com.adio.consultancy.group.recruitment.repository;

import com.adio.consultancy.group.recruitment.model.entity.User;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long>{

    User findOneById(Integer id);

    User findOneByUniqueKey(String UniqueKey);

    User findOneByEmail(String email);

    User findOneByPhone(String phone);

    List<User> findAll();

}
