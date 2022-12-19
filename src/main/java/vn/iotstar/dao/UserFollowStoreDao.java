package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.UserFollowStore;

public interface UserFollowStoreDao {
	void insert(UserFollowStore userFollowStore);
	void delete(int id);
	List<UserFollowStore> findByUserId(int id);
}
