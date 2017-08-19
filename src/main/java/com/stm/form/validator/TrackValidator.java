package com.stm.form.validator;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.stm.data.rep.TrackRepository;

import com.stm.form.SignupForm;
import com.stm.form.TrackForm;
import com.stm.data.entity.Track;

@Component
public class TrackValidator extends LocalValidatorFactoryBean {
	
	private TrackRepository trackRepository;
	
	@Resource
	public void setTrackRepository(TrackRepository trackRepository) {
		this.trackRepository = trackRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(SignupForm.class);
	}

	@Override
	public void validate(Object obj, Errors errors, final Object... validationHints) {
		
		super.validate(obj, errors, validationHints);
		
		if (!errors.hasErrors()) {
			TrackForm trackForm = (TrackForm) obj;
			Track   track= trackRepository.findOne(trackForm.getId());
			if (track != null)
				errors.rejectValue("email", "emailNotUnique");			
		}
		
	}

}
