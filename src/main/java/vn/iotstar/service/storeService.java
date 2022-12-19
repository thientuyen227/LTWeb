package vn.iotstar.service;

import vn.iotstar.model.Store;
import java.util.List;

public interface storeService {
    void insert(Store store);
    void edit(Store store);
    Store get(int id);
    List<Store> findByUserId(int userId);

    int totalStores();
    List<Store> getAll();
	List<Store> findAll();
	List<Store> findAllByName(String searchkeyword);
}
