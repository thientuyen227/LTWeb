package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.ImageProduct;

public interface ImageProductDao {
    void insert (ImageProduct image);
    void delete(int productId);
    List<ImageProduct> findByProductId(int id);
}