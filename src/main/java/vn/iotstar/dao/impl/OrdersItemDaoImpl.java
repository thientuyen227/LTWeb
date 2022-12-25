package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.OrdersItemDao;
import vn.iotstar.model.OrdersItem;
import vn.iotstar.service.productService;
import vn.iotstar.service.impl.productServiceImpl;

public class OrdersItemDaoImpl extends DBConnection implements OrdersItemDao {

	public OrdersItemDaoImpl() {
		// TODO Auto-generated constructor stub
	}	

	@Override
	public void insert(OrdersItem orderItem) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO OrdersItem (ordersId, productId, count) " + "VALUE (?,?,?)";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orderItem.getOrdersId());
			ps.setInt(2, orderItem.getProductId());
			ps.setInt(3, orderItem.getCount());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrdersItem> findByOrdersId(int ordersId) {
		// TODO Auto-generated method stub
		String sql = "select * from ordersItem where ordersId = ?";
		List<OrdersItem> ordersItems = new ArrayList<>();
		productService productservice = new productServiceImpl();
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ordersId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrdersItem ordersItem = new OrdersItem();
				ordersItem.setId(rs.getInt("id"));
				ordersItem.setOrdersId(rs.getInt("ordersId"));
				ordersItem.setProductId(rs.getInt("productId"));
				ordersItem.setCount(rs.getInt("count"));
				ordersItem.setProduct(productservice.get(rs.getInt("productId")));
				ordersItems.add(ordersItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ordersItems;
	}

}
