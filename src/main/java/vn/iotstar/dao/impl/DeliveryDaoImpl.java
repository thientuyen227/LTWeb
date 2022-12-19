package vn.iotstar.dao.impl;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.DeliveryDao;
import vn.iotstar.model.Delivery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDaoImpl extends DBConnection implements DeliveryDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public Delivery findById(int id) {
        String sql = "select * from delivery where id = ?";
        Delivery delivery = new Delivery();
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                delivery.setId(rs.getInt("id"));
                delivery.setName(rs.getString("name"));
                delivery.setDescription(rs.getString("description"));
                delivery.setPrice(rs.getDouble("price"));
                delivery.setDeleted(rs.getBoolean("isDeleted"));
                delivery.setCreateAt(rs.getTimestamp("createdAt"));
                delivery.setUpdateAt(rs.getTimestamp("updatedAt"));
            }
            return delivery;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Delivery> findAll() {
        String sql = "SELECT * FROM delivery";
        List<Delivery> deliveries = new ArrayList<Delivery>();
        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                Delivery delivery = new Delivery();
                delivery.setId(rs.getInt("id"));
                delivery.setName(rs.getString("name"));
                delivery.setDescription(rs.getString("description"));
                delivery.setPrice(rs.getDouble("price"));
                delivery.setDeleted(rs.getBoolean("isDeleted"));
                deliveries.add(delivery);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deliveries;
    }

    @Override
    public void insert(Delivery delivery) {
        String sql = "INSERT INTO delivery(name, description, price) VALUES (?,?,?)";
        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, delivery.getName());
            ps.setString(2, delivery.getDescription());
            ps.setDouble(3, delivery.getPrice());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Delivery delivery) {
        String sql = "UPDATE delivery SET name = ?, description = ?, price = ? WHERE id = ?";
        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, delivery.getName());
            ps.setString(2, delivery.getDescription());
            ps.setDouble(3, delivery.getPrice());
            ps.setInt(4, delivery.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSoft(int id) {
        String sql = "UPDATE delivery SET isDeleted = true WHERE id = ?";
        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM delivery WHERE id = ?";
        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void restore(int id) {
        String sql = "UPDATE delivery SET isDeleted = false WHERE id = ?";
        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Override
	public void updateStatus(Delivery delivery) {
		// TODO Auto-generated method stub
		
	}

}