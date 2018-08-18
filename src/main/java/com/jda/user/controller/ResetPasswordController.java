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
import org.springframework.web.servlet.ModelAndView;
import com.jda.user.model.ResetPassword;
import com.jda.user.model.User;
import com.jda.user.service.UserService;

@Controller
public class ResetPasswordController {
	@Autowired
	public UserService userService;
	private static final Logger logger = Logger.getLogger(RegistrationController.class);

	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public ModelAndView showForgot(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView("resetpassword");
		mav.addObject("reset", new ResetPassword());
		return mav;
	}

	@RequestMapping(value = "/resetProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	      @ModelAttribute("reset") ResetPassword reset) throws IOException {
		logger.info(reset);
		ModelAndView mav = null;
		User user = userService.validateUser(reset);
	    if (null != user) {
		userService.newPassword(reset);
		mav=new ModelAndView("redirect:/Welcome");
		mav.addObject("message","password is changed");
	}
	    else
	    { mav = new ModelAndView("redirect:/login");
	    mav.addObject("message", "Oldpassword is wrong!!");
	}
	    return mav;
}
}
