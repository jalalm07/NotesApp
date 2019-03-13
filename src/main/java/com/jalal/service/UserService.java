package com.jalal.service;

import com.jalal.model.Login;
import com.jalal.model.User;

public interface UserService {
	void register(User user);
	User validateUser(Login login);
}
