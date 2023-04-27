package com.web.dssapp.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.dssapp.config.CustomUserDetails;
import com.web.dssapp.model.User;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute
    public void addLoggedInUser(Model model, RedirectAttributes atr) {
    	//UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication(); 
    	if( !(SecurityContextHolder.getContext().getAuthentication().getPrincipal()=="anonymousUser")) {
    		User authentication = ((CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getContext();
    		if (authentication != null) { model.addAttribute("currentuser",  authentication); }
    	}
		
    }
}
