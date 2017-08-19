package com.stm.form.validator;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.stm.data.rep.UserRepository;
import com.stm.form.SignupForm;
import com.stm.data.entity.User;
@Component
public class SignupFormValidator extends LocalValidatorFactoryBean {
	
	private UserRepository userRepository;
	
	@Resource
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(SignupForm.class);
	}

	@Override
	public void validate(Object obj, Errors errors, final Object... validationHints) {
		
		super.validate(obj, errors, validationHints);
		
		if (!errors.hasErrors()) {
			SignupForm signupForm = (SignupForm) obj;
			User user = userRepository.findByEmail(signupForm.getEmail());
			if (user != null)
				errors.rejectValue("email", "emailNotUnique");			
		}
		
	}

}
