package vn.iotstar.service.impl;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.OrderDao;
import vn.iotstar.dao.impl.OrderDaoImpl;
import vn.iotstar.model.Orders;
import vn.iotstar.service.ordersService;

import java.util.List;


public class ordersServiceImpl extends DBConnection implements ordersService{
	OrderDao ordersDAO = new OrderDaoImpl();

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
}
