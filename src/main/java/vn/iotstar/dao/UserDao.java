package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.user;

public interface UserDao {
	void insert(user user);

	void edit(user user);
	
	void delete(int userId);

	user get(int userId);
	
	user signIn(String username, String password);
	List<user> getAll();

	List<user> search(String keyword);
}
