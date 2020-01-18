package com.example.demo.service;

import com.example.demo.dao.BaseRepository;
import com.example.demo.domain.BaseDomainObject;
import com.example.demo.utils.UUIDUtil;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public interface BaseService<T extends BaseDomainObject> {

	BaseRepository<T> repository();

	default void create(T t) {
		if (StringUtils.isBlank(t.getId())) {
			t.setId(UUIDUtil.generateUUID());
		}
		this.repository().save(t);
	}

	default void update(T t) {
		assert StringUtils.isNotBlank(t.getId());
		this.repository().save(t);
	}

	default void delete(T t) {
		this.repository().delete(t);
	}

	default T findById(String id) {
		return this.repository().findById(id).orElse(null);
	}

	default long count() {
		return this.repository().count();
	}

	default long count(Specification<T> specification) {
		return this.repository().count(specification);
	}

	default long count(Example<T> example) {
		return this.repository().count(example);
	}

	default List<T> findAll() {
		return this.repository().findAll();
	}

	default List<T> findAll(Specification<T> specification) {
		return this.repository().findAll(specification);
	}

	default List<T> findAll(Sort sort) {
		return this.repository().findAll(sort);
	}

	default List<T> findAll(Specification<T> specification, Sort sort) {
		return this.repository().findAll(specification, sort);
	}

	default List<T> findAll(Example<T> example) {
		return this.repository().findAll(example);
	}

	default List<T> findAll(Example<T> example, Sort sort) {
		return this.repository().findAll(example, sort);
	}

	default Page<T> findAll(Pageable pageable) {
		return this.repository().findAll(pageable);
	}

	default Page<T> findAll(Specification<T> specification, Pageable pageable) {
		return this.repository().findAll(specification, pageable);
	}

	default Page<T> findAll(Example<T> example, Pageable pageable) {
		return this.repository().findAll(example, pageable);
	}
}
