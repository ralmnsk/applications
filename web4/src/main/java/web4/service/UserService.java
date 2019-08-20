package web4.service;

import web4.model.User;

public interface UserService {
	User findByName(String  name);
	void saveUser(User user);
	void deleteUser(User user);
	void updateUser(User user);
}
