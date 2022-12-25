package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.OrdersItemDao;
import vn.iotstar.dao.impl.OrdersItemDaoImpl;
import vn.iotstar.model.OrdersItem;
import vn.iotstar.service.ordersItemService;

public class OrdersItemServiceImpl extends DBConnection implements ordersItemService {

	OrdersItemDao ordersitemservice = new OrdersItemDaoImpl();
	
	public OrdersItemServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(OrdersItem orderItem) {
		// TODO Auto-generated method stub
		ordersitemservice.insert(orderItem);
	}

	@Override
	public List<OrdersItem> findByOrdersId(int ordersId) {
		// TODO Auto-generated method stub
		return findByOrdersId(ordersId);
	}

}
