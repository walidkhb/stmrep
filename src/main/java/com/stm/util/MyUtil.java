package com.stm.util;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.MessageSource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.stm.data.entity.User;
import com.stm.service.UserDetailsImpl;

@Component
public class MyUtil {
	
	private static MessageSource messageSource;
	
	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		
		MyUtil.messageSource = messageSource;
		
	}

	public static String getMessage(String messageKey, Object... args) {
		return messageSource.getMessage(messageKey, args, Locale.getDefault());
	}

	public static void flash(RedirectAttributes redirectAttributes,
			String kind, String messageKey) {
		
		redirectAttributes.addFlashAttribute("flashKind", kind);
		redirectAttributes.addFlashAttribute("flashMessage",
				MyUtil.getMessage(messageKey));
		
	}
	
    public static void logInUser(User user) {
    	
        UserDetailsImpl userDetails = new UserDetailsImpl(user);
 
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }


}
