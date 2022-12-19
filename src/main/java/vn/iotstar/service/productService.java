package vn.iotstar.service;

import java.util.List;

import vn.iotstar.model.product;

public interface productService {
	void insert(product product);

	void edit(product product);

	void delete(int id);
	void isActive(int isActive,int id);

	product get(int id);

	
	product findById(int id);
	
	List<product> getAllProductByAdmin();
	List<product> getProductOfStore(int storeId);
	
	List<product> getAll();
	
	List<product> newListProduct();
	
	List<product> filterByPrice(String price0);
	
	List<product> filterByRating(int index);
	
	List<product> listShowing(int index);
	
	List<product> getTopRating(int index);

	List<product> searchProductByName(String keyword);
}
