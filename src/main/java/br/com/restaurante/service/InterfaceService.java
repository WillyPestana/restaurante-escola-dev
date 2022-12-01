package br.com.restaurante.service;

import java.util.List;

public interface InterfaceService<T> {
	
	T create(T obj);

	T findById(Long id);

	List<T> findAll();

	boolean update(T obj);
	
	boolean delete(Long id);
}