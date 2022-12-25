package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.OrdersDao;
import vn.iotstar.model.Delivery;
import vn.iotstar.model.Orders;
import vn.iotstar.model.OrdersItem;
import vn.iotstar.model.Store;
import vn.iotstar.model.user;
import vn.iotstar.paging.pgEble;
import vn.iotstar.service.deliveryService;
import vn.iotstar.service.ordersItemService;
import vn.iotstar.service.storeService;
import vn.iotstar.service.userService;
import vn.iotstar.service.impl.OrdersItemServiceImpl;
import vn.iotstar.service.impl.deliveryServicelmpl;
import vn.iotstar.service.impl.storeServiceImpl;
import vn.iotstar.service.impl.userServiceImpl;

public class OrdersDaoImpl extends DBConnection implements OrdersDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;
    
    public List<Orders> findAll(String status) {
        StringBuilder sql = new StringBuilder("select * from orders ");
        if (!status.equals("all")) {
            sql.append("where status like \"");
            sql.append(""+ status + "\"");
        }
        List<Orders> orders = new ArrayList<>();
        userService userService = new userServiceImpl();
        storeService storeService = new storeServiceImpl();
        deliveryService deliveryService = new deliveryServicelmpl();
        try {
            conn = getConnection();
            ps = conn.prepareStatement(String.valueOf(sql));
            rs = ps.executeQuery();
            while (rs.next()){
                Orders order = new Orders();
                user user = userService.get(rs.getInt("userId"));
                Store store = storeService.get(rs.getInt("storeId"));
                Delivery delivery = deliveryService.findById(rs.getInt("deliveryId"));
                order.setId(rs.getInt("id"));
                order.setUserId(rs.getInt("userId"));
                order.setStoreId(rs.getInt("storeId"));
                order.setDeliveryId(rs.getInt("deliveryId"));
                order.setAddress(rs.getString("address"));
                order.setPhone(rs.getString("phone"));
                order.setStatus(rs.getString("status"));
                order.setAmountFromUser(rs.getDouble("amountFromUser"));
                order.setAmountToStore(rs.getDouble("amountToStore"));
                order.setAmountToGD(rs.getDouble("amountToGD"));
                order.setCreateAt(rs.getTimestamp("createAt"));
                order.setUpdateAt(rs.getTimestamp("updateAt"));
                order.setUser(user);
                order.setStore(store);
                order.setDelivery(delivery);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
    @Override
    public Orders findById(int id) {
        StringBuilder sql = new StringBuilder("select * from orders where id = ?");
        userService userService = new userServiceImpl();
        storeService storeService = new storeServiceImpl();
        deliveryService deliveryService = new deliveryServicelmpl();
        try {
            conn = getConnection();
            ps = conn.prepareStatement(String.valueOf(sql));
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Orders order = new Orders();
            while (rs.next()){
                user user = userService.get(rs.getInt("userId"));
                Store store = storeService.get(rs.getInt("storeId"));
                Delivery delivery = deliveryService.findById(rs.getInt("deliveryId"));
                order.setId(rs.getInt("id"));
                order.setAddress(rs.getString("address"));
                order.setPhone(rs.getString("phone"));
                order.setStatus(rs.getString("status"));
                order.setAmountFromUser(rs.getDouble("amountFromUser"));
                order.setAmountToStore(rs.getDouble("amountToStore"));
                order.setAmountToGD(rs.getDouble("amountToGD"));
                order.setCreateAt(rs.getTimestamp("createdAt"));
                order.setUpdateAt(rs.getTimestamp("updatedAt"));
                order.setUser(user);
                order.setStore(store);
                order.setDelivery(delivery);
            }
            return order;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateStatus(String status, int id) {
        String sql = "update orders set status = ? where id = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Orders> findDelivering() {
        String sql = "SELECT * FROM orders WHERE status = 'shipped'";
        List<Orders> orders = new ArrayList<Orders>();
        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                Orders order = new Orders();
                order.setId(rs.getInt("id"));
                order.setUserId(rs.getInt("userId"));
                order.setStoreId(rs.getInt("storeId"));
                order.setDeliveryId(rs.getInt("deliveryId"));
                order.setAddress(rs.getString("address"));
                order.setPhone(rs.getString("phone"));
                order.setAmountFromUser(rs.getDouble("amountFromUser"));
                order.setAmountToStore(rs.getDouble("amountToStore"));
                order.setAmountToGD(rs.getDouble("amountToGD"));
                orders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public Orders findOneById(int id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()) {
                Orders order = new Orders();
                order.setId(rs.getInt("id"));
                order.setUserId(rs.getInt("userId"));
                order.setStoreId(rs.getInt("storeId"));
                order.setDeliveryId(rs.getInt("deliveryId"));
                order.setAddress(rs.getString("address"));
                order.setStatus(rs.getString("status"));
                order.setPhone(rs.getString("phone"));
                order.setAmountFromUser(rs.getDouble("amountFromUser"));
                order.setAmountToStore(rs.getDouble("amountToStore"));
                order.setAmountToGD(rs.getDouble("amountToGD"));
                return  order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	@Override
	public List<Orders> findDelivered() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM orders WHERE status = 'delivered'";
        List<Orders> orders = new ArrayList<Orders>();
        try {
            conn = getConnection();
            ps = conn.prepareStatement(String.valueOf(sql));
            rs = ps.executeQuery();
            while(rs.next()) {
                Orders order = new Orders();
                order.setId(rs.getInt("id"));
                order.setUserId(rs.getInt("userId"));
                order.setStoreId(rs.getInt("storeId"));
                order.setDeliveryId(rs.getInt("deliveryId"));
                order.setAddress(rs.getString("address"));
                order.setPhone(rs.getString("phone"));
                order.setAmountFromUser(rs.getDouble("amountFromUser"));
                order.setAmountToStore(rs.getDouble("amountToStore"));
                order.setAmountToGD(rs.getDouble("amountToGD"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
	}
	@Override
	public List<Orders> findAllByUserId(int userId) {
		// TODO Auto-generated method stub
		String sql = "select * from orders where userId = ?";
        List<Orders> orders = new ArrayList<>();
        userService userService = new userServiceImpl();
        storeService storeService = new storeServiceImpl();
        deliveryService deliveryService = new deliveryServicelmpl();
        ordersItemService ordersItemService = new OrdersItemServiceImpl();
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()){
                Orders order = new Orders();
                user user = userService.get(rs.getInt("userId"));
                Store store = storeService.get(rs.getInt("storeId"));
                Delivery delivery = deliveryService.findById(rs.getInt("deliveryId"));
                List<OrdersItem> ordersItem = ordersItemService.findByOrdersId(rs.getInt("id"));
                order.setId(rs.getInt("id"));
                order.setUserId(rs.getInt("userId"));
                order.setStoreId(rs.getInt("storeId"));
                order.setDeliveryId(rs.getInt("deliveryId"));
                order.setAddress(rs.getString("address"));
                order.setPhone(rs.getString("phone"));
                order.setStatus(rs.getString("status"));
                order.setAmountFromUser(rs.getDouble("amountFromUser"));
                order.setAmountToStore(rs.getDouble("amountToStore"));
                order.setAmountToGD(rs.getDouble("amountToGD"));
                order.setUser(user);
                order.setStore(store);
                order.setDelivery(delivery);
                order.setOrdersItem(ordersItem);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
	}
	@Override
	public List<Orders> findAllByStoreId(String status, int storeId, pgEble pgeble) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("select * from orders");
        if (!status.equals("all")) {
            sql.append(" where status like \"");
            sql.append(""+ status + "\"" + " and storeId = "+ storeId);
        }
        if (pgeble.getSort() != null) {
            sql.append(" order by "+pgeble.getSort().getSortName()+" "+pgeble.getSort().getSortBy()+"");
        }
        if (pgeble.getOffset() != null && pgeble.getLimit() != null) {
            sql.append(" limit "+pgeble.getOffset()+", "+pgeble.getLimit()+"");
        }
        List<Orders> orders = new ArrayList<>();
        userService userservice = new userServiceImpl();
        storeService storeservice = new storeServiceImpl();
        deliveryService deliveryService = new deliveryServicelmpl();
        try {
            conn = getConnection();
            ps = conn.prepareStatement(String.valueOf(sql));
            rs = ps.executeQuery();
            while (rs.next()){
                Orders order = new Orders();
                user user = userservice.get(rs.getInt("userId"));
                Store store = storeservice.get(rs.getInt("storeId"));
                Delivery delivery = deliveryService.findById(rs.getInt("deliveryId"));
                order.setId(rs.getInt("id"));
                order.setUserId(rs.getInt("userId"));
                order.setStoreId(rs.getInt("storeId"));
                order.setDeliveryId(rs.getInt("deliveryId"));
                order.setAddress(rs.getString("address"));
                order.setPhone(rs.getString("phone"));
                order.setStatus(rs.getString("status"));
                order.setAmountFromUser(rs.getDouble("amountFromUser"));
                order.setAmountToStore(rs.getDouble("amountToStore"));
                order.setAmountToGD(rs.getDouble("amountToGD"));
                order.setUser(user);
                order.setStore(store);
                order.setDelivery(delivery);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
	}
	
}
