package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.Delivery;

public interface DeliveryDao {
    List<Delivery> findAll();
    void insert(Delivery delivery);
    void edit(Delivery delivery);
    void deleteSoft(int id);
    void delete(int id);
    void restore(int id);
    void updateStatus(Delivery delivery);
    Delivery findById(int id);
}