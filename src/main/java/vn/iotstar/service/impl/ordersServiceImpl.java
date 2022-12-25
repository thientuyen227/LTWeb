package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.OrdersDao;
import vn.iotstar.dao.impl.OrdersDaoImpl;
import vn.iotstar.model.Orders;
import vn.iotstar.paging.pgEble;
import vn.iotstar.service.ordersService;


public class ordersServiceImpl extends DBConnection implements ordersService{
	OrdersDao ordersDAO = new OrdersDaoImpl();

    @Override
    public List<Orders> findDelivered() {
        return ordersDAO.findDelivered();
    }


    @Override
    public List<Orders> findAll(String status) {
        return ordersDAO.findAll(status);
    }

    @Override
    public List<Orders> findDelivering() {
        return ordersDAO.findDelivering();
    }

    @Override
    public Orders findOneById(int id) {
        return ordersDAO.findOneById(id);
    }


	@Override
	public List<Orders> findAllByUserId(int userId) {
		// TODO Auto-generated method stub
		return ordersDAO.findAllByUserId(userId);
	}


	@Override
	public List<Orders> findAllByStoreId(String status, int storeId, pgEble pgeble) {
		// TODO Auto-generated method stub
		return ordersDAO.findAllByStoreId(status, storeId, pgeble);
	}


	@Override
	public Orders findById(int id) {
		// TODO Auto-generated method stub
		return ordersDAO.findById(id);
	}


	@Override
	public void updateStatus(String status, int id) {
		// TODO Auto-generated method stub
		ordersDAO.updateStatus(status, id);
	}
}
