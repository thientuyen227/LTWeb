package vn.iotstar.service;

import vn.iotstar.model.ImageStore;
import java.util.List;

public interface imageStoreService {
	void insert (ImageStore image);
    List<ImageStore> findByStoreId(int id);
    void delete (int storeId);
}
