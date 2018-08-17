package com.jda.user.validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
//@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required.username","username is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password","password is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "required.firstname","firstname is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "required.lastname","lastname is required");
		ValidationUtils.rejectIfEmpty(errors, "email","required.email", "email is required");
		ValidationUtils.rejectIfEmpty(errors, "address", "required.address","address is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone","required.phone", "phone is required");

	}

}
