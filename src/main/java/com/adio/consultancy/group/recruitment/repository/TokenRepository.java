package com.adio.consultancy.group.recruitment.repository;

import com.adio.consultancy.group.recruitment.model.entity.Token;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kolawole
 */
@Repository
public interface TokenRepository extends PagingAndSortingRepository<Token, Long> {

  Token findOneByToken(String token);

  Token findOneByUserAndToken(String userKey, String token);
}
