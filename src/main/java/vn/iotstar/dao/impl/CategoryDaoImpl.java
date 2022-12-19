package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.CategoryDao;
import vn.iotstar.model.category;

public class CategoryDaoImpl extends DBConnection implements CategoryDao {

	@Override
	public void insert(category category) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO category(name) VALUES (?)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryName());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(category category) {
		// TODO Auto-generated method stub
		String sql = "UPDATE category SET name = ? WHERE id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryName());
			ps.setInt(2, category.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM category WHERE id = ?";
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
	public category get(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM category WHERE id = ? ";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				category category = new category();
				category.setId(id);;
				category.setCategoryName(rs.getString("name"));
				return category;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<category> getAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM category";
		List<category> categories = new ArrayList<category>();
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				category category = new category();
				category.setId(rs.getInt("id"));
				category.setCategoryName(rs.getString("name"));
				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public List<category> search(String keyword) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<category> findAll() {
		// TODO Auto-generated method stub
		 String sql = "select * from category";
	        List<category> categories = new ArrayList<>();
	        try {
	            Connection conn = getConnection();
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()) {
	                category category = new category();
	                category.setId(rs.getInt("id"));
	                category.setCategoryName("name");
	                category.setDelete(rs.getBoolean("isDeleted"));
	                category.setCreateAt(rs.getTimestamp("createAt"));
	                category.setUpdateAt(rs.getTimestamp("updateAt"));
	                categories.add(category);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return categories;
	}

}
