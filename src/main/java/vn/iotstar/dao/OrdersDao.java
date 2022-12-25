package vn.iotstar.dao;

import vn.iotstar.model.Orders;
import vn.iotstar.paging.pgEble;

import java.util.List;

public interface OrdersDao {
    List<Orders> findDelivered();
    List<Orders> findAll(String status);
    List<Orders> findAllByUserId(int userId);
    List<Orders> findAllByStoreId(String status, int storeId, pgEble pgeble);
    Orders findById(int id);
    void updateStatus(String status, int id);
    List<Orders> findDelivering();
    Orders findOneById(int id);
}