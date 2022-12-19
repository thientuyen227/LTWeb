package vn.iotstar.service;

import java.util.List;

import vn.iotstar.model.UserFollowStore;

public interface userFollowStoreService {

	void insert(UserFollowStore userFollowStore);
	void delete(int id);
	List<UserFollowStore> findByUserId(int id);

}
