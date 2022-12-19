package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.UserFollowProductDao;
import vn.iotstar.dao.impl.UserFollowProductDaoImpl;
import vn.iotstar.model.UserFollowProduct;
import vn.iotstar.service.userFollowProductService;

public class userFollowProductServiceImpl extends DBConnection implements userFollowProductService {

	UserFollowProductDao userFollowProductDao = new UserFollowProductDaoImpl();
	
	public userFollowProductServiceImpl() {
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void insert(UserFollowProduct userFollowProduct) {
		// TODO Auto-generated method stub
		userFollowProductDao.insert(userFollowProduct);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		userFollowProductDao.delete(id);
	}

	@Override
	public List<UserFollowProduct> findByUserId(int id) {
		// TODO Auto-generated method stub
		return userFollowProductDao.findByUserId(id);
	}

}
