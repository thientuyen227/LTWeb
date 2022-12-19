package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.StoreDao;
import vn.iotstar.model.Store;

public class StoreDaoImpl extends DBConnection implements StoreDao {
	@Override
	public void insert(Store store) {
		// TODO Auto-generated method stub
		String sql = "insert into store (name,bio,ownerId,avatar) values (?,?,?,?)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, store.getName());
			ps.setString(2, store.getBio());
			ps.setInt(3, store.getOwnerID());
			ps.setString(4, store.getAvatar());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Store store) {
		// TODO Auto-generated method stub
		String sql = "update store set name = ?, bio=?, ownerId=?, avatar=?"
				+ " where id= ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, store.getName());
			ps.setString(2, store.getBio());
			ps.setInt(3, store.getOwnerID());
			ps.setString(4, store.getAvatar());
			ps.setInt(5, store.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Store get(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM store where id=?";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Store store = new Store();
				store.setId(rs.getInt("id"));
				store.setAvatar(rs.getString("avatar"));
				store.setName(rs.getString("name"));
				store.setRating(rs.getInt("rating"));
				store.setOwnerID(rs.getInt("ownerId"));
				store.setCreateAt(rs.getTimestamp("createdAt"));
				return store;
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Store> findByUserId(int userId) {
		// TODO Auto-generated method stub
		List<Store> listStore = new ArrayList<Store>();
		String sql = "SELECT * from store where ownerId=?";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Store store = new Store();
				store.setId(rs.getInt("id"));
				store.setAvatar(rs.getString("avatar"));
				store.setName(rs.getString("name"));
				store.setRating(rs.getInt("rating"));
				store.setOwnerID(rs.getInt("ownerId"));
				store.setCreateAt(rs.getTimestamp("createdAt"));
				listStore.add(store);
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return listStore;
	}


	@Override
	public int totalStores() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<Store> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Store> findAllByName(String keyword) {
		// TODO Auto-generated method stub
		String sql = "select * from store where name like CONCAT('%', ?, '%')";
		List<Store> stores = new ArrayList<Store>();
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, keyword);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Store store = new Store();
				store.setId(rs.getInt("id"));
				store.setName(rs.getString("name"));
				store.setBio(rs.getString("bio"));
				store.setOwnerID(rs.getInt("ownerId"));
				store.setRating(rs.getInt("rating"));
				// store.setTotal(rs.getInt("total"));

				stores.add(store);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stores;
	}

	@Override
	public List<Store> getAll() {
		// TODO Auto-generated method stub
		List<Store> listStore = new ArrayList<Store>();
		String sql = "SELECT * from store";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Store store = new Store();
				store.setId(rs.getInt("id"));
				store.setAvatar(rs.getString("avatar"));
				store.setName(rs.getString("name"));
				store.setRating(rs.getInt("rating"));
				store.setOwnerID(rs.getInt("ownerId"));
				store.setCreateAt(rs.getTimestamp("createdAt"));
				listStore.add(store);
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return listStore;
	}

}
