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
import com.jda.user.model.ForgotPassword;
import com.jda.user.service.UserService;

@Controller
public class ForgotPasswordController {
	@Autowired
	public UserService userService;
	private static final Logger logger = Logger.getLogger(RegistrationController.class);

	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public ModelAndView showForgot(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView("forgotpassword");
		mav.addObject("forgot", new ForgotPassword());
		return mav;
	}

	@RequestMapping(value = "/forgotProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	      @ModelAttribute("forgot") ForgotPassword forgot) throws IOException {
		logger.info(forgot);
		ModelAndView mav = null;
		userService.newPassword(forgot);
		return new ModelAndView("redirect:/login");
	}
}
