package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.CartItemDao;
import vn.iotstar.dao.impl.CartItemDaoImpl;
import vn.iotstar.model.CartItem;
import vn.iotstar.service.cartItemService;

public class cartItemServiceImpl extends DBConnection implements cartItemService {

	CartItemDao cartItemDao = new CartItemDaoImpl();
	
	public cartItemServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartItemDao.insert(cartItem);
	}

	@Override
	public void edit(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartItemDao.edit(cartItem);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		cartItemDao.delete(id);
	}

	@Override
	public List<CartItem> findAllByCart(int cartId) {
		// TODO Auto-generated method stub
		return cartItemDao.findAllByCart(cartId);
	}

	@Override
	public CartItem findById(int id) {
		// TODO Auto-generated method stub
		return cartItemDao.findById(id);
	}

	@Override
	public CartItem findByCartAndProduct(int cartId, int productId) {
		// TODO Auto-generated method stub
		return cartItemDao.findByCartAndProduct(cartId, productId);
	}

}
