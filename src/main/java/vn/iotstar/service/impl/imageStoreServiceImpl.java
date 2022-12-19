package vn.iotstar.service.impl;


import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.ImageStoreDao;
import vn.iotstar.dao.impl.ImageStoreDaoImpl;
import vn.iotstar.model.ImageStore;
import vn.iotstar.service.imageStoreService;

import java.util.List;


public class imageStoreServiceImpl extends DBConnection implements imageStoreService{
	ImageStoreDao imageStoreDAO = new ImageStoreDaoImpl();
    @Override
    public void insert(ImageStore image) {
        imageStoreDAO.insert(image);
    }

    @Override
    public List<ImageStore> findByStoreId(int id) {
        return imageStoreDAO.findByStoreId(id);
    }

    @Override
    public void delete(int storeId) {
        imageStoreDAO.delete(storeId);
    }
}
