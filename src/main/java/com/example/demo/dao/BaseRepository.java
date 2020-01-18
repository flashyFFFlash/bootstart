package com.example.demo.dao;

import com.example.demo.domain.BaseDomainObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends BaseDomainObject> extends JpaRepository<T, String>, JpaSpecificationExecutor<T> {

}
