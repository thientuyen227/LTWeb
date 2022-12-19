package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.Store;

public interface StoreDao {
    void insert(Store store);
    void edit(Store store);
    Store get(int id);
    List<Store> findByUserId(int userId);
    int totalStores();
    List<Store> getAll();
    List<Store> findAll();
    List<Store> findAllByName(String keyword);
}