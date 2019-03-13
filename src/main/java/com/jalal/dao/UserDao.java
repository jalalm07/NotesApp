package com.jalal.dao;

import com.jalal.model.Login;
import com.jalal.model.User;

public interface UserDao {

	void register(User user);
	User validateUser(Login login);

}
