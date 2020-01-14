package com.example.demo.service;

import com.example.demo.dao.BaseRepository;

public interface BaseService<T> {

	BaseRepository<T> repository();

	default void create(T t) {
		this.repository().save(t);
	}

	default void update(T t) {
		this.repository().save(t);
	}

	default void delete(T t) {
		this.repository().delete(t);
	}

	default T findById(String id) {
		return this.repository().findById(id).orElse(null);
	}

}
