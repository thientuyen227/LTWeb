package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.UserFollowStoreDao;
import vn.iotstar.dao.impl.UserFollowStoreDaoImpl;
import vn.iotstar.model.UserFollowStore;
import vn.iotstar.service.userFollowStoreService;

public class userFollowStoreServiceImpl extends DBConnection implements userFollowStoreService {

	public userFollowStoreServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	UserFollowStoreDao userFollowStoreDao = new UserFollowStoreDaoImpl();
	@Override
	public void insert(UserFollowStore userFollowStore) {
		// TODO Auto-generated method stub
		userFollowStoreDao.insert(userFollowStore);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		userFollowStoreDao.delete(id);
	}

	@Override
	public List<UserFollowStore> findByUserId(int id) {
		// TODO Auto-generated method stub
		return userFollowStoreDao.findByUserId(id);
	}

}
