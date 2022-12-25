package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.Store;

public interface StoreDao {
    void insert(Store store);
    void edit(Store store);
    void isOpen(int isOpen, int id);
    Store get(int id);
    Store getByUserId(int userId);
    List<Store> findByUserId(int userId);
    int totalStores();
    List<Store> getAll();
    List<Store> getAllByAdmin();
    List<Store> findAll();
    List<Store> findAllByName(String keyword);
}