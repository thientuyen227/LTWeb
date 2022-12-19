package vn.iotstar.service;

import java.util.List;

import vn.iotstar.model.category;

public interface categoryService {
	void insert(category category);

	void edit(category category);

	void delete(int id);

	category get(int id);


	List<category> getAll();
	
	List<category> findAll();

	List<category> search(String keyword);
}
