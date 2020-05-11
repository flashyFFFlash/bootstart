package com.example.demo.usersystem.dao;

import com.example.demo.usersystem.domain.BaseDomainObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends BaseDomainObject> extends JpaRepository<T, String>, JpaSpecificationExecutor<T> {

}
