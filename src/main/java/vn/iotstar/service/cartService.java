package vn.iotstar.service;

import java.util.List;

import vn.iotstar.model.Cart;

public interface cartService {
	void insert(Cart cart);

	void edit(Cart cart);

	void delete(int id);

	Cart get(int id);
	
	Cart findByUserAndStore(int userId, int storeId);
	List<Cart> getAll();
	
	List<Cart> findByUserId(int userId);
	
	List<Cart> getAllProduct(int id);

	List<Cart> findAll();

	List<Cart> search(String keyword);
}
