package com.mvc.form.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mvc.form.model.Entity.User;
import com.mvc.form.service.UserService;

@Component
public class UserFormValidator implements Validator {


	@Autowired
	UserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		User user = (User) target;

//if you entry empty data for user information you will show this messages
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.userForm.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "NotEmpty.userForm.surname");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "captcha", "NotEmpty.userForm.captcha");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numbers", "NotEmpty.userForm.numbers");

	}

}
