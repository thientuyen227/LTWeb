package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.OrdersItem;

public interface OrdersItemDao {
	void insert(OrdersItem orderItem);
	List<OrdersItem> findByOrdersId(int ordersId);
}
