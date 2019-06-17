package com.example.demo.dao;

import com.example.demo.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * .
 *
 * @author gxj
 * @since 19-6-17
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {


}
