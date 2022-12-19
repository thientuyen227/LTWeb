package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.UserFollowProduct;

public interface UserFollowProductDao {
	void insert(UserFollowProduct userFollowProduct);
	void delete(int id);
	List<UserFollowProduct> findByUserId(int id);
}
