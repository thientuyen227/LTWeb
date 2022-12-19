package vn.iotstar.service;


import vn.iotstar.model.ImageProduct;
import java.util.List;

public interface imageProductService {
	void insert (ImageProduct image);
    void delete(int productId);
    List<ImageProduct> findByProductId(int id);
}
