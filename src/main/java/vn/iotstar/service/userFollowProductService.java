package vn.iotstar.service;

import java.util.List;

import vn.iotstar.model.UserFollowProduct;

public interface userFollowProductService {

	void insert(UserFollowProduct userFollowProduct);
	void delete(int id);
	List<UserFollowProduct> findByUserId(int id);

}
