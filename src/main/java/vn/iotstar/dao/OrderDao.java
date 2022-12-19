package vn.iotstar.dao;

import vn.iotstar.model.Orders;

import java.util.List;

public interface OrderDao {
    List<Orders> findDelivered();
    List<Orders> findAll(String status);
    Orders findById(int id);
    void updateStatus(String status, int id);
    List<Orders> findDelivering();
    Orders findOneById(int id);
}