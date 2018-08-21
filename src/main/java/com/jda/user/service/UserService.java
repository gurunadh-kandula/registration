package com.jda.user.service;

import com.jda.user.model.ForgotPassword;
import com.jda.user.model.Login;
import com.jda.user.model.ResetPassword;
import com.jda.user.model.User;

public interface UserService {
	  void register(User user);
	  User validateUser(Login login);
	  void newPassword(String password,String token);
	  String generator(String password);
	/*void newPassword(ResetPassword reset);*/
	/*User validateUser(ResetPassword reset);*/
	User  forgetPassword(String username);
	 User getUserbyToken(String token);
}
