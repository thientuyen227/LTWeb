package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.ProductDao;
import vn.iotstar.dao.impl.ProductDaoImpl;
import vn.iotstar.model.product;
import vn.iotstar.service.productService;

public class productServiceImpl extends DBConnection implements productService{
	ProductDao productDao = new ProductDaoImpl();
	@Override
	public void insert(product product) {
		// TODO Auto-generated method stub
		productDao.insert(product);
	}

	@Override
	public void edit(product product) {
		// TODO Auto-generated method stub
		productDao.edit(product);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		productDao.delete(id);
	}

	@Override
	public product get(int id) {
		// TODO Auto-generated method stub
		return productDao.get(id);
	}


	@Override
	public List<product> getAll() {
		// TODO Auto-generated method stub
		return productDao.getAll();
	}

	@Override
	public List<product> searchProductByName(String keyword) {
		// TODO Auto-generated method stub
		return productDao.searchProductByName(keyword);
	}

	@Override
	public List<product> newListProduct() {
		// TODO Auto-generated method stub
		return productDao.newProductList();
	}

	@Override
	public List<product> getTopRating(int index) {
		// TODO Auto-generated method stub
		return productDao.getTopRating(index);
	}

	@Override
	public List<product> filterByPrice(String price0) {
		// TODO Auto-generated method stub
		return productDao.filterByPrice(price0);
	}

	@Override
	public List<product> filterByRating(int index) {
		// TODO Auto-generated method stub
		return productDao.filterByRating(index);
	}

	@Override
	public List<product> listShowing(int index) {
		// TODO Auto-generated method stub
		return productDao.listShowing(index);
	}

	@Override
	public product findById(int id) {
		// TODO Auto-generated method stub
		return productDao.findById(id);
	}

	@Override
	public void isActive(int isActive, int id) {
		// TODO Auto-generated method stub
		productDao.isActive(isActive, id);
	}

	@Override
	public List<product> getAllProductByAdmin() {
		// TODO Auto-generated method stub
		return productDao.getAllProductByAdmin();
	}




}
