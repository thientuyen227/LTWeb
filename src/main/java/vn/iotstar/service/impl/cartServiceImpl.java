package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.CartDao;
import vn.iotstar.dao.impl.CartDaoImpl;
import vn.iotstar.model.Cart;
import vn.iotstar.service.cartService;

public class cartServiceImpl extends DBConnection implements cartService {

	CartDao cartDao = new CartDaoImpl();
	@Override
	public void insert(Cart cart) {
		// TODO Auto-generated method stub
		cartDao.insert(cart);
	}

	@Override
	public void edit(Cart cart) {
		// TODO Auto-generated method stub
		cartDao.edit(cart);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		cartDao.delete(id);
	}

	@Override
	public Cart get(int id) {
		// TODO Auto-generated method stub
		return cartDao.get(id);
	}

	@Override
	public List<Cart> getAllProduct( int id) {
		// TODO Auto-generated method stub
		return cartDao.getAllProduct(id);
	}

	@Override
	public List<Cart> findAll() {
		// TODO Auto-generated method stub
		return cartDao.findAll();
	}

	@Override
	public List<Cart> search(String keyword) {
		// TODO Auto-generated method stub
		return cartDao.search(keyword);
	}

	@Override
	public List<Cart> getAll() {
		// TODO Auto-generated method stub
		return cartDao.getAll();
	}

	@Override
	public List<Cart> findByUserId(int userId) {
		// TODO Auto-generated method stub
		return cartDao.findByUserId(userId);
	}

	@Override
	public Cart findByUserAndStore(int userId, int storeId) {
		// TODO Auto-generated method stub
		return cartDao.findByUserAndStore(userId, storeId);
	}

}
