package web4.dao;

import web4.model.User;

public interface UserDao {
	User findByName(String  name);
	void saveUser(User user);
	void deleteUser(User user);
	void updateUser(User user);
}
