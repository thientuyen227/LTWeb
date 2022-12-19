package vn.iotstar.service.impl;

import java.util.List;


import vn.iotstar.dao.ImageProductDao;
import vn.iotstar.dao.impl.ImageProductDaoImpl;
import vn.iotstar.model.ImageProduct;
import vn.iotstar.service.imageProductService;


public class imageProductServiceImpl implements imageProductService{	
	ImageProductDao imageProductDAO = new ImageProductDaoImpl();
    @Override
    public void insert(ImageProduct image) {
        imageProductDAO.insert(image);
    }
    @Override
    public void delete(int productId) {
        imageProductDAO.delete(productId);
    }
    @Override
    public List<ImageProduct> findByProductId(int id) {
        return imageProductDAO.findByProductId(id);
    }
}
