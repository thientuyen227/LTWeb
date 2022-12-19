package vn.iotstar.service;

import vn.iotstar.model.Delivery;
import java.util.List;

public interface deliveryService {
	List<Delivery> findAll();
    void insert(Delivery delivery);
    void edit(Delivery delivery);
    void deleteSoft(int id);
    void delete(int id);

    void restore(int id);
    void updateStatus(Delivery delivery);
    Delivery findById(int id);
}
