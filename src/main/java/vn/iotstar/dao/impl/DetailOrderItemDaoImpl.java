package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.DetailOrderItemDao;
import vn.iotstar.model.DetailOrdersItem;

public class DetailOrderItemDaoImpl extends DBConnection implements DetailOrderItemDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;
	@Override
	public DetailOrdersItem findOneByOrderId(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT productId, name, count, price, status FROM product INNER JOIN ordersItem  " +
                "ON productId = product._id INNER JOIN orders ON" +
                "orderId = orders._id WHERE orderId = ?";
        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while(rs.next()) {
                DetailOrdersItem detailOrdersItem = new DetailOrdersItem();
//                detailOrdersItem.setProductId(rs.getLong("productId"));
                detailOrdersItem.setName(rs.getString("name"));
                detailOrdersItem.setCount(rs.getInt("count"));
//                detailOrdersItem.setPrice(rs.getBigDecimal("price"));
//                detailOrdersItem.setStatus(rs.getString("status"));
                return detailOrdersItem;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
}
