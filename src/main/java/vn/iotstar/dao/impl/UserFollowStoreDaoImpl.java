package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.UserFollowStoreDao;	
import vn.iotstar.model.UserFollowStore;
import vn.iotstar.service.storeService;
import vn.iotstar.service.userService;
import vn.iotstar.service.impl.storeServiceImpl;
import vn.iotstar.service.impl.userServiceImpl;

public class UserFollowStoreDaoImpl extends DBConnection implements UserFollowStoreDao {

	public UserFollowStoreDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(UserFollowStore userFollowStore) {
		// TODO Auto-generated method stub
		String sql = "insert into userfollowstore(userId, storeId) values(?, ?)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userFollowStore.getUserId());
			ps.setInt(2, userFollowStore.getStoreId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from userfollowstore where id = ?";
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
	public List<UserFollowStore> findByUserId(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from userfollowstore where userId = ?";
		List<UserFollowStore> userFollowStores = new ArrayList<UserFollowStore>();
		userService userService = new userServiceImpl();
		storeService storeService = new storeServiceImpl();
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserFollowStore userFollowStore = new UserFollowStore();
				userFollowStore.setId(rs.getInt("id"));
				userFollowStore.setUserId(rs.getInt("userId"));
				userFollowStore.setStoreId(rs.getInt("storeId"));
				userFollowStore.setStore(storeService.get(userFollowStore.getStoreId()));
				userFollowStore.setUser(userService.get(userFollowStore.getUserId()));
				userFollowStores.add(userFollowStore);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userFollowStores;
	}

}
