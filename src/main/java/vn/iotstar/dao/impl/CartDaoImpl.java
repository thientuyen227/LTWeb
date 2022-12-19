package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.CartDao;
import vn.iotstar.model.Cart;
import vn.iotstar.service.cartItemService;
import vn.iotstar.service.storeService;
import vn.iotstar.service.impl.cartItemServiceImpl;
import vn.iotstar.service.impl.storeServiceImpl;

public class CartDaoImpl extends DBConnection implements CartDao {

	@Override
	public void insert(Cart cart) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO cart (userId, storeId)" + "VALUES (?,?)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cart.getUserId());
			ps.setInt(2, cart.getStoreId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Cart cart) {
		// TODO Auto-generated method stub
		String sql = "UPDATE cart " + "SET userId = ?, storeId = ?" + "WHERE id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cart.getUserId());
			ps.setInt(2, cart.getStoreId());
			ps.setInt(3, cart.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM cart WHERE id = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Cart get(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM cart WHERE id = ?";
		cartItemService cartItemService = new cartItemServiceImpl();
		storeService storeService = new storeServiceImpl();
		try {
			Connection getConnection = super.getConnection();
			PreparedStatement ps = getConnection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Cart cart = new Cart();
				cart.setId(resultSet.getInt("id"));
				cart.setUserId(resultSet.getInt("userId"));
				cart.setStoreId(resultSet.getInt("storeId"));
				cart.setStore(storeService.get(cart.getStoreId()));
				cart.setCartItems(cartItemService.findAllByCart(cart.getId()));
				return cart;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Cart> getAllProduct(int id) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM Cart where id = ?";
		cartItemService cartItemService = new cartItemServiceImpl();
		storeService storeService = new storeServiceImpl();
		List<Cart> carts =new ArrayList<Cart>();
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cart cart = new Cart();
				cart.setId(rs.getInt("id"));
				cart.setUserId(rs.getInt("userId"));
				cart.setStoreId(rs.getInt("storeId"));
				cart.setStore(storeService.get(cart.getStoreId()));
				cart.setCartItems(cartItemService.findAllByCart(cart.getId()));
				carts.add(cart);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return carts;
	}

	@Override
	public List<Cart> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> getAll() {
		String sql="select * from cart";
		List<Cart> carts =new ArrayList<Cart>();
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cart cart = new Cart();
				cart.setId(rs.getInt("id"));
				cart.setUserId(rs.getInt("userId"));
				cart.setStoreId(rs.getInt("storeId"));
				carts.add(cart);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return carts;
	}


	@Override
	public List<Cart> findByUserId(int userId) {
		// TODO Auto-generated method stub
		String sql = "SELECT DISTINCT Cart.* FROM Cart INNER JOIN CartItem ON Cart.id = CartItem.cartId WHERE Cart.userId = ?";
		List<Cart> carts = new ArrayList<Cart>();
		cartItemService cartItemService = new cartItemServiceImpl();
		storeService storeService = new storeServiceImpl();
		try {
			Connection getConnection = super.getConnection();
			PreparedStatement pStatement = getConnection.prepareStatement(sql);
			pStatement.setInt(1, userId);
			ResultSet rs = pStatement.executeQuery();
			while (rs.next()) {
				Cart cart = new Cart();
				cart.setId(rs.getInt("id"));
				cart.setUserId(rs.getInt("userId"));
				cart.setStoreId(rs.getInt("storeId"));
				cart.setStore(storeService.get(cart.getStoreId()));
				cart.setCartItems(cartItemService.findAllByCart(cart.getId()));
				carts.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carts;
	}

	@Override
	public Cart findByUserAndStore(int userId, int storeId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM cart WHERE userId = ? AND storeId = ?";
		try {
			Connection getConnection = super.getConnection();
			PreparedStatement pStatement = getConnection.prepareStatement(sql);
			pStatement.setInt(1, userId);
			pStatement.setInt(2, storeId);
			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				Cart cart = new Cart();
				cart.setId(resultSet.getInt("id"));
				cart.setUserId(resultSet.getInt("userId"));
				cart.setStoreId(resultSet.getInt("storeId"));
				return cart;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
