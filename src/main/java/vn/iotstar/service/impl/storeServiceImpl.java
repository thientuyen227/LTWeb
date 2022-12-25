package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.StoreDao;
import vn.iotstar.dao.impl.StoreDaoImpl;
import vn.iotstar.model.Store;
import vn.iotstar.service.storeService;


public class storeServiceImpl extends DBConnection implements storeService {
	
	StoreDao storeDao= new StoreDaoImpl();
	@Override
	public void insert(Store store) {
		// TODO Auto-generated method stub
		storeDao.insert(store);
	}

	@Override
	public void edit(Store store) {
		// TODO Auto-generated method stub
		storeDao.edit(store);
	}

	@Override
	public Store get(int id) {
		// TODO Auto-generated method stub
		return storeDao.get(id);
	}

	@Override
	public List<Store> findByUserId(int userId) {
		// TODO Auto-generated method stub
		return storeDao.findByUserId(userId);
	}

	@Override
	public int totalStores() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<Store> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Store> findAllByName(String searchkeyword) {
		// TODO Auto-generated method stub
		return storeDao.findAllByName(searchkeyword);
	}

	@Override
	public List<Store> getAll() {
		// TODO Auto-generated method stub
		return storeDao.getAll();
	}

	@Override
	public List<Store> getAllByAdmin() {
		// TODO Auto-generated method stub
		return storeDao.getAllByAdmin();
	}

	@Override
	public void isOpen(int isOpen, int id) {
		// TODO Auto-generated method stub
		storeDao.isOpen(isOpen, id);
	}

	@Override
	public Store getByUserId(int userId) {
		// TODO Auto-generated method stub
		return storeDao.getByUserId(userId);
	}

}
