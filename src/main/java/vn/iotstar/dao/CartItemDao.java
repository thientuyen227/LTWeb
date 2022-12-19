package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.CartItem;

public interface CartItemDao {

	void insert(CartItem cartItem);

	void edit(CartItem cartItem);

	void delete(int id);
	CartItem findByCartAndProduct(int cartId, int productId);
	List<CartItem> findAllByCart(int cartId);

	CartItem findById(int id);

}
