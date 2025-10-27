package com.example.demo.service;

import java.util.List;

public interface GenericService <T, ID> {
	List<T> findAll();
    T findById(ID id);
    T save(T entity);
    void delete(ID id);
}
