package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.dao.UserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.model.user;
import vn.iotstar.service.userService;

public class userServiceImpl implements userService {
	UserDao userDao = new UserDaoImpl();

	@Override
	public void insert(user user) {
		// TODO Auto-generated method stub
		userDao.insert(user);
	}

	@Override
	public void edit(user user) {
		// TODO Auto-generated method stub
		userDao.edit(user);
	}

	@Override
	public void delete(int userId) {
		// TODO Auto-generated method stub
		userDao.delete(userId);
	}

	@Override
	public user get(int userId) {
		// TODO Auto-generated method stub
		return userDao.get(userId);
	}

	@Override
	public List<user> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}

	@Override
	public List<user> search(String keyword) {
		// TODO Auto-generated method stub
		return userDao.search(keyword);
	}

	@Override
	public user signIn(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.signIn(username, password);
	}


}
