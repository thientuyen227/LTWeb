package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.UserFollowProductDao;
import vn.iotstar.model.UserFollowProduct;
import vn.iotstar.service.productService;
import vn.iotstar.service.userService;
import vn.iotstar.service.impl.productServiceImpl;
import vn.iotstar.service.impl.userServiceImpl;

public class UserFollowProductDaoImpl extends DBConnection implements UserFollowProductDao {

	public UserFollowProductDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(UserFollowProduct userFollowProduct) {
		// TODO Auto-generated method stub
		String sql = "insert into userfollowproduct(userId, productId) values(?, ?)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userFollowProduct.getUserId());
			ps.setInt(2, userFollowProduct.getProductId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from userfollowproduct where id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<UserFollowProduct> findByUserId(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from userfollowproduct where userId = ?";
		List<UserFollowProduct> userFollowProducts = new ArrayList<UserFollowProduct>();
		userService userService = new userServiceImpl();
		productService productService = new productServiceImpl();
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserFollowProduct userFollowProduct = new UserFollowProduct();
				userFollowProduct.setId(rs.getInt("id"));
				userFollowProduct.setUserId(rs.getInt("userId"));
				userFollowProduct.setProductId(rs.getInt("productId"));
				userFollowProduct.setProduct(productService.get(userFollowProduct.getProductId()));
				userFollowProduct.setUser(userService.get(userFollowProduct.getUserId()));
				userFollowProducts.add(userFollowProduct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userFollowProducts;
	}

}
