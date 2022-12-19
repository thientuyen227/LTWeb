package vn.iotstar.service.impl;

import vn.iotstar.model.Delivery;
import vn.iotstar.service.deliveryService;
import vn.iotstar.dao.DeliveryDao;
import vn.iotstar.dao.impl.DeliveryDaoImpl;
import java.util.List;


public class deliveryServicelmpl implements deliveryService{
	DeliveryDao deliveryDAO = new DeliveryDaoImpl();

    @Override
    public List<Delivery> findAll() {
        return deliveryDAO.findAll();
    }

    @Override
    public Delivery findById(int id) {
        return deliveryDAO.findById(id);
    }

    @Override
    public void insert(Delivery delivery) {
        deliveryDAO.insert(delivery);
    }

    @Override
    public void edit(Delivery delivery) {
        deliveryDAO.edit(delivery);
    }

    @Override
    public void restore(int id) {
        deliveryDAO.restore(id);
    }

    @Override
    public void deleteSoft(int id) {
        deliveryDAO.deleteSoft(id);
    }

    @Override
    public void delete(int id) {
        deliveryDAO.delete(id);
    }


    @Override
    public void updateStatus(Delivery delivery) {
        deliveryDAO.updateStatus(delivery);
    }

}
