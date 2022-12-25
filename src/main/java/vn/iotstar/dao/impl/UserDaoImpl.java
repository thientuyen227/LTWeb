package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.UserDao;
import vn.iotstar.model.user;
import vn.iotstar.service.storeService;
import vn.iotstar.service.impl.storeServiceImpl;

public class UserDaoImpl extends DBConnection implements UserDao {
	@Override
	public void insert(user user) {
		// TODO Auto-generated method stub
				String sql = "INSERT INTO user(firstname, lastname, id_card, email, phone, password)"
						+ "VALUES (?,?,?,?,?,?)";
				try {
					Connection conn = super.getConnection();
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, user.getFirstname());
					ps.setString(2, user.getLastname());
					ps.setString(3, user.getId_card());
					ps.setString(4, user.getEmail());
					ps.setString(5, user.getPhone());
					ps.setString(6, user.getPassword());
					ps.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	@Override
	public void edit(user user) {
		// TODO Auto-generated method stub
		String sql = "UPDATE user SET firstname = ?, lastname=?, id_card=?, email=?, phone=?"
				+ " WHERE id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getId_card());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhone());
			ps.setInt(6, user.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int userId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM user WHERE id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,userId);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public user get(int userId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM user WHERE id = ? ";
		storeService storeservice= new storeServiceImpl();
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user user = new user();
				user.setId(rs.getInt("id"));;
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setId_card(rs.getString("id_card"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setRole(rs.getString("role"));
				user.setAvatar(rs.getString("avatar"));
				user.setStore(storeservice.getByUserId(userId));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<user> getAll() {
		// TODO Auto-generated method stub
		List<user> listUser= new ArrayList<user>();
		String sql = "SELECT * FROM user";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user user = new user();
				user.setId(rs.getInt("id"));;
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setId_card(rs.getString("id_card"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setRole(rs.getString("role"));
				user.setAvatar(rs.getString("avatar"));
				user.seteWallet(rs.getDouble("eWallet"));
				
				listUser.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUser;
	}

	@Override
	public List<user> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public user signIn(String username, String password) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM user where email=? and password=?";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user user = new user();
				user.setId(rs.getInt("id"));;
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setId_card(rs.getString("id_card"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setRole(rs.getString("role"));
				user.setAvatar(rs.getString("avatar"));
				user.seteWallet(rs.getDouble("eWallet"));
				return user;
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
