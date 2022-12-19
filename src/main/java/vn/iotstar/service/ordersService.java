package vn.iotstar.service;

import vn.iotstar.model.Orders;
import java.util.List;

public interface ordersService {
	List<Orders> findDelivered();
    List<Orders> findAll(String status);
    List<Orders> findDelivering();
    Orders findOneById(int id);
}
