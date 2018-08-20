package com.jda.user.controller;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.jda.user.model.ForgotPassword;
import com.jda.user.model.User;
import com.jda.user.service.MailService;
import com.jda.user.service.UserService;

@Controller
public class ForgotPasswordController {
	@Autowired
	public UserService userService;
	@Autowired
	private MailService mailService;
	private static final Logger logger = Logger.getLogger(RegistrationController.class);

	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public ModelAndView showForgot(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView  mav = new ModelAndView("forgotpassword");
	
		return mav;
	}

	@RequestMapping(value = "/forgotProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	      @RequestParam("email") String email) throws IOException {
		logger.info(email);
		
		ModelAndView   mav = new ModelAndView("forgotpassword");
		User user=userService.forgetPassword(email);
		 if (null == user) {
		
			    mav.addObject("message", "User with this email is not exist");
		 
		return mav;
	}
		 String appUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getServletContext().getContextPath();
		 
		 mailService.sendMail(user.getEmail(), "reset password", "To reset your password, click the link below:\n" + appUrl + "/reset?resetToken="
					+ user.getToken());
		 mav.addObject("message","successful");
		 
				 return mav;
}
}