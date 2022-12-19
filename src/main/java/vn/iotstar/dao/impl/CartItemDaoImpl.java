package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.CartItemDao;
import vn.iotstar.model.CartItem;
import vn.iotstar.service.productService;
import vn.iotstar.service.impl.productServiceImpl;

public class CartItemDaoImpl extends DBConnection implements CartItemDao {

	public CartItemDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(CartItem cartItem) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO cartItem (cartId, productId, count)" + "VALUES (?,?,?)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cartItem.getCartId());
			ps.setInt(2, cartItem.getProductId());
			ps.setInt(3, cartItem.getCount());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(CartItem cartItem) {
		// TODO Auto-generated method stub
		String sql = "UPDATE cartItem " + "SET cartId = ?, productId = ?, count = ? " + "WHERE id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cartItem.getCartId());
			ps.setInt(2, cartItem.getProductId());
			ps.setInt(3, cartItem.getCount());
			ps.setInt(4, cartItem.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM cartItem WHERE id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CartItem> findAllByCart(int cartId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM CartItem WHERE cartId = ?";
		List<CartItem> cartItems = new ArrayList<CartItem>();
		productService productService = new productServiceImpl();
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cartId);
			ResultSet rs=ps.executeQuery();
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cartId);
			rs = ps.executeQuery();
			while (rs.next()) {
				CartItem cartItem = new CartItem();
				cartItem.setId(rs.getInt("id"));
				cartItem.setCartId(rs.getInt("cartId"));
				cartItem.setProductId(rs.getInt("productId"));
				cartItem.setCount(rs.getInt("count"));
				cartItem.setProduct(productService.get(cartItem.getProductId()));
				cartItems.add(cartItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartItems;
	}

	@Override
	public CartItem findById(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM cartItem WHERE id = ?";
		productService productService = new productServiceImpl();
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				CartItem cartItem = new CartItem();
				cartItem.setId(rs.getInt("id"));
				cartItem.setCartId(rs.getInt("cartId"));
				cartItem.setProductId(rs.getInt("productId"));
				cartItem.setCount(rs.getInt("count"));
				cartItem.setProduct(productService.findById(cartItem.getProductId()));
				return cartItem;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CartItem findByCartAndProduct(int cartId, int productId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM cartItem WHERE cartId = ? AND productId = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cartId);
			ps.setInt(2, productId);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				CartItem cartItem = new CartItem();
				cartItem.setId(rs.getInt("id"));
				cartItem.setCartId(rs.getInt("cartId"));
				cartItem.setProductId(rs.getInt("productId"));
				cartItem.setCount(rs.getInt("count"));
				return cartItem;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
