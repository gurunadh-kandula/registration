package com.jda.user.service;

import com.jda.user.model.ForgotPassword;
import com.jda.user.model.Login;
import com.jda.user.model.User;

public interface UserService {
	  void register(User user);
	  User validateUser(Login login);
	  void newPassword(ForgotPassword forgot);
}
