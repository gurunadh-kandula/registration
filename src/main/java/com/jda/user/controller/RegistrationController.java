package com.jda.user.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jda.user.model.User;
import com.jda.user.service.UserService;
import com.jda.user.validator.UserValidator;
@Controller
public class RegistrationController {
  @Autowired
  public UserService userService;
  @Autowired
  private UserValidator userValidator;
	private static final Logger logger = Logger.getLogger(RegistrationController.class);

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {

    ModelAndView mav = new ModelAndView("register");
    mav.addObject("user", new User());
    return mav;
  }
  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
  public ModelAndView  addUser(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("user") User user, BindingResult result) throws IOException {
		logger.info(user);
	  userValidator.validate(user, result);
	  if(result.hasErrors()){
		  return new ModelAndView("register");
	  }
  userService.register(user);
  //response.sendRedirect("login");
  return new ModelAndView("redirect:/login");
  }
  
}