package vn.iotstar.service;

import java.util.List;

import vn.iotstar.model.OrdersItem;

public interface ordersItemService {
	void insert(OrdersItem orderItem);
	List<OrdersItem> findByOrdersId(int ordersId);
}
