package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.category;

public interface CategoryDao {
	void insert(category category);

	void edit(category category);

	void delete(int categoryId);

	category get(int categoryId);


	List<category> getAll();

	List<category> findAll();
	
	List<category> search(String keyword);
}
