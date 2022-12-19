package vn.iotstar.service;

import java.util.List;

import vn.iotstar.model.CartItem;

public interface cartItemService {
	void insert(CartItem cartItem);

	void edit(CartItem cartItem);

	void delete(int id);

	List<CartItem> findAllByCart(int cartId);
	
	CartItem findById(int id);
	CartItem findByCartAndProduct(int cartId, int productId);
}
