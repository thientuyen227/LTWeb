package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.product;

public interface ProductDao {
	void insert(product product);

	void edit(product product);

	void delete(int id);
	
	void isActive(int isActive,int id);

	product get(int id);

	// Category get(String name);

	List<product> getAll();
	List<product> getProductOfStore(int storeId);
	List<product> getAllProductByAdmin();
	
	product findById(int id);
	//static int countAll();
	List<product> newProductList();
	
	List<product> filterByPrice(String price0);
	
	List<product> filterByRating(int index);
	
	List<product> listShowing(int index);

	List<product> getTopRating(int index);

	List<product> searchProductByName(String keyword);
}