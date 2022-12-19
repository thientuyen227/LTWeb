package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.CategoryDao;
import vn.iotstar.dao.impl.CategoryDaoImpl;
import vn.iotstar.model.category;
import vn.iotstar.service.categoryService;

public class categoryServiceImpl extends DBConnection implements categoryService {
	CategoryDao categoryDao = new CategoryDaoImpl();
	@Override
	public void insert(category category) {
		// TODO Auto-generated method stub
		categoryDao.insert(category);
	}

	@Override
	public void edit(category newcategory) {
		// TODO Auto-generated method stub
		
		categoryDao.edit(newcategory);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		categoryDao.delete(id);
	}

	@Override
	public category get(int id) {
		// TODO Auto-generated method stub
		return categoryDao.get(id);
		
	}

	@Override
	public List<category> getAll() {
		// TODO Auto-generated method stub
		return categoryDao.getAll();
	}

	@Override
	public List<category> search(String keyword) {
		// TODO Auto-generated method stub
		return categoryDao.search(keyword);
	}

	@Override
	public List<category> findAll() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}

}
