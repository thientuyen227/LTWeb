package vn.iotstar.dao;

import vn.iotstar.model.ImageStore;

import java.util.List;

public interface ImageStoreDao {
    void insert (ImageStore image);
    void delete(int storeId);
    List<ImageStore> findByStoreId(int id);

}